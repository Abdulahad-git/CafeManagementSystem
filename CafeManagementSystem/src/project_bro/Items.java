package project_bro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Items extends javax.swing.JFrame {
	
	ResultSet rs = null;
	Connection con=null;
	Statement st=null;
	PreparedStatement pst;
	ResultSetMetaData rsmd;
	DefaultTableModel model = new DefaultTableModel();
	DefaultTableModel model1 = new DefaultTableModel();
	public int tcolumn;
	//used variable for Table data
	   

    /**
     * Creates new form Items
     */
	
	
    public Items() {
    	
    	
        initComponents();
        showdata();
        setVisible(true);
        ImageIcon im=new ImageIcon("coffee-shop.png");
        this.setIconImage(im.getImage());
        jTable1.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
		    	int MyIndex=jTable1.getSelectedRow();
		    	Key=Integer.valueOf(model.getValueAt(MyIndex, 0).toString());
		    	PrNameTb.setText(model.getValueAt(MyIndex, 1).toString());
		    	PriceTb.setText(model.getValueAt(MyIndex, 3).toString());
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}});
    }
    
    int Key=0;
    
    private void jTable1MouseClickListener(java.awt.event.MouseEvent evt) {
    	DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
    	int MyIndex=jTable1.getSelectedRow();
    	Key=Integer.valueOf(model.getValueAt(MyIndex, 0).toString());
    	PrNameTb.setText(model.getValueAt(MyIndex, 1).toString());
    	
    }

   
    public void showdata() {
    	    int id=0;
    	    String pName = "";
    	    String Categ = "";
    	    int cost=0;
    	
        try {
        	jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            jTable1.setModel(model);
            jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            String[] col= {"Product ID","Name","Category","Price"};
            model.setColumnIdentifiers(col);
        	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Cafedb","root","abdulahad@8126");
			pst = con.prepareStatement("select * from producttb;");
			rs=pst.executeQuery();
			rsmd=rs.getMetaData();
			
			System.out.println(tcolumn);
			while(rs.next()) {
				tcolumn=rs.getInt(1);
                id = rs.getInt("pNum");
                pName = rs.getString("pName");
                Categ = rs.getString("Category");
                cost = rs.getInt("price");
                model.addRow(new Object[]{id,pName,Categ,cost});
              
              
             //  con.close();
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
   
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
     
    
    private void initComponents() {
    	
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PrNameTb = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        PrCatCb = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        PriceTb = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        this.setSize(1650,1080);
        this.setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 255, 204));
        this.setUndecorated(true);
        //setPreferredSize(new java.awt.Dimension(1366, 768));

        jPanel1.setBackground(new java.awt.Color(165, 83, 80));

        jPanel2.setBackground(new java.awt.Color(102, 0, 0));

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 204));
        jLabel1.setText("Cafe Managent System");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(606, 606, 606)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 204));
        jLabel2.setText("Product:");

        PrNameTb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PrNameTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrNameTbActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 204, 204));
        jLabel3.setText("Category :");

        PrCatCb.setBackground(new java.awt.Color(255, 204, 204));
        PrCatCb.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        PrCatCb.setForeground(new java.awt.Color(255, 102, 102));
        PrCatCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Snack", "Beverage", "Juice", "Mocktail", "Ice cream", "" }));
        PrCatCb.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 204));
        jLabel4.setText("Price  :");

        PriceTb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PriceTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PriceTbActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 153, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	Items i=new Items();
            	if(PrNameTb.getText().isEmpty()||PriceTb.getText().isEmpty()||PrCatCb.getSelectedIndex()==-1)
            	{
            		
            		JOptionPane.showMessageDialog(i,"Missing Information");
            	}
            	else {
            		try {
        				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Cafedb","root","abdulahad@8126");
        				PreparedStatement Pst=con.prepareStatement("insert into ProductTb"
        						+ " values(?,?,?,?)");
        				
        				
        				tcolumn+=1;
        				String f=PrNameTb.getText();
        				String g=PrCatCb.getSelectedItem().toString();
        				String h=PriceTb.getText();
        				Pst.setInt(1,tcolumn);
        				Pst.setString(2, PrNameTb.getText());
        				Pst.setString(3, PrCatCb.getSelectedItem().toString());
        				Pst.setInt(4,Integer.valueOf(PriceTb.getText()));
        				int row=Pst.executeUpdate();
        				pst = con.prepareStatement("select * from producttb;");
        				rs=pst.executeQuery();
        				model.addRow(new Object[]{tcolumn,f,g,h});
        				
        				JOptionPane.showMessageDialog(i,"Item Added");
        				
        				con.close();
        			} catch (SQLException e) {
        				// TODO Auto-generated catch block
        				JOptionPane.showMessageDialog(i, e);
        			}
            		
            	}
                         
            }
        });

//jButton1.AddBtnActionPerformed(new Items());

        jButton2.setBackground(new java.awt.Color(255, 153, 153));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Update");
        
        
        jButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(PrNameTb.getText().isEmpty()||PriceTb.getText().isEmpty()||PrCatCb.getSelectedIndex()==-1) {
					JOptionPane.showMessageDialog(new Items(),"Missing Information");
				}
				else {
					try {
				int	d=Integer.valueOf(JOptionPane.showInputDialog("Confirm By Entering Procduct ID:"));
					//if(d==0) {JOptionPane.showMessageDialog(null, "Enter the corrct Product ID:");}
					System.out.println("This is from "+d);
				
					//int t=Integer.valueOf(JOptionPane.showInputDialog("product ID:"));
					//System.out.println("This is from OPTION PABEL:"+t);
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Cafedb","root","abdulahad@8126");
					Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/Cafedb","root","abdulahad@8126");
					
					PreparedStatement  Pst=con.prepareStatement("update producttb set PName=?,Category=?,Price=? where PNum=?;");
				    Pst.setInt(4,d);
					Pst.setString(1,PrNameTb.getText().toString());
					Pst.setString(2,PrCatCb.getSelectedItem().toString());
					Pst.setInt(3, Integer.valueOf(PriceTb.getText()));
					int row=Pst.executeUpdate();
					model.setRowCount(0);
					showdata();
					
					JOptionPane.showMessageDialog(new Items(),"Updated Successfully");
					con.close();
					
				} catch (SQLException e1) {
					
					JOptionPane.showMessageDialog(new Items(),"Done");
				}
				catch(NumberFormatException ne) {
					JOptionPane.showMessageDialog(new Items(), "Enter the corrct Product ID:");
					
				}}}});
       
         
    	
        
        
        jButton3.addActionListener(new ActionListener() {
              int Key1;
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					model1.setRowCount(0);
					jTable1.revalidate();
					
					DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
			    	int MyIndex=jTable1.getSelectedRow();
			    	Key1=Integer.valueOf(model.getValueAt(MyIndex, 0).toString());
			    	PrNameTb.setText(model.getValueAt(MyIndex, 1).toString());
			    	PriceTb.setText(model.getValueAt(MyIndex, 3).toString());
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Cafedb","root","abdulahad@8126");
				   // Statement st=con.createStatement();
				   String nam=PrNameTb.getText();
				   System.out.println("PrName"+nam);
				   PreparedStatement pst1=con.prepareStatement("select pNum from producttb where PName='"+nam+"';");
					ResultSet rs1=pst1.executeQuery();
					rs1.next();
					int fop=rs1.getInt(1);
					
					PreparedStatement pst2=con.prepareStatement("delete from producttb where PNum="+fop+";");
					pst2.execute();
					System.out.println("This is from delete "+fop);
					
				    Items i=new Items();
					JOptionPane.showMessageDialog(i,"deleted");
	
					System.out.println("thi is"+jTable1.getRowCount());
					//con.close();
					
					model.setRowCount(0);
				
					showdata();
					con.close();
					
					System.out.println(jTable1.getSelectedRow()); 
				//	model.setRowCount(fop);
					
					
					System.out.println("from delete button");
				} catch(SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				catch(ArrayIndexOutOfBoundsException ae) {
					Items it=new Items();
					JOptionPane.showMessageDialog(it,"Empty");
				}
				
			}});
        
        jButton3.setBackground(new java.awt.Color(255, 153, 153));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Delete");
        javax.swing.table.DefaultTableModel model= new javax.swing.table.DefaultTableModel();
        
        
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setFont(new java.awt.Font("Tunga", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 204, 204));
        jLabel5.setText("  Items");
        jLabel5.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        	public void jLabel5MouseClicked(MouseEvent evt) {
        		Sale ii=new Sale();
        		ii.setVisible(true);
        		System.out.println("MOuse CLicked");
        	}
        });
        
        jLabel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 153, 153), new java.awt.Color(255, 153, 153), new java.awt.Color(255, 153, 153), new java.awt.Color(255, 153, 153)));

        jLabel6.setFont(new java.awt.Font("Tunga", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 204, 204));
        jLabel6.setText("  Log Out");
        jLabel6.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6mouseClicked(evt);
            }
        	public void jLabel6mouseClicked(MouseEvent evt) {
        		dispose();
        	}
        });
        jLabel6.setBounds(10, 20, 50, 50);
        jLabel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 153, 153), new java.awt.Color(255, 153, 153), new java.awt.Color(255, 153, 153), new java.awt.Color(255, 153, 153)));

        jLabel7.setFont(new java.awt.Font("Tunga", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 204, 204));
        jLabel7.setText("  Selling");
        jLabel7.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7mouseClicked(evt);
            }
        	public void jLabel7mouseClicked(MouseEvent evt) {
        		ViewSale vs=new ViewSale();
        		vs.setVisible(true);
        	}
        });
        jLabel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 153, 153), new java.awt.Color(255, 153, 153), new java.awt.Color(255, 153, 153), new java.awt.Color(255, 153, 153)));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 204, 204));
        jLabel8.setText("Filter  :");

        jComboBox2.setBackground(new java.awt.Color(255, 204, 204));
        jComboBox2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(255, 102, 102));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Beverage", "Juice", "Mocktail", "Ice cream", "Snack" }));
        jComboBox2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        
        
        jComboBox2.addItemListener(new ItemListener() {
            
			@Override
			public void itemStateChanged(ItemEvent e) {
				String selCat=jComboBox2.getSelectedItem().toString();
				switch(selCat) {
				case "All":
				{
					if(e.getStateChange()==ItemEvent.SELECTED)
					{System.out.println(e.getStateChange());
					try {
						model1.setRowCount(0);
					int id=0;
		    	    String pName = "";
		    	    String Categ = "";
		    	    int cost=0;
		    	    jTable1.setModel(model1);
		            jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		            String[] col= {"Product ID","Name","Category","Price"};
		            model1.setColumnIdentifiers(col);
		        	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Cafedb","root","abdulahad@8126");
					pst = con.prepareStatement("select * from producttb;");
					rs=pst.executeQuery();
					rsmd=rs.getMetaData();
					
					System.out.println(tcolumn);
					while(rs.next()) {
						//tcolumn=rs.getInt(1);
		                id = rs.getInt("pNum");
		                pName = rs.getString("pName");
		                Categ = rs.getString("Category");
		                cost = rs.getInt("price");
		                model1.addRow(new Object[]{id,pName,Categ,cost});}
		              
		                jTable1.revalidate();
		           // con.close();
		            
				     } catch(Exception we) {
					
				     	we.printStackTrace();
				     }
					
	        	
				    }
					break;}
				default:
					if(e.getStateChange()==ItemEvent.SELECTED)
					{System.out.println(e.getStateChange());
					try {
						model1.setRowCount(0);
					int id=0;
		    	    String pName = "";
		    	    String Categ = "";
		    	    int cost=0;
		    	    jTable1.setModel(model1);
		            jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		            String[] col= {"Product ID","Name","Category","Price"};
		            model1.setColumnIdentifiers(col);
		        	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Cafedb","root","abdulahad@8126");
					pst = con.prepareStatement("select * from producttb where Category='"+jComboBox2.getSelectedItem().toString()+"';");
					rs=pst.executeQuery();
					rsmd=rs.getMetaData();
					
					System.out.println(tcolumn);
					while(rs.next()) {
						//tcolumn=rs.getInt(1);
		                id = rs.getInt("pNum");
		                pName = rs.getString("pName");
		                Categ = rs.getString("Category");
		                cost = rs.getInt("price");
		                model1.addRow(new Object[]{id,pName,Categ,cost});}
		              
		                jTable1.revalidate();
		           // con.close();
		            
				} catch(Exception we) {
					
					we.printStackTrace();
				}
					
	        	
				}}}});
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(413, 413, 413)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PrNameTb, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(PrCatCb, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PriceTb, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(685, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(710, 710, 710)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrNameTb, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrCatCb, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PriceTb, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(190, 190, 190))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void PrNameTbActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void PriceTbActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
    	
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Items().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> PrCatCb;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField PrNameTb;
    private javax.swing.JTextField PriceTb;
    // End of variables declaration                   
}
