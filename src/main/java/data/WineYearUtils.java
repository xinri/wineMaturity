package data;

import java.time.LocalDate;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;


/**
 * Created by hlay on 06/07/18.
 */
public final class WineYearUtils
{
  private WineYearUtils() {
    throw new IllegalStateException("reflection not allowed");
  }

  /**
   * return if today is before or equals to the year of the bottle + a delta
   *
   * @param years is the year of the bottle
   * @param delta is the number of year to reach a state
   *
   * @return a BiPredicate to apply with the two argument
   */
  public static boolean isBeforeOrEquals(int years, int delta) {
    return LocalDate.now().getYear() - years <= delta;
  }


  /**
   * return if today is between (inclusive) the year of the bottle + delta1 and + delta2.
   *
   * @param years is years of the bottle.
   * @Param delta1 is the number of year to reach the state
   * @Param delta2 is the limit number of year to stay in the state
   * @return a boolean if it is between or not.
   */
  public static boolean isBetweenInclusive(int years, int delta1, int delta2) {
    return (LocalDate.now().getYear() - years >= delta1) && (LocalDate.now().getYear() - years <= delta2);
  }


  /**
   * for equality
   *
   * @param years is years of the bottle.
   * @param delta is the number of year to reach a state
   * @return a boolean if it is equals to the delta with the years
   */
  public static boolean isEquals(int years, int delta) {
    return LocalDate.now().getYear() - years == delta;
  }
}
