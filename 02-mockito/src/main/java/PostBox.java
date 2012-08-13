public class PostBox {
    private final Incinerator incinerator;

    public PostBox(Incinerator incinerator) {
        this.incinerator = incinerator;
    }

    public void post(Letter letter){
        if(letter.getAddressedTo().equals("Mr Liddle")){
            this.incinerator.incinerate(letter);
        }
    }
}
