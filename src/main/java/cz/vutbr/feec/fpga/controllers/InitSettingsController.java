package cz.vutbr.feec.fpga.controllers;

import com.sun.jna.Pointer;
import cz.vutbr.feec.fpga.data.FpgaInitHolder;
import cz.vutbr.feec.fpga.ndk.FpgaServiceImpl;
import cz.vutbr.feec.fpga.ndk.NdkPointer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class InitSettingsController {

    public static Pointer ndkPointer;

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
    public TextArea logTextArea;

    public void handleInitAES(ActionEvent event) {
        logTextArea.setText("AES function initialized");

        ndkPointer = FpgaServiceImpl.getFpgaWrapperService().initAES(0);
        FpgaInitHolder.isAesInitialized = true;
    }

    public void handleInitHashFunction(ActionEvent event) {
        logTextArea.setText("Hash function initialized");
        FpgaInitHolder.isHashInitialized = true;
    }

    public void handleInitEdDSA(ActionEvent event) {
        ndkPointer = FpgaServiceImpl.getFpgaWrapperService().initEDDSA(0);

        logTextArea.setText("EdDSA initialized");
        FpgaInitHolder.isEdDsaInitialized = true;
    }

    public void handleInitDilithium(ActionEvent event) {
        logTextArea.setText("Dilithium initialized");
        FpgaInitHolder.isDilithiumInitialized = true;
    }

    public void handleInitCustomModule(ActionEvent event) {
        logTextArea.setText("custom module initialized");
        FpgaInitHolder.isCustomModuleInitialized = true;
    }

}
