package services;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import entities.*;


public class TestMain {
    static PremierLeagueManager premierLeagueManager = new PremierLeagueManager();

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        readFile();

        int choice;

        while (true){
            try {
                Scanner s = new Scanner(System.in);
                System.out.println("-------------------------------------------------------");
                System.out.println("Welcome to Football Manager! ");
                System.out.println(" ");
                System.out.println("Press[1] Add a new club press ");
                System.out.println("Press[2] Remove a club press ");
                System.out.println("Press[3] Display stats of a specific club press ");
                System.out.println("Press[4] premier league manager press ");
                System.out.println("Press[5] Write to file press ");
                System.out.println("Press[6] Add match press ");
                System.out.println("Press[7] Open GUI ");
                System.out.println("------------------------------------------------------");
                System.out.println("Enter your choice : ");
                choice = s.nextInt();

                if (choice == 1) {
                    addClub();
                } else if (choice == 2) {
                    remove();
                } else if (choice == 3) {
                    displayStat();
                } else if (choice == 4) {
                    premierLeagueTable();
                } else if (choice == 5) {
                    fileWrite();
                } else if (choice == 6) {
                    addMatch();
                } else if (choice == 7) {
                    openUi();
                } else {
                    System.out.println("Invalid Input Try Again!");
                    System.out.println("------------------------------");
                }
            }catch(InputMismatchException exception){
                System.out.println("Invalid Input! Try Again! ");
                System.out.println("----------------------------------");
            }
        }
        }

    public static void addClub(){
        try {
            int type=0;
            Scanner s = new Scanner(System.in);

            System.out.println("Enter Football club type");
            System.out.println(" Football Club = 1 / University football club = 2 / School football club = 3 ");
            System.out.println("What is your club type? : ");
            type = s.nextInt();

            System.out.print("Enter Club name : ");
            String clubName = s.next();
            System.out.print("Enter club location : ");
            String clubLocation = s.next();
            System.out.print("Enter point : ");
            int points = s.nextInt();
            System.out.print("Enter clubId: ");
            int clubId = s.nextInt();
            System.out.print("Enter number of wins : ");
            int wins = s.nextInt();
            System.out.print("Enter number of defeats : ");
            int defeats = s.nextInt();
            System.out.print("Enter draws : ");
            int draws = s.nextInt();
            System.out.print("Enter goals received : ");
            int goalReceived = s.nextInt();
            System.out.print("Enter goals scored : ");
            int goalScored = s.nextInt();
            System.out.print("Enter num of matches : ");
            int numOfMatches = s.nextInt();

            SportsClub newFbClub = new FootballClub(clubName,clubLocation,points,clubId,wins,defeats,draws,goalReceived,goalScored,numOfMatches);
            premierLeagueManager.addClub(newFbClub);
//            premierLeagueManager.writeFile("PremierLeague.txt");
        }catch (InputMismatchException exception2){
            System.out.println("Invalid Input! Try Again!");
            System.out.println("----------------------------- ");
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }

    }

    public static void remove(){
        Scanner r = new Scanner(System.in);
        System.out.println("Enter club name to remove : ");
        String clubName = r.next();
        premierLeagueManager.dltClub(clubName);
    }

    public static void displayStat(){
        Scanner c = new Scanner(System.in);
        System.out.println("Enter club name to stat: ");
        String clubName = c.next();
        premierLeagueManager.displayStat(clubName);
    }

    public static void premierLeagueTable(){
        premierLeagueManager.displayPremierLeagueTable();
    }

    public static void fileWrite() throws IOException {
        premierLeagueManager.writeFile("PremierLeague.txt");
        premierLeagueManager.writeMatchData("PremierLeagueMatches.txt");
    }

    public static void readFile() throws IOException, ClassNotFoundException {
        premierLeagueManager.readFile("PremierLeague.txt");
        premierLeagueManager.readMatchData("PremierLeagueMatches.txt");
    }

    public static void addMatch(){
        Scanner am = new Scanner(System.in);
        System.out.print("Enter team 1 (Home) name : ");
        String team1 = am.next();
        System.out.print("Enter team 2 (Away) name : ");
        String team2 = am.next();
        System.out.print("Enter team 1 goals : ");
        int team1Goals = am.nextInt();
        System.out.print("Enter team 2 goals : ");
        int team2Goals = am.nextInt();
        System.out.print("Enter the stadium name : ");
        String stadium = am.next();
        System.out.print("Enter match date : ");
        int day = am.nextInt();
        System.out.print("Enter match month : ");
        int month = am.nextInt();
        System.out.print("Enter match year : ");
        int year = am.nextInt();

        Date date = new Date(day,month,year);
        Match newMach = new Match(team1,team2,team1Goals,team2Goals,stadium,date);
        premierLeagueManager.addMatch(newMach);
        premierLeagueManager.updateTeam(team1,team2,team1Goals,team2Goals);
    }

    public static void openUi(){
        String connectToGUI = "http://localhost:4200/";
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(connectToGUI));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
