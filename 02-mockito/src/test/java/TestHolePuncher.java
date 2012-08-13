import org.junit.Test;
import org.mockito.Mockito;

public class TestHolePuncher {

    @Test
    public void testPunchHole(){
        Paper paper = Mockito.mock(Paper.class);
        new HolePuncher().punchHole(paper);
        Mockito.verify(paper).punch();
    }

    @Test
    public void testPunchHoleTwice(){
        Paper paper = Mockito.mock(Paper.class);
        HolePuncher holePuncher = new HolePuncher();
        holePuncher.punchHole(paper);
        holePuncher.punchHole(paper);
        //verify that it was punched twice
    }
}
