package stages.persons;

import stages.Entity;

import javax.swing.*;
import java.awt.*;

public class Person implements Entity {
    private final int x_point;
    private final int y_point;

    public Person(int x_point, int y_point) {
        this.x_point = x_point;
        this.y_point = y_point;
    }

    public Image getPerson() {
        ImageIcon imageIcon = new ImageIcon("src/main/resources/image/person.gif");
        return imageIcon.getImage();
    }


    @Override
    public int getX_point() {
        return x_point;
    }

    @Override
    public int getY_point() {
        return y_point;
    }
}
