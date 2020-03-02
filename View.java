import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class View extends JFrame
{
Container c;
TextArea ta;
JButton btnback;


View()
{
c=getContentPane();
c.setLayout(null);
c.setBackground(new java.awt.Color(51,204,255));
ta=new TextArea(10,10);
btnback=new JButton("Back");
ta.setBounds(20,50,280,250);
btnback.setBounds(180,350,80,30);

c.add(ta);
c.add(btnback);
String top="ROLLNO.  NAME  MARKS";
DbHandler db=new DbHandler();
String data=db.ViewStudent();
ta.setText(top);
ta.setText(data);

ActionListener a1=(ae)->{
dispose();
Main t=new Main();
};



btnback.addActionListener(a1);
setSize(450,450);
setLocation(200,200);
setTitle("VIEW");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}

}
