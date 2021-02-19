package entities;

import java.io.Serializable;
import java.util.Objects;

public class SchoolFootballClubs extends FootballClub implements Serializable {
    //initialize the variables
    private String sclName;

    //Default constructor
    public SchoolFootballClubs() {
    }

    //parameterized constructor
    public SchoolFootballClubs(String clubName, String clubLocation, int points, int clubId, int numOfWins, int numOfDefeats, int numOfDraws, int numOfGoalsReceived, int numOfGoalsScored, int numOfMatches, String sclName) {
        super(clubName, clubLocation, points, clubId, numOfWins, numOfDefeats, numOfDraws, numOfGoalsReceived, numOfGoalsScored, numOfMatches);
        this.sclName = sclName;
    }

    //get goal difference to sort
    public int getGoalDiffer(){
        return getNumOfGoalsScored()-getNumOfGoalsReceived();
    }

    //getters method
    public String getSclName() {
        return sclName;
    }


    //setters method
    public void setSclName(String sclName) {
        this.sclName = sclName;
    }

    //equal method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SchoolFootballClubs)) return false;
        if (!super.equals(o)) return false;

        SchoolFootballClubs that = (SchoolFootballClubs) o;

        return getSclName() != null ? getSclName().equals(that.getSclName()) : that.getSclName() == null;
    }

    //hashcode method
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getSclName() != null ? getSclName().hashCode() : 0);
        return result;
    }
}
