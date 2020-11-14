package Projekt;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

//**********pop up start*****************************
class filenotfound1 
{
	filenotfound1()
	{
		//pop-up: Class JOptionPane
				JOptionPane.showMessageDialog(null,"File Not Found!");
	}
}
class succesful_written1
{
	succesful_written1()
	{
		//pop-up: Class JOptionPane
				JOptionPane.showMessageDialog(null,"Saved Successfully!");
	}
}
//Wrong EMail
class popupWrongEmail1  
{
	popupWrongEmail1()
	{		//pop-up: Class JOptionPane
				JOptionPane.showMessageDialog(null,"Invalid Email Address!");
	}
}
//Wrong empty information
class popupEmptyInformation1 
{	
	popupEmptyInformation1()
	{
		//pop-up: Class JOptionPane
			JOptionPane.showMessageDialog(null,"Fill Empty Field/Fields!");
	}	
}//invalid mobile
class popupInvalidMobile1// extends Frame
{
	popupInvalidMobile1()
	{
		JOptionPane.showMessageDialog(null,"Invalid Mobile Number!");		
	}
}
class FileExists1  
{
	FileExists1()
	{		//pop-up: Class JOptionPane
				JOptionPane.showMessageDialog(null,"Form Already Exists!");
	}
}
//****************end pop-up**********************************



class FormDeleteFrame extends Frame implements ActionListener{		//form-delete frame
	
	String str;
	
	Label deleteL, deleteOutL;
	Button deleteB;
	TextField deleteFileTf, deleteOutTf;
	FormDeleteFrame(String s) {
		super(s);
		setLayout(null);
		setSize(925,1050);	//width - height
		setFont(new Font("Helvetica",Font.BOLD,40));
		setBackground(Color.black);
		setForeground(Color.white);
		
		//delete label
		deleteL = new Label("★ Enter ID To Delete Form:-");
		deleteL.setBounds(100, 220, 550, 50);
		
		deleteFileTf = new TextField();
		deleteFileTf.setForeground(Color.black);
		deleteFileTf.setBounds(100, 300, 650, 60);
		
		//delete button
		deleteB = new Button("DELETE");
		deleteB.setForeground(Color.black);
		deleteB.setBounds(100, 400, 300, 50);
		
		//deleted successfully
		deleteOutL = new Label("★ Form Status:-");
		deleteOutL.setBounds(100, 570, 550, 50);
		deleteOutTf = new TextField();	
		deleteOutTf.setBackground(Color.black);
		deleteOutTf.setEditable(false);
		//here color of status
		deleteOutTf.setBounds(100, 650, 650, 60);
		
		add(deleteL);
		add(deleteFileTf);
		
		add(deleteB);
		
		add(deleteOutL);
		add(deleteOutTf);
		
		deleteB.addActionListener(this);
		
		//close
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == deleteB) {
			
			str = deleteFileTf.getText();
			
			File f = new File("D:\\Java Programs\\Java Eclipse\\EclipsePrograms\\IO files\\"+str+".txt");
			if(deleteFileTf.getText().trim().isEmpty() == true) {
				deleteOutTf.setText("Invalid ID");
				deleteOutTf.setBackground(Color.black);
				deleteOutTf.setForeground(Color.blue);
			}
			else if(f.exists() == true && deleteFileTf.getText().trim().isEmpty() == false) {
				f.delete();
				deleteOutTf.setBackground(Color.black);
				deleteOutTf.setForeground(Color.GREEN);
				deleteOutTf.setText("Form Deleted");
				//pop-up: Class JOptionPane
				JOptionPane.showMessageDialog(null,"Successfully Deleted!");
				
				dispose();
				
				deleteFileTf.setText("");
				deleteOutTf.setText("");
			}
			else if(f.exists() == false && deleteFileTf.getText().trim().isEmpty() == false) {
				deleteOutTf.setBackground(Color.black);
				deleteOutTf.setForeground(Color.red);
				deleteOutTf.setText("Form Does Not Exist");
			}
			
		}
	}
}



class FormSearchFrame extends Frame implements ActionListener{		//form-search frame

	//file-->
	File fSearch;

	//frame
		TextField searchTf, searchOutTf;
		Label searchL, searchOutL;
		Button searchB;
		
	FormSearchFrame(String s){
		super(s);
		setLayout(null);
		setSize(925,1050);	//width - height
		setFont(new Font("Helvetica",Font.BOLD,40));
		setBackground(Color.black);
		setForeground(Color.white);
		//search
		searchL = new Label("★ Search Form By ID:-");
		searchL.setBounds(100, 220, 550, 50);
			
		searchTf = new TextField();
		searchTf.setForeground(Color.black);
		searchTf.setBounds(100, 300, 650, 60);
		
		//search btn
		searchB = new Button("SEARCH");
		searchB.setForeground(Color.black);
		searchB.setBounds(100, 400, 300, 50);
			
		//searchOutL
		searchOutL = new Label("★ Form Status:-");
		searchOutL.setBounds(100, 570, 550, 50);
		searchOutTf = new TextField();	
		searchOutTf.setBackground(Color.black);
		searchOutTf.setEditable(false);
		//here color of status
		searchOutTf.setBounds(100, 650, 650, 60);
			
		add(searchL);
		add(searchTf);
		add(searchB);
		
		add(searchOutL);
		add(searchOutTf);
			
	
		searchB.addActionListener(this);
		
		//close
				addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						dispose();
					}
				});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String str;
		str = searchTf.getText();
		fSearch = new File("D:\\Java Programs\\Java Eclipse\\EclipsePrograms\\IO files\\"+str+".txt");
		//************************************status color
		if(fSearch.exists() == true) {
			searchOutTf.setBackground(Color.black);
			searchOutTf.setForeground(Color.GREEN);
		}
		else {
			searchOutTf.setBackground(Color.black);
			searchOutTf.setForeground(Color.red);
		}
		//**************************************status color-end
		if(e.getSource() == searchB) {	
			
			if(searchTf.getText().trim().isEmpty() == true) {
				searchOutTf.setText("Invalid ID");
				searchOutTf.setBackground(Color.black);
				searchOutTf.setForeground(Color.blue);
			}
			else if(fSearch.exists() == true && searchTf.getText().trim().isEmpty() == false) {
				searchOutTf.setText("Form Available");
			}
			else if(fSearch.exists() == false && searchTf.getText().trim().isEmpty() == false) {
				searchOutTf.setText("Form Unavailable");
			}
		}		
	}
}
class FillFrame extends Frame implements ActionListener {

	//Frame-->
		Button submitB;
		Choice deptCh, admYrCh, secCh, genderCh;
		Label hL,emailL, selectDeptL, fullNameL, admYrL, secL, rollL, genderL, mobileL, permanentL;
		TextField emailTf, fullNameTf, rollTf, mobileT, mobileTf, permanentTf, savedSuccessTf;
	
		String emails, depts, fullNames, admYrs, secs, rolls, genders, mobiles, permanents;
		
		String is_email_valid="no";
		
		popupWrongEmail1 emailpopup;
	    popupEmptyInformation1 emptypopup;
	    popupInvalidMobile1 InvalidMobPop;
	    FileExists1 file;
	    succesful_written1 sw;
	    
		FillFrame(String s) throws Exception {
			super(s);
			setLayout(null);
			setSize(925,1050);	//width,height

			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					dispose();
				}
			});
			
			
			//headline
			hL = new Label("Provisional Admission Form");
			hL.setFont(new Font("Helvetica",Font.BOLD,50));
			hL.setBounds(100, 150, 900, 50);
			setFont(new Font("Helvetica",Font.PLAIN,20));			
			//email address--> align
			emailL = new Label("★ Email address:-");
			emailL.setBounds(100, 300, 200, 30);
			emailTf = new TextField();
			emailTf.setBounds(300, 300, 480, 30);
			
			//Select the Department *--->align
			selectDeptL = new Label("★ Select the Department:-");	
			selectDeptL.setBounds(100, 350, 250, 50);
			deptCh = new Choice();
			deptCh.setBounds(350, 360, 430, 50);
			//deptCh.add("---select---");
			deptCh.add("");
			deptCh.add("Computer Science Engineering");
			deptCh.add("Mechanical Engineering");
			deptCh.add("Information Technology");
			deptCh.add("Electronics & Telecommunication Engineering");
			deptCh.add("Civil Engineering");
			deptCh.add("MBA");
			deptCh.add("MCA");
			
			//Full Name:-->align
			fullNameL = new Label("★ Full Name:-");
			fullNameL.setBounds(100, 420, 150, 30);
			fullNameTf = new TextField();
			fullNameTf.setBounds(250, 420, 530, 30);
			
			//Seeking Provisional Admission to *:-->align
			admYrL  = new Label("★ Seeking Provisional Admission to:-");
			admYrL.setBounds(100, 480, 350, 30);
			admYrCh = new Choice();
			admYrCh.setBounds(450, 480, 330, 30);
			//admYrCh.add("---select---");
			admYrCh.add("");
			admYrCh.add("B.E II Year");
			admYrCh.add("B.E III Year");
			admYrCh.add("B.E IV Year");
			admYrCh.add("MCA II Year");
			admYrCh.add("MCA III Year");
			admYrCh.add("MBA II Year");
			admYrCh.add("M.E");		
			
			//Section *-->align
			secL = new Label("★ Section:-");
			secL.setBounds(100, 530, 130, 30);
			secCh = new  Choice();
			secCh.setBounds(230, 530, 550, 30);
			//secCh.add("---select---");
			secCh.add("");
			secCh.add("Section A");
			secCh.add("Section B");
			secCh.add("Secton C (Second Shift)");
			secCh.add("Other (MCA)");
			
			//Roll No *-->align
			rollL = new Label("★ Roll No:-");
			rollL.setBounds(100, 580, 130, 30);
			rollTf = new TextField();
			rollTf.setBounds(230, 580, 550, 30);
			
			//Gender:-->align
			genderL = new Label("★ Gender:-");
			genderL.setBounds(100, 640, 130, 30);
			genderCh = new Choice();
			genderCh.setBounds(230, 640, 550, 30);
			//genderCh.add("---select---");
			genderCh.add("");
			genderCh.add("Male");
			genderCh.add("Female");

			//Student Mobile No *--> align
			mobileL = new Label("★ Student Mobile No:-");
			mobileL.setBounds(100, 690, 230, 30);
			mobileT = new TextField("+91 "); //+91
			mobileT.setBounds(330, 690, 50, 30);      //+91
			mobileT.setEditable(false);
			mobileTf = new TextField();
			mobileTf.setBounds(380, 690, 400, 30);
			
			//Permanent Address *-->align
			permanentL = new Label("★ Permanent Address:-");
			permanentL.setBounds(100, 740, 230, 30);
			permanentTf = new TextField();
			permanentTf.setBounds(330, 740, 450, 30);
			
			//Submit Button
			submitB = new Button("SUBMIT");
			submitB.setBounds(360, 850, 200, 60);
			
			//saved-successTf
			savedSuccessTf = new TextField(" ★  All Fields Are Mandatory");
			savedSuccessTf.setEditable(false);
			savedSuccessTf.setBounds(325, 950, 275, 35);
			
			//
			add(hL);
			
			add(emailL);//
			add(emailTf);//
			
			add(selectDeptL);//
			add(deptCh); //
			
			add(fullNameL);//
			add(fullNameTf);//
			
			add(admYrL);//
			add(admYrCh);//
			
			add(secL);//
			add(secCh);//
			
			add(rollL);//
			add(rollTf);//
			
			add(genderL);//
			add(genderCh);//
			
			add(mobileL);//
			add(mobileT);
			add(mobileTf);//
			
			add(permanentL);//
			add(permanentTf);//
		
			add(submitB);//
			
			add(savedSuccessTf);
			
			submitB.addActionListener(this);
			
			
			
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String check_email=registerDriverCodeForEmail();
		String is_all_filled=registerDriverCodeForFields();
		String is_mob_valid=registerDriverCodeForInvalidMobile();
		
		if(e.getSource()==submitB);
		{
			emails = emailTf.getText();
			depts = deptCh.getSelectedItem();
			fullNames = fullNameTf.getText() ;
			admYrs = admYrCh.getSelectedItem();
			secs = secCh.getSelectedItem();
			rolls = rollTf.getText();
			genders = genderCh.getSelectedItem();
			mobiles = mobileTf.getText();
			permanents = permanentTf.getText();
			
			
			File student_data=new File("D:\\Java Programs\\Java Eclipse\\EclipsePrograms\\IO files\\"+rolls+".txt");
			if(is_all_filled=="no")	
			{
				emptypopup =new popupEmptyInformation1(); 
				
			}
			else if(check_email=="no")
			{
				emailpopup=new popupWrongEmail1();
			}
			else if(is_mob_valid=="no")
			{
				InvalidMobPop=new popupInvalidMobile1();
			}
			else if(student_data.exists())
			{
				file=new FileExists1();
			}
			else
			{	
				try
		    	{
				  student_data.createNewFile();
				  FileWriter filewriter=new FileWriter(student_data,true);
				  BufferedWriter writer=new BufferedWriter(filewriter);
				  writer.write(emailL.getText());
				  writer.write(emails);
				  writer.write("\r");
	              writer.write(selectDeptL.getText());
	              writer.write(depts);
	              writer.write("\r");
	              writer.write(fullNameL.getText());
	              writer.write(fullNames);
	              writer.write("\r");
	              writer.write(admYrL.getText());
	              writer.write(admYrs);
	              writer.write("\r");
	              writer.write(secL.getText());
	              writer.write(secs);
	              writer.write("\r");
	              writer.write(rollL.getText());
	              writer.write(rolls);
	              writer.write("\r");
	              writer.write(genderL.getText());
	              writer.write(genders);
	              writer.write("\r");
	              writer.write(mobileL.getText());
	              writer.write(mobileT.getText());
	              writer.write(mobiles);
	              writer.write("\r");
	              writer.write(permanentL.getText());
	              writer.write(permanents);
	              writer.write("\r");

	              writer.flush();
	              writer.close();
	              filewriter.flush();
	              filewriter.close();	              


	              writer.write("\r");
	              writer.flush();
	              writer.close();
	              filewriter.flush();
	              filewriter.close();
			    }
				catch(IOException ae)
				{
				}	
				sw=new succesful_written1();
				emailTf.setText("");
				deptCh.add("");
				fullNameTf.setText("");
				admYrCh.add("");
				secCh.add("");
				rollTf.setText("");
				genderCh.add("");
				mobileTf.setText("");
				permanentTf.setText("");
				
				
				dispose();
   
			}

		}
		
	}
	/*
	 * Register driver code for field check
	 */
	String registerDriverCodeForFields()
	{   String is_all_filled;
	    if(emailTf.getText().isEmpty())	//email
		{
			is_all_filled="no";
		}
	    else if(deptCh.getSelectedItem().isEmpty())		//dept
	    {
	    	is_all_filled="no";
	    }else if(fullNameTf.getText().isEmpty())		//fname
	    {
	    	is_all_filled="no";
	    }else if(admYrCh.getSelectedItem().isEmpty())	//adm yr
	    {
	    	is_all_filled="no";
	    }else if(secCh.getSelectedItem().isEmpty())	//section
	    {
	    	is_all_filled="no";
	    }else if(rollTf.getText().isEmpty())		//roll
	    {
	    	is_all_filled="no";
	    }else if(genderCh.getSelectedItem().isEmpty())		//gender
	    {
	    	is_all_filled="no";
	    }else if(mobileTf.getText().isEmpty())		//mobile
	    {
	    	is_all_filled="no";
	    }
	    else if(permanentTf.getText().isEmpty())		//address
	    {
	    	is_all_filled="no";
	    }else
	    {
	    	is_all_filled="else";
	    }
	    
		return is_all_filled;
	}
	String registerDriverCodeForEmail() 
	{
		/*
		 * Email validation
		 */
			Pattern entered=Pattern.compile("^[\\w-\\.+]*[\\w-\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$",Pattern.CASE_INSENSITIVE);
			Matcher required=entered.matcher(emailTf.getText());
			if(required.find())
			{
				is_email_valid="yes";
			}	
			else
			{
				is_email_valid="no";
			}
		return is_email_valid;
	}

	/*
	 * Register driver code for invalid mobile
	 */
	String registerDriverCodeForInvalidMobile()
	{
		String is_mob_valid;
		Pattern entered=Pattern.compile("^\\d{10}$",Pattern.CASE_INSENSITIVE);
		Matcher required=entered.matcher(mobileTf.getText());
		if(required.find())
		{
		is_mob_valid="yes";
		}
		else
		{
			is_mob_valid="no";
		}
		return is_mob_valid;
	}
	/*
	 * RegisterDrivercode for Invalid alt mobile number
	 */
   String registerDriverCodeForInvalitAltMob()
   {
	   String is_altmob_valid;
		Pattern entered=Pattern.compile("^\\d{10}$",Pattern.CASE_INSENSITIVE);
		Matcher required=entered.matcher(mobileTf.getText());
		if(required.find())
		{
		is_altmob_valid="yes";
		}
		else
		{
			is_altmob_valid="no";
		}
		return is_altmob_valid;
   }
} 
//Applet---------------->
public class FormFrameFile extends Applet implements ActionListener {	//applet
	
	//frame
	FillFrame fillframe;
	FormSearchFrame fsf;
	FormDeleteFrame fdf;
	
	TextArea ta;
	Label l1, l2;
	Button fillFrameB, SearchBtn, DeleteBtn, UpdateBtn;
	public void init() {
		
		setLayout(null);
		setSize(1850, 1050);
		setBackground(Color.black);
		
		try {
			fillframe = new FillFrame("Fill Student Admission Form");	//fill form
		} catch (Exception e) {
		}
		try {
			fsf = new FormSearchFrame("Search Form");		//search form cons
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fdf = new FormDeleteFrame("Delete Form");		//delete form cons
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Applet contents----------------------------------->
		l1 = new Label("Prof. Ram Meghe Institute of Technology & Research");
		l1.setFont(new Font("Helvetica",Font.BOLD,50));
		l1.setForeground(Color.white);
		l1.setBounds(320, 50, 1600, 80);
		
		l2 = new Label("Provisional Admission Form (Only for Regular Students)");
		l2.setFont(new Font("Helvetica",Font.BOLD,40));
		l2.setForeground(Color.red);
		l2.setBounds(430, 150, 1100, 80);
		
		ta = new TextArea("\n The students who have filled and submitted\n the Summer 2020 SGBAU Examination form\n are only eligible to fill the Provisional\n Admission Form for the Admission to the\n Higher Class.\n\n Note:- Your details will get stored in a file\n (File Name is your Roll No.)",8,40,TextArea.SCROLLBARS_NONE);	
		ta.setFont(new Font("Helvetica",Font.BOLD,25));
		ta.setBackground(Color.black);
		ta.setForeground(Color.white);
		ta.setEditable(false);
		ta.setBounds(660, 300, 560, 300);
		
		//button-form applet
		fillFrameB = new Button("Fill Form");
		fillFrameB.setFont(new Font("Helvetica",Font.BOLD,30));
		fillFrameB.setBounds(660, 700, 200, 40);
		
		//button-search
		SearchBtn = new Button("Search Form");
		SearchBtn.setFont(new Font("Helvetica",Font.BOLD,30));
		SearchBtn.setBounds(1020, 700, 200, 40);
		
		//button-delete
		DeleteBtn = new Button("Delete Form");
		DeleteBtn.setFont(new Font("Helvetica",Font.BOLD,30));
		DeleteBtn.setBounds(660, 800, 200, 40);
		
		//button-update
		UpdateBtn = new Button("Update Form");
		UpdateBtn.setFont(new Font("Helvetica",Font.BOLD,30));
		UpdateBtn.setBounds(1020, 800, 200, 40);
		
		
		add(l1);
		add(l2);
		add(ta);
	
		add(fillFrameB);
		add(SearchBtn);
		add(DeleteBtn);
		add(UpdateBtn);
		
		//registration
		fillFrameB.addActionListener(this);
		SearchBtn.addActionListener(this);
		DeleteBtn.addActionListener(this);
		UpdateBtn.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == fillFrameB) {
			
			fillframe.setVisible(true);
		}
		else if(e.getSource() == SearchBtn) {
			fsf.setVisible(true);				//form search
		}
		else if(e.getSource() == DeleteBtn) {
			fdf.setVisible(true);				//form delete
		}
	}	
}


