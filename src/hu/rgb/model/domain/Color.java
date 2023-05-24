package hu.rgb.model.domain;

public class Color {

    private final int red;
    private final int green;
    private final int blue;

    public Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getBlue() {
        return blue;
    }

    public boolean isLight() {
        return getShade() > 600;
    }

    public int getShade() {
        return red + green  + blue;
    }

    public boolean isShade(int shade) {
        return getShade() == shade;
    }
    @Override
    public String toString() {
        return "RGB(" + red + "," + green + "," + blue + ')';
    }
}
