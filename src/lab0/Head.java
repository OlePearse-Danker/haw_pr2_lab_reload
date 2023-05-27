package lab0;

import java.awt.*;

public class Head extends BoundingBox{


    private Ear leftEar;

    private int earWidth;
    private int earHeight;

    private Ear rightEar;

    private Eye leftEye;

    private int eyeWidth;
    private int eyeHeight;

    private Eye rightEye;

    private Mouth mouth;

    private int mouthWidth;
    private int mouthHeight;

    public Head(int x, int y, int width, int height) {

        this.setWidth(width);
        this.setHeight(height);
        this.setCoordinates(new Point(x, y));

        // setting the width and height of the ears
        this.earWidth = width / 4;
        this.earHeight = height / 2;

        this.leftEar = new Ear(x, y - earWidth, earWidth, earHeight);
        this.rightEar = new Ear(x + width - earWidth, y - earWidth, earWidth, earHeight);

        // setting the width and height of the eyes
        this.eyeWidth = width / 5;
        this.eyeHeight = height / 5;

        this.leftEye = new Eye((int) (x + (1 * eyeWidth)), (int) (y + 1.2 * earWidth), eyeWidth, eyeHeight);
        this.rightEye = new Eye((int) (x + width - (2 * eyeWidth)), (int) (y + 1.2 * earWidth), eyeWidth, eyeHeight);


        this.mouthWidth = width / 5;
        this.mouthHeight = height / 5;
        this.mouth = new Mouth((int) ((int) (x + 0.5 * width) - (0.5 * mouthWidth)), (int) (y + 3 * mouthWidth), mouthWidth, mouthHeight);
    }

    public void draw() {

        // coordinates for the upper_body
        int x = (int) this.getCoordinates().getX();
        int y = (int) this.getCoordinates().getY();
        int width = this.getWidth();
        int height = this.getHeight();


        Drawing.pen().setColor(Color.orange);

        Drawing.pen().fillOval(x, y, width, height);

        leftEar.draw();
        rightEar.draw();

        leftEye.draw();
        rightEye.draw();

        mouth.draw();

        // drawing the bounding box
        this.drawBoundingBox();
    }

}


