/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Dashboard;

/**
 *
 * @author Windows 10
 */
import EP.Db;
import EP.Login;
import EP.UserSession;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    private newProduct np;
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Color DefaultColor, ClickedColor;
    Integer userID;
    public Dashboard() {
        initComponents();
        userID = UserSession.getUserID();
        con = Db.myconnection();
        loadCustomer();
        loadProduct();
        fetch();
        fetchprod(); 
        setLocationRelativeTo(null);
        DefaultColor = new Color(51,51,51);
        ClickedColor = new Color(0,255,255);
        jTable3.getColumnModel().getColumn(6).setCellRenderer(new ImageIconCellRenderer());
    }
    private String imagePath;
    class ImageIconCellRenderer implements TableCellRenderer{
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            jTable3.setRowHeight(60);
        if (value instanceof ImageIcon) {
            ImageIcon imageIcon = (ImageIcon) value;
            Image image = imageIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(image);
            JLabel label = new JLabel(scaledIcon);
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.CENTER);
            return label; 
        } else {
            
            return table.getDefaultRenderer(table.getColumnClass(column)).getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bevelBorder1 = (javax.swing.border.BevelBorder)javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED);
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        menu1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        menu2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        menu3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        menu8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        home = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        totalex = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        savings = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        totalin = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        recenttrans = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txtCustname = new javax.swing.JTextField();
        txtCustphone = new javax.swing.JTextField();
        txtCustemail = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtCustaddress = new javax.swing.JTextArea();
        kButton7 = new com.k33ptoo.components.KButton();
        custID = new javax.swing.JComboBox<>();
        kButton1 = new com.k33ptoo.components.KButton();
        custUpdate = new com.k33ptoo.components.KButton();
        custDelete = new com.k33ptoo.components.KButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        searchProd = new com.k33ptoo.components.KButton();
        kButton3 = new com.k33ptoo.components.KButton();
        kButton4 = new com.k33ptoo.components.KButton();
        removeProduct = new com.k33ptoo.components.KButton();
        prodID = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("dashboard");
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 0, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(1073, 500));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/icons8_shutdown_48px_1.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        menu1.setBackground(new java.awt.Color(51, 51, 51));
        menu1.setPreferredSize(new java.awt.Dimension(122, 40));
        menu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menu1MousePressed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("EXPENSES");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/icons8_reception_28px.png"))); // NOI18N

        javax.swing.GroupLayout menu1Layout = new javax.swing.GroupLayout(menu1);
        menu1.setLayout(menu1Layout);
        menu1Layout.setHorizontalGroup(
            menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menu1Layout.setVerticalGroup(
            menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        menu2.setBackground(new java.awt.Color(51, 51, 51));
        menu2.setPreferredSize(new java.awt.Dimension(150, 40));
        menu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menu2MousePressed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(153, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("INCOME");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/icons8_product_28px.png"))); // NOI18N

        javax.swing.GroupLayout menu2Layout = new javax.swing.GroupLayout(menu2);
        menu2.setLayout(menu2Layout);
        menu2Layout.setHorizontalGroup(
            menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu2Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        menu2Layout.setVerticalGroup(
            menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        menu3.setBackground(new java.awt.Color(51, 51, 51));
        menu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu3MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menu3MousePressed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(153, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("BUDGET");

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/icons8_add_shopping_cart_28px.png"))); // NOI18N

        javax.swing.GroupLayout menu3Layout = new javax.swing.GroupLayout(menu3);
        menu3.setLayout(menu3Layout);
        menu3Layout.setHorizontalGroup(
            menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menu3Layout.setVerticalGroup(
            menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu3Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel17))
                .addContainerGap())
        );

        menu8.setBackground(new java.awt.Color(51, 51, 51));
        menu8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu8MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menu8MousePressed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(153, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("REPORTS");

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/icons8_normal_distribution_histogram_28px.png"))); // NOI18N

        javax.swing.GroupLayout menu8Layout = new javax.swing.GroupLayout(menu8);
        menu8.setLayout(menu8Layout);
        menu8Layout.setHorizontalGroup(
            menu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu8Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menu8Layout.setVerticalGroup(
            menu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu8Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(menu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel12))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        home.setBackground(new java.awt.Color(0, 255, 255));
        home.setPreferredSize(new java.awt.Dimension(132, 40));
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                homeMousePressed(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("DASHBOARD");

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/icons8_home_28px.png"))); // NOI18N

        javax.swing.GroupLayout homeLayout = new javax.swing.GroupLayout(home);
        home.setLayout(homeLayout);
        homeLayout.setHorizontalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        homeLayout.setVerticalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel13))
                .addContainerGap())
        );

        jPanel8.setPreferredSize(new java.awt.Dimension(170, 170));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("BROWSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("INSERT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                            .addComponent(menu2, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                            .addComponent(menu3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(menu8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jLabel4))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(29, 29, 29)
                                        .addComponent(jButton2))
                                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(24, 24, 24)
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menu8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(19, 19, 19))
        );

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.setPreferredSize(new java.awt.Dimension(830, 52));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/icons8_cancel_40px.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/icons8_minus_40px.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 255, 255));
        jLabel23.setText("Jeevs");

        jLabel24.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Welcome,");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 475, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24)
                        .addComponent(jLabel23))
                    .addComponent(jLabel7))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(0, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        totalex.setBackground(new java.awt.Color(0, 153, 153));

        jLabel25.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Total Expenses");

        javax.swing.GroupLayout totalexLayout = new javax.swing.GroupLayout(totalex);
        totalex.setLayout(totalexLayout);
        totalexLayout.setHorizontalGroup(
            totalexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalexLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        totalexLayout.setVerticalGroup(
            totalexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalexLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        jPanel3.add(totalex, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 119, -1, -1));

        savings.setBackground(new java.awt.Color(0, 153, 153));
        savings.setForeground(new java.awt.Color(0, 153, 153));
        savings.setPreferredSize(new java.awt.Dimension(233, 112));

        jLabel26.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Savings");

        javax.swing.GroupLayout savingsLayout = new javax.swing.GroupLayout(savings);
        savings.setLayout(savingsLayout);
        savingsLayout.setHorizontalGroup(
            savingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(savingsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addContainerGap(148, Short.MAX_VALUE))
        );
        savingsLayout.setVerticalGroup(
            savingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(savingsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        jPanel3.add(savings, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 308, -1, -1));

        totalin.setBackground(new java.awt.Color(0, 153, 153));
        totalin.setPreferredSize(new java.awt.Dimension(233, 112));

        jLabel27.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Total  Income");

        javax.swing.GroupLayout totalinLayout = new javax.swing.GroupLayout(totalin);
        totalin.setLayout(totalinLayout);
        totalinLayout.setHorizontalGroup(
            totalinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addContainerGap(92, Short.MAX_VALUE))
        );
        totalinLayout.setVerticalGroup(
            totalinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        jPanel3.add(totalin, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 119, -1, -1));

        recenttrans.setBackground(new java.awt.Color(0, 153, 153));
        recenttrans.setPreferredSize(new java.awt.Dimension(233, 112));

        jLabel28.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Recent Transaction");

        javax.swing.GroupLayout recenttransLayout = new javax.swing.GroupLayout(recenttrans);
        recenttrans.setLayout(recenttransLayout);
        recenttransLayout.setHorizontalGroup(
            recenttransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recenttransLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        recenttransLayout.setVerticalGroup(
            recenttransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recenttransLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        jPanel3.add(recenttrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 308, -1, -1));

        jLabel8.setBackground(new java.awt.Color(51, 0, 51));
        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 0, 51));
        jLabel8.setText("EXPENSE TRACKER");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, -1));

        jTabbedPane1.addTab("tab1", jPanel3);

        jPanel5.setBackground(new java.awt.Color(0, 0, 51));

        jTable2.setBackground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Phone", "Email", "Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setFocusable(false);
        jTable2.setOpaque(false);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);

        kGradientPanel2.setkBorderRadius(20);
        kGradientPanel2.setOpaque(false);

        jLabel38.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("NAME:");

        jLabel39.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("PHONE:");

        jLabel40.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("EMAIL:");

        jLabel41.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("ADDRESS:");

        txtCustname.setBackground(new java.awt.Color(255, 255, 255));
        txtCustname.setForeground(new java.awt.Color(0, 0, 0));

        txtCustphone.setBackground(new java.awt.Color(255, 255, 255));
        txtCustphone.setForeground(new java.awt.Color(0, 0, 0));

        txtCustemail.setBackground(new java.awt.Color(255, 255, 255));
        txtCustemail.setForeground(new java.awt.Color(0, 0, 0));

        txtCustaddress.setBackground(new java.awt.Color(255, 255, 255));
        txtCustaddress.setColumns(20);
        txtCustaddress.setForeground(new java.awt.Color(0, 0, 0));
        txtCustaddress.setLineWrap(true);
        txtCustaddress.setRows(5);
        jScrollPane4.setViewportView(txtCustaddress);

        kButton7.setText("ADD");
        kButton7.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        kButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton7ActionPerformed(evt);
            }
        });

        custID.setBackground(new java.awt.Color(255, 255, 255));
        custID.setForeground(new java.awt.Color(0, 0, 0));
        custID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        kButton1.setText("SEARCH ID");
        kButton1.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });

        custUpdate.setText("UPDATE");
        custUpdate.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        custUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custUpdateActionPerformed(evt);
            }
        });

        custDelete.setText("DELETE");
        custDelete.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        custDelete.setPreferredSize(new java.awt.Dimension(185, 31));
        custDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(kButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(custUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(custDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(custID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4)
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCustemail))
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCustname, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCustphone, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(custID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCustname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addGap(56, 56, 56)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCustphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39))
                .addGap(56, 56, 56)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCustemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40))
                .addGap(56, 56, 56)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(custUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(custDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", jPanel5);

        jPanel6.setBackground(new java.awt.Color(0, 0, 51));

        jTable3.setBackground(new java.awt.Color(255, 255, 255));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Quantity", "Price", "Description", "Category", "Picture"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        searchProd.setText("SEARCH");
        searchProd.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        searchProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchProdActionPerformed(evt);
            }
        });

        kButton3.setText("NEW PRODUCT");
        kButton3.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        kButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton3ActionPerformed(evt);
            }
        });

        kButton4.setText("UPDATE PRODUCT");
        kButton4.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        kButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton4ActionPerformed(evt);
            }
        });

        removeProduct.setText("REMOVE PRODUCT");
        removeProduct.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        removeProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeProductActionPerformed(evt);
            }
        });

        prodID.setBackground(new java.awt.Color(255, 255, 255));
        prodID.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(prodID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchProd, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(removeProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchProd, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prodID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab3", jPanel6);

        jPanel7.setBackground(new java.awt.Color(0, 0, 51));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab4", jPanel7);

        jPanel12.setBackground(new java.awt.Color(0, 0, 51));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab9", jPanel12);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu1MouseClicked
       jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_menu1MouseClicked

    private void menu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu1MousePressed
        menu1.setBackground(ClickedColor);
        menu2.setBackground(DefaultColor);
        menu3.setBackground(DefaultColor);
        menu8.setBackground(DefaultColor);
        home.setBackground(DefaultColor);
    }//GEN-LAST:event_menu1MousePressed

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
       jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_homeMouseClicked

    private void homeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMousePressed
        menu1.setBackground(DefaultColor);
        menu2.setBackground(DefaultColor);
        menu3.setBackground(DefaultColor);
        menu8.setBackground(DefaultColor);
        home.setBackground(ClickedColor);
    }//GEN-LAST:event_homeMousePressed

    private void menu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu2MouseClicked
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_menu2MouseClicked

    private void menu2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu2MousePressed
        menu1.setBackground(DefaultColor);
        menu2.setBackground(ClickedColor);
        menu3.setBackground(DefaultColor);
        menu8.setBackground(DefaultColor);
        home.setBackground(DefaultColor);
    }//GEN-LAST:event_menu2MousePressed

    private void menu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu3MouseClicked
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_menu3MouseClicked

    private void menu3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu3MousePressed
        menu1.setBackground(DefaultColor);
        menu2.setBackground(DefaultColor);
        menu3.setBackground(ClickedColor);
        menu8.setBackground(DefaultColor);
        home.setBackground(DefaultColor);
    }//GEN-LAST:event_menu3MousePressed

    private void menu8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu8MouseClicked
       jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_menu8MouseClicked

    private void menu8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu8MousePressed
        menu1.setBackground(DefaultColor);
        menu2.setBackground(DefaultColor);
        menu3.setBackground(DefaultColor);
        menu8.setBackground(ClickedColor);
        home.setBackground(DefaultColor);
    }//GEN-LAST:event_menu8MousePressed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        this.setExtendedState(Dashboard.ICONIFIED);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel6MouseClicked

    public void loadCustomer(){//
        try {
            pst=con.prepareStatement("SELECT customerID FROM customer");
            rs=pst.executeQuery();
            custID.removeAllItems();
            while(rs.next()){
                custID.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void loadProduct(){//
        try {
            pst=con.prepareStatement("SELECT productID FROM product");
            rs=pst.executeQuery();
            prodID.removeAllItems();
            while(rs.next()){
                prodID.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void fetch(){//
        try {
            int query;
            pst=con.prepareStatement("SELECT * FROM customer");
            rs=pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            query = rss.getColumnCount();
            DefaultTableModel dtm = (DefaultTableModel)jTable2.getModel();
            dtm.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for (int i = 1; i < query; i++) {
                    v2.add(rs.getString("customerID"));
                    v2.add(rs.getString("customerName"));
                    v2.add(rs.getString("phoneNumber"));
                    v2.add(rs.getString("email"));
                    v2.add(rs.getString("address"));
                }
                dtm.addRow(v2);
            }
            
            pst = con.prepareStatement("SELECT * FROM customer ORDER BY customerID DESC");
            rs = pst.executeQuery();
            ResultSetMetaData rssDesc = rs.getMetaData();
            int queryDesc = rssDesc.getColumnCount();
            //DefaultTableModel dtm3 = (DefaultTableModel) jTable1.getModel();
            //dtm3.setRowCount(0);
            while (rs.next()) {
                Vector v3 = new Vector();
                for (int i = 1; i <= queryDesc; i++) {
                    v3.add(rs.getString("customerID"));
                    v3.add(rs.getString("customerName"));
                    v3.add(rs.getString("phoneNumber"));
                    v3.add(rs.getString("email"));
                    v3.add(rs.getString("address"));
                }
                //dtm3.addRow(v3);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void fetchprod(){//
    try {
        pst = con.prepareStatement("SELECT * FROM product");
        rs = pst.executeQuery();
        ResultSetMetaData rss = rs.getMetaData();
        int query = rss.getColumnCount();
        DefaultTableModel dtm = (DefaultTableModel)jTable3.getModel();
        dtm.setRowCount(0);
        
        while(rs.next()){
            Vector<Object> v2 = new Vector<>();
            for (int i = 1; i <= query; i++) {
                if (i == query) { 
                    byte[] imageData = rs.getBytes("image");
                    if (imageData != null) {
                        ImageIcon imageIcon = new ImageIcon(imageData);
                        v2.add(imageIcon);
                    } else {
                        v2.add(null);
                    }
                } else {
                    v2.add(rs.getObject(i));
                }
            }
            dtm.addRow(v2);
        }
    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    //ADD CUSTOMER
    private void kButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton7ActionPerformed
        String custname=txtCustname.getText();
        String custphone=txtCustphone.getText();
        String custemail=txtCustemail.getText();
        String custaddress=txtCustaddress.getText();
        
        try {
            pst=con.prepareStatement("INSERT INTO customer (customerName, phoneNumber, email, address) VALUES(?,?,?,?)");
            pst.setString(1, custname);
            pst.setString(2, custphone);
            pst.setString(3, custemail);
            pst.setString(4, custaddress);
            
            int k=pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(this, "CUSTOMER ADDED!");
                txtCustname.setText(" ");
                txtCustphone.setText(" ");
                txtCustemail.setText(" ");
                txtCustaddress.setText(" ");  
                fetch();
                loadCustomer();
            }else{
                JOptionPane.showMessageDialog(this, "CUSTOMER FAILED TO SAVE!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_kButton7ActionPerformed
    //SEARCH COMBO BOX CUSTOMER
    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        try {
            String cid=custID.getSelectedItem().toString();
            pst=con.prepareStatement("SELECT * FROM customer WHERE customerID=?");
            pst.setString(1, cid);
            rs=pst.executeQuery();
            
            if (rs.next()){
                txtCustname.setText(rs.getString(2));
                txtCustphone.setText(rs.getString(3));
                txtCustemail.setText(rs.getString(4));
                txtCustaddress.setText(rs.getString(5));
            }else{
                JOptionPane.showMessageDialog(this, "CUSTOMER DOES NOT EXIST!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_kButton1ActionPerformed
    //UPDATE CUSTOMER
    private void custUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custUpdateActionPerformed
        try {
            String custname=txtCustname.getText();
            String custphone=txtCustphone.getText();
            String custemail=txtCustemail.getText();
            String custaddress=txtCustaddress.getText();
            String cid=custID.getSelectedItem().toString();
            
            pst=con.prepareStatement("UPDATE customer SET customerName=?,phoneNumber=?, email=?, address=? WHERE customerID=?");
            pst.setString(1, custname);
            pst.setString(2, custphone);
            pst.setString(3, custemail);
            pst.setString(4, custaddress); 
            pst.setString(5, cid); 
            int k=pst.executeUpdate();
            if(k==1){
                JOptionPane.showMessageDialog(this, "CUSTOMER UPDATED!");
                txtCustname.setText(" ");
                txtCustphone.setText(" ");
                txtCustemail.setText(" ");
                txtCustaddress.setText(" ");  
                txtCustname.requestFocus();
                fetch();
                loadCustomer();
            }else{
                JOptionPane.showMessageDialog(this, "CUSTOMER FAILED TO UPDATE!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_custUpdateActionPerformed
    //DELETE CUSTOMER
    private void custDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custDeleteActionPerformed
        try {
            String cid=custID.getSelectedItem().toString();
            pst=con.prepareStatement("DELETE FROM customer WHERE customerID=?");
            pst.setString(1, cid);
            int k=pst.executeUpdate();
            if(k==1){
                JOptionPane.showMessageDialog(this, "CUSTOMER DELETED!");
                txtCustname.setText(" ");
                txtCustphone.setText(" ");
                txtCustemail.setText(" ");
                txtCustaddress.setText(" ");  
                txtCustname.requestFocus();
                fetch();
                loadCustomer();
            }else{
                JOptionPane.showMessageDialog(this, "CUSTOMER FAILED TO DELETE!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_custDeleteActionPerformed
    //NEW PRODUCT
    private void kButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton3ActionPerformed
        newProduct np = new newProduct();
        np.setVisible(true);
        np.setLocationRelativeTo(null);
    }//GEN-LAST:event_kButton3ActionPerformed

   // UPDATE PRODUCT
    private void kButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton4ActionPerformed
        editProduct ep = new editProduct();
        ep.setVisible(true);
        ep.setLocationRelativeTo(null);
    }//GEN-LAST:event_kButton4ActionPerformed
    // REMOVE PRODUCT
    private void removeProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeProductActionPerformed
        try {
            String pid=prodID.getSelectedItem().toString();
            pst=con.prepareStatement("DELETE FROM product WHERE productID=?");
            pst.setString(1, pid);
            int k=pst.executeUpdate();
            if(k==1){
                JOptionPane.showMessageDialog(this, "PRODUCT DELETED!");
                fetchprod();
                loadProduct();
            }else{
                JOptionPane.showMessageDialog(this, "PRODUCT FAILED TO DELETE!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_removeProductActionPerformed
    
    private void searchProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchProdActionPerformed
       /* try {
            int query;
            String pid = prodID.getSelectedItem().toString();
            pst = con.prepareStatement("SELECT * FROM product WHERE productID=?");
            pst.setString(1, pid);
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            query = rss.getColumnCount();
            DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
            dtm.setRowCount(0);

            if (rs.next()) {           
                Vector<Object> v2 = new Vector<>();
                v2.add(rs.getString("productID"));
                v2.add(rs.getString("productName"));
                v2.add(rs.getInt("quantity"));
                v2.add(rs.getDouble("price"));
                v2.add(rs.getString("description"));
                v2.add(rs.getString("category"));
                byte[] imageData = rs.getBytes("image");
                if (imageData != null) {
                    ImageIcon imageIcon = new ImageIcon(imageData);
                    v2.add(imageIcon);
                } else {
                    v2.add(null);
                }
                dtm.addRow(v2);

                
                int rowIndex = 0;
                jTable2.setRowSelectionInterval(rowIndex, rowIndex);
                jTable2.scrollRectToVisible(new Rectangle(jTable2.getCellRect(rowIndex, 0, true)));
            } else {
                JOptionPane.showMessageDialog(this, "PRODUCT DOES NOT EXIST!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_searchProdActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        int a= JOptionPane.showConfirmDialog(this, "Do you want to logout now?", "Logout",JOptionPane.YES_NO_OPTION);
        if (a==0) {
            new Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser ch = new JFileChooser("C:\\Users\\Windows 10\\Pictures\\BlueStacks"); //PARANG FILE STREAM LANG TO
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGE", "png", "jpg" , "jpeg");
        ch.addChoosableFileFilter(fnef);
        int result = ch.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedImageFile = ch.getSelectedFile();
            imagePath = selectedImageFile.getAbsolutePath();
            BufferedImage img;
            try {
                img = ImageIO.read(selectedImageFile);
                ImageIcon ii = new ImageIcon(img);
                Image image = ii.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
                jLabel1.setIcon(new ImageIcon(image));
            } catch (IOException ex) {
                Logger.getLogger(newProduct.class.getName()).log(Level.SEVERE, null, ex);
            } 
         } else if (result == JFileChooser.CANCEL_OPTION) {
             System.out.println("No file selected");
         }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.border.BevelBorder bevelBorder1;
    private com.k33ptoo.components.KButton custDelete;
    private javax.swing.JComboBox<String> custID;
    private com.k33ptoo.components.KButton custUpdate;
    private javax.swing.JPanel home;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KButton kButton3;
    private com.k33ptoo.components.KButton kButton4;
    private com.k33ptoo.components.KButton kButton7;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private javax.swing.JPanel menu1;
    private javax.swing.JPanel menu2;
    private javax.swing.JPanel menu3;
    private javax.swing.JPanel menu8;
    private javax.swing.JComboBox<String> prodID;
    private javax.swing.JPanel recenttrans;
    private com.k33ptoo.components.KButton removeProduct;
    private javax.swing.JPanel savings;
    private com.k33ptoo.components.KButton searchProd;
    private javax.swing.JPanel totalex;
    private javax.swing.JPanel totalin;
    private javax.swing.JTextArea txtCustaddress;
    private javax.swing.JTextField txtCustemail;
    private javax.swing.JTextField txtCustname;
    private javax.swing.JTextField txtCustphone;
    // End of variables declaration//GEN-END:variables
}
