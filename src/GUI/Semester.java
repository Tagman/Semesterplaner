package GUI;

/**
 * Created by chris on 04/12/16.
 */

import Backend.Semesterplan;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.LocalTime;

public class Semester {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Semester window = new Semester();
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
    public Semester() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 854, 559);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblErstellenEinesNeuen = new JLabel("Erstellen eines neuen Semesterplans");
        lblErstellenEinesNeuen.setFont(new Font("Arial Black", Font.BOLD, 20));
        lblErstellenEinesNeuen.setBounds(190, 16, 564, 33);
        frame.getContentPane().add(lblErstellenEinesNeuen);

        JLabel lblSemesterzeitraum = new JLabel("Semesterzeitraum");
        lblSemesterzeitraum.setFont(new Font("Arial Black", Font.BOLD, 11));
        lblSemesterzeitraum.setBounds(15, 152, 142, 20);
        frame.getContentPane().add(lblSemesterzeitraum);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
        textField.setBounds(192, 137, 186, 50);
        textField.setToolTipText("Startdatum eintragen. (DD.MM.YYYY)");
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
        textField_1.setColumns(10);
        textField_1.setBounds(448, 137, 186, 50);
        textField_1.setToolTipText("Enddatum eintragen. (DD.MM.YYYY)");
        frame.getContentPane().add(textField_1);

        JLabel label = new JLabel("-");
        label.setFont(new Font("Tahoma", Font.PLAIN, 27));
        label.setBounds(401, 152, 42, 20);
        frame.getContentPane().add(label);

        JLabel lblSemesterbezeichnung = new JLabel("Semesterbezeichnung");
        lblSemesterbezeichnung.setFont(new Font("Arial Black", Font.BOLD, 11));
        lblSemesterbezeichnung.setBounds(15, 88, 167, 20);
        frame.getContentPane().add(lblSemesterbezeichnung);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
        textField_2.setColumns(10);
        textField_2.setBounds(190, 71, 444, 50);
        textField_2.setToolTipText("Die Bezeichnung für das Semester eingeben. (zwischen 3 und 29 Zeichen)");
        frame.getContentPane().add(textField_2);

        JButton btnBesttigen = new JButton("Best\u00E4tigen");
        btnBesttigen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0)
            {
                Semesterplan Se = new  Semesterplan();
                Se.setSemestername(textField.getText()); //speichern
                Se.setStartzeit(LocalTime.parse(textField_1.getText())); //speichern
                Se.setEndzeit(LocalTime.parse(textField_2.getText())); //speichern
                MainGUI.main(null);
                MainGUI.sem=Se;
                frame.dispose();
            }
        });
        btnBesttigen.setBounds(291, 289, 231, 68);
        btnBesttigen.setToolTipText("Drücken des Knopfes erstellt den neuen Semesterplan.");
        frame.getContentPane().add(btnBesttigen);
    }
}


