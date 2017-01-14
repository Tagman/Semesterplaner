package Backend;

import GUI.Semester;
import org.apache.log4j.Logger;

import javax.persistence.*;
import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 02/12/16.
 */

//TODO Add Date fomat check.
    /*
    Right now it will throw an error if its parsed into Einheit
    with the incorrect format.

    checkField just checks Date field like any other txt field
    maybe decide if field is the date field over the getName() method of any passed JTextField
    */

public class Controller {

    private static String errString;
    public static boolean errBoolean;

    public static final Logger logger = Logger.getLogger(Controller.class);

    private final EntityManagerFactory emf;

    EntityManager entityManager;




    public Controller(){

        emf = Persistence.createEntityManagerFactory("SemesterplanerPU");


        // emtpy constructor.
    }

    public static int checkField(JTextField field){

        /*
            Return values:

              0 = Field OK
              1 = Txt too short
              2 = Txt too long
              3 = Txt includes special characters
              4 = Date has wrong format

              Add Error Messages, via throwsException (?)
              Want to do it like in C, with perror and non-zero return values
              For now I did it over a switch statement, works quite well tho.



         */

        String text=field.getText();


        if(field.getName().equals("Datum")) {
            try{
                LocalDate.parse(field.getText(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));

                return 0;

            }catch(DateTimeParseException e) {

                System.out.println(e.getParsedString());
                return 4;

            }

        }

        if(text.length() < 3)
        {
            //label1.setText("Eingegebener Nutzername ist zu kurz! Name muss mindestens 3 Zeichen lang sein!");
            field.setText("");

            return 1;
        }
        else if(text.length() > 29)
        {
            //label1.setText("Eingegebener Nuzername ist zu lang! Name darf maximal 29 Zeichen lang sein!");
            field.setText("");

            return 2;
        }
        else if(text.contains("!") || text.contains("§") || text.contains("$") || text.contains("%") ||
                text.contains("&") || text.contains("/") || text.contains("(") || text.contains(")") ||
                text.contains("=") || text.contains("?") || text.contains("{") || text.contains("[") ||
                text.contains("]") || text.contains("}"))
        {
            //label1.setText("Nutzername darf keine Sonderzeichen (!§$%&/()=?{[]}) enthalten!");
            field.setText("");

            return 3;
        }
        else
        {
            //label1.setText("Nutzername OK!");
            //field.setText("");

            return 0;
        }
    }

    public static boolean iterateField(ArrayList<JTextField> fields, JTextField error){



        fields.forEach(field -> {

            switch(checkField(field)) {

                case 1:
                    errString = field.getName() + " zu kurz! Muss mind. 3 Zeichen lang sein.";
                    errBoolean = false;
                    error.setText(field.getName() + " zu kurz! Muss mind. 3 Zeichen lang sein.");
                    break;
                case 2:
                    errString = field.getName() + " zu lang! Darf max. 29 Zeichen lang sein.";
                    errBoolean = false;
                    error.setText(field.getName() + " zu lang! Darf max. 29 Zeichen lang sein.");
                    break;
                case 3:
                    errString = field.getName() + " darf keine Sonderzeichen (!§$%&/()=?{[]}) enthalten!";
                    errBoolean = false;
                    error.setText(field.getName() + " darf keine Sonderzeichen (!§$%&/()=?{[]}) enthalten!");
                    break;
                case 4:
                    errString = field.getName() + " falsch formatiert. Format MUSS in DD.MM.YYYY sein";
                    errBoolean = false;
                    error.setText(field.getName() + " falsch formatiert. Format MUSS in DD.MM.YYYY sein");
                    break;

                default:
                    errString = field.getName() + " OK!";
                    errBoolean = true;
                    error.setText(field.getName() + " OK!");

            }
        });

        return errBoolean; }

    public static boolean checkTime(JTextField start, JTextField end) {

        /*
            0 - Time is in Correct Format
            1 - Time has Wrong format
         */

        try{
            LocalTime startTime = LocalTime.parse(start.getText());
            LocalTime endTime = LocalTime.parse(end.getText());

            if(startTime.isBefore(endTime)){
                return true;
            }
            else{
                return false;
            }



            
        }catch (DateTimeParseException e){

            System.out.println("Die Zeit: " + e.getParsedString() + "muss das Format hh:mm haben");

            return false;


        }
    }

    public boolean closeEntityManager(){
        entityManager.close();
        return true;
    }

    public boolean closeEntityManagerFactory(){
        emf.close();
        return true;
    }

    public boolean save(Semesterplan sp){

        boolean boolReturn = true;

        entityManager = emf.createEntityManager();


        EntityTransaction transaction = null;

        try{
            transaction = entityManager.getTransaction();

            transaction.begin();

            entityManager.persist(sp);
            transaction.commit();


        }catch (Exception e){
            logger.error("cannot commit transaction....");
            logger.error("Fehlermeldung: " + e.toString());
            transaction.rollback();
            boolReturn = false;

            entityManager.close();
        }
        return boolReturn;
    }

    public Semesterplan initLoad(){

        entityManager = emf.createEntityManager();
        Semesterplan planReturn = null;

        try {
            TypedQuery<Semesterplan> query = entityManager.createQuery("select sp FROM Semesterplan sp", Semesterplan.class);

            List<Semesterplan> semesterplanList = query.getResultList();

            planReturn = semesterplanList.get(0);
        }catch (Exception e){
            logger.error("cannot query Semesterplan object for initLoad");
            logger.error("Error message: " + e.toString());

            entityManager.close();

        }
        return planReturn;
        }

    public String buildQueryStringEinheit(String attribute, String condition ){
        StringBuilder builder = new StringBuilder("SELECT ein FROM Einheit ein WHERE ");
        builder.append(attribute + " = ");
        builder.append("'" + condition + "'");

        logger.info(builder.toString());

        return builder.toString();
    }

    public List<Einheit> searchEinheit(String query){

        entityManager = emf.createEntityManager();

        List<Einheit> einheitList = null;

        try {
            TypedQuery<Einheit> typedQuery = entityManager.createQuery(query, Einheit.class);

            einheitList = typedQuery.getResultList();
        }catch (Exception e){
            logger.error("Cannot query for Einheit...");
            logger.error(e.toString());
        }

        return einheitList;
    }

}
