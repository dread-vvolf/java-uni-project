package project;

import java.io.*;
import java.util.Base64;

public class validation {
    protected String login, password;
    protected String l1, l2;
    protected String p1, p2;
    protected boolean valid;

    protected String encoded, decoded;
    protected byte[] acc;

    BufferedReader reader;

    int n;

    public validation() throws IOException {
        File file1 = new File("logins.txt");
        File file2 = new File("passwords.txt");
        if (!file1.exists()) file1.createNewFile();
        if (!file2.exists()) file2.createNewFile();
    }
    public String encode(String text) {
        encoded = Base64.getEncoder().encodeToString(text.getBytes());
        return encoded;
    }
    public String decode(String text) {
        acc = Base64.getDecoder().decode(text);
        decoded = new String(acc);
        return decoded;
    }
    public void saveToFile(String login, String password) {
        File file1 = new File("logins.txt");
        File file2 = new File("passwords.txt");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file1, true);
            fr.write(login + "\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fr = new FileWriter(file2, true);
            fr.write(password + "\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setLogin(String login) { this.login = login; }
    public void setPassword(String password) { this.password = password; }

    //---------------COMPARE-------------------
    public boolean checkLogin(String login) {
        n = 0;
        setLogin(login);
        l1 = encode(login);
        login = l1;
        try {
            reader = new BufferedReader(new FileReader
                    ("logins.txt"));
            String line = reader.readLine();
            while (line != null) {
                //line = reader.readLine();
                if (login.equals(line)) {
                    n++;
                    return true;
                }
                else {
                    n++;
                }
                line = reader.readLine();
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean checkPassword(String password) {
        setPassword(password);
        p1 = encode(password);
        password = p1;
        try {
            reader = new BufferedReader(new FileReader
                    ("logins.txt"));
            String line = null;
            for (int i = 0; i < n; i++) {
                line = reader.readLine();
            }
            if (password.equals(line)) return true;
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    //------------------REGISTER------------------
    public boolean register(String l, String p) {
        valid = checkLogin(l);
        if (!valid) {
            l2 = encode(l);
            p2 = encode(p);
            saveToFile(l2, p2);
            return true;
        }
        else return false;
    }
    //-------------LOG IN------------------
    public boolean logIn(String l, String p) {
        valid = checkLogin(l);
        if (valid) valid = checkPassword(p);
        else return false;
        if (valid) return true;

        return false;
    }
}
