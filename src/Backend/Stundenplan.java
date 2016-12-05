package Backend;

/**
 * Created by Chris on 05.12.2016.
 */

import java.util.ArrayList;


public class Stundenplan {

    private ArrayList<Fach> faecher = new ArrayList<Fach>();

    public Stundenplan(ArrayList<Fach> f)
    {
        this.faecher = f;
    }

    public void addFach(Fach f)
    {
        faecher.add(f);
    }

    public ArrayList<Fach> getFaecher()
    {
        return this.faecher;
    }

    public void changeFaecher(ArrayList<Fach> f)
    {
        this.faecher = f;
    }
}
