import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.io.*;

class Main extends JFrame
{
Container c;
JButton btnAdd, btnView, btnUpdate, btnDelete;
Main( )
{
c = getContentPane( );
c.setLayout(null);
c.setBackground(new java.awt.Color(153,0,0));
btnAdd = new JButton("Add ");
btnView = new JButton("View");
btnUpdate = new JButton("Update");
btnDelete = new JButton("Delete");
btnAdd.setBounds(100, 100, 80, 30);
btnView.setBounds(100, 150, 80, 30);
btnUpdate.setBounds(100, 200, 80, 30);
btnDelete.setBounds(100, 250, 80, 30);
c.add(btnAdd);
c.add(btnView);
c.add(btnUpdate);
c.add(btnDelete);

ActionListener a1=(ae)->{
Add a=new Add();
dispose();
};
btnAdd.addActionListener(a1);

ActionListener a2=(ae)->{
View a=new View();
dispose();
};
btnView.addActionListener(a2);



btnUpdate.addActionListener(new ActionListener( )
{
public void actionPerformed(ActionEvent ae)
{
Update a = new Update( );
dispose( );
}
});

btnDelete.addActionListener(new ActionListener( )
{
public void actionPerformed(ActionEvent ae)
{
Delete a = new Delete( );
dispose( );
}
});

setSize(400, 400);
setLocation(200,200);
setTitle("Student  Management System ");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}

public static void main(String args[ ])
{
Main mf = new Main( );
} // end of main( )
} // end of Main

class DbHandler
{
public int addStudent(Student s )
{
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory factory=cfg.buildSessionFactory();
Session session=null;
Transaction t=null;
try
{
session=factory.openSession();
t = session.beginTransaction();
session.save(s);
t.commit();
JOptionPane.showMessageDialog(new JDialog(), "Record Inserted ");
return 1;

}
catch(Exception e1)
{
t.rollback();
JOptionPane.showMessageDialog(new JDialog(),e1);
return 1;
}

finally
{
session.close();
}
}

public String ViewStudent()
{
StringBuffer sb = new StringBuffer();
Configuration cfg  = new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory factory =cfg.buildSessionFactory();
Session session = null;
try
{
session = factory.openSession();
java.util.List<Student> e = new java.util.ArrayList<>();
e = session.createQuery("from Student").list();
for (Student m : e)
{
sb.append("RollNo-->"+m.getSrno() +  " " +"Name-->" +m.getSname()+"  "+"Marks-->"+m.getSmarks()+"\n");
}
}
catch(Exception e)
{
JOptionPane.showMessageDialog(new JDialog(),e);
}
finally
{
session.close();
}
return sb.toString();
}


public int UpdateStudent(String Sname,int Smarks,int Srno){
Configuration cfg  = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory factory =cfg.buildSessionFactory();
Transaction t=null;
Session session = null;
try
{
session = factory.openSession();

t = session.beginTransaction();
Student student=(Student)session.get(Student.class,Srno);
student.setSname(Sname);
student.setSmarks(Smarks);
t.commit();
JOptionPane.showMessageDialog(new JDialog(), "Reocord Updated ");
return 1;
}

catch(Exception e1)
{

t.rollback();
JOptionPane.showMessageDialog(new JDialog(),"Roll Number Not present in database!!!!");
return 1;
}
finally
{
session.close();

}
}

public int deleteStudent(int Srno)
{
Configuration cfg  = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory factory =cfg.buildSessionFactory();
Transaction t=null;
Session session = null;
try{
session = factory.openSession();

t = session.beginTransaction();
Student student=(Student)session.get(Student.class,Srno);
session.delete(student);
JOptionPane.showMessageDialog(new JDialog(),"Record Deleted");
t.commit();
}
catch(Exception e1)
{
t.rollback();
JOptionPane.showMessageDialog(new JDialog(),e1);
}
finally
{
session.close();
return 1;
}
}


}

