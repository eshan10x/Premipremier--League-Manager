package entities;

import java.io.Serializable;

public abstract class SportsClub implements Serializable {
    //initialize the variables
    private String clubName;
    private String clubLocation;
    private int points;
    private int clubId;

    //Default constructor
    public SportsClub() {
    }

    //parameterized constructor
    public SportsClub(String clubName, String clubLocation, int points, int clubId) {
        this.clubName = clubName;
        this.clubLocation = clubLocation;
        this.points = points;
        this.clubId = clubId;
    }

    //getters method
    public String getClubName() {
        return clubName;
    }

    public String getClubLocation() {
        return clubLocation;
    }

    public int getPoints() {
        return points;
    }

    public int getClubId() {
        return clubId;
    }

    //setters method
    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public void setClubLocation(String clubLocation) {
        this.clubLocation = clubLocation;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }





    @Override
    public String toString() {
        return "SportsClub{" +
                "clubName='" + clubName + '\'' +
                ", clubLocation='" + clubLocation + '\'' +
                ", points=" + points +
                ", clubId=" + clubId +
                '}';
    }
}
