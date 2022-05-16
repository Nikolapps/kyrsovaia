package panels;

import buttons.ApplicationButton;
import main.Main;
import stages.FirstStage;
import stages.adapters.MainWindowAdapter;
import stages.panel.StagePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StartPanel extends JPanel {

    public StartPanel(int width, int height) throws IOException {
        super(null);
        setBounds(0, 0, width, height);
        setBackground(Color.BLACK);

        Image penImage = new ImageIcon("src/main/resources/image/cursor.png").getImage();
        Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(penImage, new Point(0,0), "cursor");

        setCursor(cursor);

        String rolloverPath = "src/main/resources/image/startButton/rolloverView.png";
        String generalPath = "src/main/resources/image/startButton/generalView.png";
        String pressedPath = "src/main/resources/image/startButton/pressedView.png";

        ApplicationButton applicationButton = new ApplicationButton(generalPath, rolloverPath, pressedPath);
        applicationButton.setBounds((width / 2) - (300 / 2) , 370, 300, 100);
        applicationButton.addActionListener(e -> {
            setVisible(false);
            StagePanel stagePanel = getStage();
            stagePanel.setLocation(0, 0);
            Main.getMainFrame().addKeyListener(new MainWindowAdapter(stagePanel));
            Main.getMainFrame().addToFrame(stagePanel);
        });

        BufferedImage bufferedImage = ImageIO.read(new File("src/main/resources/image/title.png"));
        Image image = bufferedImage.getScaledInstance(560, 350, Image.SCALE_DEFAULT);
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(image));
        label.setBounds((width / 2) - (560 / 2) , 20, 560, 350);

        JLabel label_2 = new JLabel(new ImageIcon("src/main/resources/image/escape.png"));
        label_2.setBounds((width / 2) - (400 / 2) , 500, 400, 56);

        add(applicationButton);
        add(label);
        add(label_2);
    }

    private StagePanel getStage() {
        return new StagePanel(FirstStage.get());
    }
}
