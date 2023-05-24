package hu.rgb;

import hu.rgb.controller.ImageService;
import hu.rgb.model.service.Console;
import hu.rgb.model.service.DataApi;
import hu.rgb.model.service.DataParser;
import hu.rgb.model.service.FileReader;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class App {

    private final ImageService service;
    private final Console console;

    private App() {
        var dataApi = new DataApi(new FileReader(), new DataParser());
        service = new ImageService(dataApi.getData("kep.txt"));
        console = new Console(new Scanner(System.in));
    }
    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        System.out.println("2. feladat:");
        System.out.println("Kérem egy képpont adatait:");
        System.out.print("Sor: ");
        int row = console.read();
        System.out.print("Oszlop: ");
        int column = console.read();
        System.out.println("A képpont színe " + service.getPixelColor(column, row));
        System.out.println("3. feladat:");
        System.out.println("A világos képpontok száma: " + service.countLightPixels());
        int darkestShade = service.getDarkestShade();
        System.out.println("4. feladat:");
        System.out.println("A legsötétebb pont RGB összege: " + darkestShade);
        System.out.println("A legsötétebb pixelek színe:");
        System.out.println(service.getDarkestColors(darkestShade));
        System.out.println("6. feladat:");
        System.out.println("A felhő legfelső sora: " + service.getFirstRow());
        System.out.println("A felhő legalsó sora: " + service.getLastRow());
    }
}