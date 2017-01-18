package Backend;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 04/12/16.
 */
@Entity
public class Fach {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long IDFach;


    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Einheit> einheiten;

    @ManyToOne(cascade = CascadeType.ALL)
    private Stundenplan stundenplan;

    public Fach(String name, List<Einheit> einheiten){
        this.name = name;
        this.einheiten = einheiten;
    }

    public Fach(){
        name = null;
        einheiten = null;
    }

    public Fach changeFach(String name, List<Einheit> einheiten){
        this.name = name;
        this.einheiten = einheiten;

        return this;
    }

    public List<Einheit> addEinheit(Einheit einheit){

        einheiten.add(einheit);

        return einheiten;
    }

    public long getIDFach() {
        return IDFach;
    }

    public void setIDFach(long IDFach) {
        this.IDFach = IDFach;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Einheit> getEinheiten() {
        return einheiten;
    }

    public void setEinheiten(List<Einheit> einheiten) {
        this.einheiten = einheiten;
    }

    public Stundenplan getStundenplan() {
        return stundenplan;
    }

    public void setStundenplan(Stundenplan stundenplan) {
        this.stundenplan = stundenplan;
    }
}
