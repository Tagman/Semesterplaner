package GUI;

import Backend.Termin;

import java.awt.EventQueue;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

public class ChangeTermin    {

    private Termin änderungstermin = new Termin();

    Termin termino = new Termin(); //zu ändernder termin

    private JFrame frame;
    private JTextField txtPhysiotherapie;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField txtMusterstrae;
    private JTextField textField_4;

    JComboBox comboBox = new JComboBox();
    JComboBox comboBox_1 = new JComboBox();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ChangeTermin window = new ChangeTermin();
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
    public ChangeTermin() {
        initialize();
    }



    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 851, 610);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel label = new JLabel("ändern eines Termins");
        label.setFont(new Font("Tahoma", Font.PLAIN, 27));
        label.setBounds(197, 16, 400, 33);
        frame.getContentPane().add(label);

        JLabel label_1 = new JLabel("Bezeichnung des Termins");
        label_1.setBounds(16, 76, 186, 20);
        frame.getContentPane().add(label_1);

        txtPhysiotherapie = new JTextField();
        txtPhysiotherapie.setText("Physiotherapie");
        txtPhysiotherapie.setFont(new Font("Tahoma", Font.PLAIN, 22));
        txtPhysiotherapie.setColumns(10);
        txtPhysiotherapie.setBounds(15, 114, 383, 49);
        frame.getContentPane().add(txtPhysiotherapie);

        JLabel label_2 = new JLabel("Priorit\u00E4t des Termins");
        label_2.setBounds(438, 76, 203, 20);
        frame.getContentPane().add(label_2);

        JLabel label_3 = new JLabel("Uhrzeitintervall");
        label_3.setBounds(16, 179, 203, 20);
        frame.getContentPane().add(label_3);

        textField_1 = new JTextField();
        textField_1.setText("13:00");
        textField_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
        textField_1.setColumns(10);
        textField_1.setBounds(16, 209, 153, 49);
        frame.getContentPane().add(textField_1);

        textField_2 = new JTextField();
        textField_2.setText("14:30");
        textField_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
        textField_2.setColumns(10);
        textField_2.setBounds(228, 209, 153, 49);
        frame.getContentPane().add(textField_2);

        JLabel label_4 = new JLabel("-");
        label_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
        label_4.setBounds(197, 214, 31, 33);
        frame.getContentPane().add(label_4);

        txtMusterstrae = new JTextField();
        txtMusterstrae.setText("Musterstra\u00DFe 11");
        txtMusterstrae.setFont(new Font("Tahoma", Font.PLAIN, 22));
        txtMusterstrae.setColumns(10);
        txtMusterstrae.setBounds(438, 209, 361, 49);
        frame.getContentPane().add(txtMusterstrae);

        JLabel label_5 = new JLabel("Ort\r\n");
        label_5.setBounds(438, 179, 203, 20);
        frame.getContentPane().add(label_5);

        JButton btnBesttigen = new JButton("Best\u00E4tigen");
      /*  btnBesttigen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {



                ///werte einlesen und änderungstermin mit werten füllen
                änderungstermin.setBezeichnung(txtPhysiotherapie.getText());
                änderungstermin.setStartZeit(LocalTime.parse(textField_1.getText()));
               // änderungstermin.setStartZeit(textField_1.getText());
                änderungstermin.setEndZeit(LocalTime.parse(textField_2.getText()));
                //änderungstermin.setEndZeit(textField_2.getText());
                änderungstermin.setPeriodisch(comboBox.getSelectedItem().toString());
                //änderungstermin.setPriorität((int)comboIntervall.getSelectedItem());
                änderungstermin.setOrt(txtMusterstrae.getText());
                änderungstermin.setDatum(textField_4.getText());

                //ausgewählten termin mit änderungstermin füllen


                if (Termin.Termine.size()==0) Termin.Termine.add(termino); //falls liste leer, leeren beispieltermin einfügen

                termino.changeTermin(
                        änderungstermin.getBezeichnung(),
                        änderungstermin.getStartZeit(),
                        änderungstermin.getEndZeit(),
                        änderungstermin.getPeriodisch(),
                        änderungstermin.getPriorität(),
                        änderungstermin.getOrt(),
                        änderungstermin.getDatum());



            }
        });
*/
        btnBesttigen.setBounds(438, 417, 361, 99);
        frame.getContentPane().add(btnBesttigen);

        JLabel label_6 = new JLabel("Periodisch");
        label_6.setBounds(16, 274, 203, 20);
        frame.getContentPane().add(label_6);

        //JComboBox comboIntervall = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"W\u00F6chentlich", "Einmalig", "Alle zwei Wochen"}));
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 22));
        comboBox.setBounds(16, 310, 382, 49);
        frame.getContentPane().add(comboBox);

        textField_4 = new JTextField();
        textField_4.setText("09.11.2016");
        textField_4.setFont(new Font("Tahoma", Font.PLAIN, 22));
        textField_4.setColumns(10);
        textField_4.setBounds(438, 310, 361, 49);
        frame.getContentPane().add(textField_4);

        JLabel label_7 = new JLabel("Datum");
        label_7.setBounds(438, 274, 203, 20);
        frame.getContentPane().add(label_7);

        //JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"8", "1", "2", "3", "4", "5", "6", "7", "9", "10"}));
        comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
        comboBox_1.setBounds(438, 114, 361, 49);
        frame.getContentPane().add(comboBox_1);
    }

}
