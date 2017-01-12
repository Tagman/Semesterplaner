package Backend;

/**
 * Created by Chris on 05.12.2016.
 */

import javax.persistence.*;
import java.util.List;
import java.util.List;

@Entity
public class Stundenplan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long IDStundenplan;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Fach> faecher;


    @ManyToOne(cascade = CascadeType.ALL)
    private Semesterplan semesterplan;


    public Stundenplan(List<Fach> f)
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

    public List<Fach> getFaecher()
    {
        return this.faecher;
    }

    public void changeFaecher(List<Fach> f)
    {
        this.faecher = f;
    }

    public long getIDStundenplan() {
        return IDStundenplan;
    }

    public void setIDStundenplan(long IDStundenplan) {
        this.IDStundenplan = IDStundenplan;
    }

    public void setFaecher(List<Fach> faecher) {
        this.faecher = faecher;
    }

    public Semesterplan getSemesterplan() {
        return semesterplan;
    }

    public void setSemesterplan(Semesterplan semesterplan) {
        this.semesterplan = semesterplan;
    }
}
