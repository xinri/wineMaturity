package data;

import java.util.function.Predicate;


/**
 * Created by hlay on 05/07/18.
 */
public enum RedWine implements WineData
{
  LOIRE("Loire", (year) -> WineYearUtils.isBeforeOrEquals(year, 1),
      (year) -> WineYearUtils.isBetweenInclusive(year, 2, 3),
      (year) -> WineYearUtils.isBetweenInclusive(year, 4, 6)),
  BORDEAUX("Bordeaux", (year) -> WineYearUtils.isBeforeOrEquals(year, 2),
      (year) -> WineYearUtils.isBetweenInclusive(year, 3, 4),
      (year) -> WineYearUtils.isBetweenInclusive(year, 5, 10)),
  BORDEAUX_GC("Bordeaux, grands crus", (year) -> WineYearUtils.isBeforeOrEquals(year, 5),
      (year) -> WineYearUtils.isBetweenInclusive(year, 6, 9),
      (year) -> WineYearUtils.isBetweenInclusive(year, 10, 20)),
  SUDOUEST("Sud-Ouest", (year) -> WineYearUtils.isBeforeOrEquals(year, 2),
      (year) -> WineYearUtils.isBetweenInclusive(year, 3, 4),
      (year) -> WineYearUtils.isBetweenInclusive(year, 5, 10)),
  LANGUEDOC_PROVENCE("Languedoc & Provence", (year) -> WineYearUtils.isBeforeOrEquals(year, 2),
      (year) -> WineYearUtils.isBetweenInclusive(year, 3, 4),
      (year) -> WineYearUtils.isBetweenInclusive(year, 5, 8)),
  RHONE("Côtes du Rhône", (year) -> WineYearUtils.isBeforeOrEquals(year, 1),
      (year) -> WineYearUtils.isBetweenInclusive(year, 2, 3),
      (year) -> WineYearUtils.isBetweenInclusive(year, 4, 6)),
  RHONE_GC("Côtes du Rhône, grands crus", (year) -> WineYearUtils.isBeforeOrEquals(year, 5),
      (year) -> WineYearUtils.isBetweenInclusive(year, 6, 9),
      (year) -> WineYearUtils.isBetweenInclusive(year, 10, 20)),
  BEAUJOLAIS("Beaujolais", (year) -> WineYearUtils.isBeforeOrEquals(year, 1),
      (year) -> WineYearUtils.isBetweenInclusive(year, 2, 3),
      (year) -> WineYearUtils.isBetweenInclusive(year, 4, 5)),
  BEAUJOLAIS_CRUS("Beaujolais, crus", (year) -> WineYearUtils.isBeforeOrEquals(year, 2),
      (year) -> WineYearUtils.isBetweenInclusive(year, 3, 4),
      (year) -> WineYearUtils.isBetweenInclusive(year, 5, 8)),
  BOURGOGNE_SAONE("Bourgogne, Saône-et-Loire", (year) -> WineYearUtils.isBeforeOrEquals(year, 2),
      (year) -> WineYearUtils.isBetweenInclusive(year, 3, 4),
      (year) -> WineYearUtils.isBetweenInclusive(year, 5, 10)),
  BOURGOGNE_COTE("Bourgogne, Côte-d'Or", (year) -> WineYearUtils.isBeforeOrEquals(year, 5),
      (year) -> WineYearUtils.isBetweenInclusive(year, 6, 9),
      (year) -> WineYearUtils.isBetweenInclusive(year, 10, 20));

  private String name;
  private Predicate<Integer> tooYoung;
  private Predicate<Integer> mature;
  private Predicate<Integer> atPeak;


  RedWine(final String name, final Predicate<Integer> tooYoung,
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
