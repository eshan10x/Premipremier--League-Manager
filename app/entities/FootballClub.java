package entities;

import java.io.Serializable;

public class FootballClub extends SportsClub implements Serializable,Comparable <FootballClub> {
    //initialize the variables
    private int numOfWins;
    private int numOfDefeats;
    private int numOfDraws;
    private int numOfGoalsReceived;
    private int numOfGoalsScored;
    private int numOfMatches;

    //Default constructor
    public FootballClub() {
    }

    //parameterize constructor
    public FootballClub(String clubName, String clubLocation, int points, int clubId, int numOfWins, int numOfDefeats, int numOfDraws, int numOfGoalsReceived, int numOfGoalsScored, int numOfMatches) {
        super(clubName, clubLocation, points, clubId);
        this.numOfWins = numOfWins;
        this.numOfDefeats = numOfDefeats;
        this.numOfDraws = numOfDraws;
        this.numOfGoalsReceived = numOfGoalsReceived;
        this.numOfGoalsScored = numOfGoalsScored;
        this.numOfMatches = numOfMatches;
    }

    //get goal difference to sort
    public int getGoalDiffer(){
        return numOfGoalsScored-numOfGoalsReceived;
    }

    //getter methods
    public int getNumOfWins() {
        return numOfWins;
    }

    public int getNumOfDefeats() {
        return numOfDefeats;
    }

    public int getNumOfDraws() {
        return numOfDraws;
    }

    public int getNumOfGoalsReceived() {
        return numOfGoalsReceived;
    }

    public int getNumOfGoalsScored() {
        return numOfGoalsScored;
    }

    public int getNumOfMatches() {
        return numOfMatches;
    }

    //setter methods
    public void setNumOfWins(int numOfWins) {
        if (numOfWins>0)
            this.numOfWins = numOfWins;
        else
            throw new IllegalArgumentException("wins need to greater than 0 ");
    }

    public void setNumOfDefeats(int numOfDefeats) {
        this.numOfDefeats = numOfDefeats;
    }

    public void setNumOfDraws(int numOfDraws) {
        this.numOfDraws = numOfDraws;
    }

    public void setNumOfGoalsReceived(int numOfGoalsReceived) {
        this.numOfGoalsReceived = numOfGoalsReceived;
    }

    public void setNumOfGoalsScored(int numOfGoalsScored) {
        this.numOfGoalsScored = numOfGoalsScored;
    }

    public void setNumOfMatches(int numOfMatches) {
        this.numOfMatches = numOfMatches;
    }

    //equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FootballClub)) return false;

        FootballClub that = (FootballClub) o;

        if (getNumOfWins() != that.getNumOfWins()) return false;
        if (getNumOfDefeats() != that.getNumOfDefeats()) return false;
        if (getNumOfDraws() != that.getNumOfDraws()) return false;
        if (getNumOfGoalsReceived() != that.getNumOfGoalsReceived()) return false;
        if (getNumOfGoalsScored() != that.getNumOfGoalsScored()) return false;
        return getNumOfMatches() == that.getNumOfMatches();
    }

    //hashCode
    @Override
    public int hashCode() {
        int result = getNumOfWins();
        result = 31 * result + getNumOfDefeats();
        result = 31 * result + getNumOfDraws();
        result = 31 * result + getNumOfGoalsReceived();
        result = 31 * result + getNumOfGoalsScored();
        result = 31 * result + getNumOfMatches();
        return result;
    }



    //compare to method for sort
    @Override
    public int compareTo(FootballClub ob2) {
        if (this.getPoints()!=ob2.getPoints()){
            if (this.getPoints()>ob2.getPoints()){
                return 1;
            }
            else {
                return -1;
            }
        }
        else {
            if (this.getGoalDiffer()>this.getGoalDiffer()){
                return 1;
            }
            else {
                return -1;
            }
        }
    }

    @Override
    public String toString() {
        return
                "club name=" + getClubName()+
                        ", club location=" +getClubLocation()+
                        ", points= " +getPoints()+
                        ", club ID= " +getClubId()+ " " +
                        ", numOfWins=" + numOfWins +
                        ", numOfDefeats=" + numOfDefeats +
                        ", numOfDraws=" + numOfDraws +
                        ", numOfGoalsReceived=" + numOfGoalsReceived +
                        ", numOfGoalsScored=" + numOfGoalsScored +
                        ", numOfMatches=" + numOfMatches +
                        '}';
    }
}
