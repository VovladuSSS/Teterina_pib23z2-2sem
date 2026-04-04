package academy.tochkavhoda.exceptions;

public class TrainingException extends RuntimeException {
    private final TrainingErrorCode errorCode;

    public TrainingException(TrainingErrorCode errorCode) {
        super(errorCode.toString());
        this.errorCode = errorCode;
    }

    public TrainingException(TrainingErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public TrainingErrorCode getErrorCode() {
        return errorCode;
    }
}