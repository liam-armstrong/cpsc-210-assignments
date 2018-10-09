package test;

import implementations.Participant;
import implementations.Presenter;
import model.Echoer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EchoerTest {
    Presenter s;
    Participant h;

    @BeforeEach
    public void init(){
        s = new Presenter();
        h = new Participant();
    }

    @Test
    public void testDidIHearOne(){
        s.echo("thing");
        h.hear("thing");
        Assertions.assertTrue(h.didIHear("thing"));
        Assertions.assertTrue(s.didIHear("thing"));
    }

    @Test
    public void testDidIHearMultiple(){
        h.hear("thing a");
        h.hear("thing b");
        h.hear("thing c");
        Assertions.assertTrue(h.didIHear("thing b"));
        s.echo("thing a");
        s.echo("thing b");
        s.echo("thing c");
        Assertions.assertTrue(s.didIHear("thing b"));
    }

    @Test
    public void testDidIHearNotHeard(){
        Assertions.assertFalse(h.didIHear("thing a"));
        Assertions.assertFalse(s.didIHear("thing a"));
    }

    @Test
    public void testDidIHearNotHeardPopulated(){
        h.hear("thing a");
        s.echo("thing a");
        Assertions.assertFalse(h.didIHear("thing c"));
        Assertions.assertFalse(s.didIHear("thing b"));
    }

    @Test
    public void testDidISayOne(){
        h.echo("thing a");
        s.echo("thing a");
        Assertions.assertTrue(h.didISay("thing a"));
        Assertions.assertTrue(s.didISay("thing a"));
    }

    @Test
    public void testDidISayMultiple(){
        h.echo("thing a");
        h.echo("thing b");
        h.echo("thing c");
        Assertions.assertTrue(h.didISay("thing b"));
        s.echo("thing a");
        s.echo("thing b");
        s.echo("thing c");
        Assertions.assertTrue(s.didISay("thing b"));
    }

    @Test
    public void testDidISayNotSaid(){
        Assertions.assertFalse(h.didISay("thing a"));
        Assertions.assertFalse(s.didISay("thing a"));
    }

    @Test
    public void testDidISayNotSaidPopulated(){
        s.echo("thing a");
        h.echo("thing a");
        Assertions.assertFalse(h.didISay("thing c"));
        Assertions.assertFalse(s.didISay("thing c"));
    }

    @Test
    public void testEchoOne(){
        h.echo("thing a");
        s.echo("thing a");
        Assertions.assertTrue(h.didISay("thing a"));
        Assertions.assertTrue(h.didIHear("thing a"));
        Assertions.assertTrue(s.didISay("thing a"));
        Assertions.assertTrue(h.didIHear("thing a"));
    }

    @Test
    public void testEchoMultiple(){
        h.echo("thing a");
        s.echo("thing a");
        h.echo("thing b");
        s.echo("thing b");
        h.echo("thing c");
        s.echo("thing c");
        Assertions.assertTrue(h.didISay("thing b"));
        Assertions.assertTrue(h.didIHear("thing b"));
        Assertions.assertTrue(s.didISay("thing b"));
        Assertions.assertTrue(h.didIHear("thing b"));
    }
}


