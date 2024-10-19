import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class gradeBook extends JFrame implements ActionListener {
    JButton searchButton, exitButton;
    JTable table;
    JTextField textField;
    JLabel name, id, nameField, idField;
    gradeBook() {
        // Text Enter Student Id
        JLabel label1 = new JLabel("Enter Student Id");
        label1.setBounds(50, 20, 200, 30);
        label1.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(label1);

        // Text Name
        name = new JLabel("Name: ");
        name.setBounds(50, 100, 200, 30);
        name.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(name);

        nameField = new JLabel(" ");
        nameField.setBounds(170, 100, 200, 30);
        nameField.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(nameField);

        // Text Student id
        id = new JLabel("Student Id: ");
        id.setBounds(50, 150, 200, 30);
        id.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(id);

        idField = new JLabel(" ");
        idField.setBounds(170, 150, 200, 30);
        idField.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(idField);

        // Text Subject
        JLabel label4 = new JLabel("Subject");
        label4.setBounds(70, 200, 200, 30);
        label4.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(label4);

        // Text Marks
        JLabel label5 = new JLabel("Marks");
        label5.setBounds(270, 200, 200, 30);
        label5.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(label5);

        // Text Grade
        JLabel label6 = new JLabel("Grade");
        label6.setBounds(470, 200, 200, 30);
        label6.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(label6);

        // Input box
        textField = new JTextField();
        textField.setBounds(200, 20, 200, 30);
        textField.setForeground(Color.BLACK);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(textField);

        // Search Button
        searchButton = new JButton("Search");
        searchButton.setBounds(210, 60, 100, 20);
        searchButton.setFont(new Font("Tahoma", Font.PLAIN,15));
        searchButton.addActionListener(this);
        add(searchButton);

        // Exit Button
        exitButton = new JButton("Exit");
        exitButton.setBounds(325, 60, 68, 20);
        exitButton.setFont(new Font("Tahoma", Font.PLAIN,15));
        exitButton.addActionListener(this);
        add(exitButton);

        // Basic layout
        getContentPane().setBackground(Color.CYAN);
        setUndecorated(true);
        setLayout(null);
        setLocation(400, 100);
        setSize(600, 370);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == searchButton){
            connection c = new connection();
            String stu_id = textField.getText();

            //table
            table = new JTable();
            table.setBounds(0,225,600,80);
            table.setBackground(Color.WHITE);
            add(table);

            try {
                String sub = "java";
                String q1 = "select Student_ID,Name from Students where Student_ID = '"+ stu_id +"' and Subject = '"+sub+"'";
                ResultSet resultSet1 = c.statement.executeQuery(q1);
                while(resultSet1.next()){
                    nameField.setText(resultSet1.getString("Name"));
                    idField.setText(resultSet1.getString("Student_ID"));
                }

                String q = "select Subject,Marks,Grade from Students where Student_ID = '"+ stu_id +"'";
                ResultSet resultSet = c.statement.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }
            catch(Exception er){
                er.printStackTrace();
            }
        }
        else if(e.getSource() == exitButton){
            System.exit(69);
        }
    }
    public static void main(String[] args) {
        new gradeBook();
    }
}