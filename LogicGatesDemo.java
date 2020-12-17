import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class LogicGates {
   public boolean BUFFER(boolean a) {
      if (a == false)
         return false;
      else
         return true;
   }

   public boolean NOT(boolean a) {
      if (a == false)
         return true;
      else
         return false;
   }

   public boolean AND(boolean a, boolean b) {
      if (a == true && b == true)
         return true;
      else
         return false;
   }

   public boolean NAND(boolean a, boolean b) {

      if (a == true && b == true)
         return false;
      else
         return true;
   }

   public boolean OR(boolean a, boolean b) {

      if (a == false && b == false)
         return false;
      else
         return true;
   }

   public boolean NOR(boolean a, boolean b) {
      if (a == false && b == false)
         return true;
      else
         return false;
   }

   public boolean EXOR(boolean a, boolean b) {
      if ((a == false && b == false) || (a == true && b == true))
         return false;
      else
         return true;
   }

   public boolean EXNOR(boolean a, boolean b) {
      if ((a == false && b == false) || (a == true && b == true))
         return true;
      else
         return false;
   }

}

class LogicGatesGUI extends JFrame implements ItemListener {
   JLabel nameA, nameB, label, result;
   JTextField tres;
   JComboBox cbOptrs, textA, textB;
   Container c = getContentPane();
   boolean one, zero;
   String res;
   String optA[] = { "1", "0" }; // used drag down options to prevent the users to input incorrectly
   String optB[] = { "1", "0" };
   String optrs[] = { "BUFFER", "NOT Gate", "AND Gate", "NAND Gate", "OR Gate", "NOR Gate", "EX-OR Gate",
         "EX-NOR Gate" };

   public LogicGatesGUI() {
      super("Automated Logic Gates Result");
      nameA = new JLabel("Enter A: ");
      nameB = new JLabel("Enter B: ");
      label = new JLabel("Select an operation: ");
      result = new JLabel("Result: ");

      textA = new JComboBox(optA);
      textA.addItemListener(this);
      textB = new JComboBox(optB);
      textB.addItemListener(this);
      tres = new JTextField(10);
      tres.setEditable(false);

      cbOptrs = new JComboBox(optrs);
      cbOptrs.addItemListener(this);

      c.setLayout(new GridLayout(4, 2));
      c.add(label);
      c.add(cbOptrs);
      c.add(nameA);
      c.add(textA);
      c.add(nameB);
      c.add(textB);
      c.add(result);
      c.add(tres);

      setSize(300, 200);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setResizable(false);
      setVisible(true);
   }

   public void itemStateChanged(ItemEvent ie) {

      LogicGates lg = new LogicGates();

      if (textA.getSelectedIndex() == 0) {
         one = true;
      } else {
         one = false;
      }
      if (textB.getSelectedIndex() == 0) {
         zero = true;
      } else {
         zero = false;
      }

      if (cbOptrs.getSelectedIndex() == 0 || cbOptrs.getSelectedIndex() == 1) {
         textB.setEnabled(false);
         if (cbOptrs.getSelectedIndex() == 0) {
            res = lg.BUFFER(one) + "";
         } else if (cbOptrs.getSelectedIndex() == 1) {
            res = lg.NOT(one) + "";
         }
      } 
      else {
         textB.setEnabled(true);
         if (cbOptrs.getSelectedIndex() == 2)
            res = lg.AND(one, zero) + "";
         else if (cbOptrs.getSelectedIndex() == 3)
            res = lg.NAND(one, zero) + "";
         else if (cbOptrs.getSelectedIndex() == 4)
            res = lg.OR(one, zero) + "";
         else if (cbOptrs.getSelectedIndex() == 5)
            res = lg.NOR(one, zero) + "";
         else if (cbOptrs.getSelectedIndex() == 6)
            res = lg.EXOR(one, zero) + "";
         else if (cbOptrs.getSelectedIndex() == 7)
            res = lg.EXNOR(one, zero) + "";
      }
      tres.setText(res + "");
      repaint();
   }
}

public class LogicGatesDemo {
   public static void main(String args[]) {
      new LogicGatesGUI();
   }
}