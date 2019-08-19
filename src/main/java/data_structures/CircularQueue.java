package data_structures;

public class CircularQueue {
    private int[] data;
    private int head;
    private int tail;
    private final int INITIAL_SIZE;
    private int queueSize;

    public CircularQueue(int size) {
        this.head = -1;
        this.tail = -1;
        this.INITIAL_SIZE = size;
        this.data = new int[size];
        this.queueSize = 0;
    }

    public int Front() {
        return isEmpty() ? -1 : data[head];
    }

    public int Rear() {
        return isEmpty() ? -1 : data[tail];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (tail == -1) {
            head = 0;
        }
        tail = (tail + 1) < INITIAL_SIZE ? ++tail : ++tail % INITIAL_SIZE;
        data[tail] = value;
        queueSize++;
        return true;
    }

    public  boolean deQueue() {
        if(isEmpty()) {
            return false;
        }
        queueSize--;
        if (queueSize == 0) {
            head = -1;
            tail = -1;
        }
        else {
            head = (head + 1) < INITIAL_SIZE ? ++head : ++head % INITIAL_SIZE;
        }
        return true;
    }

    public boolean isEmpty() {
        return queueSize == 0;
    }

    public  boolean isFull() {
        return queueSize == INITIAL_SIZE;
    }


}
