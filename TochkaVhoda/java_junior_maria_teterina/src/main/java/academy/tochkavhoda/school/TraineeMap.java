package academy.tochkavhoda.school;

import academy.tochkavhoda.exceptions.TrainingErrorCode;
import academy.tochkavhoda.exceptions.TrainingException;

import java.util.*;

public class TraineeMap {
    private Map<Trainee, String> traineeInstituteMap;

    public TraineeMap() {
        this.traineeInstituteMap = new HashMap<>();
    }

    public void addTraineeInfo(Trainee trainee, String institute) {
        if (traineeInstituteMap.containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_TRAINEE);
        }
        traineeInstituteMap.put(trainee, institute != null ? institute : "");
    }

    public void replaceTraineeInfo(Trainee trainee, String institute) {
        if (!traineeInstituteMap.containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        traineeInstituteMap.put(trainee, institute != null ? institute : "");
    }

    public void removeTraineeInfo(Trainee trainee) {
        if (traineeInstituteMap.remove(trainee) == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
    }

    public int getTraineesCount() {
        return traineeInstituteMap.size();
    }

    public String getInstituteByTrainee(Trainee trainee) {
        String institute = traineeInstituteMap.get(trainee);
        if (institute == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        return institute;
    }

    public Set<Trainee> getAllTrainees() {
        return new HashSet<>(traineeInstituteMap.keySet());
    }

    public Set<String> getAllInstitutes() {
        return new HashSet<>(traineeInstituteMap.values());
    }

    public boolean isAnyFromInstitute(String institute) {
        return traineeInstituteMap.containsValue(institute);
    }
}