package Backend;

/**
 * Created by peter on 04/12/16.
 */
import java.util.ArrayList;

public class Termin {

    private String Bezeichnung;

    private String Startzeit;
    private String Endzeit;
    private String Periodisch;


    private int Priorität;
    private String Ort;
    private String Datum;
    static ArrayList<Termin> Termine = new ArrayList<Termin>();

    public Termin()
    {
    }

    public Termin(String Bezeichnung, String Startzeit, String Endzeit, String Periodisch, int Priorität, String Ort, String Datum)
    {
        this.Bezeichnung = Bezeichnung;
        this.Datum=Datum;
        this.Startzeit=Startzeit;
        this.Endzeit=Endzeit;
        this.Ort=Ort;
        this.Periodisch=Periodisch;
        this.Priorität=Priorität;

    };

    public void Terminändern(String Bezeichnung, String Startzeit, String Endzeit, String Periodisch, int Priorität, String Ort, String Datum)
    {
        this.Bezeichnung = Bezeichnung;
        this.Datum=Datum;
        this.Startzeit=Startzeit;
        this.Endzeit=Endzeit;
        this.Ort=Ort;
        this.Periodisch=Periodisch;
        this.Priorität=Priorität;

    };

    public void Termineausgeben(){
        for( int i = 0; i < Termin.Termine.size(); i++)
        {
            System.out.println("Termin nummer "+ (i+1));
            System.out.println(Termin.Termine.get(i).getBezeichnung());
            System.out.println(Termin.Termine.get(i).getStartzeit());
            System.out.println(Termin.Termine.get(i).getEndzeit());
            System.out.println(Termin.Termine.get(i).getPeriodisch());
            System.out.println(Termin.Termine.get(i).getPriorität());
            System.out.println(Termin.Termine.get(i).getOrt());
            System.out.println(Termin.Termine.get(i).getDatum());
            System.out.println();
        }
    }


    public String getBezeichnung() {
        return Bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        Bezeichnung = bezeichnung;
    }

    public String getDatum() {
        return Datum;
    }

    public void setDatum(String datum) {
        Datum = datum;
    }

    public String getStartzeit() {
        return Startzeit;
    }

    public void setStartzeit(String startzeit) {
        Startzeit = startzeit;
    }

    public String getEndzeit() {
        return Endzeit;
    }

    public void setEndzeit(String endzeit) {
        Endzeit = endzeit;
    }

    public String getOrt() {
        return Ort;
    }

    public void setOrt(String ort) {
        Ort = ort;
    }

    public String getPeriodisch() {
        return Periodisch;
    }

    public void setPeriodisch(String periodisch) {
        Periodisch = periodisch;
    }

    public int getPriorität() {
        return Priorität;
    }

    public void setPriorität(int priorität) {
        Priorität = priorität;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Termin termino = new Termin();
        termino.setBezeichnung("lel");
        System.out.println("" + termino.getBezeichnung());
        Termine.add(termino);
    }

}
