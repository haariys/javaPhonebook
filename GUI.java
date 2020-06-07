    import javax.swing.*;
    import java.sql.*;
    import java.awt.*;

import java.awt.Color;
import java.awt.event.*;//import java.awt.Color.*;
    public class GUI { 
   static String outputres="";
   static String[] res= new String[10];
    	static String dbURL = "jdbc:mysql://127.0.0.1:3308/phonebook";
        static String username = "root";
        static String password = "";
        static int eid1=0;
      
    public static void main(String[] args) {
    	// JTextlabel label1=new JTextlabel();
       final JFrame f=new JFrame("");  
        JButton b=new JButton("View Contact");  

        JButton b1=new JButton("Login");  
        
        b.setBounds(50,100,125,30);b1.setBounds(250,100,95,30);  
        f.add(b);f.add(b1);
        f.setSize(400,400);  
        f.setLayout(null);  f.setLocationRelativeTo(null);
        f.setVisible(true); 
       final JLabel tl =new JLabel();  
       
       final JPanel pl = new JPanel();
       pl.setBounds(50,140,300,100);    
       pl.setBackground(Color.pink); 
       f.add(pl);
       pl.setVisible(false);
       final JTextField tf= new JTextField();
        tl.setBounds(20,20, 150,20);tf.setBounds(55,55,150,20);  
    	f.getContentPane().setBackground(Color.CYAN);
        final JButton b3=new JButton("OK");final JButton b4=new JButton("Search");
		final JButton add1=new JButton("Add"); final JButton edit1=new JButton("Edit"); final JButton del1=new JButton("Delete"); 
		final JTextField editid = new JTextField ();
		final JTextField delid = new JTextField();
 final JButton editok = new JButton(); editok.setText("ok"); editid.setText("enter id");
		final JButton delok = new JButton(); delok.setText("ok"); delid.setText("enter id");
		final JTextField ename = new JTextField();final JTextField ephone = new JTextField();final JTextField eaddress = new JTextField();
		final JButton editok1 = new JButton ();
		final JTextField tf1= new JTextField();
		//final JTextField tf2= new JTextField();
		final JPasswordField tf2= new JPasswordField();
		tf1.setText("admin");tf2.setText("admin");
		tf1.setBounds(55,255,150,20);
		tf2.setBounds(55,285,150,20);b3.setBounds(255,265,70,40);b4.setBounds(235,55,80,20);
		f.add(tf1);f.add(tf2);f.add(b3);f.add(b4);
		b4.setVisible(false);
		 f.add(tl);       f.add(tf);
 		tl.setText("Enter Contact Name Here");
 	            tf.setText("umad");

       		 tl.setVisible(false);       tf.setVisible(false);
        		tf1.setVisible(false);tf2.setVisible(false);b3.setVisible(false);
        		
        		final JTextField addname = new JTextField();final JTextField addph = new JTextField();final JTextField addadd = new JTextField();
        		//addname.setBounds(10,55,140,30);addph.setBounds(10,155,140,30);addadd.setBounds(10,255,140,30);
        		addname.setText("NAME");addph.setText("Phone");addadd.setText("Address");
        		final JButton addok = new JButton();
        		addok.setText("OK");editok1.setText("ok");
        //		addok.setBounds(150,40,40,20);
        	//	addok.setPreferredSize(new Dimension(150,50));
        		//addok.setSize(new Dimension(50, 50));
        	//	addok.setLocation(50, 135);
        		//addname.setLocation(10,55);addph.setLocation(10,155);addadd.setLocation(10,255);
        		//addname.setPreferredSize(new Dimension(140,30));addph.setPreferredSize(new Dimension(140,30));addadd.setPreferredSize(new Dimension(140,30));
        		
 	            ////////////////////////////////////////////////////////////////////
        //These
        //			are
        //					actions
        b.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  
        		 tl.setVisible(true);       tf.setVisible(true);
        		 b4.setVisible(true);
        		       
        	            
        	        }  
        	    });
        b1.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  
        	
        		tf1.setVisible(true);tf2.setVisible(true);b3.setVisible(true);
        	        }  
        	    });
        b3.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  
        	
        		String user = tf1.getText();
        		String pass = tf2.getText();
        		tf1.setText("");tf2.setText("");
        		if(user.equals("admin") && pass.equals("admin")) {
        			
        			final JDialog d = new JDialog(f , "Results", true);  
        			d.setLayout( new FlowLayout() );
                    d.add( new JLabel ("LOGIN SUCCESS"));  d.add(add1);d.add(edit1);d.add(del1);
                    d.setSize(400,300); 
                    d.setVisible(true);
                  
                    
        		}
        		else {
        			final JDialog d = new JDialog(f , "Results", true);  
                    d.setLayout( new FlowLayout() );
                    d.add( new JLabel ("WRONG credentials"));  
                    d.setSize(400,300);    
                    d.setVisible(true); 
        		}
        		
        	        }  
        	
        	    });
        b4.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  
        	
        		pl.setVisible(true);
        		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
           	     
        	    	   System.out.println("Connection successful"); 
        	    	   String inputtext = tf.getText();
               		String sql = "SELECT * FROM `contact` WHERE `name`='"+inputtext+"'";
               		 
               		Statement statement = conn.createStatement();
               		ResultSet result = statement.executeQuery(sql);
               		 
               		int count = 0;
               		 
               		while (result.next()){
               		    String name = result.getString(2);
               		    String phone = result.getString(3);
               		 String address = result.getString(4);
            		    //String fullname = result.getString("fullname");
               		    //String email = result.getString("email");
               		 
               		    String output = "User #%d: %s - %s - %s";
               		    outputres=String.format(output, count, name, phone, address);
               		    res[count]=outputres;
               		    count++;
               		    System.out.println();
               		
               		   
               		}
               		final JDialog d = new JDialog(f , "Results", true);  
                    d.setLayout( new FlowLayout() );  
                    JButton b = new JButton ("OK");  
                    b.addActionListener ( new ActionListener()  
                    {  
                        public void actionPerformed( ActionEvent e )  
                        {  
                            d.setVisible(false);  
                        }  
                    }); 
                   
               	 

                 int i =0;
                 while(i < res.length) {
                	 d.add(new JLabel (res[i]));
                	 i++;
                	 };
                 
                 d.add( new JLabel ("Click button to continue."));  
                 d.add(b);      d.setSize(400,300);    
                 d.setVisible(true); 
                      }  
              
        	    	 catch (SQLException ex) {
        	    	  //  ex.printStackTrace();
        	    	    final JDialog d = new JDialog(f , "ERROR", true);  
     	 				d.add( new JLabel ("something went wrong try again!"));
 			d.setSize(250,50); 
             d.setVisible(true);
        	    	}
        	} 	    });
        add1.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  

        		final JDialog d = new JDialog(f , "add", true);  
    			d.setLayout( new GridLayout());
    			//addok.setBounds(150,40,40,20);
    		//	addname.setBounds(10,10,140,20);addph.setBounds(10,50,140,20);addadd.setBounds(10,100,140,20);
                d.add( new JLabel ("add"));d.add(addok);  d.add(addname);d.add(addph);d.add(addadd);
                d.setSize(600,150); 
                d.setVisible(true);
                
    				}  
        	    });
        addok.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  
        		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
              	     
        			String sql = "INSERT INTO contact (id,name, phone, address) VALUES (?, ?, ?, ?)";
        			 
        			PreparedStatement statement = conn.prepareStatement(sql);

        			int id =1;
        			statement.setInt(1, id);
        			statement.setString(2, addname.getText());
        			statement.setString(3, addph.getText());
        			statement.setString(4, addadd.getText());
        			//statement.setString(4, "bill.gates@microsoft.com");
        			id++;
        			 
        			int rowsInserted = statement.executeUpdate();
        			if (rowsInserted > 0) {
        				final JDialog d = new JDialog(f , "success", true);  
        			//d.setLayout( new GridLayout());
        				d.add( new JLabel ("Sucess!"));
        			d.setSize(100,50); 
                    d.setVisible(true);
        			} 
        			else {
        				final JDialog d = new JDialog(f , "error", true);  
            			//d.setLayout( new GridLayout());
            				d.add( new JLabel ("ERROR!"));
            			d.setSize(100,50); 
                        d.setVisible(true);
                        
        			}
                   }  
           
     	    	 catch (SQLException ex) {
     	    	//    ex.printStackTrace();
     	    		 final JDialog d = new JDialog(f , "ERROR", true);  
 	 				d.add( new JLabel ("something went wrong try again!"));
			d.setSize(250,50); 
         d.setVisible(true);
     	    	}

        		
    				}  
        	    });
        editok.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  
        		

        		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
        			final JDialog d = new JDialog(f , "edit", true);  
    			d.setLayout( new GridLayout());
    			d.setSize(600,150);
                
        			String eid = editid.getText();
      			  eid1 = Integer.parseInt(eid);
             		
            		String sql = "SELECT * FROM `contact` WHERE `id`='"+eid1+"'";
            		Statement statement = conn.createStatement();
               		ResultSet result = statement.executeQuery(sql);
               		while(result.next()) {
               		String name = result.getString(2);
           		    String phone = result.getString(3);
           		 String address = result.getString(4);
           		 ename.setText(name);ephone.setText(phone);eaddress.setText(address);
        			//eid.getText();
     			d.add(ename);d.add(ephone);d.add(eaddress);d.add(editok1);
           		d.setVisible(true);}
        		}
        		 catch (SQLException ex) {
       	    	    //ex.printStackTrace(); 
       	    	    final JDialog d = new JDialog(f , "ERROR", true);  
 	 				d.add( new JLabel ("something went wrong try again!"));
			d.setSize(250,50); 
         d.setVisible(true);
       	    	}
        		
               
                        	}  
        	    });
        del1.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  
        		final JDialog d = new JDialog(f , "delete", true);  
    			d.setLayout( new GridLayout());
    			d.setSize(600,150);
    			d.add(delid);d.add(delok);
                d.setVisible(true);
                        	}  
        	    });
        editok1.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  

        		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
        			
             		
            		String sql1 = "UPDATE contact SET name=?, phone=?, address=? WHERE id=?";
        			 
        			PreparedStatement statement1 = conn.prepareStatement(sql1);
        			statement1.setString(1, ename.getText());
        			statement1.setString(2, ephone.getText());
        			statement1.setString(3, eaddress.getText());
        			statement1.setString(4,  String.valueOf(eid1));
        			 
        			int rowsUpdated = statement1.executeUpdate();
        			if (rowsUpdated > 0) {	final JDialog d = new JDialog(f , "success", true);  
        			//d.setLayout( new GridLayout());
    				d.add( new JLabel ("Sucess!"));
    			d.setSize(100,50); 
    			//d.add(ename);d.add(ephone);d.add(eaddress);d.add(editok1);
                d.setVisible(true);}
        			else {
        				final JDialog d = new JDialog(f , "error", true);  
            			//d.setLayout( new GridLayout());
            				d.add( new JLabel ("error!"));
            			d.setSize(100,50); 
                        d.setVisible(true);
        			}
        		}
        		 catch (SQLException ex) {
       	//    	    ex.printStackTrace();
       	    	 final JDialog d = new JDialog(f , "ERROR", true);  
     	 				d.add( new JLabel ("something went wrong try again!"));
 			d.setSize(250,50); 
             d.setVisible(true);
       	    	}
        		
                        	}  
        	    });
        edit1.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  
        		final JDialog d = new JDialog(f , "edit", true);  
    			d.setLayout( new GridLayout());
    			d.add(editid);d.add(editok);
    			//editid.getText();
    			//String eid = editid.getText();
    			//  eid1 = Integer.parseInt(eid);
    			d.setSize(600,150);
    			

                d.setVisible(true);
                
                
        		
                        	}  
        	    });
        delok.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  
        		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
        			
        			String sql = "DELETE FROM contact WHERE id=?";
        			 
        			PreparedStatement statement = conn.prepareStatement(sql);
        			statement.setString(1, delid.getText());
        			 
        			int rowsDeleted = statement.executeUpdate();
        			if (rowsDeleted > 0) { final JDialog d = new JDialog(f , "success", true);  
 	 				d.add( new JLabel ("deleted!"));
			d.setSize(100,50); 
         d.setVisible(true);
   	    	}
        			
        			
        		}
        		 catch (SQLException ex) {
        		       	  	    ex.printStackTrace();
        		       	    	 final JDialog d = new JDialog(f , "ERROR", true);  
        		     	 				d.add( new JLabel ("something went wrong try again!"));
        		 			d.setSize(250,50); 
        		             d.setVisible(true);
        		       	    	}
                        	}  
        	    });
    }  
    }  