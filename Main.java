/* 
 * Student: Caragea Matei - Ioan
 * Grupa:   331AA
 * 
 */
package test;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;

import classes.Citire;
import classes.Greyscale;
import classes.Scriere;
import classes.Buffer;
import classes.ConsumerThread;
import classes.ProducerThread;

public class Main {
	
	static {
        System.out.println("Program initializing..."); // Add any initialization code here
    }
    public static void main(String[] varargs) throws IOException {
        // Declararea variabilelor
        BufferedImage img;
        Greyscale grey = new Greyscale();
        long start; // Variabila folosita pentru inregistrarea timpilor de executie

        // Citirea path-ului fisierului sursa din linia de comanda
        System.out.println("Introduceti path-ul fisierului sursa: ");
        String path;
        Scanner scan = new Scanner(System.in);
        path = scan.nextLine();

        // Citirea efectiva a fisierului sursa
        start = System.nanoTime(); // Inregistrarea momentului inainte de citire
        img = Citire.citire(path);
        grey.setImage(img);
        System.out.println("Timp citire: " + (System.nanoTime() - start) + " nanosecunde");

        // Verificare daca imaginea este deja Greyscale
        start = System.nanoTime();
        grey.verificare();
        System.out.println("Timp verificare: " + (System.nanoTime() - start) + " nanosecunde");

        // Inceperea procesarii imaginii daca nu este deja Greyscale
        start = System.nanoTime();
        grey.greyscale();
        System.out.println("Timp procesare: " + (System.nanoTime() - start) + " nanosecunde");

        // Scrierea imaginii convertite in fisierul destinatie
        start = System.nanoTime();
        System.out.println("Introduceti path-ul fisierului destinatie: ");
        path = scan.nextLine();
        Scriere.scriere(grey.getImage(), path);
        System.out.println("Timp scriere: " + (System.nanoTime() - start) + " nanosecunde");

        // Afișarea numărului de pixeli ai imaginii
        int nrpixeli = grey.getPixelCount(img);
        System.out.println("Numarul de pixeli ai imaginii este: " + nrpixeli);

        // Nu inchide System.in; inchide doar Scanner-ul
        scan.close();

        // Crearea unui buffer de imagini partajat cu o dimensiune maxima (ajustati dupa nevoie)
        Buffer sharedBuffer = new Buffer(5);

        // Crearea si pornirea firului de executie ConsumerThread
        ConsumerThread consumerThread = new ConsumerThread(sharedBuffer, grey);
        consumerThread.start();

        // Crearea si pornirea firului de executie ProducerThread
        ProducerThread producerThread = new ProducerThread(sharedBuffer, path);
        producerThread.start();

        // Asteptarea terminarii ambelor fire de executie
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
// Exemplu path: /Users/mateicaragea/Desktop/Facultate/javaa/messi.bmp