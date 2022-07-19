package project;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        league l = new league(30);
        gui g = new gui();
        validation v = new validation();
        //final int[] selectedRow = new int[1];
        //l.saveAllTeams();
        l.loadAllTeams();
        g.constructLogIn();
        g.b6.setEnabled(false);
        g.l1.addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
                String login, password;
                boolean checked;
                login = g.login.getText();
                password = g.password.getText();
                System.out.println("start");
                checked = v.checkLogin(login);

                if (checked) {
                    System.out.println("login good");
                    checked = v.checkPassword(password);

                }
                else g.infoBox("Wrong login! Try again.", "Error");
                if (checked) {
                    System.out.println("pswd good");
                    g.admin = true;
                    g.logIn.setVisible(false);
                    g.constructGUI();
                }
                else g.infoBox("Wrong password! Try again.", "Error");
            }
        });
        g.l2.addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
                g.admin = false;
                g.logIn.setVisible(false);
                g.constructGUI();
                g.b3.setEnabled(false);
                g.b4.setEnabled(false);
                g.b5.setEnabled(false);
                g.b6.setEnabled(false);
                g.t3.setEnabled(false);
                g.t4.setEnabled(false);
                g.p2.setEnabled(false);
                g.p3.setEnabled(false);
            }
        });
        //main screen
        //table pane
        g.b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (g.admin == true) System.out.println("1"); //test

                l.currentTeam = 0;

                g.teamName.setText(l.teams[l.currentTeam].teamName);
                //l.currentTeam[current]
                resetTable(g,l);
                resetTable(g,l);

                g.RightPanel.remove(g.playerData);
                g.RightPanel.add(g.teamData);
                g.teamData.setVisible(true);
                g.RightPanel.revalidate();
                g.RightPanel.repaint();

                g.b1.setEnabled(false);
                l.teams[l.currentTeam].setCurrentPlayer(0);
            }
        });
        g.table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println(g.table.getSelectedRow());
                if((g.table.getSelectedRow()) < 0) {
                    l.teams[l.currentTeam].setCurrentPlayer(0);
                    if (g.s) l.search.currentFound = 0;
                }
                else if (g.s) {
                    l.search.currentFound = g.table.getSelectedRow();
                    if (l.search.currentFound == -1) l.search.currentFound = 0;
                    System.out.println("currentFound " + l.search.currentFound);
                    String s = Double.toString(l.search.players[l.search.currentFound].earnings);
                    g.pname.setText("Name: " + l.search.players[l.search.currentFound].getName());
                    g.psurname.setText("Surname: " + l.search.players[l.search.currentFound].getSurname());
                    g.page.setText("Age: " + Integer.toString(l.search.players[l.search.currentFound].getAge()));
                    g.pnumber.setText("Number: " + Integer.toString(l.search.players[l.search.currentFound].getNumber()));
                    g.pearnings.setText("Earnings: " + s);
                }
                else l.teams[l.currentTeam].setCurrentPlayer(g.table.getSelectedRow());

                //System.out.println(l.teams[l.currentTeam].getCurrentPlayer());
                g.RightPanel.remove(g.teamData);
                g.RightPanel.add(g.playerData);

                if(!g.s) setData(g, l);

                g.playerData.setVisible(true);
                g.RightPanel.revalidate();
                g.RightPanel.repaint();

            }
        });
        g.tback.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                System.out.println("back");
                    //g.tableModel.setRowCount(0);
                        for (int i = 0; i < 30; i++) {
                            l.teams[i].setCurrentPlayer(0);
                        }
                    g.teamData.setVisible(false);
                    g.RightPanel.remove(g.teamData);
                    l.shown = false;
                    g.b1.setEnabled(true);
                    g.s = false;

                    if (g.admin) {
                        g.b1.setEnabled(true);
                        g.t1.setEnabled(true);
                        g.t2.setEnabled(true);
                        g.t3.setEnabled(true);
                        g.t4.setEnabled(true);
                        g.t5.setEnabled(true);
                    }
            }
        });
        g.t1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l.previousTeam();
                g.teamName.setText(l.teams[l.currentTeam].teamName);
                resetTable(g,l);
            }
        });
        g.t2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.selectSort();
                g.sort1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        l.teams[l.currentTeam].sortPlayersByAgeAscending();
                        g.sort.setVisible(false);
                        resetTable(g,l);
                    }});
                g.sort2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        l.teams[l.currentTeam].sortPlayersByAgeDescending();
                        g.sort.setVisible(false);
                        resetTable(g,l);
                    }});
                g.sort3.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        l.teams[l.currentTeam].sortPlayersByNameAscending();
                        g.sort.setVisible(false);
                        resetTable(g,l);
                    }});
                g.sort4.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        l.teams[l.currentTeam].sortPlayersByNameDescending();
                        g.sort.setVisible(false);
                        resetTable(g,l);
                    }});
                g.sort5.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        l.teams[l.currentTeam].sortPlayersByEarningsAscending();
                        g.sort.setVisible(false);
                        resetTable(g,l);
                    }});
                g.sort6.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        l.teams[l.currentTeam].sortPlayersByEarningsDescending();
                        g.sort.setVisible(false);
                        resetTable(g,l);
                    }});
            }
        });
        g.t3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.add();
            }
        });
        g.add1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] tab = new int[5];

                if (g.name.getText() == "" || isNumeric(g.name.getText()) == true) tab[0] = 1;
                if (g.surname.getText() == "" || isNumeric(g.surname.getText()) == true) tab[1] = 1;
                if (Integer.parseInt(g.age.getText()) < 18 || isNumeric(g.age.getText()) == false) tab[2] = 1;
                if (isNumeric(g.number.getText()) == false) tab[3] = 1;
                //if (isNumeric(g.earnings.getText()) == false) tab[4] = 1;

                if (tab[0] == 1) {
                    g.infoBox("Wrong name!", "Error");
                }
                else if (tab[1] == 1) {
                    g.infoBox("Wrong surname!", "Error");
                }
                else if (tab[2] == 1) {
                    g.infoBox("Please input number above equal or above 18!", "Error");
                }
                else if (tab[3] == 1) {
                    g.infoBox("Please input number!", "Error");
                }
                else if (tab[4] == 1) {
                    g.infoBox("Please input number!", "Error");
                }
                else if (tab[0] == 0 || tab[1] == 0 || tab[2] == 0 || tab[3] == 0 || tab[4] == 0) {
                    g.add.setVisible(false);
                    l.addPlayerToCurrentTeam(
                            g.name.getText(),
                            g.surname.getText(),
                            Integer.parseInt(g.age.getText()),
                            Integer.parseInt(g.number.getText()),
                            Double.parseDouble(g.earnings.getText()));
                            l.teams[l.currentTeam].saveToFile();
                            g.infoBox("Player added!", "Message");
                            resetTable(g, l);
                            clearAdd(g);
                }
            }
        });
        g.t4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    l.teams[l.currentTeam].exportToTxt();
                    g.infoBox("Exported to .txt file!", "Message");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    g.infoBox("Export could not be completed!", "Message");
                }
            }
        });
        g.t5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l.nextTeam();
                g.teamName.setText(l.teams[l.currentTeam].getTeamName());
                resetTable(g, l);
            }
        });
        //player pane
        g.pback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!g.s) resetTable(g, l);

                l.teams[l.currentTeam].setCurrentPlayer(0);

                g.RightPanel.add(g.teamData);
                g.teamData.setVisible(true);

                g.RightPanel.revalidate();
                g.RightPanel.repaint();

                g.RightPanel.remove(g.playerData);
                g.RightPanel.add(g.teamData);
                g.teamData.setVisible(true);
                g.RightPanel.revalidate();
                g.RightPanel.repaint();
            }
        });
        g.p1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l.teams[l.currentTeam].setCurrentPlayer(l.teams[l.currentTeam].getCurrentPlayer() - 1);
                if (l.teams[l.currentTeam].getCurrentPlayer() < 0)
                    l.teams[l.currentTeam].setCurrentPlayer(0);
                System.out.println(l.teams[l.currentTeam].getCurrentPlayer());
                if(!g.s) setData(g, l);
                else {
                    if (l.search.currentFound > 0) l.search.currentFound--;
                    if (l.search.currentFound == -1) l.search.currentFound = 0;
                    String s = Double.toString(l.search.players[l.search.currentFound].earnings);
                    g.pname.setText("Name: " + l.search.players[l.search.currentFound].getName());
                    g.psurname.setText("Surname: " + l.search.players[l.search.currentFound].getSurname());
                    g.page.setText("Age: " + Integer.toString(l.search.players[l.search.currentFound].getAge()));
                    g.pnumber.setText("Number: " + Integer.toString(l.search.players[l.search.currentFound].getNumber()));
                    g.pearnings.setText("Earnings: " + s);
                }
            }
        });
        g.p2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.name.setText(l.teams[l.currentTeam].players[l.teams[l.currentTeam].getCurrentPlayer()].getName());
                g.surname.setText(l.teams[l.currentTeam].players[l.teams[l.currentTeam].getCurrentPlayer()].getSurname());
                g.age.setText(Integer.toString(l.teams[l.currentTeam].players[l.teams[l.currentTeam].getCurrentPlayer()].getAge()));
                g.number.setText(Integer.toString(l.teams[l.currentTeam].players[l.teams[l.currentTeam].getCurrentPlayer()].getNumber()));
                g.earnings.setText(Double.toString(l.teams[l.currentTeam].players[l.teams[l.currentTeam].getCurrentPlayer()].getEarnings()));
                g.edit();
            }
        });
        g.edit1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l.teams[l.currentTeam].players[l.teams[l.currentTeam].getCurrentPlayer()].setName(g.name.getText());
                l.teams[l.currentTeam].players[l.teams[l.currentTeam].getCurrentPlayer()].setSurname(g.surname.getText());
                l.teams[l.currentTeam].players[l.teams[l.currentTeam].getCurrentPlayer()].setAge(Integer.parseInt(g.age.getText()));
                l.teams[l.currentTeam].players[l.teams[l.currentTeam].getCurrentPlayer()].setNumber(Integer.parseInt(g.number.getText()));
                l.teams[l.currentTeam].players[l.teams[l.currentTeam].getCurrentPlayer()].setEarnings(Double.parseDouble(g.earnings.getText()));
                l.saveAllTeams();
                setData(g, l);
                g.edit.setVisible(false);
                g.infoBox("EDITED SUCCESSFULLY!", "Message");
            }
        });
        g.p3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(l.teams[l.currentTeam].getCurrentPlayer());
                l.teams[l.currentTeam].deletePlayer(l.teams[l.currentTeam].getCurrentPlayer());
                l.printCurrentTeam();
                resetTable(g,l);
            }
        });
        g.p4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l.teams[l.currentTeam].setCurrentPlayer(l.teams[l.currentTeam].getCurrentPlayer() + 1);
                if (l.teams[l.currentTeam].getCurrentPlayer() > l.teams[l.currentTeam].teamSize - 1)
                    l.teams[l.currentTeam].setCurrentPlayer(l.teams[l.currentTeam].teamSize - 1);
                System.out.println(l.teams[l.currentTeam].getCurrentPlayer());
                if(!g.s) setData(g, l);
                else {
                    l.search.currentFound++;
                    System.out.println("current " + l.search.currentFound);
                    System.out.println("total " + l.totalFound);
                    if (l.search.currentFound == l.totalFound) l.search.currentFound--;
                    if (l.search.currentFound == -1) l.search.currentFound = 0;
                    String s = Double.toString(l.search.players[l.search.currentFound].earnings);
                    g.pname.setText("Name: " + l.search.players[l.search.currentFound].getName());
                    g.psurname.setText("Surname: " + l.search.players[l.search.currentFound].getSurname());
                    g.page.setText("Age: " + Integer.toString(l.search.players[l.search.currentFound].getAge()));
                    g.pnumber.setText("Number: " + Integer.toString(l.search.players[l.search.currentFound].getNumber()));
                    g.pearnings.setText("Earnings: " + s);
                }
            }
        });

        g.b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.search();
            }
        });
        g.search1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.searchNumber();
                g.search.setVisible(false);
                g.type = 0;
            }
        });
        g.search2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.searchNumber();
                g.search.setVisible(false);
                g.type = 1;
            }
        });
        g.search3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.searchString();
                g.search.setVisible(false);
                g.type = 2;
            }
        });
        g.confirmSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.search.setVisible(false);
                g.s = true;

                if (g.type == 0) {
                    g.searchn.setVisible(false);
                    l.searchLeagueByEarnings(Double.parseDouble(g.min.getText()), Double.parseDouble(g.max.getText()));
                    searchTable(g, l);
                }
                if (g.type == 1) {
                    g.searchn.setVisible(false);
                    l.searchLeagueByAge(Integer.parseInt(g.min.getText()), Integer.parseInt(g.max.getText()));
                    searchTable(g, l);
                }
                if (g.type == 2) {
                    g.searchs.setVisible(false);
                    l.searchLeagueBySurname(g.ssur.getText());
                    searchTable(g, l);
                }

                g.RightPanel.remove(g.playerData);
                g.RightPanel.add(g.teamData);
                g.teamData.setVisible(true);
                g.RightPanel.revalidate();
                g.RightPanel.repaint();

                g.b1.setEnabled(false);
                g.t1.setEnabled(false);
                g.t2.setEnabled(false);
                g.t3.setEnabled(false);
                g.t4.setEnabled(false);
                g.t5.setEnabled(false);
            }
        });
        g.b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l.clearAllTeams();
                g.infoBox("All data cleared. To save, select 'Save all data' option.", "Message");
                resetTable(g, l);
            }
        });
        g.b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l.deleteTeams();
                l.saveAllTeams();
                g.infoBox("All changes saved!", "Message");
            }
        });
        g.b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    l.backUpLeague();
                    g.infoBox("Backup succesful!", "Message");
                } catch (IOException ioException) {
                    g.infoBox("Backup could not be completed!", "Error");
                    ioException.printStackTrace();
                }
            }
        });
        g.b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("6");
            }
        });

    }
    public static void resetTable(gui g, league l) {
        g.tableModel.setRowCount(0);
        for (int i = 0; i < 15; i++) {
            g.tableModel.insertRow(i, new Object[] {
                    l.teams[l.currentTeam].players[i].name,
                    l.teams[l.currentTeam].players[i].surname,
                    l.teams[l.currentTeam].players[i].age,
                    l.teams[l.currentTeam].players[i].number,
                    l.teams[l.currentTeam].players[i].earnings
            });
        }
        System.out.println("teamSize " + l.teams[l.currentTeam].teamSize);
        if (l.teams[l.currentTeam].teamSize == 15) g.t3.setEnabled(false);
        else g.t3.setEnabled(true);
        g.RightPanel.revalidate();
        g.RightPanel.repaint();
    }
    public static void searchTable(gui g, league l) {
        g.teamName.setText("SEARCH RESULTS");
        g.tableModel.setRowCount(0);
        for(int i = 0; i < 100; i++) {
            g.tableModel.insertRow(i , new Object[] {
                l.search.players[i].name,
                l.search.players[i].surname,
                l.search.players[i].age,
                l.search.players[i].number,
                l.search.players[i].earnings
            });
        }
    }
    public static void clearAdd(gui g) {
        g.name.setText("");
        g.surname.setText("");
        g.age.setText("");
        g.number.setText("");
        g.earnings.setText("");
    }
    public static boolean isNumeric(String s) {
        if (s == null || s.equals("")) {
            return false;
        }
        return s.chars().allMatch(Character::isDigit);
    }
    public static void setData(gui g, league l) {
        String s = Double.toString(l.teams[l.currentTeam].players[l.teams[l.currentTeam].getCurrentPlayer()].earnings);
        g.pname.setText("Name: " + l.teams[l.currentTeam].players[l.teams[l.currentTeam].getCurrentPlayer()].getName());
        g.psurname.setText("Surname: " + l.teams[l.currentTeam].players[l.teams[l.currentTeam].getCurrentPlayer()].getSurname());
        g.page.setText("Age: " + Integer.toString(l.teams[l.currentTeam].players[l.teams[l.currentTeam].getCurrentPlayer()].getAge()));
        g.pnumber.setText("Number: " + Integer.toString(l.teams[l.currentTeam].players[l.teams[l.currentTeam].getCurrentPlayer()].getNumber()));
        g.pearnings.setText("Earnings: " + s);
    }
}
/*
                if (g.s) {
                    l.search.currentFound = g.table.getSelectedRow();
                    String s = Double.toString(l.search.players[g.table.getSelectedRow()].earnings);
                    g.pname.setText("Name: " + l.search.players[g.table.getSelectedRow()].getName());
                    g.psurname.setText("Surname: " + l.search.players[g.table.getSelectedRow()].getSurname());
                    g.page.setText("Age: " + Integer.toString(l.search.players[g.table.getSelectedRow()].getAge()));
                    g.pnumber.setText("Number: " + Integer.toString(l.search.players[g.table.getSelectedRow()].getNumber()));
                    g.pearnings.setText("Earnings: " + s);
                }
                */