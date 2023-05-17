package lab0;

import java.awt.*;

public class Upperbody extends BoundingBox{

    public Upperbody(int x, int y, int width, int height) {

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


        // drawing the upper body
        Drawing.pen().setColor(Color.ORANGE);

        Drawing.pen().fillOval(x, y, width, height);

        // drawing the bounding box
        this.drawBoundingBox();
    }
}
