package lab0;

import java.awt.*;

public class Legs extends BoundingBox {

    public Legs(int x, int y, int width, int height) {

        this.setWidth(width);
        this.setHeight(height);
        this.setCoordinates(new Point(x, y));
    }

    public void draw() {

        // coordinates for the upper_body
        int x = (int) this.getCoordinates().getX();
        int y = (int) this.getCoordinates().getY();
        int width = this.getWidth();
        int height = this.getHeight();


        Drawing.pen().setColor(Color.BLACK);

        Drawing.pen().fillRect(x, y, width, height);

        // eigene Klase für left leg und right leg machen


        // drawing the bounding box
        this.drawBoundingBox();
    }

}


