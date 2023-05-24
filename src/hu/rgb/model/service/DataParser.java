package hu.rgb.model.service;

import hu.rgb.model.domain.Color;
import hu.rgb.model.domain.Coord;
import hu.rgb.model.domain.Pixel;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

public class DataParser {

    private static final String SEPARATOR = " ";
    private static final int MAX_ROW = 360;
    private static final int MAX_COLUMN = 640;

    public List<Pixel> parse(List<String> lines) {
        return IntStream.range(0, MAX_ROW)
                .mapToObj(line -> parseLine(line + 1, lines.get(line)))
                .flatMap(Collection::stream)
                .toList();
    }

    private List<Pixel> parseLine(int row, String line) {
        var items = Arrays.stream(line.split(SEPARATOR))
                .map(Integer::parseInt)
                .toList();
        return IntStream.iterate(0, column -> column + 3)
                .limit(MAX_COLUMN)
                .mapToObj(column -> parsePixel(row, (column / 3) + 1, items.subList(column, column + 3)))
                .toList();
    }

    private Pixel parsePixel(int row, int column, List<Integer> values) {
        var coord = new Coord(column, row);
        var color = new Color(values.get(0), values.get(1), values.get(2));
        return new Pixel(coord, color);
    }
}
