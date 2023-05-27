package lab0;

import java.awt.*;

public class Mouth extends BoundingBox{

    //fields

    private Whisker[] whisker;

    public int whiskerWidth;
    public int whiskerHeight;



    public Mouth(int x, int y, int width, int height) {

        this.setWidth(width);
        this.setHeight(height);
        this.setCoordinates(new Point(x, y));

        this.whiskerWidth = width / 1;
        this.whiskerHeight = height / 5;
        this.whisker = new Whisker[4];

        this.whisker[0] = new Whisker((int) (x + 3 * whiskerHeight), (int) (y + 1 * whiskerHeight), whiskerWidth, whiskerHeight);
        this.whisker[1] = new Whisker((int) (x - 3 * whiskerHeight), (int) (y + 1 * whiskerHeight), whiskerWidth, whiskerHeight);
        this.whisker[2] = new Whisker((int) (x + 3 * whiskerHeight), (int) (y + 2 * whiskerHeight), whiskerWidth, whiskerHeight);
        this.whisker[3] = new Whisker((int) (x - 3 * whiskerHeight), (int) (y + 2 * whiskerHeight), whiskerWidth, whiskerHeight);


    }

    public void draw() {

        // coordinates for the mouth
        int x = (int) this.getCoordinates().getX();
        int y = (int) this.getCoordinates().getY();
        int width = this.getWidth();
        int height = this.getHeight();


        Drawing.pen().setColor(Color.BLACK);

        Drawing.pen().fillOval(x, y, width, height);

        for (int i = 0; i < 4; i++) {
            whisker[i].draw();

        }


        // drawing the bounding box
        //this.drawBoundingBox();
    }

}
