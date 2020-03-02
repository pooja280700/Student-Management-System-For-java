import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class Update extends JFrame
{
Container c;
JLabel lblSrno, lblSname , lblSmarks;
JTextField txtSrno, txtSname , txtSmarks;
JButton btnSave, btnBack;
int res = 0;

Update( )
{
c = getContentPane( );
c.setLayout(null);
c.setBackground(new java.awt.Color(255,102,102));
lblSrno = new JLabel("Enter Roll No : ");
txtSrno= new JTextField(10);
lblSname = new JLabel("Enter  Name : ");
txtSname = new JTextField(10);
lblSmarks = new JLabel("Enter  Marks : ");
txtSmarks = new JTextField(10);
btnSave = new JButton("Update ");
btnBack = new JButton("Back");

lblSrno.setBounds(100, 100, 120, 30);
txtSrno.setBounds(200, 100, 120, 30);
lblSname.setBounds(100, 150, 120, 30);
txtSname.setBounds(200, 150, 120, 30);
lblSmarks.setBounds(100, 200, 120, 30);
txtSmarks.setBounds(200, 200, 120, 30);
btnSave.setBounds(100, 250, 80, 30);
btnBack.setBounds(200, 250, 80, 30);

c.add(lblSname);
c.add(txtSname);
c.add(lblSmarks);
c.add(txtSmarks);
c.add(lblSrno);
c.add(txtSrno);
c.add(btnSave);
c.add(btnBack);


ActionListener a1=(ae)->{
try
{
int Srno = Integer.parseInt(txtSrno.getText( ));
String Sname = txtSname.getText( );
int Smarks = Integer.parseInt(txtSmarks.getText( ));

int j = 0, flag=0,t=0;
for(int i=0 ; i<Sname.length(); i++)
{
if(!Character.isLetter(Sname.charAt(i)))
{
JOptionPane.showMessageDialog(c,"Please Enter Character Only");
txtSname.setText("");
txtSname.requestFocus();
return;
}
}

if(Srno<=0)
{
JOptionPane.showMessageDialog(new JDialog( ), "Invalid Roll Number");
txtSrno.setText("");
txtSrno.requestFocus();
}

else if(Sname.length() <2)
{

JOptionPane.showMessageDialog(new JDialog( ), "Name should have Minimum two character");
txtSname.setText("");
txtSname.requestFocus();
}

else if (Smarks > 100)
{
JOptionPane.showMessageDialog(new JDialog( ), "Invalid Marks!!!  Enter Marks between 0 to 100 ");
txtSmarks.setText("");
txtSmarks.requestFocus();
}
else
{
Student n =new Student();
n.setSrno(Srno);
n.setSname(Sname);
n.setSmarks(Smarks);
DbHandler db=new DbHandler();
res=db.UpdateStudent(Sname,Smarks,Srno);
txtSrno.setText("");
txtSname.setText("");
txtSmarks.setText("");
txtSrno.requestFocus();
}
}
catch(NumberFormatException nfe)
{
JOptionPane.showMessageDialog(c,"Invalid Roll No!!! Or Invalid Marks!!");
txtSrno.setText("");
txtSmarks.setText("");
txtSrno.requestFocus();
}
catch(Exception e)
{
JOptionPane.showMessageDialog(c,e);
txtSrno.setText("");
txtSname.setText("");
txtSmarks.setText("");
txtSrno.requestFocus();
}
};
btnSave.addActionListener(a1);

ActionListener a2=(ae)->{
dispose();
Main m=new Main();
};
btnBack.addActionListener(a2);


setSize(400, 400);
setLocation(200, 200);
setTitle("Update Student Information ");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
public static void main(String args[])
{
Update m=new Update();
}
}


