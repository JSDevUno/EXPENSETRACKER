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
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Vector;
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
    public Dashboard() {
        initComponents();
        con = Db.myconnection();
        loadCustomer();
        loadProduct();
        fetch();
        fetchprod(); 
        setLocationRelativeTo(null);
        DefaultColor = new Color(0,0,51);
        ClickedColor = new Color(255,0,255);
        jTable3.getColumnModel().getColumn(6).setCellRenderer(new ImageIconCellRenderer());
    }

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
        logout = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
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
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
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
        kGradientPanel3 = new com.k33ptoo.components.KGradientPanel();
        jLabel30 = new javax.swing.JLabel();
        kGradientPanel4 = new com.k33ptoo.components.KGradientPanel();
        jLabel29 = new javax.swing.JLabel();
        kGradientPanel5 = new com.k33ptoo.components.KGradientPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        searchProd = new com.k33ptoo.components.KButton();
        kButton3 = new com.k33ptoo.components.KButton();
        kButton4 = new com.k33ptoo.components.KButton();
        removeProduct = new com.k33ptoo.components.KButton();
        prodID = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField6 = new javax.swing.JTextField();
        kButton8 = new com.k33ptoo.components.KButton();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        kButton9 = new com.k33ptoo.components.KButton();
        kButton12 = new com.k33ptoo.components.KButton();
        jTextField17 = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("dashboard");
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 0, 102));

        logout.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setText("LOGOUT");
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/icons8_logout_rounded_up_30px.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/icons8_manager_127px.png"))); // NOI18N

        menu1.setBackground(new java.awt.Color(0, 0, 51));
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
        jLabel1.setText("CUSTOMER");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/icons8_reception_28px.png"))); // NOI18N

        javax.swing.GroupLayout menu1Layout = new javax.swing.GroupLayout(menu1);
        menu1.setLayout(menu1Layout);
        menu1Layout.setHorizontalGroup(
            menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(48, 48, 48))
        );
        menu1Layout.setVerticalGroup(
            menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        menu2.setBackground(new java.awt.Color(0, 0, 51));
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
        jLabel2.setText("PRODUCT");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/icons8_product_28px.png"))); // NOI18N

        javax.swing.GroupLayout menu2Layout = new javax.swing.GroupLayout(menu2);
        menu2.setLayout(menu2Layout);
        menu2Layout.setHorizontalGroup(
            menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        menu3.setBackground(new java.awt.Color(0, 0, 51));
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
        jLabel3.setText("CART");

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

        menu8.setBackground(new java.awt.Color(0, 0, 51));
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

        home.setBackground(new java.awt.Color(255, 0, 255));
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
        jLabel13.setText("HOME");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(menu2, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(menu3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menu8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logout)
                .addGap(66, 66, 66))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addGap(35, 35, 35)
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menu8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 369, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(14, 14, 14))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 235, 829));

        jPanel4.setBackground(new java.awt.Color(51, 0, 102));

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
        jLabel23.setForeground(new java.awt.Color(255, 51, 255));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 645, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24)
                        .addComponent(jLabel23))
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 6, 1000, -1));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(0, 0, 51));

        jPanel13.setBackground(new java.awt.Color(204, 102, 0));

        jLabel25.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Total Income");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addContainerGap(130, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(204, 102, 0));

        jLabel26.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Recent Sale");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addContainerGap(130, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(204, 102, 0));

        jLabel27.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Top Selling");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addContainerGap(130, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(581, Short.MAX_VALUE))
        );

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

        kGradientPanel3.setkBorderRadius(20);
        kGradientPanel3.setOpaque(false);

        jLabel30.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("TOTAL ORDERS AMOUNT");

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addContainerGap(108, Short.MAX_VALUE))
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        kGradientPanel4.setkBorderRadius(20);
        kGradientPanel4.setOpaque(false);

        jLabel29.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("ORDERS COUNT");

        javax.swing.GroupLayout kGradientPanel4Layout = new javax.swing.GroupLayout(kGradientPanel4);
        kGradientPanel4.setLayout(kGradientPanel4Layout);
        kGradientPanel4Layout.setHorizontalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addContainerGap(165, Short.MAX_VALUE))
        );
        kGradientPanel4Layout.setVerticalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        kGradientPanel5.setkBorderRadius(20);
        kGradientPanel5.setOpaque(false);

        jLabel31.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("LAST ORDER DATE");

        javax.swing.GroupLayout kGradientPanel5Layout = new javax.swing.GroupLayout(kGradientPanel5);
        kGradientPanel5.setLayout(kGradientPanel5Layout);
        kGradientPanel5Layout.setHorizontalGroup(
            kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addContainerGap(149, Short.MAX_VALUE))
        );
        kGradientPanel5Layout.setVerticalGroup(
            kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 54, Short.MAX_VALUE)
                        .addComponent(kGradientPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(kGradientPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(kGradientPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(kGradientPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
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
                .addGap(62, 62, 62)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchProd, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prodID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab3", jPanel6);

        jPanel7.setBackground(new java.awt.Color(0, 0, 51));

        jTable4.setBackground(new java.awt.Color(255, 255, 255));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Phone", "Email", "Address"
            }
        ));
        jTable4.setPreferredSize(new java.awt.Dimension(245, 80));
        jScrollPane5.setViewportView(jTable4);

        jTable5.setBackground(new java.awt.Color(255, 255, 255));
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Quantity", "Price", "Picture", "Category"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTable5);
        if (jTable5.getColumnModel().getColumnCount() > 0) {
            jTable5.getColumnModel().getColumn(5).setHeaderValue("Select");
        }

        jTable6.setBackground(new java.awt.Color(255, 255, 255));
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Customer_ID", "Prod_Name", "Quantity", "Price", "Date", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane7.setViewportView(jTable6);

        jComboBox1.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextField6.setBackground(new java.awt.Color(255, 255, 255));
        jTextField6.setForeground(new java.awt.Color(0, 0, 0));

        kButton8.setForeground(new java.awt.Color(0, 0, 0));
        kButton8.setText("Search");
        kButton8.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N

        kGradientPanel1.setkBorderRadius(20);
        kGradientPanel1.setOpaque(false);

        jTextField7.setBackground(new java.awt.Color(255, 255, 255));
        jTextField7.setForeground(new java.awt.Color(0, 0, 0));

        jTextField8.setBackground(new java.awt.Color(255, 255, 255));
        jTextField8.setForeground(new java.awt.Color(0, 0, 0));

        jTextField9.setBackground(new java.awt.Color(255, 255, 255));
        jTextField9.setForeground(new java.awt.Color(0, 0, 0));

        jTextField10.setBackground(new java.awt.Color(255, 255, 255));
        jTextField10.setForeground(new java.awt.Color(0, 0, 0));

        jLabel32.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Customer ID:");

        jLabel33.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Product Name:");

        jLabel34.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Quantity:");

        jLabel35.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Price:");

        jTextField11.setBackground(new java.awt.Color(255, 255, 255));
        jTextField11.setForeground(new java.awt.Color(0, 0, 0));

        jLabel36.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Date:");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        kButton9.setForeground(new java.awt.Color(0, 0, 0));
        kButton9.setText("ADD/RESET");
        kButton9.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N

        kButton12.setForeground(new java.awt.Color(0, 0, 0));
        kButton12.setText("DELETE");
        kButton12.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N

        jTextField17.setBackground(new java.awt.Color(255, 255, 255));
        jTextField17.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(kButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(kButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(kButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(kButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(kButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab4", jPanel7);

        jPanel12.setBackground(new java.awt.Color(0, 0, 51));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 764, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab9", jPanel12);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 27, -1, 795));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        int a= JOptionPane.showConfirmDialog(this, "Do you want to logout now?", "Logout",JOptionPane.YES_NO_OPTION);
        if (a==0) {
            new Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_logoutMouseClicked

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
       jTabbedPane1.setSelectedIndex(8);
    }//GEN-LAST:event_menu8MouseClicked

    private void menu8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu8MousePressed
        menu1.setBackground(DefaultColor);
        menu2.setBackground(DefaultColor);
        menu3.setBackground(DefaultColor);
        menu8.setBackground(ClickedColor);
        home.setBackground(DefaultColor);
    }//GEN-LAST:event_menu8MousePressed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        this.setExtendedState(Login.ICONIFIED);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel6MouseClicked

    public void loadCustomer(){
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
    public void loadProduct(){
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
    public void fetch(){
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
    public void fetchprod(){
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
    private javax.swing.JComboBox<String> jComboBox1;
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
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KButton kButton12;
    private com.k33ptoo.components.KButton kButton3;
    private com.k33ptoo.components.KButton kButton4;
    private com.k33ptoo.components.KButton kButton7;
    private com.k33ptoo.components.KButton kButton8;
    private com.k33ptoo.components.KButton kButton9;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private com.k33ptoo.components.KGradientPanel kGradientPanel3;
    private com.k33ptoo.components.KGradientPanel kGradientPanel4;
    private com.k33ptoo.components.KGradientPanel kGradientPanel5;
    private javax.swing.JLabel logout;
    private javax.swing.JPanel menu1;
    private javax.swing.JPanel menu2;
    private javax.swing.JPanel menu3;
    private javax.swing.JPanel menu8;
    private javax.swing.JComboBox<String> prodID;
    private com.k33ptoo.components.KButton removeProduct;
    private com.k33ptoo.components.KButton searchProd;
    private javax.swing.JTextArea txtCustaddress;
    private javax.swing.JTextField txtCustemail;
    private javax.swing.JTextField txtCustname;
    private javax.swing.JTextField txtCustphone;
    // End of variables declaration//GEN-END:variables
}
