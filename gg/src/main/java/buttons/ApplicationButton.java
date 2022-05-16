package buttons;

import javax.swing.*;
import java.awt.*;

public class ApplicationButton extends JButton {
    private final String generalViewPath;
    private final String rolloverViewPath;
    private final String pressedViewPath;

    public ApplicationButton(String generalViewPath, String rolloverViewPath, String pressedViewPath) {
        this.generalViewPath = generalViewPath;
        this.rolloverViewPath = rolloverViewPath;
        this.pressedViewPath = pressedViewPath;
        setFocusable(false);
        setContentAreaFilled(false);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    @Override
    protected void paintComponent(Graphics g) {
        final Graphics2D g2 = (Graphics2D) g.create();

        if (getModel().isPressed()) {
            g2.drawImage(new ImageIcon(pressedViewPath).getImage(), 0, 0, null);
            g2.dispose();
            super.paintComponent(g2);
            return;
        }

        if (getModel().isRollover()) {
            g2.drawImage(new ImageIcon(rolloverViewPath).getImage(), 0, 0, null);
            g2.dispose();
            super.paintComponent(g2);
            return;
        }

        g2.drawImage(new ImageIcon(generalViewPath).getImage(), 0, 0, this);
        g2.dispose();
        super.paintComponent(g2);
    }
}
