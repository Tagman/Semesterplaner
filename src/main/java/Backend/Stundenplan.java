package Backend;

/**
 * Created by Chris on 05.12.2016.
 */

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Stundenplan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long IDStundenplan;

    @Transient
    private ArrayList<Fach> faecher = new ArrayList<Fach>();

    @ManyToOne
    private Semesterplan semesterplan;

    public Stundenplan(ArrayList<Fach> f)
    {
        this.faecher = f;
    }

    public Stundenplan(){
        faecher = null;
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
