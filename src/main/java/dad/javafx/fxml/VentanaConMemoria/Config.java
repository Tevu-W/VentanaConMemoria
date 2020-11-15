package dad.javafx.fxml.VentanaConMemoria;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Config {

	private String rutaDirectorio;
	private String rutaFichero;

	private DoubleProperty red;
	private DoubleProperty blue;
	private DoubleProperty green;
	private DoubleProperty width;
	private DoubleProperty height;
	private DoubleProperty locationX;
	private DoubleProperty locationY;

	public Config() {
		rutaDirectorio = System.getProperty("user.home") + File.separator + ".VentanaConMemoria";
		rutaFichero = rutaDirectorio + File.separator + "ventana.config";

		red = new SimpleDoubleProperty();
		blue = new SimpleDoubleProperty();
		green = new SimpleDoubleProperty();
		width = new SimpleDoubleProperty();
		height = new SimpleDoubleProperty();
		locationX = new SimpleDoubleProperty();
		locationY = new SimpleDoubleProperty();
	}

	public void guardarFichero() {

		try (OutputStream output = new FileOutputStream(rutaFichero)) {

			Properties prop = new Properties();

			prop.setProperty("background.red", red.get() + "");
			prop.setProperty("background.blue", blue.get() + "");
			prop.setProperty("background.green", green.get() + "");
			prop.setProperty("size.width", width.get() + "");
			prop.setProperty("size.height", height.get() + "");
			prop.setProperty("location.x", locationX.get() + "");
			prop.setProperty("location.y", locationY.get() + "");

			prop.store(output, null);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void cargarFichero() throws IOException {

		File directorio = new File(rutaDirectorio);
		directorio.mkdir();

		File ficherito = new File(rutaFichero);
		
		
		if (ficherito.createNewFile()) {
			try (OutputStream output = new FileOutputStream(ficherito.getPath())) {
				Properties prop = new Properties();

				prop.setProperty("background.red", "255");
				prop.setProperty("background.blue", "255");
				prop.setProperty("background.green", "255");
				prop.setProperty("size.width", "340");
				prop.setProperty("size.height", "164");
				prop.setProperty("location.x", "440");
				prop.setProperty("location.y", "244");

				prop.store(output, null);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	public void setProperties() {

		try (InputStream input = new FileInputStream(rutaFichero)) {

			Properties prop = new Properties();

			// load a properties file
			prop.load(input);

			red.set(Double.parseDouble(prop.getProperty("background.red")));
			blue.set(Double.parseDouble(prop.getProperty("background.blue")));
			green.set(Double.parseDouble(prop.getProperty("background.green")));
			width.set(Double.parseDouble(prop.getProperty("size.width")));
			height.set(Double.parseDouble(prop.getProperty("size.height")));
			locationX.set(Double.parseDouble(prop.getProperty("location.x")));
			locationY.set(Double.parseDouble(prop.getProperty("location.y")));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public final DoubleProperty redProperty() {
		return this.red;
	}

	public final double getRed() {
		return this.redProperty().get();
	}

	public final void setRed(final double red) {
		this.redProperty().set(red);
	}

	public final DoubleProperty blueProperty() {
		return this.blue;
	}

	public final double getBlue() {
		return this.blueProperty().get();
	}

	public final void setBlue(final double blue) {
		this.blueProperty().set(blue);
	}

	public final DoubleProperty greenProperty() {
		return this.green;
	}

	public final double getGreen() {
		return this.greenProperty().get();
	}

	public final void setGreen(final double green) {
		this.greenProperty().set(green);
	}

	public final DoubleProperty widthProperty() {
		return this.width;
	}

	public final double getWidth() {
		return this.widthProperty().get();
	}

	public final void setWidth(final double width) {
		this.widthProperty().set(width);
	}

	public final DoubleProperty heightProperty() {
		return this.height;
	}

	public final double getHeight() {
		return this.heightProperty().get();
	}

	public final void setHeight(final double height) {
		this.heightProperty().set(height);
	}

	public final DoubleProperty locationXProperty() {
		return this.locationX;
	}

	public final double getLocationX() {
		return this.locationXProperty().get();
	}

	public final void setLocationX(final double locationX) {
		this.locationXProperty().set(locationX);
	}

	public final DoubleProperty locationYProperty() {
		return this.locationY;
	}

	public final double getLocationY() {
		return this.locationYProperty().get();
	}

	public final void setLocationY(final double locationY) {
		this.locationYProperty().set(locationY);
	}

}
