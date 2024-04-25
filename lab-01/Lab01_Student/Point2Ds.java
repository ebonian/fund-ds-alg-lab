import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Point2Ds {
	private Point2D[] points;

	public Point2D getPoint(int i) {
		// Return the point object at index i

		// Put your code here
		return this.points[i];
	}

	public void readFromFile(String filename) throws FileNotFoundException {
		// Read all points stored in filename
		// Store them in the array points

		// Put your code here
		Scanner s = new Scanner(new File(filename));

		ArrayList<Point2D> p = new ArrayList<>();

		while (s.hasNextLine()) {
			String[] l = s.nextLine().split(" ");
			p.add(new Point2D(Double.parseDouble(l[0]), Double.parseDouble(l[1])));
		}

		this.points = new Point2D[p.size()];
		this.points = p.toArray(this.points);

		s.close();
	}

	public Point2D getClosestPointToOrigin() {
		// Return the point that is closest to the origin

		// Put your code here
		return this.getClosestPoint(0, 0);
	}

	public Point2D getClosestPoint(double x, double y) {
		// Return the point that is closest to x,y

		// Put your code here
		Point2D closestPoint = this.points[0];
		for (int i = 0; i < this.points.length; i++) {
			double d = this.points[i].distance(new Point2D(x, y));
			if (d < closestPoint.distance(new Point2D(x, y))) {
				closestPoint = this.points[i];
			}

		}
		return closestPoint;
	}
}
