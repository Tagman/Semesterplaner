package GUI;

/**
 * Created by chris on 30/11/16.
 */

import Backend.Controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.time.LocalTime;

public class AddEinheit implements ActionListener {

    private JFrame frame;
    private JTextField txtFieldName;
    private JTextField txtFieldTimeStart;
    private JTextField txtFieldTimeStop;
    private JTextField txtFieldLocation;
    private JTextField txtFieldTeacher;
    private JTextField txtFieldDate;
    private JComboBox comboTyp;
    private JComboBox comboIntervall;
    private JCheckBox checkPflicht;

    Controller controller = new Controller();




    /**
     * Launch the application.
     */
    public static void main(String[] args) {


        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddEinheit window = new AddEinheit();
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
    public AddEinheit() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 835, 608);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Hinzuf\u00FCgen einer Einheit");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
        lblNewLabel.setBounds(196, 16, 400, 33);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblName = new JLabel("Name der Veranstaltung");
        lblName.setBounds(15, 76, 186, 20);
        frame.getContentPane().add(lblName);

        txtFieldName = new JTextField();
        txtFieldName.setName("Name");
        //txtFieldName.setToolTipText("Hier Name eingeben. mind. 3 max 29 Zeichen");
        txtFieldName.setFont(new Font("Tahoma", Font.PLAIN, 22));
        txtFieldName.setBounds(14, 114, 383, 49);
        frame.getContentPane().add(txtFieldName);
        txtFieldName.setColumns(10);

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
        frame.getContentPane().add(txtFieldTimeStart);

        txtFieldTimeStop = new JTextField();
        txtFieldTimeStop.setName("Endzeit");
        txtFieldTimeStop.setFont(new Font("Tahoma", Font.PLAIN, 22));
        txtFieldTimeStop.setColumns(10);
        txtFieldTimeStop.setText("14:00");
        txtFieldTimeStop.setBounds(227, 209, 153, 49);
        frame.getContentPane().add(txtFieldTimeStop);

        JLabel label = new JLabel("-");
        label.setFont(new Font("Tahoma", Font.PLAIN, 30));
        label.setBounds(196, 214, 31, 33);
        frame.getContentPane().add(label);

        txtFieldLocation = new JTextField();
        txtFieldLocation.setName("Ort");
        txtFieldLocation.setFont(new Font("Tahoma", Font.PLAIN, 22));
        txtFieldLocation.setColumns(10);
        txtFieldLocation.setText("Field4");
        txtFieldLocation.setBounds(437, 209, 361, 49);
        frame.getContentPane().add(txtFieldLocation);

        JLabel lblRaumbezeichnung = new JLabel("Raumbezeichnung");
        lblRaumbezeichnung.setBounds(437, 179, 203, 20);
        frame.getContentPane().add(lblRaumbezeichnung);

        checkPflicht = new JCheckBox("Pflichtveranstaltung?");
        checkPflicht.setName("Pflichtveranstaltung?");
        checkPflicht.setBounds(15, 487, 224, 49);
        frame.getContentPane().add(checkPflicht);

        JButton btnHinzufgen = new JButton("Zum Stundenplan hinzuf\u00FCgen");
        btnHinzufgen.setBounds(437, 417, 361, 99);
        btnHinzufgen.addActionListener(this);
        frame.getContentPane().add(btnHinzufgen);

        JLabel lblNameDesLrhrenden = new JLabel("Name des Lehrenden");
        lblNameDesLrhrenden.setBounds(15, 274, 203, 20);
        frame.getContentPane().add(lblNameDesLrhrenden);

        txtFieldTeacher = new JTextField();
        txtFieldTeacher.setName("Lehrender");
        txtFieldTeacher.setFont(new Font("Tahoma", Font.PLAIN, 22));
        txtFieldTeacher.setColumns(10);
        txtFieldTeacher.setBounds(14, 310, 383, 49);
        frame.getContentPane().add(txtFieldTeacher);

        JLabel lblPeriodisch = new JLabel("Periodisch");
        lblPeriodisch.setBounds(15, 381, 203, 20);
        frame.getContentPane().add(lblPeriodisch);

        comboIntervall = new JComboBox();
        comboIntervall.setName("Intervall");
        comboIntervall.setModel(new DefaultComboBoxModel(new String[] {"Einmalig", "Jede Woche", "Jede zweite Woche", "sdgsgdfh", "dsgsdgsfhjta", "j", "htdhtfhtsfhdj", "sdfgdhrsfjtdh", "dhfg", "hfg", "hdfh", "fgj", "fg", "hdyfh", "fjgh", "kr", "fjfxhfgjxf", "hshrtzjzfx", "nfj", "fjzfxhk", "xuglkx", "jfzhj", "zkk", "zfj"}));
        comboIntervall.setFont(new Font("Tahoma", Font.PLAIN, 22));
        comboIntervall.setBounds(15, 417, 382, 49);
        frame.getContentPane().add(comboIntervall);
        comboIntervall.addItem("Einmalig");
        comboIntervall.addItem("Jede Woche");
        comboIntervall.addItem("Jede zweite Woche");

        txtFieldDate = new JTextField();
        txtFieldDate.setName("Datum");
        txtFieldDate.setText("10.04.1999");
        txtFieldDate.setFont(new Font("Tahoma", Font.PLAIN, 22));
        txtFieldDate.setColumns(10);
        txtFieldDate.setBounds(437, 310, 361, 49);
        frame.getContentPane().add(txtFieldDate);

        JLabel lblDatum = new JLabel("Datum");
        lblDatum.setBounds(437, 274, 203, 20);
        frame.getContentPane().add(lblDatum);

        comboTyp = new JComboBox();
        comboTyp.setName("Typ");
        comboTyp.setModel(new DefaultComboBoxModel(new String[] {"Vorlesung\t", "Praktikum", "Seminar", "Tutorium"}));
        comboTyp.setFont(new Font("Tahoma", Font.PLAIN, 22));
        comboTyp.setBounds(437, 114, 361, 49);
        frame.getContentPane().add(comboTyp);
    }

    public void actionPerformed(ActionEvent ae){
        /*

        System.out.println("Test");

        Object[] args = getAttributes();


        Backend.Einheit newEinheit = new Backend.Einheit(args);
        newEinheit.ausgabe();

        */

        ArrayList<JTextField> txtFieldsToCheck = new ArrayList<>();

        txtFieldsToCheck = collectTxtFields();

        controller.iterateField(txtFieldsToCheck);

        /*
        ////////////////////////////////////////////
        //Hier MethodenAufruf für Prüfung einbauen
         */




    }

    private Object[] getAttributes() {
        Object[] args = new Object[9];

        args[0] = txtFieldName.getText();
        args[1] = comboTyp.getSelectedItem();

        LocalTime startTime = LocalTime.parse(txtFieldTimeStart.getText());
        LocalTime endTime = LocalTime.parse(txtFieldTimeStop.getText());

        args[2] = startTime;
        args[3] = endTime;
        args[4] = txtFieldLocation.getText();
        args[5] = txtFieldTeacher.getText();

        LocalDate date = LocalDate.parse(txtFieldDate.getText(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        args[6] = date;

        if(comboIntervall.getSelectedItem().equals("Einmalig")){
            args[7] = 0;
        }
        else if(comboIntervall.getSelectedItem().equals("Jede Woche")){
            args[7] = 1;
        }
        else {
            args[7] = 2;
        }
        if(checkPflicht.isSelected()){
            args[8] = 10;
        }
        else {
            args[8] = 1;
        }


        return args;

    }

    private ArrayList<JTextField> collectTxtFields(){
       ArrayList<JTextField> gatheredTxtFields = new ArrayList<>();

        gatheredTxtFields.add(txtFieldDate);
        gatheredTxtFields.add(txtFieldLocation);
        gatheredTxtFields.add(txtFieldName);
        gatheredTxtFields.add(txtFieldTeacher);

        return gatheredTxtFields;
    }


}

