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

                return 4;

            }

        if(field.getName().equals(""))
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

    public void iterateField(ArrayList<JTextField> fields){

        fields.forEach(field -> {
            switch(checkField(field)) {

                case 1:
                    System.out.println(field.getName() + " zu kurz! Muss mind. 3 Zeichen lang sein.");
                    break;
                case 2:
                    System.out.println(field.getName() + " zu lang! Darf max. 29 Zeichen lang sein.");
                    break;
                case 3:
                    System.out.println(field.getName() + " darf keine Sonderzeichen (!§$%&/()=?{[]}) enthalten!");
                    break;
                case 4:
                    System.out.println(field.getName() + " falsch formatiert. Format MUSS in DD.MM.YYYY sein");
                    break;

                default:
                    System.out.println(field.getName() + " OK!");

            }
        });

    }

    private int checkTime(JTextField start, JTextField end) {

        try{
            LocalTime startTime = LocalTime.parse(start.getText());
            LocalTime endTime = LocalTime.parse(end.getText());

            
        }catch (){

        }
    }
}
