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
    private JTextField textField_5;
    JComboBox comboBox = new JComboBox();
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        textField_1.setBounds(16, 209, 153, 49);
        frame.getContentPane().add(textField_1);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
        textField_2.setColumns(10);
        textField_2.setBounds(228, 209, 153, 49);
        frame.getContentPane().add(textField_2);

        JLabel label_4 = new JLabel("-");
        label_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
        label_4.setBounds(197, 214, 31, 33);
        frame.getContentPane().add(label_4);

        textField_3 = new JTextField();
        textField_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
        textField_3.setColumns(10);
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
                eingabetermin.setPeriodisch(comboBox.getSelectedItem().toString());
                //eingabetermin.setPriorität((int)comboBox.getSelectedItem());
                eingabetermin.setOrt(textField_3.getText());
                eingabetermin.setDatum(textField_5.getText());

                //neuen Termin mit Eingabewerten anlegen und der Liste hinzufügen
                Termin.Termine.add(new Termin(	eingabetermin.getBezeichnung(),
                        eingabetermin.getStartzeit(),
                        eingabetermin.getEndzeit(),
                        eingabetermin.getPeriodisch(),
                        eingabetermin.getPriorität(),
                        eingabetermin.getOrt(),
                        eingabetermin.getDatum()));



                Termin.Termineausgeben();




            }
        });
        button.setBounds(438, 417, 361, 99);
        frame.getContentPane().add(button);

        JLabel label_7 = new JLabel("Periodisch");
        label_7.setBounds(16, 274, 203, 20);
        frame.getContentPane().add(label_7);

        //	JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Einmalig", "W\u00F6chentlich", "Alle zwei Wochen"}));
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 22));
        comboBox.setBounds(16, 310, 382, 49);
        frame.getContentPane().add(comboBox);

        textField_5 = new JTextField();
        textField_5.setText("DD.MM.JJJJ");
        textField_5.setFont(new Font("Tahoma", Font.PLAIN, 22));
        textField_5.setColumns(10);
        textField_5.setBounds(438, 310, 361, 49);
        frame.getContentPane().add(textField_5);

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
