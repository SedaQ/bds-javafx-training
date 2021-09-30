package cz.vutbr.feec.fpga.controllers;

import cz.vutbr.feec.fpga.App;
import cz.vutbr.feec.fpga.exceptions.ExceptionHandler;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

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
    public ButtonBar chooseCryptoModuleButtonBar;
    @FXML
    public Button initAESModule;
    @FXML
    public Button initHashFunctionModule;
    @FXML
    public Button initEdDSAModule;
    @FXML
    public Button initDilithiumModule;
    @FXML
    public Button initCustomModule;
    @FXML
    public TextField chooseFPGATextField;
    @FXML
    public Button chooseFpgaButton;
    @FXML
    public MenuItem exitMenuItem;
    @FXML
    public BorderPane dashboardContent;
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

//        openContentInitialSettings(null);
    }

    private void loadIcons() {
        Image vutLogoImage = new Image(App.class.getResourceAsStream("logos/vut-logo-eng.png"));
        ImageView vutLogo = new ImageView(vutLogoImage);
        vutLogo.setFitWidth(150);
        vutLogo.setFitHeight(50);
        headerLogo1.setGraphic(vutLogo);
        Image netcopeImage = new Image(App.class.getResourceAsStream("logos/netcope-logo.png"));
        ImageView netcopeLogo = new ImageView(netcopeImage);
        netcopeLogo.setFitWidth(150);
        netcopeLogo.setFitHeight(50);
        headerLogo2.setGraphic(netcopeLogo);
        Image mvcrImage = new Image(App.class.getResourceAsStream("logos/mvcr-logo.png"));
        ImageView mvcrLogo = new ImageView(mvcrImage);
        mvcrLogo.setFitWidth(150);
        mvcrLogo.setFitHeight(50);
        headerLogo3.setGraphic(mvcrLogo);
    }

    public void handleExitMenuItem(ActionEvent event) {
        System.exit(0);
    }

    public void openContentInitialSettings(ActionEvent e) {
        try {
            BorderPane root = FXMLLoader.load(App.class.getResource("fxml/InitialSettings.fxml"));
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
            BorderPane root = FXMLLoader.load(App.class.getResource("fxml/EncryptionDecryptionContent.fxml"));
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
