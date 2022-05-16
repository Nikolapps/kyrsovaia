package panels;

import javax.swing.*;
import java.awt.*;

public class EndPanel extends JPanel {

    public EndPanel() {
        super(null);
        setBounds(0, 0, 841, 664);
        setBackground(Color.BLACK);

        JLabel label = new JLabel(new ImageIcon("src/main/resources/image/gameOver.png"));
        label.setBounds((841 / 2) - (560 / 2) , 20, 560, 350);

        JLabel label_2 = new JLabel(new ImageIcon("src/main/resources/image/escape.png"));
        label_2.setBounds((841 / 2) - (400 / 2) , 500, 400, 56);

        add(label);
        add(label_2);
    }
}
