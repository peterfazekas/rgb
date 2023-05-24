package hu.rgb.model.domain;

public class Coord {

    private final int column;
    private final int row;

    public Coord(int column, int row) {
        this.column = column;
        this.row = row;
    }

    public boolean isCoord(int column, int row) {
        return this.row == row && this.column == column;
    }

    public boolean isRow(int row) {
        return this.row == row;
    }

}
