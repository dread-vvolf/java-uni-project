package project;

public class player {
    //----------VARIABLES-------------
    protected String name;
    protected String surname;
    protected int age;
    protected int number;
    protected double earnings;

    //-----------CONSTRUCTORS--------------
    public player() {
        name = "";
        surname = "";
        age = 0;
        number = 0;
        earnings = 0;
    }
    public player(String nam, String sur, int ag, int num, double ear) {
        name = nam;
        surname = sur;
        age = ag;
        number = num;
        earnings = ear;
    }
    //------------CLEAR--------------
    public void clear() {
        name = "";
        surname = "";
        age = 0;
        number = 0;
        earnings = 0;
    }
    //------------SETTERS------------
    public void set(String name, String sur, int ag, int num, double ear) {
        this.name = name;
        this.surname = sur;
        this.age = ag;
        this.number = num;
        this.earnings = ear;
    }
    public void setAll(String n, String s, int a, int num, double e) {
        name = n; surname = s; age = a; number = num; earnings = e;
    }
    public void setName(String nam) { this.name = nam; }
    public void setSurname(String sur) { this.surname = sur; }
    public void setAge(int ag) { this.age = ag; }
    public void setNumber(int num) { this.number = num; }
    public void setEarnings(double ear) { this.earnings = ear; }

    //------------GETTERS-------------
    public String getName() { return this.name; }
    public String getSurname() { return this.surname; }
    public int getAge() { return this.age; }
    public int getNumber() { return this.number; }
    public double getEarnings() { return this.earnings; }

    //------------PRINT---------------
    public void printAll() {
        System.out.print(name + " ");
        System.out.print(surname + " ");
        System.out.print(age + " ");
        System.out.print(number + " ");
        System.out.print(earnings + "\n");
    }
}
