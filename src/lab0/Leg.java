package lab0;

import java.awt.*;

public class Leg extends BoundingBox {

    private Foot Feet;

    private int footWidth;
    private int footHeight;


    public Leg(int x, int y, int width, int height) {

        this.setWidth(width);
        this.setHeight(height);
        this.setCoordinates(new Point(x, y));

        this.footWidth = (int) (width * 1.525);
        this.footHeight = height / 3;
        this.Feet = new Foot ((int) (x - 0.5 * width), (int) (y + 0.85 * height), footWidth, footHeight);

    }

    public void draw() {

        // coordinates for the upper_body
        int x = (int) this.getCoordinates().getX();
        int y = (int) this.getCoordinates().getY();
        int width = this.getWidth();
        int height = this.getHeight();


        Drawing.pen().setColor(Color.BLACK);

        Drawing.pen().fillRect(x, y, width, height);

        Feet.draw();


        // drawing the bounding box
        // this.drawBoundingBox();
    }

}

