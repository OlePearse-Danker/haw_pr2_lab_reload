

package lab0;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        // Add new button to the panel
        JButton add_button = new JButton("Add new Cat");
        add_button.addActionListener(e -> {
            System.out.println("--------");
            System.out.println("Add new cat button pressed.");
            Scene scene = drawing.getScene();
            scene.addCat();
            scene.draw();
            System.out.println("--------");
            drawing.revalidate(); // revalidates the panel
            drawing.repaint(); // calls paintComponent, otherwise the cats would not be drawn
        });
        gUIPanel.add(add_button);

        JButton remove_button = new JButton("Remove all");
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

        JSlider bgColorSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 238);
        bgColorSlider.setMajorTickSpacing(50);
        bgColorSlider.setMinorTickSpacing(10);
        bgColorSlider.setPaintTicks(true);
        bgColorSlider.setPaintLabels(true);
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

        JButton closeBtn = new JButton("Close");
        // Store lambda expression in variable
        ActionListener closeBtnListener = e -> { this.exit(); };
        closeBtn.addActionListener(closeBtnListener);
        gUIPanel.add(closeBtn);

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
        // TODO Auto-generated method stub

        // Say hello to the console if b is pressed
        if (e.getActionCommand().equals("stupid")) {
            System.out.println("This is stupid.");
        }
    }

    public static void main(String[] args) {
        new DrawingTool("I am a Cat!");
    }
}
