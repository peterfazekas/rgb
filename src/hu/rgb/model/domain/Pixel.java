package hu.rgb.model.domain;

public class Pixel {


    private final Coord coord;
    private final Color color;

    public Pixel(Coord coord, Color color) {
        this.coord = coord;
        this.color = color;
    }

    public String print() {
        return color.toString();
    }

    public boolean isPixel(int column, int row) {
        return coord.isCoord(column, row);
    }

    public boolean isPixelInRow(int row) {
        return coord.isRow(row);
    }

    public boolean isLight() {
        return color.isLight();
    }

    public int getShade() {
        return color.getShade();
    }

    public boolean isShade(int shade) {
        return color.isShade(shade);
    }

    public int getBlue() {
        return color.getBlue();
    }
}
