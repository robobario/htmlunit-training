public class DogSupplySpecialist {
    private DogFactory dogFactory;

    public DogSupplySpecialist(DogFactory dogFactory) {
        this.dogFactory = dogFactory;
    }

    public Dog getMeADawg(String name){
       return dogFactory.buildMeADog(name);
    }
}
