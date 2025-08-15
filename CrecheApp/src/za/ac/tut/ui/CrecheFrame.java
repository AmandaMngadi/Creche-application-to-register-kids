
package za.ac.tut.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class CrecheFrame extends JFrame{
    
  //create panel  
private JPanel inputPnl,namePnl,genderPnl,buttonsPnl,displayPnl;
// CREATE LABEL
private JLabel headingLbl,nameLbl,genderLbl;

// create radio buttons
private JRadioButton femaleRbt,maleRbt;
//create textfiled
private JTextField nameTxt;
//create buttons
private JButton registerBtn,displayBtn;
//create text area
private JTextArea displayArea;
private JScrollPane scrollPane;

private ButtonGroup genderGroup;
//create Storage
private ArrayList<Kid> kidsList;

    public CrecheFrame() {
        setTitle("CRECHE 4 YOUR KIDDIE");
        setSize(400,450);
        setLayout(new BorderLayout());
        setBackground(Color.BLUE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        kidsList = new ArrayList<>();

        
       //name panel
       namePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
       nameLbl = new JLabel("Name");
       nameTxt = new JTextField(15);
       namePnl.add(nameLbl);
       namePnl.add(nameTxt);
       
       //Gender
       genderPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
       genderLbl = new JLabel("Gender :");
       maleRbt = new JRadioButton("Male");
       femaleRbt = new JRadioButton("Female");
       genderGroup = new ButtonGroup();
        genderGroup.add(maleRbt);
        genderGroup.add(femaleRbt);
        genderPnl.add(genderLbl);
        genderPnl.add(maleRbt);
        genderPnl.add(femaleRbt);
       
       
       
       //Buttons 
       buttonsPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
       registerBtn = new JButton("Register kiddie");
       displayBtn = new JButton("Display Kiddies");
       buttonsPnl.add(registerBtn);
       buttonsPnl.add(displayBtn);
       
       registerBtn.addActionListener(new RegisterKiddieBtnHandler());
displayBtn.addActionListener(new DisplayKiddiesBtnHandler());

buttonsPnl.add(registerBtn);
buttonsPnl.add(displayBtn);

       //Input panel
       inputPnl = new JPanel();
       inputPnl.setLayout(new BoxLayout(inputPnl,BoxLayout.Y_AXIS));
       inputPnl.add(namePnl);
       inputPnl.add(genderPnl);
       inputPnl.add(buttonsPnl);
       
       //display part
       displayPnl = new JPanel(new BorderLayout());
       displayArea = new JTextArea(10,60);
       displayArea.setEditable(false);
       scrollPane = new JScrollPane(displayArea);
       displayPnl.add(scrollPane,BorderLayout.CENTER);
       
       
       add(inputPnl,BorderLayout.WEST);
       add(displayPnl,BorderLayout.SOUTH);
         
       
       
    
               
       setVisible(true);
    }
      private class RegisterKiddieBtnHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            Kid kiddie;
            String gender="";
            
            
            String name= nameTxt.getText();
            
            if(maleRbt.isSelected())
            {
                gender="male";
               
            }
            else if(femaleRbt.isSelected())
            {
                 gender="female";
                 
            }
             kiddie=new Kid(name,gender);
             kidsList.add(kiddie);
             
             nameTxt.setText("");
             genderGroup.clearSelection();
    }
    }
    
     private class DisplayKiddiesBtnHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
           
            StringBuilder sb=new StringBuilder();
            
            for(Kid kiddies1:kidsList)
            {
                sb.append(kiddies1.toString()).append("\n");
            }
            
            displayArea.setText(sb.toString());
    }    
    } 
    
    
}
