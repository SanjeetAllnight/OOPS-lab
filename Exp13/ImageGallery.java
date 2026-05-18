package Exp13;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class ImageGallery extends JFrame implements ActionListener {

    JLabel imageLabel;
    JLabel detailsLabel;

    JButton prevBtn;
    JButton nextBtn;

    JTable table;

    String[] imagePaths = {
        "Exp13/img1.jpg",
        "Exp13/img2.jpg",
        "Exp13/img3.jpg"
    };

    String[][] data = {
        {"Image 1","800x600","120KB"},
        {"Image 2","1024x768","200KB"},
        {"Image 3","640x480","90KB"}
    };

    int current = 0;

    public ImageGallery() {

        setTitle("Image Gallery");

        setSize(700,600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10,10));

        try {

            UIManager.setLookAndFeel(
                "javax.swing.plaf.nimbus.NimbusLookAndFeel"
            );

        }

        catch(Exception e) {}

        JPanel topPanel = new JPanel();

        topPanel.setBorder(
            new TitledBorder("Gallery")
        );

        imageLabel = new JLabel();

        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        loadImage();

        topPanel.add(imageLabel);

        add(topPanel, BorderLayout.NORTH);

        String[] cols = {"Image Name","Resolution","Size"};

        table = new JTable(data, cols);

        JScrollPane jsp = new JScrollPane(table);

        jsp.setBorder(
            BorderFactory.createTitledBorder("Image Details")
        );

        add(jsp, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();

        prevBtn = new JButton("Previous");

        nextBtn = new JButton("Next");

        prevBtn.setMnemonic('P');

        nextBtn.setMnemonic('N');

        prevBtn.setToolTipText("Previous Image");

        nextBtn.setToolTipText("Next Image");

        prevBtn.addActionListener(this);

        nextBtn.addActionListener(this);

        detailsLabel = new JLabel("Currently Showing: Image 1");

        detailsLabel.setFont(
            new Font("Arial", Font.BOLD, 16)
        );

        bottomPanel.add(prevBtn);

        bottomPanel.add(nextBtn);

        bottomPanel.add(detailsLabel);

        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
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

        detailsLabel.setText(
            "Currently Showing: " + data[current][0]
        );
    }

    public static void main(String[] args) {

        new ImageGallery();
    }
}