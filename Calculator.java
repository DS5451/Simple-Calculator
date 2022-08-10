package Calculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {

	
     JTextField top = new JTextField();
     	JButton decimal  = new JButton(".");
	 	JButton zero = new JButton("0");
	 	JButton one = new JButton("1");  
     	JButton two = new JButton("2");  
     	JButton three = new JButton("3");  
     	JButton four = new JButton("4");  
     	JButton five = new JButton("5");  
     	JButton six = new JButton("6");  
     	JButton seven = new JButton("7");  
     	JButton eight = new JButton("8");  
        JButton nine = new JButton("9");  
        JButton addition = new JButton("+");  
        JButton multiplication = new JButton("*"); 
        JButton subtraction = new JButton("-");  
        JButton division = new JButton("/"); 
        JButton equal = new JButton("=");
        JButton CE = new JButton("CE");
        JButton C = new JButton("C");
        JButton per = new JButton("%");
        JButton negpos = new JButton("+/-");
        JButton[] misc = {C, CE};
        JButton[] buttons = {zero, one, two, three, four, five, six, seven, eight, nine, negpos, per};
        JButton[] ops = {addition, multiplication, subtraction, division};
        Double[] inputs = {null, null};
        int counter = 0;
        int negposC = 0;
        String op = "";
        double answer;
        
        
        public Calculator(){
	
		JFrame frame = new JFrame();
	   
        		
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        panel.setLayout(new GridLayout(5,2));
        JPanel BOX = new JPanel();
        BOX.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        BOX.setLayout(new GridLayout(1,1));
        BOX.add(top); 
        
        
        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);
        zero.addActionListener(this);
        addition.addActionListener(this);
        division.addActionListener(this);
        subtraction.addActionListener(this);
        multiplication.addActionListener(this);
        equal.addActionListener(this);
        C.addActionListener(this);
        CE.addActionListener(this);
        negpos.addActionListener(this);
        decimal.addActionListener(this);
        per.addActionListener(this);
        
        panel.add(seven);
        panel.add(eight);
        panel.add(nine);
        panel.add(division);
        panel.add(four);
        panel.add(five);
        panel.add(six);
        panel.add(multiplication);
        panel.add(three);
        panel.add(two);
        panel.add(one);
        panel.add(subtraction);
        panel.add(zero);
        panel.add(addition);
        panel.add(decimal);
       	panel.add(per);
       	panel.add(addition);
        panel.add(CE);
       	panel.add(C);
       	panel.add(negpos);
       	panel.add(equal);
       
       
        frame.add(panel, BorderLayout.CENTER);
        frame.add(BOX, BorderLayout.BEFORE_FIRST_LINE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Calculator");
        frame.pack();
        frame.setVisible(true);
        
        

    }
     
   public static void main(String[] args) {
	   Calculator c1 = new Calculator();
	  

   }
    
    
	@Override
	public void actionPerformed(ActionEvent e) {
		//decimal
		if(e.getSource()==decimal) {
			top.setText(top.getText()+".");
			
		}
		
		//percent
		if(e.getSource()==per) {
			if(counter==0) {
				top.setText(""+inputs[0]/100);
				
			}
			if(counter==1) {
				top.setText(""+inputs[1]/100);
				
			}
		}
		
		//negative/positive
		double a = 0;
		 if(e.getSource()==negpos && top.getText().charAt(0)!='-') {
			top.setText("-"+top.getText());
		} else if(e.getSource()==negpos && top.getText().charAt(0)=='-') {
			String b = top.getText();
			top.setText(b.substring(1));
		} 
		
		
		//Clear buttons
		if(e.getSource()==CE) {
			if(counter==1) {
				inputs[1]=null;
				top.setText("");
			} else if(counter==0) {
				inputs[0]=null;
				top.setText("");
			}
			top.setText("");
		} else if(e.getSource()==C) {
			top.setText("");
			inputs[0]=null;
			inputs[1]=null;
			counter=0;
		}
		
		//buttons 1-9
		for(int i = 0; i<buttons.length; i++) {
			 if(buttons[i]==e.getSource() && counter == 0 || buttons[i]==e.getSource() && counter==2) {
				 if(counter==2) {
					 top.setText("");
					 counter=0;
				 }
				 if(e.getSource()!=negpos && e.getSource()!=per) {
				 top.setText(top.getText()+i+"");}
				 
				 inputs[0] = Double.parseDouble(top.getText());
				
				 
				 
			 }  else if(buttons[i]==e.getSource() && counter==1) {
				 if(counter==1 && inputs[0]==null) {
					 inputs[0]=answer;
				 }
				 if(e.getSource()!=negpos &&  e.getSource()!=per) {
				 top.setText(top.getText()+i+"");}
				 inputs[1] =  Double.parseDouble(top.getText());
				
			 }
			 
		 }
		 
		//operator buttons
		 for(int i = 0; i<ops.length; i++) {
			 if(ops[i]==e.getSource()) {
				 op = ops[i].getText();
				 top.setText("");
				counter=1;
			 } 
					 
			 
			 
		 }
		 
		 //equals 
		 if(equal==e.getSource()) {
				counter = 2;
			}

		 if(counter==2) {
			 if(ops[0].getText()==op) {
				answer= inputs[0]+inputs[1];
				top.setText(answer+"");
			 } else if(ops[1].getText()==op) {
				 answer = inputs[0]*inputs[1];
				 top.setText(answer+"");
			 } else if(ops[2].getText()==op) {
				 answer = inputs[0]-inputs[1];
				 top.setText(answer+"");
			 } else if(ops[3].getText()==op) {
				 answer = inputs[0]/inputs[1];
				 top.setText(answer+"");
			 }
			 inputs[0]=null;
			 inputs[1]=null;
		 }

//print
		 System.out.println();
		 System.out.println("new");
		 System.out.println("negpos:"+negposC);
		 System.out.println(inputs[0]);
		 System.out.println(inputs[1]);
		 System.out.println(op);
		 System.out.println(counter);
		 System.out.println(answer);
 }
		 
	}
	
	