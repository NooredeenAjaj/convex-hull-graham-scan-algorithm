import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fileName = "16000.0.in";
        boolean isInt = false;

        List<Point> points = new ArrayList<>();

        Scanner scanner = new Scanner(fileName);

        scanner.nextLine();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] values = line.trim().split("#");
            String[] xandY = values[1].trim().split(" ");

            Double x = Double.parseDouble(xandY[0]);
            Double y = Double.parseDouble(xandY[1]);
            if (Math.abs(((int) Math.round(x)) - x) > 0 || Math.abs(((int) Math.round(y)) - y) > 0) {
                isInt = true;
            }

            Point p = new Point(x, y);
            points.add(p);
        }

        scanner.close();

        Point[] p = points.toArray(new Point[points.size()]);

        List<Point> pointsklar = GrahamScan.grahamScan(points);
        Point[] s = pointsklar.toArray(new Point[pointsklar.size()]);
        System.out.println(s.length);

        for (int i = 0; i < s.length; i++) {
            int x = (int) (s[i].getX());
            int y = (int) (s[i].getY());
            if (isInt) {
                System.out.printf("%.3f %.3f", s[i].getX(), s[i].getY());
                System.out.println();
            } else {
                System.out.println(x + " " + y);
            }
        }
    }
}
