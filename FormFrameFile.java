package Projekt;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*
 * 
 * Section:- Dialog Box
 * 
 * 
 */
class filenotfound1 
{
	filenotfound1()
	{
		/*
		 * 
		 * Form doesn't exists!
		 * 
		 */
		//pop-up: Class JOptionPane
				JOptionPane.showMessageDialog(null,"Form Doesn't Exists!");
	}
}
class succesful_written1
{
	succesful_written1()
	{
		/*
		 * 
		 * Form saved successfully!
		 * 
		 */
		//pop-up: Class JOptionPane
				JOptionPane.showMessageDialog(null,"Saved Successfully!");
	}
}
//Wrong EMail
class popupWrongEmail1  
{
	/*
	 * 
	 * check email: @/./com if not Invalid!
	 * 
	 */
	popupWrongEmail1()
	{		//pop-up: Class JOptionPane
				JOptionPane.showMessageDialog(null,"Invalid Email Address!");
	}
}
//Wrong empty information
class popupEmptyInformation1 
{	
	/*
	 * 
	 * Empty Text Fields!
	 * 
	 */
	popupEmptyInformation1()
	{
		//pop-up: Class JOptionPane
			JOptionPane.showMessageDialog(null,"Fill Empty Field/Fields!");
	}	
}//invalid mobile
class popupInvalidMobile1// extends Frame
{
	/*
	 * 
	 * 
	 * 10 digits compulsory or invalid number
	 * 
	 */
	popupInvalidMobile1()
	{
		JOptionPane.showMessageDialog(null,"Invalid Mobile Number!");		
	}
}
class FileExists1  
{
	/*
	 * 
	 * Form Exists with same id!
	 * 
	 */
	FileExists1()
	{		//pop-up: Class JOptionPane
				JOptionPane.showMessageDialog(null,"Form Already Exists!");
	}
}
/*
 * 
 * End:- Dialog Box
 * 
 * 
 */
class View_Forms extends Frame implements ActionListener{		// View Forms #1
	
	Button viewB;
	TextArea ta;
	File file_directory;
	View_Forms(String s) throws Exception {
		super(s);
		setLayout(null);
		setSize(925,1050);	//width,height
		setFont(new Font("serif",Font.BOLD,30));
		setBackground(Color.black);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		ta = new TextArea();
		ta.setBounds(200, 200, 500, 500);
		ta.setEditable(false);
		ta.setBackground(Color.black);
		ta.setForeground(Color.white);
		ta.setVisible(false);
		add(ta);
		
		
	      
	    viewB = new Button("VIEW");
	    viewB.setBounds(200, 100, 500, 50);
	    add(viewB);
	    viewB.addActionListener(this);
	    
	}
	
@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	file_directory = new File("D:\\Java Programs\\Java Eclipse\\EclipsePrograms\\IO files");
	//List of all files and directories
	String contents[] = file_directory.list();
		if(e.getSource() == viewB) {
			ta.setVisible(true);
			
			for(int i=0; i<contents.length; i++) {
		         ta.append(contents[i]+"\n");
		      }
			
		}
	}
}




class Update_Info extends Frame implements ActionListener//,ItemListener		//update information	##3		
{
	
	String email, dept, fname, adm, sec, roll, gender, mobile, address;
	
	Button submitB;
	Choice deptCh, admYrCh, secCh, genderCh;
	Label hL,emailL, selectDeptL, fullNameL, admYrL, secL, rollL, genderL, mobileL, permanentL;
	TextField emailTf, fullNameTf, rollTf, mobileT, mobileTf, permanentTf, savedSuccessTf;
    
	String is_email_valid="no";
    
	String filemain; 
    File change_data;
    
    /*
     * dialog box objects
     */
    popupWrongEmail1 emailpopup;
    popupEmptyInformation1 emptypopup;
    popupInvalidMobile1 InvalidMobPop;
   // FileExists1 file;
    succesful_written1 sw;

	Update_Info(int bemail, int bdept, int bfname, int badm, int bsec, int broll, int bgender, int bmobile, int baddress, String framename, String file_name) throws Exception {
		// TODO Auto-generated constructor stub
		super("Re-Submit Form "+file_name+".txt");
		setLayout(null);
		setSize(925,1050);	//width,height
		filemain = file_name;
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
		mobileT = new TextField("+91"); //+91
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
		submitB.setFont(new Font("serif",Font.BOLD,30));
		submitB.setBounds(325, 850, 275, 50);
		
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
		
		//setting textfields to editable
		//true or false
		if(bemail == 1) {
			emailTf.setEditable(true);
		}else {
			emailTf.setEditable(false);
		}
		if(bdept == 1) {
			deptCh.setEnabled(true);
		}else {
			deptCh.setEnabled(false);
		}
		if(bfname == 1) {
			fullNameTf.setEditable(true);
		}else {
			fullNameTf.setEditable(false);
		}
		if(badm == 1) {
			admYrCh.setEnabled(true);
		}else {
			admYrCh.setEnabled(false);
		}
		if(bsec == 1) {
			secCh.setEnabled(true);
		}else {
			secCh.setEnabled(false);
		}
		if(broll == 1) {
			rollTf.setEditable(true);
		}else {
			rollTf.setEditable(false);
		}
		if(bgender == 1) {
			genderCh.setEnabled(true);
		}else {
			genderCh.setEnabled(false);
		}
		if(bmobile == 1) {
			mobileTf.setEditable(true);
		}else {
			mobileTf.setEditable(false);
		}
		if(baddress == 1) {
			permanentTf.setEditable(true);
		}else {
			permanentTf.setEditable(false);
		}	
		
		//file
		change_data = new File("D:\\Java Programs\\Java Eclipse\\EclipsePrograms\\IO files\\"+file_name+".txt");
		
		String str;
		try {
			FileReader fr = new FileReader(change_data);
			BufferedReader br = new BufferedReader(fr);
			/*
			 * 
			 * HERE:  write from .txt to text fields
			 * 
			 * 
			 */
			while((str=br.readLine())!=null)			
			{
				if(str.contains("★ Email address:-")){//email
					
		  			String[] a=str.split("-",2);
		  			emailTf.setText(a[1]);
				}
				if(str.contains("★ Select the Department:-")){//dept
					
		  			String[] a=str.split("-",2);
		  			deptCh.select(a[1]);
				}
				if(str.contains("★ Full Name:-")){//name
					
		  			String[] a=str.split("-",2);
		  			fullNameTf.setText(a[1]);
				}
				if(str.contains("★ Seeking Provisional Admission to:-")){	//adm yr
	
					String[] a=str.split("-",2);
					admYrCh.select(a[1]);
				}
				if(str.contains("★ Section:-")){	//section
	
					String[] a=str.split("-",2);	
					secCh.select(a[1]);
				}
				if(str.contains("★ Roll No:-")){	//roll
	
					String[] a=str.split("-",2);
					rollTf.setText(a[1]);
				}
				if(str.contains("★ Gender:-")){	//gender
					
					String[] a=str.split("-",2);
					genderCh.select(a[1]);
				}
				if(str.contains("★ Student Mobile No:-")){	//mob no
	
					String[] a=str.split("1",2);
					mobileTf.setText(a[1]);
				}
				if(str.contains("★ Permanent Address:-")){
					
					String[] a=str.split("-",2);
					permanentTf.setText(a[1]);
				}
			}		
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.print(e1);
		}
		
	
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
				
				
				if(e.getSource()==submitB);
				{
					
					String check_email=registerDriverCodeForEmail();
					String is_all_filled=registerDriverCodeForFields();
					String is_mob_valid=registerDriverCodeForInvalidMobile();
					
				//	if(e.getSource()==submitB) {
						
					email = emailTf.getText();
					dept = deptCh.getSelectedItem();
					fname = fullNameTf.getText() ;
					adm = admYrCh.getSelectedItem();
					sec = secCh.getSelectedItem();
					roll = rollTf.getText();
					gender = genderCh.getSelectedItem();
					mobile = mobileTf.getText();
					address = permanentTf.getText();
					
					
					File student_data=new File("D:\\Java Programs\\Java Eclipse\\EclipsePrograms\\IO files\\"+filemain+".txt");
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
					}else {
						try
				    	{
						 // student_data.createNewFile();
						  FileWriter filewriter=new FileWriter(student_data,false);
						  BufferedWriter writer=new BufferedWriter(filewriter);
						  writer.write(emailL.getText());
						  writer.write(email);
						  writer.write("\r");
			              writer.write(selectDeptL.getText());
			              writer.write(dept);
			              writer.write("\r");
			              writer.write(fullNameL.getText());
			              writer.write(fname);
			              writer.write("\r");
			              writer.write(admYrL.getText());
			              writer.write(adm);
			              writer.write("\r");
			              writer.write(secL.getText());
			              writer.write(sec);
			              writer.write("\r");
			              writer.write(rollL.getText());
			              writer.write(roll);
			              writer.write("\r");
			              writer.write(genderL.getText());
			              writer.write(gender);
			              writer.write("\r");
			              writer.write(mobileL.getText());
			              writer.write(mobileT.getText());
			              writer.write(mobile);
			              writer.write("\r");
			              writer.write(permanentL.getText());
			              writer.write(address);
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
						dispose();
					}
	
				}		
	}

	//here
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
	
}//ctrl+shift+p
class Update_Radio extends Frame implements ActionListener,ItemListener {			//TODO: here update ##2
	Label task;
	Checkbox email, dept, fname, adm, sec, roll, gender, mobile, address;
	Button submit;
	int bemail=0, bdept=0, bfname=0, badm=0, bsec=0, broll=0, bgender=0, bmobile=0, baddress=0;
	String file_name;
	Update_Radio(String s){
		super("Update Form "+s+".txt");
		file_name= s;

		setSize(1000,1000);
		setLayout(null);
		setBackground(Color.black);
		setForeground(Color.white);
		setFont(new Font("serif",Font.BOLD,30));
		addWindowListener(new WindowAdapter() {
			 
	    	 public void windowClosing(WindowEvent e)
		 {
			 dispose();
		 }
	    });
		task=new Label(":: Select The Field/Fields You Want To Update ::",Label.CENTER);
		task.setBounds(100, 70, 800, 40);
		
		email = new Checkbox(" Email Address",false);
		email.setBounds(100, 150, 300, 30);
		
		dept=new Checkbox(" Department",false);
		dept.setBounds(100, 200, 300, 30);
		
		fname=new Checkbox(" Full Name",false);
		fname.setBounds(100, 250, 300, 30);
		
		adm=new Checkbox(" Provisional Admission Year",false);
		adm.setBounds(100, 300, 400, 30);
		
		sec=new Checkbox(" Section",false);
		sec.setBounds(100, 350, 300, 30);
		
		roll=new Checkbox(" Roll Number [Uneditable]",false);
		roll.setBounds(100, 400, 400, 30);
		roll.setEnabled(false);
		
		gender=new Checkbox(" Gender",false);
		gender.setBounds(100, 450,300, 30);
		
		mobile=new Checkbox(" Mobile Number",false);
		mobile.setBounds(100, 500, 300, 30);
		
		address=new Checkbox(" Address",false);
		address.setBounds(100, 550, 300, 30);
		
		submit = new Button("PROCEED");
		submit.setForeground(Color.black);
		submit.setBounds(250, 650, 300, 50);
		
	
		
		add(task);
		add(email);
		add(dept);
		add(fname);
		add(adm);
		add(sec);
		add(roll);
		add(gender);
		add(mobile);
		add(address);
		add(submit);
		
		email.addItemListener(this);
		dept.addItemListener(this);
		fname.addItemListener(this);
		adm.addItemListener(this);
		sec.addItemListener(this);
		roll.addItemListener(this);
		gender.addItemListener(this);
		mobile.addItemListener(this);
		address.addItemListener(this);
		submit.addActionListener(this);
		
		
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if(e.getSource() == email) {
			if(email.getState() == true) {
				this.bemail = 1;
			}else {
				this.bemail = 0;
			}
		}
		if(e.getSource() == dept) {
			if(dept.getState() == true) {
				this.bdept = 1;
			}else {
				this.bdept = 0;
			}			
		}
		if(e.getSource() == fname) {
			if(fname.getState() == true) {
				this.bfname = 1;
			}else {
				this.bfname = 0;
			}
		}
		if(e.getSource() == adm) {
			if(adm.getState() == true) {
				this.badm = 1;
			}
			else {
				this.badm = 0;
			}
		}
		if(e.getSource() == sec) {
			if(sec.getState() == true) {
				this.bsec = 1;
			}else {
				this.bsec = 0;
			}
		}
		if(e.getSource() == roll) {
			if(roll.getState() == true) {
				this.broll = 1;
			}else {
				this.broll = 0;
			}
		}
		if(e.getSource() == gender) {
			if(gender.getState() == true) {
				this.bgender = 1;
			}else {
				this.bgender = 0;
			}
		}
		if(e.getSource() == mobile) {
			if(mobile.getState() == true) {
				this.bmobile = 1;
			}else {
				this.bmobile = 0;
			}
		}
		if(e.getSource() == address) {
			if(address.getState() == true) {
				this.baddress = 1;
			}else {
				this.baddress = 0;
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == submit) {
			Update_Info u = null;
			try {
				u = new Update_Info(this.bemail,this.bdept,this.bfname,this.badm,this.bsec,this.broll,this.bgender,this.bmobile,this.baddress,"Write the change",file_name);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			u.setVisible(true);
		}
	}
}
class FormUpdateFrame extends Frame implements ActionListener {				//TODO: here update ##1

	Label filename;
    TextField tfilename;
    Button find;
	Update_Radio updateRadio;	//class obj
	String name="";
	popupEmptyInformation1 p1;
	filenotfound1 fnf;
	FormUpdateFrame(String string) {				
		super(string);
		
		setBackground(Color.black);
		
		addWindowListener(new WindowAdapter() {
			
	    	 public void windowClosing(WindowEvent e)
		 {
			 dispose();
		 }
	    });
		setFont(new Font("serif",Font.BOLD,30)); 
		setLayout(null);
		setSize(1000,1000);
		
		filename=new Label(":: Enter Your Student ID ::");
		filename.setForeground(Color.red);
		
		tfilename=new TextField();
		tfilename.setFont(new Font("serif",Font.BOLD,30)); 

		
		find=new Button("UPDATE");
		
		filename.setBounds(320,350,900,90);
		
		tfilename.setBounds(350,450,300,40);
		
		find.setBounds(350,500,300,50);
		
		add(filename);
		
		add(tfilename);
		
		add(find);
		
		
		find.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==find)//
		{
			name=tfilename.getText();	//
			File student_data=new File("D:\\Java Programs\\Java Eclipse\\EclipsePrograms\\IO files\\"+name+".txt");//
			if(student_data.exists() == true)//
			{
				updateRadio =new Update_Radio(name);	
				updateRadio.setVisible(true);
				tfilename.setText("");
			}
			else if(name.isEmpty())
			{
				 p1=new popupEmptyInformation1();
				 tfilename.setText("");
				
			}
			else if(student_data.exists() == false)
			{
				fnf=new filenotfound1();
				tfilename.setText("");
			}
			
		}
}
	
}


class FormDeleteFrame extends Frame implements ActionListener{		//form-delete frame
	
	String str;
	
	Label deleteL, deleteOutL;
	Button deleteB;
	TextField deleteFileTf, deleteOutTf;
	FormDeleteFrame(String s) {
		super(s);
		setLayout(null);
		setSize(925,1050);	//width - height
		setFont(new Font("serif",Font.BOLD,30));
		setBackground(Color.black);
		setForeground(Color.white);
		
		//delete label
		deleteL = new Label("★ Enter ID To Delete Form:-");
		deleteL.setBounds(100, 220, 550, 50);
		
		deleteFileTf = new TextField();
		deleteFileTf.setForeground(Color.black);
		deleteFileTf.setBounds(100, 300, 650, 50);
		
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
		deleteOutTf.setBounds(100, 650, 650, 50);
		
		add(deleteL);
		add(deleteFileTf);
		
		add(deleteB);
		
		add(deleteOutL);
		add(deleteOutTf);
		
		deleteB.addActionListener(this);
		
		//close
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				deleteFileTf.setText("");
				deleteOutTf.setText("");
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
		Button searchB, OpenB;
		
	FormSearchFrame(String s){
		super(s);
		setLayout(null);
		setSize(925,1050);	//width - height
		setFont(new Font("serif",Font.BOLD,30));
		setBackground(Color.black);
		setForeground(Color.white);
		//search
		searchL = new Label("★ Search Form By ID:-");
		searchL.setBounds(100, 220, 550, 50);
			
		searchTf = new TextField();
		searchTf.setForeground(Color.black);
		searchTf.setBounds(100, 300, 650, 50);
		
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
		searchOutTf.setBounds(100, 650, 650, 50);
			
		//open B
		OpenB = new Button("OPEN");
		OpenB.setBounds(100, 750, 300, 60);
		OpenB.setForeground(Color.black);
		
		add(searchL);
		add(searchTf);
		add(searchB);
		
		add(searchOutL);
		add(searchOutTf);
			
		add(OpenB);
	
		searchB.addActionListener(this);
		OpenB.addActionListener(this);
		//close
				addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						searchTf.setText("");
						searchOutTf.setText("");
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
		/*if(fSearch.exists() == true) {
			searchOutTf.setBackground(Color.black);
			searchOutTf.setForeground(Color.GREEN);
		}
		else {
			searchOutTf.setBackground(Color.black);
			searchOutTf.setForeground(Color.red);
		}*/
		//**************************************status color-end
		if(e.getSource() == searchB) {	
			
			if(searchTf.getText().trim().isEmpty() == true) {
				searchOutTf.setText("Invalid ID");
				searchOutTf.setBackground(Color.black);
				searchOutTf.setForeground(Color.blue);
			}
			else if(fSearch.exists() == true && searchTf.getText().trim().isEmpty() == false) {
				searchOutTf.setText("Form Available");
				searchOutTf.setBackground(Color.black);
				searchOutTf.setForeground(Color.GREEN);
				
				
				
			}
			else if(fSearch.exists() == false && searchTf.getText().trim().isEmpty() == false) {
				searchOutTf.setText("Form Unavailable");
				searchOutTf.setBackground(Color.black);
				searchOutTf.setForeground(Color.red);
			}
		}
		if(e.getSource() == OpenB && searchOutTf.getText().isEmpty() == false) {
			
			if(!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not  
			{  
			System.out.println("not supported");  
			return;  
			}  
			Desktop desktop = Desktop.getDesktop();  
			if(fSearch.exists()) {
				try {
					desktop.open(fSearch);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}              //opens the specified file 
			}
				 
			
		}
	}
}
/*
 * 
 * Section: Fill Form On Frame
 * Store in .txt file with file name equals to roll no.
 * 
 */
class FillFrame extends Frame implements ActionListener {															//form fill #1

	//Frame-->
		Button submitB;
		Choice deptCh, admYrCh, secCh, genderCh;
		Label hL,emailL, selectDeptL, fullNameL, admYrL, secL, rollL, genderL, mobileL, permanentL;
		TextField emailTf, fullNameTf, rollTf, mobileT, mobileTf, permanentTf, savedSuccessTf;
	
		String emails, depts, fullNames, admYrs, secs, rolls, genders, mobiles, permanents;
		
		String is_email_valid="no";
		
		/*
		 * dialog boxes for further use
		 */
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
			mobileT = new TextField("+91"); //+91
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
			submitB.setFont(new Font("serif",Font.BOLD,30));
			submitB.setBounds(325, 850, 275, 50);
			
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
	public void actionPerformed(ActionEvent e) {//
		/*
		 * 
		 * 1. check email first
		 * 2. fields filled
		 * 3. mobile validity [10 digits]
		 * 
		 * will return "no" if false 
		 * 
		 */
		
		
		if(e.getSource()==submitB);
		{
			/*
			 * when user clicks submit 
			 * 
			 */
			String check_email=registerDriverCodeForEmail();
			String is_all_filled=registerDriverCodeForFields();
			String is_mob_valid=registerDriverCodeForInvalidMobile();
			
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
				admYrCh.add("");		//TODO: HERE it isn't showing "" in choice
				secCh.add("");
				rollTf.setText("");
				genderCh.add("");
				mobileTf.setText("");
				permanentTf.setText("");
				
				
				dispose();
   
			}

		}
		
	}//
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
/*
 * 
 * Section: Applet
 * contains: Applet Components with Frame Objects
 * 
 */
public class FormFrameFile extends Applet implements ActionListener {	//applet
	
	/*
	 * frames to link with applet
	 */
	FillFrame fillframe;
	FormSearchFrame fsf;
	FormDeleteFrame fdf;
	FormUpdateFrame fuf;
	View_Forms vf;
	
	/*
	 * 
	 * other components
	 */
	TextArea ta;
	Label l1, l2;
	Button fillFrameB, SearchBtn, DeleteBtn, UpdateBtn;
	Button ViewBtn;
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
		try {
			fuf = new FormUpdateFrame("Update Form");			//update form
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*try {
			vf = new View_Forms("View Forms");					//view forms
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//Applet contents----------------------------------->
		
		//title 1
		l1 = new Label("Prof. Ram Meghe Institute of Technology & Research");
		l1.setFont(new Font("Helvetica",Font.BOLD,50));
		l1.setForeground(Color.white);
		l1.setBounds(320, 50, 1600, 80);
		//title 2
		l2 = new Label("Provisional Admission Form (Only for Regular Students)");
		l2.setFont(new Font("serif",Font.BOLD,40));
		l2.setForeground(Color.red);
		l2.setBounds(430, 150, 1100, 80);
		
		//textarea on applet
		ta = new TextArea("\n The students who have filled and submitted\n the Summer 2020 SGBAU Examination form\n are only eligible to fill the Provisional\n Admission Form for the Admission to the\n Higher Class.\n\n Note:- Your details will get stored in a file\n (File Name is your Roll No.)",8,40,TextArea.SCROLLBARS_NONE);	
		ta.setFont(new Font("serif",Font.BOLD,25));
		ta.setBackground(Color.black);
		ta.setForeground(Color.white);
		ta.setEditable(false);
		ta.setBounds(660, 300, 560, 300);
		
		
		//button-form applet
		fillFrameB = new Button("FILL FORM");
		fillFrameB.setFont(new Font("serif",Font.BOLD,25));
		fillFrameB.setBounds(660, 650, 200, 40);
		
		//button-search
		SearchBtn = new Button("SEARCH FORM");
		SearchBtn.setFont(new Font("serif",Font.BOLD,25));
		SearchBtn.setBounds(1020, 650, 200, 40);
		
		//button-delete
		DeleteBtn = new Button("DELETE FORM");
		DeleteBtn.setFont(new Font("serif",Font.BOLD,25));
		DeleteBtn.setBounds(660, 750, 200, 40);
		
		//button-update
		UpdateBtn = new Button("UPDATE FORM");
		UpdateBtn.setFont(new Font("serif",Font.BOLD,25));
		UpdateBtn.setBounds(1020, 750, 200, 40);
		
		//button-view forms
		ViewBtn = new Button("SUBMISSIONS");
		ViewBtn.setFont(new Font("serif",Font.BOLD,25));
		ViewBtn.setBounds(840, 850, 200, 40);

		
		add(l1);
		add(l2);
		add(ta);
	
		
		add(fillFrameB);
		add(SearchBtn);
		add(DeleteBtn);
		add(UpdateBtn);
		add(ViewBtn);
		
		/*
		 * Frame buttons registration
		 */
		fillFrameB.addActionListener(this);
		SearchBtn.addActionListener(this);
		DeleteBtn.addActionListener(this);
		UpdateBtn.addActionListener(this);
		ViewBtn.addActionListener(this);
	}
	/*
	 * 
	 * Method of Interface ActionListener
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == fillFrameB) {		//form: fill#1
			
			fillframe.setVisible(true);
		}
		else if(e.getSource() == SearchBtn) {
			fsf.setVisible(true);				//form: search
		}
		else if(e.getSource() == DeleteBtn) {
			fdf.setVisible(true);				//form: delete
		}
		else if(e.getSource() == UpdateBtn) {		//form: update
			fuf.setVisible(true);
		}
		else if(e.getSource() == ViewBtn) {		//form: view
		
			 
			try {
				vf = new View_Forms("View Forms");
				vf.setVisible(true);
	      	
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}	
}
/*
 * 
 * End: Applet
 * 
 * 
 */

