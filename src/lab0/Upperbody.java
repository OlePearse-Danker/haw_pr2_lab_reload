package lab0;

import java.awt.*;

public class Upperbody extends BoundingBox {

    private Color primaryColor;

    private Tail tail;

    private Cat cat;

    public Upperbody(int x, int y, int width, int height, int tailSpacingPlacerholder, Cat iBelongTo) {
        this.cat = iBelongTo;
        this.setWidth(width);
        this.setHeight(height);
        this.setCoordinates(new Point(x, y));

        this.primaryColor = Color.ORANGE;
        int tailX = (int) (x + width);
        int tailY = (int) (y + 0.45 * height);
        int tailW = tailSpacingPlacerholder;
        int tailH = height;
        this.tail = new Tail(tailX, tailY, tailW, tailH, this.cat);

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
        // this.drawBoundingBox();
    }

    public Tail getTail() {
        return this.tail;
    }
}
