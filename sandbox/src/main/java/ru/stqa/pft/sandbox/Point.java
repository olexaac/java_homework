package ru.stqa.pft.sandbox;

/**
 * Created by Админ on 20.02.2018.
 */
public class Point {

  public static void main(String[] args) {
    Distance p1;
    Distance p2;
    p1 = new Distance(3.0, 5.0);
    p2 = new Distance(6.0, 9.0);
    System.out.println("Расстояние между двумя точками " + " = " + Distance.distance(p1, p2));
  }

}

