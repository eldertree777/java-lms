package nextstep.courses;

public class ExceedMaxStudentException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ExceedMaxStudentException(String message) {
        super(message);
    }
}
