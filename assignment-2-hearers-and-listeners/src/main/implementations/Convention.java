package implementations;

import model.Echoer;
import model.Hearer;
import model.Speaker;

import java.util.ArrayList;
import java.util.List;

// Represents a convention of echoers, hearers and speakers
public class Convention {
    private List<Echoer> echoers;
    private List<Hearer> hearers;
    private List<Speaker> speakers;

    // EFFECTS: creates empty lists of echoers, hearers and speakers
    public Convention() {
        echoers = new ArrayList<>();
        hearers = new ArrayList<>();
        speakers = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds participant to convention as a hearer and echoer
    public void addParticipant(Participant participant) {
        hearers.add(participant);
        echoers.add(participant);
    }

    // MODIFIES: this
    // EFFECTS: adds presenter to convention as a speaker and echoer
    public void addPresenter(Presenter presenter) {
        speakers.add(presenter);
        echoers.add(presenter);
    }

    // MODIFIES: this
    // EFFECTS: each speaker says the statement to every hearer
    public void speakersSay(String statement) {
        for (Speaker s : speakers) {
            for (Hearer h : hearers) {
                s.say(statement, h);
            }
            // the following statements included only to illustrate other behaviours of a Speaker
            boolean didHear = s.didISay(statement);
        }
    }

    // MODIFIES: this
    // EFFECTS: each hearer hears the statement
    public void hearersHear(String statement) {
        for (Hearer h : hearers) {
            String whatIHeard = h.hear(statement);
            System.out.println(whatIHeard);
            // the following statements included only to illustrate other behaviours of a Hearer
            boolean didHear = h.didIHear(statement);
        }
    }

    // MODIFIES: this
    // EFFECTS: each echoer echos the statement
    public void echoersEcho(String statement) {
        for (Echoer e : echoers) {
            e.echo(statement);
            // the following statements included only to illustrate other behaviours of an Echoer
            boolean didHear = e.didIHear(statement);
            boolean didSay = e.didISay(statement);
        }
    }
}
