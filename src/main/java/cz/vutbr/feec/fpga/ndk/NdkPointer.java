package cz.vutbr.feec.fpga.ndk;

import com.sun.jna.Pointer;

public class NdkPointer {

    private static Pointer ndkInitPointer = null;

    public static Pointer initializeNdkAndGetPointer() {
        if (ndkInitPointer == null) {
            synchronized (NdkPointer.class) {
                if (ndkInitPointer == null) {
                    //ndkInitPointer = FpgaServiceImpl.getFpgaWrapperService().initNdk();
                }
            }
        }
        return ndkInitPointer;
    }

    public static void exitNdk(Pointer ndkInitPointer) {
        if (ndkInitPointer == null) {
            return;
        }
        FpgaServiceImpl.getFpgaWrapperService().exitNdk(ndkInitPointer);
    }

}
