package GUI;

/**
 * Created by chris on 04/12/16.
 */

import Backend.Controller;
import Backend.Termin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddTermin {

    //speichert eingabe
    private Termin eingabetermin = new Termin();


    private JFrame frame;
    private JTextField name;
    private JTextField start;
    private JTextField ende;
    private JTextField ort;
    private JTextField Datum;
    JComboBox comboIntervall = new JComboBox();
    JComboBox comboBox_1 = new JComboBox();
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

        name = new JTextField();
        name.setFont(new Font("Tahoma", Font.PLAIN, 22));
        name.setName("Bezeichnung");
        name.setText("Field");
        name.setColumns(10);
        name.setBounds(15, 114, 383, 49);
        frame.getContentPane().add(name);

        JLabel lblPriorittDesTermins = new JLabel("Priorit\u00E4t des Termins");
        lblPriorittDesTermins.setBounds(438, 76, 203, 20);
        frame.getContentPane().add(lblPriorittDesTermins);

        JLabel label_3 = new JLabel("Uhrzeitintervall");
        label_3.setBounds(16, 179, 203, 20);
        frame.getContentPane().add(label_3);

        start = new JTextField();
        start.setName("Startzeit");
        start.setFont(new Font("Tahoma", Font.PLAIN, 22));
        start.setColumns(10);
        start.setText("Field1");
        start.setBounds(16, 209, 153, 49);
        frame.getContentPane().add(start);

        ende = new JTextField();
        ende.setName("Endzeit");
        ende.setFont(new Font("Tahoma", Font.PLAIN, 22));
        ende.setColumns(10);
        ende.setText("Field2");
        ende.setBounds(228, 209, 153, 49);
        frame.getContentPane().add(ende);

        JLabel label_4 = new JLabel("-");
        label_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
        label_4.setBounds(197, 214, 31, 33);
        frame.getContentPane().add(label_4);

        ort = new JTextField();
        ort.setName("Veranstaltungsort");
        ort.setFont(new Font("Tahoma", Font.PLAIN, 22));
        ort.setColumns(10);
        ort.setText("Field3");
        ort.setBounds(438, 209, 361, 49);
        frame.getContentPane().add(ort);

        JLabel lblOrt = new JLabel("Ort\r\n");
        lblOrt.setBounds(438, 179, 203, 20);
        frame.getContentPane().add(lblOrt);

        JButton button = new JButton("Zum Stundenplan hinzuf\u00FCgen");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                //Testen
                ArrayList<JTextField> TerminList= new ArrayList();
                TerminList.add(name);
                TerminList.add(start);
                TerminList.add(ende);
                TerminList.add(Datum);
                TerminList.add(ort);
                Controller.iterateField(TerminList,error);

                //eingabetermin mit werten füllen
                eingabetermin.setBezeichnung(name.getText());
                eingabetermin.setStartzeit(start.getText());
                eingabetermin.setEndzeit(ende.getText());
                eingabetermin.setPeriodisch(comboIntervall.getSelectedItem().toString());
                eingabetermin.setPriorität(Integer.parseInt((String) comboBox_1.getSelectedItem()));
                eingabetermin.setOrt(ort.getText());
                eingabetermin.setDatum(LocalDate.parse(Datum.getText(), DateTimeFormatter.ofPattern("dd.MM.yyyy")));

                //neuen Termin mit Eingabewerten anlegen und der Liste hinzufügen
                Termin.Termine.add(new Termin(
                        eingabetermin.getBezeichnung(),
                        eingabetermin.getStartzeit(),
                        eingabetermin.getEndzeit(),
                        eingabetermin.getPeriodisch(),
                        eingabetermin.getPriorität(),
                        eingabetermin.getOrt(),
                        eingabetermin.getDatum()));

                //experimentell
                Object[] args = new Object[9];
                args[0] = eingabetermin.getBezeichnung();
                args[1] = "";
                args[2] = eingabetermin.getStartzeit()+"-"+eingabetermin.getEndzeit();
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




            }
        });
        button.setBounds(438, 417, 361, 99);
        frame.getContentPane().add(button);

        JLabel label_7 = new JLabel("Periodisch");
        label_7.setBounds(16, 274, 203, 20);
        frame.getContentPane().add(label_7);

        //	JComboBox comboIntervall = new JComboBox();
        comboIntervall.setModel(new DefaultComboBoxModel(new String[] {"Einmalig", "W\u00F6chentlich", "Alle zwei Wochen"}));
        comboIntervall.setFont(new Font("Tahoma", Font.PLAIN, 22));
        comboIntervall.setBounds(16, 310, 382, 49);
        frame.getContentPane().add(comboIntervall);

        Datum = new JTextField();
        Datum.setName("Datum");
        Datum.setText("DD.MM.JJJJ");
        Datum.setFont(new Font("Tahoma", Font.PLAIN, 22));
        Datum.setColumns(10);
        Datum.setBounds(438, 310, 361, 49);
        frame.getContentPane().add(Datum);

        JLabel label_8 = new JLabel("Datum");
        label_8.setBounds(438, 274, 203, 20);
        frame.getContentPane().add(label_8);

        //	JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
        comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
        comboBox_1.setBounds(438, 114, 361, 49);
        frame.getContentPane().add(comboBox_1);

        error = new JTextField();
        error.setBounds(10, 540, 799, 20);
        frame.getContentPane().add(error);
        error.setColumns(10);
    }
}
