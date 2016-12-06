package GUI;

/**
 * Created by chris on 04/12/16.
 */

import Backend.Termin;
import sun.rmi.server.LoaderHandler;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddTermin implements ActionListener{

    //speichert eingabe
    private Termin eingabeTermin;


    private JFrame frame;
    private JTextField txtFieldName;
    private JTextField txtFieldTimeStart;
    private JTextField txtFieldTimeStop;
    private JTextField txtFieldLocation;
    private JTextField txtFieldDate;
    private JComboBox comboInterval = new JComboBox();
    private JComboBox comboPriority = new JComboBox();

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
        txtFieldTimeStart.setText("Field1");
        txtFieldTimeStart.setBounds(16, 209, 153, 49);
        frame.getContentPane().add(txtFieldTimeStart);

        txtFieldTimeStop = new JTextField();
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
        txtFieldLocation.setFont(new Font("Tahoma", Font.PLAIN, 22));
        txtFieldLocation.setColumns(10);
        txtFieldLocation.setText("Field3");
        txtFieldLocation.setBounds(438, 209, 361, 49);
        frame.getContentPane().add(txtFieldLocation);

        JLabel lblOrt = new JLabel("Ort\r\n");
        lblOrt.setBounds(438, 179, 203, 20);
        frame.getContentPane().add(lblOrt);

        JButton button = new JButton("Zum Stundenplan hinzuf\u00FCgen");
        button.addActionListener(this);
        button.setBounds(438, 417, 361, 99);
        frame.getContentPane().add(button);

        JLabel label_7 = new JLabel("Periodisch");
        label_7.setBounds(16, 274, 203, 20);
        frame.getContentPane().add(label_7);

        //	JComboBox comboInterval = new JComboBox();
        comboInterval.setModel(new DefaultComboBoxModel(new String[] {"Einmalig", "W\u00F6chentlich", "Alle zwei Wochen"}));
        comboInterval.setFont(new Font("Tahoma", Font.PLAIN, 22));
        comboInterval.setBounds(16, 310, 382, 49);
        frame.getContentPane().add(comboInterval);

        txtFieldDate = new JTextField();
        txtFieldDate.setText("DD.MM.JJJJ");
        txtFieldDate.setFont(new Font("Tahoma", Font.PLAIN, 22));
        txtFieldDate.setColumns(10);
        txtFieldDate.setBounds(438, 310, 361, 49);
        frame.getContentPane().add(txtFieldDate);

        JLabel label_8 = new JLabel("Datum");
        label_8.setBounds(438, 274, 203, 20);
        frame.getContentPane().add(label_8);

        //	JComboBox comboPriority = new JComboBox();
        comboPriority.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
        comboPriority.setFont(new Font("Tahoma", Font.PLAIN, 22));
        comboPriority.setBounds(438, 114, 361, 49);
        frame.getContentPane().add(comboPriority);
    }

    public void actionPerformed(ActionEvent arg0) {



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

        MainGUI.tm.addRow(new Object[]{eingabeTermin.getBezeichnung(), "", eingabeTermin.getStartZeit()+"-"+ eingabeTermin.getEndZeit(), eingabeTermin.getOrt(), "", "", eingabeTermin.getDatum(), eingabeTermin.getPeriodisch(), eingabeTermin.getPriorität()});




    }
}
