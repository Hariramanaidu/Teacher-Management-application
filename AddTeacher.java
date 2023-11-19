import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;
import java.util.*;
import java.sql.*;
public class AddTeacher implements ActionListener{
	
	public JFrame addTeacher;
	public JLabel id,name,dob,age,phone,mailid,gender,subject,qualification,address,mail;
	public JLabel idE,nameE,dobE,ageE,phoneE,mailidE,genderE,subjectE,qualificationE,addressE,mailE;
	public static Font bnamef,font1,font2;
	public static JTextField idt,namet,dobt,aget,phonet,mailidt,subjectt,qualificationt,addresst,mailt;
	ButtonGroup bg;
	JRadioButton male,female,other;
	public static JButton backbtn,adddatabtn;
	String sname,sdob,ssubject,sgender,squalification,saddress,sid,sage,sphone,smail;
	
	AddTeacher()
	{
		addTeacher = new JFrame("Adding new Teacher");
		
		bnamef = new Font("POPPINS",Font.BOLD,30);
		font1 = new Font("POPPINS",Font.BOLD,18);
		font2 = new Font("POPPINS",Font.BOLD,16);
		
		//Labels
		id = new JLabel("ID Number");id.setBounds(30,50,100,30);addTeacher.add(id);id.setFont(font1);
		
		name = new JLabel("Name");name.setBounds(30,100,100,30);addTeacher.add(name);name.setFont(font1);
		
		dob = new JLabel("Date of Birth");dob.setBounds(30,150,150,30);addTeacher.add(dob);dob.setFont(font1);
		
		age = new JLabel("Age");age.setBounds(380,150,150,30);addTeacher.add(age);age.setFont(font1);
		
		gender = new JLabel("Gender");gender.setBounds(30,200,100,30);addTeacher.add(gender);gender.setFont(font1);
		
		phone = new JLabel("Phone Number");phone.setBounds(30,250,150,30);addTeacher.add(phone);phone.setFont(font1);
		
		subject = new JLabel("Subject");subject.setBounds(30,300,100,30);addTeacher.add(subject);subject.setFont(font1);
		
		qualification = new JLabel("Qualification");qualification.setBounds(30,350,150,30);addTeacher.add(qualification);qualification.setFont(font1);
		
		address = new JLabel("Address");address.setBounds(30,400,100,30);addTeacher.add(address);address.setFont(font1);
		
		mail = new JLabel("Mail ID");mail.setBounds(30,450,100,30);addTeacher.add(mail);mail.setFont(font1);
		
		//TextFields
		idt = new JTextField();idt.setBounds(190,50,150,30);addTeacher.add(idt);idt.setFont(font1);
				
		namet = new JTextField();namet.setBounds(190,100,250,30);addTeacher.add(namet);namet.setFont(font1);
				
		dobt = new JTextField();dobt.setBounds(190,150,150,30);addTeacher.add(dobt);dobt.setFont(font1);
		
		aget = new JTextField();aget.setBounds(450,150,150,30);addTeacher.add(aget);aget.setFont(font1);
		
		phonet = new JTextField();phonet.setBounds(190,250,150,30);addTeacher.add(phonet);phonet.setFont(font1);
				
		subjectt = new JTextField();subjectt.setBounds(190,300,150,30);addTeacher.add(subjectt);subjectt.setFont(font1);
				
		qualificationt = new JTextField();qualificationt.setBounds(190,350,150,30);addTeacher.add(qualificationt);qualificationt.setFont(font1);
				
		addresst = new JTextField();addresst.setBounds(190,400,250,30);addTeacher.add(addresst);addresst.setFont(font1);
		
		mailt = new JTextField();mailt.setBounds(190,450,250,30);addTeacher.add(mailt);mailt.setFont(font1);
		
		//Error Labels
		idE = new JLabel("Enter ID Number(4digits)");idE.setBounds(190,74,200,20);addTeacher.add(idE);idE.setForeground(Color.red);
		idE.setVisible(false);	
		
		nameE = new JLabel("Enter the Name");nameE.setBounds(190,127,150,20);addTeacher.add(nameE);nameE.setForeground(Color.red);
		nameE.setVisible(false);
		
		dobE = new JLabel("Enter the DOB(DD-MM-YYYY)");dobE.setBounds(190,180,200,20);addTeacher.add(dobE);dobE.setForeground(Color.red);
		dobE.setVisible(false);
		
		ageE = new JLabel("Enter your Age");ageE.setBounds(450,180,150,20);addTeacher.add(ageE);ageE.setForeground(Color.red);
		ageE.setVisible(false);
		
		genderE = new JLabel("Select your Gender");genderE.setBounds(190,223,150,20);addTeacher.add(genderE);genderE.setForeground(Color.red);
		genderE.setVisible(false);	
		
		phoneE = new JLabel("Enter your Phone Number");phoneE.setBounds(190,280,150,20);addTeacher.add(phoneE);phoneE.setForeground(Color.red);
		phoneE.setVisible(false);
		
		subjectE = new JLabel("Enter the Subject");subjectE.setBounds(190,330,150,20);addTeacher.add(subjectE);subjectE.setForeground(Color.red);
		subjectE.setVisible(false);	
		
		qualificationE = new JLabel("Enter your Qualification");qualificationE.setBounds(190,380,150,20);addTeacher.add(qualificationE);qualificationE.setForeground(Color.red);
		qualificationE.setVisible(false);
		
		addressE = new JLabel("Enter your Address");addressE.setBounds(190,430,150,20);addTeacher.add(addressE);addressE.setForeground(Color.red);
		addressE.setVisible(false);
		
		mailE = new JLabel("Enter valid mail");mailE.setBounds(190,480,150,20);addTeacher.add(mailE);mailE.setForeground(Color.red);
		mailE.setVisible(false);
		/*
		 * Radio Buttons Male,Female,others
		 */
		bg = new ButtonGroup();
		male = new JRadioButton("Male");male.setBounds(190,200,60,30);bg.add(male);addTeacher.add(male);
		male.setFont(font2);
		
		female = new JRadioButton("Female");female.setBounds(260,200,90,30);
		bg.add(female);addTeacher.add(female);female.setFont(font2);
		
		other = new JRadioButton("Other");other.setBounds(350,200,70,30);bg.add(other);
		addTeacher.add(other);other.setFont(font2);
		/*
		 * Buttons
		 */
		backbtn = new JButton("Back");backbtn.setBounds(100,500,80,30);addTeacher.add(backbtn);backbtn.setFont(font2);
		/*backbtn.setBackground(Color.red);backbtn.setForeground(Color.white);*/backbtn.setVisible(true);
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				new LoginPage();
				addTeacher.setVisible(false);
			}
		});
		
		adddatabtn = new JButton("Add");adddatabtn.setBounds(500,500,80,30);addTeacher.add(adddatabtn);adddatabtn.setFont(font2);
		/*backbtn.setBackground(Color.red);backbtn.setForeground(Color.white);*/adddatabtn.setVisible(true);
		adddatabtn.addActionListener(this);
		//new ActionListener() {
//			public void actionPerformed(ActionEvent ae)
//			{
//				
//			}
//		});
		
		addTeacher.setSize(800,600);
		addTeacher.setLayout(null);
		addTeacher.setVisible(true);
		addTeacher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*
	 * Implementing the Check button 
	 */
	public void actionPerformed(ActionEvent ae)
	{
		/*
		 * pattern Matching for Characters and Numbers
		 */
		Pattern names = Pattern.compile("[A-Za-z]+");
		sname = namet.getText();
		Matcher mnames = names.matcher(sname);
		
		Pattern pid = Pattern.compile("[1-9][0-9]{3}");
		sid = idt.getText();
		Matcher mid = pid.matcher(sid);
		//checking the id number
		if(idt.getText().length() == 4 && mid.find())
		{
			sid = idt.getText();
			idE.setVisible(false);
			System.out.println(sid);
		}
		else { idE.setVisible(true);}
		// checking name field
		if(namet.getText().length() !=0 && mnames.find())
		{
			sname = (namet.getText()).toUpperCase();
			nameE.setVisible(false);
			System.out.println(sname);
		}
		else{ nameE.setVisible(true);}//nameE.setText("Enter your Name");	}
		
		// checking Gender is Selected or Not
		if(male.isSelected() || female.isSelected() || other.isSelected())
		{
//			genderErr.setText("");
			if(male.isSelected())
			{
				sgender = male.getText();
			}
			if(female.isSelected())
			{
				sgender = female.getText();
			}
			if(other.isSelected())
			{
				sgender = other.getText();
			}
			genderE.setVisible(false);
			System.out.println(sgender);
		}
		else{ genderE.setVisible(true);	}//genderErr.setText("Please select your Gender");	}
		
		
		// checking  Date of Birth and pattern matching
		Pattern pDOB = Pattern.compile("[0-9]{2}[-][0-9]{2}[-][1-2][0-9]{3}");
		sdob = dobt.getText();
		Matcher mDOB = pDOB.matcher(sdob);
		
		if(dobt.getText().length() == 10 && mDOB.find())
		{
//			bDOB = true;
			sdob = dobt.getText();
			dobE.setVisible(false);
			System.out.println(sdob);
//			DOBErr.setText("");
		}
		else{ dobE.setVisible(true);	}//DOBErr.setText("Please Enter  Valid Date of Birth");	}
		
        // check Age
		Pattern page = Pattern.compile("[0-9]?[1-9]{2}");
		sage = aget.getText();
		Matcher mage = page.matcher(sage);
		//checking the id number
		if(aget.getText().length() <=3 && mage.find())
		{
			sage = aget.getText();
			ageE.setVisible(false);
			System.out.println(sage);
		}else { ageE.setVisible(true);}
		//checking phone number
		Pattern pphn = Pattern.compile("[6-9]{1}[0-9]{9}");
		sphone = phonet.getText();
		Matcher mphone = pphn.matcher(sphone);
		if(phonet.getText().length() == 10 && mphone.find())
		{
			sphone = phonet.getText();
			phoneE.setVisible(false);
			System.out.println(sphone);
		}else { phoneE.setVisible(true);}
		
		// checking subject field
		ssubject = subjectt.getText();
		mnames = names.matcher(ssubject);
		if(subject.getText().length() !=0 && mnames.find())
		{
			ssubject = (subjectt.getText()).toUpperCase();
			subjectE.setVisible(false);
			System.out.println(ssubject);
		}
		else{ subjectE.setVisible(true);}//nameE.setText("Enter your Name");	}
		
		// checking Qualification field
		squalification = qualificationt.getText();
		mnames = names.matcher(squalification);
		if(qualificationt.getText().length() !=0 && mnames.find())
		{
			squalification = (qualificationt.getText()).toUpperCase();
			qualificationE.setVisible(false);
			System.out.println(squalification);
		}
		else{ qualificationE.setVisible(true);}//nameE.setText("Enter your Name");	}
		
		// checking Address field
		saddress = addresst.getText();
		mnames = names.matcher(saddress);
		if(addresst.getText().length() !=0 && mnames.find())
		{
			saddress = (addresst.getText()).toUpperCase();
			addressE.setVisible(false);
			System.out.println(saddress);
		}
		else{ addressE.setVisible(true);}//nameE.setText("Enter your Name");	}
		
		// checking  Mail and Matching the some pattern
		Pattern pmail = Pattern.compile("[a-zA-Z0-9_-]+@[a-z]+[.][a-z]{2,3}");
		Matcher mmail = pmail.matcher(mailt.getText());
		int flag = 0;
		if(mailt.getText().length() !=0 && mmail.find())
		{
			smail = mailt.getText();
			flag = 1;
			mailE.setVisible(false);
		}
		else{	mailE.setVisible(true); flag = 0;	}
	
		//invoking submit button if all conditions r passed
//		if(		(namet.getText().length() !=0)	
//			&&	(male.isSelected() || female.isSelected() || other.isSelected())
//			&&	(dobt.getText().length() == 10 )
//			&&  (phonet.getText().length() != 0 )
//		  )
//		{
//			password.setVisible(true);
//			tpassword.setVisible(true);
//			confirmpassword.setVisible(true);
//			tconfirmpassword.setVisible(true);
//			spass = tpassword.getText();
//			scpass = tconfirmpassword.getText();
//			mailErr.setText("");
//			
//			if((spass.length() != 0) && (scpass.length() != 0))
//			{
//				if(scpass.equals(spass))
//				{
//					scpassword = scpass.trim();
//					String msg = "Are u sure about your giving Data,if u click YES there is no more Editable Option";
//					int a = JOptionPane.showConfirmDialog(fbac,msg);
//					if(a == JOptionPane.YES_OPTION)
//					{
//						submit.setVisible(true);
//						reset.setVisible(true);
//						tname.setEditable(false);
//						taccount_number.setEditable(false);
//						taadhaar.setEditable(false);
//						male.setEnabled(false);
//						female.setEnabled(false);
//						other.setEnabled(false);
//						tcountry.setEditable(false);
//						tpincode.setEditable(false);
//						tDOB.setEditable(false);
//						tmail.setEditable(false);
//						thouseno.setEditable(false);
//						tstreet.setEditable(false);
//						tarea_loc.setEditable(false);
//						tvillage_t_c.setEditable(false);
//						tlandmark.setEditable(false);
//						tdistrict.setEditable(false);
//						tstate.setEditable(false);
//						
//						tnoname.setEditable(false);
//						tnomobile.setEditable(false);
//						tnoaadhar.setEditable(false);
//						tnoprofession.setEditable(false);
//						tnocountry.setEditable(false);
//						tnoarea.setEditable(false);
//						
//						tpassword.setEditable(false);
//						tconfirmpassword.setEditable(false);
//						check.setVisible(false);
//						
//						branches.setEditable(false);
//					}
//				}
//				else 
//				{	
//					submit.setVisible(false);
//					reset.setVisible(false);
//					
//					JOptionPane.showMessageDialog(fbac,"Password NOT Matching","Alert",JOptionPane.WARNING_MESSAGE);
//				}
//			}
//		}
//		else
//		{
//			password.setVisible(false);
//			tpassword.setVisible(false);
//			confirmpassword.setVisible(false);
//			tconfirmpassword.setVisible(false);
//		}	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AddTeacher();
	}

}
