package lab0;

import java.awt.*;

public class Grid {

    private int size;
    private int width;
    private int height;

    public Grid(int size, int width, int height) {
        this.size = size;
        this.width = width;
        this.height = height;
    }

    public void draw() {
        Drawing.pen().setColor(Color.LIGHT_GRAY);

        int tileCountX = width / size;
        int tileCountY = height / size;

        for (int row = 0; row < 100; row++) {
            for (int col = 0; col < 100; col++) {
                int x = col * size;
                int y = row * size;
                Drawing.pen().drawRect(x, y, size, size);
            }
        }
    }
}
