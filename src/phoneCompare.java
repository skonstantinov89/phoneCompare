//FrameDemo2
//Demonstrates a simple frame with menus and a dialog box
//adds window listeners

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.Border;


@SuppressWarnings({ "serial", "unused" })
public class phoneCompare extends Applet implements WindowListener, ActionListener
 {
	
	Panel mainFrame = new Panel();
	Frame srav = new Frame("    Сравняване      ");
	String[] phones = {"Nokia", "Samsung", "LG"};
	
	String[] Nokia_model = {"X1", "N9", "N7"};
	String[] Samsung_model = {"Galaxy 3", "Galaxy ACE", "Note"};
	String[] LG_model = {"Prada", "Optimus 3D", "LTE2"};
	
	String[][] Models ={
			{"X1","Battery:1320mAh", "Display:1.26 inch", "Camera:None","Price:100"},
			{"N9","Battery:1400mAh", "Display:4.0 inch", "Camera:8.1","Price:800"},
			{"N7","Battery:1320mAh", "Display:3.26 inch", "Camera:None","Price:600"},
			{"Galaxy 3","Battery:2100mAh", "Display:4.8 inch", "Camera:8.1","Price:1300"},
			{"Note","Battery:2500mAh", "Display:5.0 inch", "Camera:8.1","Price:1000"},
			{"Galaxy ACE","Battery:1500mAh", "Display:4.0 inch", "Camera:5","Price:400"},
			{"Prada","Battery:1200mAh", "Display:3.0 inch", "Camera:3.2","Price:350"},
			{"Optimus 3D","Battery:1650mAh", "Display:4.3 inch", "Camera:8.1","Price:1100"},
			{"LTE2","Battery:2150mAh", "Display:4.8 inch", "Camera:12","Price:1400"}
			};


							//1,		2,		3,		4;
	String[][] Param= {
			{"X1",			"1320",		"1", 	"0",	"100"},	
			{"N9",			"1400", 	"4",	"8",	"800"},
			{"N7",			"1450",		"3",	"3",	"600"},
			{"Galaxy 3",	"2100", 	"4", 	"8",	"1300"},	
			{"Note",		"2500", 	"5",	"8",	"1000"},
			{"Galagy ACE",	"1500",		"4",	"5",	"400"},
			{"Prada",		"1200",		"3", 	"3",	"350"},	
			{"Optimus 3D",	"1650", 	"4", 	"8",	"1100"},
			{"LTE2",		"2150",		"12",	"8",	"1400"}
			};
	
				
	
	
	JComboBox	phone1 = new JComboBox(phones),
				model1= new JComboBox();
	
	JComboBox	phone2 = new JComboBox(phones),
				model2 = new JComboBox();
				
	Button compare = new Button("Сравняване!");
	
	
	Label lbl1_battery= new Label();
	Label lbl1_display= new Label();
	Label lbl1_camera= new Label();
	Label lbl1_price = new Label();
	
	Label lbl2_battery = new Label();
	Label lbl2_display = new Label();
	Label lbl2_camera = new Label();
	Label lbl2_price = new Label();
	
	Label lbl11_battery= new Label();
	Label lbl11_display= new Label();
	Label lbl11_camera= new Label();
	Label lbl11_price= new Label();
	
	Label lbl22_battery= new Label();
	Label lbl22_display= new Label();
	Label lbl22_camera= new Label();
	Label lbl22_price= new Label();
	
	Label lbl_score = new Label();

	Label mylbl = new Label("Choose some GSMs ");
	//Manage Score
	int score1=0, score2=0,score=0;;
	int p1=-1,p2=-1;
	
	public void init()
	{
		add(mylbl);

		mainFrame.setSize(300, 300);
		mainFrame.setLocation(200,200);

		mainFrame.setLayout(new GridLayout(5,0));

		mainFrame.add(phone1);

		mainFrame.add(model1);
		mainFrame.add(compare);
		phone1.addActionListener(this);
		compare.addActionListener(this);
		

			mainFrame.add(phone2);
			mainFrame.add(model2);
		phone2.addActionListener(this);
	
		phone2.addActionListener(this);
		add(mainFrame);

		srav.setLayout( new GridBagLayout());
		GridBagConstraints grid = new GridBagConstraints();
		
		Border blackline = BorderFactory.createLineBorder(Color.WHITE);
		
		grid.fill=GridBagConstraints.VERTICAL;
		grid.gridx=0;
		grid.gridy=0;
		grid.weightx=2;
		grid.weighty=1;
		//slaga elementa na (0,0)  v "tablicata" (grid-a)
		//lbl1_battery.setBorder(blackline);
		srav.add(lbl1_battery,grid);//bateriq1
		grid.fill=GridBagConstraints.VERTICAL;
		grid.gridx=1;
		grid.gridy=0;
		grid.weightx=2;
		grid.weighty=1;
		//slaga elementa na (0,1)
		srav.add(lbl2_battery,grid);//bateriq2
		grid.fill=GridBagConstraints.VERTICAL;
		grid.gridx=0;
		grid.gridy=1;
		grid.weightx=2;
		grid.weighty=1;
		srav.add(lbl1_display,grid);//display1
		grid.fill=GridBagConstraints.VERTICAL;
		grid.gridx=1;
		grid.gridy=1;
		grid.weightx=2;
		grid.weighty=1;
		srav.add(lbl2_display,grid);//display2
		grid.fill=GridBagConstraints.VERTICAL;		
		grid.gridx=0;
		grid.gridy=2;
		grid.weightx=2;
		grid.weighty=1;
		srav.add(lbl1_camera,grid);//camera1
		grid.fill=GridBagConstraints.VERTICAL;
		grid.gridx=1;
		grid.gridy=2;
		grid.weightx=2;
		grid.weighty=1;
		srav.add(lbl2_camera,grid);//camera2
		grid.fill=GridBagConstraints.VERTICAL;		
		grid.gridx=0;
		grid.gridy=3;
		grid.weightx=2;
		grid.weighty=1;
		srav.add(lbl1_price,grid);//price
		grid.fill=GridBagConstraints.VERTICAL;
		grid.gridx=1;
		grid.gridy=3;
		grid.weightx=2;
		grid.weighty=1;
		srav.add(lbl2_price,grid);//price2
		grid.fill=GridBagConstraints.VERTICAL;
		grid.gridx=0;
		grid.gridy=4;
		grid.weightx=5;
		grid.weighty=5;
		grid.ipadx=5;
		srav.add(lbl_score,grid);//price2
		
		
		
		//Params
		srav.addWindowListener(this);

		
	}
	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource() == phone1)
			{
			if( phone1.getSelectedItem() == "Nokia")
				{
					model1.removeAllItems();
					for(int i=0;i<3;i++)
						model1.addItem(Nokia_model[i]);
				}
			if( phone1.getSelectedItem() == "Samsung")
				{
					model1.removeAllItems();
					for(int i=0;i<3;i++)
						model1.addItem(Samsung_model[i]);
				}
				if( phone1.getSelectedItem() == "LG")
				{
					model1.removeAllItems();
					for(int i=0;i<3;i++)
						model1.addItem(LG_model[i]);
				}
			}
		if(e.getSource() == phone2)
			{
			if( phone2.getSelectedItem() == "Nokia")
				{
				model2.removeAllItems();
				for(int i=0;i<3;i++)
					model2.addItem(Nokia_model[i]);
				}
			if( phone2.getSelectedItem() == "Samsung")
				{
				model2.removeAllItems();
				for(int i=0;i<3;i++)
					model2.addItem(Samsung_model[i]);
				}
			if( phone2.getSelectedItem() == "LG")
				{
				model2.removeAllItems();
				for(int i=0;i<3;i++)
					model2.addItem(LG_model[i]);
				}
			}
		if(e.getSource() == compare)
			{
			
				srav.setVisible(true);
				srav.setSize(400,400);
				srav.setLocation(400,400);	
				lbl1_battery.setForeground(Color.BLACK);
				lbl2_battery.setForeground(Color.BLACK);
				lbl1_display.setForeground(Color.BLACK);
				lbl2_display.setForeground(Color.BLACK);
				lbl1_camera.setForeground(Color.BLACK);
				lbl2_camera.setForeground(Color.BLACK);
				score1=score2=score=0;
				
				for(int i=0;i<9;i++)
					{
					//	if(model1.equals(Models[i][0]))
					
					if(model1.getSelectedItem() == Models[i][0]) lbl1_battery.setText(Models[i][1]);
					if(model2.getSelectedItem() == Models[i][0]) lbl2_battery.setText(Models[i][1]);
					if(model1.getSelectedItem() == Models[i][0]) lbl1_display.setText(Models[i][2]);
					if(model2.getSelectedItem() == Models[i][0]) lbl2_display.setText(Models[i][2]);
					if(model1.getSelectedItem() == Models[i][0]) lbl1_camera.setText(Models[i][3]);
					if(model2.getSelectedItem() == Models[i][0]) lbl2_camera.setText(Models[i][3]);
					if(model1.getSelectedItem() == Models[i][0]) lbl1_price.setText(Models[i][4]);
					if(model2.getSelectedItem() == Models[i][0]) lbl2_price.setText(Models[i][4]);
					}

				for(int i=0;i<9;i++)
				{

				if (model1.getSelectedItem() == Param[i][0])
						{
							lbl11_battery.setText(Param[i][1]);
							lbl11_display.setText(Param[i][2]);
							lbl11_camera.setText(Param[i][3]);
							lbl11_price.setText(Param[i][4]);
						}
				}
				for (int i=0;i<9;i++)
				{	
					if (model2.getSelectedItem() == Param[i][0])
						{
							lbl22_battery.setText(Param[i][1]);
							lbl22_display.setText(Param[i][2]);
							lbl22_camera.setText(Param[i][3]);
							lbl22_price.setText(Param[i][4]);
						}
				}	
				Compare_models();
			}
		}

	public void windowClosing(WindowEvent e)
	 
	   {	
			if(e.getSource() == srav)
			{
				srav.setVisible(false);
				srav.dispose();
			}
		} 	// end window event
	public void Compare_models()
	{
		for(int i=0;i<9;i++)
		{
		if(model1.getSelectedItem() == Models[i][0]) p1=i;
		if(model2.getSelectedItem() == Models[i][0]) p2=i;
		}
		if(p1>-1 && p2>-1)
			{
			if(Integer.parseInt(Param[p2][1]) < Integer.parseInt(Param[p1][1]) )
				{
				lbl1_battery.setForeground(Color.BLUE);
				lbl2_battery.setForeground(Color.RED);
				score1+=2;
				}
			else 
				{
				lbl1_battery.setForeground(Color.RED);
				lbl2_battery.setForeground(Color.BLUE);
				score2+=2;
				}
			if(Integer.parseInt(Param[p2][2]) < Integer.parseInt(Param[p1][2]) ){
				lbl1_display.setForeground(Color.BLUE);
				lbl2_display.setForeground(Color.RED);
				score1+=2;
			}
			else{
				lbl1_display.setForeground(Color.RED);
				lbl2_display.setForeground(Color.BLUE);
				score2++;
			}
			
			if(Integer.parseInt(Param[p2][3]) < Integer.parseInt(Param[p1][3]) )
			{
				lbl1_camera.setForeground(Color.BLUE);
				lbl2_camera.setForeground(Color.RED);
				score1++;
			}
			else {
				lbl1_camera.setForeground(Color.RED);
				lbl2_camera.setForeground(Color.BLUE);
				score2++;
			}
			if(Integer.parseInt(Param[p2][4]) > Integer.parseInt(Param[p1][4]) ){
				lbl1_price.setForeground(Color.BLUE);
				lbl2_price.setForeground(Color.RED);
				score1++;
				}
			else {
				lbl1_price.setForeground(Color.RED);
				lbl2_price.setForeground(Color.BLUE);
				score2++;
			}
			if(score1>score2) { lbl_score.setText("По-добрия вариант е "+ phone1.getSelectedItem().toString()+ " "+model1.getSelectedItem().toString()+ " с резултат " + score1);}
			else {lbl_score.setText("По-добрия вариант е "+ phone2.getSelectedItem().toString()+ " "+model2.getSelectedItem().toString()+ " с резултат " + score2);}
			}
		else lbl_score.setText("Не са въведени 2 модела! ");
	}
		public void windowActivated(WindowEvent e){}
		public void windowClosed(WindowEvent e){}
		public void windowDeactivated(WindowEvent e){}
		public void windowDeiconified(WindowEvent e){}
		public void windowIconified(WindowEvent e){}
		public void windowOpened(WindowEvent e){}
 }
	