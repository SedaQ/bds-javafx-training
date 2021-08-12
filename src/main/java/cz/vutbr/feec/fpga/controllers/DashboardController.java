package cz.vutbr.feec.fpga.controllers;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    public TabPane dashboardTabPane;
    @FXML
    public TextField chooseFPGATextField;
    @FXML
    public Tab aesTab;
    @FXML
    public Tab hashFunctionsTab;
    @FXML
    public Tab eddsaTab;
    @FXML
    public Tab dilithiumTab;
    @FXML
    public Tab initialSettingsTab;
    @FXML
    public Button chooseFpgaButton;
    @FXML
    public MenuItem exitMenuitem;

    public DashboardController() {
//		usersTabPaneController.ini
    }

    @FXML
    private void initialize() {
        GlyphsDude.setIcon(exitMenuitem, FontAwesomeIcon.CLOSE, "1em");

    }


    public void handleExitMenuItem(ActionEvent event) {
        System.exit(0);
    }
}
