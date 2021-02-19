package entities;

import java.io.Serializable;

public class UniversityFootballClub extends FootballClub implements Serializable {
    //initialize the variables
    private String uniName;

    //Default constructor
    public UniversityFootballClub() {
    }

    //parameterized constructor
    public UniversityFootballClub(String uniName) {
        this.uniName = uniName;
    }

    //getters method
    public String getUniName() {
        return uniName;
    }



    //setters method
    public void setUniName(String uniName) {
        this.uniName = uniName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UniversityFootballClub)) return false;
        if (!super.equals(o)) return false;

        UniversityFootballClub that = (UniversityFootballClub) o;

        return getUniName() != null ? getUniName().equals(that.getUniName()) : that.getUniName() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getUniName() != null ? getUniName().hashCode() : 0);
        return result;
    }
}
