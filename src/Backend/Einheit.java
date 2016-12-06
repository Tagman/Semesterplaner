package Backend;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 * Created by Chris on 28.11.2016.
 */

public class Einheit {

    private LocalTime anfangsZeit;
    private LocalTime endZeit;
    private String ort;
    private String name;
    private String lehrender;
    private int wiederholungsrhytmus;
    private int prioriät;
    private String typ;
    private LocalDate date;


    public Einheit(){
        anfangsZeit = null;
        endZeit = null;
        ort = null;
        name = null;
        lehrender = null;
        wiederholungsrhytmus = -1;
        prioriät = -1;
        typ = null;
        date = null;


    }

    public Einheit(Object args[]){
        name = (String)args[0];
        typ = (String)args[1];
        anfangsZeit = (LocalTime)args[2];
        endZeit = (LocalTime)args[3];
        ort = (String)args[4];
        lehrender = (String)args[5];
        date = (LocalDate) args[6];
        wiederholungsrhytmus = (int)args[7];
        prioriät = (int)args[8];


    }

    public Einheit changeEinheit(Object args[]){
        name = (String)args[0];
        typ = (String)args[1];
        anfangsZeit = (LocalTime) args[2];
        endZeit = (LocalTime) args[3];
        ort = (String)args[4];
        lehrender = (String)args[5];
        date = (LocalDate) args[6];
        wiederholungsrhytmus = (int)args[7];
        prioriät = (int)args[8];

        return this;
    }

    public void ausgabe(){
        System.out.println(lehrender);
        System.out.println(date);
        System.out.println(anfangsZeit);
    }

}

