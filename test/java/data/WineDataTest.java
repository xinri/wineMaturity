package data;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;


/**
 * Created by hlay on 14/07/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class WineDataTest
{
  private final static Predicate<Integer> alwaysTrue = (value) -> true;
  private final static Predicate<Integer> alawysFalse = (value) -> false;

  @Spy
  private WineData wineData = new FakeWineData();


  @Before
  public void setup()
  {
    given(wineData.isTooYoung()).willReturn(alawysFalse);
    given(wineData.isMature()).willReturn(alawysFalse);
    given(wineData.isAtThePeak()).willReturn(alawysFalse);

  }


  @Test
  public void displayMessageWineTooYoung() throws Exception {
    // given
    given(wineData.isTooYoung()).willReturn(alwaysTrue);

    // when
    String result = wineData.displayMessage(0);

    // then
    assertEquals("trop jeune pour être consommé", result);
  }


  @Test
  public void displayMessageWineMature() throws Exception {
    // given
    given(wineData.isMature()).willReturn(alwaysTrue);

    // when
    String result = wineData.displayMessage(0);

    // then
    assertEquals("Vin mature mais pas encore au pic", result);
  }


  @Test
  public void displayMessageWineTooPeak() throws Exception {
    // given
    given(wineData.isAtThePeak()).willReturn(alwaysTrue);

    // when
    String result = wineData.displayMessage(0);

    // then
    assertEquals("vin à l'apogée, dégustez le rapidement", result);
  }


  @Test
  public void displayMessageWineTooOld() throws Exception {
    // given

    // when
    String result = wineData.displayMessage(0);

    // then
    assertEquals("Vin en déclin. Buvable mais a déjà perdu son goût", result);
  }


  static class FakeWineData implements WineData
  {

    @Override
    public String getName() {
      return null;
    }


    @Override
    public Predicate<Integer> isTooYoung() {
      return alawysFalse;
    }


    @Override
    public Predicate<Integer> isMature() {
      return alawysFalse;
    }


    @Override
    public Predicate<Integer> isAtThePeak() {
      return alawysFalse;
    }
  }
}