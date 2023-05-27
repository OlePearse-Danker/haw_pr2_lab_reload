package lab0;

import java.awt.*;

public class Tail extends BoundingBox {

    private Color tailColor1 = new Color(238,238,238);
    private Color tailColor2 = Color.BLACK;
    public Tail(int x, int y, int width, int height) {

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


        Drawing.pen().setColor(tailColor2);
        Drawing.pen().fillArc(x, y, width, height, 0, 90);
        Drawing.pen().setColor(tailColor1);
        Drawing.pen().fillArc(x, (int) (y + 0.1 * height), width, height, 0, 90);


        // drawing the bounding box
        //this.drawBoundingBox();
    }

}


