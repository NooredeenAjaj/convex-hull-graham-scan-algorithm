import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class GrahamScan {
    public static List<Point> grahamScan(List<Point> points) {
        Point po = points.stream()
                .min(Comparator.comparing(Point::getY).thenComparing(Point::getX))
                .orElseThrow(IllegalArgumentException::new);
        sortMeDady(points, po);

        List<Point> hull = new ArrayList<>();
        hull.add(points.get(0));
        hull.add(points.get(1));

        for (int i = 2; i < points.size(); i++) {
            while (hull.size() >= 2
                    && orientation(hull.get(hull.size() - 2), hull.get(hull.size() - 1), points.get(i)) != 1) {
                hull.remove(hull.size() - 1);
            }
            hull.add(points.get(i));
        }

        return hull;
    }

    private static void sortMeDady(List<Point> points, Point po) {
        points.sort((p1, p2) -> {
            double polarAngle1 = po.polarAngle(p1);
            double polarAngle2 = po.polarAngle(p2);
            if (polarAngle1 < polarAngle2) {
                return -1;
            } else if (polarAngle1 > polarAngle2) {
                return 1;
            } else {
                double dist1 = po.distanceTo(p1);
                double dist2 = po.distanceTo(p2);
                if (dist1 < dist2) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
    }

    public static int orientation(Point p1, Point p2, Point p3) {
        double x1 = p1.getX();
        double y1 = p1.getY();
        double x2 = p2.getX();
        double y2 = p2.getY();
        double x3 = p3.getX();
        double y3 = p3.getY();

        double d = (y3 - y2) * (x2 - x1) - (y2 - y1) * (x3 - x2);

        if (d > 0) {
            return 1;
        } else if (d < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
