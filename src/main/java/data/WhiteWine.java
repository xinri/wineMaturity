package data;

import java.util.function.Predicate;


/**
 * Created by hlay on 05/07/18.
 */
public enum WhiteWine implements WineData
{
  LOIRE_SEC("Loire, sec", year -> WineYearUtils.isBeforeOrEquals(year, 1),
      year -> WineYearUtils.isEquals(year, 2),
      year -> WineYearUtils.isBetweenInclusive(year, 3, 4)),
  LOIRE_MOEL("Loire, moelleux et liquoreux", year -> WineYearUtils.isBeforeOrEquals(year, 3),
      year -> WineYearUtils.isBetweenInclusive(year, 4, 9),
      year -> WineYearUtils.isBetweenInclusive(year, 10, 20)),
  BORDEAUX_SEC("Bordeaux, sec", year -> WineYearUtils.isBeforeOrEquals(year, 2),
      year -> WineYearUtils.isBetweenInclusive(year, 3, 4),
      year -> WineYearUtils.isBetweenInclusive(year, 5, 8)),
  BORDEAUX_LIQ("Bordeaux, liquoreux", year -> WineYearUtils.isBeforeOrEquals(year, 6),
      year -> WineYearUtils.isBetweenInclusive(year, 7, 14),
      year -> WineYearUtils.isBetweenInclusive(year, 15, 20)),
  SUDOUEST_SEC("Sud-Ouest, sec", year -> WineYearUtils.isBeforeOrEquals(year, 1),
      year -> WineYearUtils.isBetweenInclusive(year, 2, 3),
      year -> WineYearUtils.isBetweenInclusive(year, 4, 5)),
  SUDOUEST_LIQ("Sud-Ouest, liquoreux", year -> WineYearUtils.isBeforeOrEquals(year, 2),
      year -> WineYearUtils.isBetweenInclusive(year, 3, 9),
      year -> WineYearUtils.isBetweenInclusive(year, 10, 15)),
  LANGUEDOC_PROVENCE("Languedoc & Provence", year -> WineYearUtils.isBeforeOrEquals(year, 1),
      year -> WineYearUtils.isEquals(year, 2),
      year -> WineYearUtils.isEquals(year, 3)),
  RHONE("Côtes du Rhône", year -> WineYearUtils.isBeforeOrEquals(year, 1),
      year -> WineYearUtils.isEquals(year, 2),
      year -> WineYearUtils.isBetweenInclusive(year, 3, 4)),
  BOURGOGNE_SAONE("Bourgogne, Saône-et-Loire", year -> WineYearUtils.isBeforeOrEquals(year, 1),
      year -> WineYearUtils.isBetweenInclusive(year, 2, 3),
      year -> WineYearUtils.isEquals(year, 4)),
  BOURGOGNE_COTE("Bourgogne, Côte-d'Or", year -> WineYearUtils.isBeforeOrEquals(year, 3),
      year -> WineYearUtils.isBetweenInclusive(year, 4, 6),
      year -> WineYearUtils.isBetweenInclusive(year, 7, 10)),
  JURA("Jura", year -> WineYearUtils.isBeforeOrEquals(year, 4),
      year -> WineYearUtils.isBetweenInclusive(year, 5, 7),
      year -> WineYearUtils.isBetweenInclusive(year, 8, 20)),
  ALSACE("Alsace", year -> WineYearUtils.isBeforeOrEquals(year, 1),
      year -> WineYearUtils.isBetweenInclusive(year, 2, 3),
      year -> WineYearUtils.isBetweenInclusive(year, 4, 5)),
  CHAMPAGNE("Champagne", year -> WineYearUtils.isBeforeOrEquals(year, 1),
      year -> WineYearUtils.isEquals(year, 2),
      year -> WineYearUtils.isEquals(year, 3));

  private String name;
  private Predicate<Integer> tooYoung;
  private Predicate<Integer> mature;
  private Predicate<Integer> atPeak;


  WhiteWine(final String name, final Predicate<Integer> tooYoung,
            final Predicate<Integer> mature, final Predicate<Integer> atPeak)
  {
    this.name = name;
    this.tooYoung = tooYoung;
    this.mature = mature;
    this.atPeak = atPeak;
  }


  @Override
  public String getName() {
    return name;
  }


  @Override
  public Predicate<Integer> isTooYoung() {
    return tooYoung;
  }


  @Override
  public Predicate<Integer> isMature() {
    return mature;
  }


  @Override
  public Predicate<Integer> isAtThePeak() {
    return atPeak;
  }


  @Override
  public String toString()
  {
    return name;
  }
}
