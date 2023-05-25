import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(500,500);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton circleButton = new JButton("Circle");
        JButton squareButton = new JButton("Square");
        JButton rectangleButton = new JButton("Rectangle");
        JButton starButton = new JButton("Star");
        JButton hexagonButton = new JButton("Hexagon");
        JButton pentagonButton = new JButton("Pentagon");
        JButton triangleButton = new JButton("Triangle");
        JButton rhombusButton = new JButton("Rhombus");
        JButton heartButton = new JButton("Heart");
        JButton trapeziumButton = new JButton("Trapezium");
        JButton ellipseButton = new JButton("Ellipse");
        JButton parallelogramButton = new JButton("Parallelogram");


        Dimension buttonSize = new Dimension(500, 50);
        circleButton.setPreferredSize(buttonSize);
        squareButton.setPreferredSize(buttonSize);
        rectangleButton.setPreferredSize(buttonSize);
        starButton.setPreferredSize(buttonSize);
        hexagonButton.setPreferredSize(buttonSize);
        pentagonButton.setPreferredSize(buttonSize);
        triangleButton.setPreferredSize(buttonSize);
        rhombusButton.setPreferredSize(buttonSize);
        heartButton.setPreferredSize(buttonSize);
        trapeziumButton.setPreferredSize(buttonSize);
        ellipseButton.setPreferredSize(buttonSize);
        parallelogramButton.setPreferredSize(buttonSize);

        //circleButton.setFont(buttonFont);
        circleButton.setBackground(new Color(173, 216, 230));

        //squareButton.setFont(buttonFont);
        squareButton.setBackground(new Color(173, 216, 230));

        //rectangleButton.setFont(buttonFont);
        rectangleButton.setBackground(new Color(173, 216, 230));

        //starButton.setFont(buttonFont);
        starButton.setBackground(new Color(173, 216, 230));

        //hexagonButton.setFont(buttonFont);
        hexagonButton.setBackground(new Color(173, 216, 230));

        //pentagonButton.setFont(buttonFont);
        pentagonButton.setBackground(new Color(173, 216, 230));

        //triangleButton.setFont(buttonFont);
        triangleButton.setBackground(new Color(173, 216, 230));

        //rhombusButton.setFont(buttonFont);
        rhombusButton.setBackground(new Color(173, 216, 230));

        //heartButton.setFont(buttonFont);
        heartButton.setBackground(new Color(173, 216, 230));

        //trapeziumButton.setFont(buttonFont);
        trapeziumButton.setBackground(new Color(173, 216, 230));

        //ellipseButton.setFont(buttonFont);
        ellipseButton.setBackground(new Color(173, 216, 230));

        //parallelogramButton.setFont(buttonFont);
        parallelogramButton.setBackground(new Color(173, 216, 230));

        // Add action listeners to buttons

        circleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Circle circle = new Circle();
            }
        });

        squareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Square square = new Square();
            }
        });

        rectangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle rectangle = new Rectangle();
            }
        });

        starButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Star star = new Star();
            }
        });

        hexagonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hexagon hexagon = new Hexagon();
            }
        });

        pentagonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pentagon pentagon = new Pentagon();
            }
        });

        triangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Triangle triangle = new Triangle();
            }
        });

        rhombusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rhombus rhombus = new Rhombus();
            }
        });

        heartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Heart rhombus = new Heart();
            }
        });

        trapeziumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Trapezium trapezium = new Trapezium();
            }
        });

        ellipseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ellipse ellipse = new Ellipse();
            }
        });
        parallelogramButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Parallelogram parallelogram = new Parallelogram();
            }
        });




        frame.add(circleButton);
        frame.add(squareButton);
        frame.add(rectangleButton);
        frame.add(starButton);
        frame.add(hexagonButton);
        frame.add(pentagonButton);
        frame.add(triangleButton);
        frame.add(rhombusButton);
        frame.add(heartButton);
        frame.add(trapeziumButton);
        frame.add(ellipseButton);
        frame.add(parallelogramButton);

    }

}