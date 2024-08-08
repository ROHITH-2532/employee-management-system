package employee.management.system;

import com.mysql.cj.jdbc.admin.MiniAdmin;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class View_Employee extends javax.swing.JFrame implements ActionListener {

    JTable table;
    Choice choiceemp;
    JButton  searchbtn,print,update,back;
    View_Employee()
    {
        getContentPane().setBackground(new Color(255,131,122));
        JLabel search = new JLabel("Search by empID:");
        search.setBounds(20,20,150,20);
        add(search);

        choiceemp = new Choice();
        choiceemp.setBounds(180,20,150,20);
        add(choiceemp);

        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while(resultSet.next()){
                choiceemp.add(resultSet.getString("empID"));   //extract and set in the choiceemp
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        table = new JTable();  //for displaying the table for choocing the empid
        try
        {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));    // add the jar file of dbutils and also in preious as calendar

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        JScrollPane jp = new JScrollPane(table);    // for scrolling the tables for viewing the details
        jp.setBounds(0,100,900,600);
        add(jp);

        searchbtn = new JButton("Search");
        searchbtn.setBounds(20,70,80,20);
        searchbtn.addActionListener(this);
        add(searchbtn);

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);

        setSize(900,700);
        setLayout(null);
        setLocation(300,100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==searchbtn)
        {
            String query = "select * from employee where empID='"+choiceemp.getSelectedItem()+"'";
            try
            {
                conn c = new conn();
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));       // resultset is added into the table

            }
            catch(Exception e1){
                e1.printStackTrace();
            }
        }
        else if(e.getSource()==print)
        {
            try{
                table.print();           // prints the table
            }
            catch(Exception e1){
                e1.printStackTrace();
            }
        } else if (e.getSource()==update)
        {
            setVisible(false);
            new Update_Employee(choiceemp.getSelectedItem());
        }
        else
        {
            setVisible(false);  //goes back
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new View_Employee();
    }
}
