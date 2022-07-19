package project;

import java.io.IOException;

public class league extends team {
    //-------------VARIABLES-------------
    protected team teams[], search;
    protected int numberOfTeams;
    protected int currentTeam;
    protected int current;
    protected int totalFound;
    private int t;
    private int i;
    protected boolean shown = false;


    //-----------CONSTRUCTORS--------------
    public league(int n) {
        numberOfTeams = n;
        teams = new team[numberOfTeams];
        for(i = 0; i < numberOfTeams; i++) {
            teams[i] = new team(15);
            teams[i].setTeamName(teams[i].nameBase[i]);
        }
        currentTeam = 0;
    }
    //----------------CLEAR---------------
    public void clearAllTeams() {
        for(i = 0; i < numberOfTeams; i++) {
            teams[i].clearPlayers();
            teams[i].teamSize = 0;
        }
    }
    //-------------SETTERS---------------
    public void setCurrentTeam(int n) {
        currentTeam = n;
    }
    //-------------GETTERS--------------
    public int getCurrentTeam() {
        return this.currentTeam;
    }
    //------------NEXT/PREVIOUS-------------
    public void resetCurrentPlayer() {
        teams[currentTeam].setCurrentPlayer(0);
    }
    public void nextTeam() {
        resetCurrentPlayer();
        currentTeam++;
        if (currentTeam > 29) currentTeam = 29;
    }
    public void previousTeam() {
        resetCurrentPlayer();
        currentTeam--;
        if (currentTeam < 0) currentTeam = 0;
    }
    public void nextPlayer() {
        teams[currentTeam].setCurrentPlayer(teams[currentTeam].getCurrentPlayer() + 1);
        if (teams[currentTeam].getCurrentPlayer() > teams[currentTeam].teamSize)
            teams[currentTeam].setCurrentPlayer(teams[currentTeam].getCurrentPlayer() - 1);
    }
    public void previousPlayer() {
        teams[currentTeam].setCurrentPlayer(teams[currentTeam].getCurrentPlayer() - 1);
        if (teams[currentTeam].getCurrentPlayer() < 0)
            teams[currentTeam].setCurrentPlayer(teams[currentTeam].getCurrentPlayer() + 1);
    }
    //-------------PRINT--------------
    public void printCurrentTeam() { teams[currentTeam].printPlayers(); }
    public void printCurrentPlayer() {
        teams[currentTeam].printCurrentPlayer();
    }

    //-------------ADD PLAYER------------
    public void addPlayerToCurrentTeam(String name, String surname, int age, int number, double earnings) {
        teams[currentTeam].addPlayer(name, surname, age, number, earnings);
    }
    //------------------EDIT----------------
    public void setCurrentPlayerName(String name) { teams[currentTeam].players[teams[currentTeam].getCurrentPlayer()].setName(name); }
    public void setCurrentPlayerSurname(String surname) { teams[currentTeam].players[teams[currentTeam].getCurrentPlayer()].setSurname(surname); }
    public void setCurrentPlayerAge(int age) { teams[currentTeam].players[teams[currentTeam].getCurrentPlayer()].setAge(age); }
    public void setCurrentPlayerNumber(int number) { teams[currentTeam].players[teams[currentTeam].getCurrentPlayer()].setNumber(number); }
    public void setCurrentPlayerEarnings(double earnings) { teams[currentTeam].players[teams[currentTeam].getCurrentPlayer()].setEarnings(earnings); }


    //--------------SEARCH FOR PLAYERS--------------
    public void addToFound(int t, int p) {
        search.players[currentFound].setName(teams[t].players[p].name);
        search.players[currentFound].setSurname(teams[t].players[p].surname);
        search.players[currentFound].setAge(teams[t].players[p].age);
        search.players[currentFound].setNumber(teams[t].players[p].number);
        search.players[currentFound].setEarnings(teams[t].players[p].earnings);
    }
    public void showFound() {
        for (i = 0; i < currentFound; i++) {
            search.players[i].printAll();
        }
    }
    public void searchLeagueByEarnings(double min, double max) {
        totalFound = 0;
        currentFound = 0;
        search = new team(100);
        for (i = 0; i < numberOfTeams; i++) {
            current = 0;
            teams[i].currentFound = 0;
            for (int j = 0; j < teams[i].teamSize; j++) {
                if (teams[i].searchTeamByEarnings(current, min, max)) {
                    addToFound(i, current);
                    currentFound++;
                    //System.out.println("TUTAJ " + currentFound);
                }
                totalFound = currentFound;
                current++;
            }
        }
    }
    public void searchLeagueByAge (int min, int max) {
        totalFound = 0;
        currentFound = 0;
        search = new team(100);
        for (i = 0; i < numberOfTeams; i++) {
            current = 0;
            teams[i].currentFound = 0;
            for (int j = 0; j < teams[i].teamSize; j++) {
                if (teams[i].searchTeamByAge(current, min, max)) {
                    addToFound(i, current);
                    currentFound++;
                }
                totalFound = currentFound;
                current++;
            }
        }
    }
    public void searchLeagueBySurname (String str) {
        totalFound = 0;
        currentFound = 0;
        search = new team(100);
        for (i = 0; i < numberOfTeams; i++) {
            current = 0;
            teams[i].currentFound = 0;
            for (int j = 0; j < teams[i].teamSize; j++) {
                if (teams[i].searchTeamBySurname(current, str)) {
                    addToFound(i, current);
                    currentFound++;
                }
                totalFound = currentFound;
                current++;
            }
        }
    }
    public void saveFound() {
        //File file =
        for (i = 0; i < 100; i++) {

        }
    }
    //----------------SAVE ALL TEAMS-----------------
    public void saveAllTeams() {
        for (i = 0; i < numberOfTeams; i++) {
            teams[i].saveToFile();
        }
    }
    //--------------LOAD ALL TEAMS------------------
    public void loadAllTeams() {
        for (i = 0; i < numberOfTeams; i++) {
            teams[i].loadFromFile(teams[i].nameBase[i]);
        }
    }
    //--------------BACKUP ALL TEAMS------------------
    public void backUpLeague() throws IOException {
        for (i = 0; i < numberOfTeams; i++) {
            teams[i].exportToTxt();
        }
    }
    //--------------DELETE LEAGUE FILES-------------
    public void deleteTeams() {
        for (i = 0; i < numberOfTeams; i++) {
            teams[i].deleteFile();
        }
    }
}
