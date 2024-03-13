/* 
 * Student: Caragea Matei - Ioan
 * Grupa:   331AA
 * Scopul modulului: Citirea imaginii
 * 
 */
package classes;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;

// Metoda folosită pentru citirea imaginii de la adresa specificată
public class Citire {
    public static BufferedImage citire(String path) {
        try {
            File file = new File(path);
            return ImageIO.read(file);
        } catch (IOException e) {
            System.out.println("Citire imagine nereușită!"); // Tratare eroare de citire
            System.exit(0);
        }
        return null;
    }
}
