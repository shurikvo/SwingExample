import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FormComponents extends JFrame implements ItemListener {
    public boolean RIGHT_TO_LEFT = false;

    private JFrame frame;
    public JPanel pnlData, pnlButtons, pnlBottom, pnlInfo;
    public JComboBox cbxPerson;
    public JLabel lblSurName, lblName, lblPatronymic, lblBirthday, lblInfo;
    public JTextField strSurname, strName, strPatronymic, strBirthday, strInfo;
    public JButton btnCommit, btnCancel;

    private void addComponentsToPane(Container pane) {
        if (!(pane.getLayout() instanceof BorderLayout)) {
            pane.add(new JLabel("Container doesn't use BorderLayout!"));
            return;
        }

        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(
                    java.awt.ComponentOrientation.RIGHT_TO_LEFT);
        }
        // BorderLayout: PAGE_START, LINE_START, CENTER, LINE_END, PAGE_END

        int offV = 100;
        String[] strPersons = {"Alex","Iren","Nasty","Andrew","Ann","Kate"};
        cbxPerson = new JComboBox(strPersons);
        //cbxPerson.setBounds(0,0,200,20);
        cbxPerson.addItemListener(this);
        pane.add(cbxPerson, BorderLayout.PAGE_START);

        pnlData = new JPanel();
        pnlData.setPreferredSize(new Dimension(700, 300));
        pnlData.setLayout(null);
        pane.add(pnlData, BorderLayout.CENTER);

        lblSurName = new JLabel("Surname:", SwingConstants.RIGHT);
        lblSurName.setBounds(10,10+ offV,70,20);
        pnlData.add(lblSurName);

        lblName = new JLabel("Name:", SwingConstants.RIGHT);
        lblName.setBounds(10,30+ offV,70,20);
        pnlData.add(lblName);

        lblPatronymic = new JLabel("Patronymic:", SwingConstants.RIGHT);
        lblPatronymic.setBounds(10,50+ offV,70,20);
        pnlData.add(lblPatronymic);

        lblBirthday = new JLabel("Birthday:", SwingConstants.RIGHT);
        lblBirthday.setBounds(10,70+ offV,70,20);
        pnlData.add(lblBirthday);

        strSurname = new JTextField();
        strSurname.setBounds(85,10+ offV,200,20);
        pnlData.add(strSurname);

        strName = new JTextField();
        strName.setBounds(85,30+ offV,200,20);
        pnlData.add(strName);

        strPatronymic = new JTextField();
        strPatronymic.setBounds(85,50+ offV,200,20);
        pnlData.add(strPatronymic);

        strBirthday = new JTextField();
        strBirthday.setBounds(85,70+ offV,100,20);
        pnlData.add(strBirthday);
        //------------------------------------------------------------------------------
        pnlBottom = new JPanel();
        BorderLayout blt = new BorderLayout();
        pnlBottom.setLayout(blt);
        pane.add(pnlBottom, BorderLayout.PAGE_END);

        //strInfo = new JTextField("");
        //pnlBottom.add(strInfo, BorderLayout.CENTER);
        lblInfo = new JLabel("");
        Border blackline = BorderFactory.createLineBorder(Color.black);
        lblInfo.setBorder(blackline);
        pnlBottom.add(lblInfo, BorderLayout.CENTER);

        pnlButtons = new JPanel();
        pnlButtons.setLayout(null);
        pnlButtons.setPreferredSize(new Dimension(210, 20));
        pnlBottom.add(pnlButtons, BorderLayout.LINE_END);

        int offBot = 2, wBotBut = 100, hBotBut = 20;

        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(offBot,0,wBotBut,hBotBut);
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doCancel();
            }
        } );
        pnlButtons.add(btnCancel);

        btnCommit = new JButton("Commit");
        btnCommit.setBounds(offBot+wBotBut+3,0,wBotBut,hBotBut);
        btnCommit.addItemListener(this);
        btnCommit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doCommit();
            }
        } );
        pnlButtons.add(btnCommit);

        showPerson();
    }

    public void createAndShowGUI() {
        frame = new JFrame("FormMain");
        frame.setTitle("First Swift form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(frame.getContentPane());
        frame.pack();
        centerFrame();
        frame.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == cbxPerson) {
            cbxPerson_SelectionChanhed(e);
        }
    }

    private void cbxPerson_SelectionChanhed(ItemEvent e){
        showPerson();
    }

    private void showPerson(){
        String sItem = (String)cbxPerson.getSelectedItem();

        //strInfo.setText("Selected: "+sItem);
        lblInfo.setText("Selected: "+sItem);

        strSurname.setText("");
        strName.setText("");
        strPatronymic.setText("");
        strBirthday.setText("");

        switch(sItem){ // "Alex","Iren","Nasty","Andrew","Ann","Kate"
            case "Alex":
                strSurname.setText("Voroshilov");
                strName.setText("Aleksandr");
                strPatronymic.setText("Vladimirovich");
                strBirthday.setText("25.06.1959");
                break;
            case "Iren":
                strSurname.setText("Voroshilova (Marasina)");
                strName.setText("Irina");
                strPatronymic.setText("Vasilievna");
                strBirthday.setText("13.08.1960");
                break;
            case "Nasty":
                strSurname.setText("Kuznetsova (Voroshilova)");
                strName.setText("Anastasia");
                strPatronymic.setText("Aleksandrovna");
                strBirthday.setText("21.11.1984");
                break;
            case "Andrew":
                strSurname.setText("Voroshilov");
                strName.setText("Andrey");
                strPatronymic.setText("Aleksandrovich");
                strBirthday.setText("20.07.1988");
                break;
            case "Ann":
                strSurname.setText("Kuznetsova");
                strName.setText("Anna");
                strPatronymic.setText("Alekseevna");
                strBirthday.setText("18.11.2013");
                break;
            case "Kate":
                strSurname.setText("Kuznetsova");
                strName.setText("Ekanerina");
                strPatronymic.setText("Alekseevna");
                strBirthday.setText("09.11.2016");
                break;
        }
    }

    private void centerFrame() {

        Dimension windowSize = frame.getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();

        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;
        frame.setLocation(dx, dy);
    }

    private void doCommit(){
        //strInfo.setText("Done: Commit");
        lblInfo.setText("Done: Commit");
    }

    private void doCancel(){
        //strInfo.setText("Done: Cancel");
        lblInfo.setText("Done: Cancel");
    }
}
