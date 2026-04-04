package academy.tochkavhoda.school;

import java.util.*;

public class TraineeMultiValuedMap {
    private Map<Integer, Set<Trainee>> ratingTraineeMap;

    public TraineeMultiValuedMap() {
        this.ratingTraineeMap = new HashMap<>();
    }

    public boolean addTrainee(Trainee trainee) {
        int rating = trainee.getRating();
        Set<Trainee> trainees = ratingTraineeMap.get(rating);
        if (trainees == null) {
            trainees = new HashSet<>();
            ratingTraineeMap.put(rating, trainees);
        }
        return trainees.add(trainee);
    }

    public boolean removeTrainee(Trainee trainee) {
        int rating = trainee.getRating();
        Set<Trainee> trainees = ratingTraineeMap.get(rating);
        if (trainees == null) {
            return false;
        }
        boolean removed = trainees.remove(trainee);
        if (trainees.isEmpty()) {
            ratingTraineeMap.remove(rating);
        }
        return removed;
    }

    public Collection<Trainee> getTraineesByRating(int rating) {
        Set<Trainee> trainees = ratingTraineeMap.get(rating);
        return trainees != null ? new ArrayList<>(trainees) : new ArrayList<>();
    }

    public boolean hasAnyBodyRating(int rating) {
        Set<Trainee> trainees = ratingTraineeMap.get(rating);
        return trainees != null && !trainees.isEmpty();
    }

    public int getTraineesCount() {
        int count = 0;
        for (Set<Trainee> trainees : ratingTraineeMap.values()) {
            count += trainees.size();
        }
        return count;
    }
}