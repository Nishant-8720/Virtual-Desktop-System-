import java.awt.*;
import javax.swing.*;

public class Frame1 extends JFrame
{
JProgressBar jpb;
JPanel Panel1;
static int width=850,height=650;
public Frame1()
{
ImageIcon i=new javax.swing.ImageIcon("C://Users/nishant/Desktop/Virtual Desktop/Project image and sound/Au.png");

	JLabel	jLabel3 = new javax.swing.JLabel(i);
Panel1=new JPanel();
Panel1.add(jLabel3);
Panel1.setBackground(new Color(212,223,255));
getContentPane().add(Panel1);
this.setSize(width,height);
setResizable(false);
Dimension D=Toolkit.getDefaultToolkit().getScreenSize();
setLocation((D.width-width)/2,(D.height-height)/2);
setTitle("About Us!");
}
public static void main(String args[]){
	new Frame1().setVisible(true);
}
}