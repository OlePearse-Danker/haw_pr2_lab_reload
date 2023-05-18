package lab0;

import java.awt.*;

public class Head extends BoundingBox{


    private Ear leftEar;

    private int earWidth;
    private int earHeight;

    private Ear rightEar;

    public Head(int x, int y, int width, int height) {

        this.setWidth(width);
        this.setHeight(height);
        this.setCoordinates(new Point(x, y));


        this.earWidth = width / 4;
        this.earHeight = height / 2;

        this.leftEar = new Ear(x, y, earWidth, earHeight);
        this.rightEar = new Ear(x + width - earWidth, y, earWidth, earHeight);

    }

    public void draw() {

        // coordinates for the upper_body
        int x = (int) this.getCoordinates().getX();
        int y = (int) this.getCoordinates().getY();
        int width = this.getWidth();
        int height = this.getHeight();


        Drawing.pen().setColor(Color.BLACK);

        Drawing.pen().fillOval(x, y, width, height);

        leftEar.draw();
        rightEar.draw();

        // drawing the bounding box
        this.drawBoundingBox();
    }

}


