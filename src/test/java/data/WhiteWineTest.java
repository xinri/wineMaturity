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
public class WhiteWineTest
{
  private static int THIS_YEAR = LocalDate.now().getYear();


  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
        // Loire, sec 	1 an 	2 ans 	3-4 ans 	+ 4 ans
        { WhiteWine.LOIRE_SEC, THIS_YEAR, true, false, false },
        { WhiteWine.LOIRE_SEC, THIS_YEAR - 1, true, false, false },
        { WhiteWine.LOIRE_SEC, THIS_YEAR - 2, false, true, false },
        { WhiteWine.LOIRE_SEC, THIS_YEAR - 3, false, false, true },
        { WhiteWine.LOIRE_SEC, THIS_YEAR - 4, false, false, true },
        { WhiteWine.LOIRE_SEC, THIS_YEAR - 5, false, false, false },

        // Loire, moelleux et liquoreux 	3 ans 	4-9 ans 	10-20 ans 	+ 20 ans
        { WhiteWine.LOIRE_MOEL, THIS_YEAR, true, false, false },
        { WhiteWine.LOIRE_MOEL, THIS_YEAR - 3, true, false, false },
        { WhiteWine.LOIRE_MOEL, THIS_YEAR - 4, false, true, false },
        { WhiteWine.LOIRE_MOEL, THIS_YEAR - 9, false, true, false },
        { WhiteWine.LOIRE_MOEL, THIS_YEAR - 10, false, false, true },
        { WhiteWine.LOIRE_MOEL, THIS_YEAR - 20, false, false, true },
        { WhiteWine.LOIRE_MOEL, THIS_YEAR - 21, false, false, false },

        // Bordeaux, sec 	2 ans 	3-4 ans 	5-8 ans 	+ 8 ans
        { WhiteWine.BORDEAUX_SEC, THIS_YEAR, true, false, false },
        { WhiteWine.BORDEAUX_SEC, THIS_YEAR - 2, true, false, false },
        { WhiteWine.BORDEAUX_SEC, THIS_YEAR - 3, false, true, false },
        { WhiteWine.BORDEAUX_SEC, THIS_YEAR - 4, false, true, false },
        { WhiteWine.BORDEAUX_SEC, THIS_YEAR - 5, false, false, true },
        { WhiteWine.BORDEAUX_SEC, THIS_YEAR - 8, false, false, true },
        { WhiteWine.BORDEAUX_SEC, THIS_YEAR - 9, false, false, false },

        // Bordeaux, liquoreux 	6 ans 	7-14 ans 	15-20 ans 	+ 20 ans
        { WhiteWine.BORDEAUX_LIQ, THIS_YEAR, true, false, false },
        { WhiteWine.BORDEAUX_LIQ, THIS_YEAR - 6, true, false, false },
        { WhiteWine.BORDEAUX_LIQ, THIS_YEAR - 7, false, true, false },
        { WhiteWine.BORDEAUX_LIQ, THIS_YEAR - 14, false, true, false },
        { WhiteWine.BORDEAUX_LIQ, THIS_YEAR - 15, false, false, true },
        { WhiteWine.BORDEAUX_LIQ, THIS_YEAR - 20, false, false, true },
        { WhiteWine.BORDEAUX_LIQ, THIS_YEAR - 21, false, false, false },

        // Sud-Ouest, sec 	1 an 	2-3 ans 	4-5 ans 	+ 5 ans
        { WhiteWine.SUDOUEST_SEC, THIS_YEAR, true, false, false },
        { WhiteWine.SUDOUEST_SEC, THIS_YEAR - 1, true, false, false },
        { WhiteWine.SUDOUEST_SEC, THIS_YEAR - 2, false, true, false },
        { WhiteWine.SUDOUEST_SEC, THIS_YEAR - 3, false, true, false },
        { WhiteWine.SUDOUEST_SEC, THIS_YEAR - 4, false, false, true },
        { WhiteWine.SUDOUEST_SEC, THIS_YEAR - 5, false, false, true },
        { WhiteWine.SUDOUEST_SEC, THIS_YEAR - 6, false, false, false },

        // Sud-Ouest, liquoreux 	2 ans 	3-9 ans 	10-15 ans 	+ 15 ans
        { WhiteWine.SUDOUEST_LIQ, THIS_YEAR, true, false, false },
        { WhiteWine.SUDOUEST_LIQ, THIS_YEAR - 2, true, false, false },
        { WhiteWine.SUDOUEST_LIQ, THIS_YEAR - 3, false, true, false },
        { WhiteWine.SUDOUEST_LIQ, THIS_YEAR - 9, false, true, false },
        { WhiteWine.SUDOUEST_LIQ, THIS_YEAR - 10, false, false, true },
        { WhiteWine.SUDOUEST_LIQ, THIS_YEAR - 15, false, false, true },
        { WhiteWine.SUDOUEST_LIQ, THIS_YEAR - 16, false, false, false },

        // Languedoc & Provence 	1 an 	2 ans 	3 ans 	+ 3 ans
        { WhiteWine.LANGUEDOC_PROVENCE, THIS_YEAR, true, false, false },
        { WhiteWine.LANGUEDOC_PROVENCE, THIS_YEAR - 1, true, false, false },
        { WhiteWine.LANGUEDOC_PROVENCE, THIS_YEAR - 2, false, true, false },
        { WhiteWine.LANGUEDOC_PROVENCE, THIS_YEAR - 3, false, false, true },
        { WhiteWine.LANGUEDOC_PROVENCE, THIS_YEAR - 4, false, false, false },

        // Côtes du Rhône 	1 an 	2 ans 	3-4 ans 	+ 4 ans
        { WhiteWine.RHONE, THIS_YEAR, true, false, false },
        { WhiteWine.RHONE, THIS_YEAR - 1, true, false, false },
        { WhiteWine.RHONE, THIS_YEAR - 2, false, true, false },
        { WhiteWine.RHONE, THIS_YEAR - 3, false, false, true },
        { WhiteWine.RHONE, THIS_YEAR - 4, false, false, true },
        { WhiteWine.RHONE, THIS_YEAR - 5, false, false, false },

        // Bourgogne, Saône-et-Loire 	1 an 	2-3 ans 	4 ans 	+5 ans
        { WhiteWine.BOURGOGNE_SAONE, THIS_YEAR, true, false, false },
        { WhiteWine.BOURGOGNE_SAONE, THIS_YEAR - 1, true, false, false },
        { WhiteWine.BOURGOGNE_SAONE, THIS_YEAR - 2, false, true, false },
        { WhiteWine.BOURGOGNE_SAONE, THIS_YEAR - 3, false, true, false },
        { WhiteWine.BOURGOGNE_SAONE, THIS_YEAR - 4, false, false, true },
        { WhiteWine.BOURGOGNE_SAONE, THIS_YEAR - 5, false, false, false },

        // Bourgogne, Côte-d'Or 	3 ans 	4-6 ans 	7-10 ans 	+ 10 ans
        { WhiteWine.BOURGOGNE_COTE, THIS_YEAR, true, false, false },
        { WhiteWine.BOURGOGNE_COTE, THIS_YEAR - 3, true, false, false },
        { WhiteWine.BOURGOGNE_COTE, THIS_YEAR - 4, false, true, false },
        { WhiteWine.BOURGOGNE_COTE, THIS_YEAR - 6, false, true, false },
        { WhiteWine.BOURGOGNE_COTE, THIS_YEAR - 7, false, false, true },
        { WhiteWine.BOURGOGNE_COTE, THIS_YEAR - 10, false, false, true },
        { WhiteWine.BOURGOGNE_COTE, THIS_YEAR - 11, false, false, false },

        // Jura 	4 ans 	5-7 ans 	8-20 ans 	+ 20 ans
        { WhiteWine.JURA, THIS_YEAR, true, false, false },
        { WhiteWine.JURA, THIS_YEAR - 4, true, false, false },
        { WhiteWine.JURA, THIS_YEAR - 5, false, true, false },
        { WhiteWine.JURA, THIS_YEAR - 7, false, true, false },
        { WhiteWine.JURA, THIS_YEAR - 8, false, false, true },
        { WhiteWine.JURA, THIS_YEAR - 20, false, false, true },
        { WhiteWine.JURA, THIS_YEAR - 21, false, false, false },

        // Alsace 	1 an 	2-3 ans 	4-5 ans 	+ 5 ans
        { WhiteWine.ALSACE, THIS_YEAR, true, false, false },
        { WhiteWine.ALSACE, THIS_YEAR - 1, true, false, false },
        { WhiteWine.ALSACE, THIS_YEAR - 2, false, true, false },
        { WhiteWine.ALSACE, THIS_YEAR - 3, false, true, false },
        { WhiteWine.ALSACE, THIS_YEAR - 4, false, false, true },
        { WhiteWine.ALSACE, THIS_YEAR - 5, false, false, true },
        { WhiteWine.ALSACE, THIS_YEAR - 6, false, false, false },

        // Champagne 	1 an 	2 ans 	3 ans 	+ 3 ans
        { WhiteWine.CHAMPAGNE, THIS_YEAR, true, false, false },
        { WhiteWine.CHAMPAGNE, THIS_YEAR - 1, true, false, false },
        { WhiteWine.CHAMPAGNE, THIS_YEAR - 2, false, true, false },
        { WhiteWine.CHAMPAGNE, THIS_YEAR - 3, false, false, true },
        { WhiteWine.CHAMPAGNE, THIS_YEAR - 4, false, false, false },
    });
  }


  @Parameterized.Parameter
  public WhiteWine wine;

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