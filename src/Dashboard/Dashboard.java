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
import java.math.BigDecimal;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Color DefaultColor, ClickedColor;
    Integer userID;
    public Dashboard() {
        initComponents();
        userID = UserSession.getUserID();
        con = Db.myconnection();
        loadExpenses();
        fetchExpenses();
        loadIncome();
        fetchIncome();
        fetchBudget();
        loadBudget();
        displayUserProfile(); 
        setLocationRelativeTo(null);
        DefaultColor = new Color(51,51,51);
        ClickedColor = new Color(0,255,255);
        //jTable3.getColumnModel().getColumn(6).setCellRenderer(new ImageIconCellRenderer());
    }
    private String imagePath;
    class ImageIconCellRenderer implements TableCellRenderer{
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            incometable.setRowHeight(60);
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
        profile = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        totalex = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        labelexpense = new javax.swing.JLabel();
        savings = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        labelsavings = new javax.swing.JLabel();
        totalin = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        labelincome = new javax.swing.JLabel();
        recenttrans = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        labelspent = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        expensetable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtdescription = new javax.swing.JTextArea();
        amounttextfield1 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        categorycombobox = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        exDelete = new com.k33ptoo.components.KButton();
        kButton7 = new com.k33ptoo.components.KButton();
        exUpdate = new com.k33ptoo.components.KButton();
        exID = new javax.swing.JComboBox<>();
        kButton1 = new com.k33ptoo.components.KButton();
        jLabel33 = new javax.swing.JLabel();
        sortComboBox1 = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        incometable = new javax.swing.JTable();
        inadd = new com.k33ptoo.components.KButton();
        inupdate = new com.k33ptoo.components.KButton();
        indelete = new com.k33ptoo.components.KButton();
        txtsource = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txtamount2 = new javax.swing.JTextField();
        frequencycombobox = new javax.swing.JComboBox<>();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel45 = new javax.swing.JLabel();
        kButton2 = new com.k33ptoo.components.KButton();
        inID = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        sortComboBox2 = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        budgetTable = new javax.swing.JTable();
        kButton3 = new com.k33ptoo.components.KButton();
        budID = new javax.swing.JComboBox<>();
        budadd = new com.k33ptoo.components.KButton();
        budupdate = new com.k33ptoo.components.KButton();
        jLabel46 = new javax.swing.JLabel();
        categorycombobox2 = new javax.swing.JComboBox<>();
        jLabel47 = new javax.swing.JLabel();
        txtbudgetamount = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        sortComboBox3 = new javax.swing.JComboBox<>();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel49 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        txtspentamount = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        buddelete = new com.k33ptoo.components.KButton();
        jPanel12 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();

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

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/icons8_low_price_28px.png"))); // NOI18N

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

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/icons8_paycheque_28px.png"))); // NOI18N

        javax.swing.GroupLayout menu2Layout = new javax.swing.GroupLayout(menu2);
        menu2.setLayout(menu2Layout);
        menu2Layout.setHorizontalGroup(
            menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
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

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/icons8_budget_28px.png"))); // NOI18N

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
            .addComponent(profile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
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
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel32.setBackground(new java.awt.Color(0, 255, 255));
        jLabel32.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("PROFILE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(menu2, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(menu3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(menu8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(29, 29, 29)
                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jLabel4)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel32)
                .addGap(90, 90, 90))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

        labelexpense.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        labelexpense.setForeground(new java.awt.Color(255, 255, 255));
        labelexpense.setText("jLabel36");
        labelexpense.setToolTipText("");

        javax.swing.GroupLayout totalexLayout = new javax.swing.GroupLayout(totalex);
        totalex.setLayout(totalexLayout);
        totalexLayout.setHorizontalGroup(
            totalexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalexLayout.createSequentialGroup()
                .addGroup(totalexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(totalexLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel25))
                    .addGroup(totalexLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(labelexpense, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        totalexLayout.setVerticalGroup(
            totalexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalexLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(labelexpense)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel3.add(totalex, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 119, -1, -1));

        savings.setBackground(new java.awt.Color(0, 153, 153));
        savings.setForeground(new java.awt.Color(0, 153, 153));
        savings.setPreferredSize(new java.awt.Dimension(233, 112));

        jLabel26.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Savings");

        labelsavings.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        labelsavings.setForeground(new java.awt.Color(255, 255, 255));
        labelsavings.setText("jLabel36");
        labelsavings.setToolTipText("");

        javax.swing.GroupLayout savingsLayout = new javax.swing.GroupLayout(savings);
        savings.setLayout(savingsLayout);
        savingsLayout.setHorizontalGroup(
            savingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(savingsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, savingsLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(labelsavings, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        savingsLayout.setVerticalGroup(
            savingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(savingsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addComponent(labelsavings)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel3.add(savings, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 308, -1, -1));

        totalin.setBackground(new java.awt.Color(0, 153, 153));
        totalin.setPreferredSize(new java.awt.Dimension(233, 112));

        jLabel27.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Total  Income");

        labelincome.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        labelincome.setForeground(new java.awt.Color(255, 255, 255));
        labelincome.setText("jLabel36");
        labelincome.setToolTipText("");

        javax.swing.GroupLayout totalinLayout = new javax.swing.GroupLayout(totalin);
        totalin.setLayout(totalinLayout);
        totalinLayout.setHorizontalGroup(
            totalinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addContainerGap(92, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, totalinLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelincome, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        totalinLayout.setVerticalGroup(
            totalinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addGap(18, 18, 18)
                .addComponent(labelincome)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel3.add(totalin, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 119, -1, -1));

        recenttrans.setBackground(new java.awt.Color(0, 153, 153));
        recenttrans.setPreferredSize(new java.awt.Dimension(233, 112));

        jLabel28.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Recent Spent");

        labelspent.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        labelspent.setForeground(new java.awt.Color(255, 255, 255));
        labelspent.setText("jLabel36");
        labelspent.setToolTipText("");

        javax.swing.GroupLayout recenttransLayout = new javax.swing.GroupLayout(recenttrans);
        recenttrans.setLayout(recenttransLayout);
        recenttransLayout.setHorizontalGroup(
            recenttransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recenttransLayout.createSequentialGroup()
                .addGroup(recenttransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(recenttransLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel28))
                    .addGroup(recenttransLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(labelspent, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        recenttransLayout.setVerticalGroup(
            recenttransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recenttransLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addGap(18, 18, 18)
                .addComponent(labelspent)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel3.add(recenttrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 308, -1, -1));

        jLabel8.setBackground(new java.awt.Color(51, 0, 51));
        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 0, 51));
        jLabel8.setText("EXPENSE TRACKER");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, -1));

        jTabbedPane1.addTab("tab1", jPanel3);

        jPanel5.setBackground(new java.awt.Color(0, 255, 255));

        expensetable.setBackground(new java.awt.Color(255, 255, 255));
        expensetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Category", "Amount", "Description", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        expensetable.setFocusable(false);
        expensetable.setOpaque(false);
        expensetable.setVerifyInputWhenFocusTarget(false);
        jScrollPane2.setViewportView(expensetable);

        txtdescription.setBackground(new java.awt.Color(255, 255, 255));
        txtdescription.setColumns(20);
        txtdescription.setForeground(new java.awt.Color(0, 0, 0));
        txtdescription.setLineWrap(true);
        txtdescription.setRows(5);
        jScrollPane4.setViewportView(txtdescription);

        amounttextfield1.setBackground(new java.awt.Color(255, 255, 255));
        amounttextfield1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel41.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(51, 51, 51));
        jLabel41.setText("DECRIPTION:");

        jLabel40.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(51, 51, 51));
        jLabel40.setText("DATE:");

        jLabel39.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(51, 51, 51));
        jLabel39.setText("AMOUNT:");

        jLabel38.setBackground(new java.awt.Color(51, 51, 51));
        jLabel38.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(51, 51, 51));
        jLabel38.setText("CATEGORY:");

        categorycombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Groceries", "Utilities", "Transportation", "Housing", "Healthcare", "Entertainment", "Education", "Clothing", "Travel", "Personal Care" }));

        jDateChooser1.setDateFormatString("yyyy-MM-dd");

        exDelete.setText("DELETE");
        exDelete.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        exDelete.setPreferredSize(new java.awt.Dimension(185, 31));
        exDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exDeleteActionPerformed(evt);
            }
        });

        kButton7.setText("ADD");
        kButton7.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        kButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton7ActionPerformed(evt);
            }
        });

        exUpdate.setText("UPDATE");
        exUpdate.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        exUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exUpdateActionPerformed(evt);
            }
        });

        exID.setBackground(new java.awt.Color(255, 255, 255));
        exID.setForeground(new java.awt.Color(0, 0, 0));
        exID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        kButton1.setText("SEARCH ID");
        kButton1.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(51, 51, 51));
        jLabel33.setText("EXPENSES");

        sortComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "sort by amount asc", "sort by amount dsc", "sort by date asc", "sort by date dsc" }));
        sortComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(exDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(exUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(amounttextfield1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(categorycombobox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(84, 84, 84)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(sortComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(exID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sortComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(categorycombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(amounttextfield1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39)
                            .addComponent(exUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(exDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel40)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addGap(3504, 3504, 3504))
        );

        jTabbedPane1.addTab("tab2", jPanel5);

        jPanel6.setBackground(new java.awt.Color(0, 255, 255));

        incometable.setBackground(new java.awt.Color(255, 255, 255));
        incometable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Source", "Amount", "Frequency", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(incometable);

        inadd.setText("ADD");
        inadd.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        inadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inaddActionPerformed(evt);
            }
        });

        inupdate.setText("UPDATE");
        inupdate.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        inupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inupdateActionPerformed(evt);
            }
        });

        indelete.setText("DELETE");
        indelete.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        indelete.setPreferredSize(new java.awt.Dimension(185, 31));
        indelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indeleteActionPerformed(evt);
            }
        });

        txtsource.setBackground(new java.awt.Color(255, 255, 255));
        txtsource.setForeground(new java.awt.Color(0, 0, 0));

        jLabel43.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(51, 51, 51));
        jLabel43.setText("SOURCE:");

        jLabel44.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(51, 51, 51));
        jLabel44.setText("FREQUENCY:");

        jLabel42.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(51, 51, 51));
        jLabel42.setText("AMOUNT:");

        txtamount2.setBackground(new java.awt.Color(255, 255, 255));
        txtamount2.setForeground(new java.awt.Color(0, 0, 0));

        frequencycombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monthly", "Bi-Weekly", "Weekly", "Daily" }));

        jLabel45.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(51, 51, 51));
        jLabel45.setText("DATE:");

        kButton2.setText("SEARCH ID");
        kButton2.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });

        inID.setBackground(new java.awt.Color(255, 255, 255));
        inID.setForeground(new java.awt.Color(0, 0, 0));

        jLabel31.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 51, 51));
        jLabel31.setText("INCOME");

        sortComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "sort by amount asc", "sort by amount dsc", "sort by date asc", "sort by date dsc" }));
        sortComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortComboBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addComponent(indelete, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel44))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inadd, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(87, 87, 87)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel43)
                                    .addComponent(jLabel42))))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtsource)
                            .addComponent(txtamount2)
                            .addComponent(frequencycombobox, 0, 180, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45)))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel31)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(70, 70, 70)
                            .addComponent(sortComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sortComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inadd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(txtsource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel42)
                        .addComponent(txtamount2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(indelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44)
                    .addComponent(frequencycombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab3", jPanel6);

        jPanel7.setBackground(new java.awt.Color(0, 255, 255));

        budgetTable.setBackground(new java.awt.Color(255, 255, 255));
        budgetTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Categ.(no duplicate)", "Budget Amount", "Spent Amount", "Remaining Amount", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(budgetTable);

        kButton3.setText("SEARCH ID");
        kButton3.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        kButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton3ActionPerformed(evt);
            }
        });

        budID.setBackground(new java.awt.Color(255, 255, 255));
        budID.setForeground(new java.awt.Color(0, 0, 0));

        budadd.setText("ADD");
        budadd.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        budadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                budaddActionPerformed(evt);
            }
        });

        budupdate.setText("UPDATE");
        budupdate.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        budupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                budupdateActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(51, 51, 51));
        jLabel46.setText("CATEGORY:");

        categorycombobox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Groceries", "Utilities", "Transportation", "Housing", "Healthcare", "Entertainment", "Education", "Clothing", "Travel", "Personal Care" }));

        jLabel47.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(51, 51, 51));
        jLabel47.setText("BUDGET AMOUNT:");

        txtbudgetamount.setBackground(new java.awt.Color(255, 255, 255));
        txtbudgetamount.setForeground(new java.awt.Color(0, 0, 0));

        jLabel34.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(51, 51, 51));
        jLabel34.setText("BUDGET");

        sortComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "sort by budget amount asc", "sort by budget amount dsc", "sort by spent amount asc", "sort by spent amount dsc", "sort by date asc", "sort by date dsc" }));
        sortComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortComboBox3ActionPerformed(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(51, 51, 51));
        jLabel49.setText("DATE:");

        txtspentamount.setEditable(false);
        txtspentamount.setBackground(new java.awt.Color(255, 255, 255));
        txtspentamount.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtspentamount, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtspentamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel48.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(51, 51, 51));
        jLabel48.setText("SPENT AMOUNT:");

        buddelete.setText("DELETE");
        buddelete.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        buddelete.setPreferredSize(new java.awt.Dimension(185, 31));
        buddelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buddeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addGap(211, 211, 211)
                        .addComponent(budID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(sortComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(budadd, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(budupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(jLabel46))
                                    .addComponent(jLabel47)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(buddelete, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(110, 110, 110)
                                .addComponent(jLabel49)))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(categorycombobox2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtbudgetamount, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(137, 137, 137)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(jLabel48))
                                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(budID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(sortComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(budadd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(budupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel46)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel47))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(categorycombobox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(txtbudgetamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel48)
                        .addGap(4, 4, 4)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buddelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel49)))))
        );

        jTabbedPane1.addTab("tab4", jPanel7);

        jPanel12.setBackground(new java.awt.Color(0, 255, 255));

        jPanel9.setBackground(new java.awt.Color(0, 102, 102));

        jPanel22.setBackground(new java.awt.Color(51, 51, 51));
        jPanel22.setForeground(new java.awt.Color(0, 0, 0));
        jPanel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/icons8_natural_user_interface_2_25px_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addContainerGap())
        );

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("INCOME REPORT");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addGap(0, 30, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(23, 23, 23))
        );

        jPanel10.setBackground(new java.awt.Color(0, 102, 102));

        jPanel23.setBackground(new java.awt.Color(51, 51, 51));
        jPanel23.setForeground(new java.awt.Color(0, 0, 0));
        jPanel23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/icons8_natural_user_interface_2_25px_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addContainerGap())
        );

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("BUDGET REPORT");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(23, 23, 23))
        );

        jPanel11.setBackground(new java.awt.Color(0, 102, 102));

        jPanel24.setBackground(new java.awt.Color(51, 51, 51));
        jPanel24.setForeground(new java.awt.Color(0, 0, 0));
        jPanel24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/icons8_natural_user_interface_2_25px_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addContainerGap())
        );

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("SAVINGS REPORT");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addGap(0, 26, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(24, 24, 24))
        );

        jPanel13.setBackground(new java.awt.Color(0, 102, 102));

        jPanel15.setBackground(new java.awt.Color(51, 51, 51));
        jPanel15.setForeground(new java.awt.Color(0, 0, 0));
        jPanel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/icons8_natural_user_interface_2_25px_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addContainerGap())
        );

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("EXPENSE REPORT");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(0, 24, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(23, 23, 23))
        );

        jPanel14.setBackground(new java.awt.Color(0, 102, 102));

        jPanel25.setBackground(new java.awt.Color(51, 51, 51));
        jPanel25.setForeground(new java.awt.Color(0, 0, 0));
        jPanel25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/icons8_natural_user_interface_2_25px_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel30)
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel30)
                .addContainerGap())
        );

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("SUMMARY REPORT");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addGap(0, 18, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(23, 23, 23))
        );

        jLabel35.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(51, 51, 51));
        jLabel35.setText("REPORTS");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(132, 132, 132))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(313, 313, 313))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel35)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(89, 89, 89)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(88, 88, 88)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
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

    public void loadExpenses(){
        int userId = UserSession.getUserID();

        try {
            pst = con.prepareStatement("SELECT expenseid FROM expenses WHERE userid = ?");
            pst.setInt(1, userId); 

            ResultSet rs = pst.executeQuery();

            exID.removeAllItems();

            while (rs.next()) {
                exID.addItem(rs.getString("expenseid"));
            }

            rs.close();
            pst.close();
            fetchExpenses(); 
            updateTotalExpenseLabel();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public BigDecimal calculateTotalExpense() {
        int userId = UserSession.getUserID();
        BigDecimal totalExpense = BigDecimal.ZERO;

        try {
            String query = "SELECT SUM(amount) AS total FROM expenses WHERE userid = ?";
            pst = con.prepareStatement(query);
            pst.setInt(1, userId);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                totalExpense = rs.getBigDecimal("total");
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }

        return totalExpense != null ? totalExpense : BigDecimal.ZERO;
    }

    public void updateTotalExpenseLabel() {
        BigDecimal totalExpense = calculateTotalExpense();
        labelexpense.setText("PHP "+totalExpense.toString());
    }
    public BigDecimal fetchMostRecentSpent() {
        int userId = UserSession.getUserID();
        BigDecimal recentSpent = BigDecimal.ZERO;

        try {
            String query = "SELECT amount FROM expenses WHERE userid = ? ORDER BY date DESC LIMIT 1";
            pst = con.prepareStatement(query);
            pst.setInt(1, userId);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                recentSpent = rs.getBigDecimal("amount");
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }

        return recentSpent;
    }
    public void updateRecentSpentLabel() {
        BigDecimal recentSpent = fetchMostRecentSpent();
        labelspent.setText("PHP " + recentSpent.toString());
    }

    public void fetchExpenses(){
        int userId = UserSession.getUserID(); 
    
        try {           
            pst = con.prepareStatement("SELECT * FROM expenses WHERE userid = ?");
            pst.setInt(1, userId); 
            
            ResultSet rs = pst.executeQuery();

            DefaultTableModel expenseTableModel = (DefaultTableModel) expensetable.getModel();
            expenseTableModel.setRowCount(0); 

            while (rs.next()) {
                Object[] rowData = {
                    rs.getInt("expenseid"),
                    rs.getString("category"),
                    rs.getBigDecimal("amount"),
                    rs.getString("description"),
                    rs.getDate("date")
                };
                expenseTableModel.addRow(rowData); 
            }

            rs.close();
            pst.close();
            updateTotalExpenseLabel();
            updateTotalSavingsLabel();
            updateRecentSpentLabel();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ImageIcon fetchUserImage(int desiredWidth, int desiredHeight) {
        try {
            int userId = UserSession.getUserID();
            pst = con.prepareStatement("SELECT image FROM users WHERE userid = ?");
            pst.setInt(1, userId);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                byte[] imageData = rs.getBytes("image");
                if (imageData != null) {
                    ImageIcon imageIcon = new ImageIcon(imageData);
                    Image image = imageIcon.getImage();
                    Image resizedImage = image.getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
                    return new ImageIcon(resizedImage);
                }
            }
            return getDefaultImageIcon(desiredWidth, desiredHeight);
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            return getDefaultImageIcon(desiredWidth, desiredHeight);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private ImageIcon getDefaultImageIcon(int width, int height) {
        String desktopPath = System.getProperty("user.home") + "/Desktop/profile.png";
        ImageIcon defaultIcon = new ImageIcon(desktopPath);
        Image image = defaultIcon.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    public void displayUserProfile() {
        int desiredWidth = profile.getWidth(); 
        int desiredHeight = profile.getHeight();
        ImageIcon userImageIcon = fetchUserImage(desiredWidth, desiredHeight);
        profile.setIcon(userImageIcon);
    }
    public void fetchIncome(){
        int userId = UserSession.getUserID(); 

        try {           
            pst = con.prepareStatement("SELECT * FROM income WHERE userid = ?");
            pst.setInt(1, userId); 

            ResultSet rs = pst.executeQuery();

            DefaultTableModel incomeTableModel = (DefaultTableModel) incometable.getModel();
            incomeTableModel.setRowCount(0); 

            while (rs.next()) {
                Object[] rowData = {
                    rs.getInt("incomeid"),
                    rs.getString("source"),
                    rs.getBigDecimal("amount"),
                    rs.getString("frequency"),
                    rs.getDate("date")
                };
                incomeTableModel.addRow(rowData); 
            }

            rs.close();
            pst.close();
            updateTotalIncomeLabel();
            updateTotalSavingsLabel();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public BigDecimal calculateTotalIncome() {
        int userId = UserSession.getUserID();
        BigDecimal totalIncome = BigDecimal.ZERO;

        try {
            String query = "SELECT SUM(amount) AS total FROM income WHERE userid = ?";
            pst = con.prepareStatement(query);
            pst.setInt(1, userId);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                totalIncome = rs.getBigDecimal("total");
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }

        return totalIncome != null ? totalIncome : BigDecimal.ZERO;
    }

    public void updateTotalIncomeLabel() {
        BigDecimal totalIncome = calculateTotalIncome();
        labelincome.setText("PHP "+totalIncome.toString());
    }

    public void loadIncome(){
        int userId = UserSession.getUserID();

        try {
            pst = con.prepareStatement("SELECT incomeid FROM income WHERE userid = ?");
            pst.setInt(1, userId); 

            ResultSet rs = pst.executeQuery();

            inID.removeAllItems();

            while (rs.next()) {
                inID.addItem(rs.getString("incomeid"));
            }

            rs.close();
            pst.close();
            fetchIncome();
            updateTotalIncomeLabel();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public BigDecimal calculateTotalSavings() {
        BigDecimal totalIncome = calculateTotalIncome();
        BigDecimal totalExpenses = calculateTotalExpense();
        return totalIncome.subtract(totalExpenses);
    }
    public void updateTotalSavingsLabel() {
        BigDecimal totalSavings = calculateTotalSavings();
        labelsavings.setText("PHP " + totalSavings.toString());
    }

    public void fetchIncomesortasc() {
        int userId = UserSession.getUserID();
        try {
            pst = con.prepareStatement("SELECT * FROM income WHERE userid = ? ORDER BY amount ASC");
            pst.setInt(1, userId);

            ResultSet rs = pst.executeQuery();

            DefaultTableModel incomeTableModel = (DefaultTableModel) incometable.getModel();
            incomeTableModel.setRowCount(0);

            while (rs.next()) {
                Object[] rowData = {
                    rs.getInt("incomeid"),
                    rs.getString("source"),
                    rs.getBigDecimal("amount"),
                    rs.getString("frequency"),
                    rs.getDate("date")
                };
                incomeTableModel.addRow(rowData);
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void fetchIncomesortdsc() {
        int userId = UserSession.getUserID();
        try {
            pst = con.prepareStatement("SELECT * FROM income WHERE userid = ? ORDER BY amount DESC");
            pst.setInt(1, userId);

            ResultSet rs = pst.executeQuery();

            DefaultTableModel incomeTableModel = (DefaultTableModel) incometable.getModel();
            incomeTableModel.setRowCount(0);

            while (rs.next()) {
                Object[] rowData = {
                    rs.getInt("incomeid"),
                    rs.getString("source"),
                    rs.getBigDecimal("amount"),
                    rs.getString("frequency"),
                    rs.getDate("date")
                };
                incomeTableModel.addRow(rowData);
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void fetchIncomesortdateasc() {
        int userId = UserSession.getUserID();
        try {
            pst = con.prepareStatement("SELECT * FROM income WHERE userid = ? ORDER BY date ASC");
            pst.setInt(1, userId);

            ResultSet rs = pst.executeQuery();

            DefaultTableModel incomeTableModel = (DefaultTableModel) incometable.getModel();
            incomeTableModel.setRowCount(0);

            while (rs.next()) {
                Object[] rowData = {
                    rs.getInt("incomeid"),
                    rs.getString("source"),
                    rs.getBigDecimal("amount"),
                    rs.getString("frequency"),
                    rs.getDate("date")
                };
                incomeTableModel.addRow(rowData);
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void fetchIncomesortdatedsc() {
        int userId = UserSession.getUserID();
        try {
            pst = con.prepareStatement("SELECT * FROM income WHERE userid = ? ORDER BY date DESC");
            pst.setInt(1, userId);

            ResultSet rs = pst.executeQuery();

            DefaultTableModel incomeTableModel = (DefaultTableModel) incometable.getModel();
            incomeTableModel.setRowCount(0);

            while (rs.next()) {
                Object[] rowData = {
                    rs.getInt("incomeid"),
                    rs.getString("source"),
                    rs.getBigDecimal("amount"),
                    rs.getString("frequency"),
                    rs.getDate("date")
                };
                incomeTableModel.addRow(rowData);
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void fetchExpensesortasc(){
        int userId = UserSession.getUserID();
        try {
            pst = con.prepareStatement("SELECT * FROM expenses WHERE userid = ? ORDER BY amount ASC");
            pst.setInt(1, userId);

            ResultSet rs = pst.executeQuery();

            DefaultTableModel expenseTableModel = (DefaultTableModel) expensetable.getModel();
            expenseTableModel.setRowCount(0);

            while (rs.next()) {
                Object[] rowData = {
                    rs.getInt("expenseid"),
                    rs.getString("category"),
                    rs.getBigDecimal("amount"),
                    rs.getString("description"),
                    rs.getDate("date")
                };
                expenseTableModel.addRow(rowData);
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void fetchExpensesortdsc(){
        int userId = UserSession.getUserID();
        try {
            pst = con.prepareStatement("SELECT * FROM expenses WHERE userid = ? ORDER BY amount DESC");
            pst.setInt(1, userId);

            ResultSet rs = pst.executeQuery();

            DefaultTableModel expenseTableModel = (DefaultTableModel) expensetable.getModel();
            expenseTableModel.setRowCount(0);

            while (rs.next()) {
                Object[] rowData = {
                    rs.getInt("expenseid"),
                    rs.getString("category"),
                    rs.getBigDecimal("amount"),
                    rs.getString("description"),
                    rs.getDate("date")
                };
                expenseTableModel.addRow(rowData);
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void fetchExpensesortdateasc(){
        int userId = UserSession.getUserID();
        try {
            pst = con.prepareStatement("SELECT * FROM expenses WHERE userid = ? ORDER BY date ASC");
            pst.setInt(1, userId);

            ResultSet rs = pst.executeQuery();

            DefaultTableModel expenseTableModel = (DefaultTableModel) expensetable.getModel();
            expenseTableModel.setRowCount(0);

            while (rs.next()) {
                Object[] rowData = {
                    rs.getInt("expenseid"),
                    rs.getString("category"),
                    rs.getBigDecimal("amount"),
                    rs.getString("description"),
                    rs.getDate("date")
                };
                expenseTableModel.addRow(rowData);
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    public void fetchExpensesortdatedsc(){
        int userId = UserSession.getUserID();
        try {
            pst = con.prepareStatement("SELECT * FROM expenses WHERE userid = ? ORDER BY date DESC");
            pst.setInt(1, userId);

            ResultSet rs = pst.executeQuery();

            DefaultTableModel expenseTableModel = (DefaultTableModel) expensetable.getModel();
            expenseTableModel.setRowCount(0);

            while (rs.next()) {
                Object[] rowData = {
                    rs.getInt("expenseid"),
                    rs.getString("category"),
                    rs.getBigDecimal("amount"),
                    rs.getString("description"),
                    rs.getDate("date")
                };
                expenseTableModel.addRow(rowData);
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void fetchBudget() {
        int userId = UserSession.getUserID();
        try {
            pst = con.prepareStatement("SELECT * FROM budget WHERE userid = ?");
            pst.setInt(1, userId);

            ResultSet rs = pst.executeQuery();

            DefaultTableModel budgetTableModel = (DefaultTableModel) budgetTable.getModel();
            budgetTableModel.setRowCount(0);

            while (rs.next()) {
                BigDecimal budgetAmount = rs.getBigDecimal("budgetamount");
                BigDecimal spentAmount = rs.getBigDecimal("spentamount");
                BigDecimal remainingAmount = budgetAmount.subtract(spentAmount);

                Object[] rowData = {
                    rs.getInt("budgetid"),
                    rs.getString("category"),
                    budgetAmount,
                    spentAmount,
                    remainingAmount,
                    rs.getDate("date")
                };
                budgetTableModel.addRow(rowData);
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void loadBudget() {
        int userId = UserSession.getUserID();

        try {
            pst = con.prepareStatement("SELECT budgetid FROM budget WHERE userid = ?");
            pst.setInt(1, userId);

            ResultSet rs = pst.executeQuery();

            budID.removeAllItems();  

            while (rs.next()) {
                budID.addItem(rs.getString("budgetid"));
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void fetchBudgetSort(String column, String order) {
        int userId = UserSession.getUserID();
        try {
            String query = "SELECT * FROM budget WHERE userid = ? ORDER BY " + column + " " + order;
            pst = con.prepareStatement(query);
            pst.setInt(1, userId);

            ResultSet rs = pst.executeQuery();

            DefaultTableModel budgetTableModel = (DefaultTableModel) budgetTable.getModel();
            budgetTableModel.setRowCount(0);

            while (rs.next()) {
                Object[] rowData = {
                    rs.getInt("budgetid"),
                    rs.getString("category"),
                    rs.getBigDecimal("budgetamount"),
                    rs.getBigDecimal("spentamount"),
                    rs.getBigDecimal("remainingamount"),
                    rs.getDate("date")
                };
                budgetTableModel.addRow(rowData);
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //ADD EXPENSES
    private void kButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton7ActionPerformed
       String category = (String) categorycombobox.getSelectedItem();
        String amountText = amounttextfield1.getText();
        BigDecimal expenseAmount = new BigDecimal(amountText);
        java.util.Date utilDate = jDateChooser1.getDate();
        String description = txtdescription.getText();

        java.sql.Date sqlDate = null;
        if (utilDate != null) {
            sqlDate = new java.sql.Date(utilDate.getTime());
        }

        try {            
            pst = con.prepareStatement("SELECT budgetamount, spentamount FROM budget WHERE userid = ? AND category = ?");
            pst.setInt(1, userID);
            pst.setString(2, category);
            rs = pst.executeQuery();

            if (rs.next()) {
                BigDecimal budgetAmount = rs.getBigDecimal("budgetamount");
                BigDecimal spentAmount = rs.getBigDecimal("spentamount");
                BigDecimal newSpentAmount = spentAmount.add(expenseAmount);

                if (newSpentAmount.compareTo(budgetAmount) > 0) {
                    JOptionPane.showMessageDialog(this, "This expense exceeds the budget for the category: " + category);
                    return;
                }
            } 
            pst = con.prepareStatement("INSERT INTO expenses (userid, category, amount, description, date) VALUES (?, ?, ?, ?, ?)");
            pst.setInt(1, userID);
            pst.setString(2, category);
            pst.setBigDecimal(3, expenseAmount);
            pst.setString(4, description);
            pst.setDate(5, sqlDate);

            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(this, "EXPENSE ADDED!");

                // Update the budget table
                pst = con.prepareStatement("SELECT * FROM budget WHERE userid = ? AND category = ?");
                pst.setInt(1, userID);
                pst.setString(2, category);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {                    
                    BigDecimal spentAmount = rs.getBigDecimal("spentamount").add(expenseAmount);

                    pst = con.prepareStatement("UPDATE budget SET spentamount = ? WHERE userid = ? AND category = ?");
                    pst.setBigDecimal(1, spentAmount);
                    pst.setInt(2, userID);
                    pst.setString(3, category);
                    pst.executeUpdate();
                } else {                    
                    pst = con.prepareStatement("INSERT INTO budget (userid, category, budgetamount, spentamount, date) VALUES (?, ?, 0, ?, ?)");
                    pst.setInt(1, userID);
                    pst.setString(2, category);
                    pst.setBigDecimal(3, expenseAmount);
                    pst.setDate(4, sqlDate);
                    pst.executeUpdate();
                }

                fetchExpenses();
                loadExpenses();
                fetchBudget();
            } else {
                JOptionPane.showMessageDialog(this, "EXPENSE FAILED TO SAVE!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid amount.");
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_kButton7ActionPerformed
    //SEARCH COMBO BOX EXPENSES
    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        try {
            String cid = exID.getSelectedItem().toString(); 

            pst = con.prepareStatement("SELECT * FROM expenses WHERE expenseid=?");
            pst.setString(1, cid);
            rs = pst.executeQuery();

            if (rs.next()) {
                categorycombobox.setSelectedItem(rs.getString("category"));
                amounttextfield1.setText(rs.getBigDecimal("amount").toString());
                jDateChooser1.setDate(rs.getDate("date"));
                txtdescription.setText(rs.getString("description"));
            } else {
                JOptionPane.showMessageDialog(this, "Expense with ID " + cid + " not found!");
                categorycombobox.setSelectedIndex(0);
                amounttextfield1.setText("");
                jDateChooser1.setDate(null);
                txtdescription.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_kButton1ActionPerformed
    //UPDATE EXPENSES
    private void exUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exUpdateActionPerformed
        try {
            String category = (String) categorycombobox.getSelectedItem();
            String amountText = amounttextfield1.getText();
            java.util.Date utilDate = jDateChooser1.getDate();
            String description = txtdescription.getText();
            String expenseId = exID.getSelectedItem().toString(); 

            java.sql.Date sqlDate = null;
            if (utilDate != null) {
                sqlDate = new java.sql.Date(utilDate.getTime());
            }

            pst = con.prepareStatement("UPDATE expenses SET category=?, amount=?, description=?, date=? WHERE expenseid=?");

            
            pst.setString(1, category);
            pst.setBigDecimal(2, new BigDecimal(amountText));
            pst.setString(3, description);
            pst.setDate(4, sqlDate);
            pst.setString(5, expenseId);

            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(this, "EXPENSE UPDATED!");
                
                categorycombobox.setSelectedIndex(0);
                amounttextfield1.setText("");
                jDateChooser1.setDate(null);
                txtdescription.setText("");
                fetchExpenses();
                loadExpenses();
            } else {
                JOptionPane.showMessageDialog(this, "EXPENSE FAILED TO UPDATE!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid amount.");
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_exUpdateActionPerformed
    //DELETE EXPENSES
    private void exDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exDeleteActionPerformed
        try {
            String expenseId = exID.getSelectedItem().toString();

            pst = con.prepareStatement("DELETE FROM expenses WHERE expenseid=?");

            pst.setString(1, expenseId);

            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(this, "EXPENSE DELETED!");
                categorycombobox.setSelectedIndex(0);
                amounttextfield1.setText("");
                jDateChooser1.setDate(null);
                txtdescription.setText("");
                fetchExpenses();
                loadExpenses();
            } else {
                JOptionPane.showMessageDialog(this, "EXPENSE FAILED TO DELETE!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_exDeleteActionPerformed

   
    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        int a= JOptionPane.showConfirmDialog(this, "Do you want to logout now?", "Logout",JOptionPane.YES_NO_OPTION);
        if (a==0) {
            new Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser ch = new JFileChooser("C:\\Users\\Windows 10\\Pictures\\BlueStacks"); 
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
                Image image = ii.getImage().getScaledInstance(profile.getWidth(), profile.getHeight(), Image.SCALE_SMOOTH);
                profile.setIcon(new ImageIcon(image));
            } catch (IOException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            } 
         } else if (result == JFileChooser.CANCEL_OPTION) {
             System.out.println("No file selected");
         }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void inaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inaddActionPerformed

        String source = txtsource.getText();
        String amountText = txtamount2.getText();
        String frequency = (String) frequencycombobox.getSelectedItem();
        java.util.Date utilDate = jDateChooser2.getDate();
        
        java.sql.Date sqlDate = null;
        if (utilDate != null) {
            sqlDate = new java.sql.Date(utilDate.getTime());
        }

        try {
            pst = con.prepareStatement("INSERT INTO income (userid, source, amount, frequency, date) VALUES (?, ?, ?, ?, ?)");

            pst.setInt(1, userID); 
            pst.setString(2, source);
            pst.setBigDecimal(3, new BigDecimal(amountText));
            pst.setString(4, frequency);
            pst.setDate(5, sqlDate); 

            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(this, "INCOME ADDED!");
                txtsource.setText("");
                txtamount2.setText("");
                frequencycombobox.setSelectedIndex(0);
                jDateChooser2.setDate(null);
                fetchIncome(); 
                loadIncome();  
            } else {
                JOptionPane.showMessageDialog(this, "INCOME FAILED TO SAVE!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid amount.");
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_inaddActionPerformed

    private void inupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inupdateActionPerformed
        try {
            String source = txtsource.getText();
            String amountText = txtamount2.getText();
            java.util.Date utilDate = jDateChooser2.getDate();
            String frequency = (String) frequencycombobox.getSelectedItem();
            String incomeId = inID.getSelectedItem().toString(); 

            java.sql.Date sqlDate = null;
            if (utilDate != null) {
                sqlDate = new java.sql.Date(utilDate.getTime());
            }

            pst = con.prepareStatement("UPDATE income SET source=?, amount=?, frequency=?, date=? WHERE incomeid=?");

            pst.setString(1, source);
            pst.setBigDecimal(2, new BigDecimal(amountText));
            pst.setString(3, frequency);
            pst.setDate(4, sqlDate);
            pst.setString(5, incomeId);

            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(this, "INCOME UPDATED!");

                txtsource.setText("");
                txtamount2.setText("");
                jDateChooser2.setDate(null);
                frequencycombobox.setSelectedIndex(0);
                fetchIncome();
                loadIncome();
            } else {
                JOptionPane.showMessageDialog(this, "INCOME FAILED TO UPDATE!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid amount.");
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_inupdateActionPerformed

    private void indeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indeleteActionPerformed
        try {
            String incomeId = inID.getSelectedItem().toString();

            pst = con.prepareStatement("DELETE FROM income WHERE incomeid=?");
            pst.setString(1, incomeId);

            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(this, "INCOME DELETED!");
                txtsource.setText("");
                txtamount2.setText("");
                jDateChooser2.setDate(null);
                frequencycombobox.setSelectedIndex(0);
                fetchIncome(); 
                loadIncome();
            } else {
                JOptionPane.showMessageDialog(this, "INCOME FAILED TO DELETE!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_indeleteActionPerformed

    private void budaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_budaddActionPerformed
        String category = (String) categorycombobox2.getSelectedItem();
        String budgetAmountText = txtbudgetamount.getText();
        BigDecimal budgetAmount = new BigDecimal(budgetAmountText);
        java.util.Date utilDate = jDateChooser3.getDate();

        java.sql.Date sqlDate = null;
        if (utilDate != null) {
            sqlDate = new java.sql.Date(utilDate.getTime());
        }

        try {           
            pst = con.prepareStatement("SELECT COUNT(*) as expenseCount FROM expenses WHERE userid = ?");
            pst.setInt(1, userID);
            rs = pst.executeQuery();

            if (rs.next() && rs.getInt("expenseCount") == 0) {
                JOptionPane.showMessageDialog(this, "Please add an expense first!");
                return;
            }
            BigDecimal totalBudget = calculateTotalBudget();
            BigDecimal totalIncome = calculateTotalIncome();

            if (totalBudget.add(budgetAmount).compareTo(totalIncome) > 0) {
                JOptionPane.showMessageDialog(this, "The total budget exceeds the total income!");
                return;
            }
            
            pst = con.prepareStatement("SELECT * FROM budget WHERE userid = ? AND category = ?");
            pst.setInt(1, userID);
            pst.setString(2, category);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {               
                BigDecimal existingBudgetAmount = rs.getBigDecimal("budgetamount").add(budgetAmount);

                pst = con.prepareStatement("UPDATE budget SET budgetamount = ?, date = ? WHERE userid = ? AND category = ?");
                pst.setBigDecimal(1, existingBudgetAmount);
                pst.setDate(2, sqlDate);
                pst.setInt(3, userID);
                pst.setString(4, category);
                pst.executeUpdate();
            } else {               
                pst = con.prepareStatement("INSERT INTO budget (userid, category, budgetamount, date) VALUES (?, ?, ?, ?)");
                pst.setInt(1, userID);
                pst.setString(2, category);
                pst.setBigDecimal(3, budgetAmount);
                pst.setDate(4, sqlDate);
                pst.executeUpdate();
            }

            JOptionPane.showMessageDialog(this, "BUDGET ADDED!");
            categorycombobox2.setSelectedIndex(0);
            txtbudgetamount.setText("");
            jDateChooser3.setDate(null);
            fetchBudget();
            loadBudget();

        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid amount.");
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_budaddActionPerformed
    
    private void buddeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buddeleteActionPerformed
        try {
            String budgetId = budID.getSelectedItem().toString();

            pst = con.prepareStatement("DELETE FROM budget WHERE budgetid=?");
            pst.setString(1, budgetId);

            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(this, "BUDGET DELETED!");
                categorycombobox2.setSelectedIndex(0);
                txtbudgetamount.setText("");
                txtspentamount.setText("");
                jDateChooser3.setDate(null);
                fetchBudget(); 
                loadBudget(); 
            } else {
                JOptionPane.showMessageDialog(this, "BUDGET FAILED TO DELETE!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buddeleteActionPerformed
    private BigDecimal calculateTotalBudget() {
        BigDecimal totalBudget = BigDecimal.ZERO;
        try {
            pst = con.prepareStatement("SELECT SUM(budgetamount) as total FROM budget WHERE userid = ?");
            pst.setInt(1, userID);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                totalBudget = rs.getBigDecimal("total");
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalBudget;
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            File imageFile = new File(imagePath);
            byte[] imageData = Files.readAllBytes(imageFile.toPath());

            int userId = UserSession.getUserID(); 

            pst = con.prepareStatement("SELECT * FROM users WHERE userid = ?");
            pst.setInt(1, userId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                // If a record exists, update the existing record with the new image
                pst = con.prepareStatement("UPDATE users SET image = ? WHERE userid = ?");
                pst.setBytes(1, imageData);
                pst.setInt(2, userId);
                int k = pst.executeUpdate();

                if (k == 1) {
                    JOptionPane.showMessageDialog(this, "IMAGE UPDATED!");
                } else {
                    JOptionPane.showMessageDialog(this, "FAILED TO UPDATE IMAGE!");
                }
            } else {
                pst = con.prepareStatement("INSERT INTO users (userid, image) VALUES (?, ?)");
                pst.setInt(1, userId);
                pst.setBytes(2, imageData);
                int k = pst.executeUpdate();

                if (k == 1) {
                    JOptionPane.showMessageDialog(this, "IMAGE INSERTED!");
                } else {
                    JOptionPane.showMessageDialog(this, "FAILED TO INSERT IMAGE!");
                }
            }
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        try {
            String incomeId = inID.getSelectedItem().toString(); 

            pst = con.prepareStatement("SELECT * FROM income WHERE incomeid=?");
            pst.setString(1, incomeId);
            rs = pst.executeQuery();

            if (rs.next()) {
                txtsource.setText(rs.getString("source"));
                txtamount2.setText(rs.getBigDecimal("amount").toString());
                frequencycombobox.setSelectedItem(rs.getString("frequency"));
                jDateChooser2.setDate(rs.getDate("date"));
            } else {
                JOptionPane.showMessageDialog(this, "Income with ID " + incomeId + " not found!");
                txtsource.setText("");
                txtamount2.setText("");
                jDateChooser2.setDate(null);
                frequencycombobox.setSelectedIndex(0);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_kButton2ActionPerformed

    private void sortComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortComboBox2ActionPerformed
        String selectedSortOption = (String) sortComboBox2.getSelectedItem();
        if (selectedSortOption.equals("sort by amount asc")) {
            fetchIncomesortasc();
        } else if (selectedSortOption.equals("sort by amount dsc")) {
            fetchIncomesortdsc();
        } else if (selectedSortOption.equals("sort by date asc")){
            fetchIncomesortdateasc();
        }else if (selectedSortOption.equals("sort by date dsc")){
            fetchIncomesortdatedsc();
        }
    }//GEN-LAST:event_sortComboBox2ActionPerformed

    private void sortComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortComboBox1ActionPerformed
        String selectedSortOption = (String) sortComboBox1.getSelectedItem();
        if (selectedSortOption.equals("sort by amount asc")) {
            fetchExpensesortasc();
        } else if (selectedSortOption.equals("sort by amount dsc")) {
            fetchExpensesortdsc();
        } else if (selectedSortOption.equals("sort by date asc")){
            fetchExpensesortdateasc();
        }else if (selectedSortOption.equals("sort by date dsc")){
            fetchExpensesortdatedsc();
        }
    }//GEN-LAST:event_sortComboBox1ActionPerformed

    private void sortComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortComboBox3ActionPerformed
        String selectedSortOption = (String) sortComboBox3.getSelectedItem();
        switch (selectedSortOption) {
            case "sort by budget amount asc":
                fetchBudgetSort("budgetamount", "ASC");
                break;
            case "sort by budget amount dsc":
                fetchBudgetSort("budgetamount", "DESC");
                break;
            case "sort by spent amount asc":
                fetchBudgetSort("spentamount", "ASC");
                break;
            case "sort by spent amount dsc":
                fetchBudgetSort("spentamount", "DESC");
                break;
            case "sort by date asc":
                fetchBudgetSort("date", "ASC");
                break;
            case "sort by date dsc":
                fetchBudgetSort("date", "DESC");
                break;
        }
    }//GEN-LAST:event_sortComboBox3ActionPerformed

    private void budupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_budupdateActionPerformed
        String category = (String) categorycombobox2.getSelectedItem();
        String budgetAmountText = txtbudgetamount.getText();
        String spentAmountText = txtspentamount.getText();
        java.util.Date utilDate = jDateChooser3.getDate();
        String budgetId = budID.getSelectedItem().toString(); 

        java.sql.Date sqlDate = null;
        if (utilDate != null) {
            sqlDate = new java.sql.Date(utilDate.getTime());
        }

        try {
            pst = con.prepareStatement("UPDATE budget SET category=?, budgetamount=?, spentamount=?, date=? WHERE budgetid=?");

            pst.setString(1, category);
            pst.setBigDecimal(2, new BigDecimal(budgetAmountText));
            pst.setBigDecimal(3, new BigDecimal(spentAmountText));
            pst.setDate(4, sqlDate);
            pst.setString(5, budgetId);

            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(this, "BUDGET UPDATED!");
                categorycombobox2.setSelectedIndex(0);
                txtbudgetamount.setText("");
                txtspentamount.setText("");
                jDateChooser3.setDate(null);
                fetchBudget();  
                loadBudget();
            } else {
                JOptionPane.showMessageDialog(this, "BUDGET FAILED TO UPDATE!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid amounts.");
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_budupdateActionPerformed

    private void kButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton3ActionPerformed
        try {
            String budgetId = budID.getSelectedItem().toString();

            pst = con.prepareStatement("SELECT * FROM budget WHERE budgetid=?");
            pst.setString(1, budgetId);
            rs = pst.executeQuery();

            if (rs.next()) {
                categorycombobox2.setSelectedItem(rs.getString("category"));
                txtbudgetamount.setText(rs.getBigDecimal("budgetamount").toString());
                txtspentamount.setText(rs.getBigDecimal("spentamount").toString());
                jDateChooser3.setDate(rs.getDate("date"));
            } else {
                JOptionPane.showMessageDialog(this, "Budget with ID " + budgetId + " not found!");
                categorycombobox2.setSelectedIndex(0);
                txtbudgetamount.setText("");
                txtspentamount.setText("");
                jDateChooser3.setDate(null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_kButton3ActionPerformed
    
    
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
    private javax.swing.JTextField amounttextfield1;
    private javax.swing.border.BevelBorder bevelBorder1;
    private javax.swing.JComboBox<String> budID;
    private com.k33ptoo.components.KButton budadd;
    private com.k33ptoo.components.KButton buddelete;
    private javax.swing.JTable budgetTable;
    private com.k33ptoo.components.KButton budupdate;
    private javax.swing.JComboBox<String> categorycombobox;
    private javax.swing.JComboBox<String> categorycombobox2;
    private com.k33ptoo.components.KButton exDelete;
    private javax.swing.JComboBox<String> exID;
    private com.k33ptoo.components.KButton exUpdate;
    private javax.swing.JTable expensetable;
    private javax.swing.JComboBox<String> frequencycombobox;
    private javax.swing.JPanel home;
    private javax.swing.JComboBox<String> inID;
    private com.k33ptoo.components.KButton inadd;
    private javax.swing.JTable incometable;
    private com.k33ptoo.components.KButton indelete;
    private com.k33ptoo.components.KButton inupdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KButton kButton2;
    private com.k33ptoo.components.KButton kButton3;
    private com.k33ptoo.components.KButton kButton7;
    private javax.swing.JLabel labelexpense;
    private javax.swing.JLabel labelincome;
    private javax.swing.JLabel labelsavings;
    private javax.swing.JLabel labelspent;
    private javax.swing.JPanel menu1;
    private javax.swing.JPanel menu2;
    private javax.swing.JPanel menu3;
    private javax.swing.JPanel menu8;
    private javax.swing.JLabel profile;
    private javax.swing.JPanel recenttrans;
    private javax.swing.JPanel savings;
    private javax.swing.JComboBox<String> sortComboBox1;
    private javax.swing.JComboBox<String> sortComboBox2;
    private javax.swing.JComboBox<String> sortComboBox3;
    private javax.swing.JPanel totalex;
    private javax.swing.JPanel totalin;
    private javax.swing.JTextField txtamount2;
    private javax.swing.JTextField txtbudgetamount;
    private javax.swing.JTextArea txtdescription;
    private javax.swing.JTextField txtsource;
    private javax.swing.JTextField txtspentamount;
    // End of variables declaration//GEN-END:variables
}
