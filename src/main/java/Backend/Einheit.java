package Backend;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 * Created by Chris on 28.11.2016.
 */
@Entity
public class Einheit {

    @Id
    @GeneratedValue
    private long IDEinheit;
    private LocalTime anfangsZeit;
    private LocalTime endZeit;
    private String ort;
    private String name;
    private String lehrender;
    //private int wiederholungsrhytmus; //Integer Wert um später damit rechnen zu können
    private String wiederholungsrhytmus;
    private int prioriät;
    private String typ;
    private LocalDate date;


    @ManyToOne
    private Fach fach;


    public Einheit(){
        anfangsZeit = null;
        endZeit = null;
        ort = null;
        name = null;
        lehrender = null;
        wiederholungsrhytmus = null;
        prioriät = -1;
        typ = null;
        date = null;


    }

    public Einheit(LocalTime anfangsZeit, LocalTime endZeit, String ort, String name, String lehrender, String wiederholungsrhytmus, int prioriät, String typ, LocalDate date, Fach fach) {
        this.anfangsZeit = anfangsZeit;
        this.endZeit = endZeit;
        this.ort = ort;
        this.name = name;
        this.lehrender = lehrender;
        this.wiederholungsrhytmus = wiederholungsrhytmus;
        this.prioriät = prioriät;
        this.typ = typ;
        this.date = date;
        this.fach = fach;
    }

    public Einheit(Object args[]){
        name = (String)args[0];
        typ = (String)args[1];
        anfangsZeit = (LocalTime)args[2];
        endZeit = (LocalTime)args[3];
        ort = (String)args[4];
        lehrender = (String)args[5];
        date = (LocalDate) args[6];
        wiederholungsrhytmus = (String)args[7];
        prioriät = (int)args[8];


    }

    public Einheit changeEinheit(Object args[])
    {
        name = (String)args[0];
        typ = (String)args[1];
        anfangsZeit = (LocalTime) args[2];
        endZeit = (LocalTime) args[3];
        ort = (String)args[4];
        lehrender = (String)args[5];
        date = (LocalDate) args[6];
        wiederholungsrhytmus = (String)args[7];
        prioriät = (int)args[8];

        return this;
    }

    public void ausgabe(){
        System.out.println(lehrender);
        System.out.println(date);
        System.out.println(anfangsZeit);
    }

    public long getIDEinheit() {
        return IDEinheit;
    }

    public void setIDEinheit(long IDEinheit) {
        this.IDEinheit = IDEinheit;
    }

    public LocalTime getAnfangsZeit() {
        return anfangsZeit;
    }

    public void setAnfangsZeit(LocalTime anfangsZeit) {
        this.anfangsZeit = anfangsZeit;
    }

    public LocalTime getEndZeit() {
        return endZeit;
    }

    public void setEndZeit(LocalTime endZeit) {
        this.endZeit = endZeit;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLehrender() {
        return lehrender;
    }

    public void setLehrender(String lehrender) {
        this.lehrender = lehrender;
    }

    public String getWiederholungsrhytmus() {
        return wiederholungsrhytmus;
    }

    public void setWiederholungsrhytmus(String wiederholungsrhytmus) {
        this.wiederholungsrhytmus = wiederholungsrhytmus;
    }

    public int getPrioriät() {
        return prioriät;
    }

    public void setPrioriät(int prioriät) {
        this.prioriät = prioriät;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Fach getFach() {
        return fach;
    }

    public void setFach(Fach fach) {
        this.fach = fach;
    }
}
