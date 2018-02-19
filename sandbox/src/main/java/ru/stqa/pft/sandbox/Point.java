package ru.stqa.pft.sandbox;

/**
 * Created by Админ on 20.02.2018.
 */
public class Point {
  double x;
  double y;

  Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public static double distance(Point p1, Point p2) {
    return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
  }

  public static void main(String[] args) {
    Point p1;
    Point p2;
    p1 = new Point(3.0, 5.0);
    p2 = new Point(6.0, 9.0);
    System.out.print(Point.distance(p1, p2));
  }
}

