package data;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;


/**
 * Created by hlay on 06/07/18.
 */
@RunWith(Parameterized.class)
public class RedWineTest
{
  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
        { RedWine.LOIRE, 0, true , false, false}
    });
  }

  @Parameterized.Parameter
  public RedWine wine;

  @Parameterized.Parameter(1)
  public int year;

  @Parameterized.Parameter(2)
  public boolean isItYoung;

  @Parameterized.Parameter(3)
  public boolean isItMature;

  @Parameterized.Parameter(4)
  public boolean isItAtPeak;

  @Test
  public void testWine()
  {
    Assert.assertThat(isItYoung, is(wine.isTooYoung().test(year)));
    Assert.assertThat(isItMature, is(wine.isMature().test(year)));
    Assert.assertThat(isItAtPeak, is(wine.isAtThePeak().test(year)));
  }

}