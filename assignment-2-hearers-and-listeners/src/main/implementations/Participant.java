package implementations;

import model.Echoer;
import model.Hearer;

import java.util.ArrayList;

// Represents a participant with a list of statements said and a list of statements heard
public class Participant implements Echoer, Hearer{
    ArrayList<String> said;
    ArrayList<String> heard;

    // EFFECTS: list of statements said and list of statements heard are empty
    public Participant() {
        said = new ArrayList<>();
        heard = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: statement is added to list of statements said and to list of statements heard
    public void echo(String statement) {
        said.add(statement);
        heard.add(statement);
    }

    // EFFECTS: returns true if this presenter has heard the statement
    public boolean didIHear(String statement) {
        return heard.contains(statement);
    }

    // EFFECTS: returns true if this presenter has said the statement
    public boolean didISay(String statement) {
        return said.contains(statement);
    }

    // MODIFIES: this
    // EFFECTS: statement is added to list of statements heard and string of form "I heard <statement>" is returned
    public String hear(String statement) {
        heard.add(statement);
        return "I heard " + statement;
    }
}

