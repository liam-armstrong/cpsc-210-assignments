package test;

import implementations.Participant;
import implementations.Presenter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HearerTest {
    Participant h;

    @BeforeEach
    public void init(){
        h = new Participant();
    }

    @Test
    public void testDidIHearOne(){
        h.hear("thing");
        Assertions.assertTrue(h.didIHear("thing"));
    }

    @Test
    public void testDidIHearMultiple(){
        h.hear("thing a");
        h.hear("thing b");
        h.hear("thing c");
        Assertions.assertTrue(h.didIHear("thing b"));
    }

    @Test
    public void testDidIHearNotHeard(){
        Assertions.assertFalse(h.didIHear("thing a"));
    }

    @Test
    public void testDidIHearNotHeardPopulated(){
        h.hear("thing a");
    }

    @Test
    public void testHearOutputValid(){
        Assertions.assertEquals("I heard thing", h.hear("thing"));
    }

    @Test
    public void testHearOutputNull(){
        Assertions.assertEquals("I heard ", h.hear(null));
    }
}
