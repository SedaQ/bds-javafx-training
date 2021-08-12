package cz.vutbr.feec.fpga;

import cz.vutbr.feec.fpga.controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * 
 * @author Pavel Šeda
 *
 */
public class App extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("App.fxml"));
		VBox mainStage = loader.load();

		loader.setControllerFactory(initControllerFactory());

		primaryStage.setTitle("Demonstrator of HW Crypto Accelerator");
		Scene scene = new Scene(mainStage);
		setUserAgentStylesheet(STYLESHEET_MODENA);
		String myStyle = getClass().getResource("css/myStyle.css").toExternalForm();
		scene.getStylesheets().add(myStyle);

		primaryStage.getIcons().add(new Image(App.class.getResourceAsStream("logos/vut.jpg")));
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private Callback<Class<?>, Object> initControllerFactory() {
		return type -> {
			if (type == App.class) {
				return new MainController();
			} else {
				try {
					return type.newInstance();
				} catch (Exception exc) {
					exc.printStackTrace();
					throw new RuntimeException(exc); // fatal, just bail...
				}
			}
		};
	}

}