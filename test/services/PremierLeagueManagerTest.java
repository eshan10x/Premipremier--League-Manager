package services;
import entities.FootballClub;
import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.*;

public class PremierLeagueManagerTest {
    PremierLeagueManager premierLeagueManager = new PremierLeagueManager();

    FootballClub testSportClub = new FootballClub("testTeam","testLocation",6,1452,4,2,0,1,2,6);

    @Test
    public void addClub() {
        String expectedOutput = "Club Successfully added!";
        premierLeagueManager.addClub(testSportClub);
        String actualOutput = "Club Successfully added!";
        assertEquals(expectedOutput,actualOutput);
    }

    @Test
    public void dltClub() {
        premierLeagueManager.addClub(testSportClub);
        String expectedOutput = "Successfully removed \" + eachRecord.getClubName() + \" club";
        premierLeagueManager.dltClub("testTeam");
        String actualOutput = "Successfully removed \" + eachRecord.getClubName() + \" club";
        assertEquals(expectedOutput,actualOutput);
    }

    @Test
    public void readFile() throws IOException, ClassNotFoundException {
        premierLeagueManager.readFile("PremierLeague.txt");
        String expectedOutput = "File Read Successfully";
        String actualOutput = "File Read Successfully";
        assertEquals(expectedOutput,actualOutput);
    }
}