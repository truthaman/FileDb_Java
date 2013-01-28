import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: tmb
 * Date: 20/01/13
 * Time: 7:22 PM
 *
 * NOTES: Using GUI designer in IntelliJ Idea:
 * Create new form (File > New > GUI form), bind to a class. Give JPanel field name some name (i.e. bind to a field in class).
 * In the generated class file insert automatic code (Code > Generate > Form main).
 * Move this code from main method to constructor - delete new JFrame instantiation (instead change the class to extend from JFrame).
 * Change: frame.setContentPane(new MainGui().mainPanel) to:  setContentPane(mainPanel);
 *
 *
 */
public class MainGui extends JFrame {
    private JList list1;
    private JButton button1;
    private JPanel mainPanel;

    private DefaultListModel listModel;

    public MainGui() {
        setlist();
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void setlist()
    {
        listModel = new DefaultListModel();
        listModel.addElement("Jane Doe");
        listModel.addElement("John Smith");
        listModel.addElement("Kathy Green");



        //Create the list and put it in a scroll pane.
        list1.setModel(listModel);
        //list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //list1.setSelectedIndex(0);
        //list1.addListSelectionListener(this);
        //list1.setVisibleRowCount(5);
        //JScrollPane listScrollPane = new JScrollPane(list1);

        //listScrollPane.setPreferredSize(new Dimension(250, 80));
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        mainPanel.setPreferredSize(new Dimension(400, 200));
        mainPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), null));
        button1 = new JButton();
        button1.setText("Button");
        mainPanel.add(button1);
        list1 = new JList();
        mainPanel.add(list1);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}