package stages.adapters;

import stages.panel.StagePanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainWindowAdapter extends KeyAdapter {

    private final StagePanel stagePanel;

    public MainWindowAdapter(StagePanel stagePanel) {
        this.stagePanel = stagePanel;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        if (e.getKeyCode() == 27) {
            System.exit(0);
        }

        if (stagePanel.isVisible()) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                stagePanel.moveLeft();
            }
        }

        if (stagePanel.isVisible()) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                stagePanel.moveUp();
            }
        }

        if (stagePanel.isVisible()) {
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                stagePanel.moveDown();
            }
        }

        if (stagePanel.isVisible()) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                stagePanel.moveRight();
            }
        }
    }
}
