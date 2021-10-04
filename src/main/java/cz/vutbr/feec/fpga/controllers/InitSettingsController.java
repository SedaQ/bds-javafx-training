package cz.vutbr.feec.fpga.controllers;

import com.sun.jna.Pointer;
import cz.vutbr.feec.fpga.data.FpgaInitHolder;
import cz.vutbr.feec.fpga.enums.SupportedFunctions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class InitSettingsController {

    public static Pointer ndkPointerInitAesEnc;
    public static Pointer getNdkPointerInitAesDec;

    @FXML
    public TextArea logTextArea;
    @FXML
    public ButtonBar chooseCryptoModuleButtonBar;
    @FXML
    public ComboBox comboboxInitFunctions;

    @FXML
    private void initialize() {
        if (comboboxInitFunctions != null && comboboxInitFunctions.getItems() != null) {
            comboboxInitFunctions.getItems().addAll(
                    SupportedFunctions.AES.getDescription(),
                    SupportedFunctions.HASH_FUNCTION.getDescription(),
                    SupportedFunctions.DILITHIUM_MODULE.getDescription(),
                    SupportedFunctions.EDDSA_MODULE.getDescription(),
                    SupportedFunctions.CUSTOM_MODULE.getDescription()
            );
            comboboxInitFunctions.getSelectionModel().select(0);
        }
    }

    public void handleInitFunction(ActionEvent event) {
        if (comboboxInitFunctions.getSelectionModel().getSelectedItem().equals(SupportedFunctions.AES.getDescription())) {
            logTextArea.setText("AES function initialized");
//            ndkPointerInitAesEnc = FpgaServiceImpl.getFpgaWrapperService().initAESEncryption(0);
//            getNdkPointerInitAesDec = FpgaServiceImpl.getFpgaWrapperService().initAESDecryption(1);
            FpgaInitHolder.isAesInitialized = true;
        } else if (comboboxInitFunctions.getSelectionModel().getSelectedItem().equals(SupportedFunctions.HASH_FUNCTION.getDescription())) {
            logTextArea.setText("Hash function initialized");
            FpgaInitHolder.isHashInitialized = true;
        } else if (comboboxInitFunctions.getSelectionModel().getSelectedItem().equals(SupportedFunctions.EDDSA_MODULE.getDescription())) {
//            ndkPointerInitAesEnc = FpgaServiceImpl.getFpgaWrapperService().initEDDSA(0);

            logTextArea.setText("EdDSA initialized");
            FpgaInitHolder.isEdDsaInitialized = true;
        } else if (comboboxInitFunctions.getSelectionModel().getSelectedItem().equals(SupportedFunctions.DILITHIUM_MODULE.getDescription())) {
            logTextArea.setText("Dilithium initialized");
            FpgaInitHolder.isDilithiumInitialized = true;
        } else if (comboboxInitFunctions.getSelectionModel().getSelectedItem().equals(SupportedFunctions.CUSTOM_MODULE.getDescription())) {
            logTextArea.setText("custom module initialized");
            FpgaInitHolder.isCustomModuleInitialized = true;
        }
    }
}
