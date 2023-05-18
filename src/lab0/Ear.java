package lab0;

import java.awt.*;

public class Ear extends BoundingBox {
    public Ear(int x, int y, int width, int height) {

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

        Drawing.pen().fillOval(x, y, width, height);


        // drawing the bounding box
        //this.drawBoundingBox();
    }

}


