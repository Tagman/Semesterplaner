package GUI;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
        import java.awt.GridBagConstraints;
        import java.awt.Insets;
import javax.swing.GroupLayout.Alignment;
        import javax.swing.LayoutStyle.ComponentPlacement;
        import java.awt.event.ActionListener;
        import java.awt.event.ActionEvent;
import java.awt.Font;

public class Such {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Such window = new Such();
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
    public Such() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel UeberschriftSuche = new JLabel("Suchen eines Termins");
        UeberschriftSuche.setHorizontalAlignment(SwingConstants.CENTER);
        UeberschriftSuche.setFont(new Font("Arial", Font.PLAIN, 20));

        JButton btnSuchen = new JButton("Suche ausf\u00FChren");
        btnSuchen.setFont(new Font("Arial", Font.PLAIN, 11));
        btnSuchen.setToolTipText("Klicken um Suche zu starten");
        btnSuchen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });

        JLabel lblSuchbegriff = new JLabel("Suchbegriff:");
        lblSuchbegriff.setFont(new Font("Arial", Font.PLAIN, 11));

        JFormattedTextField KontrollAnzeige = new JFormattedTextField();
        KontrollAnzeige.setToolTipText("Kontrollanzeige");

        JFormattedTextField Suchbegriff = new JFormattedTextField();
        Suchbegriff.setFont(new Font("Arial", Font.PLAIN, 11));
        Suchbegriff.setToolTipText("Wonach soll gesucht werden?");

        JComboBox AuswahlAttribut = new JComboBox();
        AuswahlAttribut.setFont(new Font("Arial", Font.PLAIN, 11));
        AuswahlAttribut.setModel(new DefaultComboBoxModel(new String[] {"Name der Veranstaltung", "Datum", "Dozent", "Priorit\u00E4t", "Raum", "Uhrzeit", "", "", ""}));
        AuswahlAttribut.setToolTipText("Bitte Attribut ausw\u00E4hlen z.B. Ort, Dozent etc.");

        JLabel lblAttribut = new JLabel("Attribut:");
        lblAttribut.setFont(new Font("Arial", Font.PLAIN, 11));
        GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(KontrollAnzeige, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(41)
                                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                                        .addComponent(lblAttribut)
                                                        .addComponent(lblSuchbegriff))
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
                                                        .addComponent(Suchbegriff, Alignment.LEADING)
                                                        .addComponent(AuswahlAttribut, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(UeberschriftSuche, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addComponent(btnSuchen, Alignment.TRAILING))
                                .addContainerGap())
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(UeberschriftSuche)
                                .addGap(48)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(Suchbegriff, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblSuchbegriff))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(AuswahlAttribut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblAttribut))
                                .addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addComponent(btnSuchen, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(KontrollAnzeige, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        frame.getContentPane().setLayout(groupLayout);
    }
}
