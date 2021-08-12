package cz.vutbr.feec.fpga.controllers;

import cz.vutbr.feec.fpga.App;
import cz.vutbr.feec.fpga.services.AuthService;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Optional;

public class MainController {
    @FXML
    private VBox fpga;
    @FXML
    private MenuBar menuBar;
    @FXML
    private Button signInButton;
    @FXML
    private TextField usernameTextfield;
    @FXML
    private PasswordField passwordTextField;

    // Reference to the main application.
    private App mainApp;

    public MainController() {
//		usersTabPaneController.ini
    }

    @FXML
    private void initialize() {
        GlyphsDude.setIcon(signInButton, FontAwesomeIcon.SIGN_IN, "1em");

        usernameTextfield.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                handleSignIn();
            }
        });
        passwordTextField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                handleSignIn();
            }
        });
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(App mainApp) {
        this.mainApp = mainApp;
    }

    public void signInActionHandler(ActionEvent event) {
        handleSignIn();
    }

    private void handleSignIn() {
        String username = usernameTextfield.getText();
        String password = passwordTextField.getText();

        AuthService authService = new AuthService();
        boolean authenticated = authService.authenticate(username, password);
        if (authenticated) {
            showDashboardWindow();
        } else {
            showInvalidPaswordDialog();
        }

    }

    private void showDashboardWindow() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../Dashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Demonstrator of HW Crypto Accelerator");
            stage.setScene(scene);

            Stage stageOld = (Stage) signInButton.getScene().getWindow();
            stageOld.close();

            authConfirmDialog();
            stage.show();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void showInvalidPaswordDialog() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Unauthenticated");
        alert.setHeaderText("The user is not authenticated");
        alert.setContentText("Please provide a valid username and password");//ww  w . j  a  va2s  .  co  m

        alert.showAndWait();
    }


    private void authConfirmDialog() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logging confirmation");
        alert.setHeaderText("You were successfully logged in.");
//        alert.setContentText("Are you ok with this?");

        Timeline idlestage = new Timeline(new KeyFrame(Duration.seconds(3), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                alert.setResult(ButtonType.CANCEL);
                alert.hide();
            }
        }));
        idlestage.setCycleCount(1);
        idlestage.play();

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            System.out.println("ok clicked");
        } else if (result.get() == ButtonType.CANCEL) {
            System.out.println("cancel clicked");
        }

    }


    public void handleOnEnterActionPassword(ActionEvent dragEvent) {
        handleSignIn();
    }
}