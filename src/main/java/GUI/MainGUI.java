package GUI;

import Backend.Semesterplan;
import Backend.Stundenplan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class MainGUI {

    private JFrame frame;
    public JTable Tabelle;
    private JTextField txtAnfangsdatum;
    private JTextField txtEnddatum;
    static Semesterplan sem;
    static Stundenplan stundenplan;
    static Object[][] data;
    static DefaultTableModel tm;
    static Object[] daten = new Object[200];


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


    public MainGUI() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize()
    {

        frame = new JFrame();
        frame.setBounds(100, 100, 909, 650);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
        btnAktualisieren.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if((""+Tabelle.getValueAt(Tabelle.getSelectedRow(),1)+"").equals(""))
                {
                    String name = ""+Tabelle.getValueAt(Tabelle.getSelectedRow(),0)+"";
                    String time = ""+Tabelle.getValueAt(Tabelle.getSelectedRow(),2)+"";
                    String timestart = ""+time.charAt(0)+time.charAt(1)+time.charAt(2)+time.charAt(3)+time.charAt(4);
                    String timeend = ""+time.charAt(6)+time.charAt(7)+time.charAt(8)+time.charAt(9)+time.charAt(10);
                    String location = ""+Tabelle.getValueAt(Tabelle.getSelectedRow(),3)+"";
                    LocalDate date = (LocalDate) Tabelle.getValueAt(Tabelle.getSelectedRow(),6);
                    String intervall = ""+Tabelle.getValueAt(Tabelle.getSelectedRow(),7)+"";
                    String prio = ""+Tabelle.getValueAt(Tabelle.getSelectedRow(),8)+"";

                    AddTermin.main(null);
                    AddTermin.ChangeTermin(name,LocalTime.parse(timestart),LocalTime.parse(timeend),location,date,intervall,prio);
                }
                else
                {
                    String name = ""+Tabelle.getValueAt(Tabelle.getSelectedRow(),0)+"";
                    String type = ""+Tabelle.getValueAt(Tabelle.getSelectedRow(),1)+"";
                    LocalTime start = (LocalTime) Tabelle.getValueAt(Tabelle.getSelectedRow(),2);
                    LocalTime end = (LocalTime) Tabelle.getValueAt(Tabelle.getSelectedRow(),3);
                    String location = ""+Tabelle.getValueAt(Tabelle.getSelectedRow(),4)+"";
                    String teacher = ""+Tabelle.getValueAt(Tabelle.getSelectedRow(),5)+"";
                    LocalDate date = (LocalDate) Tabelle.getValueAt(Tabelle.getSelectedRow(),6);
                    String intervall = ""+Tabelle.getValueAt(Tabelle.getSelectedRow(),7)+"";
                    boolean pflicht;
                    if((int) Tabelle.getValueAt(Tabelle.getSelectedRow(),8)==1)
                    {
                        pflicht = false;
                    }
                    else{pflicht = true;}

                    AddEinheit.main(null);
                    System.out.println("nachdem fenster(vor dem eintragen)");


                    AddEinheit.ChangeEinheit(name,type,start,end,location,teacher,date,intervall,pflicht);
                    System.out.println("nachdem Eintragen");


                }}
        });
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

    public static void aktualisieren()
    {
        try {
            for( int j = tm.getRowCount() - 1; j >= 0; j-- )
            {
                tm.removeRow(j);
            }

            for(int i=0;i<=daten.length;i++)
            {
                LocalDate today = LocalDate.now();
                TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
                int weekNumber = today.get(woy);
                //  System.out.println(weekNumber);
                Object[] etwas = (Object[]) daten[i];
                LocalDate datum = (LocalDate) etwas[6];
                TemporalField week = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
                int holweek = datum.get(week);
                // System.out.println(holweek);
                //  System.out.println(datum);
                if(weekNumber==holweek)
                {

                    tm.addRow((Object[]) daten[i]);
                }
            }}
        catch (NullPointerException igno) {
            System.out.print("ignorieren");}
    }

}
