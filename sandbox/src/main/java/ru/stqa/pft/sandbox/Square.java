package ru.stqa.pft.sandbox;

/**
 * Created by Админ on 19.02.2018.
 */
public class Square {

  public double l;

  public Square(double l) {
    this.l = l;
  }

  public double area(){
    return this.l * this.l;
  }
}
