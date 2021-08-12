package cz.vutbr.feec.fpga.controllers;

import cz.vutbr.feec.fpga.App;
import cz.vutbr.feec.fpga.services.AuthService;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class MainController {
    @FXML
    private VBox users;
    @FXML
    private MenuBar menuBar;
    @FXML
    private VBox usersTabPane;
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
//		GlyphsDude.setIcon(exportDataButton, FontAwesomeIcon.FILE_EXCEL_ALT/* , "6em" */);
//		exportDataButton.setTooltip(new Tooltip("Export table view to Excel."));
//		GlyphsDude.setIcon(importButton, FontAwesomeIcon.DATABASE/* , "6em" */);
//		importButton.setTooltip(new Tooltip("Import table from excel."));
//		GlyphsDude.setIcon(printButton, FontAwesomeIcon.FILE_PDF_ALT/* , "6em" */);
//		printButton.setTooltip(new Tooltip("Print data report."));
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
        String username = usernameTextfield.getText();
        String password = passwordTextField.getText();

        AuthService authService = new AuthService();
        boolean authenticated = authService.authenticate(username, password);
        if (authenticated) {
            // open new windows
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Unauthenticated");
            alert.setHeaderText("The user is not authenticated");
            alert.setContentText("Please provide a valid username and password");//ww  w . j  a  va2s  .  co  m

            alert.showAndWait();
        }
    }

}
