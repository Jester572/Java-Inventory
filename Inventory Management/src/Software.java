public class Software extends Item {
    public int length;
    private int softwareId;
    public static int softwareCounter = 0;
    Software(String iName, int iQuantity, int monthsActive) {
        super(iName, iQuantity);
        this.softwareId = softwareCounter++;
        length = monthsActive;

    }

    public int getLength() {
        return length;
    }

    public int getSoftwareId() {
        return softwareId;
    }
}
