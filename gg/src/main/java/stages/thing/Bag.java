package stages.thing;

import stages.Entity;

import javax.swing.*;

public class Bag implements Entity {
    private final int x_point;
    private final int  y_point;

    public Bag(int x_point, int y_point) {
        this.x_point = x_point;
        this.y_point = y_point;
    }

    public JLabel getBag() {
        JLabel label = new JLabel(new ImageIcon("src/main/resources/image/thing.gif"));
        int height = 50;
        int width = 50;
        label.setBounds(x_point, y_point, width, height);
        return label;
    }

    public int getX_point() {
        return x_point;
    }

    public int getY_point() {
        return y_point;
    }
}
