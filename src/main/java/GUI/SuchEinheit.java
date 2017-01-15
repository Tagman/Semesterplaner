package GUI;

/**
 * Created by Whoop on 15.01.2017.
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JList;

public class SuchEinheit {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SuchEinheit window = new SuchEinheit();
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
    public SuchEinheit() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 470, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblSuchenEinerEinheit = new JLabel("Suchen einer Einheit");
        lblSuchenEinerEinheit.setHorizontalAlignment(SwingConstants.CENTER);
        lblSuchenEinerEinheit.setFont(new Font("Arial", Font.PLAIN, 20));

        JFormattedTextField ftfSuchbegriff = new JFormattedTextField();
        ftfSuchbegriff.setToolTipText("Wonach soll gesucht werden?");
        ftfSuchbegriff.setFont(new Font("Arial", Font.PLAIN, 11));

        JLabel lbSuchbegriff = new JLabel("Suchbegriff:");
        lbSuchbegriff.setFont(new Font("Arial", Font.PLAIN, 11));

        JLabel lbAttribut = new JLabel("Attribut:");
        lbAttribut.setFont(new Font("Arial", Font.PLAIN, 11));

        JComboBox boxAttribut = new JComboBox();
        boxAttribut.setModel(new DefaultComboBoxModel(new String[] {"Name der Veranstaltung", "Datum", "Dozent", "Priorit\u00E4t", "Raum", "Uhrzeit"}));
        boxAttribut.setToolTipText("Bitte Attribut ausw\u00E4hlen z.B. Ort, Dozent etc.");
        boxAttribut.setFont(new Font("Arial", Font.PLAIN, 11));

        JLabel lblErgebnis = new JLabel("Ergebnis:");

        lblErgebnis.setFont(new Font("Arial", Font.PLAIN, 11));

        JButton btnSuchen = new JButton("Suchen\r\n");
        btnSuchen.setToolTipText("Klicken um Suche zu starten");
        btnSuchen.setFont(new Font("Arial", Font.PLAIN, 11));

        JFormattedTextField KontrollAnzeige = new JFormattedTextField();
        KontrollAnzeige.setEditable(false);
        KontrollAnzeige.setToolTipText("Kontrollanzeige");

        JList lsErgebnis = new JList();
        lsErgebnis.setFont(new Font("Arial", Font.PLAIN, 11));



        GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.TRAILING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                .addGroup(groupLayout.createSequentialGroup()
                                                        .addComponent(KontrollAnzeige, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                                                        .addContainerGap())
                                                .addGroup(groupLayout.createSequentialGroup()
                                                        .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                                                .addComponent(lblErgebnis)
                                                                .addComponent(lbAttribut, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(lbSuchbegriff, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(ComponentPlacement.RELATED)
                                                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                                .addComponent(lsErgebnis, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(lblSuchenEinerEinheit, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
                                                                        .addComponent(ftfSuchbegriff, Alignment.LEADING)
                                                                        .addComponent(boxAttribut, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                        .addContainerGap(109, Short.MAX_VALUE)))
                                        .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
                                                .addComponent(btnSuchen, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.TRAILING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblSuchenEinerEinheit, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                .addGap(44)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lbSuchbegriff)
                                        .addComponent(ftfSuchbegriff, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lbAttribut)
                                        .addComponent(boxAttribut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lsErgebnis, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblErgebnis))
                                .addGap(12)
                                .addComponent(btnSuchen, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(KontrollAnzeige, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        frame.getContentPane().setLayout(groupLayout);
    }
}

