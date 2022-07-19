package project;

public class stats extends player{
    protected float points;
    protected float rebounds;
    protected float threePointers;
    protected float steals;

    public stats(String nam, String sur, int ag, int num, float ear, float poi) {
        super(nam, sur, ag, num, ear);
        points = poi;

    }
}
