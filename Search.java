import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;
import java.util.*;
import java.sql.*;
public class Search extends LoginPage{
	
	public JFrame searchTeacher;
	public JLabel id,name,dob,age,phone,mailid,gender,subject,qualification,address,salary,nofclasses;
	public JLabel id2,name2,dob2,age2,phone2,mailid2,gender2,subject2,qualification2,address2,salary2,nofclasses2;
	public static Font bnamef,font1,font2;
	
	ButtonGroup bg;
	public static JButton backbtn;
	String sname,sdob,ssubject,sgender,squalification,saddress,sid,sage,sphone,sno_of_classes,ssalary;
	
	Search()
	{
		searchTeacher = new JFrame("Teacher Data");
		
		bnamef = new Font("POPPINS",Font.BOLD,30);
		font1 = new Font("POPPINS",Font.BOLD,18);
		font2 = new Font("POPPINS",Font.BOLD,16);
		
		//Labels 
		id = new JLabel("ID Number");id.setBounds(30,50,100,30);searchTeacher.add(id);id.setFont(font1);
		
		name = new JLabel("Name");name.setBounds(30,100,100,30);searchTeacher.add(name);name.setFont(font1);
		
		dob = new JLabel("Date of Birth");dob.setBounds(30,150,150,30);searchTeacher.add(dob);dob.setFont(font1);
		
		gender = new JLabel("Gender");gender.setBounds(30,200,100,30);searchTeacher.add(gender);gender.setFont(font1);
		
		phone = new JLabel("Phone Number");phone.setBounds(30,250,150,30);searchTeacher.add(phone);phone.setFont(font1);
		
		subject = new JLabel("Subject");subject.setBounds(30,300,100,30);searchTeacher.add(subject);subject.setFont(font1);
		
		qualification = new JLabel("Qualification");qualification.setBounds(30,350,150,30);searchTeacher.add(qualification);qualification.setFont(font1);
		
		address = new JLabel("Address");address.setBounds(30,400,100,30);searchTeacher.add(address);address.setFont(font1);
		
		salary = new JLabel("Salary");salary.setBounds(500,50,100,30);searchTeacher.add(salary);salary.setFont(font1);
		
		nofclasses = new JLabel("Number of Classes");nofclasses.setBounds(500,100,180,30);searchTeacher.add(nofclasses);nofclasses.setFont(font1);
		
		age = new JLabel("Age");age.setBounds(500,150,180,30);searchTeacher.add(age);age.setFont(font1);
		
		//Labels - 2
		id2 = new JLabel();id2.setBounds(190,50,200,30);searchTeacher.add(id2);id2.setFont(font1);id2.setForeground(Color.red);
				
		name2 = new JLabel();name2.setBounds(190,100,200,30);searchTeacher.add(name2);name2.setFont(font1);name2.setForeground(Color.red);
				
		dob2 = new JLabel();dob2.setBounds(190,150,200,30);searchTeacher.add(dob2);dob2.setFont(font1);dob2.setForeground(Color.red);
				
		gender2 = new JLabel();gender2.setBounds(190,200,200,30);searchTeacher.add(gender2);gender2.setFont(font1);gender2.setForeground(Color.red);
				
		phone2 = new JLabel();phone2.setBounds(190,250,200,30);searchTeacher.add(phone2);phone2.setFont(font1);phone2.setForeground(Color.red);
			
		subject2 = new JLabel();subject2.setBounds(190,300,200,30);searchTeacher.add(subject2);subject2.setFont(font1);subject2.setForeground(Color.red);
				
		qualification2 = new JLabel();qualification2.setBounds(190,350,200,30);searchTeacher.add(qualification2);qualification2.setFont(font1);qualification2.setForeground(Color.red);
				
		address2 = new JLabel();address2.setBounds(190,400,200,30);searchTeacher.add(address2);address2.setFont(font1);address2.setForeground(Color.red);
				
		salary2 = new JLabel();salary2.setBounds(600,50,200,30);searchTeacher.add(salary2);salary2.setFont(font1);salary2.setForeground(Color.red);
				
		nofclasses2 = new JLabel();nofclasses2.setBounds(700,100,200,30);searchTeacher.add(nofclasses2);nofclasses2.setFont(font1);nofclasses2.setForeground(Color.red);
		
		age2 = new JLabel();age2.setBounds(550,150,200,30);searchTeacher.add(age2);age2.setFont(font1);age2.setForeground(Color.red);
		/*
		 * DataBase Connectivity
		 */
		try
		{
			String url = "jdbc:mysql://localhost:3306/teacher_management_1";
			String user = "root";
			String password = "Prasanth@6";
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c = DriverManager.getConnection(url,user,password);
				
			Statement st1 = c.createStatement();
			Statement st2 = c.createStatement();
			
			String tdquery = 	"select * from teachers_data_1 where id = '"+id_num+"'" ;
			String csquery = 	"select Classes_Allocated,Salary from classes__allocated where id = '"+id_num+"'" ;

			ResultSet tdrs=st1.executeQuery(tdquery);
			ResultSet csrs=st2.executeQuery(csquery);
			
			if(tdrs.next())
			{
				id2.setText(tdrs.getString("id"));
				name2.setText(tdrs.getString("Name"));
				dob2.setText(tdrs.getString("DOB"));
				age2.setText(tdrs.getString("Age"));
				gender2.setText(tdrs.getString("Gender"));
				phone2.setText(tdrs.getString("Mobile"));
				subject2.setText(tdrs.getString("Subject"));
				qualification2.setText(tdrs.getString("Qualification"));
				address2.setText(tdrs.getString("Address"));
			}
			if(csrs.next())
			{
				nofclasses2.setText(csrs.getString("Classes_Allocated"));
				salary2.setText(csrs.getString("Salary"));
			}
			
			c.close();
		}catch(Exception e) {e.printStackTrace();}

		/*
		 * Button
		 */
		backbtn = new JButton("Back");backbtn.setBounds(100,500,80,30);searchTeacher.add(backbtn);backbtn.setFont(font2);
		/*backbtn.setBackground(Color.red);backbtn.setForeground(Color.white);*/backbtn.setVisible(true);
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				new LoginPage();
				searchTeacher.setVisible(false);
			}
		});
		searchTeacher.setSize(800,600);
		searchTeacher.setLayout(null);
		searchTeacher.setVisible(true);
		searchTeacher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
