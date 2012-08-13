import org.junit.Test;
import org.mockito.Mockito;

public class TestPostbox {
    @Test
    public void testPostboxIncineratesLettersForMrLiddle(){
        Incinerator mock = Mockito.mock(Incinerator.class);
        PostBox postBox = new PostBox(mock);
        Letter letter = Letter.addressedTo("Mr Liddle");
        postBox.post(letter);
        //verify that the mock incinerator, incinerated that letter.
    }

    @Test
    public void testPostboxDoesNotIncinerateLettersForOtherPeople(){
        Incinerator mock = Mockito.mock(Incinerator.class);
        PostBox postBox = new PostBox(mock);
        Letter letter = Letter.addressedTo("Mothra");
        postBox.post(letter);
        //verify that the mock incinerator never incinerated that letter.
    }

    @Test(expected = RuntimeException.class)
    public void testPostboxDoesNotHandleIncineratorError(){
        Incinerator mock = Mockito.mock(Incinerator.class);
        //Tell the mock object to throw a runtime exception on incinerate
        PostBox postBox = new PostBox(mock);
        Letter letter = Letter.addressedTo("Mothra");
        postBox.post(letter);
    }
}
