package Backend;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Created by chris on 04/12/16.
 */
@Entity
public class Fach {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long IDFach;
    private String name;
    @Transient
    private ArrayList<Einheit> einheiten;

    @ManyToOne
    private Stundenplan stundenplan;

    public Fach(String name, ArrayList<Einheit> einheiten){
        this.name = name;
        this.einheiten = einheiten;
    }

    public Fach(){
        name = null;
        einheiten = null;
    }

    public Fach changeFach(String name, ArrayList<Einheit> einheiten){
        this.name = name;
        this.einheiten = einheiten;

        return this;
    }

    public ArrayList<Einheit> addEinheit(Einheit einheit){

        einheiten.add(einheit);

        return einheiten;
    }

}
