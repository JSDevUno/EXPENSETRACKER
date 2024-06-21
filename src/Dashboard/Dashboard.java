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
import java.awt.BorderLayout;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Vector;
import org.jfree.data.general.DefaultPieDataset;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.ui.RectangleInsets;
import java.awt.geom.RoundRectangle2D;
import javax.swing.table.DefaultTableCellRenderer;
public class Dashboard extends javax.swing.JFrame {
    private DefaultPieDataset pieDataset;
    private JFreeChart pieChart;
    private PiePlot piePlot;
    private ChartPanel chartPanel;
    private int initialClickX, initialClickY;
    
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Color DefaultColor, ClickedColor;
    Integer userID;
    public Dashboard() {
        initComponents();
        userID = UserSession.getUserID();
        con = Db.myconnection();
        displayFirstName();
        loadExpenses();
        fetchExpenses();
        loadIncome();
        fetchIncome();
        fetchBudget();
        loadBudget();
        displayUserProfile(); 
        showPieChart();
        setLocationRelativeTo(null);
        DefaultColor = new Color(51,51,51);
        ClickedColor = new Color(0,255,255);
        setShape(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),40,30));
        expensetable.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {{
            setBackground(new Color(32, 136, 203));
            setForeground(Color.WHITE);
        }});
        incometable.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {{
            setBackground(new Color(32, 136, 203));
            setForeground(Color.WHITE);
        }});
        budgetTable.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {{
            setBackground(new Color(32, 136, 203));
            setForeground(Color.WHITE);
        }});
    }
    public void showPieChart(){
        pieDataset = new DefaultPieDataset();

        pieDataset.setValue("Total Expense", getTotalExpense());
        pieDataset.setValue("Total Income", getTotalIncome());
        pieDataset.setValue("Total Budget", getTotalBudget());
        pieDataset.setValue("Total Savings", getTotalSavings());

        pieChart = ChartFactory.createPieChart("CHART TOTALS", pieDataset, true, true, false);

        pieChart.setBackgroundPaint(new Color(0, 255, 255));
        pieChart.setBorderVisible(false);
        pieChart.setPadding(new RectangleInsets(0, 0, 0, 0));

        pieChart.getPlot().setBackgroundPaint(Color.WHITE);

        chartPanel = new ChartPanel(pieChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(360, 280));

        pieChartPanel.removeAll();
        pieChartPanel.add(chartPanel, BorderLayout.CENTER);
        pieChartPanel.revalidate();
    
        pieChartPanel.setVisible(true);
    }
    private BigDecimal getTotalExpense() {
        BigDecimal totalExpense = BigDecimal.ZERO;
        try {
            pst = con.prepareStatement("SELECT SUM(amount) as total FROM expenses WHERE userid = ?");
            pst.setInt(1, userID);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                totalExpense = rs.getBigDecimal("total");
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalExpense;
    }
    private BigDecimal getTotalExpensesExcludingCurrent(String expenseId) {
        BigDecimal totalExpenses = BigDecimal.ZERO;
        try {
            pst = con.prepareStatement("SELECT COUNT(*) as count FROM expenses WHERE userid = ?");
            pst.setInt(1, userID);
            ResultSet rsCount = pst.executeQuery();
            if (rsCount.next() && rsCount.getInt("count") > 1) {
                pst = con.prepareStatement("SELECT SUM(amount) as total FROM expenses WHERE userid = ? AND expenseid != ?");
                pst.setInt(1, userID);
                pst.setString(2, expenseId);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    totalExpenses = rs.getBigDecimal("total");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, "Error fetching total expenses excluding current", ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, "Error closing resources", ex);
            }
        }
        return totalExpenses;
    }

    private BigDecimal getTotalIncome() {
        BigDecimal totalIncome = BigDecimal.ZERO;
        try {
            pst = con.prepareStatement("SELECT SUM(amount) as total FROM income WHERE userid = ?");
            pst.setInt(1, userID);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                totalIncome = rs.getBigDecimal("total");
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalIncome;
    }

    private BigDecimal getTotalBudget() {
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
    private BigDecimal getTotalBudgetExcludingCurrent(String budgetId) {
        BigDecimal totalBudget = BigDecimal.ZERO;
        try {
            pst = con.prepareStatement("SELECT SUM(budgetamount) as total FROM budget WHERE userid = ? AND budgetid != ?");
            pst.setInt(1, userID);
            pst.setString(2, budgetId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                totalBudget = rs.getBigDecimal("total");
                if (totalBudget == null) {
                    totalBudget = BigDecimal.ZERO; 
                }
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalBudget;
    }
    private BigDecimal getTotalSavings() {
        BigDecimal totalIncome = getTotalIncome();
        BigDecimal totalExpense = getTotalExpense();

        if (totalIncome != null && totalExpense != null) {
            if (totalIncome.compareTo(totalExpense) >= 0) {
                return totalIncome.subtract(totalExpense);
            } else {
                return BigDecimal.ZERO;
            }
        } else {
            return BigDecimal.ZERO;
        }
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
        jToolBar1 = new javax.swing.JToolBar();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
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
        menu5 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        dragpanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fnamelabel = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        totalex = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        labelexpense = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        savings = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        labelsavings = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        totalin = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        labelincome = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        recenttrans = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        labelspent = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
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
        inreport = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        budreport = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        exreport = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        sumreport = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        pieChartPanel = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        EMAIL_MATCH = new javax.swing.JTextField();
        CURRENT_PASS = new javax.swing.JTextField();
        NEW_PASS = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        CHANGEPASS = new com.k33ptoo.components.KButton();
        jLabel30 = new javax.swing.JLabel();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel36 = new javax.swing.JLabel();
        kButton4 = new com.k33ptoo.components.KButton();
        jLabel11 = new javax.swing.JLabel();

        jToolBar1.setRollover(true);

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

        menu5.setBackground(new java.awt.Color(51, 51, 51));
        menu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu5MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menu5MousePressed(evt);
            }
        });

        jLabel19.setBackground(new java.awt.Color(153, 255, 255));
        jLabel19.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("MANAGE");

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/icons8_account_28px.png"))); // NOI18N

        javax.swing.GroupLayout menu5Layout = new javax.swing.GroupLayout(menu5);
        menu5.setLayout(menu5Layout);
        menu5Layout.setHorizontalGroup(
            menu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menu5Layout.setVerticalGroup(
            menu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu5Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(menu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel19))
                .addContainerGap(7, Short.MAX_VALUE))
        );

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menu5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menu5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(19, 19, 19))
        );

        dragpanel.setBackground(new java.awt.Color(0, 153, 153));
        dragpanel.setPreferredSize(new java.awt.Dimension(830, 52));
        dragpanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                dragpanelMouseDragged(evt);
            }
        });
        dragpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dragpanelMousePressed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/icons8_multiply_30px.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/icons8_subtract_30px.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        fnamelabel.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        fnamelabel.setForeground(new java.awt.Color(0, 255, 255));
        fnamelabel.setText("Jeevs");

        jLabel24.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Welcome,");

        javax.swing.GroupLayout dragpanelLayout = new javax.swing.GroupLayout(dragpanel);
        dragpanel.setLayout(dragpanelLayout);
        dragpanelLayout.setHorizontalGroup(
            dragpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dragpanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fnamelabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 489, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(12, 12, 12))
        );
        dragpanelLayout.setVerticalGroup(
            dragpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dragpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dragpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(dragpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24)
                        .addComponent(fnamelabel))
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

        jPanel4.setBackground(new java.awt.Color(51, 0, 51));
        jPanel4.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

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
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        totalexLayout.setVerticalGroup(
            totalexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalexLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(labelexpense)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jPanel17.setBackground(new java.awt.Color(51, 0, 51));
        jPanel17.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

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
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        savingsLayout.setVerticalGroup(
            savingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(savingsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addComponent(labelsavings)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jPanel11.setBackground(new java.awt.Color(51, 0, 51));
        jPanel11.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

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
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        totalinLayout.setVerticalGroup(
            totalinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addGap(18, 18, 18)
                .addComponent(labelincome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jPanel18.setBackground(new java.awt.Color(51, 0, 51));
        jPanel18.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

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
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        recenttransLayout.setVerticalGroup(
            recenttransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recenttransLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addGap(18, 18, 18)
                .addComponent(labelspent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.add(recenttrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 308, -1, -1));

        jLabel8.setBackground(new java.awt.Color(51, 0, 51));
        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 3, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("EXPENSE TRACKER");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 12, -1, 40));

        jPanel19.setBackground(new java.awt.Color(51, 0, 51));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 320, 10));

        jTabbedPane1.addTab("tab1", jPanel3);

        jPanel5.setBackground(new java.awt.Color(0, 255, 255));

        expensetable.setBackground(new java.awt.Color(255, 255, 255));
        expensetable.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        expensetable.setFont(new java.awt.Font("Tw Cen MT", 3, 12)); // NOI18N
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
        txtdescription.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txtdescription.setForeground(new java.awt.Color(0, 0, 0));
        txtdescription.setLineWrap(true);
        txtdescription.setRows(5);
        jScrollPane4.setViewportView(txtdescription);

        amounttextfield1.setBackground(new java.awt.Color(255, 255, 255));
        amounttextfield1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
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

        categorycombobox.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        categorycombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Groceries", "Utilities", "Transportation", "Housing", "Healthcare", "Entertainment", "Education", "Clothing", "Travel", "Personal Care" }));

        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        jDateChooser1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N

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
        exID.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
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

        sortComboBox1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
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
                        .addComponent(jLabel33)
                        .addGap(192, 192, 192)
                        .addComponent(exID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(sortComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(kButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(jLabel38)
                        .addGap(36, 36, 36)
                        .addComponent(categorycombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(jLabel41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(exUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(exDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(87, 87, 87)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel39)
                            .addComponent(jLabel40))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(amounttextfield1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(84, 84, 84)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(exID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(sortComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel38))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(categorycombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel41)))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(exUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(exDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel39)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel40))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(amounttextfield1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.addTab("tab2", jPanel5);

        jPanel6.setBackground(new java.awt.Color(0, 255, 255));

        incometable.setBackground(new java.awt.Color(255, 255, 255));
        incometable.setFont(new java.awt.Font("Tw Cen MT", 3, 12)); // NOI18N
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
        txtsource.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
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
        txtamount2.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txtamount2.setForeground(new java.awt.Color(0, 0, 0));

        frequencycombobox.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        frequencycombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monthly", "Bi-Weekly", "Weekly", "Daily" }));

        jDateChooser2.setDateFormatString("yyyy-MM-dd");
        jDateChooser2.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N

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
        inID.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        inID.setForeground(new java.awt.Color(0, 0, 0));
        inID.setPreferredSize(new java.awt.Dimension(78, 24));

        jLabel31.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 51, 51));
        jLabel31.setText("INCOME");

        sortComboBox2.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
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
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        budgetTable.setBackground(new java.awt.Color(255, 255, 255));
        budgetTable.setFont(new java.awt.Font("Tw Cen MT", 3, 12)); // NOI18N
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

        jPanel7.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 60, 754, 326));

        kButton3.setText("SEARCH ID");
        kButton3.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        kButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton3ActionPerformed(evt);
            }
        });
        jPanel7.add(kButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 16, 70, 26));

        budID.setBackground(new java.awt.Color(255, 255, 255));
        budID.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        budID.setForeground(new java.awt.Color(0, 0, 0));
        budID.setPreferredSize(new java.awt.Dimension(78, 24));
        jPanel7.add(budID, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 17, 150, -1));

        budadd.setText("ADD");
        budadd.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        budadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                budaddActionPerformed(evt);
            }
        });
        jPanel7.add(budadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 410, 72, 32));

        budupdate.setText("UPDATE");
        budupdate.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        budupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                budupdateActionPerformed(evt);
            }
        });
        jPanel7.add(budupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 448, 72, 32));

        jLabel46.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(51, 51, 51));
        jLabel46.setText("CATEGORY:");
        jPanel7.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 418, -1, -1));

        categorycombobox2.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        categorycombobox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Groceries", "Utilities", "Transportation", "Housing", "Healthcare", "Entertainment", "Education", "Clothing", "Travel", "Personal Care" }));
        jPanel7.add(categorycombobox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 414, 180, -1));

        jLabel47.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(51, 51, 51));
        jLabel47.setText("BUDGET AMOUNT:");
        jPanel7.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 456, -1, -1));

        txtbudgetamount.setBackground(new java.awt.Color(255, 255, 255));
        txtbudgetamount.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txtbudgetamount.setForeground(new java.awt.Color(0, 0, 0));
        jPanel7.add(txtbudgetamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 451, 180, -1));

        jLabel34.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(51, 51, 51));
        jLabel34.setText("BUDGET");
        jPanel7.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 21, -1, 21));

        sortComboBox3.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        sortComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "sort by budget amount asc", "sort by budget amount dsc", "sort by spent amount asc", "sort by spent amount dsc", "sort by date asc", "sort by date dsc" }));
        sortComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortComboBox3ActionPerformed(evt);
            }
        });
        jPanel7.add(sortComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(608, 18, -1, -1));

        jDateChooser3.setDateFormatString("yyyy-MM-dd");
        jDateChooser3.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jPanel7.add(jDateChooser3, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 488, 180, -1));

        jLabel49.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(51, 51, 51));
        jLabel49.setText("DATE:");
        jPanel7.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 494, -1, -1));

        txtspentamount.setEditable(false);
        txtspentamount.setBackground(new java.awt.Color(255, 255, 255));
        txtspentamount.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
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

        jPanel7.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(612, 442, -1, -1));

        jLabel48.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(51, 51, 51));
        jLabel48.setText("SPENT AMOUNT:");
        jPanel7.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 420, -1, -1));

        buddelete.setText("DELETE");
        buddelete.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        buddelete.setPreferredSize(new java.awt.Dimension(185, 31));
        buddelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buddeleteActionPerformed(evt);
            }
        });
        jPanel7.add(buddelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 486, 72, 32));

        jTabbedPane1.addTab("tab4", jPanel7);

        jPanel12.setBackground(new java.awt.Color(0, 255, 255));

        jPanel9.setBackground(new java.awt.Color(0, 102, 102));

        jPanel22.setBackground(new java.awt.Color(51, 51, 51));
        jPanel22.setForeground(new java.awt.Color(0, 0, 0));
        jPanel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        inreport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/icons8_natural_user_interface_2_25px_1.png"))); // NOI18N
        inreport.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        inreport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inreportMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(inreport, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(inreport, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        budreport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/icons8_natural_user_interface_2_25px_1.png"))); // NOI18N
        budreport.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        budreport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                budreportMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(budreport, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(budreport, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(0, 28, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(23, 23, 23))
        );

        jPanel13.setBackground(new java.awt.Color(0, 102, 102));

        jPanel15.setBackground(new java.awt.Color(51, 51, 51));
        jPanel15.setForeground(new java.awt.Color(0, 0, 0));
        jPanel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        exreport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/icons8_natural_user_interface_2_25px_1.png"))); // NOI18N
        exreport.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        exreport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exreportMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(exreport, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exreport, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        sumreport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/icons8_natural_user_interface_2_25px_1.png"))); // NOI18N
        sumreport.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        sumreport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sumreportMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(sumreport, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sumreport, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        pieChartPanel.setBackground(new java.awt.Color(255, 255, 102));
        pieChartPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(pieChartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pieChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(75, 75, 75))
        );

        jTabbedPane1.addTab("tab9", jPanel12);

        jPanel20.setBackground(new java.awt.Color(0, 255, 255));

        kGradientPanel2.setkBorderRadius(20);
        kGradientPanel2.setOpaque(false);

        EMAIL_MATCH.setBackground(new java.awt.Color(255, 255, 255));
        EMAIL_MATCH.setForeground(new java.awt.Color(0, 0, 0));

        CURRENT_PASS.setBackground(new java.awt.Color(255, 255, 255));
        CURRENT_PASS.setForeground(new java.awt.Color(0, 0, 0));

        NEW_PASS.setBackground(new java.awt.Color(255, 255, 255));
        NEW_PASS.setForeground(new java.awt.Color(0, 0, 0));

        jLabel20.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("EMAIL");

        jLabel21.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("CURRENT PASSWORD");

        jLabel29.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("NEW PASSWORD");

        CHANGEPASS.setText("CHANGE");
        CHANGEPASS.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        CHANGEPASS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CHANGEPASSActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("CHANGE PASSWORD");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CURRENT_PASS, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NEW_PASS, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EMAIL_MATCH, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel21))
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(CHANGEPASS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel29))
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(jLabel20))
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel30)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EMAIL_MATCH, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CURRENT_PASS, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NEW_PASS, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(CHANGEPASS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        kGradientPanel1.setkBorderRadius(20);
        kGradientPanel1.setOpaque(false);
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("DELETE ACCOUNT");
        kGradientPanel1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, 30));

        kButton4.setText("DELETE ACCOUNT");
        kButton4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        kButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton4ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(kButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 150, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/icons8_delete_document_40px.png"))); // NOI18N
        kGradientPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab9", jPanel20);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dragpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(dragpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void displayFirstName() {
        try {
            pst = con.prepareStatement("SELECT firstname FROM users WHERE userid = ?");
            pst.setInt(1, userID);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String firstName = rs.getString("firstname");
                fnamelabel.setText(firstName);
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void menu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu1MouseClicked
       jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_menu1MouseClicked

    private void menu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu1MousePressed
        menu1.setBackground(ClickedColor);
        menu2.setBackground(DefaultColor);
        menu3.setBackground(DefaultColor);
        menu8.setBackground(DefaultColor);
        menu5.setBackground(DefaultColor);
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
        menu5.setBackground(DefaultColor);
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
        menu5.setBackground(DefaultColor);
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
        menu5.setBackground(DefaultColor);
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
        menu5.setBackground(DefaultColor);
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
    BigDecimal getExpenseAmount(int expenseId) {
        BigDecimal amount = BigDecimal.ZERO;
        try {
            pst = con.prepareStatement("SELECT amount FROM expenses WHERE expenseid = ?");
            pst.setInt(1, expenseId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                amount = rs.getBigDecimal("amount");
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        return amount;
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
            fetchBudget();
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
                String category = rs.getString("category");
                BigDecimal budgetAmount = rs.getBigDecimal("budgetamount");
                BigDecimal totalExpenses = calculateTotalExpensesForCategory(category);
                BigDecimal remainingAmount = budgetAmount.subtract(totalExpenses);

                Object[] rowData = {
                    rs.getInt("budgetid"),
                    category,
                    budgetAmount,
                    totalExpenses,               
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
    public BigDecimal calculateTotalExpensesForCategory(String category) {
        BigDecimal totalExpenses = BigDecimal.ZERO;
        try {
            pst = con.prepareStatement("SELECT SUM(amount) AS total FROM expenses WHERE userid = ? AND category = ?");
            pst.setInt(1, userID);
            pst.setString(2, category);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                totalExpenses = rs.getBigDecimal("total");
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalExpenses != null ? totalExpenses : BigDecimal.ZERO;
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
    private BigDecimal calculateTotalSpentAmount(String category, int userID) {
        BigDecimal totalSpent = BigDecimal.ZERO;
        try {
            pst = con.prepareStatement("SELECT SUM(amount) as total FROM expenses WHERE userid = ? AND category = ?");
            pst.setInt(1, userID);
            pst.setString(2, category);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                totalSpent = rs.getBigDecimal("total");
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalSpent;
    }
   
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
            pst = con.prepareStatement("INSERT INTO expenses (userid, category, amount, description, date) VALUES (?, ?, ?, ?, ?)");
            pst.setInt(1, userID);
            pst.setString(2, category);
            pst.setBigDecimal(3, expenseAmount);
            pst.setString(4, description);
            pst.setDate(5, sqlDate);

            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(this, "EXPENSE ADDED!");

                BigDecimal totalSpent = calculateTotalSpentAmount(category, userID);

                pst = con.prepareStatement("SELECT * FROM budget WHERE userid = ? AND category = ?");
                pst.setInt(1, userID);
                pst.setString(2, category);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    pst = con.prepareStatement("UPDATE budget SET spentamount = ? WHERE userid = ? AND category = ?");
                    pst.setBigDecimal(1, totalSpent);
                    pst.setInt(2, userID);
                    pst.setString(3, category);
                    pst.executeUpdate();
                } else {
                    pst = con.prepareStatement("INSERT INTO budget (userid, category, budgetamount, spentamount, date) VALUES (?, ?, 0, ?, ?)");
                    pst.setInt(1, userID);
                    pst.setString(2, category);
                    pst.setBigDecimal(3, totalSpent);
                    pst.setDate(4, sqlDate);
                    pst.executeUpdate();
                }

                fetchExpenses();
                loadExpenses();
                fetchBudget();
                loadBudget();
                showPieChart();
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
    
    private void exUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exUpdateActionPerformed
        String category = (String) categorycombobox.getSelectedItem();
        String amountText = amounttextfield1.getText();
        java.util.Date utilDate = jDateChooser1.getDate();
        String description = txtdescription.getText();
        String expenseId = exID.getSelectedItem().toString(); 

        java.sql.Date sqlDate = null;
        if (utilDate != null) {
            sqlDate = new java.sql.Date(utilDate.getTime());
        }

        BigDecimal newExpenseAmount = new BigDecimal(amountText);

        try {
            BigDecimal totalExpensesExcludingCurrent = getTotalExpensesExcludingCurrent(expenseId);
            BigDecimal totalBudget = getTotalBudget();

            if (totalExpensesExcludingCurrent.add(newExpenseAmount).compareTo(totalBudget) > 0) {
                JOptionPane.showMessageDialog(this, "The total expenses exceed the total budget!");
                return;
            }

            pst = con.prepareStatement("UPDATE expenses SET category=?, amount=?, description=?, date=? WHERE expenseid=?");

            pst.setString(1, category);
            pst.setBigDecimal(2, newExpenseAmount);
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
                showPieChart();
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
   
    private void exDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exDeleteActionPerformed
        try {
            String expenseId = exID.getSelectedItem().toString();

            BigDecimal expenseAmount = getExpenseAmount(Integer.parseInt(expenseId));

            pst = con.prepareStatement("DELETE FROM expenses WHERE expenseid=?");
            pst.setString(1, expenseId);
            int k = pst.executeUpdate();

            if (k == 1) {
                pst = con.prepareStatement("UPDATE budget SET spentamount = spentamount - ? WHERE budgetid IN (SELECT budgetid FROM expenses WHERE expenseid = ?)");
                pst.setBigDecimal(1, expenseAmount);
                pst.setString(2, expenseId);
                pst.executeUpdate();
                pst.close();

                JOptionPane.showMessageDialog(this, "EXPENSE DELETED!");
                categorycombobox.setSelectedIndex(0);
                amounttextfield1.setText("");
                jDateChooser1.setDate(null);
                txtdescription.setText("");
                fetchExpenses();
                loadExpenses();
                fetchBudget(); 
                showPieChart();
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
                showPieChart();
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
                showPieChart();
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
                showPieChart();
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
            showPieChart();
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
                showPieChart();
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
            BigDecimal newBudgetAmount = new BigDecimal(budgetAmountText);

            BigDecimal totalBudgetExcludingCurrent = getTotalBudgetExcludingCurrent(budgetId);
            BigDecimal totalIncome = getTotalIncome();

            if (totalBudgetExcludingCurrent.add(newBudgetAmount).compareTo(totalIncome) > 0) {
                JOptionPane.showMessageDialog(this, "The total budget exceeds the total income!");
                return;
            }

            pst = con.prepareStatement("UPDATE budget SET category=?, budgetamount=?, spentamount=?, date=? WHERE budgetid=?");

            pst.setString(1, category);
            pst.setBigDecimal(2, newBudgetAmount);
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
                showPieChart();
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
                String category = rs.getString("category");
                BigDecimal totalExpenses = calculateTotalExpensesForCategory(category);
                categorycombobox2.setSelectedItem(rs.getString("category"));
                txtbudgetamount.setText(rs.getBigDecimal("budgetamount").toString());
                txtspentamount.setText(totalExpenses.toString());
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

    private void exreportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exreportMouseClicked
        ExpenseReport exp=new ExpenseReport();
        exp.setVisible(true);
        exp.setLocationRelativeTo(null);
    }//GEN-LAST:event_exreportMouseClicked

    private void inreportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inreportMouseClicked
        IncomeReport inp=new IncomeReport();
        inp.setVisible(true);
        inp.setLocationRelativeTo(null);
    }//GEN-LAST:event_inreportMouseClicked

    private void budreportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_budreportMouseClicked
        BudgetReport budp=new BudgetReport();
        budp.setVisible(true);
        budp.setLocationRelativeTo(null);
    }//GEN-LAST:event_budreportMouseClicked

    private void sumreportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sumreportMouseClicked
        SummaryReport sump=new SummaryReport();
        sump.setVisible(true);
        sump.setLocationRelativeTo(null);
    }//GEN-LAST:event_sumreportMouseClicked

    private void dragpanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dragpanelMouseDragged
        int newX = getX() + evt.getX() - initialClickX;
        int newY = getY() + evt.getY() - initialClickY;
        setLocation(newX, newY);
    }//GEN-LAST:event_dragpanelMouseDragged

    private void dragpanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dragpanelMousePressed
        initialClickX = evt.getX();
        initialClickY = evt.getY();
    }//GEN-LAST:event_dragpanelMousePressed

    private void menu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu5MouseClicked
       jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_menu5MouseClicked

    private void menu5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu5MousePressed
        menu1.setBackground(DefaultColor);
        menu2.setBackground(DefaultColor);
        menu3.setBackground(DefaultColor);
        menu8.setBackground(DefaultColor);
        menu5.setBackground(ClickedColor);
        home.setBackground(DefaultColor);
    }//GEN-LAST:event_menu5MousePressed

    private void CHANGEPASSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CHANGEPASSActionPerformed
        String email = EMAIL_MATCH.getText(); 
        String currentPassword = CURRENT_PASS.getText(); 
        String newPassword = NEW_PASS.getText(); 

        if (!email.isEmpty() && !currentPassword.isEmpty() && !newPassword.isEmpty()) {
            try {               
                int userId = UserSession.getUserID(); 
                pst = con.prepareStatement("SELECT * FROM users WHERE userid = ? AND email = ? AND password = ?");
                pst.setInt(1, userId);
                pst.setString(2, email);
                pst.setString(3, currentPassword); 

                rs = pst.executeQuery();

                if (rs.next()) {                  
                    pst = con.prepareStatement("UPDATE users SET password = ? WHERE userid = ?");
                    pst.setString(1, newPassword);
                    pst.setInt(2, userId);
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(this, "Password changed successfully.");
                    Login log = new Login();
                    log.setVisible(true);
                    dispose(); 
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid email or current password. Please enter valid details.");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error changing password: " + ex.getMessage());
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (pst != null) pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
        }
    }//GEN-LAST:event_CHANGEPASSActionPerformed

    private void kButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton4ActionPerformed
       int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete your account?", "Delete Account", JOptionPane.YES_NO_OPTION);
    
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                
                pst = con.prepareStatement("DELETE FROM users WHERE userid = ?");
                pst.setInt(1, userID);
                int affectedRows = pst.executeUpdate();

                if (affectedRows > 0) {
                    JOptionPane.showMessageDialog(this, "Your account has been deleted successfully.");
                    
                    Login log = new Login();
                    log.setVisible(true);
                    dispose(); // Close the current window after account deletion
                } else {
                    JOptionPane.showMessageDialog(this, "Error deleting account. Please try again.");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error deleting account: " + ex.getMessage());
            } finally {
                try {
                    if (pst != null) pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_kButton4ActionPerformed
    
    
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
    private com.k33ptoo.components.KButton CHANGEPASS;
    private javax.swing.JTextField CURRENT_PASS;
    private javax.swing.JTextField EMAIL_MATCH;
    private javax.swing.JTextField NEW_PASS;
    private javax.swing.JTextField amounttextfield1;
    private javax.swing.border.BevelBorder bevelBorder1;
    private javax.swing.JComboBox<String> budID;
    private com.k33ptoo.components.KButton budadd;
    private com.k33ptoo.components.KButton buddelete;
    private javax.swing.JTable budgetTable;
    private javax.swing.JLabel budreport;
    private com.k33ptoo.components.KButton budupdate;
    private javax.swing.JComboBox<String> categorycombobox;
    private javax.swing.JComboBox<String> categorycombobox2;
    private javax.swing.JPanel dragpanel;
    private com.k33ptoo.components.KButton exDelete;
    private javax.swing.JComboBox<String> exID;
    private com.k33ptoo.components.KButton exUpdate;
    private javax.swing.JTable expensetable;
    private javax.swing.JLabel exreport;
    private javax.swing.JLabel fnamelabel;
    private javax.swing.JComboBox<String> frequencycombobox;
    private javax.swing.JPanel home;
    private javax.swing.JComboBox<String> inID;
    private com.k33ptoo.components.KButton inadd;
    private javax.swing.JTable incometable;
    private com.k33ptoo.components.KButton indelete;
    private javax.swing.JLabel inreport;
    private com.k33ptoo.components.KButton inupdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
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
    private javax.swing.JLabel jLabel36;
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
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
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
    private javax.swing.JToolBar jToolBar1;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KButton kButton2;
    private com.k33ptoo.components.KButton kButton3;
    private com.k33ptoo.components.KButton kButton4;
    private com.k33ptoo.components.KButton kButton7;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel labelexpense;
    private javax.swing.JLabel labelincome;
    private javax.swing.JLabel labelsavings;
    private javax.swing.JLabel labelspent;
    private javax.swing.JPanel menu1;
    private javax.swing.JPanel menu2;
    private javax.swing.JPanel menu3;
    private javax.swing.JPanel menu5;
    private javax.swing.JPanel menu8;
    private javax.swing.JPanel pieChartPanel;
    private javax.swing.JLabel profile;
    private javax.swing.JPanel recenttrans;
    private javax.swing.JPanel savings;
    private javax.swing.JComboBox<String> sortComboBox1;
    private javax.swing.JComboBox<String> sortComboBox2;
    private javax.swing.JComboBox<String> sortComboBox3;
    private javax.swing.JLabel sumreport;
    private javax.swing.JPanel totalex;
    private javax.swing.JPanel totalin;
    private javax.swing.JTextField txtamount2;
    private javax.swing.JTextField txtbudgetamount;
    private javax.swing.JTextArea txtdescription;
    private javax.swing.JTextField txtsource;
    private javax.swing.JTextField txtspentamount;
    // End of variables declaration//GEN-END:variables
}
