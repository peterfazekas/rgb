package hu.rgb.controller;

import hu.rgb.model.domain.Pixel;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ImageService {

    private final List<Pixel> pixels;

    public ImageService(List<Pixel> pixels) {
        this.pixels = pixels;
    }

    /**
     * 2. feladat
     */
    public String getPixelColor(int column, int row) {
        return getPixel(column, row).print();
    }


    private Pixel getPixel(int column, int row) {
        return pixels.stream()
                .filter(i -> i.isPixel(column, row))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Nincs ilyen képkocka!"));
    }

    /**
     * 3. feladat
     */
    public long countLightPixels() {
        return pixels.stream()
                .filter(Pixel::isLight)
                .count();
    }

    /**
     * 4. feladat
     */
    public int getDarkestShade() {
        return pixels.stream()
                .map(Pixel::getShade)
                .min(Comparator.naturalOrder())
                .get();
    }
    public String getDarkestColors(int shade) {
        return pixels.stream()
                .filter(pixel -> pixel.isShade(shade))
                .map(Pixel::print)
                .collect(Collectors.joining("\n"));
    }

    /**
     * 5. feladat
     */
    private boolean hatar(int row, int range) {
        List<Pixel> pixelsInRow = getRow(row);
        return IntStream.rangeClosed(1, pixelsInRow.size() - 2)
                .anyMatch(i -> Math.abs(pixelsInRow.get(i).getBlue() - pixelsInRow.get(i + 1).getBlue()) > range);
    }

    private List<Pixel> getRow(int row) {
        return pixels.stream()
                .filter(i -> i.isPixelInRow(row))
                .toList();
    }

    /**
     * 6. feladat
     */
    public int getFirstRow() {
        int row = 1;
        while (!hatar(row, 10)) {
            row++;
        }
        return row;
    }

    public int getLastRow() {
        int row = 360;
        while (!hatar(row, 10)) {
            row--;
        }
        return row;
    }
}
