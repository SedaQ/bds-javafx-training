package org.but.feec.javafx.controllers;

import org.but.feec.javafx.App;
import org.but.feec.javafx.exceptions.ExceptionHandler;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class DashboardController {
    
    @FXML
    public Button initialSettings;
    @FXML
    public Button encryptionDecryption;
    @FXML
    public Button hashFunction;
    @FXML
    public Button signingEdDSA;
    @FXML
    public Button signingDilithium;
    @FXML
    public MenuItem exitMenuItem;
    @FXML
    public Pane dashboardContent;
    @FXML
    public Label headerLogo1;
    @FXML
    public Label headerLogo2;
    @FXML
    public Label headerLogo3;
    @FXML
    public TextArea logTextArea;


    public DashboardController() {
    }

    @FXML
    private void initialize() {
        GlyphsDude.setIcon(exitMenuItem, FontAwesomeIcon.CLOSE, "1em");
        initialSettings.setStyle("-fx-background-color: #FFDC00;");
        encryptionDecryption.setStyle("-fx-background-color: #AAAAAA;");
        hashFunction.setStyle("-fx-background-color: #AAAAAA;");
        signingEdDSA.setStyle("-fx-background-color: #AAAAAA;");
        signingDilithium.setStyle("-fx-background-color: #AAAAAA;");

        loadIcons();
    }

    private void loadIcons() {
        Image vutLogoImage = new Image(App.class.getResourceAsStream("logos/vut-logo-eng.png"));
        ImageView vutLogo = new ImageView(vutLogoImage);
        vutLogo.setFitWidth(150);
        vutLogo.setFitHeight(50);
        headerLogo1.setGraphic(vutLogo);
    }

    public void handleExitMenuItem(ActionEvent event) {
        System.exit(0);
    }

    public void openContentInitialSettings(ActionEvent e) {
        try {
            Pane root = FXMLLoader.load(App.class.getResource("fxml/InitialSettings.fxml"));
            dashboardContent.getChildren().setAll(root);
            initialSettings.setStyle("-fx-background-color: #FFDC00;");
            encryptionDecryption.setStyle("-fx-background-color: #AAAAAA;");
            hashFunction.setStyle("-fx-background-color: #AAAAAA;");
            signingEdDSA.setStyle("-fx-background-color: #AAAAAA;");
            signingDilithium.setStyle("-fx-background-color: #AAAAAA;");
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }
    }

    public void openContentEncryptDecrypt(ActionEvent event) {
        try {
            Pane root = FXMLLoader.load(App.class.getResource("fxml/EncryptionDecryptionContent.fxml"));
            dashboardContent.getChildren().setAll(root);
            initialSettings.setStyle("-fx-background-color: #AAAAAA;");
            encryptionDecryption.setStyle("-fx-background-color: #FFDC00;");
            hashFunction.setStyle("-fx-background-color: #AAAAAA;");
            signingEdDSA.setStyle("-fx-background-color: #AAAAAA;");
            signingDilithium.setStyle("-fx-background-color: #AAAAAA;");
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }
    }

    public void openContentHashFunction(ActionEvent event) {
    }

    public void openContentSigningEdDSA(ActionEvent event) {

    }

    public void openContentSigninDilithium(ActionEvent event) {

    }

}
