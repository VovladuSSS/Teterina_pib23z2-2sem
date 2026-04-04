package academy.tochkavhoda.school;

import academy.tochkavhoda.exceptions.TrainingErrorCode;
import academy.tochkavhoda.exceptions.TrainingException;

import java.util.LinkedList;
import java.util.Queue;

public class TraineeQueue {
    private Queue<Trainee> queue;

    public TraineeQueue() {
        this.queue = new LinkedList<>();
    }

    public void addTrainee(Trainee trainee) {
        queue.add(trainee);
    }

    public Trainee removeTrainee() {
        Trainee trainee = queue.poll();
        if (trainee == null) {
            throw new TrainingException(TrainingErrorCode.EMPTY_TRAINEE_QUEUE);
        }
        return trainee;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}