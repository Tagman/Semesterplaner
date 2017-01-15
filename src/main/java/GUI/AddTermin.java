package GUI;


import Backend.Termin;
import Backend.Controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddTermin implements ActionListener// implements ActionListener
 {

    //speichert eingabe
    private Termin eingabetermin = new Termin();


    private JFrame frame;
    private JTextField txtFieldName;
    private JTextField txtFieldTimeStart;
    private JTextField txtFieldTimeStop;
    private JTextField txtFieldLocation;
    private JTextField txtFieldDate;
    private JComboBox comboInterval = new JComboBox();
    private JComboBox comboPriority = new JComboBox();
    private Controller controller = new Controller();
    private JTextField error;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddTermin window = new AddTermin();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public AddTermin() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 835, 610);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblHinzufgenEinesTermins = new JLabel("Hinzuf\u00FCgen eines Termins");
        lblHinzufgenEinesTermins.setFont(new Font("Tahoma", Font.PLAIN, 27));
        lblHinzufgenEinesTermins.setBounds(197, 16, 400, 33);
        frame.getContentPane().add(lblHinzufgenEinesTermins);

        JLabel lblBezeichnungDesTermins = new JLabel("Bezeichnung des Termins");
        lblBezeichnungDesTermins.setBounds(16, 76, 186, 20);
        frame.getContentPane().add(lblBezeichnungDesTermins);

        txtFieldName = new JTextField();
        txtFieldName.setFont(new Font("Tahoma", Font.PLAIN, 22));
        txtFieldName.setText("Field");
        txtFieldName.setName("Bezeichnung");
        txtFieldName.setColumns(10);
        txtFieldName.setBounds(15, 114, 383, 49);
        frame.getContentPane().add(txtFieldName);

        JLabel lblPriorittDesTermins = new JLabel("Priorit\u00E4t des Termins");
        lblPriorittDesTermins.setBounds(438, 76, 203, 20);
        frame.getContentPane().add(lblPriorittDesTermins);

        JLabel label_3 = new JLabel("Uhrzeitintervall");
        label_3.setBounds(16, 179, 203, 20);
        frame.getContentPane().add(label_3);

        txtFieldTimeStart = new JTextField();
        txtFieldTimeStart.setFont(new Font("Tahoma", Font.PLAIN, 22));
        txtFieldTimeStart.setColumns(10);
        txtFieldTimeStart.setName("Startzeit");
        txtFieldTimeStart.setText("Field1");
        txtFieldTimeStart.setBounds(16, 209, 153, 49);
        frame.getContentPane().add(txtFieldTimeStart);

        JButton btnHinzufgen = new JButton("Zum Stundenplan hinzuf\u00FCgen");
        btnHinzufgen.setBounds(437, 417, 361, 99);
        btnHinzufgen.addActionListener(this);
        btnHinzufgen.setToolTipText("Mit drückend es Buttons bestätigen sie die Eingabe und Die einheit wird in ihren Stundenplan übertragen.");
        frame.getContentPane().add(btnHinzufgen);

        txtFieldTimeStop = new JTextField();
        txtFieldTimeStop.setName("Endzeit");
        txtFieldTimeStop.setFont(new Font("Tahoma", Font.PLAIN, 22));
        txtFieldTimeStop.setColumns(10);
        txtFieldTimeStop.setText("Field2");
        txtFieldTimeStop.setBounds(228, 209, 153, 49);
        frame.getContentPane().add(txtFieldTimeStop);

        JLabel label_4 = new JLabel("-");
        label_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
        label_4.setBounds(197, 214, 31, 33);
        frame.getContentPane().add(label_4);

        txtFieldLocation = new JTextField();
        txtFieldLocation.setName("Veranstaltungsort");
        txtFieldLocation.setFont(new Font("Tahoma", Font.PLAIN, 22));
        txtFieldLocation.setColumns(10);
        txtFieldLocation.setText("Field3");
        txtFieldLocation.setBounds(438, 209, 361, 49);
        frame.getContentPane().add(txtFieldLocation);

        JLabel label_7 = new JLabel("Periodisch");
        label_7.setBounds(16, 274, 203, 20);
        frame.getContentPane().add(label_7);

        //	JComboBox comboInterval = new JComboBox();
        comboInterval.setModel(new DefaultComboBoxModel(new String[] {"Einmalig", "W\u00F6chentlich", "Alle zwei Wochen"}));
        comboInterval.setFont(new Font("Tahoma", Font.PLAIN, 22));
        comboInterval.setBounds(16, 310, 382, 49);
        frame.getContentPane().add(comboInterval);

        txtFieldDate = new JTextField();
        txtFieldDate.setName("Datum");
        txtFieldDate.setText("DD.MM.JJJJ");
        txtFieldDate.setFont(new Font("Tahoma", Font.PLAIN, 22));
        txtFieldDate.setColumns(10);
        txtFieldDate.setBounds(438, 310, 361, 49);
        frame.getContentPane().add(txtFieldDate);

        JLabel label_8 = new JLabel("Datum");
        label_8.setBounds(438, 274, 203, 20);
        frame.getContentPane().add(label_8);

        error = new JTextField();
        error.setBounds(10, 540, 799, 20);
        frame.getContentPane().add(error);
        error.setColumns(10);

        JLabel lblOrt = new JLabel("Ort\r\n");
        lblOrt.setBounds(438, 179, 203, 20);
        frame.getContentPane().add(lblOrt);

        comboPriority.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
        comboPriority.setFont(new Font("Tahoma", Font.PLAIN, 22));
        comboPriority.setBounds(438, 114, 361, 49);
        frame.getContentPane().add(comboPriority);

        JButton button = new JButton("Zum Stundenplan hinzuf\u00FCgen");}

            public void actionPerformed(ActionEvent e) {



                //Testen
                ArrayList<JTextField> TerminList= new ArrayList();
                TerminList.add(txtFieldName);
                TerminList.add(txtFieldTimeStart);
                TerminList.add(txtFieldTimeStop);
                TerminList.add(txtFieldDate);
                TerminList.add(txtFieldLocation);

                if(Controller.iterateField(TerminList,error) && Controller.checkTime(txtFieldTimeStart, txtFieldTimeStop))
                {

                //eingabetermin mit werten füllen
                eingabetermin.setBezeichnung(txtFieldName.getText());
                eingabetermin.setStartZeit(LocalTime.parse(txtFieldTimeStart.getText()));
                eingabetermin.setEndZeit(LocalTime.parse(txtFieldTimeStop.getText()));
                eingabetermin.setPeriodisch(comboInterval.getSelectedItem().toString());
                eingabetermin.setPriorität(Integer.parseInt((String) comboPriority.getSelectedItem()));
                eingabetermin.setOrt(txtFieldLocation.getText());
                eingabetermin.setDatum(LocalDate.parse(txtFieldDate.getText(), DateTimeFormatter.ofPattern("dd.MM.yyyy")));

                //neuen Termin mit Eingabewerten anlegen und der Liste hinzufügen
                Termin.Termine.add(new Termin(
                        eingabetermin.getBezeichnung(),
                        eingabetermin.getStartZeit(),
                        eingabetermin.getEndZeit(),
                        eingabetermin.getPeriodisch(),
                        eingabetermin.getPriorität(),
                        eingabetermin.getOrt(),
                        eingabetermin.getDatum()));

                //experimentell
                Object[] args = new Object[9];
                args[0] = eingabetermin.getBezeichnung();
                args[1] = "";
                args[2] = eingabetermin.getStartZeit()+"-"+eingabetermin.getEndZeit();
                args[3] = eingabetermin.getOrt();
                args[4] = "";
                args[5] = "";
                args[6] = eingabetermin.getDatum();
                args[7] = eingabetermin.getPeriodisch();
                args[8] = eingabetermin.getPriorität();

                for(int i=0;i<=MainGUI.daten.length; i++)
                {
                    if(MainGUI.daten[i]==null)
                    {

                        MainGUI.daten[i] = args;
                        break;
                    }

                }
                //MainGUI.tm.addRow(new Object[]{eingabetermin.getBezeichnung(), "", eingabetermin.getStartzeit()+"-"+eingabetermin.getEndzeit(), eingabetermin.getOrt(), "", "", eingabetermin.getDatum(), eingabetermin.getPeriodisch(), eingabetermin.getPriorität()});




            }}


    //public void actionPerformed(ActionEvent arg0) {



        //eingabeTermin mit werten füllen
        /*
        eingabeTermin.setBezeichnung(txtFieldName.getText());
        eingabeTermin.setStartZeit(txtFieldTimeStart.getText());
        eingabeTermin.setEndZeit(txtFieldTimeStop.getText());
        eingabeTermin.setPeriodisch(comboInterval.getSelectedItem().toString());
        eingabeTermin.setPriorität(Integer.parseInt((String) comboPriority.getSelectedItem()));
        eingabeTermin.setOrt(txtFieldLocation.getText());
        eingabeTermin.setDatum(txtFieldDate.getText());
        */

     /*   ArrayList<JTextField> txtFieldsToCheck = collectTxtFields();

        if(controller.iterateField(txtFieldsToCheck) && controller.checkTime(txtFieldTimeStart, txtFieldTimeStop)){

            eingabeTermin = new Termin( txtFieldName.getText(),
                    LocalTime.parse(txtFieldTimeStart.getText()),
                    LocalTime.parse(txtFieldTimeStop.getText()),
                    comboInterval.getSelectedItem().toString(),
                    Integer.parseInt((String)comboPriority.getSelectedItem()),
                    txtFieldLocation.getText(),
                    txtFieldDate.getText()
            );

            // neuen Termin mit Eingabenwert in Liste des Semesterplans Objekt hinzufügen

            MainGUI.sem.addTermin(eingabeTermin);  //Anschauen ob es in der wirklich in der Liste ist
        }
   */



        /*
        //neuen Termin mit Eingabewerten anlegen und der Liste hinzufügen
        Termin.Termine.add(new Termin(
                eingabeTermin.getBezeichnung(),
                eingabeTermin.getStartZeit(),
                eingabeTermin.getEndZeit(),
                eingabeTermin.getPeriodisch(),
                eingabeTermin.getPriorität(),
                eingabeTermin.getOrt(),
                eingabeTermin.getDatum()));

            */

       // MainGUI.tm.addRow(new Object[]{eingabeTermin.getBezeichnung(), "", eingabeTermin.getStartZeit()+"-"+ eingabeTermin.getEndZeit(), eingabeTermin.getOrt(), "", "", eingabeTermin.getDatum(), eingabeTermin.getPeriodisch(), eingabeTermin.getPriorität()});

 //   }

    private ArrayList<JTextField> collectTxtFields(){
        ArrayList<JTextField> gatheredTxtFields = new ArrayList<>();

        gatheredTxtFields.add(txtFieldDate);
        gatheredTxtFields.add(txtFieldLocation);
        gatheredTxtFields.add(txtFieldName);

        return gatheredTxtFields;
    }



 }
