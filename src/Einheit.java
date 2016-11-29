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
    }

}

