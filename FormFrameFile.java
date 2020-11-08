package Projekt;

import java.io.*;
import javax.swing.JOptionPane;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

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
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == deleteB) {
			
			str = deleteFileTf.getText();
			
			File f = new File("D:\\Java Programs\\Java Eclipse\\EclipsePrograms\\IO files\\"+str+".txt");
			
			if(f.exists() == true) {
				f.delete();
				deleteOutTf.setBackground(Color.black);
				deleteOutTf.setForeground(Color.GREEN);
				deleteOutTf.setText("Form Deleted");
			}
			else if(f.exists() == false) {
				deleteOutTf.setBackground(Color.black);
				deleteOutTf.setForeground(Color.red);
				deleteOutTf.setText("File Does Not Exist");
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
						System.exit(0);
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
			if(fSearch.exists() == true) {
				searchOutTf.setText("File Available");
			}
			else if(fSearch.exists() == false) {
				searchOutTf.setText("File Unavailable");
			}
		}		
	}
}
class FormFrame extends Frame implements ActionListener {			//form fill frame
	//File-->
	File f;
	FileOutputStream fos;
	String str;
	char[] ch;
	//Frame-->
	Button submitB;
	Choice deptCh, admYrCh, secCh, genderCh;
	Label hL,emailL, selectDeptL, fullNameL, admYrL, secL, rollL, genderL, mobileL, permanentL;
	TextField emailTf, fullNameTf, rollTf, mobileT, mobileTf, permanentTf, savedSuccessTf;
	FormFrame(String s) throws Exception {

		super(s);
		setLayout(null);
		setSize(925,1050);	//width,height

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
		//TODO: complete form --> design it --> file handling --> done
		
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
		
		//********************************************************************************************************close
				addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String sureRoll;
		sureRoll = rollTf.getText();
		
		f = new File("D:\\Java Programs\\Java Eclipse\\EclipsePrograms\\IO files\\"+sureRoll+".txt");
		try {
			fos = new FileOutputStream(f, false);
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		// TODO Auto-generated method stub
		if(e.getSource() == submitB) {
			
			if(emailTf.getText().trim().isEmpty() == false && deptCh.getSelectedItem().trim().isEmpty() == false && fullNameTf.getText().trim().isEmpty() == false && admYrCh.getSelectedItem().trim().isEmpty() == false && secCh.getSelectedItem().trim().isEmpty() == false && rollTf.getText().trim().isEmpty() == false && genderCh.getSelectedItem().trim().isEmpty() == false && mobileTf.getText().trim().isEmpty() == false && permanentTf.getText().trim().isEmpty() == false) {
				//email Label 
				str = emailL.getText();
				ch = str.toCharArray();
				for(int i=0; i<str.length(); i++) {
					try {
						fos.write(ch[i]);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				//email
				str = emailTf.getText();
				ch = str.toCharArray();
				for(int i=0; i<str.length(); i++) {
					try {
						fos.write(ch[i]);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}		
				//space1
				try {
					fos.write('\n');
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//selectDeptL
				str = selectDeptL.getText();
				ch = str.toCharArray();
				for(int i=0; i<str.length(); i++) {
					try {
						fos.write(ch[i]);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				//deptCh
				str = deptCh.getSelectedItem();
				ch = str.toCharArray();
				for(int i=0; i<str.length(); i++) {
					try {
						fos.write(ch[i]);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				//space2
				try {
					fos.write('\n');
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//fullNameL
				str = fullNameL.getText();
				ch = str.toCharArray();
				for(int i=0; i<str.length(); i++) {
					try {
						fos.write(ch[i]);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				//fullNameTf
				str = fullNameTf.getText();
				ch = str.toCharArray();
				for(int i=0; i<str.length(); i++) {
					try {
						fos.write(ch[i]);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				//space3
				try {
					fos.write('\n');
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//admYrL
				str = admYrL.getText();
				ch = str.toCharArray();
				for(int i=0; i<str.length(); i++) {
					try {
						fos.write(ch[i]);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				//admYrCh
				str = admYrCh.getSelectedItem();
				ch = str.toCharArray();
				for(int i=0; i<str.length(); i++) {
					try {
						fos.write(ch[i]);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				//space4
				try {
					fos.write('\n');
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//secL
				str = secL.getText();
				ch = str.toCharArray();
				for(int i=0; i<str.length(); i++) {
					try {
						fos.write(ch[i]);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				//secCh
				str = secCh.getSelectedItem();
				ch = str.toCharArray();
				for(int i=0; i<str.length(); i++) {
					try {
						fos.write(ch[i]);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				//space5
				try {
					fos.write('\n');
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//rollL
				str = rollL.getText();
				ch = str.toCharArray();
				for(int i=0; i<str.length(); i++) {
					try {
						fos.write(ch[i]);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				//rollTf
				str = rollTf.getText();
				ch = str.toCharArray();
				for(int i=0; i<str.length(); i++) {
					try {
						fos.write(ch[i]);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				//space6
				try {
					fos.write('\n');
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//genderL
				str = genderL.getText();
				ch = str.toCharArray();
				for(int i=0; i<str.length(); i++) {
					try {
						fos.write(ch[i]);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				//genderCh
				str = genderCh.getSelectedItem();
				ch = str.toCharArray();
				for(int i=0; i<str.length(); i++) {
					try {
						fos.write(ch[i]);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				//space7
				try {
					fos.write('\n');
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//mobileL
				str = mobileL.getText();
				ch = str.toCharArray();
				for(int i=0; i<str.length(); i++) {
					try {
						fos.write(ch[i]);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				//mobileT
				str = mobileT.getText();
				ch = str.toCharArray();
				for(int i=0; i<str.length(); i++) {
					try {
						fos.write(ch[i]);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				//mobileTf
				str = mobileTf.getText();
				ch = str.toCharArray();
				for(int i=0; i<str.length(); i++) {
					try {
						fos.write(ch[i]);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				//space8
				try {
					fos.write('\n');
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//permanentL
				str = permanentL.getText();
				ch = str.toCharArray();
				for(int i=0; i<str.length(); i++) {
					try {
						fos.write(ch[i]);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				//permanentTf
				str = permanentTf.getText();
				ch = str.toCharArray();
				for(int i=0; i<str.length(); i++) {
					try {
						fos.write(ch[i]);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				//space9
				try {
					fos.write('\n');
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				//saved success
				savedSuccessTf.setText(" ★  Thank You!");	

				//pop-up: Class JOptionPane
				JOptionPane.showMessageDialog(null,"Successfully Saved!");
				//exit: close everything
				System.exit(0);
			}
			//all fields are empty
			else if(emailTf.getText().trim().isEmpty() == true && deptCh.getSelectedItem().trim().isEmpty() == true && fullNameTf.getText().trim().isEmpty() == true && admYrCh.getSelectedItem().trim().isEmpty() == true && secCh.getSelectedItem().trim().isEmpty() == true && rollTf.getText().trim().isEmpty() == true && genderCh.getSelectedItem().trim().isEmpty() == true && mobileTf.getText().trim().isEmpty() == true && permanentTf.getText().trim().isEmpty() == true){
				savedSuccessTf.setText(" ★  All Fields Are Mandatory");	
			}
			//some fields aren't empty
			else {
				
				if(emailTf.getText().trim().isEmpty() == true) {	//email
					savedSuccessTf.setText(" ★  Enter Email Id");
				}
				else if(deptCh.getSelectedItem().trim().isEmpty() == true) {	//dept
					savedSuccessTf.setText(" ★  Select Your Department");
				}
				else if(fullNameTf.getText().trim().isEmpty() == true) {	//full name
					savedSuccessTf.setText(" ★  Enter Your Name");
				}
				else if(admYrCh.getSelectedItem().trim().isEmpty() == true) { //adm yr
					savedSuccessTf.setText(" ★  Select Admission Year");
				}
				else if(secCh.getSelectedItem().trim().isEmpty() == true) {	//section
					savedSuccessTf.setText(" ★  Select Your Section");
				}
				else if(rollTf.getText().trim().isEmpty() == true) {	//roll no
					savedSuccessTf.setText(" ★  Enter Your Roll No.");
				}
				else if(genderCh.getSelectedItem().trim().isEmpty() == true) {	//gender
					savedSuccessTf.setText(" ★  Select Your Gender");
				}
				else if(mobileTf.getText().trim().isEmpty() == true) {	//mobile
					savedSuccessTf.setText(" ★  Enter Your Contact No.");
				}
				else if(permanentTf.getText().trim().isEmpty() == true) {	//address
					savedSuccessTf.setText(" ★  Enter Your Address");
				}
			}
		}//end if(getSource() == submit)m
	}
}
//Applet---------------->
public class FormFrameFile extends Applet implements ActionListener {	//applet
	
	//frame
	FormFrame ff;
	FormSearchFrame fsf;
	FormDeleteFrame fdf;
	
	TextArea ta;
	Label l1, l2;
	Button FormBtn, SearchBtn, DeleteBtn, UpdateBtn;
	public void init() {
		
		setLayout(null);
		setSize(1850, 1050);
		setBackground(Color.black);
		
		try {
			ff = new FormFrame("Admission Form");		//fill form cons
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fsf = new FormSearchFrame("Form: Search Form");		//search form cons
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fdf = new FormDeleteFrame("Form: Delete Form");		//delete form cons
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
		FormBtn = new Button("Fill Form");
		FormBtn.setFont(new Font("Helvetica",Font.BOLD,30));
		FormBtn.setBounds(660, 700, 200, 40);
		
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
	
		add(FormBtn);
		add(SearchBtn);
		add(DeleteBtn);
		add(UpdateBtn);
		
		//registration
		FormBtn.addActionListener(this);
		SearchBtn.addActionListener(this);
		DeleteBtn.addActionListener(this);
		UpdateBtn.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == FormBtn) {
			ff.setVisible(true);				//form fill
		}
		else if(e.getSource() == SearchBtn) {
			fsf.setVisible(true);				//form search
		}
		else if(e.getSource() == DeleteBtn) {
			fdf.setVisible(true);				//form delete
		}
	}	
}
