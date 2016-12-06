package GUI;

/**
 * Created by chris on 04/12/16.
 */

import Backend.Termin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddTermin {

    //speichert eingabe
    private Termin eingabetermin = new Termin();


    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField txtFieldDate;
    JComboBox comboIntervall = new JComboBox();
    JComboBox comboBox_1 = new JComboBox();

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

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
        textField.setText("Field");
        textField.setColumns(10);
        textField.setBounds(15, 114, 383, 49);
        frame.getContentPane().add(textField);

        JLabel lblPriorittDesTermins = new JLabel("Priorit\u00E4t des Termins");
        lblPriorittDesTermins.setBounds(438, 76, 203, 20);
        frame.getContentPane().add(lblPriorittDesTermins);

        JLabel label_3 = new JLabel("Uhrzeitintervall");
        label_3.setBounds(16, 179, 203, 20);
        frame.getContentPane().add(label_3);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
        textField_1.setColumns(10);
        textField_1.setText("Field1");
        textField_1.setBounds(16, 209, 153, 49);
        frame.getContentPane().add(textField_1);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
        textField_2.setColumns(10);
        textField_2.setText("Field2");
        textField_2.setBounds(228, 209, 153, 49);
        frame.getContentPane().add(textField_2);

        JLabel label_4 = new JLabel("-");
        label_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
        label_4.setBounds(197, 214, 31, 33);
        frame.getContentPane().add(label_4);

        textField_3 = new JTextField();
        textField_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
        textField_3.setColumns(10);
        textField_3.setText("Field3");
        textField_3.setBounds(438, 209, 361, 49);
        frame.getContentPane().add(textField_3);

        JLabel lblOrt = new JLabel("Ort\r\n");
        lblOrt.setBounds(438, 179, 203, 20);
        frame.getContentPane().add(lblOrt);

        JButton button = new JButton("Zum Stundenplan hinzuf\u00FCgen");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {



                //eingabetermin mit werten füllen
                eingabetermin.setBezeichnung(textField.getText());
                eingabetermin.setStartzeit(textField_1.getText());
                eingabetermin.setEndzeit(textField_2.getText());
                eingabetermin.setPeriodisch(comboIntervall.getSelectedItem().toString());
                eingabetermin.setPriorität(Integer.parseInt((String) comboBox_1.getSelectedItem()));
                eingabetermin.setOrt(textField_3.getText());
                eingabetermin.setDatum(LocalDate.parse(txtFieldDate.getText(), DateTimeFormatter.ofPattern("dd.MM.yyyy")));

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

        txtFieldDate = new JTextField();
        txtFieldDate.setText("DD.MM.JJJJ");
        txtFieldDate.setFont(new Font("Tahoma", Font.PLAIN, 22));
        txtFieldDate.setColumns(10);
        txtFieldDate.setBounds(438, 310, 361, 49);
        frame.getContentPane().add(txtFieldDate);

        JLabel label_8 = new JLabel("Datum");
        label_8.setBounds(438, 274, 203, 20);
        frame.getContentPane().add(label_8);

        //	JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
        comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
        comboBox_1.setBounds(438, 114, 361, 49);
        frame.getContentPane().add(comboBox_1);
    }
}
