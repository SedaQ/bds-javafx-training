package cz.vutbr.feec.fpga;

import com.sun.jna.Pointer;
import cz.vutbr.feec.fpga.controllers.MainController;
import cz.vutbr.feec.fpga.exceptions.ExceptionHandler;
import cz.vutbr.feec.fpga.ndk.NdkPointer;
import cz.vutbr.feec.service.FPGAWrapperServiceImpl;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * @author Pavel Šeda
 */
public class App extends Application {

    private FXMLLoader loader;
    private VBox mainStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            NdkPointer.initializeNdkAndGetPointer();
            loader = new FXMLLoader(getClass().getResource("App.fxml"));
            mainStage = loader.load();

            loader.setControllerFactory(initControllerFactory());

            primaryStage.setTitle("Demonstrator of HW Crypto Accelerator");
            Scene scene = new Scene(mainStage);
            setUserAgentStylesheet(STYLESHEET_MODENA);
            String myStyle = getClass().getResource("css/myStyle.css").toExternalForm();
            scene.getStylesheets().add(myStyle);

            primaryStage.getIcons().add(new Image(App.class.getResourceAsStream("logos/vut.jpg")));
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }
    }

    private Callback<Class<?>, Object> initControllerFactory() {
        return type -> {
            if (type == App.class) {
                return new MainController();
            } else {
                try {
                    return type.newInstance();
                } catch (Exception ex) {
                    throw new RuntimeException(ex); // fatal, just bail...
                }
            }
        };
    }

}