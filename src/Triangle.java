import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Triangle {
    private JTextField baseField;
    private JTextField heightField;
    private JTextField shapeNameField;
    private JButton visualize2DButton;
    private JButton visualize3DButton;
    private JButton scaleButton;
    private JButton addShadeButton;
    private JButton changeColorButton;
    private JButton saveButton;
    private JButton editButton;
    private JButton deleteButton;
    private JPanel trianglePanel;
    private Color triangleColor;

    Triangle() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(600, 600);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Create input fields
        JLabel baseLabel = new JLabel("Base:");
        baseField = new JTextField(10);

        JLabel heightLabel = new JLabel("Height:");
        heightField = new JTextField(10);

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
                if (baseField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please Insert Base of Triangle");
                } else if (heightField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please Insert Height of Triangle");
                } else if (shapeNameField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please Insert Shape Name");
                } else {
                    trianglePanel = new JPanel() {
                        @Override
                        protected void paintComponent(Graphics g) {
                            super.paintComponent(g);
                            Graphics2D g2d = (Graphics2D) g;
                            int base = Integer.parseInt(baseField.getText());
                            int height = Integer.parseInt(heightField.getText());
                            int[] xPoints = {getWidth() / 2, (getWidth() / 2) - (base / 2), (getWidth() / 2) + (base / 2)};
                            int[] yPoints = {getHeight() / 2 - (height / 2), getHeight() / 2 + (height / 2), getHeight() / 2 + (height / 2)};
                            g2d.setColor(triangleColor);
                            g2d.fillPolygon(xPoints, yPoints, 3);
                        }
                    };
                    trianglePanel.setPreferredSize(new Dimension(300, 300));
                    frame.add(trianglePanel);
                    frame.revalidate();
                    frame.repaint();

                    visualize2DButton.setVisible(false);
                }
            }
        });

        changeColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (trianglePanel != null) {
                    Color newColor = JColorChooser.showDialog(frame, "Choose a Color", triangleColor);
                    if (newColor != null) {
                        triangleColor = newColor;
                        if (trianglePanel != null) {
                            trianglePanel.repaint();
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
                if (trianglePanel != null) {
                    String scaleInput = JOptionPane.showInputDialog(frame, "Enter the scale factor:");
                    if (scaleInput != null && !scaleInput.isEmpty()) {
                        try {
                            double scaleFactor = Double.parseDouble(scaleInput);
                            int base = Integer.parseInt(baseField.getText());
                            int height = Integer.parseInt(heightField.getText());
                            int scaledBase = (int) (base * scaleFactor);
                            int scaledHeight = (int) (height * scaleFactor);
                            baseField.setText(String.valueOf(scaledBase));
                            heightField.setText(String.valueOf(scaledHeight));
                            trianglePanel.repaint();
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
                if (trianglePanel != null) {
                    String newBaseInput = JOptionPane.showInputDialog(frame, "Enter the new base:");
                    String newHeightInput = JOptionPane.showInputDialog(frame, "Enter the new height:");
                    if (newBaseInput != null && !newBaseInput.isEmpty() && newHeightInput != null && !newHeightInput.isEmpty()) {
                        try {
                            int newBase = Integer.parseInt(newBaseInput);
                            int newHeight = Integer.parseInt(newHeightInput);
                            baseField.setText(String.valueOf(newBase));
                            heightField.setText(String.valueOf(newHeight));
                            trianglePanel.repaint();
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Invalid input for base or height.");
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
                if (trianglePanel != null) {
                    frame.remove(trianglePanel);
                    trianglePanel = null;
                    frame.revalidate();
                    frame.repaint();
                    visualize2DButton.setVisible(true);
                }
            }
        });

        visualize3DButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add functionality to visualize the Triangle in 3D
            }
        });

        frame.add(baseLabel);
        frame.add(baseField);
        frame.add(heightLabel);
        frame.add(heightField);
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
