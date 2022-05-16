package stages;

import stages.brick.Brick;

import java.util.ArrayList;
import java.util.List;

public class FirstStage {
    private static final List<Brick> bricks;

    static {
        bricks = new ArrayList<>();
        getHorizontalLine(75, 3, 525);
        getHorizontalLine(200, 13, 525);
        getHorizontalLine(575, 1, 525);
        getHorizontalLine(650, 4, 525);
        getVerticalLine(300, 9, 500);
        getHorizontalLine(150, 12, 450);
        getHorizontalLine(150, 9, 375);
        getHorizontalLine(150, 6, 300);
        getHorizontalLine(100, 8, 225);
        getHorizontalLine(525, 2, 300);
        getHorizontalLine(100, 5, 75);
        getHorizontalLine(150, 5, 150);
        getHorizontalLine(450, 6, 225);
        getHorizontalLine(425, 9, 150);
        getHorizontalLine(375, 12, 75);
        getVerticalLine(300, 9, 75);
        getVerticalLine(75, 7, 75);
        getVerticalLine(300, 9, 575);
        getVerticalLine(150, 15, 650);
        getVerticalLine(225, 9, 425);
        getVerticalLine(75, 12, 350);
        getVerticalLine(75, 4, 275);
        getVerticalLine(250, 2, 275);
        getVerticalLine(75, 18, 725);
    }

    public static List<Brick> get() {
        return bricks;
    }

    private static void getHorizontalLine(int startX, int count, int level) {
        for (int i = 0; i < count; i++) {
            bricks.add(new Brick(startX, level));
            startX += 25;
        }
    }

    private static void getVerticalLine(int startY, int count, int level) {
        for (int i = 0; i < count; i++) {
            bricks.add(new Brick(level, startY));
            startY += 25;
        }
    }
}
