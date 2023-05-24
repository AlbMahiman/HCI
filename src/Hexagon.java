import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hexagon {
    private JTextField sideField;
    private JTextField shapeNameField;
    private JButton visualize2DButton;
    private JButton visualize3DButton;
    private JButton scaleButton;
    private JButton addShadeButton;
    private JButton changeColorButton;
    private JButton saveButton;
    private JButton editButton;
    private JButton deleteButton;
    private JPanel hexagonPanel;
    private Color hexagonColor;

    Hexagon() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(600, 600);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Create input fields
        JLabel sideLabel = new JLabel("Side:");
        sideField = new JTextField(10);

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
                if (sideField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please Insert Side of Hexagon");
                } else if (shapeNameField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please Insert Shape Name");
                } else {
                    hexagonPanel = new JPanel() {
                        @Override
                        protected void paintComponent(Graphics g) {
                            super.paintComponent(g);
                            Graphics2D g2d = (Graphics2D) g;
                            int side = Integer.parseInt(sideField.getText());
                            int centerX = getWidth() / 2;
                            int centerY = getHeight() / 2;
                            int radius = side / 2;

                            int[] xPoints = new int[6];
                            int[] yPoints = new int[6];

                            double angle = Math.PI / 2;
                            double angleIncrement = Math.PI / 3;

                            for (int i = 0; i < 6; i++) {
                                xPoints[i] = centerX + (int) (radius * Math.cos(angle));
                                yPoints[i] = centerY - (int) (radius * Math.sin(angle));
                                angle += angleIncrement;
                            }

                            g2d.setColor(hexagonColor);
                            g2d.fillPolygon(xPoints, yPoints, 6);
                        }
                    };
                    hexagonPanel.setPreferredSize(new Dimension(300, 300));
                    frame.add(hexagonPanel);
                    frame.revalidate();
                    frame.repaint();

                    visualize2DButton.setVisible(false);
                }
            }
        });

        changeColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hexagonPanel != null) {
                    Color newColor = JColorChooser.showDialog(frame, "Choose a Color", hexagonColor);
                    if (newColor != null) {
                        hexagonColor = newColor;
                        if (hexagonPanel != null) {
                            hexagonPanel.repaint();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Please Create the Shape First");
                }
            }
        });

        scaleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hexagonPanel != null) {
                    String scaleInput = JOptionPane.showInputDialog(frame, "Enter the scale factor:");
                    if (scaleInput != null && !scaleInput.isEmpty()) {
                        try {
                            double scaleFactor = Double.parseDouble(scaleInput);
                            int side = Integer.parseInt(sideField.getText());
                            int scaledSide = (int) (side * scaleFactor);
                            sideField.setText(String.valueOf(scaledSide));
                            hexagonPanel.repaint();
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Invalid input for scale factor.");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Please Create the Shape First");
                }
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hexagonPanel != null) {
                    String newSideInput = JOptionPane.showInputDialog(frame, "Enter the new side:");
                    if (newSideInput != null && !newSideInput.isEmpty()) {
                        try {
                            int newSide = Integer.parseInt(newSideInput);
                            sideField.setText(String.valueOf(newSide));
                            hexagonPanel.repaint();
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Invalid input for side.");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Please Create the Shape First");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hexagonPanel != null) {
                    frame.remove(hexagonPanel);
                    hexagonPanel = null;
                    frame.revalidate();
                    frame.repaint();
                    visualize2DButton.setVisible(true);
                }
            }
        });

        visualize3DButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add functionality to visualize the Hexagon in 3D
            }
        });

        frame.add(sideLabel);
        frame.add(sideField);
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




}
