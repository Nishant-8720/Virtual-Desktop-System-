import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.applet.*;

//add java.swing in every object creation
//addGap is use to add Gap between the Activity
public class Login extends javax.swing.JFrame {

    /** Creates new form Login */
    public Login() {
		this.setContentPane(new javax.swing.JLabel(new javax.swing.ImageIcon("C://Users/nishant/Desktop/Virtual Desktop/Project image and sound/5.jpg")));
		//this.setContentPane(new javax.swing.JLabel(new javax.swing.ImageIcon("C://Users/nishant/Desktop/Virtual Desktop/Project image and sound/gif.gif")));
        //^add background images pictures
		
		initComponents();
        
		this.setLocation(350,100);
		this.setSize(720,500);
		this.setResizable(false);
		//this.getContentPane().setBackground(Color.lightGray);//background color
		
		//this.setIconImage(Toolkit.getDefaultToolkit().getImage("VD2.png"));//logo for application
    }
	
    /** This method is called from within the constructor to
     * initialize the form.

     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
		
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
		
		//add Image in Frame (Create Image Object)
		javax.swing.ImageIcon i=new javax.swing.ImageIcon("C://Users/nishant/Desktop/Virtual Desktop/Project image and sound/cd4.gif");
		
		jLabel3 = new javax.swing.JLabel(i);
		//javax.swing.ImageIcon i2=new javax.swing.ImageIcon("login-button.png");
		
		javax.swing.ImageIcon i1=new javax.swing.ImageIcon("C://Users/nishant/Desktop/Virtual Desktop/Project image and sound/Maxigems.png");
		
		jLabel4 = new javax.swing.JLabel(i1);
		
		javax.swing.ImageIcon i2=new javax.swing.ImageIcon("C://Users/nishant/Desktop/Virtual Desktop/Project image and sound/VDS.png");
		jLabel5 = new javax.swing.JLabel(i2);
		
		 jLabel1.setForeground(Color.red);//Label Color
		  jLabel2.setForeground(Color.red);//Label Color
		   jLabel3.setForeground(Color.red);//Label Color
        
		jTextField1 = new javax.swing.JTextField();
	//	jTextField1.setEnabled(false);
        jButton1 = new javax.swing.JButton();
		jButton1.setToolTipText("Login");
        jButton2 = new javax.swing.JButton();
		jButton2.setToolTipText("Clear");
		jButton3 = new javax.swing.JButton();
		jButton3.setToolTipText("About Me");
		
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
		setTitle("VIRTUAL DESKTOP - Login");
       // setBounds(new java.awt.Rectangle(400, 200, 300, 300));
		
        jLabel1.setFont(new java.awt.Font("Algerian",Font.BOLD,24));
        jLabel1.setText("USER NAME :");
		
        jLabel2.setFont(new java.awt.Font("Algerian",Font.BOLD, 24));
        jLabel2.setText("PASSWORD :");
		
		//jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 28));
       // jLabel3.setText("VIRTUAL DESKTOP");
		 
        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 14));
		
		/*
		jTextField1.addKeyListener(new java.awt.event.KeyAdapter(){
			public void keyTyped(KeyEvent e){	
				jTextField1.setEnabled(true);
			}
			public void keyReleased(KeyEvent e){}
			public void keyPressed(KeyEvent e){}
		});
		
		*/
		//***on click label Event
		
		jLabel1.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				//Frame1=new Frame1();
				//Frame1.setVisible(true);
			//jTextField1.setText("");	
		  NetStart tl=new NetStart();
            tl.setVisible(true);
			//this.setVisible(false);
			//System.out.println();
			/*Panel=new JPanel();
					Panel.add(jLabel2);
					getContentPane().add(Panel);
				Panel.setSize(300,300);
			*/}
			public void mouseEntered(MouseEvent e){}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
			public void mouseReleased(MouseEvent e){}
		});
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("About Me");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
		
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
		
		layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGap(80,80,80)
					//.addComponent(jLabel5,javax.swing.GroupLayout.Alignment.CENTER)
					//.addGap(200,200,200)
						.addComponent(jLabel3,javax.swing.GroupLayout.Alignment.CENTER)
						  .addComponent(jButton3,javax.swing.GroupLayout.Alignment.CENTER)
						   .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                .addGap(80,80,80)
				//.addGap(400,400,400)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        
						.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 10, Short.MAX_VALUE)
						.addGap(21, 21, 21)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
							.addGroup(layout.createSequentialGroup()
                        
						.addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 10, Short.MAX_VALUE)
							.addGap(21, 21, 21)
							.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                        
								.addGap(28, 28, 28)
                                .addComponent(jButton2))
						  //.addComponent(jButton3,javax.swing.GroupLayout.Alignment.CENTER)                        
						 .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)))
						 .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 10, Short.MAX_VALUE)
							.addGap(21, 21, 21))
                .addGap(120	, 120, 120))//text box size
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			//.addComponent(jLabel5)
			.addGap(100, 100, 100)
			
			.addComponent(jLabel3)
			//.addGap(30, 30, 30)
            
				
			.addGroup(layout.createSequentialGroup()
                .addGap(180,180,180)//gap between the image and Username and Password
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)					                   
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))//text field size
                .addGap(20, 20, 20)
				
									
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
					.addGap(10, 10, 10)
					.addComponent(jButton3)    
.addComponent(jLabel4)     					
			  .addContainerGap(70, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
					Frame1=new Frame1();
				Frame1.setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
					
                   jTextField1.setText("");
				  // jTextField1.setBounds(50,100,200,30);
                   jPasswordField1.setText("");
				   
                   jButton1.setEnabled(true);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
        String username = new String(jTextField1.getText());
        String password = new String(jPasswordField1.getPassword());

        if(username.equals("") || password.equals(""))
        {
         JOptionPane.showMessageDialog(null,"Fields cannot be blank");
          jTextField1.setText("");
          jPasswordField1.setText("");
          jButton1.setEnabled(true);
        }
        else
            if(username.equals("Admin")&& password.equals("Admin"))
        {
           
		   try{
		   AudioClip ac=Applet.newAudioClip(new File("C://Users/nishant/Desktop/Virtual Desktop/Project image and sound/Sucess.wav").toURL());
		   ac.play();}
		   catch(Exception e){}
		  
		  JOptionPane.showMessageDialog(null,"Login Successful");
            NetStart tl=new NetStart();
            tl.setVisible(true);
            this.setVisible(false);
        }
            else
            {   //JOptionPane.showMessageDialog(null,"Username or Password entered is wrong ");
		try{
		AudioClip ac=Applet.newAudioClip(new File("C://Users/nishant/Desktop/Virtual Desktop/Project image and sound/Error.wav").toURL());
		   ac.play();}
		   catch(Exception e){}
			
			JOptionPane.showMessageDialog(Frame1,"Username or Password entered is wrong ","",JOptionPane.ERROR_MESSAGE);
                 jTextField1.setText("");
                 jPasswordField1.setText("");
                 jButton1.setEnabled(true);
            }



    }//GEN-LAST:event_jButton1ActionPerformed
  
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;//Login
    private javax.swing.JButton jButton2;//Clear
	private javax.swing.JButton jButton3;//About us
    private javax.swing.JLabel jLabel1;//username
    private javax.swing.JLabel jLabel2;//password
    private javax.swing.JLabel jLabel3;//Logo Image
	private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
	  private javax.swing.JLabel jLabel6;
	private javax.swing.JFrame Frame1;
    private javax.swing.JPanel Panel;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
	

}
