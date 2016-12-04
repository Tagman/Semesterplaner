package Backend;

import java.time.LocalTime;

/**
 * Created by chris on 04/12/16.
 */


public class Semesterplan
{
    private String semestername;
    private LocalTime startzeit;
    private LocalTime endzeit;


    public Semesterplan(String name, LocalTime start, LocalTime end){
        semestername = name;
        startzeit = start;
        endzeit = end;
    }

    public Semesterplan(){
        semestername = null;
        startzeit = null;
        endzeit = null;
    }

    public String getSemestername()
    {
        return semestername;
    }

    public void setSemestername(String semestername)
    {
        this.semestername = semestername;
    }

    public LocalTime getStartzeit()
    {
        return startzeit;
    }

    public void setStartzeit(LocalTime startzeit)
    {
        this.startzeit = startzeit;
    }

    public LocalTime getEndzeit()
    {
        return endzeit;
    }

    public void setEndzeit(LocalTime endzeit)
    {
        this.endzeit = endzeit;
    }


}
