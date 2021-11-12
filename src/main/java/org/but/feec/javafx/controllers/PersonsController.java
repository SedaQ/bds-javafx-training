package org.but.feec.javafx.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import org.but.feec.javafx.App;
import org.but.feec.javafx.api.PersonBasicView;
import org.but.feec.javafx.data.PersonRepository;
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
import org.but.feec.javafx.services.PersonService;

import java.util.List;

public class PersonsController {

    @FXML
    private TableColumn<PersonBasicView, Long> personsId;
    @FXML
    private TableColumn<PersonBasicView, String> personsCity;
    @FXML
    private TableColumn<PersonBasicView, String> personsEmail;
    @FXML
    private TableColumn<PersonBasicView, String> personsFamilyName;
    @FXML
    private TableColumn<PersonBasicView, String> personsGivenName;
    @FXML
    private TableView<PersonBasicView> systemPersonsTableView;
//    @FXML
//    public MenuItem exitMenuItem;

    private PersonService personService;
    private PersonRepository personRepository;

    public PersonsController() {
    }

    @FXML
    private void initialize() {
        personRepository = new PersonRepository();
        personService = new PersonService(personRepository);

//        GlyphsDude.setIcon(exitMenuItem, FontAwesomeIcon.CLOSE, "1em");

        personsId.setCellValueFactory(new PropertyValueFactory<PersonBasicView, Long>("id"));
        personsCity.setCellValueFactory(new PropertyValueFactory<PersonBasicView, String>("city"));
        personsEmail.setCellValueFactory(new PropertyValueFactory<PersonBasicView, String>("email"));
        personsFamilyName.setCellValueFactory(new PropertyValueFactory<PersonBasicView, String>("givenName"));
        personsGivenName.setCellValueFactory(new PropertyValueFactory<PersonBasicView, String>("givenName"));


        ObservableList<PersonBasicView> observablePersonsList = initializePersonsData();
        systemPersonsTableView.setItems(observablePersonsList);

        loadIcons();
    }

    private ObservableList<PersonBasicView> initializePersonsData() {
        List<PersonBasicView> persons = personService.getPersonsBasicView();
        persons.forEach(p -> System.out.println(p.getEmail()));
        return FXCollections.observableArrayList(persons);
    }

    private void loadIcons() {
        Image vutLogoImage = new Image(App.class.getResourceAsStream("logos/vut-logo-eng.png"));
        ImageView vutLogo = new ImageView(vutLogoImage);
        vutLogo.setFitWidth(150);
        vutLogo.setFitHeight(50);
    }

    public void handleExitMenuItem(ActionEvent event) {
        System.exit(0);
    }

    public void openContentEncryptDecrypt(ActionEvent event) {
        try {
            Pane root = FXMLLoader.load(App.class.getResource("fxml/EncryptionDecryptionContent.fxml"));
//            dashboardContent.getChildren().setAll(root);
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }
    }

}
