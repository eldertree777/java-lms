package nextstep.courses.infrastructure;

import nextstep.courses.domain.SessionRepository;
import nextstep.courses.domain.Student;
import nextstep.courses.domain.StudentRepository;
import nextstep.users.domain.UserRepository;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository("studentRepository")
public class JdbcStudentRepository implements StudentRepository {

    private final JdbcOperations jdbcTemplate;
    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;

    public JdbcStudentRepository(JdbcOperations jdbcTemplate, UserRepository userRepository, SessionRepository sessionRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
    }

    @Override
    public int save(Student student) {
        String sql = "insert into student (ns_user_id, session_id, created_at) values (?, ?, ?)";
        return jdbcTemplate.update(sql, student.getNsUserId(), student.getSessionId(), student.getCreatedAt());
    }

    @Override
    public Optional<Student> findById(Long id) {
        String sql = "select id, ns_user_id, session_id, created_at, updated_at from student where id = ?";
        RowMapper<Student> rowMapper = (rs, rowNum) -> new Student(
                rs.getLong(1),
                userRepository.findByUserId(rs.getString(2)).orElseThrow(IllegalStateException::new),
                sessionRepository.findById(rs.getLong(3)).orElseThrow(IllegalStateException::new),
                toLocalDateTime(rs.getTimestamp(4)),
                toLocalDateTime(rs.getTimestamp(5))

        );
        Student savedStudent = jdbcTemplate.queryForObject(sql, rowMapper, id);
        return Optional.ofNullable(savedStudent);
    }

    private LocalDateTime toLocalDateTime(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        }
        return timestamp.toLocalDateTime();
    }

}
