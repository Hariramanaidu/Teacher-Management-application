import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;
import java.util.*;
import java.sql.*;

public class LoginPage 
{
	public static JFrame f;
	public static JTextField searchbar;
	public static JLabel name;
	public static Font bnamef,font1,font2;
	public static JButton sot,aat,ft,urt,dat,searchbtn;
	public static String id_num;
	LoginPage()
	{
		f = new JFrame("Teacher Management Application");
		
		bnamef = new Font("POPPINS",Font.BOLD,30);
		font1 = new Font("POPPINS",Font.BOLD,18);
		font2 = new Font("POPPINS",Font.BOLD,16);
		
		searchbar = new JTextField();searchbar.setBounds(280,100,240,35);f.add(searchbar);
		searchbtn = new JButton("search");searchbtn.setBounds(530, 100, 100,35);f.add(searchbtn);
		searchbtn.setFont(font2);
		
		searchbtn.addActionListener(ae ->
		{
			id_num = searchbar.getText();
			new Search();
			f.setVisible(false);
		});
		
		name = new JLabel("TEACHERS MANAGEMENT");name.setBounds(200,30,450,30);f.add(name);
		name.setFont(bnamef);name.setForeground(Color.red);
		
		//Show all Teachers Button
		sot = new JButton("Show all Teachers");sot.setBounds(300,150,200,40);f.add(sot);
		sot.setFont(font2);
		sot.addActionListener(ae ->
		{
			new ShowAllTeachers();
			f.setVisible(false);
		});
		//Add a Teacher Button
		aat = new JButton("Add a Teacher");aat.setBounds(300,200,200,40);f.add(aat);
		aat.setFont(font2);
		aat.addActionListener(ae ->
		{
			new AddTeacher();
			f.setVisible(false);
					
		});
		//Filter Teachers Button
		ft = new JButton("Filter Teachers");ft.setBounds(300,250,200,40);f.add(ft);
		ft.setFont(font2);
		ft.addActionListener(ae ->
		{
			new FilterTeachers();	
			f.setVisible(false);
		});
		//Update a Record of Teacher Button
		urt = new JButton("Update a Record");urt.setBounds(300,300,200,40);f.add(urt);
		urt.setFont(font2);
		urt.addActionListener(ae ->
		{
			new UpdateRecord();	
			f.setVisible(false);
		});
		//Delete a Teacher Button
		dat = new JButton("Delete Teacher");dat.setBounds(300,350,200,40);f.add(dat);
		dat.setFont(font2);
		dat.addActionListener(ae ->
		{
							
							
		});
		
		f.setSize(800,500);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LoginPage();
	}

}
