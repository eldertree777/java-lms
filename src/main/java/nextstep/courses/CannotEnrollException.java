package nextstep.courses;

public class CannotEnrollException extends Exception {
    private static final long serialVersionUID = 1L;

    public CannotEnrollException(String message) {
        super(message);
    }
}
