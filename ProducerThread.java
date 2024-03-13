/* 
 * Student: Caragea Matei - Ioan
 * Grupa:   331AA
 * 
 */
package classes;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ProducerThread extends Thread {
    private final Buffer buffer;
    private final String sourceFilePath;

    public ProducerThread(Buffer buffer, String sourceFilePath) {
        this.buffer = buffer;
        this.sourceFilePath = sourceFilePath;
    }

    @Override
    public void run() {
        try {
            processSegment(sourceFilePath);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void processSegment(String segmentPath) throws IOException, InterruptedException {
        // Verifica daca fisierul exista
        Path path = Paths.get(segmentPath);
        if (!Files.exists(path)) {
            System.err.println("Fisier negasit: " + segmentPath);
            return;
        }

        // Citeste segmentul de imagine
        BufferedImage img = Citire.citire(segmentPath);

        // Produce segmentul de imagine in buffer
        buffer.produce(img);

        Thread.sleep(1000); // Asteapta 1 secunda pentru a evidentia pasii de comunicare
    }
}
