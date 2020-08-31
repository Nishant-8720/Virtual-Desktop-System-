import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.*;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.applet.*;
import java.awt.event.*;
import javax.swing.JOptionPane.*;

public class NetStart extends javax.swing.JFrame {


    public static Object mac_list[][] = null;
    public static Object task_list[][] = null;
    public static String title[] = {"Machine Name","IP Address","Status","Option"};
    public static Vector compname=null;
    public static Vector tasklst = null;
	public static Vector Application_List = null;
    public static Hashtable ipAddrTab = null;
    public static InetAddress address =null ;
    public static int flagrow=0;
    public static int flag=0;
    public static String taskmachineIP = "";

    public NetStart() {
		this.setContentPane(new javax.swing.JLabel(new javax.swing.ImageIcon("C://Users/nishant/Desktop/Virtual Desktop/Project image and sound/1.jpg")));
       
		initComponents();
        screenrefresh();
        this.setSize(750,400);
        this.setLocation(200,200);
		this.getContentPane().setBackground(Color.lightGray);
		this.setResizable(false);
    }

	
    public void screenrefresh()
    {
        getMachines();
        getIPAddress();
        jTable1.setModel(new javax.swing.table.DefaultTableModel(mac_list,title));

        Font f = new Font("Times New Roman",Font.BOLD,14);
        jTable1.setFont(f);

        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.sizeColumnsToFit(0);
    }

    public void getIPAddress()
    {
        try
        {
            ipAddrTab = new Hashtable();

            for(int i=0;i<compname.size();i++)
            {
                    try
                    {
                        address = InetAddress.getByName(compname.get(i).toString());
                        String tempIP[] = address.toString().split("/");
                        ipAddrTab.put(tempIP[0],tempIP[1]);
                    }catch(UnknownHostException ue)
                    {
                        if(compname.get(i).toString().indexOf("")<=-1)
                        ipAddrTab.put(compname.get(i).toString(),"NO IP FOUND");
                    }
                    catch(Exception ee)
                    {
                        if(compname.get(i).toString().indexOf("")<=-1)
                        ipAddrTab.put(compname.get(i).toString(),"NO IP FOUND");
                    }
            }
            //System.out.println(ipAddrTab);
            for(int i=1,j=0;i<compname.size();i++,j++)
                if(ipAddrTab.get(compname.get(i))!=null||ipAddrTab.get(compname.get(i))!="")
                {
                    mac_list[j][1] = ipAddrTab.get(compname.get(i));
                    mac_list[j][2] = "ALIVE";
                    mac_list[j][3] = "View";
                }
                else
                {
                    mac_list[j][1] = "NO IP FOUND";
                    mac_list[j][2] = "DEAD";
                    mac_list[j][3] = "NA";
                }

        }catch(Exception e)
        {
            System.out.println("getIPAddress "+e);
        }
    }

    public void getMachines()
    {
                        try
                        {
                                String cmd = "net view";
                                Process child = Runtime.getRuntime().exec(cmd);
                                // hook up child process output to parent
                                InputStream lsOut = child.getInputStream();
                                InputStreamReader r = new InputStreamReader(lsOut);
                                BufferedReader in = new BufferedReader(r);

                                // read the child process' output

                                String line;
                                int cnt = 0;
                                compname = new Vector();
                                while ((line = in.readLine()) != null)
                                {
                                        //System.out.println(line);
                                        StringTokenizer token = new StringTokenizer(line,"\\");
                                        while(token.hasMoreElements())
                                        {
          
                                      String temp = token.nextToken().toString();
                                                String tempar[] = temp.split(" ");
                                                compname.addElement(tempar[0]);
                                        }
                                }

                                compname.remove(0);
                                //compname.remove(1);
                                compname.remove(compname.size()-1);

                                //for(int i=0;i<compname.size();i++)
                                        //System.out.println(compname.get(i));

                         mac_list = new Object[compname.size()-1][4];

                         for(int i=1,j=0;i<compname.size();i++,j++)
                             mac_list[j][0] = compname.get(i);

                        }catch(Exception e)
                        {
                                System.out.println("getMachines() "+e);
                                e.printStackTrace();
                        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
	
		
	// jpb=new JProgressBar();
// jpb.setOrientation(jpb.HORIZONTAL);
// jpb.setBackground(new Color(12,223,255));
// jpb.setForeground(Color.pink);
// jpb.setIndeterminate(true);
// jpb.setString("NISHANT");
// jpb.setStringPainted(true);
// jpb.enable(true);
//Panel=new JPanel();
//Panel.add(jpb);
//getContentPane().add(Panel);
//this.setSize(300,300);
 //javax.swing.BorderLayout B=new  javax.swing.BorderLayout(getContentPane());
//getContentPane().setLayout(B);
//add(jpb,BorderLayout.NORTH);
    
		javax.swing.ImageIcon i2=new javax.swing.ImageIcon("C://Users/nishant/Desktop/Virtual Desktop/Project image and sound/Scan.jpg");
		jButton1 = new javax.swing.JButton("SCAN");
		jButton1.setToolTipText("Scan");
        jButton2 = new javax.swing.JButton();
		jButton2.setToolTipText("Restart");
        jButton3 = new javax.swing.JButton();
		jButton3.setToolTipText("Shutdown");
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel(i2);
        jButton5 = new javax.swing.JButton();
		jButton5.setToolTipText("Snapshot");
		
        jButton6 = new javax.swing.JButton();
		jButton6.setToolTipText("Log out");
		
		jButton7 = new javax.swing.JButton("View");
		jButton7.setToolTipText("TaskList");
        
		jButton8 = new javax.swing.JButton();
		jButton8.setToolTipText("Application");
		//setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		//String S="abc";
        setTitle("List of machines in network");
        setBounds(new java.awt.Rectangle(400, 200, 400, 400));
		 
		//System.out.println(compname);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e)
			{
				//int dialogButton= 
		int option=JOptionPane.showConfirmDialog(null,"Do you Want to Close","Warning",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(option==0)
		{
			//this.dispose(); 
			try{
		 AudioClip ac=Applet.newAudioClip(new File("C://Users/nishant/Desktop/Virtual Desktop/Project image and sound/logout.wav").toURL());
		   ac.play();}
		    catch(Exception e4){}
        // this.dispose();
        // this.setVisible(false);
		 new Login().setVisible(true);
		}
		else if(option==1)
		{
			System.out.println("Hi");
			new NetStart().setVisible(true);
		}
			}
		});
		jButton1.setText("SCAN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Restart");
        //jButton2.setIcon(new javax.swing.ImageIcon("restart-button-hi.gif"));
		jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Shutdown");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

		
		
        jButton7.setText("TaskList");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jScrollPane1.setToolTipText("");
        jScrollPane1.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String[] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
		//String S=jTable1.getToolTipText(MouseEvent);
       
	   jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable1PropertyChange(evt);
            }
        });

        jScrollPane1.setViewportView(jTable1);

       jLabel1.setFont(new java.awt.Font("Algerian", Font.BOLD, 14));
      //  jLabel1.setText("SCAN");
		jLabel1.setForeground(Color.white);
		
		jLabel1.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				screenrefresh();
				System.out.println("Refresh");
			}
			public void mouseEntered(MouseEvent e){}
			public void mouseExited(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
			public void mouseReleased(MouseEvent e){}
		});
        jButton5.setText("Snapshot");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Log Out");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

		 jButton8.setText("Application");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
		
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			//.addComponent(jpb,javax.swing.GroupLayout.Alignment.CENTER) 
			//.addComponent(jTable1,javax.swing.GroupLayout.Alignment.CENTER)
            		.addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
			.addGroup(layout.createSequentialGroup()
			.addGap(50, 50, 50)
			               
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        //.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                       // .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					//	.addGap(15, 15, 15)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(15, 15, 15)
                        .addComponent(jButton3)
                        .addGap(15, 15, 15)
                        .addComponent(jButton5)
                        .addGap(15, 15, 15)
                        .addComponent(jButton8)
						.addGap(15, 15, 15)
                        .addComponent(jButton7)
                        
						.addGap(19, 19, 19)
                        .addComponent(jButton6)))
                .addContainerGap(91, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			//.addComponent(jpb,javax.swing.GroupLayout.Alignment.CENTER) 
			//.addComponent(jTable1)
          .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
			.addGap(60, 60, 60)
			.addGroup(layout.createSequentialGroup()
			//.addGap(100, 100, 100)
			            
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				 
				  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton3)
                        .addComponent(jButton6)
						.addComponent(jButton8)
                        .addComponent(jButton7)
						.addComponent(jButton5))
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  //  .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
				  )
                .addGap(57, 57, 57)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(167, 167, 167)))
        );
		
		
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
// TODO add your handling code here:
	try{
		AudioClip ac=Applet.newAudioClip(new File("C://Users/nishant/Desktop/Virtual Desktop/Project image and sound/logout.wav").toURL());
		   ac.play();}
		   catch(Exception e){}
        this.dispose();
        this.setVisible(false);
		 new Login().setVisible(true);
		
		
		
    }//GEN-LAST:event_jButton6ActionPerformed

	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
// TODO add your handling code here:
if(jTable1.getSelectedRow()!=-1)
	 {
  try
                    {
                        int i =jTable1.getSelectedRow();
                        address = InetAddress.getByName(compname.get(i+1).toString());
                        String tempIP = address.toString().split("/")[1];
                        taskmachineIP = tempIP;

                        Socket socket = new Socket(tempIP,8080);

                        InputStream sin = socket.getInputStream();
                        OutputStream sout = socket.getOutputStream();
                        DataInputStream in = new DataInputStream(sin);
                        DataOutputStream out = new DataOutputStream(sout);
                        String line = null;
                        out.writeUTF("tasklist");
                        out.flush();
                        socket.close();
						//System.out.println(compname);
                }
                catch(UnknownHostException e)
                {
                     System.out.println("unknown host Error  "+e);
					
                }
                catch(Exception e)
                {
                    System.out.println("jtable selection "+e);
                }

                    try
                    {
                            System.out.println("creating server");
                            ServerSocket ss = new ServerSocket(8081);
                            System.out.println("waiting for client");
                            Socket socket = ss.accept();
                            System.out.println("got client");
                            //new Socket(ipAddress, serverPort); // create a socket with the server's IP address and server's port.

                            InputStream sin = socket.getInputStream();
                            OutputStream sout = socket.getOutputStream();

                            DataInputStream in = new DataInputStream(sin);
                            DataOutputStream out = new DataOutputStream(sout);

                            String cmd = "";
                            tasklst = new Vector();

                            while(true)
                            {
                                    try
                                    {
                                            cmd = in.readUTF();
                                            if(cmd.equals("bye"))
                                                break;
											if(cmd.contains("Console"))
												tasklst.add(cmd);

                                    }
                                    catch(Exception e)
                                    {
                                            System.out.println(e);
                                    }
                            }
							
							
							
							// this code is use for datasaving
                            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
                            Date date = new Date();
                            System.out.println(dateFormat.format(date));
                            
							Collections.sort(tasklst);
							String abc ="";
							for (int i = 0; i < tasklst.size(); i++) {
								abc = abc +  (String)tasklst.get(i)+"\n";
								
							}
							//System.out.println("----------------"+abc);							
							
							 File file = new File("C://Users/nishant/Desktop/Virtual Desktop/Task List",compname.get(1)+".xls");
							 FileWriter fr = null;
							try {
							fr = new FileWriter(file);			
							fr.write(abc);
							} catch (IOException e) {
							//e.printStackTrace();
        }finally{
            //close resources
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
							
                            out.flush();
                            out.close();
                            ss.close();
                            socket.close();
                    }
                    catch(Exception ee)
                    {
                            System.out.println (ee);
                    }

                    try
                    {
                                        tasklst.remove(0);
                                        tasklst.remove(1);

                                        task_list = new Object[tasklst.size()][5];

                                        for(int j=0;j<tasklst.size()-1;j++)
                                        {
                                        int i=0,k=1;
                                        StringTokenizer tasktoken = new StringTokenizer(tasklst.get(j).toString()," ");
                                        while(tasktoken.hasMoreTokens())
                                        {
                                            String temp = tasktoken.nextToken().toString();
                                            //System.out.println(j+" "+k+" "+i);
                                            if(i!=3&&i<=4)
                                                if(i==4)
                                                {
                                                    task_list[j][0] = new Boolean(false);
                                                    task_list[j][k++] = temp.trim()+" KB";
                                                }
                                                else
                                                {
                                                    task_list[j][0] = new Boolean(false);
                                                    task_list[j][k++] = temp.trim();
                                                }
                                            i++;
                                        }
                                        }

                                        try
                                        {
                                            this.setVisible(false);
                                            TaskList taskList = new TaskList(task_list,taskmachineIP);
                                        }
                                        catch(Exception e)
                                        {
                                            e.printStackTrace();
                                                JOptionPane.showMessageDialog(this,"Cant Launch TaskList......");
                                        }

//                                        for(int i=0;i<tasklst.size()-1;i++)
//                                            System.out.println(task_list[i][0]+ " "+task_list[i][1]+" "+task_list[i][2]+" "+task_list[i][3]);
                    }
                    catch(Exception e)
                    {
                        System.out.println("exception while tasklist "+e);
                        e.printStackTrace();
                    }
				    }	
	 else{
		 try{
		 //initComponents();
		 JOptionPane.showMessageDialog(null,"Select The Machine ","",JOptionPane.ERROR_MESSAGE);
		 System.out.println("hi");
		}catch(Exception e)
                    {}
		 }
    }

	private void jButton8ActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				//GEN-FIRST:event_jButton5ActionPerformed
				// TODO add your handling code here:
if(jTable1.getSelectedRow()!=-1)
	 {	                  
 String compname1="";
 try
				                    {
				                        int i =jTable1.getSelectedRow();
										compname1= compname.get(i+1).toString();
				                        address = InetAddress.getByName(compname.get(i+1).toString());
				                        String tempIP = address.toString().split("/")[1];

				                        Socket socket = new Socket(tempIP,8080);

				                        InputStream sin = socket.getInputStream();
				                        OutputStream sout = socket.getOutputStream();
				                        DataInputStream in = new DataInputStream(sin);
				                        DataOutputStream out = new DataOutputStream(sout);
				                        String line = null;
				                        out.writeUTF("application");
				                        out.flush();
				                        socket.close();
				                    }
				                    catch(Exception e)
				                    {
				                        System.out.println("video request"+e);
				                    }

				                    try
				                    {
										 ServerSocket ss1 = new ServerSocket(8081);
										 ss1.accept();
										 ss1.close();
				                            System.out.println("creating server");
				                            ServerSocket ss = new ServerSocket(8098);
				                            System.out.println("waiting for client");
				                            Socket socket = ss.accept();
				                            System.out.println("got client");
											//Thread.sleep(80000);
									
                            
				                            byte[] mybytearray = new byte[6022386];
				                            InputStream is = socket.getInputStream();
				                            FileOutputStream fos = new FileOutputStream(compname1 + " Application.xls");
				                            
											 //File file = new File("C://Users/nishant/Desktop/Virtual Desktop/Image",compname.get(1)+" Application.xls");
							 // FileWriter fr = null;
							// try {
							// fr = new FileWriter(file);			
							// fr.write(fos);
							// } catch (IOException e) {}
											//File Folder la add karayeche aahe
											System.out.println("Application");
										
											BufferedOutputStream bos = new BufferedOutputStream(fos);
				                            int bytesRead = is.read(mybytearray, 0, mybytearray.length);
				                            bos.write(mybytearray, 0, bytesRead);
											bos.flush();
											fos.close();
				                            bos.close();
				                            socket.close();
				                            ss.close();
											
											JOptionPane.showMessageDialog(null,"Software list Successfully Stored on Server Device","",JOptionPane.PLAIN_MESSAGE);

				                      /*      InputStream sin = socket.getInputStream();
				                            ObjectInputStream in = new ObjectInputStream(sin);
				                            ImageIcon i = (ImageIcon) in.readObject();
				                            RemoteImage ri = new RemoteImage();
				                            ri.updateScreen(i);
				                            in.close();
				                            sin.close();
				                            ss.close();
				                            socket.close();*/
				                    }
				                    catch(Exception e)
				                    {
				                        System.out.println("getting image exception  "+e);
				                        e.printStackTrace();
				                    }
				    }	
	 else{
		 try{
		 //initComponents();
		 JOptionPane.showMessageDialog(null,"Select The Machine ","",JOptionPane.ERROR_MESSAGE);
		 System.out.println("hi");
		}catch(Exception e)
                    {}
		 }
			}
        		
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
// TODO add your handling code here:
      //String getSource  
	
	if(jTable1.getSelectedRow()!=-1)
	 {
		
				 try
                    {
                        int i =jTable1.getSelectedRow();
                        address = InetAddress.getByName(compname.get(i+1).toString());
                        String tempIP = address.toString().split("/")[1];

                        Socket socket = new Socket(tempIP,8080);

                        InputStream sin = socket.getInputStream();
                        OutputStream sout = socket.getOutputStream();
                        DataInputStream in = new DataInputStream(sin);
                        DataOutputStream out = new DataOutputStream(sout);
                        String line = null;
                        out.writeUTF("image");
                        out.flush();
                        socket.close();
                    }
                    catch(Exception e)
                    {
                        //
System.out.println("video request"+e);
					
                    }

                    try
                    {
                            System.out.println("creating server");
                            ServerSocket ss = new ServerSocket(8081);
                            System.out.println("waiting for client");
                            Socket socket = ss.accept();
                            System.out.println("got client");

                            InputStream sin = socket.getInputStream();
                            ObjectInputStream in = new ObjectInputStream(sin);
                            ImageIcon i = (ImageIcon) in.readObject();
                            RemoteImage ri = new RemoteImage();
                            ri.updateScreen(i);
                            in.close();
                            sin.close();
                            ss.close();
                            socket.close();
                    }
                    catch(Exception e)
                    {
                        System.out.println("getting image exception  "+e);
                        e.printStackTrace();
                    }
	}	
	 else{
		 try{
		 //initComponents();
		 JOptionPane.showMessageDialog(null,"Select The Machine ","",JOptionPane.ERROR_MESSAGE);
		 System.out.println("hi");
		}catch(Exception e)
                    {}
		 }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
	if(jTable1.getSelectedRow()!=-1)
	 {
         try
                {
                 int i =jTable1.getSelectedRow();
                 address = InetAddress.getByName(compname.get(i+1).toString());
                 String tempIP = address.toString().split("/")[1];

                        Socket socket = new Socket(tempIP,8080);

                        InputStream sin = socket.getInputStream();
                        OutputStream sout = socket.getOutputStream();
                        DataInputStream in = new DataInputStream(sin);
                        DataOutputStream out = new DataOutputStream(sout);
                        String line = null;
                        String shutdown = ("shutdown -s -t 20");
                        out.writeUTF(shutdown);
                        out.flush();
                        socket.close();
						//System.out.println(compname);
                }
                catch(UnknownHostException e)
                {
                     System.out.println("unknown host Error  "+e);
                }
                catch(Exception e)
                {
                    System.out.println("jtable selection "+e);
                }

                    try
                    {
                            System.out.println("creating server");
                            ServerSocket ss = new ServerSocket(8081);
                            System.out.println("waiting for client");
                            Socket socket = ss.accept();
                            System.out.println("got client");
                            //new Socket(ipAddress, serverPort); // create a socket with the server's IP address and server's port.

                            InputStream sin = socket.getInputStream();
                            OutputStream sout = socket.getOutputStream();

                            DataInputStream in = new DataInputStream(sin);
                            DataOutputStream out = new DataOutputStream(sout);

                            while(true)
                            {
                                    try
                                    {
                                                System.out.println("Byeeeeeee!!!!!");
                                                break;
                                    }
                                    catch(Exception e)
                                    {
                                            System.out.println(e);
                                    }
                            }
                            out.flush();
                            out.close();
                            ss.close();
                            socket.close();
                    }
                    catch(Exception ee)
                    {
                            System.out.println (ee);
                    }
					    }	
	 else{
		 try{
		 //initComponents();
		 JOptionPane.showMessageDialog(null,"Select The Machine ","",JOptionPane.ERROR_MESSAGE);
		 System.out.println("hi");
		}catch(Exception e)
                    {}
		 }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
if(jTable1.getSelectedRow()!=-1)
	 {
          try
                {
                 int i =jTable1.getSelectedRow();
                 address = InetAddress.getByName(compname.get(i+1).toString());
                 String tempIP = address.toString().split("/")[1];

                        Socket socket = new Socket(tempIP,8080);

                        InputStream sin = socket.getInputStream();
                        OutputStream sout = socket.getOutputStream();
                        DataInputStream in = new DataInputStream(sin);
                        DataOutputStream out = new DataOutputStream(sout);
                        String line = null;
                        String restart = ("shutdown -r -t 20");
                        out.writeUTF(restart);
                        out.flush();
                        socket.close();
                }
                catch(UnknownHostException e)
                {
                     System.out.println("unknown host Error  "+e);
                }
                catch(Exception e)
                {
                    System.out.println("jtable selection "+e);
                }

                    try
                    {
                            System.out.println("creating server");
                            ServerSocket ss = new ServerSocket(8081);
                            System.out.println("waiting for client");
                            Socket socket = ss.accept();
                            System.out.println("got client");
                            //new Socket(ipAddress, serverPort); // create a socket with the server's IP address and server's port.

                            InputStream sin = socket.getInputStream();
                            OutputStream sout = socket.getOutputStream();

                            DataInputStream in = new DataInputStream(sin);
                            DataOutputStream out = new DataOutputStream(sout);



                            while(true)
                            {
                                    try
                                    {
                                                System.out.println("Byeeeeeee!!!!!");
                                                break;
                                    }
                                    catch(Exception e)
                                    {
                                            System.out.println(e);
                                    }
                            }
                            out.flush();
                            out.close();
                            ss.close();
                            socket.close();
                    }
                    catch(Exception ee)
                    {
                            System.out.println (ee);
                    }
							    }	
	 else{
		 try{
		 //initComponents();
		 JOptionPane.showMessageDialog(null,"Select The Machine ","",JOptionPane.ERROR_MESSAGE);
		 System.out.println("hi");
		}catch(Exception e)
                    {}
		 }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange
// TODO add your handling code here:
    
	}//GEN-LAST:event_jTable1PropertyChange

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
// TODO add your handling code here:
            //System.out.println("event "+jTable1.getSelectedRow());
			/*
           if(flag==0)
            {
                flagrow = jTable1.getSelectedRow();
                flag =1;
            }
            else if(flagrow==jTable1.getSelectedRow())
            {
            if (jTable1.getSelectedRow()!=-1)
            {
				System.out.println(compname);
                    try
                    {
                        int i =jTable1.getSelectedRow();
                        address = InetAddress.getByName(compname.get(i+1).toString());
                        String tempIP = address.toString().split("/")[1];
                        taskmachineIP = tempIP;

                        Socket socket = new Socket(tempIP,8080);

                        InputStream sin = socket.getInputStream();
                        OutputStream sout = socket.getOutputStream();
                        DataInputStream in = new DataInputStream(sin);
                        DataOutputStream out = new DataOutputStream(sout);
                        String line = null;
                        out.writeUTF("tasklist");
                        out.flush();
                        socket.close();
						//System.out.println(compname);
                }
                catch(UnknownHostException e)
                {
                     System.out.println("unknown host Error  "+e);
                }
                catch(Exception e)
                {
                    System.out.println("jtable selection "+e);
                }

                    try
                    {
                            System.out.println("creating server");
                            ServerSocket ss = new ServerSocket(8081);
                            System.out.println("waiting for client");
                            Socket socket = ss.accept();
                            System.out.println("got client");
                            //new Socket(ipAddress, serverPort); // create a socket with the server's IP address and server's port.

                            InputStream sin = socket.getInputStream();
                            OutputStream sout = socket.getOutputStream();

                            DataInputStream in = new DataInputStream(sin);
                            DataOutputStream out = new DataOutputStream(sout);

                            String cmd = "";
                            tasklst = new Vector();

                            while(true)
                            {
                                    try
                                    {
                                            cmd = in.readUTF();
                                            if(cmd.equals("bye"))
                                                break;
											if(cmd.contains("Console"))
												tasklst.add(cmd);

                                    }
                                    catch(Exception e)
                                    {
                                            System.out.println(e);
                                    }
                            }
							
							
							
							// this code is use for datasaving
                            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
                            Date date = new Date();
                            System.out.println(dateFormat.format(date));
                            
							Collections.sort(tasklst);
							String abc ="";
							for (int i = 0; i < tasklst.size(); i++) {
								abc = abc +  (String)tasklst.get(i)+"\n";
								
							}
							//System.out.println("----------------"+abc);							
							
							 File file = new File("C://Users/nishant/Desktop/Virtual Desktop/Database",compname.get(1)+".xls");
							 FileWriter fr = null;
							try {
							fr = new FileWriter(file);			
							fr.write(abc);
							} catch (IOException e) {
							e.printStackTrace();
        }finally{
            //close resources
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
							
                            out.flush();
                            out.close();
                            ss.close();
                            socket.close();
                    }
                    catch(Exception ee)
                    {
                            System.out.println (ee);
                    }

                    try
                    {
                                        tasklst.remove(0);
                                        tasklst.remove(1);

                                        task_list = new Object[tasklst.size()][5];

                                        for(int j=0;j<tasklst.size()-1;j++)
                                        {
                                        int i=0,k=1;
                                        StringTokenizer tasktoken = new StringTokenizer(tasklst.get(j).toString()," ");
                                        while(tasktoken.hasMoreTokens())
                                        {
                                            String temp = tasktoken.nextToken().toString();
                                            //System.out.println(j+" "+k+" "+i);
                                            if(i!=3&&i<=4)
                                                if(i==4)
                                                {
                                                    task_list[j][0] = new Boolean(false);
                                                    task_list[j][k++] = temp.trim()+" KB";
                                                }
                                                else
                                                {
                                                    task_list[j][0] = new Boolean(false);
                                                    task_list[j][k++] = temp.trim();
                                                }
                                            i++;
                                        }
                                        }

                                        try
                                        {
                                            this.setVisible(false);
                                            TaskList taskList = new TaskList(task_list,taskmachineIP);
                                        }
                                        catch(Exception e)
                                        {
                                            e.printStackTrace();
                                                JOptionPane.showMessageDialog(this,"Cant Launch TaskList......");
                                        }

//                                        for(int i=0;i<tasklst.size()-1;i++)
//                                            System.out.println(task_list[i][0]+ " "+task_list[i][1]+" "+task_list[i][2]+" "+task_list[i][3]);
                    }
                    catch(Exception e)
                    {
                        System.out.println("exception while tasklist "+e);
                        e.printStackTrace();
                    }

            }//end if
            flag=0;
            }*/
    }//GEN-LAST:event_jTable1MouseClicked
	
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
        screenrefresh();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
	private  JProgressBar jpb;
	private JPanel Panel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton7,jButton8;//View and Application
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
