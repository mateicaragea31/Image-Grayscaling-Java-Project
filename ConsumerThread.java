/* 
 * Student: Caragea Matei - Ioan
 * Grupa:   331AA
 * 
 */
package classes;

import java.awt.image.BufferedImage;

public class ConsumerThread extends Thread {
    private final Buffer buffer;
    private final Greyscale greyscale;

    public ConsumerThread(Buffer buffer, Greyscale greyscale) {
        this.buffer = buffer;
        this.greyscale = greyscale;
    }

    @Override
    public void run() {
        try {
            while (true) {
                BufferedImage segment = buffer.consume();
                if (segment != null) {
                    processSegment(segment);
                    System.out.println("Procesat o imagine");
                    Thread.sleep(1000); // Asteapta 1 secunda pentru a evidentia pasii de comunicare
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void processSegment(BufferedImage segment) {
       
        greyscale.setImage(segment);
        greyscale.greyscale();
    }
}
