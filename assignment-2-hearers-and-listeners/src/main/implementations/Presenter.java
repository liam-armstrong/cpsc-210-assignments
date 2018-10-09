package implementations;

import model.Echoer;
import model.Hearer;
import model.Speaker;

import java.util.ArrayList;

// Represents a presenter with a list of statements said and a list of statements heard
public class Presenter implements Speaker, Echoer{
    ArrayList<String> said;
    ArrayList<String> heard;

    // EFFECTS: list of statements said and list of statements heard are empty
    public Presenter() {
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

    // MODIFIES: this, hearer
    // EFFECTS: hearer hears statement and statement is added to list of statements said
    public void say(String statement, Hearer hearer) {
        said.add(statement);
        hearer.hear(statement);
    }
}

