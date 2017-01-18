package Backend;

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
    
    Robert push test

    checkField just checks Date field like any other txt field
    maybe decide if field is the date field over the getName() method of any passed JTextField
    */

public class Controller {

    private static String errString="";
    private static String errStringTime ="";
    public static boolean errBoolean;

    public static final Logger logger = Logger.getLogger(Controller.class);

    private EntityManagerFactory emf;

    private EntityManager entityManager;

    private static boolean admin;




    public Controller(){

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

    public static String iterateField(ArrayList<JTextField> fields, JTextField error){

        errString = "";


        fields.forEach(field -> {

            switch(checkField(field)) {

                case 1:
                    errString = "<html>" +errString + field.getName() + " zu kurz! Muss mind. 3 Zeichen lang sein. <br> <html>";
                    errBoolean = false;
                    error.setText(field.getName() + " zu kurz! Muss mind. 3 Zeichen lang sein. \n");
                    break;
                case 2:
                    errString =  "<html>" +errString + field.getName() + " zu lang! Darf max. 29 Zeichen lang sein. <br> <html>";
                    errBoolean = false;
                    error.setText(field.getName() + " zu lang! Darf max. 29 Zeichen lang sein. \n");
                    break;
                case 3:
                    errString =  "<html>" +errString + field.getName() + " darf keine Sonderzeichen (!§$%&/()=?{[]}) enthalten! <br> <html>";
                    errBoolean = false;
                    error.setText(field.getName() + " darf keine Sonderzeichen (!§$%&/()=?{[]}) enthalten! \n");
                    break;
                case 4:
                    errString =  "<html>" +errString + field.getName() + " falsch formatiert. Format MUSS in DD.MM.YYYY sein <br> <html>";
                    errBoolean = false;
                    error.setText(field.getName() + " falsch formatiert. Format MUSS in DD.MM.YYYY sein \n");
                    break;

                default:
                   // errString = field.getName() + " OK!";
                    errBoolean = true;
                  //  error.setText(field.getName() + " OK!");

            }
        });

        return errString; }

    public static String checkTime(JTextField start, JTextField end)
    {
        errStringTime = "";

        /*
            0 - Time is in correct format
            1 - Time has wrong format
         */

        try{
            LocalTime startTime = LocalTime.parse(start.getText());
            LocalTime endTime = LocalTime.parse(end.getText());

            if(startTime.isBefore(endTime)){
                return errStringTime;
            }
            else
            {
                errStringTime=errStringTime+"Die Startzeit darf nicht vor der Endzeit liegen";
                return errStringTime;
            }



            
        }catch (DateTimeParseException e){

            errStringTime = errStringTime +("Die Zeit ist falsch formatiert, sie muss das Format hh:mm haben");

            return errStringTime;


        }
    }

    public void initDB(){
        emf = Persistence.createEntityManagerFactory("SemesterplanerPU");
        entityManager = emf.createEntityManager();
    }

    public void closeDB(){
        entityManager.close();
        emf.close();
    }

    public void closeEntityManager(){
        entityManager.close();
    }

    public void closeEntityManagerFactory(){
        emf.close();
           }

    public boolean save(Semesterplan sp){

        //*** Autoinit wegen DB Test gelöscht
        //initDB();

        boolean boolReturn = true;



        EntityTransaction transaction = null;

        try{
            transaction = entityManager.getTransaction();

            transaction.begin();

//            entityManager.persist(sp);
            entityManager.merge(sp);
            transaction.commit();


        }catch (Exception e){
            logger.error("cannot commit transaction....");
            logger.error("Fehlermeldung: " + e.toString());
            transaction.rollback();
            boolReturn = false;

            closeDB();
        }

        return boolReturn;

    }

    public boolean saveTermin(Einheit ein){


    boolean boolReturn = true;



    EntityTransaction transaction = null;

        try{
        transaction = entityManager.getTransaction();

        transaction.begin();

//            entityManager.persist(sp);
        entityManager.merge(ein);
        transaction.commit();


    }catch (Exception e){
        logger.error("cannot commit transaction....");
        logger.error("Fehlermeldung: " + e.toString());
        transaction.rollback();
        boolReturn = false;

        closeDB();
    }

        return boolReturn;


    }



    public Semesterplan initLoad() throws NullPointerException{

        //*** Autoinit wegen DB Test gelöscht
        //initDB();

        Semesterplan planReturn = null;

        try {
            TypedQuery<Semesterplan> query = entityManager.createQuery("select sp FROM Semesterplan sp", Semesterplan.class);

            List<Semesterplan> semesterplanList = query.getResultList();

            planReturn = semesterplanList.get(0);
        }catch (Exception e){
            logger.error("cannot query Semesterplan object for initLoad");
            logger.error("Error message: " + e.toString());

            closeDB();

        }
        return planReturn;
        }

    public String buildQueryStringEinheit(String attribute, String condition ){
        StringBuilder builder = new StringBuilder("SELECT ein FROM Einheit ein WHERE ");

        if(!attribute.contains("Zeit")){
            builder.append(attribute).append(" = ");
        }
        else{
            builder.append(attribute).append(" LIKE ");
        }

        builder.append(condition);

        logger.info(builder.toString());

        return builder.toString();
    }

    public String buildQueryStringTermin(String attribute, String condition) {
        StringBuilder builder = new StringBuilder("SELECT ter FROM Termin ter WHERE ");

        if(!attribute.contains("Zeit")){
            builder.append(attribute).append(" =  ");
        }
        else{
            builder.append(attribute).append(" LIKE ");
        }

        builder.append(condition);

        logger.info(builder.toString());

        return builder.toString();
    }

    public List<Einheit> searchEinheit(String query){


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

    public List<Termin> searchTermin(String query){



        List<Termin> terminList = null;

        try {
            TypedQuery<Termin> typedQuery = entityManager.createQuery(query, Termin.class);

            terminList = typedQuery.getResultList();
        }catch (Exception e) {
            logger.error("Cannot query for Termin...");
            logger.error(e.toString());
        }

        return  terminList;
    }

    public static boolean isAdmin() {
        return admin;
    }

    public static void setAdmin(boolean adminBool) {
        admin = adminBool;
    }
}
