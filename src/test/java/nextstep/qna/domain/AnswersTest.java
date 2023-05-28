package nextstep.qna.domain;

import nextstep.users.domain.NsUserTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class AnswersTest {

    private Question Q1;
    private Answer A1;
    private Answer A2;
    private Answers answers;

    @BeforeEach
    void setUp() {
        this.answers= new Answers();

        this.Q1 = new Question(NsUserTest.JAVAJIGI, "title1", "contents1");
        this.A1 = new Answer(NsUserTest.JAVAJIGI, Q1, "Answers Contents1");
        this.A2 = new Answer(NsUserTest.SANJIGI, Q1, "Answers Contents2");
    }

    @Test
    @DisplayName("Answers 일급 컬렉션에 답변 객체를 추가할 수 있다.")
    void enroll_AddAnswer_ContainExactlyToList() {
        answers.add(A1);
        answers.add(A2);

        List<Answer> answerList = answers.getAnswers();

        assertThat(answerList).containsExactly(A1, A2).hasSize(2);
    }

    @Test
    @DisplayName("Answers 일급 컬렉션에 null이 추가되면 예외를 던진다.")
    void enroll_AddNull_ThrowException() {
        assertThatThrownBy(() -> answers.add(null))
                .isInstanceOf(NullPointerException.class);
    }
}