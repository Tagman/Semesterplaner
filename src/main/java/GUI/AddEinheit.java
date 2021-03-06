package GUI;

import Backend.Controller;
import Backend.Einheit;
import Backend.Fach;
import Backend.Semesterplan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddEinheit implements ActionListener {

    private JFrame frame;
    private static JTextField txtFieldName;
    private static JTextField txtFieldTimeStart;
    private static JTextField txtFieldTimeStop;
    private static JTextField txtFieldLocation;
    private static JTextField txtFieldTeacher;
    private static JTextField txtFieldDate;
    private static JComboBox comboTyp;
    private static JComboBox comboIntervall;
    private static JCheckBox checkPflicht;
    private static JTextField error;
    static JComboBox nameBox;
    static String[] fächer  = new String[200];

    Semesterplan plan;


    private Controller controller = new Controller();

    private Einheit eingabeEinheit;


    /**
     * Launch the application.
     * @param sp
     */
    public static void startAddEinheit(Semesterplan sp)
    {


        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddEinheit window = new AddEinheit(sp);
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
    public AddEinheit(Semesterplan sp) {
        plan = sp;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 835, 608);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Hinzuf\u00FCgen einer Einheit");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
        lblNewLabel.setBounds(196, 16, 400, 33);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblName = new JLabel("Name der Veranstaltung");
        lblName.setBounds(15, 76, 186, 20);
        frame.getContentPane().add(lblName);

        getFacherList();

        nameBox = new JComboBox();
        nameBox.setModel(new DefaultComboBoxModel(fächer));
        nameBox.setToolTipText("Bitte die Art der Veranstaltung ausw\u00E4hlen");
        nameBox.setName("Typ");
        nameBox.setFont(new Font("Tahoma", Font.PLAIN, 22));
        nameBox.setBounds(14, 91, 381, 49);
        nameBox.setEditable(true);
        frame.getContentPane().add(nameBox);

        JLabel lblNewLabel_1 = new JLabel("Art der Veranstaltung");
        lblNewLabel_1.setBounds(437, 76, 203, 20);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblUhrzeitintervall = new JLabel("Uhrzeitintervall");
        lblUhrzeitintervall.setBounds(15, 179, 203, 20);
        frame.getContentPane().add(lblUhrzeitintervall);

        txtFieldTimeStart = new JTextField();
        txtFieldTimeStart.setName("Startzeit");
        txtFieldTimeStart.setFont(new Font("Tahoma", Font.PLAIN, 22));
        txtFieldTimeStart.setColumns(10);
        txtFieldTimeStart.setText("13:30");
        txtFieldTimeStart.setBounds(15, 209, 153, 49);
        txtFieldTimeStart.setToolTipText("Hier bitte die Uhzeit angeben wann die Veranstaltung beginnt");
        frame.getContentPane().add(txtFieldTimeStart);

        txtFieldTimeStop = new JTextField();
        txtFieldTimeStop.setName("Endzeit");
        txtFieldTimeStop.setFont(new Font("Tahoma", Font.PLAIN, 22));
        txtFieldTimeStop.setColumns(10);
        txtFieldTimeStop.setText("14:00");
        txtFieldTimeStop.setBounds(227, 209, 153, 49);
        txtFieldTimeStop.setToolTipText("Hier bitte die Uhrzeit angeben wann die Veranstaltung endet.");
        frame.getContentPane().add(txtFieldTimeStop);

        JLabel label = new JLabel("-");
        label.setFont(new Font("Tahoma", Font.PLAIN, 30));
        label.setBounds(196, 214, 31, 33);
        frame.getContentPane().add(label);

        txtFieldLocation = new JTextField();
        txtFieldLocation.setName("Ort");
        txtFieldLocation.setFont(new Font("Tahoma", Font.PLAIN, 22));
        txtFieldLocation.setColumns(10);
        txtFieldLocation.setBounds(437, 209, 361, 49);
        txtFieldLocation.setToolTipText("Bitte den Namen des Raums eintragen in welchem die Veranstaltung stattfindet");
        frame.getContentPane().add(txtFieldLocation);

        JLabel lblRaumbezeichnung = new JLabel("Raumbezeichnung");
        lblRaumbezeichnung.setBounds(437, 179, 203, 20);
        frame.getContentPane().add(lblRaumbezeichnung);

        checkPflicht = new JCheckBox("Pflichtveranstaltung?");
        checkPflicht.setName("Pflichtveranstaltung?");
        checkPflicht.setBounds(15, 487, 224, 49);
        checkPflicht.setToolTipText("Bitte einen Haken setzen, sollte die Veranstaltung Pflicht sein.");
        frame.getContentPane().add(checkPflicht);

        JButton btnHinzufgen = new JButton("Zum Stundenplan hinzuf\u00FCgen");
        btnHinzufgen.setBounds(437, 417, 361, 99);
        btnHinzufgen.addActionListener(this);
        btnHinzufgen.setToolTipText("Mit drückend es Buttons bestätigen sie die Eingabe und Die einheit wird in ihren Stundenplan übertragen.");
        frame.getContentPane().add(btnHinzufgen);

        JLabel lblNameDesLrhrenden = new JLabel("Name des Lehrenden");
        lblNameDesLrhrenden.setBounds(15, 274, 203, 20);
        frame.getContentPane().add(lblNameDesLrhrenden);

        txtFieldTeacher = new JTextField();
        txtFieldTeacher.setName("Lehrender");
        txtFieldTeacher.setFont(new Font("Tahoma", Font.PLAIN, 22));
        txtFieldTeacher.setColumns(10);
        txtFieldTeacher.setBounds(14, 310, 383, 49);
        txtFieldTeacher.setToolTipText("Hier bitte den Namen des Lehrenden eintragen");
        frame.getContentPane().add(txtFieldTeacher);

        JLabel lblPeriodisch = new JLabel("Periodisch");
        lblPeriodisch.setBounds(15, 381, 203, 20);
        frame.getContentPane().add(lblPeriodisch);

        comboIntervall = new JComboBox();
        comboIntervall.setName("Intervall");
        comboIntervall.setModel(new DefaultComboBoxModel(new String[]{"Einmalig", "Jede Woche", "Jede zweite Woche"}));
        comboIntervall.setFont(new Font("Tahoma", Font.PLAIN, 22));
        comboIntervall.setBounds(15, 417, 382, 49);
        frame.getContentPane().add(comboIntervall);
        comboIntervall.addItem("Einmalig");
        comboIntervall.addItem("Jede Woche");
        comboIntervall.addItem("Jede zweite Woche");
        comboIntervall.setToolTipText("Hier bitte den Wiederholrhytmus auswählen");

        txtFieldDate = new JTextField();
        txtFieldDate.setName("Datum");
        txtFieldDate.setText("10.04.1999");
        txtFieldDate.setFont(new Font("Tahoma", Font.PLAIN, 22));
        txtFieldDate.setColumns(10);
        txtFieldDate.setBounds(437, 310, 361, 49);
        txtFieldDate.setToolTipText("Hier bitte das Datum der ersten Veranstaltung eintragen im Format - DD.MM.YYYY");
        frame.getContentPane().add(txtFieldDate);

        JLabel lblDatum = new JLabel("Datum");
        lblDatum.setBounds(437, 274, 203, 20);
        frame.getContentPane().add(lblDatum);

        comboTyp = new JComboBox();
        comboTyp.setName("Typ");
        comboTyp.setModel(new DefaultComboBoxModel(new String[]{"Vorlesung\t", "Praktikum", "Seminar", "Tutorium"}));
        comboTyp.setFont(new Font("Tahoma", Font.PLAIN, 22));
        comboTyp.setBounds(437, 114, 361, 49);
        comboTyp.setToolTipText("Bitte die Art der Veranstaltung auswählen");
        frame.getContentPane().add(comboTyp);

        error = new JTextField();
        error.setBounds(14, 538, 795, 20);
        frame.getContentPane().add(error);
        error.setColumns(10);
    }

    public void actionPerformed(ActionEvent ae)
    {

        eingabeEinheit = new Einheit();
        Fach eingabeFach;
        //Testen
        ArrayList<JTextField> EinheitList = new ArrayList();
     //   EinheitList.add(txtFieldName);
        EinheitList.add(txtFieldTimeStart);
        EinheitList.add(txtFieldTimeStop);
        EinheitList.add(txtFieldDate);
        EinheitList.add(txtFieldLocation);
        EinheitList.add(txtFieldTeacher);

        Controller.iterateField(EinheitList, error);
        if(Controller.iterateField(EinheitList, error).equals("") && Controller.checkTime(txtFieldTimeStart, txtFieldTimeStop).equals(""))
        {
            Confirmation.startConfirmation(plan);
            //  Confirmation.confirm("Ihre Eingaben wurden erfolgreich auf Korrektheit geprüft!");
            Confirmation.confirm("Ihre Einheit wurde erfolgreich hinzugefügt!");

            int prio;
            if(checkPflicht.isSelected()){
                prio = 10;
            }else {
                prio = 1;
            }

            eingabeEinheit.setName(nameBox.getSelectedItem().toString());
            eingabeEinheit.setAnfangsZeit(LocalTime.parse(txtFieldTimeStart.getText()));
            eingabeEinheit.setEndZeit(LocalTime.parse(txtFieldTimeStop.getText()));
            eingabeEinheit.setDate(LocalDate.parse(txtFieldDate.getText(), DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            eingabeEinheit.setOrt(txtFieldLocation.getText());
            eingabeEinheit.setLehrender(txtFieldTeacher.getText());
            eingabeEinheit.setWiederholungsrhytmus(comboIntervall.getSelectedItem().toString());
            eingabeEinheit.setTyp(comboTyp.getSelectedItem().toString());
            eingabeEinheit.setPriorität(prio);

            eingabeFach = plan.getStundenplan().searchFach(eingabeEinheit.getName());
            if(eingabeFach == null){
                eingabeFach = new Fach(eingabeEinheit.getName(), new ArrayList<>());


            }

            plan.getStundenplan().addFach(eingabeFach);

            eingabeFach.setStundenplan(plan.getStundenplan());

            eingabeFach.addEinheit(eingabeEinheit);
            eingabeEinheit.setFach(eingabeFach);


            getFacherList();
            nameBox.setModel(new DefaultComboBoxModel(fächer));








            for (int i = 0; i <= MainGUI.daten.length; i++) {
                if (MainGUI.daten[i] == null) {

                    MainGUI.daten[i] = (getAttributes());

                    break;
                }
            }


            /*
            for(int i = 0; i<fächer.length;i++)
            {
                if(fächer[i]==null)
                {
                    if(nameBox.getSelectedItem()!=fächer[i])
                    {
                        Einheit e = new Einheit(getAttributes());
                        List<Einheit> einheiten=null;
                        einheiten.add(e);
                        Fach f = new Fach(((String)nameBox.getSelectedItem()).toLowerCase(),einheiten);

                        fächer[i] = "" + nameBox.getSelectedItem();
                        nameBox.setModel(new DefaultComboBoxModel(fächer));
                        System.out.println(fächer[i]);
                        Object[] etwas= plan.collectArgs();
                        System.out.println(etwas[0]);
                        break;
                    }
                    else
                    {
                      //  Einheit e = new Einheit(getAttributes())

                    }
                }
            }
            */

            controller.initDB();
            controller.save(plan);
            controller.closeDB();

        } else {
            Confirmation.startConfirmation(plan);
            Confirmation.confirm(Controller.iterateField(EinheitList, error) + Controller.checkTime(txtFieldTimeStart, txtFieldTimeStop));
        }
        }
/*
        Object[] tableArgs = reorderAttributes();   //Setzte Neue Reihenfolge für Object Array fest, damit sie zur Reihenfolge für das TableModel passt

        ArrayList<JTextField> txtFieldsToCheck = collectTxtFields();

        if(controller.iterateField(txtFieldsToCheck) && controller.checkTime(txtFieldTimeStart, txtFieldTimeStop)){      // Falls Felder alle in Ordnung sind kommt true zurück

            eingabeEinheit = new Einheit(args);

            //Setzte Neue Reihenfolge für Object Array fest, damit sie zur Reihenfolge für das TableModel passt


            MainGUI.tm.addRow(tableArgs);

        }

    }
*/
        private Object[] getAttributes()
        {
            Object[] args = new Object[10];

            args[0] = nameBox.getSelectedItem();
            args[1] = comboTyp.getSelectedItem();

            LocalTime startTime = LocalTime.parse(txtFieldTimeStart.getText());
            LocalTime endTime = LocalTime.parse(txtFieldTimeStop.getText());

            //args[2] = ""+startTime+"-"+endTime;
            args[2] = startTime;
            args[3] = endTime;
            args[4] = txtFieldLocation.getText();
            args[5] = txtFieldTeacher.getText();

            LocalDate date = LocalDate.parse(txtFieldDate.getText(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            args[6] = date;

            args[7] = (comboIntervall.getSelectedItem());


            if (checkPflicht.isSelected()) {
                args[8] = 10;
            } else {
                args[8] = 1;
            }





            return args;

        }

        private ArrayList<JTextField> collectTxtFields () {
            ArrayList<JTextField> gatheredTxtFields = new ArrayList<>();

            gatheredTxtFields.add(txtFieldDate);
            gatheredTxtFields.add(txtFieldLocation);
          //  gatheredTxtFields.add(txtFieldName);
            gatheredTxtFields.add(txtFieldTeacher);

            return gatheredTxtFields;
        }

        public Object[] reorderAttributes () {
            Object[] args = new Object[9];

            args[0] = nameBox.getSelectedItem();
            args[1] = comboTyp.getSelectedItem();

            LocalTime startTime = LocalTime.parse(txtFieldTimeStart.getText());
            LocalTime endTime = LocalTime.parse(txtFieldTimeStop.getText());

            args[2] = "" + startTime + "-" + endTime;
            args[3] = txtFieldLocation.getText();
            args[4] = txtFieldTeacher.getText();

            LocalDate date = LocalDate.parse(txtFieldDate.getText(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            args[6] = date;

            args[7] = (comboIntervall.getSelectedItem());

            args[5] = (checkPflicht.isSelected());

            return args;

    }


        public static void ChangeEinheit(String name, String type, LocalTime start, LocalTime schluss, String location, String teacher, LocalDate datum, String intervall, Boolean pflicht)
        {
            nameBox.setSelectedItem(name);
            comboTyp.setSelectedItem(type);
            txtFieldTimeStart.setText(""+start+"");
            txtFieldTimeStop.setText(""+schluss+"");
            txtFieldLocation.setText(location);
            txtFieldTeacher.setText(teacher);
            txtFieldDate.setText(""+datum+"");
            comboIntervall.setSelectedItem(intervall);
            checkPflicht.setSelected(pflicht);
        }

        public void getFacherList(){
            List<Fach> faecher = plan.getStundenplan().getFaecher();

            for (int i = 0; i < faecher.size(); i++){
                fächer[i] =  faecher.get(i).getName();
            }
        }



}