import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

public class StudentDBApp extends JFrame {

    public StudentDBApp() {
        setTitle("Experiment 14 - Database Operations");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1, 10, 10));

        JButton btnForm1 = new JButton("Form 1 - Database Connection");
        JButton btnForm2 = new JButton("Form 2 - Student Registration");
        JButton btnForm3 = new JButton("Form 3 - Records Viewer");
        JButton btnForm4 = new JButton("Form 4 - Update Record");
        JButton btnForm5 = new JButton("Form 5 - Delete Record");

        btnForm1.addActionListener(e -> new Form1Connection().setVisible(true));
        btnForm2.addActionListener(e -> new Form2Registration().setVisible(true));
        btnForm3.addActionListener(e -> new Form3Viewer().setVisible(true));
        btnForm4.addActionListener(e -> new Form4Update().setVisible(true));
        btnForm5.addActionListener(e -> new Form5Delete().setVisible(true));

        add(btnForm1);
        add(btnForm2);
        add(btnForm3);
        add(btnForm4);
        add(btnForm5);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentDBApp().setVisible(true));
    }
}

class Form1Connection extends JFrame {
    private JTextField hostField, portField, dbNameField, urlField;
    private JComboBox<String> dbTypeCombo;
    private JPasswordField passField;
    private JLabel statusLabel;

    public Form1Connection() {
        setTitle("Database Connection Form");
        setSize(500, 350);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 2, 10, 10));

        add(new JLabel("Database Type:"));
        dbTypeCombo = new JComboBox<>(new String[]{"MySQL", "PostgreSQL", "SQLite"});
        add(dbTypeCombo);

        add(new JLabel("Host:"));
        hostField = new JTextField("localhost");
        add(hostField);

        add(new JLabel("Port:"));
        portField = new JTextField("3306");
        add(portField);

        add(new JLabel("Database Name:"));
        dbNameField = new JTextField("university");
        add(dbNameField);

        add(new JLabel("Password:"));
        passField = new JPasswordField();
        add(passField);

        add(new JLabel("JDBC URL:"));
        urlField = new JTextField();
        urlField.setEditable(false);
        add(urlField);

        JButton connectBtn = new JButton("Connect");
        statusLabel = new JLabel("Status: Disconnected", SwingConstants.CENTER);
        add(connectBtn);
        add(statusLabel);

        DocumentListener dl = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { updateUrl(); }
            public void removeUpdate(DocumentEvent e) { updateUrl(); }
            public void changedUpdate(DocumentEvent e) { updateUrl(); }
        };

        hostField.getDocument().addDocumentListener(dl);
        portField.getDocument().addDocumentListener(dl);
        dbNameField.getDocument().addDocumentListener(dl);
        dbTypeCombo.addItemListener(e -> updateUrl());

        updateUrl();

        connectBtn.addActionListener(e -> {
            String url = urlField.getText();
            String user = "root";
            String pass = new String(passField.getPassword());

            try {
                Connection conn = DriverManager.getConnection(url, user, pass);
                statusLabel.setText("Status: Connection Successful!");
                statusLabel.setForeground(Color.GREEN);
                conn.close();
            } catch (SQLException ex) {
                statusLabel.setText("Status: Connection Failed");
                statusLabel.setForeground(Color.RED);
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Connection Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void updateUrl() {
        String type = dbTypeCombo.getSelectedItem().toString().toLowerCase();
        String host = hostField.getText();
        String port = portField.getText();
        String db = dbNameField.getText();
        
        if (type.equals("mysql")) {
            urlField.setText("jdbc:mysql://" + host + ":" + port + "/" + db);
        } else if (type.equals("postgresql")) {
            urlField.setText("jdbc:postgresql://" + host + ":" + port + "/" + db);
        } else {
            urlField.setText("jdbc:sqlite:" + db + ".db");
        }
    }
}

class Form2Registration extends JFrame {
    private JTextField nameField, emailField;
    private JComboBox<String> courseCombo, yearCombo;
    private JRadioButton maleRadio, femaleRadio;
    private JPasswordField pinField;
    private JLabel statusLabel;

    public Form2Registration() {
        setTitle("Student Registration");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 2, 5, 5));

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Course:"));
        courseCombo = new JComboBox<>(new String[]{"Computer Science", "Information Technology", "Electronics"});
        add(courseCombo);

        add(new JLabel("Year:"));
        yearCombo = new JComboBox<>(new String[]{"First Year", "Second Year", "Third Year", "Fourth Year"});
        add(yearCombo);

        add(new JLabel("Gender:"));
        JPanel radioPanel = new JPanel();
        ButtonGroup bg = new ButtonGroup();
        maleRadio = new JRadioButton("Male", true);
        femaleRadio = new JRadioButton("Female");
        bg.add(maleRadio);
        bg.add(femaleRadio);
        radioPanel.add(maleRadio);
        radioPanel.add(femaleRadio);
        add(radioPanel);

        add(new JLabel("Set PIN:"));
        pinField = new JPasswordField();
        add(pinField);

        JButton registerBtn = new JButton("Register");
        JButton resetBtn = new JButton("Reset");
        add(registerBtn);
        add(resetBtn);

        statusLabel = new JLabel("");
        add(new JLabel("")); 
        add(statusLabel);

        resetBtn.addActionListener(e -> resetForm());

        registerBtn.addActionListener(e -> {
            String url = "jdbc:mysql://localhost:3306/university";
            String query = "INSERT INTO students (name, email, course, year, gender, pin) VALUES (?, ?, ?, ?, ?, ?)";
            
            try (Connection conn = DriverManager.getConnection(url, "root", "");
                 PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                
                pstmt.setString(1, nameField.getText());
                pstmt.setString(2, emailField.getText());
                pstmt.setString(3, courseCombo.getSelectedItem().toString());
                pstmt.setString(4, yearCombo.getSelectedItem().toString());
                pstmt.setString(5, maleRadio.isSelected() ? "Male" : "Female");
                pstmt.setString(6, new String(pinField.getPassword()));

                int affected = pstmt.executeUpdate();
                if (affected > 0) {
                    ResultSet rs = pstmt.getGeneratedKeys();
                    if (rs.next()) {
                        statusLabel.setText("Success! Student ID: " + rs.getInt(1));
                        statusLabel.setForeground(Color.BLUE);
                        JOptionPane.showMessageDialog(this, "Data successfully inserted.");
                        resetForm();
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Insert Failed: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void resetForm() {
        nameField.setText("");
        emailField.setText("");
        courseCombo.setSelectedIndex(0);
        yearCombo.setSelectedIndex(0);
        maleRadio.setSelected(true);
        pinField.setText("");
    }
}

class Form3Viewer extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private JLabel countLabel;
    private JTextField searchField;
    private TableRowSorter<DefaultTableModel> sorter;

    public Form3Viewer() {
        setTitle("Student Records Viewer");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5, 5));

        JPanel topPanel = new JPanel(new BorderLayout());
        searchField = new JTextField();
        JButton refreshBtn = new JButton("Refresh");
        topPanel.add(new JLabel("Search Name: "), BorderLayout.WEST);
        topPanel.add(searchField, BorderLayout.CENTER);
        topPanel.add(refreshBtn, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

        model = new DefaultTableModel(new String[]{"ID", "Name", "Email", "Course", "Year", "Gender"}, 0);
        table = new JTable(model);
        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
        add(new JScrollPane(table), BorderLayout.CENTER);

        countLabel = new JLabel("Total records: 0");
        add(countLabel, BorderLayout.SOUTH);

        loadData();

        refreshBtn.addActionListener(e -> loadData());

        searchField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { filter(); }
            public void removeUpdate(DocumentEvent e) { filter(); }
            public void changedUpdate(DocumentEvent e) { filter(); }
        });
    }

    private void filter() {
        String text = searchField.getText();
        if (text.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 1));
        }
        countLabel.setText("Total records displayed: " + table.getRowCount());
    }

    private void loadData() {
        model.setRowCount(0);
        String url = "jdbc:mysql://localhost:3306/university";
        String query = "SELECT id, name, email, course, year, gender FROM students";

        try (Connection conn = DriverManager.getConnection(url, "root", "");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"), rs.getString("name"), rs.getString("email"),
                    rs.getString("course"), rs.getString("year"), rs.getString("gender")
                });
            }
            countLabel.setText("Total records fetched: " + model.getRowCount());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Fetch Failed: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

class Form4Update extends JFrame {
    private JTextField idField, nameField, emailField, courseField;
    private JTable table;
    private DefaultTableModel model;

    public Form4Update() {
        setTitle("Update Student Record");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(5, 3, 5, 5));
        idField = new JTextField();
        nameField = new JTextField();
        emailField = new JTextField();
        courseField = new JTextField();
        JButton fetchBtn = new JButton("Fetch");
        JButton updateBtn = new JButton("Update");

        formPanel.add(new JLabel("Enter Student ID:"));
        formPanel.add(idField);
        formPanel.add(fetchBtn);

        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("")); 

        formPanel.add(new JLabel("Email:"));
        formPanel.add(emailField);
        formPanel.add(new JLabel(""));

        formPanel.add(new JLabel("Course:"));
        formPanel.add(courseField);
        formPanel.add(new JLabel(""));

        formPanel.add(new JLabel(""));
        formPanel.add(updateBtn);
        formPanel.add(new JLabel(""));
        
        add(formPanel, BorderLayout.NORTH);

        model = new DefaultTableModel(new String[]{"ID", "Name", "Email", "Course"}, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        loadTable();

        fetchBtn.addActionListener(e -> {
            String url = "jdbc:mysql://localhost:3306/university";
            String query = "SELECT name, email, course FROM students WHERE id = ?";
            try (Connection conn = DriverManager.getConnection(url, "root", "");
                 PreparedStatement pstmt = conn.prepareStatement(query)) {
                
                pstmt.setInt(1, Integer.parseInt(idField.getText()));
                ResultSet rs = pstmt.executeQuery();
                
                if (rs.next()) {
                    nameField.setText(rs.getString("name"));
                    emailField.setText(rs.getString("email"));
                    courseField.setText(rs.getString("course"));
                } else {
                    JOptionPane.showMessageDialog(this, "Record not found!");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        updateBtn.addActionListener(e -> {
            String url = "jdbc:mysql://localhost:3306/university";
            String query = "UPDATE students SET name = ?, email = ?, course = ? WHERE id = ?";
            try (Connection conn = DriverManager.getConnection(url, "root", "");
                 PreparedStatement pstmt = conn.prepareStatement(query)) {
                
                pstmt.setString(1, nameField.getText());
                pstmt.setString(2, emailField.getText());
                pstmt.setString(3, courseField.getText());
                pstmt.setInt(4, Integer.parseInt(idField.getText()));
                
                int rows = pstmt.executeUpdate();
                if (rows > 0) {
                    JOptionPane.showMessageDialog(this, "Record Updated Successfully");
                    loadTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Update Failed");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });
    }

    private void loadTable() {
        model.setRowCount(0);
        String url = "jdbc:mysql://localhost:3306/university";
        String query = "SELECT id, name, email, course FROM students";
        try (Connection conn = DriverManager.getConnection(url, "root", "");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                model.addRow(new Object[]{rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("course")});
            }
        } catch (Exception ex) {}
    }
}

class Form5Delete extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private JLabel countLabel;

    public Form5Delete() {
        setTitle("Delete Student Record");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        model = new DefaultTableModel(new String[]{"ID", "Name", "Email", "Course"}, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        JButton deleteBtn = new JButton("Delete Selected");
        JButton refreshBtn = new JButton("Refresh Data");
        countLabel = new JLabel("Total records: 0");

        JPanel btnPanel = new JPanel();
        btnPanel.add(deleteBtn);
        btnPanel.add(refreshBtn);

        bottomPanel.add(countLabel, BorderLayout.WEST);
        bottomPanel.add(btnPanel, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);

        loadData();

        refreshBtn.addActionListener(e -> loadData());

        deleteBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Please select a record from the table first.");
                return;
            }

            int id = (int) table.getValueAt(row, 0);
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete Student ID " + id + "?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                String url = "jdbc:mysql://localhost:3306/university";
                String query = "DELETE FROM students WHERE id = ?";
                try (Connection conn = DriverManager.getConnection(url, "root", "");
                     PreparedStatement pstmt = conn.prepareStatement(query)) {
                    
                    pstmt.setInt(1, id);
                    int affected = pstmt.executeUpdate();
                    if (affected > 0) {
                        model.removeRow(row);
                        countLabel.setText("Total records: " + model.getRowCount());
                        JOptionPane.showMessageDialog(this, "Record deleted successfully.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error deleting record: " + ex.getMessage());
                }
            }
        });
    }

    private void loadData() {
        model.setRowCount(0);
        String url = "jdbc:mysql://localhost:3306/university";
        String query = "SELECT id, name, email, course FROM students";
        try (Connection conn = DriverManager.getConnection(url, "root", "");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                model.addRow(new Object[]{rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("course")});
            }
            countLabel.setText("Total records: " + model.getRowCount());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + ex.getMessage());
        }
    }
}