package data;

import java.util.function.Predicate;


/**
 * Interface for providing data on the wine.
 *
 * TODO : refactor this interface in order to retrieve the remaining year for the next step.
 *
 * Created by hlay on 05/07/18.
 */
public interface WineData
{
  /**
   * give where it comes from
   * @return the name where the wine comes from.
   */
  String getName();


  /**
   * A predicate that, when apply to the year, will tell if it is too young or not
   * @return Predicate to apply to an integer
   */
  Predicate<Integer> isTooYoung();


  /**
   * A predicate that, when apply to the year, will tell if it is mature or not
   * @return Predicate to apply to an integer
   */
  Predicate<Integer> isMature();


  /**
   * A predicate that, when apply to the year, will tell if it is at the peak (need to drink as soon as possible) or not
   * @return Predicate to apply to an integer
   */
  Predicate<Integer> isAtThePeak();


  default String displayMessage(int years)
  {
    return isTooYoung().test(years) ? "trop jeune pour être consommé" :
        isMature().test(years) ? "Vin mature mais pas encore au pic" :
            isAtThePeak().test(years) ? "vin à l'apogée, dégustez le rapidement" :
                "Vin en déclin. Buvable mais a déjà perdu son goût";
  }
}
