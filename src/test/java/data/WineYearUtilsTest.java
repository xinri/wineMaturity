package data;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Created by hlay on 06/07/18.
 */
public class WineYearUtilsTest
{
  @Test
  public void beforeOrEqualsIsBefore() {
    // given
    int delta = 0;
    int yearOfTheBottle = LocalDate.now().getYear() - 1;

    // when
    boolean result = WineYearUtils.isBeforeOrEquals(yearOfTheBottle, delta);

    // then
    assertThat(true, is(result));
  }


  @Test
  public void beforeOrEqualsIsEquals() {
    // given
    int delta = 1;
    int yearOfTheBottle = LocalDate.now().getYear() - delta;

    // when
    boolean result = WineYearUtils.isBeforeOrEquals(yearOfTheBottle, delta);

    // then
    assertThat(true, is(result));
  }


  @Test
  public void beforeOrEqualsIsAfter() {
    // given
    int delta = 1;
    int yearOfTheBottle = LocalDate.now().getYear() + 2;

    // when
    boolean result = WineYearUtils.isBeforeOrEquals(yearOfTheBottle, delta);

    // then
    assertThat(false, is(result));
  }


  @Test
  public void isBetweenBefore() {
    // given
    int delta1 = 1;
    int delta2 = 3;
    int yearOfTheBottle = LocalDate.now().getYear();

    // when
    boolean result = WineYearUtils.isBetweenInclusive(yearOfTheBottle, delta1, delta2);

    // then
    assertThat(false, is(result));
  }


  @Test
  public void isBetweenEqualsDelta1() {
    // given
    int delta1 = 1;
    int delta2 = 3;
    int yearOfTheBottle = LocalDate.now().getYear() - 1;

    // when
    boolean result = WineYearUtils.isBetweenInclusive(yearOfTheBottle, delta1, delta2);

    // then
    assertThat(true, is(result));
  }


  @Test
  public void isBetween() {
    // given
    int delta1 = 1;
    int delta2 = 3;
    int yearOfTheBottle = LocalDate.now().getYear() - 2;

    // when
    boolean result = WineYearUtils.isBetweenInclusive(yearOfTheBottle, delta1, delta2);

    // then
    assertThat(true, is(result));
  }


  @Test
  public void isBetweenEqualsDelta2() {
    // given
    int delta1 = 1;
    int delta2 = 3;
    int yearOfTheBottle = LocalDate.now().getYear() - 3;

    // when
    boolean result = WineYearUtils.isBetweenInclusive(yearOfTheBottle, delta1, delta2);

    // then
    assertThat(true, is(result));
  }


  @Test
  public void isBetweenAfter() {
    // given
    int delta1 = 1;
    int delta2 = 3;
    int yearOfTheBottle = LocalDate.now().getYear() - 4;

    // when
    boolean result = WineYearUtils.isBetweenInclusive(yearOfTheBottle, delta1, delta2);

    // then
    assertThat(false, is(result));
  }
}

