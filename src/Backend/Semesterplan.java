package Backend;

/**
 * Created by chris on 04/12/16.
 */


public class Semesterplan
{
    private String Semestername;
    private String Startzeit;
    private String Endzeit;


    public String getSemestername()
    {
        return Semestername;
    }

    public void setSemestername(String semestername)
    {
        Semestername = semestername;
    }

    public String getStartzeit()
    {
        return Startzeit;
    }

    public void setStartzeit(String startzeit)
    {
        Startzeit = startzeit;
    }

    public String getEndzeit()
    {
        return Endzeit;
    }

    public void setEndzeit(String endzeit)
    {
        Endzeit = endzeit;
    }


}
