package Backend;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Stundenplan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long IDStundenplan;

    @OneToMany(cascade = CascadeType.MERGE)
    private List<Fach> faecher;



    @ManyToOne(cascade = CascadeType.MERGE)
    private Semesterplan semesterplan;


    public Stundenplan(List<Fach> f)
    {
        this.faecher = f;
    }

    public Stundenplan(){
        faecher = new ArrayList<>();
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

    public Fach searchFach(String name){


        for(int i = 0; i < faecher.size(); i++){


            if (faecher.get(i).getName().toLowerCase().equals(name.toLowerCase())){

                return faecher.get(i);
            }
        }

        return null;

    }
}
