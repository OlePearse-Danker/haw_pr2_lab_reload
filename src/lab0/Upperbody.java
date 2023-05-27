package lab0;

import java.awt.*;

public class Upperbody extends BoundingBox{

    private Color primaryColor;

    private Tail tail;

    public Upperbody(int x, int y, int width, int height) {
        this.setWidth(width);
        this.setHeight(height);
        this.setCoordinates(new Point(x, y));

        this.primaryColor = Color.ORANGE;
        this.tail = new Tail((int) (x + 0.5 * width), (int) (y + 0.45 * height), width, height);

    }

    public void setPrimaryColor(Color color) {
        this.primaryColor = color;
    }

    public Color getPrimaryColor() {
        return this.primaryColor;
    }

    public void draw() {

        // coordinates for the upper_body
        int x = (int) this.getCoordinates().getX();
        int y = (int) this.getCoordinates().getY();
        int width = this.getWidth();
        int height = this.getHeight();


        // drawing the upper body
        Drawing.pen().setColor(this.primaryColor);

        Drawing.pen().fillOval(x, y, width, height);

        tail.draw();

        // drawing the bounding box
        this.drawBoundingBox();
    }
}
