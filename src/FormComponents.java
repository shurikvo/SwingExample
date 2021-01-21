import javax.swing.*;
import java.awt.*;

public class FormComponents {
    public boolean RIGHT_TO_LEFT = false;

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

        String[] strPersons = {"Alex","Iren","Nasty","Andrew","Ann","Kate"};
        cbxPerson = new JComboBox(strPersons);
        pane.add(cbxPerson, BorderLayout.PAGE_START);

        panelData = new JPanel();
        panelData.setPreferredSize(new Dimension(300, 300));
        panelData.setLayout(null);
        pane.add(panelData, BorderLayout.CENTER);

        lblSurName = new JLabel("Surname:", SwingConstants.RIGHT);
        lblSurName.setBounds(10,10,70,20);
        panelData.add(lblSurName);

        lblName = new JLabel("Name:", SwingConstants.RIGHT);
        lblName.setBounds(10,30,70,20);
        panelData.add(lblName);

        lblPatronymic = new JLabel("Patronymic:", SwingConstants.RIGHT);
        lblPatronymic.setBounds(10,50,70,20);
        panelData.add(lblPatronymic);

        lblBirthday = new JLabel("Birthday:", SwingConstants.RIGHT);
        lblBirthday.setBounds(10,70,70,20);
        panelData.add(lblBirthday);

        strSurname = new JTextField();
        strSurname.setBounds(85,10,200,20);
        panelData.add(strSurname);

        strName = new JTextField();
        strName.setBounds(85,30,200,20);
        panelData.add(strName);

        strPatronymic = new JTextField();
        strPatronymic.setBounds(85,50,200,20);
        panelData.add(strPatronymic);

        strBirthday = new JTextField();
        strBirthday.setBounds(85,70,100,20);
        panelData.add(strBirthday);

        btnCommit = new JButton("Commit [Exit]");
        pane.add(btnCommit, BorderLayout.PAGE_END);
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("FormMain");
        frame.setTitle("Первая форма Swift");

        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addComponentsToPane(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
}
