package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Админ on 26.02.2018.
 */
public class PointTests {

  @Test
  public void testDistance (){
    Distance p1;
    Distance p2;
    p1 = new Distance(3.0, 5.0);
    p2 = new Distance(6.0, 9.0);
    Assert.assertEquals (Distance.distance(p1, p2), 5.0);
  }
}
