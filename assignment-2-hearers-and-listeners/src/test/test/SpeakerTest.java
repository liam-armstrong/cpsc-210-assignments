package test;

import implementations.Participant;
import implementations.Presenter;
import model.Echoer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SpeakerTest {
    Presenter s;
    Participant h;

    @BeforeEach
    public void init(){
        s = new Presenter();
        h = new Participant();
    }

    @Test
    public void testDidISayOne(){
        s.echo("thing a");
        Assertions.assertTrue(s.didISay("thing a"));
    }

    @Test
    public void testDidISayMultiple(){
        s.echo("thing a");
        s.echo("thing b");
        s.echo("thing c");
        Assertions.assertTrue(s.didISay("thing b"));
    }

    @Test
    public void testDidISayNotSaid(){
        Assertions.assertFalse(s.didISay("thing a"));
    }

    @Test
    public void testDidISayNotSaidPopulated(){
        s.echo("thing a");
        Assertions.assertFalse(s.didISay("thing c"));
    }

    @Test
    public void testSayOne(){
        s.say("thing", h);
        Assertions.assertTrue(s.didISay("thing"));
        Assertions.assertTrue(h.didIHear("thing"));

        Assertions.assertFalse(s.didISay("thing a"));
        Assertions.assertFalse(h.didIHear("thing a"));
    }

    @Test
    public void testSayMultiple(){
        s.say("thing a", h);
        s.say("thing b", h);
        s.say("thing c", h);
        Assertions.assertTrue(s.didISay("thing b"));
        Assertions.assertTrue(h.didIHear("thing c"));

        Assertions.assertFalse(s.didISay("thing d"));
        Assertions.assertFalse(h.didIHear("thing d"));
    }
}


