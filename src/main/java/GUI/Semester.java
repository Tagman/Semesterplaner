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

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Semester implements ActionListener{

    private JFrame frame;
    private JTextField txtFieldName;
    private JTextField txtFieldStartZeit;
    private JTextField txtFieldEndZeit;
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

        txtFieldName = new JTextField();
        txtFieldName.setName("Startdatum");
        txtFieldName.setFont(new Font("Tahoma", Font.PLAIN, 22));
        txtFieldName.setBounds(190, 133, 186, 50);
        txtFieldName.setToolTipText("Startdatum eintragen. (DD.MM.YYYY)");
        frame.getContentPane().add(txtFieldName);
        txtFieldName.setColumns(10);

        txtFieldStartZeit = new JTextField();
        txtFieldStartZeit.setName("Enddatum");
        txtFieldStartZeit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        txtFieldStartZeit.setColumns(10);
        txtFieldStartZeit.setBounds(448, 133, 186, 50);
        txtFieldStartZeit.setToolTipText("Enddatum eintragen. (DD.MM.YYYY)");
        frame.getContentPane().add(txtFieldStartZeit);

        JLabel label = new JLabel("-");
        label.setFont(new Font("Tahoma", Font.PLAIN, 27));
        label.setBounds(401, 152, 42, 20);
        frame.getContentPane().add(label);

        JLabel lblSemesterbezeichnung = new JLabel("Semesterbezeichnung");
        lblSemesterbezeichnung.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblSemesterbezeichnung.setBounds(13, 71, 167, 20);
        frame.getContentPane().add(lblSemesterbezeichnung);

        txtFieldEndZeit = new JTextField();
        txtFieldEndZeit.setName("Semesterbezeichnung");
        txtFieldEndZeit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        txtFieldEndZeit.setColumns(10);
        txtFieldEndZeit.setBounds(190, 71, 444, 50);
        txtFieldEndZeit.setToolTipText("Die Bezeichnung für das Semester eingeben. (zwischen 3 und 29 Zeichen)");
        frame.getContentPane().add(txtFieldEndZeit);

        error = new JTextField();
        error.setBounds(10, 489, 818, 20);
        frame.getContentPane().add(error);
        error.setColumns(10);

        JButton btnBesttigen = new JButton("Best\u00E4tigen");
        btnBesttigen.addActionListener(this);
        btnBesttigen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0)
            {
                //Testen
                ArrayList<JTextField> SemesterList= new ArrayList();
                SemesterList.add(txtFieldStartZeit);
                SemesterList.add(txtFieldEndZeit);
                SemesterList.add(txtFieldName);
                Controller.iterateField(SemesterList,error);
                MainGUI.main(null);
                frame.dispose();
            }
        });
        btnBesttigen.setBounds(291, 289, 231, 68);
        btnBesttigen.setToolTipText("Drücken des Knopfes erstellt den neuen Semesterplan.");
        frame.getContentPane().add(btnBesttigen);
    }


    public void actionPerformed(ActionEvent ae){

        Semesterplan se = new  Semesterplan();
        se.setSemesterName(txtFieldName.getText()); //speichern
        se.setStartDate(LocalDate.parse(txtFieldStartZeit.getText())); //speichern
        se.setEndDate(LocalDate.parse(txtFieldEndZeit.getText())); //speichern
        MainGUI.main(null);
        MainGUI.sem=se;
        frame.dispose();

    }
}


