package Backend;

import javax.persistence.*;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.ArrayList;

@Entity
public class Termin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IDTermin;

    private String bezeichnung;

    private LocalTime startZeit;
    private LocalTime endZeit;
    private String periodisch;


    private int priorität;
    private String ort;
    private LocalDate datum;


    @ManyToOne(cascade = CascadeType.ALL)
    private Semesterplan semesterplan;

    //public static ArrayList<Termin> Termine = new ArrayList<Termin>();
    //Füge Termine liste zu Semesterplan hinzu
    //Dazugehörende Operationen wie zur liste hinzufügen, denke eher auch dort rein.

    public Termin()
    {
    }

    public Termin(String bezeichnung, LocalTime startZeit, LocalTime endZeit, String periodisch, int priorität, String ort, LocalDate datum, Semesterplan sp)
    {
        this.bezeichnung = bezeichnung;
        this.datum = datum;
        this.startZeit = startZeit;
        this.endZeit = endZeit;
        this.ort = ort;
        this.periodisch = periodisch;
        this.priorität = priorität;
        this.semesterplan = sp;

    }

    public void changeTermin(String bezeichnung, LocalTime startzeit, LocalTime endzeit, String periodisch, int priorität, String ort, LocalDate datum)
    {
        this.bezeichnung = bezeichnung;
        this.datum = datum;
        this.startZeit = startzeit;
        this.endZeit = endzeit;
        this.ort = ort;
        this.periodisch = periodisch;
        this.priorität = priorität;

    }

    /*
        Hier diese Ausgabe in Stundenplan einfügen


    public void ausgabeTermin(){
        for( int i = 0; i < Termin.Termine.size(); i++)
        {
            System.out.println("Termin nummer "+ (i+1));
            System.out.println(Termin.Termine.get(i).getBezeichnung());
            System.out.println(Termin.Termine.get(i).getStartZeit());
            System.out.println(Termin.Termine.get(i).getEndZeit());
            System.out.println(Termin.Termine.get(i).getPeriodisch());
            System.out.println(Termin.Termine.get(i).getPriorität());
            System.out.println(Termin.Termine.get(i).getOrt());
            System.out.println(Termin.Termine.get(i).getDatum());
            System.out.println();
        }
    }
    */


    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public LocalTime getStartZeit()
    {
        return startZeit;
    }

    public void setStartZeit(LocalTime startZeit) {
        this.startZeit = startZeit;
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

    public String getPeriodisch() {
        return periodisch;
    }

    public void setPeriodisch(String periodisch) {
        this.periodisch = periodisch;
    }

    public int getPriorität() {
        return priorität;
    }

    public void setPriorität(int priorität) {
        this.priorität = priorität;
    }

    public Long getIDTermin() {
        return IDTermin;
    }

    public void setIDTermin(Long IDTermin) {
        this.IDTermin = IDTermin;
    }


    public Semesterplan getSemesterplan() {
        return semesterplan;
    }

    public void setSemesterplan(Semesterplan semesterplan) {
        this.semesterplan = semesterplan;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(bezeichnung).append("    ");
        stringBuilder.append(datum).append("    ");
        stringBuilder.append(startZeit).append("    ");
        stringBuilder.append(ort).append("    ");

        return stringBuilder.toString();
    }

    public Object[] getArray(){
        Object[] args = {bezeichnung, "Termin", startZeit.toString() + "-" + endZeit.toString(),
                ort, "", "", datum, "", priorität};

        return args;
    }


}
