package Lab5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }
}

class Line {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }
}

class Polyline {
    private List<Line> lines;  // ломаная состоит из линий

    public Polyline(List<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    // для получения всех точек ломаной (для удобства)
    public List<Point> getAllPoints() {
        if (lines.isEmpty()) {
            return Collections.emptyList();
        }

        List<Point> points = new ArrayList<>();
        points.add(lines.get(0).getStart());  // первая точка первой линии

        for (Line line : lines) {
            points.add(line.getEnd());  // конечные точки всех линий
        }

        return points;
    }

    @Override
    public String toString() {
        if (lines.isEmpty()) {
            return "Пустая ломаная";
        }

        List<Point> allPoints = getAllPoints();
        String pointsStr = allPoints.stream()
                .map(Point::toString)
                .collect(Collectors.joining(",", "[", "]"));

        return "Ломаная " + pointsStr;
    }
}

public class Task7_1 {

    // обрабатывает точки и создает ломаную из линий
    public static Polyline processPoints(List<Point> points) {
        // обрабатываем точки: удаляем дубликаты, сортируем по X, делаем Y положительными
        List<Point> processedPoints = points.stream()
                .distinct()
                .sorted(Comparator.comparingDouble(Point::getX))
                .map(p -> new Point(p.getX(), Math.abs(p.getY())))
                .collect(Collectors.toList());

        // если точек меньше 2, нельзя создать ни одной линии
        if (processedPoints.size() < 2) {
            return new Polyline(Collections.emptyList());
        }

        // создаем линии из последовательных точек
        List<Line> lines = IntStream.range(0, processedPoints.size() - 1)
                .mapToObj(i -> new Line(processedPoints.get(i),
                        processedPoints.get(i + 1)))
                .collect(Collectors.toList());

        // создаем ломаную из линий
        return new Polyline(lines);
    }
}