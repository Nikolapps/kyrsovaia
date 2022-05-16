package frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame {
    private final JLayeredPane layeredPane;

    public MainFrame() {
        setTitle("Courier Simulator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(841, 664);
        setLocationRelativeTo(null);
        setResizable(false);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == 27) {
                    System.exit(0);
                }
            }
        });
        setVisible(true);

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, getWidth(), getHeight());
        getContentPane().add(layeredPane);
    }

    public void addToFrame(Component component) {
        layeredPane.add(component);
    }
}
