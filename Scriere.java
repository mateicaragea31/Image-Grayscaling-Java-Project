/* 
 * Student: Caragea Matei - Ioan
 * Grupa:   331AA
 * Scopul modulului: Scrierea imaginii
 * 
 */
package classes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

//Metoda folosita pentru scrierea imaginii la adresa specificata
public class Scriere{
	public static void scriere(BufferedImage img, String path) {
		try{
            if(!path.endsWith(".bmp")) {
                System.out.println("Fisierul trebuie sa contina extensia .bmp!"); // tratare eroare de scriere
                System.exit(0);
            }
			File f = new File(path);
            ImageIO.write(img, "bmp", f);
            
        }catch(IOException e){
        	System.out.println("Scriere nereusita!"); // tratare eroare de scriere
            System.exit(0);
        }
	}
}