package dad.javafx.fxml.VentanaConMemoria;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	private VentanaConMemoriaController controller;
	private Config config = new Config();

	@Override
	public void init() throws Exception {
		config.cargarFichero();
		config.setProperties();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		controller = new VentanaConMemoriaController();

		controller.model.redProperty().bindBidirectional(config.redProperty());
		controller.model.greenProperty().bindBidirectional(config.greenProperty());
		controller.model.blueProperty().bindBidirectional(config.blueProperty());

		Scene scene = new Scene(controller.getView(), config.getWidth(), config.getHeight());

		config.heightProperty().bind(scene.heightProperty());
		config.widthProperty().bind(scene.widthProperty());

		Stage stage = new Stage();

		stage.setX(config.getLocationX());
		stage.setY(config.getLocationY());

		config.locationXProperty().bind(stage.xProperty());
		config.locationYProperty().bind(stage.yProperty());

		stage.setTitle("Ventana Con Memoria");
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void stop() throws Exception {
		config.guardarFichero();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
