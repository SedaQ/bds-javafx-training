package cz.vutbr.feec.fpga.controllers;

import cz.vutbr.feec.fpga.data.FpgaInitHolder;
import cz.vutbr.feec.fpga.enums.EncrypytionDecryptionDevices;
import cz.vutbr.feec.fpga.enums.SupportedFunctions;
import cz.vutbr.feec.fpga.ndk.FpgaServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class InitSettingsController {

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
            FpgaServiceImpl.getFpgaWrapperService().initAESEncryption(EncrypytionDecryptionDevices.AES_ENCRYPT_DEVICE);
            FpgaServiceImpl.getFpgaWrapperService().writeIVAES(new int[]{1, 2, 3}, EncrypytionDecryptionDevices.AES_ENCRYPT_DEVICE);

            FpgaServiceImpl.getFpgaWrapperService().initAESDecryption(EncrypytionDecryptionDevices.AES_DECRYPT_DEVICE);
            FpgaServiceImpl.getFpgaWrapperService().writeIVAES(new int[]{1, 2, 3}, EncrypytionDecryptionDevices.AES_DECRYPT_DEVICE);
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
