/* 
 * Student: Caragea Matei - Ioan
 * Grupa:   331AA
 * Scopul modulului: Convertirea imaginii efective in Greyscale
 * 
 */
package classes;

import java.awt.image.BufferedImage;

public class Greyscale extends FormatPixel {
    // Metoda ce convertește o imagine color în Greyscale
    public void greyscale() {
        // Dacă imaginea este color, o convertește în Greyscale
        if (this.getFormat() == 0) {    
            BufferedImage image = this.getImage();
            int width = image.getWidth();
            int height = image.getHeight();

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int p = image.getRGB(x, y); // Se citește valoarea RGB a pixelului 

                    int a = (p >> 24) & 0xff; // Variabila ce stochează transparența pixelului, nu este folosită
                    int R = (p >> 16) & 0xff; // Variabila ce stochează valoarea culorii roșii a pixelului 
                    int G = (p >> 8) & 0xff; // Variabila ce stochează valoarea culorii verzi a pixelului 
                    int B = p & 0xff; // Variabila ce stochează valoarea culorii albastre a pixelului 

                    // Se calculează folosind formula weighted
                    int grayscale = (int) (0.299 * R + 0.587 * G + 0.114 * B);

                    // Se înlocuiesc valorile RGB ale pixelului cu valoarea grayscale calculată anterior
                    p = (a << 24) | (grayscale << 16) | (grayscale << 8) | grayscale;
                    image.setRGB(x, y, p);
                }
            }
        }
        // Dacă imaginea este deja Greyscale, afișează un mesaj de avertisment și încheie programul
        else {
            System.out.println("Imaginea este deja Greyscale!");
            System.exit(0);
        }
    }

    // Metoda ce returnează numărul total de pixeli ai imaginii
    public int getPixelCount(BufferedImage img) {
        int width = img.getWidth(); 
        int height = img.getHeight();
        return width * height;
    }
}
