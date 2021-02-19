package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import javafx.scene.Scene;
import play.mvc.*;
import utilities.Utils;
import services.PremierLeagueManager;
import entities.*;
import services.PremierLeagueManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class HomeController extends Controller {

    PremierLeagueManager premierLeagueManager = new PremierLeagueManager();

    public Result getPremierLeagueData() throws IOException, ClassNotFoundException {
        PremierLeagueManager.premierLeagueClubs.clear();
        premierLeagueManager.readFile("PremierLeague.txt");


        JsonNode premierLeagueData = Utils.convertToJson((ArrayList) PremierLeagueManager.premierLeagueClubs);
        System.out.println(PremierLeagueManager.premierLeagueClubs);
        return ok(premierLeagueData);
    }

    public Result getMatchData() throws IOException, ClassNotFoundException {
        PremierLeagueManager.premierLeagueMatches.clear();
        premierLeagueManager.readMatchData("PremierLeagueMatches.txt");

        JsonNode matchData = Utils.convertToJson((ArrayList) PremierLeagueManager.premierLeagueMatches);
        System.out.println(PremierLeagueManager.premierLeagueMatches);
        return ok(matchData);
    }

    public Result generateMatch() throws IOException, ClassNotFoundException {

        SportsClub matchTeam1=null;
        SportsClub matchTeam2=null;

        Random random = new Random();

        //select the random football club from arrayList
        int index = random.nextInt(PremierLeagueManager.premierLeagueClubs.size());
        matchTeam1= PremierLeagueManager.premierLeagueClubs.get(index);

        int index1 = random.nextInt(PremierLeagueManager.premierLeagueClubs.size());
        matchTeam2 = PremierLeagueManager.premierLeagueClubs.get(index1);

        //array with venues to be randomly selected
        String[] stadiums ={ "Elland Road Stadium","Ewood Park Stadium","Anfield Stadium","Emirates Stadium","Filbert Street Stadium","Kirklees Stadium"};
        int index2 = random.nextInt(6);
        String stadium = stadiums[index2];
        int team1GoalsScore = random.nextInt(10);
        int team2GoalsScore = random.nextInt(10);
        int day = random.nextInt(30)+1;
        int month = random.nextInt(11)+1;
        int year = random.nextInt(5)+2019;
        Date randDate = new Date(day,month,year);
        Match matchPlayed = new Match(matchTeam1.getClubName(),matchTeam2.getClubName(),team1GoalsScore,team2GoalsScore,stadium,randDate);
        premierLeagueManager.addMatch(matchPlayed);
        premierLeagueManager.updateTeam(matchTeam1.getClubName(),matchTeam2.getClubName(),team1GoalsScore,team2GoalsScore);

        premierLeagueManager.writeMatchData("PremierLeagueMatches.txt");
        premierLeagueManager.writeFile("PremierLeague.txt");

        JsonNode matchData = Utils.convertToJson(PremierLeagueManager.premierLeagueMatches);
        System.out.println(PremierLeagueManager.premierLeagueMatches);

        return ok(matchData).as("application/json");
    }
}
