package Projekt;
import java.io.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

class FormFrame extends Frame implements ActionListener {
	//File-->
	File f;
	FileOutputStream fos;
	String str;
	char[] ch;
	//Frame-->
	Button submitB;
	Choice deptCh, admYrCh, secCh, genderCh;
	Label hL,emailL, selectDeptL, fullNameL, admYrL, secL, rollL, genderL, mobileL, permanentL;
	TextField emailTf, fullNameTf, rollTf, mobileTf, permanentTf;
	FormFrame(String s) throws Exception {

		super(s);
		setLayout(null);
		setSize(925,1050);	//width,height
		//file
		f = new File("D:\\Java Programs\\Java Eclipse\\EclipsePrograms\\IO files\\FormFrameFile.txt");
		fos = new FileOutputStream(f, false);
	
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
		deptCh.add("---select---");
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
		admYrCh.add("---select---");
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
		secCh.add("---select---");
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
		genderCh.add("---select---");
		genderCh.add("Male");
		genderCh.add("Female");

		//Student Mobile No *--> align
		mobileL = new Label("★ Student Mobile No:-");
		mobileL.setBounds(100, 690, 230, 30);
		mobileTf = new TextField("+91 ");
		mobileTf.setBounds(330, 690, 450, 30);
		
		//Permanent Address *-->align
		permanentL = new Label("★ Permanent Address:-");
		permanentL.setBounds(100, 740, 230, 30);
		permanentTf = new TextField();
		permanentTf.setBounds(330, 740, 450, 30);
		
		//Submit Button
		submitB = new Button("SUBMIT");
		submitB.setBounds(360, 850, 200, 60);
		//TODO: complete form --> design it --> file handling --> done
		
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
		add(mobileTf);//
		
		add(permanentL);//
		add(permanentTf);//
	
		add(submitB);//
		
		submitB.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == submitB) {
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
			
		}//end if(getSource() == submit)m
		
	}
}
//Applet
public class FormFrameFile extends Applet implements ActionListener {
	FormFrame ff;		//frame
	TextArea ta;
	Label l1, l2;
	Button FormBtn;
	public void init() {
		
		setLayout(null);
		setSize(1850, 1050);
		setBackground(Color.black);
		
		try {
			ff = new FormFrame("Admission Form");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		l1 = new Label("Prof. Ram Meghe Institute of Technology & Research");
		l1.setFont(new Font("Helvetica",Font.BOLD,50));
		l1.setForeground(Color.white);
		l1.setBounds(320, 50, 1600, 80);
		
		l2 = new Label("Provisional Admission Form (Only for Regular Students)");
		l2.setFont(new Font("Helvetica",Font.BOLD,40));
		l2.setForeground(Color.red);
		l2.setBounds(430, 200, 1100, 80);
		
		
		ta = new TextArea(" NOTE:-\n\n The students who have filled and submitted\n the Summer 2020 SGBAU Examination form\n are only eligible to fill the Provisional\n Admission Form for the Admission to the\n Higher Class.",8,40,TextArea.SCROLLBARS_NONE);	
		ta.setFont(new Font("Helvetica",Font.BOLD,25));
		ta.setBackground(Color.black);
		ta.setForeground(Color.white);
		ta.setEditable(false);
		ta.setBounds(660, 400, 560, 300);
		
		FormBtn = new Button("Fill Form");
		FormBtn.setFont(new Font("Helvetica",Font.BOLD,30));
		FormBtn.setBounds(850, 800, 200, 40);
		
		add(l1);
		add(l2);
		add(ta);
		add(FormBtn);
	
		FormBtn.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == FormBtn) {
			ff.setVisible(true);
		}
	}	
}
