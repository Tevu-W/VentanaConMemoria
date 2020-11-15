package dad.javafx.fxml.VentanaConMemoria;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

	VentanaConMemoriaController controller;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		controller = new VentanaConMemoriaController();
		
		Scene scene = new Scene(controller.getView(), 340, 164);
		
		Stage stage = new Stage();
		
		stage.setTitle("Ventana Con Memoria");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
