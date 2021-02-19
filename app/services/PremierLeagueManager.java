package services;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.*;
import entities.*;

public class PremierLeagueManager implements LeagueManager {

    //creating arraylist for premier league clubs to save
    public static List<SportsClub> premierLeagueClubs = new ArrayList<SportsClub>();
    public static ArrayList<Match> premierLeagueMatches = new ArrayList<Match>();

    //add a new club method
    @Override
    public void addClub(SportsClub fClub) {
        if (premierLeagueClubs.contains(fClub)){
            System.out.println("Club already exist ");
        }else {
            premierLeagueClubs.add(fClub);
            System.out.println(fClub);
            System.out.println("Club Successfully added!");
        }
    }


    //dlt a club from list method
    @Override
    public void dltClub(String clubName) {
        try {
            SportsClub remove = null;
            for (SportsClub eachRecord : premierLeagueClubs) {
                if (eachRecord.getClubName().equals(clubName)) {
                    remove = eachRecord;
                    System.out.println("Successfully removed " + eachRecord.getClubName() + " club");
                }
            }premierLeagueClubs.remove(remove);
        } catch (Exception e) {
            System.out.println(" Check your club name ");
        }
    }

    //to display selected club statistics method
    @Override
    public void displayStat(String clubName) {
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        SportsClub selectedClub = null;

        for (SportsClub eachRecord : premierLeagueClubs) {
            if (eachRecord.getClubName().equals(clubName)) {
                selectedClub = eachRecord;
                System.out.println(selectedClub);
            }
        }
    }

    //display premierLeague table method
    @Override
    public void displayPremierLeagueTable() {
        Collections.sort(premierLeagueClubs, Collections.reverseOrder());
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.printf("%10s %20s %10s %5s %5s %5s %5s %10s %10s %5s ", "ClubName", "ClubLocation", "ClubPoints", "ClubId" , "Wins", "Defeat", "Draws", "GoalReceived", "GoalsScored", "Matches");
        System.out.println();
        for (SportsClub eachRecord : premierLeagueClubs) {
            if (eachRecord instanceof FootballClub) {
                System.out.println("---------------------------------------------------------------------------------------------------");
                System.out.format("%10s %20s %10s %5s %5s %5s %5s %10s %10s %10s ", eachRecord.getClubName(), eachRecord.getClubLocation(), eachRecord.getPoints(), eachRecord.getClubId()
                        , ((FootballClub) eachRecord).getNumOfWins(), ((FootballClub) eachRecord).getNumOfDefeats(), ((FootballClub) eachRecord).getNumOfDraws(), ((FootballClub) eachRecord).getNumOfGoalsReceived()
                        , ((FootballClub) eachRecord).getNumOfGoalsScored(), ((FootballClub) eachRecord).getNumOfMatches());
                System.out.println();
            }
        }
    }

    //Method for write club data to a file
    @Override
    public void writeFile(String x) throws IOException {
        //create a file called premier league
        File file = new File("PremierLeague.txt");


        FileOutputStream fo = new FileOutputStream(x);
        ObjectOutputStream o = new ObjectOutputStream(fo);

        for (SportsClub sportsClub : premierLeagueClubs) {
                    System.out.println(sportsClub);
                    o.writeObject(sportsClub);
            System.out.println("File Write Successfully");
        }

        o.flush();
        o.close();
        fo.close();
    }

    //Method for read club data from file
    @Override
    public void readFile(String y) throws IOException, ClassNotFoundException {

        try {


            FileInputStream fi = new FileInputStream(y);
            ObjectInputStream ois = new ObjectInputStream(fi);

            for (; ; ) {
                try {
                    SportsClub sportsClub = (SportsClub) ois.readObject();
                    premierLeagueClubs.add(sportsClub);
                    System.out.println("File Read Successfully");
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException error) {
            System.out.println("File not Found");
        }
    }

    //Method for write match data to file
    @Override
    public void writeMatchData(String x) throws IOException {
        File file = new File("PremierLeagueMatches.txt");

        FileOutputStream mis = new FileOutputStream(x);
        ObjectOutputStream mos = new ObjectOutputStream(mis);

        for (Match match : premierLeagueMatches) {
            System.out.println(match);
            mos.writeObject(match);
        }

        mos.flush();
        mos.close();
        mis.close();
    }

    //method for read match data from file
    @Override
    public void readMatchData(String y) throws IOException, ClassNotFoundException {
        try {


            FileInputStream mfi = new FileInputStream(y);
            ObjectInputStream mis = new ObjectInputStream(mfi);

            for (; ; ) {
                try {
                    Match match = (Match) mis.readObject();
                    premierLeagueMatches.add(match);
                } catch (EOFException e) {
                    break;
                }
            }
        }catch (IOException error){
            System.out.println("File not Found");
        }
    }

    //Method for add match data to list
    @Override
    public void addMatch(Match newMatch) {
        premierLeagueMatches.add(newMatch);
    }

    //Method for update club statistics
    public void updateTeam(String team1, String team2, int goalsteam1, int goalsTeam2) {
        for (SportsClub record : premierLeagueClubs) {
            System.out.println(record);
            if (record instanceof FootballClub) {

                ((FootballClub) record).setNumOfMatches(((FootballClub) record).getNumOfMatches() + 1);
                if (goalsteam1 == goalsTeam2) {
                    ((FootballClub) record).setNumOfDraws(((FootballClub) record).getNumOfDraws() + 1);
                }

                if (record.getClubName().equals(team1)) {
                    ((FootballClub) record).setNumOfGoalsScored(goalsteam1 + ((FootballClub) record).getNumOfGoalsScored());
                    ((FootballClub) record).setNumOfGoalsReceived(goalsTeam2 + ((FootballClub) record).getNumOfGoalsReceived());

                    if (goalsteam1 > goalsTeam2) {
                        ((FootballClub) record).setNumOfWins(((FootballClub) record).getNumOfWins() + 1);
                    } else if (goalsteam1 < goalsTeam2) {
                        ((FootballClub) record).setNumOfDefeats(((FootballClub) record).getNumOfDefeats() + 1);
                    }
                } else if (record.getClubName().equals(team2)) {
                    ((FootballClub) record).setNumOfGoalsScored(goalsTeam2 + ((FootballClub) record).getNumOfGoalsScored());
                    ((FootballClub) record).setNumOfGoalsReceived(goalsteam1 + ((FootballClub) record).getNumOfGoalsReceived());

                    if (goalsTeam2 > goalsteam1) {
                        ((FootballClub) record).setNumOfWins(((FootballClub) record).getNumOfWins() + 1);
                    } else if (goalsTeam2 < goalsteam1) {
                        ((FootballClub) record).setNumOfDefeats(((FootballClub) record).getNumOfDefeats() + 1);
                    }
                }
            }
        }
    }


    public ObservableList<SportsClub> getFootballClubs() {
        ObservableList<SportsClub> clubs = FXCollections.observableArrayList();
        for (SportsClub sportsClub : premierLeagueClubs){
            clubs.addAll(sportsClub);
        }
        return clubs;
    }

    public ObservableList<Match> getMatchDetail() {
        ObservableList<Match> match = FXCollections.observableArrayList();
        for (Match matches : premierLeagueMatches){
            match.addAll(matches);
        }
        return match;
    }


}
