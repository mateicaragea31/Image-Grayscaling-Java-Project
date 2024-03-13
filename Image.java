/* 
 * Student: Caragea Matei - Ioan
 * Grupa:   331AA
 * 
 */
package classes;

import java.awt.image.BufferedImage;

abstract public class Image implements Interfata{
	private BufferedImage img;
	private String path;
	// Setter pentru path-ul fisierului 
	public void setPath(String pth) {
		this.path = pth;
	}
	// Getter pentru path-ul fisierului
	public String getPath() {
		return this.path;
	}
	// Setter pentru imagine
	public void setImage(BufferedImage image) {
		this.img = image;
	}
	// Getter pentru imagine
	public BufferedImage getImage() {
		return img;
	}
	public void greey() {	
	}
}