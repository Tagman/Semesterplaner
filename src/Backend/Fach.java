package Backend;

import java.util.ArrayList;

/**
 * Created by chris on 04/12/16.
 */
public class Fach {

    private String name;
    private ArrayList<Einheit> einheiten;

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
