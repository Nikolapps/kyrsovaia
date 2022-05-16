package main;

import frames.MainFrame;
import panels.StartPanel;

import java.io.IOException;

public class Main {
    private static MainFrame mainFrame;

    public static void main(String[] args) throws IOException {
        mainFrame = new MainFrame();

        StartPanel panel = new StartPanel(mainFrame.getContentPane().getWidth(), mainFrame.getContentPane().getHeight());

        mainFrame.addToFrame(panel);
    }

    public static MainFrame getMainFrame() {
        return mainFrame;
    }
}
