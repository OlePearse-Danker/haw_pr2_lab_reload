

package lab0;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class DrawingTool extends JFrame {
    private DrawingArea drawing;

    public DrawingTool(String title) {
        super(title);

        // New SplitPane
        JSplitPane splitPane = new JSplitPane();
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPane.setDividerLocation(700);

        //constructDrawingArea();
        drawing = new DrawingArea();

        // Add new panel to the frame
        JPanel gUIPanel = new JPanel();
        gUIPanel.setBounds(0, 500, 300, 60);
        gUIPanel.setBackground(Color.BLACK);

        // Add new button to the panel
        JButton button = new JButton("Add Cat");
        gUIPanel.add(button);

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

    public static void main(String[] args) {
        new DrawingTool("I am a Cat!");
    }
}
