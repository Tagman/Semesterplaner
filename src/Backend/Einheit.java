package Backend;

import java.util.Date;

/**
 * Created by Chris on 28.11.2016.
 */
public class Einheit {

    private Date anfangsZeit;
    private Date endZeit;
    private String ort;
    private String name;
    private String lehrender;
    private int wiederholungsrhytmus;
    private int prioriät;
    private String typ;


    public Einheit(){
        anfangsZeit = null;
        endZeit = null;
        ort = null;
        name = null;
        lehrender = null;
        wiederholungsrhytmus = -1;
        prioriät = -1;
        typ = null;

    }

    public Einheit(Object args[]){
        anfangsZeit = (Date)args[0];
        endZeit = (Date)args[1];
        ort = (String)args[2];
        name = (String)args[3];
        lehrender = (String)args[4];
        wiederholungsrhytmus = (int)args[5];
        prioriät = (int)args[6];
        typ = (String)args[7];
    }

    public Einheit changeEinheit(Object args[]){
        anfangsZeit = (Date)args[0];
        endZeit = (Date)args[1];
        ort = (String)args[2];
        name = (String)args[3];
        lehrender = (String)args[4];
        wiederholungsrhytmus = (int)args[5];
        prioriät = (int)args[6];
        typ = (String)args[7];

        return this;
    }

}

