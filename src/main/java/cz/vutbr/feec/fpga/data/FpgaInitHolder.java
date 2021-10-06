package cz.vutbr.feec.fpga.data;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FpgaInitHolder {

    public static boolean isAesInitialized;
    public static boolean isHashInitialized;
    public static boolean isEdDsaInitialized;
    public static boolean isDilithiumInitialized;
    public static boolean isCustomModuleInitialized;

    public static Path filesStorageFolder = Paths.get("/home/server/fpga/data/");

}
