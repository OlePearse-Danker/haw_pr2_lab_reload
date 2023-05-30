

package lab0;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <h1>DrawingTool</h1>
 */
@SuppressWarnings("serial")
public class DrawingTool extends JFrame implements ActionListener {
    private DrawingArea drawing;

    public DrawingTool(String title) {
        super(title);

        // New SplitPane
        JSplitPane splitPane = new JSplitPane();
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPane.setDividerLocation(900);

        //constructDrawingArea();
        this.drawing = new DrawingArea();

        // Add new panel to the frame
        JPanel gUIPanel = new JPanel();
        gUIPanel.setBounds(0, 500, 300, 60);
        gUIPanel.setBackground(Color.BLACK);

        JLabel menuLabel = new JLabel("Menu");
        menuLabel.setForeground(Color.WHITE);
        gUIPanel.add(menuLabel);

        //adding textfield/textarea for user to enter the number of the cats

        JTextField catNumText = new JTextField("Enter the number of cats here");
        catNumText.setEnabled(false);
        gUIPanel.add(catNumText);

        JTextField catNum = new JTextField("1");
        gUIPanel.add(catNum);
        //int a = Integer.getInteger(catNum.getText()); // get Integer from text field


        // Add new button to the panel
        JButton add_button = new JButton("Add new Cat");
        add_button.addActionListener(e -> {
            System.out.println("--------");
            System.out.println("Add new cat button pressed.");
            Scene scene = drawing.getScene();

            try {
                scene.addCats(Integer.parseInt(catNum.getText()));
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid number");
            } finally { // nach dem try catch block wird finally immer ausgeführt
                scene.draw();
            }

            System.out.println("--------");
            drawing.revalidate(); // revalidates the panel
            drawing.repaint(); // calls paintComponent, otherwise the cats would not be drawn
        });
        gUIPanel.add(add_button);

        /**
         * <h2>Remove All Btn</h2>
         *
         * <p>
         *     This button removes all cats when pressed.
         * </p>
         *
         * @see {@link PrimaryButton}
         */
        PrimaryButton remove_button = new PrimaryButton("Remove all");
        remove_button.addActionListener(e -> {
            System.out.println("--------");
            System.out.println("Remove all button pressed.");
            Scene scene = drawing.getScene();
            scene.removeAllCats();
            System.out.println("--------");
            drawing.revalidate(); // revalidates the panel
            drawing.repaint(); // calls paintComponent, otherwise the cats would not be drawn
        });
        gUIPanel.add(remove_button);

        ColorSlider bgColorSlider = new ColorSlider();
        bgColorSlider.setCurrentValue(drawing.getScene().getBackgroundColor().getRed());

        bgColorSlider.addChangeListener(e -> {
            System.out.println("--------");
            System.out.println("Background color slider changed.");
            Scene scene = drawing.getScene();
            Color bgColor = new Color(bgColorSlider.getValue(), bgColorSlider.getValue(), bgColorSlider.getValue());
            scene.setBackgroundColor(bgColor);

            // Get all cats
            for (Cat cat : scene.getAllCats()) {
                cat.getUpperbody().getTail().setBgColor(bgColor);
            }
            scene.draw();
            System.out.println("--------");
            drawing.revalidate(); // revalidates the panel
            drawing.repaint(); // calls paintComponent, otherwise the cats would not be drawn
        });
        gUIPanel.add(bgColorSlider);

        /**
         * Add new button to the panel
         *
         * This button will close the program
         */

        JButton closeBtn = new JButton("Close"); // Create a new JButton with the label "Close"
        ActionListener closeBtnListener = e -> {    // Create a new ActionListener using a lambda expression and store it in closeBtnListener
            this.exit();                            // Call the exit() method of the current object when the button is clicked
        };

        closeBtn.addActionListener(closeBtnListener);   // Add the ActionListener to the JButton
        gUIPanel.add(closeBtn);                         // Add the JButton to a panel named gUIPanel

        /**
         * Add new button to the panel
         *
         * This button will print "This is stupid." to the console
         */

        // Button via ActionListener
        JButton stupidBtn = new JButton("Stupid");
        stupidBtn.addActionListener(this);
        stupidBtn.setActionCommand("stupid");
        gUIPanel.add(stupidBtn);




        // Add panels to the split pane
        splitPane.setTopComponent(drawing);
        splitPane.setBottomComponent(gUIPanel);

        // Add SplitPane to the frame
        this.add(splitPane);

        Dimension screenSize = getToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    private void constructDrawingArea() {
        drawing = new DrawingArea();
        add(drawing);
    }

    public void exit() {
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println(e.getActionCommand());
        // Say hello to the console if b is pressed
        if (e.getActionCommand().equals("stupid")) {
            System.out.println("This is a button.");
        }

    }

    public static void main(String[] args) {
        new DrawingTool("I am a Cat!");
    }
}
