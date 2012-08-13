public class Letter {
    private final String addressedTo;

    private Letter(String addressedTo) {
        this.addressedTo = addressedTo;
    }

    public String getAddressedTo() {
        return addressedTo;
    }

    public static Letter addressedTo(String name){
        return new Letter(name);
    }
}
