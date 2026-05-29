package Exp13;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

public class ImageGallery extends JFrame implements ActionListener {

    JLabel imageLabel;
    JLabel detailsLabel;

    JButton prevBtn;
    JButton nextBtn;

    JTable table;

    String[] imagePaths = {
        "Exp13/1288367.jpg",
        "Exp13/1312123.jpg",
        "Exp13/archbtw.png"
    };

    String[][] data = {
        {"Image 1","800x600","120KB"},
        {"Image 2","1024x768","200KB"},
        {"Image 3","640x480","90KB"}
    };

    int current = 0;

    public ImageGallery() {

        setTitle("Image Gallery");

        setSize(760,640);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setResizable(false);

        try {

            UIManager.setLookAndFeel(
                "javax.swing.plaf.nimbus.NimbusLookAndFeel"
            );

        }

        catch(Exception e) {}

        JPanel mainPanel = new JPanel(new BorderLayout(0, 18));

        mainPanel.setBackground(new Color(245, 247, 251));

        mainPanel.setBorder(new EmptyBorder(24, 28, 24, 28));

        setContentPane(mainPanel);

        JLabel title = new JLabel("Image Gallery");

        title.setFont(new Font("Segoe UI", Font.BOLD, 28));

        title.setForeground(new Color(31, 41, 55));

        mainPanel.add(title, BorderLayout.NORTH);

        JPanel topPanel = new JPanel(new BorderLayout());

        topPanel.setBackground(Color.WHITE);

        topPanel.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240)),
                new EmptyBorder(18, 18, 18, 18)
            )
        );

        imageLabel = new JLabel();

        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        imageLabel.setPreferredSize(new Dimension(680, 300));

        imageLabel.setOpaque(true);

        imageLabel.setBackground(new Color(15, 23, 42));

        loadImage();

        topPanel.add(imageLabel, BorderLayout.CENTER);

        JPanel centerPanel = new JPanel(new BorderLayout(0, 16));

        centerPanel.setOpaque(false);

        centerPanel.add(topPanel, BorderLayout.NORTH);

        String[] cols = {"Image Name","Resolution","Size"};

        table = new JTable(data, cols);

        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        table.setRowHeight(30);

        table.setGridColor(new Color(226, 232, 240));

        table.setSelectionBackground(new Color(219, 234, 254));

        table.setSelectionForeground(new Color(30, 64, 175));

        table.setFillsViewportHeight(true);

        JTableHeader tableHeader = table.getTableHeader();

        tableHeader.setFont(new Font("Segoe UI", Font.BOLD, 14));

        tableHeader.setForeground(new Color(51, 65, 85));

        tableHeader.setBackground(new Color(241, 245, 249));

        JScrollPane jsp = new JScrollPane(table);

        jsp.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240)),
                new EmptyBorder(0, 0, 0, 0)
            )
        );

        centerPanel.add(jsp, BorderLayout.CENTER);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());

        bottomPanel.setOpaque(false);

        prevBtn = new JButton("Previous");

        nextBtn = new JButton("Next");

        styleButton(prevBtn);

        styleButton(nextBtn);

        prevBtn.setMnemonic('P');

        nextBtn.setMnemonic('N');

        prevBtn.setToolTipText("Previous Image");

        nextBtn.setToolTipText("Next Image");

        prevBtn.addActionListener(this);

        nextBtn.addActionListener(this);

        detailsLabel = new JLabel("", JLabel.RIGHT);

        detailsLabel.setFont(
            new Font("Segoe UI", Font.BOLD, 15)
        );

        detailsLabel.setForeground(new Color(51, 65, 85));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));

        buttonPanel.setOpaque(false);

        buttonPanel.add(prevBtn);

        buttonPanel.add(nextBtn);

        bottomPanel.add(buttonPanel, BorderLayout.WEST);

        bottomPanel.add(detailsLabel, BorderLayout.EAST);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        updateDetails();

        setVisible(true);
    }

    private void styleButton(JButton button) {

        button.setPreferredSize(new Dimension(120, 38));

        button.setFont(new Font("Segoe UI", Font.BOLD, 14));

        button.setForeground(Color.WHITE);

        button.setBackground(new Color(37, 99, 235));

        button.setFocusPainted(false);

        button.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
    }

    public void loadImage() {

        ImageIcon icon = new ImageIcon(imagePaths[current]);

        Image img = icon.getImage().getScaledInstance(
            400,
            250,
            Image.SCALE_SMOOTH
        );

        imageLabel.setIcon(new ImageIcon(img));
    }

    public void updateDetails() {

        ImageIcon icon = new ImageIcon(imagePaths[current]);

        File imageFile = new File(imagePaths[current]);

        long sizeInKb = Math.max(1, imageFile.length() / 1024);

        detailsLabel.setText(
            data[current][0] + " | Resolution: " +
            icon.getIconWidth() + "x" + icon.getIconHeight() +
            " | Size: " + sizeInKb + " KB"
        );
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == nextBtn) {

            current++;

            if(current >= imagePaths.length)
                current = 0;
        }

        if(e.getSource() == prevBtn) {

            current--;

            if(current < 0)
                current = imagePaths.length - 1;
        }

        loadImage();

        updateDetails();
    }

    public static void main(String[] args) {

        new ImageGallery();
    }
}
