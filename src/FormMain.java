import javax.swing.*;
import java.awt.*;

public class FormMain {
    public static boolean RIGHT_TO_LEFT = false;

    public static void addComponentsToPane(Container pane) {
        if (!(pane.getLayout() instanceof BorderLayout)) {
            pane.add(new JLabel("Container doesn't use BorderLayout!"));
            return;
        }

        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(
                    java.awt.ComponentOrientation.RIGHT_TO_LEFT);
        }
        // BorderLayout: PAGE_START, LINE_START, CENTER, LINE_END, PAGE_END

        JPanel panelData = new JPanel();
        JComboBox cbxPerson = new JComboBox();
        JButton btnCommit = new JButton("Commit [Exit]");

        pane.add(cbxPerson, BorderLayout.PAGE_START);

        panelData.setPreferredSize(new Dimension(300, 300));
        pane.add(panelData, BorderLayout.CENTER);

        pane.add(btnCommit, BorderLayout.PAGE_END);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("FormMain");
        frame.setTitle("Первая форма Swift");

        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addComponentsToPane(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        //UIManager.put("swing.boldMetal", Boolean.FALSE);

        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });










    }

    private JPanel pnlMain;
}
