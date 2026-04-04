package academy.tochkavhoda.school;

import academy.tochkavhoda.exceptions.TrainingErrorCode;
import academy.tochkavhoda.exceptions.TrainingException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TraineeBidiMap {
    private Map<String, Trainee> passportToTrainee;
    private Map<Trainee, String> traineeToPassport;

    public TraineeBidiMap() {
        this.passportToTrainee = new HashMap<>();
        this.traineeToPassport = new HashMap<>();
    }

    public void addTrainee(Trainee trainee, String passport) {
        if (traineeToPassport.containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_TRAINEE);
        }
        if (passportToTrainee.containsKey(passport)) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_PASSPORT);
        }
        passportToTrainee.put(passport, trainee);
        traineeToPassport.put(trainee, passport);
    }

    public void replaceTraineePassport(Trainee trainee, String passport) {
        if (!traineeToPassport.containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        if (passportToTrainee.containsKey(passport)) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_PASSPORT);
        }

        String oldPassport = traineeToPassport.get(trainee);
        passportToTrainee.remove(oldPassport);
        passportToTrainee.put(passport, trainee);
        traineeToPassport.put(trainee, passport);
    }

    public void removeTrainee(Trainee trainee) {
        String passport = traineeToPassport.remove(trainee);
        if (passport == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        passportToTrainee.remove(passport);
    }

    public void removeTraineeByPassport(String passport) {
        Trainee trainee = passportToTrainee.remove(passport);
        if (trainee == null) {
            throw new TrainingException(TrainingErrorCode.PASSPORT_NOT_FOUND);
        }
        traineeToPassport.remove(trainee);
    }

    public Trainee getTraineeByPassport(String passport) {
        Trainee trainee = passportToTrainee.get(passport);
        if (trainee == null) {
            throw new TrainingException(TrainingErrorCode.PASSPORT_NOT_FOUND);
        }
        return trainee;
    }

    public String getPassportByTrainee(Trainee trainee) {
        String passport = traineeToPassport.get(trainee);
        if (passport == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        return passport;
    }

    public Set<Trainee> getAllTrainees() {
        return new HashSet<>(traineeToPassport.keySet());
    }

    public Set<String> getAllPassports() {
        return new HashSet<>(passportToTrainee.keySet());
    }

    public boolean hasAnybodyPassport(String passport) {
        return passportToTrainee.containsKey(passport);
    }

    public int getTraineesCount() {
        return traineeToPassport.size();
    }
}