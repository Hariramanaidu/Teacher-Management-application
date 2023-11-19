import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;
import java.util.*;
import java.sql.*;
public class ShowAllTeachers {
	
	public static JFrame showTeachers;
	public static JTable table;
	public static JButton showData,backbtn;
	public static JLabel title;
	JScrollPane sp;
	ShowAllTeachers()
	{
		showTeachers = new JFrame("Teachers Data");
		Font bnamef = new Font("POPPINS",Font.BOLD,25);
		title = new JLabel("Teachers Information"); title.setBounds(280,10,250,40);showTeachers.add(title);
		title.setFont(bnamef);title.setForeground(Color.red);
		table = new JTable();table.setBounds(50,50,670,450);showTeachers.add(table);
		showData = new JButton("Display Data");showData.setBounds(340,500,150,30);showTeachers.add(showData);
		showData.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
			{
				/*
				 * DataBase Connectivity and storing the data into MySql
				 */
				try
				{
					String url = "jdbc:mysql://localhost:3306/Teacher_Management_1";
					String user = "root";
					String password = "Prasanth@6";
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con = DriverManager.getConnection(url,user,password);
					Statement st = con.createStatement();
					String query = "select * from classes__allocated";
					ResultSet rs = st.executeQuery(query);
					
					ResultSetMetaData rsmd = rs.getMetaData();	
					
					DefaultTableModel model =(DefaultTableModel) table.getModel();
	  
					int cols = rsmd.getColumnCount();
					String[] colName = new String[cols];
					for(int i = 0;i < cols;i++)
						colName[i] = rsmd.getColumnName(i+1);
					
					model.setColumnIdentifiers(colName);
					
					String id,name,dob,nofclasses,subject,phone,salary;
					while(rs.next())
					{
						id = rs.getString(1);
						name = rs.getString(2);
						dob = rs.getString(3);
						nofclasses = rs.getString(4);
						subject = rs.getString(5);
						phone = rs.getString(6);
						salary = rs.getString(7);
						String[] row = {id,name,dob,nofclasses,subject,phone,salary};
						model.addRow(row);
					}
					st.close();
					con.close();
					showData.setEnabled(false);
				}
				catch(Exception e1){System.out.print(e1);}
				
			}
		});
		backbtn = new JButton("Back");backbtn.setBounds(100,500,80,30);showTeachers.add(backbtn);//backbtn.setFont(font2);
		/*backbtn.setBackground(Color.red);backbtn.setForeground(Color.white);*/backbtn.setVisible(true);
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				new LoginPage();
				showTeachers.setVisible(false);
			}
		});
		showTeachers.setSize(800,600);
		showTeachers.setLayout(null);
		showTeachers.setVisible(true);
		showTeachers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ShowAllTeachers();
	}

}
