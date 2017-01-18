package GUI;

/**
 * Created by Whoop on 15.01.2017.
 */

import Backend.Controller;
import Backend.Termin;
import org.apache.log4j.Logger;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SearchTermin implements ActionListener,
                                        WindowListener{



    private JFrame frame;

    private Controller controller = new Controller();
    private static final Logger logger = Logger.getLogger(SearchTermin.class);

    private JComboBox boxAttribut;
    private JFormattedTextField ftfSuchbegriff;
    private JFormattedTextField kontrollAnzeige;

    private String whereAttribute;
    private String whereBedingung;



    private DefaultListModel listModel = new DefaultListModel();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SearchTermin window = new SearchTermin();
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
    public SearchTermin() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 470, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(this);

        JLabel lblSuchenTermin = new JLabel("Suchen eines Termins");
        lblSuchenTermin.setHorizontalAlignment(SwingConstants.CENTER);
        lblSuchenTermin.setFont(new Font("Arial", Font.PLAIN, 20));

        ftfSuchbegriff = new JFormattedTextField();
        ftfSuchbegriff.setToolTipText("Wonach soll gesucht werden?");
        ftfSuchbegriff.setFont(new Font("Arial", Font.PLAIN, 11));

        JLabel lbSuchbegriff = new JLabel("Suchbegriff:");
        lbSuchbegriff.setFont(new Font("Arial", Font.PLAIN, 11));

        JLabel lbAttribut = new JLabel("Attribut:");
        lbAttribut.setFont(new Font("Arial", Font.PLAIN, 11));

        boxAttribut = new JComboBox();
        boxAttribut.setModel(new DefaultComboBoxModel(new String[] {"Name", "Datum", "Ort", "Priorit\u00E4t", "Anfangszeit"}));
        boxAttribut.setToolTipText("Bitte Attribut ausw\u00E4hlen z.B. Ort, Dozent etc.");
        boxAttribut.setFont(new Font("Arial", Font.PLAIN, 11));

        JLabel lblErgebnis = new JLabel("Ergebnis:");

        lblErgebnis.setFont(new Font("Arial", Font.PLAIN, 11));

        JButton btnSuchen = new JButton("Suchen\r\n");
        btnSuchen.setToolTipText("Klicken um Suche zu starten");
        btnSuchen.addActionListener(this);
        btnSuchen.setFont(new Font("Arial", Font.PLAIN, 11));

        kontrollAnzeige = new JFormattedTextField();
        kontrollAnzeige.setEditable(false);
        kontrollAnzeige.setToolTipText("Kontrollanzeige");

        JList lsErgebnis = new JList(listModel);
        lsErgebnis.setFont(new Font("Arial", Font.PLAIN, 11));
        
        JButton btnNewButton = new JButton("Zurück");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose();
        	}
        });



        GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(kontrollAnzeige, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(lblErgebnis)
        						.addComponent(lbAttribut, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lbSuchbegriff, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addComponent(lsErgebnis, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblSuchenTermin, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
        						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
        							.addComponent(boxAttribut, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(ftfSuchbegriff, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
        					.addGap(244)
        					.addComponent(btnSuchen, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblSuchenTermin, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        			.addGap(44)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lbSuchbegriff)
        				.addComponent(ftfSuchbegriff, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lbAttribut)
        				.addComponent(boxAttribut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lsErgebnis, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblErgebnis))
        			.addGap(12)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(btnSuchen, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(kontrollAnzeige, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        frame.getContentPane().setLayout(groupLayout);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        kontrollAnzeige.setText("");
        whereAttribute = null;
        whereBedingung = null;
        listModel.removeAllElements();

        switch (boxAttribut.getSelectedIndex()){

            case 0: whereAttribute = "bezeichnung";
                    whereBedingung = "'" + ftfSuchbegriff.getText() + "'";
                    break;
            case 1: whereAttribute = "datum";
                    try {


                        LocalDate tempDate = LocalDate.parse(ftfSuchbegriff.getText(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                        whereBedingung = "STR_TO_DATE('" + tempDate.toString() + "', '%Y-%m-%d')";
                    }catch (DateTimeParseException ae){
                        kontrollAnzeige.setText("Datum muss in Format DD.MM.YYYY sein");
                    }
                    break;

            case 2: whereAttribute = "ort";
                    whereBedingung = "'" + ftfSuchbegriff.getText() + "'";
                    break;
            case 3: whereAttribute = "priorität";
                    whereBedingung = ftfSuchbegriff.getText();
                    break;

            case 4: whereAttribute = "TIME_FORMAT(startZeit, '%H:%i')";
                    try {


                        LocalTime tempTime = LocalTime.parse(ftfSuchbegriff.getText(), DateTimeFormatter.ofPattern("HH:mm"));
                        whereBedingung = "TIME_FORMAT('" + tempTime.toString() + "', '%H:%i')";
                    }catch (DateTimeParseException ex){
                        kontrollAnzeige.setText("Zeit muss in Format HH:MM angegeben werden");
                    }

                    break;

            default:
                    break;
        }

        controller.initDB();

        String query = controller.buildQueryStringTermin(whereAttribute, whereBedingung);
        List<Termin> results = controller.searchTermin(query);

        if(results.isEmpty()){
            if (kontrollAnzeige.getText().isEmpty()) {
                kontrollAnzeige.setText("Keine Einträge gefunden bzw. in DB gespeichert");
            }

        }
        else {
            kontrollAnzeige.setText("OK!");
            results.forEach(result -> {
                listModel.addElement(result);
            });

        }



    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        controller.closeDB();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
