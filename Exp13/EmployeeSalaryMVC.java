package Exp13;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

class EmployeeModel {

    private String name;
    private String department;
    private String type;
    private double basicSalary;
    private double salary;

    public EmployeeModel() {}

    public EmployeeModel(String name, String department, String type, double basicSalary) {
        this.name = name;
        this.department = department;
        this.type = type;
        this.basicSalary = basicSalary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getType() {
        return type;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public double calculateSalary() {

        double allowancePercent;

        if (department.equals("IT"))
            allowancePercent = 0.10;

        else if (department.equals("HR"))
            allowancePercent = 0.08;

        else
            allowancePercent = 0.06;

        if (type.equals("Full Time"))
            allowancePercent += 0.05;

        else
            allowancePercent += 0.02;

        salary = basicSalary + (basicSalary * allowancePercent);

        return salary;
    }
}

class EmployeeView extends JFrame {

    JTextField txtName;
    JTextField txtBasicSalary;

    JComboBox<String> comboDept;

    JRadioButton fullTime;
    JRadioButton partTime;

    JButton btnCalc;

    JLabel lblResult;

    public EmployeeView() {

        setTitle("Employee Salary Calculator");

        setSize(620, 460);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout(0, 22));

        mainPanel.setBackground(new Color(245, 247, 251));

        mainPanel.setBorder(new EmptyBorder(26, 34, 26, 34));

        setContentPane(mainPanel);

        JPanel northPanel = new JPanel(new BorderLayout());

        northPanel.setOpaque(false);

        JLabel title = new JLabel("Employee Salary Calculator");

        title.setFont(new Font("Segoe UI", Font.BOLD, 26));

        title.setForeground(new Color(31, 41, 55));

        JLabel subtitle = new JLabel("Enter employee details to calculate the final salary");

        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        subtitle.setForeground(new Color(100, 116, 139));

        northPanel.add(title, BorderLayout.NORTH);

        northPanel.add(subtitle, BorderLayout.SOUTH);

        mainPanel.add(northPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridBagLayout());

        centerPanel.setBackground(Color.WHITE);

        centerPanel.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240)),
                new EmptyBorder(24, 26, 24, 26)
            )
        );

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(8, 0, 8, 0);

        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridy = 0;

        JLabel lblName = createLabel("Employee Name");

        txtName = new JTextField();

        styleInput(txtName);

        JLabel lblBasicSalary = createLabel("Basic Salary");

        txtBasicSalary = new JTextField();

        styleInput(txtBasicSalary);

        JLabel lblDept = createLabel("Department");

        String[] depts = {"IT","HR","Sales"};

        comboDept = new JComboBox<>(depts);

        comboDept.setPreferredSize(new Dimension(260, 36));

        comboDept.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        comboDept.setBackground(Color.WHITE);

        comboDept.setBorder(BorderFactory.createLineBorder(new Color(203, 213, 225)));

        JLabel lblType = createLabel("Employment Type");

        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 0));

        radioPanel.setOpaque(false);

        fullTime = new JRadioButton("Full Time");

        partTime = new JRadioButton("Part Time");

        styleRadio(fullTime);

        styleRadio(partTime);

        ButtonGroup bg = new ButtonGroup();

        bg.add(fullTime);

        bg.add(partTime);

        fullTime.setSelected(true);

        radioPanel.add(fullTime);

        radioPanel.add(partTime);

        lblResult = new JLabel("Salary will appear here", JLabel.CENTER);

        lblResult.setForeground(new Color(21, 128, 61));

        lblResult.setFont(new Font("Segoe UI", Font.BOLD, 15));

        lblResult.setOpaque(true);

        lblResult.setBackground(new Color(240, 253, 244));

        lblResult.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(187, 247, 208)),
                new EmptyBorder(8, 12, 8, 12)
            )
        );

        addFormRow(centerPanel, gbc, lblName, txtName);

        addFormRow(centerPanel, gbc, lblBasicSalary, txtBasicSalary);

        addFormRow(centerPanel, gbc, lblDept, comboDept);

        addFormRow(centerPanel, gbc, lblType, radioPanel);

        addFormRow(centerPanel, gbc, createLabel("Result"), lblResult);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));

        southPanel.setOpaque(false);

        btnCalc = new JButton("Calculate Salary");

        btnCalc.setMnemonic('C');

        btnCalc.setToolTipText("Click to calculate salary");

        btnCalc.setPreferredSize(new Dimension(190,42));

        btnCalc.setFont(new Font("Segoe UI", Font.BOLD, 14));

        btnCalc.setForeground(Color.WHITE);

        btnCalc.setBackground(new Color(37, 99, 235));

        btnCalc.setFocusPainted(false);

        btnCalc.setBorder(BorderFactory.createEmptyBorder(10, 18, 10, 18));

        southPanel.add(btnCalc);

        mainPanel.add(southPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private JLabel createLabel(String text) {

        JLabel label = new JLabel(text);

        label.setFont(new Font("Segoe UI", Font.BOLD, 14));

        label.setForeground(new Color(51, 65, 85));

        return label;
    }

    private void styleInput(JTextField field) {

        field.setPreferredSize(new Dimension(260, 36));

        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        field.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(203, 213, 225)),
                new EmptyBorder(6, 10, 6, 10)
            )
        );

        field.setOpaque(true);
    }

    private void styleRadio(JRadioButton radioButton) {

        radioButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        radioButton.setForeground(new Color(51, 65, 85));

        radioButton.setOpaque(false);
    }

    private void addFormRow(JPanel panel, GridBagConstraints gbc, JLabel label, JComponent field) {

        gbc.gridx = 0;

        gbc.weightx = 0;

        gbc.anchor = GridBagConstraints.WEST;

        panel.add(label, gbc);

        gbc.gridx = 1;

        gbc.weightx = 1;

        gbc.insets = new Insets(8, 28, 8, 0);

        panel.add(field, gbc);

        gbc.insets = new Insets(8, 0, 8, 0);

        gbc.gridy++;
    }
}

class EmployeeController implements ActionListener {

    EmployeeModel model;

    EmployeeView view;

    public EmployeeController(EmployeeModel model, EmployeeView view) {

        this.model = model;

        this.view = view;

        view.btnCalc.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            String name = view.txtName.getText();

            double basicSalary = Double.parseDouble(view.txtBasicSalary.getText());

            String dept = (String)view.comboDept.getSelectedItem();

            String type;

            if(view.fullTime.isSelected())
                type = "Full Time";

            else
                type = "Part Time";

            model.setName(name);

            model.setDepartment(dept);

            model.setType(type);

            model.setBasicSalary(basicSalary);

            double sal = model.calculateSalary();

            view.lblResult.setText("Rs. " + sal);

            view.txtName.setText("");

            view.txtBasicSalary.setText("");

        }

        catch(NumberFormatException ex) {

            JOptionPane.showMessageDialog(view,"Please enter a valid basic salary");
        }

        catch(Exception ex) {

            JOptionPane.showMessageDialog(view,"Error");
        }
    }
}

public class EmployeeSalaryMVC {

    public static void main(String[] args) {

        try {

            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.windows.WindowsLookAndFeel"
            );

        }

        catch(Exception e) {}

        EmployeeModel model = new EmployeeModel();

        EmployeeView view = new EmployeeView();

        new EmployeeController(model, view);
    }
}
