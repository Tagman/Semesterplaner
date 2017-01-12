package Backend;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(cascade = CascadeType.ALL)
    private List<Termin> termine;

    @OneToOne(cascade = CascadeType.ALL)
    private Stundenplan stundenplan;


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

    public List<Termin> addTermin(Termin termin){
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

    public Long getIDSemesterplan() {
        return IDSemesterplan;
    }

    public void setIDSemesterplan(Long IDSemesterplan) {
        this.IDSemesterplan = IDSemesterplan;
    }

    public List<Termin> getTermine() {
        return termine;
    }

    public void setTermine(List<Termin> termine) {
        this.termine = termine;
    }

    public Stundenplan getStundenplan() {
        return stundenplan;
    }

    public void setStundenplan(Stundenplan stundenplan) {
        this.stundenplan = stundenplan;
    }
}
