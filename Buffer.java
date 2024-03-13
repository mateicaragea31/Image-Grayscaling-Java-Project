/* 
 * Student: Caragea Matei - Ioan
 * Grupa:   331AA
 * 
 */
package classes;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    private final Queue<BufferedImage> buffer;
    private final int maxSize;

    public Buffer(int maxSize) {
        this.buffer = new LinkedList<>();
        this.maxSize = maxSize;
    }

    public synchronized boolean isEmpty() {
        return buffer.isEmpty();
    }

    public synchronized boolean isFull() {
        return buffer.size() == maxSize;
    }

    public synchronized void produce(BufferedImage imageSegment) throws InterruptedException {
        while (isFull()) {
            wait();
        }

        buffer.add(imageSegment);
        System.out.println("Produced: " + imageSegment);

        notify();
    }

    public synchronized BufferedImage consume() throws InterruptedException {
        while (isEmpty()) {
            wait();
        }

        BufferedImage img = buffer.poll();
        System.out.println("Consumed: " + img);

        notifyAll();

        return img;
    }
}