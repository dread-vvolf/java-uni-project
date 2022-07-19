package project;

import java.io.FileOutputStream;
import java.io.*;

public class team extends player{
    //-------------VARIABLES-------------
    protected player players[], temp;
    protected String teamName;
    protected int teamSize;
    private int currentPlayer;
    protected int currentFound;
    private int i;

    protected double tempD;
    protected String tempS1, tempS2;
    protected int tempI1, tempI2;

    String nameBase[] = {
            "Atlanta Hawks",
            "Boston Celtics",
            "Brooklyn Nets",
            "Charlotte Bobcats",
            "Chicago Bulls",
            "Cleveland Cavaliers",
            "Dallas Mavericks",
            "Denver Nuggets",
            "Detroit Pistons",
            "Golden State Warriors",
            "Houston Rockets",
            "Indiana Pacers",
            "LA Clippers",
            "LA Lakers",
            "Memphis Grizzlies",
            "Miami Heat",
            "Milwaukee Bucks",
            "Minnesota Timberwolves",
            "New Orleans Hornets",
            "New York Knicks",
            "Oklahoma City Thunder",
            "Orlando Magic",
            "Philadelphia Sixers",
            "Phoenix Suns",
            "Portland Trail Blazers",
            "Sacramento Kings",
            "San Antonio Spurs",
            "Toronto Raptors",
            "Utah Jazz",
            "Washington Wizards",
    };
    //-----------CONSTRUCTORS--------------
    public team() {
        teamSize = 0;
        setCurrentPlayer(0);
    }
    public team(int n) {
        teamSize = 0;
        players = new player[n];
        for (i = 0; i < n; i++) {
            players[i] = new player();
        }
        setCurrentPlayer(0);
    }
    //--------------CLEAR--------------
    public void clearPlayers() {
        for (i = 0; i < teamSize; i++) {
            players[i].clear();
        }
        setCurrentPlayer(0);
    }
    //---------------SETTERS-----------
    public void setTeamName(String nam) { this.teamName = nam; }
    public void setCurrentPlayer(int n) { this.currentPlayer = n; }

    //-------------GETTERS-----------
    public String getTeamName() { return this.teamName; }

    //------------ADD-------------
    public void addPlayer(String nam, String sur, int ag, int num, double ear) {
        players[teamSize].set(nam, sur, ag, num, ear);
        teamSize++;
    }
    /*
    public void addFound(player object) {
        temp = object;
        players[currentFound] = temp;
        currentFound++;
    }
    */
    //-----------DELETE-----------
    public void deletePlayer(int n) {
        players[n].setName(players[teamSize - 1].getName());
        players[n].setSurname(players[teamSize - 1].getSurname());
        players[n].setAge(players[teamSize - 1].getAge());
        players[n].setNumber(players[teamSize - 1].getNumber());
        players[n].setEarnings(players[teamSize - 1].getEarnings());
        players[teamSize - 1].clear();
        teamSize--;
    }
    //-------------PRINT--------------
    public void printTeamName() {
        System.out.println(teamName);
    }
    public void printPlayers() {
        printTeamName(); //testowo
        for (i = 0; i < teamSize; i++) {
            players[i].printAll();
        }
    }
    public void printCurrentPlayer() {
        players[getCurrentPlayer()].printAll();
    }

    //---------------SORT PLAYERS--------------------
    public void sortPlayersByEarningsAscending() {
        for (i = 0; i < teamSize; i++) {
            for (int j = 1; j < teamSize; j++) {
                if (players[j ].earnings < players[j - 1].earnings) {
                    temp = players[j - 1];
                    players[j - 1] = players[j];
                    players[j] = temp;
                }
            }
        }
    }
    public void sortPlayersByEarningsDescending() {
        for (i = 0; i < teamSize; i++) {
            for (int j = 1; j < teamSize; j++) {
                if (players[j ].earnings > players[j - 1].earnings) {
                    temp = players[j - 1];
                    players[j - 1] = players[j];
                    players[j] = temp;
                }
            }
        }
    }
    public void sortPlayersByAgeAscending() {
        for (i = 0; i < teamSize; i++) {
            for (int j = 1; j < teamSize; j++) {
                if (players[j ].age < players[j - 1].age) {
                    temp = players[j - 1];
                    players[j - 1] = players[j];
                    players[j] = temp;
                }
            }
        }
    }
    public void sortPlayersByAgeDescending() {
        for (i = 0; i < teamSize; i++) {
            for (int j = 1; j < teamSize; j++) {
                if (players[j ].age > players[j - 1].age) {
                    temp = players[j - 1];
                    players[j - 1] = players[j];
                    players[j] = temp;
                }
            }
        }
    }
    public void sortPlayersByNameAscending() {
        for (i = 0; i < teamSize; i++) {
            for (int j = 1; j < teamSize; j++) {
                if (players[j-1].name.compareTo(players[j].name) > 0) {
                    temp = players[j - 1];
                    players[j - 1] = players[j];
                    players[j] = temp;
                }
            }
        }
    }
    public void sortPlayersByNameDescending() {
        for (i = 0; i < teamSize; i++) {
            for (int j = 1; j < teamSize; j++) {
                if (players[j-1].name.compareTo(players[j].name) < 0) {
                    temp = players[j - 1];
                    players[j - 1] = players[j];
                    players[j] = temp;
                }
            }
        }
    }
    //--------------SEARCH FOR PLAYERS--------------
    public boolean searchTeamByEarnings(int i, double min, double max) {
        if(players[i].earnings >= min && players[i].earnings <= max) return true;
        else return false;
    }
    public boolean searchTeamByAge(int i, int min, int max) {
        if(players[i].age >= min && players[i].age <= max) return true;
        else return false;
    }
    public boolean searchTeamBySurname(int i, String search) {
        if (players[i].surname.equals(search)) return true;
        else return false;
    }
    //------------SAVE TEAM TO FILE--------------
    public void saveToFile() {
        FileOutputStream saveStream = null;
        File file = new File(teamName + ".dat");
        try { saveStream = new FileOutputStream(file); }
        catch (FileNotFoundException e) {
           System.err.println("ERROR " + e + "\n> FILE NOT FOUND");
           System.exit(-1);
        }

        DataOutputStream ds = new DataOutputStream(saveStream);
        try { ds.writeInt(teamSize); }
        catch (IOException e) {
            System.err.println("ERROR " + e + "\n> FAILED TO SAVE NUMBER OF ELEMENTS");
            System.exit(-1);
        }

        for(i = 0; i < teamSize; i++) {
            try {
                ds.writeUTF(players[i].name);
                ds.writeUTF(players[i].surname);
                ds.writeInt(players[i].age);
                ds.writeInt(players[i].number);
                ds.writeDouble(players[i].earnings);
            }
            catch (IOException e) {
                System.err.println("ERROR " + e + "\n> FAILED TO SAVE ELEMENT NUMBER " + i);
                System.exit(-1);
            }
        }
        try { ds.close(); }
        catch (IOException e) {
            System.err.println("ERROR " + e + "\n> FAILED TO CLOSE DATA STREAM");
            System.exit(-1);
        }

        try { saveStream.close(); }
        catch (IOException e) {
            System.err.println("ERROR " + e + "\n> COULD NOT CLOSE SAVE STREAM");
            System.exit(-1);
        }
    }
    //-------------LOAD TEAM FROM FILE---------------
    public void loadFromFile(String fileName) {
        FileInputStream readStream = null;
        File file = new File(fileName + ".dat");

        try { readStream = new FileInputStream(file); }
        catch (FileNotFoundException e) {
            System.err.println("ERROR " + e + "\n> FAILED TO FIND FILE " + fileName + ".dat");
        }

        DataInputStream ds = new DataInputStream(readStream);
        try { teamSize = ds.readInt();
            System.out.println(teamSize); }
        catch (IOException e) {
            System.err.println("ERROR " + e + "\n> FAILED TO READ NUMBER OF ELEMENTS");
            System.exit(-1);
        }

        for (i = 0; i < teamSize; i++) {
            try {
                players[i].name = ds.readUTF();
                players[i].surname = ds.readUTF();
                players[i].age = ds.readInt();
                players[i].number = ds.readInt();
                players[i].earnings = ds.readDouble();
            }
            catch (IOException e) {
                System.err.println("ERROR " + e + "\n> FAILED TO READ ELEMENT NUMBER " + i);
                System.exit(-1);
            }
        }

        try { ds.close(); }
        catch (IOException e) {
            System.err.println("ERROR " + e + "\n> FAILED TO CLOSE DATA STREAM");
            System.exit(-1);
        }
        try { readStream.close(); }
        catch (IOException e) {
            System.err.println("ERROR " + e + "\n> FAILED TO CLOSE INPUT STREAM");
            System.exit(-1);
        }
    }
    //---------------EXPORT TO TXT----------------------
    public void exportToTxt() throws IOException {
        deleteFile();
        File file = new File( "backup/" + teamName + ".txt");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file, true);
            for(i = 0; i < teamSize; i++) {
                fr.write(players[i].name + " " +
                            players[i].surname + " " +
                            players[i].age + " " +
                            players[i].number + " " +
                            players[i].earnings + "\n");
            }
        }
        catch (IOException e) {
            System.out.println("ERROR " + e + " SAVING COULD NOT BE COMPLETED");
        }
        finally {
            fr.close();
            System.out.println("SAVED AND CLOSED " + file);
        }
    }
    public void deleteFile() {
        try {
            File file = new File("backup/" + teamName + ".txt");
            if (file.delete()) {
                System.out.println( file.getName() + " DELETED");
            }
            else {
                System.out.println("DELETE OPERATION FAILED");
            }
        }
        catch (Exception e) {
            System.out.println("ERROR " + e);
        }
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }
}
