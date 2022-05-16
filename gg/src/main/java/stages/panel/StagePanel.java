package stages.panel;

import main.Main;
import panels.EndPanel;
import stages.Entity;
import stages.brick.Brick;
import stages.persons.Person;
import stages.thing.Bag;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StagePanel extends JPanel {

    private Person person;
    private final List<Brick> bricks;
    private final List<Bag> things;
    private Bag collisionBag;
    private int move;

    public StagePanel(List<Brick> bricks) {
        super(null);
        this.bricks = bricks;
        things = new ArrayList<>();
        setSize(825, 625);
        setBackground(Color.BLACK);

        initBorder();
        initLabyrinth();
        createBags();
        initPerson();
    }

    public Person getPerson() {
        return person;
    }

    private void initPerson() {
        Random random = new Random();

        while (true) {
            int x = random.nextInt(30);
            int y = random.nextInt(22);

            Person person = new Person((x * 25) + 25, (y * 25) + 25);

            if (checkCollisionWithBricks(person) && checkCollisionWithThings(person)) {
                this.person = person;
                repaint();
                return;
            }
        }
    }


    private void createBags() {
        if (things.size() < 5) {
            while (things.size() < 5) {
                Bag bag = generateThing();
                things.add(bag);
                add(bag.getBag());
            }
        }
    }

    private Bag generateThing() {
        Random random = new Random();

        while (true) {
            int x = random.nextInt(30);
            int y = random.nextInt(22);

            Bag bag = new Bag((x * 25) + 25, (y * 25) + 25);

            if (checkCollisionWithBricks(bag) && checkCollisionWithThings(bag)) return bag;
        }
    }

    private boolean checkCollisionWithThings(Entity entity) {
        boolean key = true;
        for (Bag value : things) {
            if ((value.getX_point() == entity.getX_point() && value.getY_point() == entity.getY_point()) ||
                    (value.getX_point() == entity.getX_point() + 25 && value.getY_point() == entity.getY_point()) ||
                    (value.getX_point() + 25 == entity.getX_point() && value.getY_point() == entity.getY_point()) ||
                    (value.getX_point() == entity.getX_point() && value.getY_point() == entity.getY_point() + 25) ||
                    (value.getX_point() == entity.getX_point() && value.getY_point() + 25 == entity.getY_point() + 25) ||
                    (value.getX_point() + 25 == entity.getX_point() + 25 && value.getY_point() == entity.getY_point()) ||
                    (value.getX_point() == entity.getX_point() && value.getY_point() + 25 == entity.getY_point())) {
                collisionBag = value;
                key = false;
                break;
            }
        }
        return key;
    }

    private boolean checkCollisionWithBricks(Entity entity) {
        boolean key = true;
        for (Brick brick : bricks) {
            if ((brick.getX_point() == entity.getX_point() && brick.getY_point() == entity.getY_point()) ||
                    (brick.getX_point() == entity.getX_point() + 25 && brick.getY_point() == entity.getY_point()) ||
                    (brick.getX_point() == entity.getX_point() && brick.getY_point() == entity.getY_point() + 25) ||
                    (brick.getX_point() == entity.getX_point() + 25 && brick.getY_point() == entity.getY_point() + 25)) {
                key = false;
                break;
            }
        }
        return key;
    }

    private void initBorder() {
        int width = 0;
        for (int i = 0; i < 825 / 25; i++) {
            Brick brick = new Brick(width, 0);
            bricks.add(brick);
            add(brick.getBrick());

            Brick brick_2 = new Brick(width, 600);
            bricks.add(brick_2);
            add(brick_2.getBrick());
            width += 25;
        }

        int height = 25;
        for (int i = 0; i < 575 / 25; i++) {
            Brick brick = new Brick(0, height);
            bricks.add(brick);
            add(brick.getBrick());

            Brick brick_2 = new Brick(800, height);
            bricks.add(brick_2);
            add(brick_2.getBrick());
            height += 25;
        }
    }

    private void initLabyrinth() {
        for (Brick brick : bricks) {
            add(brick.getBrick());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        AffineTransform original = ((Graphics2D) g).getTransform();
        AffineTransform newForm = (AffineTransform) original.clone();
        if (move == 1) {
            newForm.rotate(1.6d, person.getX_point() + 25, person.getY_point() + 25);
            ((Graphics2D) g).setTransform(newForm);
        } else if (move == 2) {
            newForm.rotate(3.1d, person.getX_point() + 25, person.getY_point() + 25);
            ((Graphics2D) g).setTransform(newForm);
        } else if (move == 3) {
            newForm.rotate(4.7d, person.getX_point() + 25, person.getY_point() + 25);
            ((Graphics2D) g).setTransform(newForm);
        }


        g.drawImage(person.getPerson(), person.getX_point(), person.getY_point(), this);
        ((Graphics2D) g).setTransform(original);
    }

    public void moveLeft() {
        move = 2;
        Person person = new Person(getPerson().getX_point() - 25, getPerson().getY_point());
        if (checkCollisionWithBricks(person)) {
            this.person = person;
            repaint();
        }

        if (!checkCollisionWithThings(person)) {
            playSound();
            remove(collisionBag);
        }
    }

    public void moveUp() {
        move = 3;
        Person person = new Person(getPerson().getX_point(), getPerson().getY_point() - 25);
        if (checkCollisionWithBricks(person)) {
            this.person = person;
            repaint();
        }
        if (!checkCollisionWithThings(person)) {
            playSound();
            remove(collisionBag);
        }
    }

    public void moveDown() {
        move = 1;
        Person person = new Person(getPerson().getX_point(), getPerson().getY_point() + 25);
        if (checkCollisionWithBricks(person)) {
            this.person = person;
            repaint();
        }
        if (!checkCollisionWithThings(person)) {
            playSound();
            remove(collisionBag);
        }
    }

    public void moveRight() {
        move = 0;
        Person person = new Person(getPerson().getX_point() + 25, getPerson().getY_point());
        if (checkCollisionWithBricks(person)) {
            this.person = person;
            repaint();
        }
        if (!checkCollisionWithThings(person)) {
            playSound();
            remove(collisionBag);
        }
    }

    private void remove(Bag bag) {
        remove(getComponentAt(bag.getX_point(), bag.getY_point()));
        things.remove(bag);

        if (things.isEmpty()) {
            setVisible(false);
            EndPanel panel = new EndPanel();
            Main.getMainFrame().addToFrame(panel);
        }
    }

    private void playSound() {
        new Thread(() -> {
            try {
                File file = new File("src/main/resources/sound/mario_coin_sound.wav");
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
                Clip clip = AudioSystem.getClip();
                clip.open(inputStream);
                clip.setFramePosition(0);
                clip.start();
                Thread.sleep(clip.getFrameLength());
                clip.stop();
                clip.close();
            } catch (
                    Exception e) {
                System.out.println(e.getMessage());
            }
        }).start();
    }
}
