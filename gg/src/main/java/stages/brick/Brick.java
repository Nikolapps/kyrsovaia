package stages.brick;

import javax.swing.*;

public class Brick {
    private final int x_point;
    private final int  y_point;

    public Brick(int x_point, int y_point) {
        this.x_point = x_point;
        this.y_point = y_point;
    }

    public JLabel getBrick() {
        JLabel label = new JLabel(new ImageIcon("src/main/resources/image/brick.png"));
        int height = 25;
        int width = 25;
        label.setBounds(x_point, y_point, width, height);
        return label;
    }

    public int getX_point() {
        return x_point;
    }

    public int getY_point() {
        return y_point;
    }

    @Override
    public String toString() {
        return "Brick{" +
                "x_point=" + x_point +
                ", y_point=" + y_point +
                '}';
    }
}
