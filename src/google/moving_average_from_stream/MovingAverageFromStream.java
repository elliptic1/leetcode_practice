package google.moving_average_from_stream;

public class MovingAverageFromStream {
    public static void main(String[] args) {
        MovingAverageA ma = new MovingAverageA(5);

        ma.next(1);
        ma.next(1);
        ma.next(1);
        ma.next(1);
        ma.next(1);
        ma.next(4);
        ma.next(4);
        ma.next(4);
        ma.next(4);
        ma.next(4);
    }
}

class MovingAverageA {

    int[] data;
    int index = 0;
    int size;
    double avg;
    boolean full = false;

    /**
     * Initialize your data structure here.
     */
    public MovingAverageA(int size) {
        this.size = size;
        data = new int[size];
    }

    public double next(int val) {
        data[index] = val;
        if (index + 1 == size) {
            full = true;
        }
        index = (index + 1) % size;

        int sum = 0;
        if (full) {
            for (int i = 0; i < size; i++) {
                sum += data[i];
            }
            avg = sum / (size * 1.0);
        } else {
            for (int i = 0; i < index; i++) {
                sum += data[i];
            }
            avg = sum / (index * 1.0);
        }
        System.out.println("avg " + avg);
        return avg;

    }

}



