package Backend;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by chris on 04/12/16.
 */

@Entity
public class Semesterplan
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IDSemesterplan;

    private String semesterName;
    private LocalDate startDate;
    private LocalDate endDate;
    @Transient
    private ArrayList<Termin> termine;


    public Semesterplan(String name, LocalDate start, LocalDate end, ArrayList<Termin> termine){
        semesterName = name;
        startDate = start;
        endDate = end;
        this.termine = termine;
    }

    public Semesterplan(){
        semesterName = null;
        startDate = null;
        endDate = null;
        termine = null;
    }

    public Semesterplan changeSemesterplan(String name, LocalDate start, LocalDate end, ArrayList<Termin> termine){

        semesterName = name;
        startDate = start;
        endDate = end;
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

    public LocalDate getStartDate()
    {
        return startDate;
    }

    public void setStartDate(LocalDate startZeit)
    {
        this.startDate = startZeit;
    }

    public LocalDate getEndDate()
    {
        return endDate;
    }

    public void setEndDate(LocalDate endZeit)
    {
        this.endDate = endZeit;
    }


}
