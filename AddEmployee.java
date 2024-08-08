package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends javax.swing.JFrame implements ActionListener
{
    Random ran  = new Random();
    int number = ran.nextInt(999999);

    JTextField tname , tfname, taddress, tphone, taadhar, temail, tsalary, tdesignation;
    JLabel tempid;
    JDateChooser tob;   // text data of birth
    JComboBox Boxeducation;
    JButton add,back;
    AddEmployee()
    {

        getContentPane().setBackground(new Color(163,255,188));
        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        JLabel name = new JLabel("Name:");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SANS_SERIF",Font.BOLD,20));     // Employeee name
        add(name);

        tname = new JTextField();
        tname.setBounds(200,150,150,30);
        tname.setBackground(new Color(177,252,197));
        add(tname);

        JLabel fname = new JLabel("Father's Name:");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("SANS_SERIF",Font.BOLD,20));    //fathers name
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600,150,150,30);
        tfname.setBackground(new Color(177,252,197));
        add(tfname);


        JLabel dob = new JLabel("Date Of Birth:");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("SANS_SERIF",Font.BOLD,20));   // date of birth
        add(dob);

        // for calendar
        tob = new JDateChooser();
        tob.setBounds(200,200,150,30);
        tob.setBackground(new Color(177,252,197));
        add(tob);

        JLabel address = new JLabel("Address:");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("SAN_SERIF",Font.BOLD,20));        //address
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200,250,150,30);
        taddress.setBackground(new Color(177,252,197));
        add(taddress);

        JLabel salary = new JLabel("Salary:");
        salary.setBounds(400,200,150,30);
        salary.setFont(new Font("SANS_SERIF",Font.BOLD,20));     // salary
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600,200,150,30);
        tsalary.setBackground(new Color(177,252,197));
        add(tsalary);

        JLabel  phone = new JLabel("Phone:");
        phone.setBounds(400,250,150,30);
        phone.setFont(new Font("SANS_SERIF",Font.BOLD,20));    //phone
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600,250,150,30);
        tphone.setBackground(new Color(177,252,197));
        add(tphone);

        JLabel aadhaar = new JLabel("Aadhaar:");
        aadhaar.setBounds(400,350,150,30);
        aadhaar.setFont(new Font("SANS_SERIF",Font.BOLD,20));  //aadhar
        add(aadhaar);

        taadhar = new JTextField();
        taadhar.setBounds(600,350,150,30);
        taadhar.setBackground(new Color(177,252,197));
        add(taadhar);

        JLabel email = new JLabel("E-mail:");
        email.setBounds(50,300,150,30);
        email.setFont(new Font("SANS_SERIF",Font.BOLD,20));    // email
        add(email);

        temail = new JTextField();
        temail.setBounds(200,300,150,30);
        temail.setBackground(new Color(177,252,197));
        add(temail);

        JLabel education = new JLabel("Higher Education:");
        education.setBounds(400,300,150,30);
        education.setFont(new Font("SANS_SERIF",Font.BOLD,20));    // education
        add(education);

        String items[] = {"BBA","B.Tech","BCA","BA","BSC","B.COM","MBA","MCA","MA","MTech","MSC","PHD"};    // for displaying of the options
        Boxeducation = new JComboBox(items);
        Boxeducation.setBackground(new Color(177,252,197));
        Boxeducation.setBounds(600,300,150,30);
        add(Boxeducation);


        JLabel empid = new JLabel("Employee ID:");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("SANS_SERIF",Font.BOLD,20));
        add(empid);

        tempid = new JLabel(""+number);
        tempid.setBounds(200,400,150,30);
        tempid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        tempid.setForeground(Color.RED);
        add(tempid);


        JLabel designation = new JLabel("Designation:");
        designation.setBounds(50,350,150,30);
        designation.setFont(new Font("SANS_SERIF",Font.BOLD,20));    //designation
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(200,350,150,30);
        tdesignation.setBackground(new Color(177,252,197));
        add(tdesignation);



        back = new JButton("BACK");
        back.setBounds(250,550,150,40);     // back button
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);


        add = new JButton("ADD EMPLOYEE");
        add.setBounds(450,550,150,40);            // add button
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);

        setSize(900,700);
        setLayout(null);
        setLocation(300,50);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add)
        {
            String name = tname.getText();
            String fname = tfname.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String dob = ((JTextField) tob.getDateEditor().getUiComponent()).getText();
            String email = temail.getText();
            String education = Boxeducation.getSelectedItem().toString();
            String designation = Boxeducation.getSelectedItem().toString();
            String empID = tempid.getText();
            String salary = tsalary.getText();
            String aadhaar = taadhar.getText();

            try
            {
                conn c = new conn();
                String query = "insert into employee values('"+name+"', '"+fname+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+aadhaar+"', '"+empID+"')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details added Successfully");
                setVisible(false);
                new Main_class();
            }
            catch (Exception E)
            {
                E.printStackTrace();
            }
        }
        else {
            setVisible(false);
            new Main_class();
        }

    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
