import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Path2D;


public class Heart {

    private JTextField sizeField;
    private JTextField shapeNameField;
    private JButton visualize2DButton;
    private JButton visualize3DButton;
    private JButton scaleButton;
    private JButton addShadeButton;
    private JButton changeColorButton;
    private JButton saveButton;
    private JButton editButton;
    private JButton deleteButton;
    private JPanel heartPanel;
    private Color heartColor;

    Heart() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(600, 600);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Create input fields
        JLabel sizeLabel = new JLabel("Size:");
        sizeField = new JTextField(10);

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
                if (sizeField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please Insert Size of Heart");
                } else if (shapeNameField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please Insert Shape Name");
                } else {
                    heartPanel = new JPanel() {
                        @Override
                        protected void paintComponent(Graphics g) {
                            super.paintComponent(g);
                            Graphics2D g2d = (Graphics2D) g;
                            int size = Integer.parseInt(sizeField.getText());
                            int centerX = getWidth() / 2;
                            int centerY = getHeight() / 2;

                            Path2D.Double path = new Path2D.Double();
                            path.moveTo(centerX, centerY - size / 4);
                            path.curveTo(centerX + size / 2, centerY - size / 2, centerX + size / 4, centerY + size / 3, centerX, centerY + size / 2);
                            path.curveTo(centerX - size / 4, centerY + size / 3, centerX - size / 2, centerY - size / 2, centerX, centerY - size / 4);
                            g2d.setColor(heartColor);
                            g2d.fill(path);
                        }
                    };
                    heartPanel.setPreferredSize(new Dimension(300, 300));
                    frame.add(heartPanel);
                    frame.revalidate();
                    frame.repaint();

                    visualize2DButton.setVisible(false);
                }
            }
        });

        changeColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (heartPanel != null) {
                    Color newColor = JColorChooser.showDialog(frame, "Choose a Color", heartColor);
                    if (newColor != null) {
                        heartColor = newColor;
                        if (heartPanel != null) {
                            heartPanel.repaint();
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
                if (heartPanel != null) {
                    String scaleInput = JOptionPane.showInputDialog(frame, "Enter the scale factor:");
                    if (scaleInput != null && !scaleInput.isEmpty()) {
                        try {
                            double scaleFactor = Double.parseDouble(scaleInput);
                            int size = Integer.parseInt(sizeField.getText());
                            int scaledSize = (int) (size * scaleFactor);
                            sizeField.setText(String.valueOf(scaledSize));
                            heartPanel.repaint();
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
                if (heartPanel != null) {
                    String newSizeInput = JOptionPane.showInputDialog(frame, "Enter the new size:");
                    if (newSizeInput != null && !newSizeInput.isEmpty()) {
                        try {
                            int newSize = Integer.parseInt(newSizeInput);
                            sizeField.setText(String.valueOf(newSize));
                            heartPanel.repaint();
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Invalid input for size.");
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
                if (heartPanel != null) {
                    frame.remove(heartPanel);
                    heartPanel = null;
                    frame.revalidate();
                    frame.repaint();
                    visualize2DButton.setVisible(true);
                }
            }
        });

        visualize3DButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add functionality to visualize the Heart in 3D
            }
        });

        frame.add(sizeLabel);
        frame.add(sizeField);
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

    public static void main(String[] args) {
        new Heart();
    }



}
