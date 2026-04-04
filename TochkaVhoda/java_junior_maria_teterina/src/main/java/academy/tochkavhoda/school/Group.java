package academy.tochkavhoda.school;

import academy.tochkavhoda.exceptions.TrainingErrorCode;
import academy.tochkavhoda.exceptions.TrainingException;

import java.util.*;

public class Group {
    private String name;
    private String room;
    private List<Trainee> trainees;

    public Group(String name, String room) {
        setName(name);
        setRoom(room);
        this.trainees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_NAME);
        }
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        if (room == null || room.trim().isEmpty()) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_ROOM);
        }
        this.room = room;
    }

    public List<Trainee> getTrainees() {
        return trainees;
    }

    public void addTrainee(Trainee trainee) {
        if (trainee != null) {
            trainees.add(trainee);
        }
    }

    public void removeTrainee(Trainee trainee) {
        if (!trainees.remove(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
    }

    public void removeTrainee(int index) {
        if (index < 0 || index >= trainees.size()) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        trainees.remove(index);
    }

    public Trainee getTraineeByFirstName(String firstName) {
        for (Trainee trainee : trainees) {
            if (trainee.getFirstName().equals(firstName)) {
                return trainee;
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public Trainee getTraineeByFullName(String fullName) {
        for (Trainee trainee : trainees) {
            if (trainee.getFullName().equals(fullName)) {
                return trainee;
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public void sortTraineeListByFirstNameAscendant() {
        trainees.sort(Comparator.comparing(Trainee::getFirstName));
    }

    public void sortTraineeListByRatingDescendant() {
        trainees.sort((t1, t2) -> Integer.compare(t2.getRating(), t1.getRating()));
    }

    public void reverseTraineeList() {
        Collections.reverse(trainees);
    }

    public void rotateTraineeList(int positions) {
        if (trainees.isEmpty()) return;
        Collections.rotate(trainees, positions);
    }

    public List<Trainee> getTraineesWithMaxRating() {
        if (trainees.isEmpty()) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

        int maxRating = trainees.stream()
                .mapToInt(Trainee::getRating)
                .max()
                .orElse(0);

        return trainees.stream()
                .filter(t -> t.getRating() == maxRating)
                .toList();
    }

    public boolean hasDuplicates() {
        Set<String> uniqueKeys = new HashSet<>();
        for (Trainee trainee : trainees) {
            String key = trainee.getFirstName() + "|" +
                    trainee.getLastName() + "|" +
                    trainee.getRating();
            if (!uniqueKeys.add(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(name, group.name) &&
                Objects.equals(room, group.room) &&
                Objects.equals(trainees, group.trainees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, room, trainees);
    }
}