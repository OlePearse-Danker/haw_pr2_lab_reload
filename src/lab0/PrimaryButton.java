package lab0;

import javax.swing.*;
import java.awt.*;

public class PrimaryButton extends JButton {

    private Color bgColor;
    private Color textColor;

    public PrimaryButton(String name) {
        super(name);

        this.bgColor = Color.DARK_GRAY;
        this.textColor = Color.RED;

        this.setBackground(this.bgColor);
        this.setForeground(this.textColor);
    }

}
