package lab0;

import java.awt.*;

public class ScreenInterface {

    public static Dimension getScreenSize() {
        Window[] windows = Window.getWindows();
        Dimension size = windows[0].getSize();
        return size;
    }

}
