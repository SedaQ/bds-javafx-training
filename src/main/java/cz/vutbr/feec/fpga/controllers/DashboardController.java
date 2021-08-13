package cz.vutbr.feec.fpga.controllers;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
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
    @FXML
    public TextArea textAreaEncryptDecryptInput;
    @FXML
    public TextArea textAreaEncryptDecryptOutput;
    @FXML
    public Button takeInputDataAndEncrypt;
    @FXML
    public Button takeInputDataAndDecrypt;

    public DashboardController() {
    }

    @FXML
    private void initialize() {
        GlyphsDude.setIcon(exitMenuItem, FontAwesomeIcon.CLOSE, "1em");
//        textAreaEncryptDecrypt.setText("Test");
//        textAreaEncryptDecrypt.setOnDragDetected((event) -> {
//            /* drag was detected, start a drag-and-drop gesture*/
//            /* allow any transfer mode */
//            Dragboard db = textAreaEncryptDecrypt.startDragAndDrop(TransferMode.ANY);
//
//            /* Put a string on a dragboard */
//            ClipboardContent content = new ClipboardContent();
//            content.putString(textAreaEncryptDecrypt.getText());
//            db.setContent(content);
//
//            event.consume();
//        });
    }


    public void handleExitMenuItem(ActionEvent event) {
        System.exit(0);
    }

    public void openContentInitialSettings(ActionEvent e) {
        try {
            BorderPane root = FXMLLoader.load(getClass().getResource("../fxml/InitialSettings.fxml"));
            dashboardContent.getChildren().setAll(root);

            dashboardContent.setOnDragDetected(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {
                    /* drag was detected, start a drag-and-drop gesture*/
                    /* allow any transfer mode */
                    Dragboard db = dashboardContent.startDragAndDrop(TransferMode.ANY);

                    /* Put a string on a dragboard */
                    ClipboardContent content = new ClipboardContent();
                    content.putString("Test String");
                    db.setContent(content);

                    event.consume();
                }
            });

//            textAreaEncryptDecryptInput.setOnDragOver(event -> {
//                event.acceptTransferModes(TransferMode.ANY);
//                Dragboard db = event.getDragboard();
//                boolean success = false;
//                if (db.hasString()) {
//                    textAreaEncryptDecryptInput.setText(db.getString());
//                    success = true;
//                }
//                /* let the source know whether the string was successfully
//                 * transferred and used */
//                event.setDropCompleted(success);
//
//                event.consume();            });
        } catch (Exception ex) {
            System.out.println("WTF: " + ex);
            System.out.println("Null pointer: " + ex.getMessage());
        }
    }

    public void openContentEncryptDecrypt(ActionEvent event) {
        try {
            BorderPane root = FXMLLoader.load(getClass().getResource("../fxml/EncryptionDecryptionContent.fxml"));
            dashboardContent.getChildren().setAll(root);

//            textAreaEncryptDecrypt.setOnDragOver(e -> {
//                e.acceptTransferModes(TransferMode.ANY);
//            });
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
