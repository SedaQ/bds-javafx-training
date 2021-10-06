package cz.vutbr.feec.fpga.ndk;

import cz.vutbr.feec.service.FPGAWrapperServiceImpl;

public class FpgaServiceImpl {

    private static FPGAWrapperServiceImpl fpgaWrapperService = null;

    public static synchronized FPGAWrapperServiceImpl getFpgaWrapperService() {
        if (fpgaWrapperService == null) {
            fpgaWrapperService = new FPGAWrapperServiceImpl();
        }
        return fpgaWrapperService;
    }
}
