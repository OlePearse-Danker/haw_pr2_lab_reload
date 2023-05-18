package lab0;

import java.awt.*;

public class Upperbody extends BoundingBox{

    private Color primaryColor;

    public Upperbody(int x, int y, int width, int height) {
        this.setWidth(width);
        this.setHeight(height);
        this.setCoordinates(new Point(x, y));

        this.primaryColor = Color.ORANGE;
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

        // drawing the bounding box
        this.drawBoundingBox();
    }
}
