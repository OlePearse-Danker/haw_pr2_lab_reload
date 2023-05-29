package lab0;

import javax.swing.*;

public class ColorSlider extends JSlider {

    public ColorSlider() {
        super();

        this.setOrientation(JSlider.HORIZONTAL);
        this.setMinimum(0);
        this.setMaximum(255);
        this.setValue(0);

        this.setMajorTickSpacing(50);
        this.setMinorTickSpacing(10);
        this.setPaintTicks(true);
        this.setPaintLabels(true);
    }

    public void setCurrentValue(int value) {
        this.setValue(value);
    }

}
