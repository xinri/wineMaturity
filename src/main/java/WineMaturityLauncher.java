import com.sun.javafx.collections.ImmutableObservableList;
import data.RedWine;
import data.WhiteWine;
import data.WineData;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.commons.lang3.math.NumberUtils;

import javax.annotation.Nonnull;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


/**
 * This is the launcher on javaFX. It is a draft before creating a front and a back end.
 *
 * TODO : remove all the magic number
 * TODO : some refactoring to do
 *
 * Created by hlay on 05/07/18.
 */
public class WineMaturityLauncher extends Application
{
  private static int ACTUAL_YEAR = LocalDate.now().getYear();

  private static final String RED_WINE = "Vin rouge";
  private static final String WHITE_WINE = "Vin blanc";

  private static final Map<String, ObservableList<WineData>> wineTypeMapWithData = new HashMap<>();

  private static final ObservableList<WineData> RED_WINES = new ImmutableObservableList<>(RedWine.values());
  private static final ObservableList<WineData> WHITE_WINES = new ImmutableObservableList<>(WhiteWine.values());

  static {
    wineTypeMapWithData.put(RED_WINE, RED_WINES);
    wineTypeMapWithData.put(WHITE_WINE, WHITE_WINES);
  }

  @Override
  public void start(@Nonnull final Stage primaryStage) throws Exception {
    primaryStage.setTitle("Maturité du vin");

    final TextArea textArea = new TextArea();
    final HBox wineTypeBox = createFirstLine(textArea);

    Pane rootGroup = createAndInitRootGroup(wineTypeBox, textArea);

    primaryStage.setScene(new Scene(rootGroup));
    primaryStage.show();
  }


  /**
   * Create the first line which is compose with
   * - the wine type (red or white)
   * - the name of area in which the wine was created (Bordeaux, Loire...)
   * - the year of the bottle
   * - a button to launch the application
   *
   * @return a HBox that is a container for the components.
   */
  private static HBox createFirstLine(TextArea textArea)
  {
    final ComboBox<String> wineTypeComboBox =
        new ComboBox<>(new ImmutableObservableList<>(new String[] { RED_WINE, WHITE_WINE }));
    wineTypeComboBox.setValue(RED_WINE);

    final ComboBox<WineData> wineComboBox = new ComboBox<>(RED_WINES);
    wineComboBox.setValue(RED_WINES.get(0));

    wineTypeComboBox.setOnAction(value ->
        wineComboBox.setItems(wineTypeMapWithData.get(wineTypeComboBox.getValue())));


    final Label wineTypeLabelField = new Label("Type de vin :");
    final Label wineAppelationLabelField = new Label("vin d'appelation : ");
    final Label dateLabelField = new Label("Date : ");
    final Spinner<Integer> yearSpinner = new Spinner<>(0, 4000, ACTUAL_YEAR);
    yearSpinner.setEditable(true);

    final Button run = new Button("Voir la maturité");

    run.setOnAction(value -> {
      Integer yearValue;
      if (yearSpinner.isEditable()) {
        if (!NumberUtils.isCreatable(yearSpinner.getEditor().getText())) {
          yearSpinner.getEditor().setText(String.valueOf(ACTUAL_YEAR));
          yearValue = ACTUAL_YEAR;
        }
        else {
          yearValue = Integer.valueOf(yearSpinner.getEditor().getText());
        }
      }
      else {
        yearValue = yearSpinner.getValueFactory().getValue();
      }
      textArea.setText(wineComboBox.getValue().displayMessage(yearValue));
    });

    HBox wineTypeBox = new HBox();
    wineTypeBox.getChildren().addAll(
        wineTypeLabelField, wineTypeComboBox,
        wineAppelationLabelField, wineComboBox,
        dateLabelField, yearSpinner,
        run);
    wineTypeBox.setSpacing(10);

    return wineTypeBox;
  }


  /**
   * Create the root pane and adding all the other pane inside it.
   *
   * @param wineTypeBox the first line which describe the type of the wine, the name, the year and a button
   * @param textArea the result output
   * @return the root Pane that will regroup the first line and the text area.
   */
  private static Pane createAndInitRootGroup(HBox wineTypeBox, TextArea textArea)
  {

    final GridPane gridPane = new GridPane();
    gridPane.setConstraints(wineTypeBox, 0, 0);
    gridPane.setConstraints(textArea, 0, 1);

    gridPane.getChildren().add(wineTypeBox);
    gridPane.getChildren().add(textArea);

    final Pane rootGroup = new VBox(10);
    rootGroup.setMinWidth(950);
    rootGroup.getChildren().add(gridPane);

    return rootGroup;
  }


  public static void main(String[] args) {
    launch(args);
  }
}
