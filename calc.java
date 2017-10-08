import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

public class calc extends JFrame
{
 private String check;
 private int numOne, sum, total ; 
 private int count = 0, Chec = 0; 
 private final String names[] = {"7", "8", "9", "-", "4", "5", "6", "+", "1", "2", "3", "*", "0", "c", "=", "/"}; 
 private JTextField inputText;
 
 public calc()
 {
  super("°è»ê±â");
  
  BorderLayout layout = new BorderLayout(3, 3); 
  setLayout(layout); 
  
  
  JPanel groupPanel = new JPanel(new BorderLayout(5, 2));
  
  inputText = new JTextField("", SwingConstants.CENTER); 
  inputText.setHorizontalAlignment(JTextField.RIGHT); 
  
  groupPanel.add(inputText, BorderLayout.CENTER);
  
  
  JPanel padPanel = new JPanel(new GridLayout(4, 4));
  JButton buttons[] = new JButton[names.length];
  for(int count = 0; count < names.length; count++)
  {
   buttons[count] = new JButton(names[count]);
   padPanel.add(buttons[count]);
   
   PadInput handler = new PadInput(); 
   buttons[count].addActionListener(handler); 
  }
  add(groupPanel, BorderLayout.NORTH);
  add(padPanel, BorderLayout.CENTER);
  
 }

 private class PadInput implements ActionListener
 {
  public void actionPerformed(ActionEvent event)
  {
   String eventText = event.getActionCommand();
   
   
   if(eventText.equals("+")) 
   {
    Chec = 1;
   }
   else if(eventText.equals("-")) 
   {
    Chec = 2;
   }
   else if(eventText.equals("*")) 
   {
    Chec = 3;
   }
   else if(eventText.equals("/")) 
   {
    Chec = 4;
   }
   else if(eventText.equals("=")) 
   {
    Chec = 5;
   }
   else if(eventText.equals("c"))
   {
	   inputText.setText("");
 	   numOne = 0;
 	   total = 0;
 	   sum = 0;
 	   count = 0;
 	   Chec=0;
   }
   else
   {
    if(count == 1) 
    {
     inputText.setText("");
     count = 0;
    }
    
    inputText.setText(inputText.getText()+event.getActionCommand()); 
   }

   try
   {
    if((total != 0) && (Chec <= 5)) 
    {
     inputText.setText(inputText.getText()); 
    }
    else
    {
     if( Chec == 1 ) 
     {
      numOne = Integer.parseInt(inputText.getText()); 
      total += numOne;  
      numOne = 0; 
      
      inputText.setText(String.valueOf(total)); 
      
      count = 1;
      check = "+";
     }
     else if( Chec == 2 ) 
     {
      numOne = Integer.parseInt(inputText.getText());
      total += numOne;
      numOne = 0;
      
      inputText.setText(String.valueOf(total));
      
      count = 1;
      check = "-";
     }
     else if( Chec == 3 )
     {
      numOne = Integer.parseInt(inputText.getText());
      total += numOne;
      numOne = 0;
      
      inputText.setText(String.valueOf(total));
      
      count = 1;
      check = "*";
     }
     else if( Chec == 4 )
     {
      numOne = Integer.parseInt(inputText.getText());
      total += numOne;
      numOne = 0;
      
      inputText.setText(String.valueOf(total));
      
      System.out.println(" numBer ==> " + numOne);
      System.out.println(" total ==> " + total);
      
      count = 1;
      check = "/";
     }
    }
   }
   catch(Exception e)
   {
    System.out.println(" Error ==> " + e);
   }
  
   if(total == 0)
   {
    inputText.setText(inputText.getText()); 
   }
   else
   {
    if((Chec == 5) && check.equals("+"))
    {
     numOne = Integer.parseInt(inputText.getText()); 
     sum = numOne + total; 
     
     count = 1;
     numOne = 0;
     total = 0;
     inputText.setText(String.valueOf(sum)); 
    }
    else if((Chec == 5) && check.equals("-")) 
    {
     System.out.println("bbb");
     numOne = Integer.parseInt(inputText.getText());
     sum = total - numOne;
     
     count = 1;
     numOne = 0;
     total = 0;
     inputText.setText(String.valueOf(sum));
    }
    else if((Chec == 5) && check.equals("*")) 
    {
     System.out.println("ccc");
     numOne = Integer.parseInt(inputText.getText());
     sum = numOne * total;
     
     count = 1;
     numOne = 0;
     total = 0;
     inputText.setText(String.valueOf(sum));
    }
    else if((Chec == 5) && check.equals("/")) 
    {
     System.out.println("ddd");
     numOne = Integer.parseInt(inputText.getText());
     sum = total / numOne;
     
     count = 1;
     numOne = 0;
     total = 0;
     inputText.setText(String.valueOf(sum));
    }
   }
  }
 }

 public static void main(String args[])
 {
  calc calStart = new calc(); 
  calStart.setSize(300, 350); 
  calStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  calStart.setVisible(true);
 }
}