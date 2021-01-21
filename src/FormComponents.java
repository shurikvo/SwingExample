import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class FormComponents extends JFrame implements ItemListener {
    public boolean RIGHT_TO_LEFT = false;

    private JFrame frame;
    public JPanel panelData;
    public JComboBox cbxPerson;
    public JLabel lblSurName, lblName, lblPatronymic, lblBirthday;
    public JTextField strSurname, strName, strPatronymic, strBirthday;
    public JButton btnCommit;

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

        int Voff = 100;
        String[] strPersons = {"Alex","Iren","Nasty","Andrew","Ann","Kate"};
        cbxPerson = new JComboBox(strPersons);
        cbxPerson.addItemListener(this);
        pane.add(cbxPerson, BorderLayout.PAGE_START);

        panelData = new JPanel();
        panelData.setPreferredSize(new Dimension(300, 300));
        panelData.setLayout(null);
        pane.add(panelData, BorderLayout.CENTER);

        lblSurName = new JLabel("Surname:", SwingConstants.RIGHT);
        lblSurName.setBounds(10,10+Voff,70,20);
        panelData.add(lblSurName);

        lblName = new JLabel("Name:", SwingConstants.RIGHT);
        lblName.setBounds(10,30+Voff,70,20);
        panelData.add(lblName);

        lblPatronymic = new JLabel("Patronymic:", SwingConstants.RIGHT);
        lblPatronymic.setBounds(10,50+Voff,70,20);
        panelData.add(lblPatronymic);

        lblBirthday = new JLabel("Birthday:", SwingConstants.RIGHT);
        lblBirthday.setBounds(10,70+Voff,70,20);
        panelData.add(lblBirthday);

        strSurname = new JTextField();
        strSurname.setBounds(85,10+Voff,200,20);
        panelData.add(strSurname);

        strName = new JTextField();
        strName.setBounds(85,30+Voff,200,20);
        panelData.add(strName);

        strPatronymic = new JTextField();
        strPatronymic.setBounds(85,50+Voff,200,20);
        panelData.add(strPatronymic);

        strBirthday = new JTextField();
        strBirthday.setBounds(85,70+Voff,100,20);
        panelData.add(strBirthday);

        btnCommit = new JButton("Commit [Exit]");
        pane.add(btnCommit, BorderLayout.PAGE_END);
    }

    public void createAndShowGUI() {
        frame = new JFrame("FormMain");
        frame.setTitle("Первая форма Swift");
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
        String sItem = (String)cbxPerson.getSelectedItem();

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
}
