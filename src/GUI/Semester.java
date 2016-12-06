package GUI;

/**
 * Created by chris on 04/12/16.
 */

import Backend.Controller;
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
import java.util.ArrayList;

public class Semester {

    private JFrame frame;
    private JTextField start;
    private JTextField ende;
    private JTextField name;
    private JTextField error;

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
        lblErstellenEinesNeuen.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblErstellenEinesNeuen.setBounds(190, 16, 564, 33);
        frame.getContentPane().add(lblErstellenEinesNeuen);

        JLabel lblSemesterzeitraum = new JLabel("Semesterzeitraum");
        lblSemesterzeitraum.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblSemesterzeitraum.setBounds(15, 133, 142, 20);
        frame.getContentPane().add(lblSemesterzeitraum);

        start = new JTextField();
        start.setName("Startdatum");
        start.setFont(new Font("Tahoma", Font.PLAIN, 22));
        start.setBounds(190, 133, 186, 50);
        start.setToolTipText("Startdatum eintragen. (DD.MM.YYYY)");
        frame.getContentPane().add(start);
        start.setColumns(10);

        ende = new JTextField();
        ende.setName("Enddatum");
        ende.setFont(new Font("Tahoma", Font.PLAIN, 22));
        ende.setColumns(10);
        ende.setBounds(448, 133, 186, 50);
        ende.setToolTipText("Enddatum eintragen. (DD.MM.YYYY)");
        frame.getContentPane().add(ende);

        JLabel label = new JLabel("-");
        label.setFont(new Font("Tahoma", Font.PLAIN, 27));
        label.setBounds(401, 152, 42, 20);
        frame.getContentPane().add(label);

        JLabel lblSemesterbezeichnung = new JLabel("Semesterbezeichnung");
        lblSemesterbezeichnung.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblSemesterbezeichnung.setBounds(13, 71, 167, 20);
        frame.getContentPane().add(lblSemesterbezeichnung);

        name = new JTextField();
        name.setName("Semesterbezeichnung");
        name.setFont(new Font("Tahoma", Font.PLAIN, 22));
        name.setColumns(10);
        name.setBounds(190, 71, 444, 50);
        name.setToolTipText("Die Bezeichnung für das Semester eingeben. (zwischen 3 und 29 Zeichen)");
        frame.getContentPane().add(name);

        error = new JTextField();
        error.setBounds(10, 489, 818, 20);
        frame.getContentPane().add(error);
        error.setColumns(10);

        JButton btnBesttigen = new JButton("Best\u00E4tigen");
        btnBesttigen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0)
            {
                //Testen
                ArrayList<JTextField> SemesterList= new ArrayList();
                SemesterList.add(start);
                SemesterList.add(ende);
                SemesterList.add(name);

                Controller.iterateField(SemesterList,error);

                Semesterplan Se = new  Semesterplan();
                Se.setSemestername(start.getText()); //speichern
                //  Se.setStartzeit(LocalTime.parse(textField_1.getText())); //speichern
                //  Se.setEndzeit(LocalTime.parse(textField_2.getText())); //speichern
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


