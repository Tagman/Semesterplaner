package Backend;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

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
    private boolean errBoolean;

    public Controller(){
        // emtpy constructor.
    }

    public int checkField(JTextField field){

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

        String text;
        text=field.getText();

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

    public boolean iterateField(ArrayList<JTextField> fields){



        fields.forEach(field -> {

            switch(checkField(field)) {

                case 1:
                    errString = field.getName() + " zu kurz! Muss mind. 3 Zeichen lang sein.";
                    errBoolean = false;
                    System.out.println(field.getName() + " zu kurz! Muss mind. 3 Zeichen lang sein.");
                    break;
                case 2:
                    errString = field.getName() + " zu lang! Darf max. 29 Zeichen lang sein.";
                    errBoolean = false;
                    System.out.println(field.getName() + " zu lang! Darf max. 29 Zeichen lang sein.");
                    break;
                case 3:
                    errString = field.getName() + " darf keine Sonderzeichen (!§$%&/()=?{[]}) enthalten!";
                    errBoolean = false;
                    System.out.println(field.getName() + " darf keine Sonderzeichen (!§$%&/()=?{[]}) enthalten!");
                    break;
                case 4:
                    errString = field.getName() + " falsch formatiert. Format MUSS in DD.MM.YYYY sein";
                    errBoolean = false;
                    System.out.println(field.getName() + " falsch formatiert. Format MUSS in DD.MM.YYYY sein");
                    break;

                default:
                    errString = field.getName() + " OK!";
                    errBoolean = true;
                    System.out.println(field.getName() + " OK!");

            }


        });
        return errBoolean;
    }

    public boolean checkTime(JTextField start, JTextField end) {

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
}
