package GUI;

/**
 * Created by chris on 04/12/16.
 */
import Backend.Semesterplan;
import Backend.Stundenplan;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUI {

    private JFrame frame;
    public JTable Tabelle;
    private JTextField txtAnfangsdatum;
    private JTextField txtEnddatum;
    static Semesterplan sem;
    static Stundenplan stundenplan;
    static Object[][] data;

    static DefaultTableModel tm;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainGUI window = new MainGUI();
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
    public MainGUI() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 909, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 139, 31);
        frame.getContentPane().add(menuBar);

        JMenu mnNewMenu = new JMenu("Neu                                  ");
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem_3 = new JMenuItem("Einheit");
        mntmNewMenuItem_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0)
            {
                AddEinheit.main(null);
            }
        });
        mntmNewMenuItem_3.setToolTipText("Hier klicken um eine neue Einheit zu erstellen");
        mnNewMenu.add(mntmNewMenuItem_3);

        JMenuItem mntmNewMenuItem_4 = new JMenuItem("Termin");
        mntmNewMenuItem_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0)
            {
                AddTermin.main(null);
            }
        });
        mntmNewMenuItem_4.setToolTipText("Hier klicken um einen neuen Termin zu erstellen");
        mnNewMenu.add(mntmNewMenuItem_4);

        JMenuBar menuBar_1 = new JMenuBar();
        menuBar_1.setBounds(139, 0, 139, 31);
        frame.getContentPane().add(menuBar_1);

        JMenu mnAnsicht = new JMenu("Ansicht                                 ");
        menuBar_1.add(mnAnsicht);

        JMenuItem mntmNewMenuItem = new JMenuItem("Ansicht 1");
        mntmNewMenuItem.setToolTipText("Hier klicken um die Ansicht auf 'Ansicht 1' zu ändern");
        mnAnsicht.add(mntmNewMenuItem);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Ansicht 2");
        mntmNewMenuItem_1.setToolTipText("Hier klicken um die Ansicht auf 'Ansicht 2' zu ändern");
        mnAnsicht.add(mntmNewMenuItem_1);

        JMenuItem mntmNewMenuItem_2 = new JMenuItem("Ansicht 3");
        mntmNewMenuItem_2.setToolTipText("Hier klicken um die Ansicht auf 'Ansicht 3' zu ändern");
        mnAnsicht.add(mntmNewMenuItem_2);

        JMenuBar menuBar_2 = new JMenuBar();
        menuBar_2.setBounds(748, 0, 139, 31);
        frame.getContentPane().add(menuBar_2);

        JMenu mnNewMenu_1 = new JMenu("Hilfe                                              ");
        menuBar_2.add(mnNewMenu_1);

        JMenuItem mntmNewMenuItem_5 = new JMenuItem("Hilfe                              ");
        mntmNewMenuItem_5.setToolTipText("Hier klicken um Technische Hilfe zu erhalten");
        mnNewMenu_1.add(mntmNewMenuItem_5);

        JMenuBar menuBar_3 = new JMenuBar();
        menuBar_3.setBounds(278, 0, 139, 31);
        frame.getContentPane().add(menuBar_3);

        JMenu mnImport = new JMenu("Import                                         ");
        menuBar_3.add(mnImport);

        JMenuItem mntmNewMenuItem_6 = new JMenuItem("Stundenplan");
        mntmNewMenuItem_6.setToolTipText("Hier klicken um einen Vorhandenen Stundenplan zu importieren");
        mnImport.add(mntmNewMenuItem_6);

        JMenuItem mntmSonstiges = new JMenuItem("Sonstiges");
        mnImport.add(mntmSonstiges);


        String[] columnNames = {"Modulname",
                "Veranstaltungsart",
                "Uhrzeit",
                "Raum/Ort",
                "Lehrender",
                "Pflicht?",
                "Datum",
                "Wiederholrhythmus",
                "Priorität"
        };




        JLabel label = new JLabel("-");
        label.setBounds(427, 91, 13, 20);
        frame.getContentPane().add(label);

        txtAnfangsdatum = new JTextField();
        txtAnfangsdatum.setText("Anfangsdatum");
        txtAnfangsdatum.setBounds(271, 88, 146, 26);
        frame.getContentPane().add(txtAnfangsdatum);
        txtAnfangsdatum.setColumns(10);
        txtAnfangsdatum.setToolTipText("Hier bitte das anzuzeigende Startdatum eingeben");

        txtEnddatum = new JTextField();
        txtEnddatum.setText("Enddatum");
        txtEnddatum.setBounds(443, 88, 146, 26);
        frame.getContentPane().add(txtEnddatum);
        txtEnddatum.setColumns(10);
        txtEnddatum.setToolTipText("Hier bitte das anzuzeigende Enddatum eingeben");

        JLabel lblAnzeigezeitraum = new JLabel("Anzeigezeitraum:");
        lblAnzeigezeitraum.setBounds(139, 91, 130, 20);
        frame.getContentPane().add(lblAnzeigezeitraum);

        JButton btnAktualisieren = new JButton("Aktualisieren");
        btnAktualisieren.setBounds(633, 87, 130, 29);
        frame.getContentPane().add(btnAktualisieren);
        btnAktualisieren.setToolTipText("Hier klicken um die Ansicht auf Basis der Daten zu Aktualisieren");

        JPanel panel = new JPanel();
        panel.setBounds(15, 134, 857, 444);
        frame.getContentPane().add(panel);
        panel.setLayout(null);


        Tabelle = new JTable(data, columnNames);
        Tabelle.setToolTipText("Hier wird ihnen die Ansicht ihrer Termine und Einheiten Wiedergegeben");
        Tabelle.setModel(new DefaultTableModel(
                data,
                columnNames
        ));

        Tabelle.setBounds(1, 36, 784, 400);
        frame.getContentPane().add(Tabelle);
        Tabelle.setAutoCreateRowSorter(true);
        Tabelle.setFillsViewportHeight(true);
        JScrollPane jps = new JScrollPane(Tabelle);
        jps.setBounds(0, 0, 857, 442);
        panel.add(jps);
        tm = (DefaultTableModel) Tabelle.getModel();
    }


    private static void addPopup(Component component, final JPopupMenu popup) {
        component.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showMenu(e);
                }
            }
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showMenu(e);
                }
            }
            private void showMenu(MouseEvent e) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        });
    }

}
