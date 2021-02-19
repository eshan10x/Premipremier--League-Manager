package services;

import javafx.collections.ObservableList;

import java.io.IOException;
import entities.*;

public interface LeagueManager {
    void addClub(SportsClub fClub);
    void dltClub(String clubName);
    void displayStat(String clubName);
    void displayPremierLeagueTable();
    void writeFile(String x) throws IOException;
    void readFile(String y) throws IOException, ClassNotFoundException;
    void writeMatchData(String x) throws IOException;
    void readMatchData(String y) throws IOException, ClassNotFoundException;
    void addMatch(Match newMatch);

}
