package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListOfClowns {
    List<Clown> clowns = new ArrayList<Clown>();

    //REQUIRES: boolean value isStanding, indicating whether the clown should be constructed sitting or standing
    //MODIFIES: the list clowns
    //EFFECTS:  creates a new clown, passing in the isStanding parameter, and adds that clown to the list of clowns
    public void addClown(boolean isStanding) {
        clowns.add(new Clown(isStanding));
    }

    //REQUIRES: nothing
    //MODIFIES: nothing
    //EFFECTS:  checks all the clowns in the list clowns, and returns true if every clown is standing
    public boolean allClownsStanding() {
        for(Clown c: clowns){
            if(!c.getIsStanding()){
                return false;
            }
        }
        return true;
    }

    //REQUIRES: an integer value for the clown's index in the list clowns (position)
    //MODIFIES: the clown at the position, and the clown to either side (position+1 and position-1) of the clown
    //EFFECTS:  calls clown.flip() to make a clown sit if standing, or stand if sitting.
    public void flip(int position) {
        if(position >= 0 && position <= (clowns.size() - 1)){
            clowns.get(position).flip();
        }
        if((position - 1) >= 0 && (position - 1) <= (clowns.size() - 1)){
            clowns.get(position - 1).flip();
        }
        if((position + 1) >= 0 && (position + 1) <= (clowns.size() - 1)){
            clowns.get(position + 1).flip();
        }
    }

    //REQUIRES: an integer value for the clown's index in the list of clowns (position)
    //MODIFIES: nothing
    //EFFECTS:  returns true if the clown in the list clowns at index position is standing, false otherwise
    public boolean isClownStanding(int position) {
        if(position >= 0 && position <= (clowns.size() - 1)){
            return clowns.get(position).getIsStanding();
        }
        return false;
    }

    //Do not modify this method
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Clown c : clowns) {
            if (c.getIsStanding()) {
                sb.append("  UP  ");
            } else {
                sb.append(" DOWN ");
            }
        }
        return sb.toString();
    }

    //Do not modify this method
    public List<Integer> solve() {
        return solve(new HashSet<String>());
    }

    //Do not modify this method
    public List<Integer> solve(Set<String> seen) {
        return null;
    }
}