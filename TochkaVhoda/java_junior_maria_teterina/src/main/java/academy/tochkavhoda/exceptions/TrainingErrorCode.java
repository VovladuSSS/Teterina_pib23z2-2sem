package academy.tochkavhoda.exceptions;

public enum TrainingErrorCode {
    // Общие ошибки
    NULL_PARAMETER,
    EMPTY_STRING,

    // Ошибки Group
    GROUP_WRONG_NAME,
    GROUP_WRONG_ROOM,
    TRAINEE_NOT_FOUND,

    // Ошибки School
    SCHOOL_WRONG_NAME,
    DUPLICATE_GROUP_NAME,
    GROUP_NOT_FOUND,

    // Ошибки TraineeMap
    DUPLICATE_TRAINEE,

    // Ошибки TraineeQueue
    EMPTY_TRAINEE_QUEUE,

    // Ошибки TraineeBidiMap
    DUPLICATE_PASSPORT,
    PASSPORT_NOT_FOUND
}