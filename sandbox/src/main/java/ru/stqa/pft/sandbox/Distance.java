package ru.stqa.pft.sandbox;

import com.sun.javafx.geom.Quat4f;

/**
 * Created by Админ on 20.02.2018.
 */
public class Distance {
  public double x;
  public double y;

  public Distance(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public static double distance(Distance p1, Distance p2) {
    return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
  }
}
