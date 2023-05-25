import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sun.prism.PhongMaterial;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Sphere;

import javafx.scene.paint.Material;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Sphere;





public class Circle {
    private JTextField radiusField;
    private JTextField shapeNameField;
    private JButton visualize2DButton;
    private JButton visualize3DButton;
    private JButton scaleButton;
    private JButton addShadeButton;
    private JButton changeColorButton;
    private JButton saveButton;
    private JButton editButton;
    private JButton deleteButton;
    private JPanel circlePanel;
    private Color circleColor;


    Circle(){
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(600,600);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Create Swing JPanel for JavaFX integration
        circlePanel = new JPanel();
        circlePanel.setLayout(new BorderLayout());

        // Create JavaFX components
        JFXPanel fxPanel;
        fxPanel = new JFXPanel();
        Group root3D = new Group();
        Scene scene3D = new Scene(root3D, 600, 600, true);

        // Create input fields
        JLabel radiusLabel = new JLabel("Radius:");
        radiusField = new JTextField(10);

        JLabel shapeNameLabel = new JLabel("Shape Name:");
        shapeNameField = new JTextField(10);

        // Create buttons
        visualize2DButton = new JButton("Visualize 2D");
        visualize3DButton = new JButton("Visualize 3D");
        scaleButton = new JButton("Scale Shape");
        addShadeButton = new JButton("Add Shade");
        changeColorButton = new JButton("Change Color");
        saveButton = new JButton("Save Shape");
        editButton = new JButton("Edit Shape");
        deleteButton = new JButton("Delete Shape");

        // Add components to the frame
        visualize2DButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(radiusField ==null){JOptionPane.showMessageDialog(frame, "Please Insert Radius of Circle");}
                else if (shapeNameField ==null){JOptionPane.showMessageDialog(frame, "Please Insert Shape Name");}
                else
                {
                    circlePanel = new JPanel() {

                        @Override
                        protected void paintComponent(Graphics g) {
                            super.paintComponent(g);
                            Graphics2D g2d = (Graphics2D) g;
                            double radius = Double.parseDouble(radiusField.getText());
                            int diameter = (int) (radius * 2);
                            int x = (getWidth() - diameter) / 2;
                            int y = (getHeight() - diameter) / 2;
                            g2d.setColor(circleColor);
                            g2d.fillOval(x, y, diameter, diameter);
                        }
                    };
                    circlePanel.setPreferredSize(new Dimension(300, 300));
                    frame.add(circlePanel);
                    frame.revalidate();
                    frame.repaint();

                    visualize2DButton.setVisible(false);
                }

            }
        });

        changeColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (circlePanel != null) {
                    Color newColor = JColorChooser.showDialog(frame, "Choose a Color", circleColor);
                    if (newColor != null) {
                        circleColor = newColor;
                        if (circlePanel != null) {
                            circlePanel.repaint();
                        }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(frame, "Please Create the Shape First");

                }

            }
        });

        scaleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (circlePanel != null) {
                    String scaleInput = JOptionPane.showInputDialog(frame, "Enter the scale factor:");
                    if (scaleInput != null && !scaleInput.isEmpty()) {
                        try {
                            double scaleFactor = Double.parseDouble(scaleInput);
                            double radius = Double.parseDouble(radiusField.getText());
                            double scaledRadius = radius * scaleFactor;
                            radiusField.setText(String.valueOf(scaledRadius));
                            circlePanel.repaint();
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Invalid input for scale factor.");
                        }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(frame, "Please Create the Shape First");

                }

            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (circlePanel != null) {
                    String newRadiusInput = JOptionPane.showInputDialog(frame, "Enter the new radius:");
                    if (newRadiusInput != null && !newRadiusInput.isEmpty()) {
                        try {
                            double newRadius = Double.parseDouble(newRadiusInput);
                            radiusField.setText(String.valueOf(newRadius));
                            circlePanel.repaint();
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Invalid input for radius.");
                        }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(frame, "Please Create the Shape First");

                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (circlePanel != null) {
                    frame.remove(circlePanel);
                    circlePanel = null;
                    frame.revalidate();
                    frame.repaint();
                    visualize2DButton.setVisible(true);
                }
            }
        });
        visualize3DButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radiusField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please insert the radius of the sphere.");
                } else {
                    try {
                        double radius = Double.parseDouble(radiusField.getText());
                        // Call method to visualize 3D sphere here
                        generate3DSphere(radius);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Invalid input for radius.");
                    }
                }
            }
        });


        frame.add(radiusLabel);
        frame.add(radiusField);
        frame.add(shapeNameLabel);
        frame.add(shapeNameField);
        frame.add(visualize2DButton);
        frame.add(visualize3DButton);
        frame.add(scaleButton);
        frame.add(addShadeButton);
        frame.add(changeColorButton);
        frame.add(saveButton);
        frame.add(editButton);
        frame.add(deleteButton);

    }

    private void generate3DSphere(double radius) {
        JFrame sphereFrame = new JFrame();
        sphereFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        sphereFrame.setSize(600, 600);
        sphereFrame.setLocationRelativeTo(null);

        JFXPanel fxPanel = new JFXPanel();
        sphereFrame.add(fxPanel);

        Platform.runLater(() -> {
            Group root3D = new Group();
            Scene scene3D = new Scene(root3D, 600, 600, true);

            Sphere sphere = new Sphere(radius);
            sphere.setTranslateX(scene3D.getWidth() / 2);
            sphere.setTranslateY(scene3D.getHeight() / 2);
            sphere.setTranslateZ(scene3D.getWidth() / 2);

            //PhongMaterial material = new PhongMaterial();
            //material.setDiffuseColor(Color.BLUE);
            //sphere.setMaterial((Material) material);

            root3D.getChildren().add(sphere);

            fxPanel.setScene(scene3D);
        });

        sphereFrame.setVisible(true);
    }

}
