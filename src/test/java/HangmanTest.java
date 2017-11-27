import org.junit.*;
import  org.junit.Before;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class HangmanTest {
    @Before
    public void before() {
    }

    @Rule
    public ExpectedException exception = ExpectedException.none ();


    @Test
    public void given_NewHangman_A_When__Then_StartedTest() {
        Hangman h = new Hangman ("A", 1);

/*        exception.expect(RuntimeException.class);
        h.doFoo ();*/
        assertEquals ("", h.tries ());
        assertEquals ("_", h.word ());
        assertEquals (Hangman.Status.Started, h.getStatus ());

    }

    @Test
    public void given_NewHangman_A_When_guess_A_Then_StartedTest() throws Exception {
        Hangman h = new Hangman ("A", 2);
        Assert.assertEquals (Hangman.Status.Started, h.getStatus ());
        assertEquals ("_", h.word ());
        h.guess ('A');
        assertEquals (Hangman.Status.Won, h.getStatus ());
    }

    @Test
    public void given_NewHangman_A_When_guessB_Then_StartedTest() throws Exception {

        Hangman h = new Hangman ("A", 1);
        Assert.assertEquals (Hangman.Status.Started, h.getStatus ());
        h.guess ('B');
        assertEquals (Hangman.Status.Lose, h.getStatus ());
        assertEquals ("B", h.tries ());
    }

    @Test
    public void given_NewHangman_A_When_guessBBB_Then_StartedTest() throws Exception {

        Hangman h = new Hangman ("A", 3);
        h.guess ('B');
        assertEquals (Hangman.Status.Started, h.getStatus ());
        h.guess ('B');
        h.guess ('B');
        assertEquals (Hangman.Status.Lose, h.getStatus ());
        assertEquals ("B", h.tries ());
    }

    @Test
    public void given_NewHangman_AT_When__Then___Test() throws Exception {

        Hangman h = new Hangman ("AT", 3);

        assertEquals ("__", h.word ());
    }

    @Test
    public void given_NewHangman_AT_When_guessA_Then_A__Test() throws Exception {

        Hangman h = new Hangman ("AT", 3);
        h.guess ('A');
        assertEquals ("A_", h.word ());
    }

    @Test
    public void given_NewHangman_AT_When_guessTA_Then_A__Test() throws Exception {

        Hangman h = new Hangman ("AT", 3);
        h.guess ('T');
        assertEquals ("_T",h.word ());
        h.guess ('A');
        assertEquals ("AT", h.word ());
    }

    @Test
    public void given_NewHangman_AT_3_A_When_Then__T_3(){
        Hangman h = new Hangman ("AT", 3, "A");
        assertEquals ("A_",h.word ());
        assertEquals (3, h.getTries () );
    }
    @Test
    public void given_NewHangman_APPLE_9_A_When_Then_A___E_3(){
        Hangman h = new Hangman ("APPLE",9,"AEIOU");
        assertEquals ("A___E",h.word ());
        assertEquals (9,h.getTries ());
        h.guess ('T');
        assertEquals ("A___E",h.word ());
        assertEquals (8,h.getTries ());
        h.guess ('R');
        h.guess ('R');
        h.guess ('P');
        assertEquals ("APP_E",h.word ());
        assertEquals (6, h.getTries ());
        h.guess ('L');
        assertEquals (Hangman.Status.Won, h.getStatus ());

    }
}