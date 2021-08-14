package cz.vutbr.feec.fpga.controllers;

import cz.vutbr.feec.fpga.exceptions.ExceptionHandler;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.BorderPane;

import javax.swing.*;

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

    public DashboardController() {
    }

    @FXML
    private void initialize() {
        GlyphsDude.setIcon(exitMenuItem, FontAwesomeIcon.CLOSE, "1em");
    }


    public void handleExitMenuItem(ActionEvent event) {
        System.exit(0);
    }

    public void openContentInitialSettings(ActionEvent e) {
        try {
            BorderPane root = FXMLLoader.load(getClass().getResource("../fxml/InitialSettings.fxml"));
            dashboardContent.getChildren().setAll(root);
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }
    }

    public void openContentEncryptDecrypt(ActionEvent event) {
        try {
            BorderPane root = FXMLLoader.load(getClass().getResource("../fxml/EncryptionDecryptionContent.fxml"));
            dashboardContent.getChildren().setAll(root);
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
