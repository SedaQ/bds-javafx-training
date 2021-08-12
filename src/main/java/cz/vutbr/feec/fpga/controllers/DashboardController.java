package cz.vutbr.feec.fpga.controllers;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
    public Button initEdDSAModule;
    @FXML
    public Button initDilithiumModule;
    @FXML
    public Button initCustomModule;
    @FXML
    public Button initHashFunctionModule;
    @FXML
    public TextField chooseFPGATextField;
    @FXML
    public Button chooseFpgaButton;
    @FXML
    public MenuItem exitMenuitem;
    @FXML
    public BorderPane dashboardContent;

    public DashboardController() {
    }

    @FXML
    private void initialize() {
        GlyphsDude.setIcon(exitMenuitem, FontAwesomeIcon.CLOSE, "1em");
    }


    public void handleExitMenuItem(ActionEvent event) {
        System.exit(0);
    }

    public void openContentEncryptDecrypt(ActionEvent event) {
        try {
            BorderPane root = FXMLLoader.load(getClass().getResource("../fxml/EncryptionDecryptionContent.fxml"));
            System.out.println("Root se nacetl... FXML je OK");
            System.out.println("Tohle je root: " + root);
            System.out.println();

            System.out.println("PRed set all...");
            dashboardContent.getChildren().setAll(root);
            System.out.println("Po sent all");
        } catch (Exception e) {
            System.out.println("WTF: " + e);
            System.out.println("Null pointer: " + e.getMessage());
        }
    }

    public void openContentHashFunction(ActionEvent event) {
    }

    public void openContentSigningEdDSA(ActionEvent event) {

    }

    public void openContentSigninDilithium(ActionEvent event) {

    }
}
