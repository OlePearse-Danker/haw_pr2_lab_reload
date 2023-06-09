/**
 * Provides a panel on which an object of class "Graphics" can draw.
 *
 * @author Björn Gottfried
 * @version 1.0
 * @runsWith JAVA 1.8
 *
 * In this file, you have to add two lines of code:
 * 		+ instantiate one object of your domain class
 * 		+ call its drawAt-method
 */

package lab0;

import javax.swing.JPanel;

import java.awt.*;

@SuppressWarnings("serial")
public class DrawingArea extends JPanel {

    private Scene scene;

    public DrawingArea() {
        super(); // initalizes the jpanel with deafult settings
        this.scene = new Scene();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Drawing.set(g);

        Grid grid = new Grid(25, 1000, 1000);
        if (this.scene != null) {
            this.scene.draw();
        }
        // grid.draw();
    }

    public Scene getScene() {
        return this.scene;
    }
}