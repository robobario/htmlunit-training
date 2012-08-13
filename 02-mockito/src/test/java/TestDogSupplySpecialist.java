import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class TestDogSupplySpecialist {

    @Test
    public void testConditionalMocking(){
        DogFactory dogFactory = Mockito.mock(DogFactory.class);
        DogSupplySpecialist specialist= new DogSupplySpecialist(dogFactory);
        Dog alsatian = Dog.newAlsatian();
        Dog nobleSausageDog = Dog.newSausageDog();
        //when the dog factory is asked for a dog with name alan return alsatian
        //when the dog factory is asked for a dog with name richard return sausage monster
        assertEquals(alsatian, specialist.getMeADawg("alan"));
        assertEquals(nobleSausageDog,specialist.getMeADawg("richard"));
    }

    @Test
    public void testCustomConditionMocking(){
        DogFactory dogFactory = Mockito.mock(DogFactory.class);
        DogSupplySpecialist specialist= new DogSupplySpecialist(dogFactory);
        Dog alsatian = Dog.newAlsatian();
        Dog nobleSausageDog = Dog.newSausageDog();
        //when the dog factory is asked for a dog with name starting with r then return noble sausage dog
        assertEquals(alsatian, specialist.getMeADawg("alan"));
        assertEquals(nobleSausageDog,specialist.getMeADawg("richard"));
    }
}
