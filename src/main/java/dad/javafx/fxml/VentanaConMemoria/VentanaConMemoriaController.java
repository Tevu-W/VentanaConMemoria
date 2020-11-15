package dad.javafx.fxml.VentanaConMemoria;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;

public class VentanaConMemoriaController implements Initializable {

	@FXML
	private GridPane view;

	@FXML
	private Slider redSlider;

	@FXML
	private Slider greenSlider;

	@FXML
	private Slider blueSlider;

	VentanaConMemoriaModel model = new VentanaConMemoriaModel();

	public VentanaConMemoriaController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		model.redProperty().bindBidirectional(redSlider.valueProperty());
		model.blueProperty().bindBidirectional(blueSlider.valueProperty());
		model.greenProperty().bindBidirectional(greenSlider.valueProperty());

		redSlider.valueProperty().addListener((o, ov, nv) -> {
			view.setStyle("-fx-background-color: rgb(" + redSlider.getValue() + "," + greenSlider.getValue() + ", "
					+ blueSlider.getValue() + ");");
			// System.out.println(redSlider.getValue());
			System.out.println(System.getProperty("user.home")); // C:\Users\Tevu
		});

		greenSlider.valueProperty().addListener((o, ov, nv) -> {
			view.setStyle("-fx-background-color: rgb(" + redSlider.getValue() + "," + greenSlider.getValue() + ", "
					+ blueSlider.getValue() + ");");
			// System.out.println(greenSlider.getValue());
		});

		blueSlider.valueProperty().addListener((o, ov, nv) -> {
			view.setStyle("-fx-background-color: rgb(" + redSlider.getValue() + "," + greenSlider.getValue() + ", "
					+ blueSlider.getValue() + ");");
			// System.out.println(blueSlider.getValue());
		});

	}

	public GridPane getView() {
		return view;
	}

}
