
import org.junit.Test;

import static org.junit.Assert.*;

public class ShowTennisGameTest {

    @Test
    public void Given_when_then_Love_All(){
        assertEquals("Love All", ShowTennisGame.showResult(0, 0));
        assertEquals("Fifteen All", ShowTennisGame.showResult(1, 1));
        assertEquals("Thirty All", ShowTennisGame.showResult(2, 2));
        assertEquals("Deuce", ShowTennisGame.showResult(3, 3));

        assertEquals("Fifteen Love", ShowTennisGame.showResult(1, 0));
        assertEquals("Thirty Love", ShowTennisGame.showResult(2, 0));
        assertEquals("Forty Love", ShowTennisGame.showResult(3, 0));

        assertEquals("A Win", ShowTennisGame.showResult(4, 0));
        assertEquals("A Win", ShowTennisGame.showResult(4, 1));
        assertEquals("A Win", ShowTennisGame.showResult(4, 2));
        assertEquals("A Win", ShowTennisGame.showResult(7, 5));

        assertEquals("A Advance", ShowTennisGame.showResult(4, 3));
        assertEquals("A Advance", ShowTennisGame.showResult(11, 10));

        assertEquals("Thirty Fifteen", ShowTennisGame.showResult(2, 1));
        assertEquals("Forty Fifteen", ShowTennisGame.showResult(3, 1));
    }
}