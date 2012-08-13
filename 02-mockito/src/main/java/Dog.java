public class Dog {
    private final String breed;

    private Dog(String breed) {
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public static Dog newAlsatian(){
        return new Dog("alsatian");
    }

    public static Dog newSausageDog(){
        return new Dog("sossie");
    }
}
