package cz.vutbr.feec.fpga.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.*;

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
                    textAreaEncryptDecryptInput.setText(db.getFiles().toString());
                    success = true;
                }
                /* let the source know whether the string was successfully
                 * transferred and used */
                event.setDropCompleted(success);

                event.consume();
            }
        });
    }
}
