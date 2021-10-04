package cz.vutbr.feec.fpga.controllers;

import cz.vutbr.feec.fpga.exceptions.ExceptionHandler;
import cz.vutbr.feec.fpga.ndk.FpgaServiceImpl;
import cz.vutbr.feec.service.FPGAWrapperServiceImpl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.stage.FileChooser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.File;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

import static cz.vutbr.feec.fpga.data.FpgaInitHolder.filesStorageFolder;

public class EncryptionDecryptionContentController {

    @FXML
    public TextArea textAreaEncryptDecryptInput;
    @FXML
    public TextArea textAreaEncryptDecryptOutput;
    @FXML
    public Button takeInputDataAndEncrypt;
    @FXML
    public Button takeInputDataAndDecrypt;
    @FXML
    public TextArea logTextArea;
    @FXML
    public TextArea textAreaEncryptionKey;
    @FXML
    public Button chooseEncryptionKey;
    @FXML
    public Button chooseInputFile;
    @FXML
    public Button loadEncryptionKey;

    @FXML
    private void initialize() {
        textAreaEncryptDecryptInput.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                if (event.getGestureSource() != textAreaEncryptDecryptInput
                        && event.getDragboard().hasFiles()) {
                    /* allow for both copying and moving, whatever user chooses */
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });

        textAreaEncryptDecryptInput.setOnDragDropped(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasFiles()) {
                    textAreaEncryptDecryptInput.setText(db.getFiles().get(0).toString());
                    success = true;
                }
                /* let the source know whether the string was successfully
                 * transferred and used */
                event.setDropCompleted(success);
                event.consume();
            }
        });

        FileChooser fileChooser = new FileChooser();

        chooseEncryptionKey.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(chooseEncryptionKey.getScene().getWindow());
            textAreaEncryptionKey.setText(selectedFile.getAbsolutePath());

        });

        chooseInputFile.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(chooseEncryptionKey.getScene().getWindow());
            textAreaEncryptDecryptInput.setText(selectedFile.getAbsolutePath());
        });

    }

    public void handleAESEncryption(ActionEvent event) {
        try {
            logTextArea.setText("");
            Instant start = Instant.now();
            byte[] fileToEncrypt = Files.readAllBytes(Paths.get(textAreaEncryptDecryptInput.getText()));
            FPGAWrapperServiceImpl fpgaWrapperService = FpgaServiceImpl.getFpgaWrapperService();
            byte[] encryptedFile = fpgaWrapperService.encryptAES(InitSettingsController.ndkPointerInitAesEnc, fileToEncrypt);
            Instant end = Instant.now();

            Path resultingPath = filesStorageFolder.resolve("aes-encryption_" + UUID.randomUUID());
            Files.write(resultingPath, encryptedFile);

            textAreaEncryptDecryptOutput.setText(resultingPath.toAbsolutePath().toString());
            logTextArea.setText("Encryption operation is successful (file size (in bytes): " + encryptedFile.length + ", time of op.: " + Duration.between(end, start).toMillis() + " ms");
        } catch (IOException | NullPointerException io) {
            logTextArea.setText("Encryption operation is not successful");
            ExceptionHandler.handleException(io);
        }
    }

    public void handleAESDecryption(ActionEvent event) {
        try {
            logTextArea.setText("");
            Instant start = Instant.now();
            byte[] fileToDecrypt = Files.readAllBytes(Paths.get(textAreaEncryptDecryptOutput.getText()));
            FPGAWrapperServiceImpl fpgaWrapperService = FpgaServiceImpl.getFpgaWrapperService();
            byte[] decryptedFile = fpgaWrapperService.decryptAES(InitSettingsController.ndkPointerInitAesEnc, fileToDecrypt);
            Instant end = Instant.now();

            Path resultingPath = filesStorageFolder.resolve("aes-decryption" + UUID.randomUUID());
            Files.write(resultingPath, decryptedFile);

            textAreaEncryptDecryptOutput.setText(resultingPath.toAbsolutePath().toString());
            logTextArea.setText("Decryption operation is successful (file size (in bytes): " + decryptedFile.length + ", time of op.: " + Duration.between(end, start).toMillis() + " ms");

        } catch (IOException | NullPointerException io) {
            logTextArea.setText("Decryption operation is not successful");
            ExceptionHandler.handleException(io);
        }
    }

    public void handleLoadEncryptionKey(ActionEvent event) {
        logTextArea.setText("Encryption key loaded. (not implemented yet..)");
    }
}
