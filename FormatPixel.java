/* 
 * Student: Caragea Matei - Ioan
 * Grupa:   331AA
 * Scopul modulului: Analizarea formatului pixelilor pentru a stabili daca imaginea este deja Greyscale
 * 
 */
package classes;

class FormatPixel extends Image {
	int format = 1; // 1 = greyscale ; 0 = rgb
	
	// Getter pentru atributul format
	public int getFormat() {
		return format;
	}
	// Setter pentru atributul format
	public void setFormat(int frmt) {
		this.format = frmt;
	}
	// Metoda ce verifica daca imaginea este color sau Grayscale
	// Daca este deja Grayscale, aceasta nu mai este convertita
	public void verificare() {
		int width = this.getImage().getWidth();
	    int height = this.getImage().getHeight();

	    //Convert to grayscale
	    for(int y = 0; y < height; y++){
	      for(int x = 0; x < width; x++){
	        int p = this.getImage().getRGB(x,y); // Variabila in care se stocheaza valoarea rgb a pixelului

	        int r = (p>>16)&0xff; // Citeste valoarea culorii rosii a pixelului
	        int g = (p>>8)&0xff; // Citeste valoarea culorii verzi a pixelului
	        int b = p&0xff; // Citeste valoarea culorii albastre a pixelului
	        if(r == g && g == b) // Daca cele 3 culori au valori egale, stim ca pixelul este gri
	        	continue;
	        else {
	        	this.setFormat(0); // Daca cel putin un pixel este color, formatul se schimba din Grayscale in imagine color
	        	break;
	        }
	      }
	    }
	}
}