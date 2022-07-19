package project;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

public class gui extends JPanel {
    int i, n;
    boolean admin;
    JFrame mainframe, logIn, search, searchs, searchn, sort, add, confirm;
    JPanel menu;

    JPanel content;
    DefaultTableModel tableModel = new DefaultTableModel();
    //login
    JTextField login, password;
    JButton l1, l2;
    JLabel lheader;
    JPanel lp1, lp2, lp3;

    //menu
    JButton b1 = new JButton();
    JButton b2 = new JButton();
    JButton b3 = new JButton();
    JButton b4 = new JButton();
    JButton b5 = new JButton();
    JButton b6 = new JButton();
    JLabel header = new JLabel();
    JLabel footer = new JLabel();

    //team
    JPanel teamData;
    JScrollPane tablePane;
    JTable table;
    JPanel tableMenu;
    JPanel teamHeader;
    JLabel teamName = new JLabel();
    JButton tback = new JButton();
    JButton t1 = new JButton();
    JButton t2 = new JButton();
    JButton t3 = new JButton();
    JButton t4 = new JButton();
    JButton t5 = new JButton();

    //sort
    JPanel sortPane;
    JButton sort1 = new JButton(),
            sort2 = new JButton(),
            sort3 = new JButton(),
            sort4 = new JButton(),
            sort5 = new JButton(),
            sort6 = new JButton();

    //search
    boolean s;
    int type;
    JPanel searchPane;
    JButton search1 = new JButton(),
            search2 = new JButton(),
            search3 = new JButton(),
            confirmSearch = new JButton("CONFIRM");
    JPanel searchString;
    JPanel searchNumber;
    JTextField
            min = new JTextField(),
            max = new JTextField(),
            ssur = new JTextField();

    //add
    JPanel addPane;
    JTextField
            name = new JTextField(),
            surname = new JTextField(),
            age = new JTextField(),
            number = new JTextField(),
            earnings = new JTextField();
    JLabel
            lname = new JLabel("Input First Name:"),
            lsurname = new JLabel("Input Surname:"),
            lage = new JLabel("Input Age:"),
            lnumber = new JLabel("Input Number:"),
            learnings = new JLabel("Input Earnings");

    JButton add1 = new JButton("OK");

    //player
    JPanel playerData;
    JPanel playerPane;
    JPanel playerMenu;
    JButton pback = new JButton();
    JButton p1 = new JButton();
    JButton p2 = new JButton();
    JButton p3 = new JButton();
    JButton p4 = new JButton();
    JLabel
            pname = new JLabel(),
            psurname = new JLabel(),
            page = new JLabel(),
            pnumber = new JLabel(),
            pearnings = new JLabel();
    //edit
    JButton edit1 = new JButton("OK");
    JFrame edit;

    JPanel LeftPanel, RightPanel;

    public gui() {
        //LEFT PANEL - MENU
        menu = new JPanel();
        LeftPanel = new JPanel();
        LeftPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        LeftPanel.setLayout(new GridBagLayout());

        //header
        header.setText("MENU");
        header.setFont(new Font("ROBOTO", Font.BOLD, 20));
        header.setForeground(Color.WHITE);
        Border border = BorderFactory.createLineBorder(Color.WHITE, 3);
        header.setBorder(border);
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setPreferredSize(new Dimension(150,40));
        LeftPanel.add(header, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(10, 0, 0, 0), 0, 0));

        //button 1
        b1.setText("Show all players");
        LeftPanel.add(b1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.2,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 10));

        //button 2
        b2.setText("Search league");
        LeftPanel.add(b2, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.2,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 10));

        //button 3
        b3.setText("Clear all data");
        LeftPanel.add(b3, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.2,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 10));

        //button 4
        b4.setText("Save all data");
        LeftPanel.add(b4, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.2,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 10));

        //button 5
        b5.setText("Backup League");
        LeftPanel.add(b5, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.2,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 10));

        //button 6
        b6.setText("Register new Admin");
        LeftPanel.add(b6, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.2,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 10));

        //---- footer ----
        footer.setText("Oskar Skop 4BDI 2021");
        footer.setForeground(Color.LIGHT_GRAY);
        LeftPanel.add(footer, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 10));

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.VERTICAL;
        c.insets = new Insets(0,1,1,1);
        LeftPanel.setPreferredSize(new Dimension(200,500));

        //RIGHT PANEL - CONTENT---------------
        RightPanel = new JPanel();
        RightPanel.setLayout(new BorderLayout());

        teamData = new JPanel();
        teamData.setLayout(new BorderLayout());

        playerData = new JPanel();
        playerData.setLayout(new BorderLayout());

        //team data
        teamHeader = new JPanel();
        teamName.setText("test");
        teamHeader.add(teamName);
        teamData.add(teamHeader, BorderLayout.PAGE_START);

        //table
        createTable();
        tablePane = new JScrollPane(table);
        teamData.add(tablePane, BorderLayout.CENTER);

        //table menu
        tableMenu = new JPanel();

        tback.setText("Back");
        tableMenu.add(tback);

        t1.setText("<- Previous");
        tableMenu.add(t1);

        t2.setText("Sort");
        tableMenu.add(t2);

        t3.setText("Add");
        tableMenu.add(t3);

        t4.setText("Export");
        tableMenu.add(t4);

        t5.setText("Next ->");
        tableMenu.add(t5);

        teamData.add(tableMenu, BorderLayout.PAGE_END);

        //player panel
        playerPane = new JPanel();
        playerPane.setLayout(new BoxLayout(playerPane, BoxLayout.PAGE_AXIS));
        playerPane.setBackground(Color.LIGHT_GRAY);
        playerPane.setBorder(BorderFactory.createEmptyBorder(100,50,50,50));

        pname.setFont(new Font("ROBOTO", Font.BOLD, 25));
        psurname.setFont(new Font("ROBOTO", Font.BOLD, 25));
        page.setFont(new Font("ROBOTO", Font.BOLD, 25));
        pnumber.setFont(new Font("ROBOTO", Font.BOLD, 25));
        pearnings.setFont(new Font("ROBOTO", Font.BOLD, 25));

        //pname.setAlignmentX(JLabel.CENTER_ALIGNMENT);


        playerPane.add(pname);
        playerPane.add(Box.createRigidArea(new Dimension(0, 10)));
        playerPane.add(psurname);
        playerPane.add(Box.createRigidArea(new Dimension(0, 10)));
        playerPane.add(page);
        playerPane.add(Box.createRigidArea(new Dimension(0, 10)));
        playerPane.add(pnumber);
        playerPane.add(Box.createRigidArea(new Dimension(0, 10)));
        playerPane.add(pearnings);

        playerData.add(playerPane, BorderLayout.CENTER);

        //player menu
        playerMenu = new JPanel();

        pback.setText("Back");
        playerMenu.add(pback);

        p1.setText("<- Previous");
        playerMenu.add(p1);

        p2.setText("Edit");
        playerMenu.add(p2);

        p3.setText("Delete");
        playerMenu.add(p3);

        p4.setText("Next ->");
        playerMenu.add(p4);

        playerData.add(playerMenu, BorderLayout.PAGE_END);
    }
    public void constructLogIn() {
        JLabel temp = new JLabel(), temp2 = new JLabel();
        logIn = new JFrame("Log in");
        logIn.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        logIn.setSize(300,200);
        logIn.setResizable(false);
        logIn.setLayout(new BorderLayout());
        logIn.setBackground(Color.DARK_GRAY);


        lp1 = new JPanel();
        lp2 = new JPanel();
        lp3 = new JPanel();
        lp2.setLayout(new BoxLayout(lp2, BoxLayout.PAGE_AXIS));
        lp2.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));

        lheader = new JLabel("LOG IN");
        lheader.setFont(new Font("ROBOTO", Font.BOLD, 15));
        lheader.setForeground(Color.WHITE);
        lp3.setBackground(Color.DARK_GRAY);

        login = new JTextField();
        login.setSize(50,50);
        password = new JTextField("", 20);
        l1 = new JButton("OK");
        l2 = new JButton("SKIP");

        lp3.add(lheader, BorderLayout.PAGE_START);
        temp.setText("Login:");
        lp2.add(temp);
        lp2.add(login, BorderLayout.CENTER);
        temp2.setText("Password:");
        lp2.add(temp2);
        lp2.add(password, BorderLayout.CENTER);
        lp1.add(l1);
        lp1.add(l2);
        logIn.add(lp3, BorderLayout.PAGE_START);
        logIn.add(lp2, BorderLayout.CENTER);
        logIn.add(lp1, BorderLayout.PAGE_END);

        logIn.setLocationRelativeTo(null);
        logIn.setVisible(true);
    }
    public void constructGUI() {
        mainframe = new JFrame("Oskar Skop - Projekt");

        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainframe.setSize(700,500);
        mainframe.setResizable(false);
        mainframe.setLayout(new BorderLayout());

        //left panel
        LeftPanel.setBackground(Color.DARK_GRAY);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.VERTICAL;
        mainframe.add(LeftPanel, BorderLayout.WEST);
        mainframe.add(RightPanel);
        mainframe.setLocationRelativeTo(null);
        mainframe.setVisible(true);
    }
    public void search() {
        search = new JFrame("SEARCH");
        search.setLayout(new BorderLayout());
        search.setResizable(false);
        search.setLocationRelativeTo(null);
        search.setSize(new Dimension(230, 230));

        searchPane = new JPanel();
        searchPane.setBackground(Color.DARK_GRAY);
        searchPane.setLayout(new GridBagLayout());
        searchPane.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        search1.setText("By earnings");
        search2.setText("By age");
        search3.setText("By surname");

        searchPane.add(search1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.2, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0,0,0,0),0,10));
        searchPane.add(search2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.2, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0,0,0,0),0,10));
        searchPane.add(search3, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.2, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0,0,0,0),0,10));

        search.add(searchPane, BorderLayout.CENTER);
        search.setVisible(true);
    }
    public void searchString() {
        searchs = new JFrame("SEARCH");
        searchs.setLayout(new BorderLayout());
        searchs.setResizable(false);
        searchs.setLocationRelativeTo(null);
        searchs.setSize(new Dimension(230, 230));

        searchString = new JPanel();
        searchString.setBackground(Color.DARK_GRAY);
        searchString.setLayout(new GridBagLayout());
        searchString.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        ssur.setText("Input searched surname");

        searchString.add(ssur, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.2, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0,0,0,0),0,10));
        searchString.add(confirmSearch, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.2, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0,0,0,0),0,10));

        searchs.add(searchString, BorderLayout.CENTER);
        searchs.setVisible(true);
    }
    public void searchNumber() {
        searchn = new JFrame("SEARCH");
        searchn.setLayout(new BorderLayout());
        searchn.setResizable(false);
        searchn.setLocationRelativeTo(null);
        searchn.setSize(new Dimension(230, 230));

        searchNumber = new JPanel();
        searchNumber.setBackground(Color.DARK_GRAY);
        searchNumber.setLayout(new GridBagLayout());
        searchNumber.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        min.setText("Input minimal value");
        max.setText("Input maximum value");

        searchNumber.add(min, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.2, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0,0,0,0),0,10));
        searchNumber.add(max, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.2, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0,0,0,0),0,10));
        searchNumber.add(confirmSearch, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.2, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0,0,0,0),0,10));

        searchn.add(searchNumber, BorderLayout.CENTER);
        searchn.setVisible(true);
    }
    public void selectSort() {
        sort = new JFrame("SORT");
        sort.setResizable(false);
        sort.setLocationRelativeTo(null);
        sort.setSize(new Dimension(230, 350));
        sortPane = new JPanel();
        sortPane.setBackground(Color.DARK_GRAY);
        sortPane.setLayout(new GridBagLayout());

        sort1.setText("By Age - Ascending");
        sort2.setText("By Age - Descending");
        sort3.setText("By Name - Ascending");
        sort4.setText("By Name - Descending");
        sort5.setText("By Earnings - Ascending");
        sort6.setText("By Earnings - Descending");

        sortPane.add(sort1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.2, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0,0,0,0),0,10));
        sortPane.add(sort2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.2, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0,0,0,0),0,10));
        sortPane.add(sort3, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.2, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0,0,0,0),0,10));
        sortPane.add(sort4, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.2, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0,0,0,0),0,10));
        sortPane.add(sort5, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.2, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0,0,0,0),0,10));
        sortPane.add(sort6, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.2, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0,0,0,0),0,10));
        sort.add(sortPane);
        sort.setVisible(true);
    }
    public void add() {
        add = new JFrame("ADD PLAYER");
        add.setLayout(new BorderLayout());
        add.setResizable(false);
        add.setLocationRelativeTo(null);
        add.setSize(300, 330);

        addPane = new JPanel();
        addPane.setLayout(new BoxLayout(addPane, BoxLayout.PAGE_AXIS));
        addPane.setBackground(Color.DARK_GRAY);
        addPane.setBorder(BorderFactory.createEmptyBorder(20,20,0,20));

        lname.setForeground(Color.WHITE);
        lsurname.setForeground(Color.WHITE);
        lage.setForeground(Color.WHITE);
        lnumber.setForeground(Color.WHITE);
        learnings.setForeground(Color.WHITE);

        addPane.add(lname);
        addPane.add(name);
        addPane.add(Box.createRigidArea(new Dimension(0, 10)));

        addPane.add(lsurname);
        addPane.add(surname);
        addPane.add(Box.createRigidArea(new Dimension(0, 10)));

        addPane.add(lage);
        addPane.add(age);
        addPane.add(Box.createRigidArea(new Dimension(0, 10)));

        addPane.add(lnumber);
        addPane.add(number);
        addPane.add(Box.createRigidArea(new Dimension(0, 10)));

        addPane.add(learnings);
        addPane.add(earnings);
        addPane.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel addPane2 = new JPanel();
        addPane2.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
        addPane2.setBackground(Color.DARK_GRAY);
        addPane2.add(add1, BorderLayout.CENTER);

        add.add(addPane, BorderLayout.PAGE_START);
        add.add(addPane2, BorderLayout.PAGE_END);
        add.setVisible(true);
    }
    public void edit() {
        edit = new JFrame("EDIT");
        edit.setLayout(new BorderLayout());
        edit.setResizable(false);
        edit.setLocationRelativeTo(null);
        edit.setSize(300, 330);


        JPanel editPane = new JPanel();
        editPane.setLayout(new BoxLayout(editPane, BoxLayout.PAGE_AXIS));
        editPane.setBackground(Color.DARK_GRAY);
        editPane.setBorder(BorderFactory.createEmptyBorder(20,20,0,20));

        lname.setForeground(Color.WHITE);
        lsurname.setForeground(Color.WHITE);
        lage.setForeground(Color.WHITE);
        lnumber.setForeground(Color.WHITE);
        learnings.setForeground(Color.WHITE);

        editPane.add(lname);
        editPane.add(name);
        editPane.add(Box.createRigidArea(new Dimension(0, 10)));

        editPane.add(lsurname);
        editPane.add(surname);
        editPane.add(Box.createRigidArea(new Dimension(0, 10)));

        editPane.add(lage);
        editPane.add(age);
        editPane.add(Box.createRigidArea(new Dimension(0, 10)));

        editPane.add(lnumber);
        editPane.add(number);
        editPane.add(Box.createRigidArea(new Dimension(0, 10)));

        editPane.add(learnings);
        editPane.add(earnings);
        editPane.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel editPane2 = new JPanel();
        editPane2.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
        editPane2.setBackground(Color.DARK_GRAY);
        editPane2.add(edit1, BorderLayout.CENTER);

        edit.add(editPane, BorderLayout.PAGE_START);
        edit.add(editPane2, BorderLayout.PAGE_END);
        edit.setVisible(true);
    }
    public void confirm() {

    }
    public void createTable() {
        table = new JTable(tableModel);

        tableModel.addColumn("First Name");
        tableModel.addColumn("Surname");
        tableModel.addColumn("Age");
        tableModel.addColumn("Number");
        tableModel.addColumn("Earnings");
    }

    public static void infoBox(String infoMessage, String windowTitle) {
        JOptionPane.showMessageDialog(null, infoMessage, windowTitle, JOptionPane.INFORMATION_MESSAGE);
    }
}
