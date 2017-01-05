package Backend;

import GUI.Semester;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Created by chris on 04/12/16.
 */

@Entity
@Table(name = "sp")
public class Semesterplan
{
    @Id
    @GeneratedValue
    private Long id;

    private String semesterName;
    private LocalTime startZeit;
    private LocalTime endZeit;
    private ArrayList<Termin> termine;


    public Semesterplan(String name, LocalTime start, LocalTime end, ArrayList<Termin> termine){
        semesterName = name;
        startZeit = start;
        endZeit = end;
        this.termine = termine;
    }

    public Semesterplan(){
        semesterName = null;
        startZeit = null;
        endZeit = null;
        termine = null;
    }

    public Semesterplan changeSemesterplan(String name, LocalTime start, LocalTime end, ArrayList<Termin> termine){

        semesterName = name;
        startZeit = start;
        endZeit = end;
        this.termine = termine;

        return this;
    }

    public ArrayList<Termin> addTermin(Termin termin){
        termine.add(termin);

        return termine;
    }

    public String getSemesterName()
    {
        return semesterName;
    }

    public void setSemesterName(String semesterName)
    {
        this.semesterName = semesterName;
    }

    public LocalTime getStartZeit()
    {
        return startZeit;
    }

    public void setStartZeit(LocalTime startZeit)
    {
        this.startZeit = startZeit;
    }

    public LocalTime getEndZeit()
    {
        return endZeit;
    }

    public void setEndZeit(LocalTime endZeit)
    {
        this.endZeit = endZeit;
    }


}
