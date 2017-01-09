package GUI;

/**
 * Created by Whoop on 08.01.2017.
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JList;
import java.awt.ScrollPane;
import java.awt.List;
import javax.swing.JScrollPane;

public class Ergebnis {

    private JFrame frame;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ergebnis window = new Ergebnis();
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
    public Ergebnis() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel LbSuche = new JLabel("Gesuchter Begriff:");
        LbSuche.setFont(new Font("Arial", Font.PLAIN, 11));
        LbSuche.setHorizontalAlignment(SwingConstants.LEFT);

        JLabel UeberschriftErgebnis = new JLabel("Ergebnis der Suche");
        UeberschriftErgebnis.setFont(new Font("Arial", Font.PLAIN, 20));

        JFormattedTextField Kontrollanzeige = new JFormattedTextField();
        Kontrollanzeige.setToolTipText("Kontrollanzeige");
        Kontrollanzeige.setHorizontalAlignment(SwingConstants.CENTER);

        JFormattedTextField AusgabeAttribut = new JFormattedTextField();
        AusgabeAttribut.setFont(new Font("Arial", Font.PLAIN, 11));
        AusgabeAttribut.setEditable(false);

        JLabel lbGewaehltesAttribut = new JLabel("Gew\u00E4hltes Attribut:");
        lbGewaehltesAttribut.setFont(new Font("Arial", Font.PLAIN, 11));

        JFormattedTextField AusgabeBegriff = new JFormattedTextField();
        AusgabeBegriff.setFont(new Font("Arial", Font.PLAIN, 11));
        AusgabeBegriff.setEditable(false);
        AusgabeBegriff.setHorizontalAlignment(SwingConstants.LEFT);

        JButton BtNeueSuche = new JButton("Neue Suche");
        BtNeueSuche.setFont(new Font("Arial", Font.PLAIN, 11));

        JScrollPane scrollPane = new JScrollPane();

        JLabel lblErgebnis = new JLabel("Ergebnis:");
        lblErgebnis.setFont(new Font("Arial", Font.PLAIN, 11));

        GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(Kontrollanzeige, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                                        .addComponent(lblErgebnis)
                                                        .addComponent(LbSuche)
                                                        .addComponent(lbGewaehltesAttribut))
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(UeberschriftErgebnis, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(groupLayout.createSequentialGroup()
                                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                                                                        .addComponent(AusgabeAttribut)
                                                                        .addComponent(AusgabeBegriff)
                                                                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                                                                .addGap(52)
                                                                .addComponent(BtNeueSuche)))))
                                .addContainerGap())
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(UeberschriftErgebnis, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                .addGap(28)
                                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                                        .addComponent(lblErgebnis))
                                                .addGap(18)
                                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(LbSuche)
                                                        .addComponent(AusgabeBegriff, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18)
                                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(lbGewaehltesAttribut)
                                                        .addComponent(AusgabeAttribut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(6))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(BtNeueSuche, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(Kontrollanzeige, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        JList lsErgebnis = new JList();
        lsErgebnis.setFont(new Font("Arial", Font.PLAIN, 11));
        scrollPane.setViewportView(lsErgebnis);
        frame.getContentPane().setLayout(groupLayout);
    }
}
