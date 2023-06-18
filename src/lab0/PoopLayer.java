package lab0;

import java.awt.*;

public class PoopLayer extends BoundingBox {

    private final Poop context;

    public PoopLayer(Point coords, Dimension size, Poop iBelongTo) {
        int x = coords.x;
        int y = coords.y;
        this.setCoordinates(new Point(x, y));
        int w = (int) size.getWidth();
        int h = (int) size.getHeight();
        this.setWidth(w);
        this.setHeight(h);
        this.context = iBelongTo;
    }

    public void draw() {

        // coordinates for the upper_body
        int x = (int) this.getCoordinates().getX();
        int y = (int) this.getCoordinates().getY();
        int width = this.getWidth();
        int height = this.getHeight();

        System.out.println("Draw poop layer at: " + x + "/" + y + " with: "+ width + "x" + height);


        Drawing.pen().setColor(this.context.getColor());

        Drawing.pen().fillOval(x, y, width, height);

        // drawing the bounding box
        // this.drawBoundingBox();
    }
}
