package cz.vutbr.feec.fpga.enums;

public enum SupportedFunctions {

    AES("AES", "Init AES"),
    HASH_FUNCTION("HASH_FUNCTION", "Init Hash Function"),
    EDDSA_MODULE("EDDSA_MODULE", "Init EdDSA Module"),
    DILITHIUM_MODULE("DILITHIUM_MODULE", "Init Dilithium Module"),
    CUSTOM_MODULE("CUSTOM_MODULE", "Init Custom Module");

    private String title;
    private String description;

    SupportedFunctions(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
