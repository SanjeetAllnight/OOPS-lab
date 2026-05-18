package Exp13;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

class EmployeeModel {

    private String name;
    private String department;
    private String type;
    private double salary;

    public EmployeeModel() {}

    public EmployeeModel(String name, String department, String type) {
        this.name = name;
        this.department = department;
        this.type = type;
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

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getType() {
        return type;
    }

    public double calculateSalary() {

        double base = 30000;

        if (department.equals("IT"))
            base += 15000;

        else if (department.equals("HR"))
            base += 8000;

        else
            base += 10000;

        if (type.equals("Full Time"))
            base += 10000;

        else
            base += 3000;

        salary = base;

        return salary;
    }
}

class EmployeeView extends JFrame {

    JTextField txtName;

    JComboBox<String> comboDept;

    JRadioButton fullTime;
    JRadioButton partTime;

    JButton btnCalc;

    JLabel lblResult;

    public EmployeeView() {

        setTitle("Employee Salary Calculator");

        setSize(500, 350);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10,10));

        JPanel northPanel = new JPanel();

        JLabel title = new JLabel("Employee Salary Calculator");

        title.setFont(new Font("Arial", Font.BOLD, 24));

        northPanel.add(title);

        add(northPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();

        centerPanel.setLayout(new GridLayout(4,2,10,10));

        centerPanel.setBorder(new EmptyBorder(20,20,20,20));

        JLabel lblName = new JLabel("Employee Name:");

        txtName = new JTextField();

        txtName.setPreferredSize(new Dimension(150,30));

        txtName.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        txtName.setOpaque(true);

        JLabel lblDept = new JLabel("Department:");

        String[] depts = {"IT","HR","Sales"};

        comboDept = new JComboBox<>(depts);

        comboDept.setPreferredSize(new Dimension(150,30));

        comboDept.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        JLabel lblType = new JLabel("Employment Type:");

        JPanel radioPanel = new JPanel();

        fullTime = new JRadioButton("Full Time");

        partTime = new JRadioButton("Part Time");

        ButtonGroup bg = new ButtonGroup();

        bg.add(fullTime);

        bg.add(partTime);

        fullTime.setSelected(true);

        radioPanel.add(fullTime);

        radioPanel.add(partTime);

        lblResult = new JLabel("Salary will appear here");

        lblResult.setForeground(Color.BLUE);

        lblResult.setFont(new Font("Verdana", Font.BOLD, 16));

        centerPanel.add(lblName);

        centerPanel.add(txtName);

        centerPanel.add(lblDept);

        centerPanel.add(comboDept);

        centerPanel.add(lblType);

        centerPanel.add(radioPanel);

        centerPanel.add(new JLabel("Result:"));

        centerPanel.add(lblResult);

        add(centerPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();

        btnCalc = new JButton("Calculate Salary");

        btnCalc.setMnemonic('C');

        btnCalc.setToolTipText("Click to calculate salary");

        btnCalc.setPreferredSize(new Dimension(180,40));

        southPanel.add(btnCalc);

        add(southPanel, BorderLayout.SOUTH);

        setVisible(true);
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

            String dept = (String)view.comboDept.getSelectedItem();

            String type;

            if(view.fullTime.isSelected())
                type = "Full Time";

            else
                type = "Part Time";

            model.setName(name);

            model.setDepartment(dept);

            model.setType(type);

            double sal = model.calculateSalary();

            view.lblResult.setText("Rs. " + sal);

            view.txtName.setText("");

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