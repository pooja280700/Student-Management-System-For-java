import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class Delete extends JFrame
{
Container c;
JLabel lblSrno;
JTextField txtSrno;
JButton btnDelete, btnBack;
int res = 0;

Delete( )
{
c = getContentPane( );
c.setLayout(null);
c.setBackground(new java.awt.Color(255,102,102));
lblSrno = new JLabel("Enter Roll No : ");
txtSrno= new JTextField(10);
btnDelete = new JButton("Delete ");
btnBack = new JButton("Back");

lblSrno.setBounds(100, 100, 120, 30);
txtSrno.setBounds(200, 100, 120, 30);
btnDelete.setBounds(100, 150, 80, 30);
btnBack.setBounds(200, 150, 80, 30);


c.add(lblSrno);
c.add(txtSrno);
c.add(btnDelete);
c.add(btnBack);

ActionListener a1=(ae)->{

try
{
int Srno = Integer.parseInt(txtSrno.getText( ));
if(Srno <= 0)
{
JOptionPane.showMessageDialog(new JDialog( ), "Invalid Roll Number");
txtSrno.setText("");
txtSrno.requestFocus();
}
else
{
DbHandler db=new DbHandler();
res=db.deleteStudent(Srno);
txtSrno.setText("");
txtSrno.requestFocus();
}
}
catch(NumberFormatException nfe)
{

JOptionPane.showMessageDialog(c,"Invalid Roll No!!!");
txtSrno.setText("");
txtSrno.requestFocus();
}
};
btnDelete.addActionListener(a1);

ActionListener a2=(ae)->{
dispose();
Main m=new Main();
};
btnBack.addActionListener(a2);


setSize(400, 400);
setLocation(200, 200);
setTitle("Delete Student Information ");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
public static void main(String args[])
{
Delete m=new Delete();
}
}
