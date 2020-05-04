import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;

public class Reserve {

    private JPanel panelMain;
    private JTextField firstName;
    private JTextField lastName;
    private JTextField textField3;
    private JEditorPane editorPane1;
    private JComboBox hotelBox;
    private JFormattedTextField startDate;
    private JFormattedTextField duration;
    private JComboBox roomBox;
    private JButton submit;
    private JRadioButton cancelingRadioButton;
    private JRadioButton reservingRadioButton;


    public Reserve() {

        hotelBox.addItem("Cherry Hotel");
        hotelBox.addItem("Lincoln Hotel");
        hotelBox.addItem("Tree Hotel");

        roomBox.addItem("double");
        roomBox.addItem("king");
        roomBox.addItem("suite");

        java.net.URL helpURL = Reserve.class.getResource(
                "frontpage.html");
        if (helpURL != null) {
            try {
                editorPane1.setPage(helpURL);
            } catch (IOException e) {
                System.err.println("Attempted to read a bad URL: " + helpURL);
            }
        } else {
            System.err.println("Couldn't find file: frontpage.html");
        }


//        NumberFormat nf = NumberFormat.getIntegerInstance(); // Specify specific format here.
////        nf.setGroupingUsed(false);
////        System.out.println(nf.getRoundingMode());
////        NumberFormatter nff = new NumberFormatter(nf);
////        nff.setAllowsInvalid(false);
////        DefaultFormatterFactory factory = new DefaultFormatterFactory(nff);
////
////
////        startDate.setFormatterFactory(factory);

            startDate.setColumns(8);


        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileContent = null;

                if (reservingRadioButton.isSelected()) {
                    fileContent = "RESERVE HOTEL " + hotelBox.getSelectedIndex() + " START "
                            + startDate.getText() + " DURATION " + duration.getText()
                            + "\n" + firstName.getText() + " " + lastName.getText() + " " + roomBox.getSelectedItem();

                    System.out.println(fileContent);



                }
                else {
                    fileContent = "CANCEL HOTEL " + hotelBox.getSelectedIndex() + "\n" + firstName.getText()
                            + " " + lastName.getText();


                }

//                FileWriter fileWriter = null;
//                try {
//                    fileWriter = new FileWriter("samplefile2.txt");
//                    fileWriter.write(fileContent);
//                    fileWriter.close();
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                }
            }
        });
    }

    public static void main(String[] args) {

//        Login
//        LoginFrame login=new LoginFrame();
//        login.setTitle("Login Form");
//        login.setVisible(true);
//        login.setBounds(10,10,370,600);
//        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        login.setResizable(false);



        JFrame frame = new JFrame("Reserve");
        frame.setContentPane(new Reserve().panelMain);
        frame.setSize(2000,1500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
}
