package data_structures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CircularQueueTest {
    private static final int INITIAL_QUEUE_SIZE = 5;
    private CircularQueue queue;

    @Before
    public void setup() {
        this.queue = new CircularQueue(INITIAL_QUEUE_SIZE);
    }

    @Test
    public void enQueueWorksCorrectly() {
        Assert.assertTrue("Queue should be empty",queue.isEmpty());
        queue.enQueue(5);
        queue.enQueue(6);
        queue.enQueue(7);
        queue.enQueue(8);
        queue.enQueue(9);
        Assert.assertFalse("Queue should not enqueue any more elements when full", queue.enQueue(10));
        Assert.assertEquals(5, queue.Front());
        Assert.assertEquals(9, queue.Rear());
        Assert.assertTrue("Queue should be full", queue.isFull());
        queue.deQueue();
        Assert.assertFalse("Queue should not be full.", queue.isFull());
        queue.deQueue();
        queue.enQueue(10);
        Assert.assertEquals(7,queue.Front());
        Assert.assertEquals(10, queue.Rear());
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        Assert.assertFalse("Queue should not be empty.",queue.isEmpty());
        queue.deQueue();
        Assert.assertTrue("Queue should be empty.", queue.isEmpty());
        Assert.assertFalse("Queue should not be able to deQueue further", queue.deQueue());
        queue.enQueue(100);
        Assert.assertFalse(queue.isEmpty());
        Assert.assertEquals(100, queue.Front());
        Assert.assertEquals(100, queue.Rear());
    }
}
