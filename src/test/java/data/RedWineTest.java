package data;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;


/**
 * Created by hlay on 06/07/18.
 */
@RunWith(Parameterized.class)
public class RedWineTest
{
  private static int THIS_YEAR = LocalDate.now().getYear();


  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
        // Loire  1 an 	2-3 ans 	4-6 ans 	+ 6 ans
        { RedWine.LOIRE, THIS_YEAR, true, false, false },
        { RedWine.LOIRE, THIS_YEAR - 1, true, false, false },
        { RedWine.LOIRE, THIS_YEAR - 2, false, true, false },
        { RedWine.LOIRE, THIS_YEAR - 3, false, true, false },
        { RedWine.LOIRE, THIS_YEAR - 4, false, false, true },
        { RedWine.LOIRE, THIS_YEAR - 6, false, false, true },
        { RedWine.LOIRE, THIS_YEAR - 7, false, false, false },

        // Bordeaux 2 ans 	3-4 ans 	5-10 ans 	+ 10 ans
        { RedWine.BORDEAUX, THIS_YEAR, true, false, false },
        { RedWine.BORDEAUX, THIS_YEAR - 2, true, false, false },
        { RedWine.BORDEAUX, THIS_YEAR - 3, false, true, false },
        { RedWine.BORDEAUX, THIS_YEAR - 4, false, true, false },
        { RedWine.BORDEAUX, THIS_YEAR - 5, false, false, true },
        { RedWine.BORDEAUX, THIS_YEAR - 10, false, false, true },
        { RedWine.BORDEAUX, THIS_YEAR - 11, false, false, false },

        // Bordeaux_grands_crus, 	5 ans 	6-9 ans 	10-20 ans 	+ 20 ans
        { RedWine.BORDEAUX_GC, THIS_YEAR, true, false, false },
        { RedWine.BORDEAUX_GC, THIS_YEAR - 5, true, false, false },
        { RedWine.BORDEAUX_GC, THIS_YEAR - 6, false, true, false },
        { RedWine.BORDEAUX_GC, THIS_YEAR - 9, false, true, false },
        { RedWine.BORDEAUX_GC, THIS_YEAR - 10, false, false, true },
        { RedWine.BORDEAUX_GC, THIS_YEAR - 20, false, false, true },
        { RedWine.BORDEAUX_GC, THIS_YEAR - 21, false, false, false },

        // Sud-Ouest 	2 ans 	3-4 ans 	5-10 ans 	+10 ans
        { RedWine.SUDOUEST, THIS_YEAR, true, false, false },
        { RedWine.SUDOUEST, THIS_YEAR - 2, true, false, false },
        { RedWine.SUDOUEST, THIS_YEAR - 3, false, true, false },
        { RedWine.SUDOUEST, THIS_YEAR - 4, false, true, false },
        { RedWine.SUDOUEST, THIS_YEAR - 5, false, false, true },
        { RedWine.SUDOUEST, THIS_YEAR - 10, false, false, true },
        { RedWine.SUDOUEST, THIS_YEAR - 11, false, false, false },

        // Languedoc & Provence 	2 ans 	3-4 ans 	5-8 ans 	+ 8 ans
        { RedWine.LANGUEDOC_PROVENCE, THIS_YEAR, true, false, false },
        { RedWine.LANGUEDOC_PROVENCE, THIS_YEAR - 2, true, false, false },
        { RedWine.LANGUEDOC_PROVENCE, THIS_YEAR - 3, false, true, false },
        { RedWine.LANGUEDOC_PROVENCE, THIS_YEAR - 4, false, true, false },
        { RedWine.LANGUEDOC_PROVENCE, THIS_YEAR - 5, false, false, true },
        { RedWine.LANGUEDOC_PROVENCE, THIS_YEAR - 8, false, false, true },
        { RedWine.LANGUEDOC_PROVENCE, THIS_YEAR - 9, false, false, false },

        // Côtes du Rhône 	1 an 	2-3 ans 	4-6 ans 	+ 6 ans
        { RedWine.RHONE, THIS_YEAR, true, false, false },
        { RedWine.RHONE, THIS_YEAR - 1, true, false, false },
        { RedWine.RHONE, THIS_YEAR - 2, false, true, false },
        { RedWine.RHONE, THIS_YEAR - 3, false, true, false },
        { RedWine.RHONE, THIS_YEAR - 4, false, false, true },
        { RedWine.RHONE, THIS_YEAR - 6, false, false, true },
        { RedWine.RHONE, THIS_YEAR - 7, false, false, false },

        // Côtes du Rhône, grands crus 	5 ans 	6-9 ans 	10-20 ans 	+ 20 ans
        { RedWine.RHONE_GC, THIS_YEAR, true, false, false },
        { RedWine.RHONE_GC, THIS_YEAR - 5, true, false, false },
        { RedWine.RHONE_GC, THIS_YEAR - 6, false, true, false },
        { RedWine.RHONE_GC, THIS_YEAR - 9, false, true, false },
        { RedWine.RHONE_GC, THIS_YEAR - 10, false, false, true },
        { RedWine.RHONE_GC, THIS_YEAR - 20, false, false, true },
        { RedWine.RHONE_GC, THIS_YEAR - 21, false, false, false },

        // Beaujolais 	1 an 	2-3 ans 	4-5 ans 	+ 5 ans
        { RedWine.BEAUJOLAIS, THIS_YEAR, true, false, false },
        { RedWine.BEAUJOLAIS, THIS_YEAR - 1, true, false, false },
        { RedWine.BEAUJOLAIS, THIS_YEAR - 2, false, true, false },
        { RedWine.BEAUJOLAIS, THIS_YEAR - 3, false, true, false },
        { RedWine.BEAUJOLAIS, THIS_YEAR - 4, false, false, true },
        { RedWine.BEAUJOLAIS, THIS_YEAR - 5, false, false, true },
        { RedWine.BEAUJOLAIS, THIS_YEAR - 6, false, false, false },

        // Beaujolais, crus 	2 ans 	3-4 ans 	5-8 ans 	+ 8 ans
        { RedWine.BEAUJOLAIS_CRUS, THIS_YEAR, true, false, false },
        { RedWine.BEAUJOLAIS_CRUS, THIS_YEAR - 2, true, false, false },
        { RedWine.BEAUJOLAIS_CRUS, THIS_YEAR - 3, false, true, false },
        { RedWine.BEAUJOLAIS_CRUS, THIS_YEAR - 4, false, true, false },
        { RedWine.BEAUJOLAIS_CRUS, THIS_YEAR - 5, false, false, true },
        { RedWine.BEAUJOLAIS_CRUS, THIS_YEAR - 8, false, false, true },
        { RedWine.BEAUJOLAIS_CRUS, THIS_YEAR - 9, false, false, false },

        // Bourgogne, Saône-et-Loire 	2 ans 	3-4 ans 	5-10 ans 	+10 ans
        { RedWine.BOURGOGNE_SAONE, THIS_YEAR, true, false, false },
        { RedWine.BOURGOGNE_SAONE, THIS_YEAR - 2, true, false, false },
        { RedWine.BOURGOGNE_SAONE, THIS_YEAR - 3, false, true, false },
        { RedWine.BOURGOGNE_SAONE, THIS_YEAR - 4, false, true, false },
        { RedWine.BOURGOGNE_SAONE, THIS_YEAR - 5, false, false, true },
        { RedWine.BOURGOGNE_SAONE, THIS_YEAR - 10, false, false, true },
        { RedWine.BOURGOGNE_SAONE, THIS_YEAR - 11, false, false, false },

        // Bourgogne, Côte-d'Or 5 ans 	6-9ans 	10-20 ans 	+ 20 ans
        { RedWine.BOURGOGNE_COTE, THIS_YEAR, true, false, false },
        { RedWine.BOURGOGNE_COTE, THIS_YEAR - 5, true, false, false },
        { RedWine.BOURGOGNE_COTE, THIS_YEAR - 6, false, true, false },
        { RedWine.BOURGOGNE_COTE, THIS_YEAR - 9, false, true, false },
        { RedWine.BOURGOGNE_COTE, THIS_YEAR - 10, false, false, true },
        { RedWine.BOURGOGNE_COTE, THIS_YEAR - 20, false, false, true },
        { RedWine.BOURGOGNE_COTE, THIS_YEAR - 21, false, false, false },
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