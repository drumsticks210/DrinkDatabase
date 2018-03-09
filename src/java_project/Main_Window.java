/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author drums
 */
public final class Main_Window extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    

        public Main_Window() 
        {
        initComponents();
        getConnection();
        Show_Cocktails_In_JTable();
        Show_Ingredient_In_JTable();
        }
        
        int pos = 0;
        
        
        
    
     // Function To Connect To MySQL Database 
     // Added derbyclient.jar file to project library to get connected to DB   
    public final Connection getConnection()
    {
        Connection con = null;
        
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/drink_database;user=drumsticks210;password=US.army.123");
           JOptionPane.showMessageDialog(null, "Connected");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null, "Not Connected");
            return null;
        }
        
    }
    
    
    
    //Check Input Fields 
    public boolean checkInputs()
    {
        if(
                   txt_ID.getText() == null
                || txt_name.getText() == null 
                || txt_description.getText() == null
                || txt_catagoryID.getSelectedItem() == null
                || txt_methodID.getSelectedItem() == null
                || txt_methodID.getSelectedItem() == null
                || txt_extraID.getText() == null
                 ){
            return false;
        }
        else {
            try{
                //Float.parseFloat(txt_name.getText());
                return true;
            }catch(Exception ex){
                return false;
            }
        }
    }
    

    
    
    
    // Display Data in JTable: 
    //  1 - Fill ArrayList With The Data
    public ArrayList<Cocktail> getDrinksList() 
    {
        
                ArrayList<Cocktail> cocktailList = new ArrayList<Cocktail>();
                Connection con = getConnection();
                String query = "SELECT * FROM APP.DRINKS";
                
                Statement st;
                ResultSet rs;
           
            try {
                
                st = con.createStatement();
                rs = st.executeQuery(query);
                Cocktail cocktail;
                
                while (rs.next())
                {
                    cocktail = new Cocktail(rs.getString("Drink_ID"), rs.getString("Drink_Name"), rs.getString("drinkDescription"), 
                            rs.getString("drinkCatagory_ID"), rs.getString("glass_ID"), rs.getString("method_ID"), rs.getString("extra_ID"));
                    cocktailList.add(cocktail);
                }
                
            } catch (SQLException ex) {
                
                Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return cocktailList;
        
    }
    
    //  2 - Populate the JTable
    
    public void Show_Cocktails_In_JTable()
    {
        ArrayList<Cocktail> list = getDrinksList();
        DefaultTableModel model = (DefaultTableModel)JTable_Cocktails.getModel();
        
        //clear jtable conteent
        model.setRowCount(0);
        Object[] row = new Object[7];
        for(int i = 0; i < list.size(); i++)
        {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getdrinkDescription();
            row[3] = list.get(i).getcatagoryID();
            row[4] = list.get(i).getglassID();
            row[5] = list.get(i).getmethodID();
            row[6] = list.get(i).getextraID();
            
            model.addRow(row);
            
        }
    }
    
      // Display Ingredient Data in JTable: 
    //  1 - Fill ArrayList With The Data
    public ArrayList<Ingredient> getIngredientList() 
    {
        
                ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
                Connection con = getConnection();
                String query = "SELECT * FROM APP.Drink_Ingredient";
                
                Statement st;
                ResultSet rs;
           
            try {
                
                st = con.createStatement();
                rs = st.executeQuery(query);
                Ingredient ingredient;
                
                while (rs.next())
                {
                    ingredient = new Ingredient(rs.getString("Ingredient_chart_ID"), rs.getString("Drink_ID"), rs.getString("IngredientID"), 
                            rs.getString("Ingredientamount"));
                    ingredientList.add(ingredient);
                }
                
            } catch (SQLException ex) {
                
                Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return ingredientList;
        
    }
    
    //  2 - Populate the JTable
    
    public void Show_Ingredient_In_JTable()
    {
        ArrayList<Ingredient> list = getIngredientList();
        DefaultTableModel model = (DefaultTableModel)jTable_ingredient.getModel();
        
        //clear jtable conteent
        model.setRowCount(0);
        Object[] row = new Object[4];
        for(int i = 0; i < list.size(); i++)
        {
            row[0] = list.get(i).getIngredient_Chart_id();
            row[1] = list.get(i).getDrink_id();
            row[2] = list.get(i).getIngredient_id();
            row[3] = list.get(i).getingredient_amount();

            model.addRow(row);
            
        }
    }
    
    public void ShowItem(int index)
    {
        txt_ID.setText(getDrinksList().get(index).getId());
        txt_name.setText(getDrinksList().get(index).getName());
        txt_description.setText(getDrinksList().get(index).getdrinkDescription());
        txt_catagoryID.setSelectedItem(getDrinksList().get(index).getcatagoryID());
        txt_glassID.setSelectedItem(getDrinksList().get(index).getglassID());
        txt_methodID.setSelectedItem(getDrinksList().get(index).getmethodID());
        txt_extraID.setText(getDrinksList().get(index).getextraID());
        
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_ID = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        txt_extraID = new javax.swing.JTextField();
        btn_insert = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_first = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        btn_previous = new javax.swing.JButton();
        btn_last = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable_Cocktails = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txt_description = new javax.swing.JTextArea();
        txt_catagoryID = new javax.swing.JComboBox<>();
        txt_methodID = new javax.swing.JComboBox<>();
        txt_glassID = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable_ingredient = new javax.swing.JTable();
        txt_search = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        jLabel1.setText("ID:");

        jLabel2.setText("Drink Name:");

        jLabel3.setText("Drink Description");

        jLabel4.setText("Drink Catagory_ID");

        jLabel5.setText("Glass ID");

        jLabel6.setText("Method ID:");

        jLabel7.setText("Extra ID:");

        btn_insert.setText("Insert");
        btn_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertActionPerformed(evt);
            }
        });

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_first.setText("|<- First");
        btn_first.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_firstActionPerformed(evt);
            }
        });

        btn_next.setText("> Next");
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        btn_previous.setText("<Previous");
        btn_previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_previousActionPerformed(evt);
            }
        });

        btn_last.setText("->| Last");
        btn_last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lastActionPerformed(evt);
            }
        });

        JTable_Cocktails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Drink Name", "Description", "Catagory ID", "Glass ID", "Method ID", "Extra ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTable_Cocktails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTable_CocktailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTable_Cocktails);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Drink Catagory ID's:\n    \"DC001\" = After Dinner Cocktail\n    \"DC002\" = Before Dinner Cocktail\n    \"DC003\" = Sparkling Cocktail\n    \"DC004\" = All Day Cocktail\n    \"DC005\" = Longdrink");
        jTextArea1.setEnabled(false);
        jScrollPane2.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("Glass Category ID's:\n   \"GL001\" = Highball \n   \"GL002\" = Cocktail\n   \"GL003\" = Chapmagne\n   \"GL004\" = Large\n   \"GL005\" = Old Fashioned\n   \"GL006\" = Large Goblet\n   \"GL007\" = Rocks\n   \"GL008\" = Any\n   \"GL009\" = Martini \n   \"GL0010\" = Wine\n   \"GL00111\" = Double");
        jTextArea2.setEnabled(false);
        jScrollPane3.setViewportView(jTextArea2);

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jTextArea3.setText("Method Category ID's:\n    MD001 = Shake and strain\n    MD002 = Mix with ice\n    MD003 = Layer ingredients\n    MD004 = Stir\n    MD005 = Pour\n    MD006 = Muddle lime, sugar and mint\n    MD007 = Muddle the mint, sugar and water. Stir\n    MD008 = Disolve sugar with bitters and water, add rest.\n    MD009 = Blend\n    MD010 = Dry shake, hard shake and strain\n    MD011 = Stir gently\n    MD012 = Pour(build)\n    MD013 = Pour, do not stir\n    MD014 = Stir and strain \n    MD015 = Muddle\n\n\n");
        jTextArea3.setEnabled(false);
        jScrollPane4.setViewportView(jTextArea3);

        txt_description.setColumns(20);
        txt_description.setLineWrap(true);
        txt_description.setRows(5);
        jScrollPane5.setViewportView(txt_description);

        txt_catagoryID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DC001", "DC002", "DC003", "DC004", "DC005" }));
        txt_catagoryID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_catagoryIDActionPerformed(evt);
            }
        });

        txt_methodID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MD001", "MD002", "MD003", "MD004", "MD005", "MD006", "MD007", "MD008", "MD009", "MD010", "MD011", "MD012", "MD013", "MD014", "MD015" }));

        txt_glassID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GL001", "GL002", "GL003", "GL004", "GL005", "GL006", "GL007", "GL008", "GL009", "GL010", "GL011" }));

        jTable_ingredient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ingredient Chart ID", "Drink ID", "Ingredient ID", "Ingredient  Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_ingredient.setEnabled(false);
        jScrollPane6.setViewportView(jTable_ingredient);

        txt_search.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
            }
        });
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("Search Box");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1)))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_methodID, 0, 83, Short.MAX_VALUE)
                                            .addComponent(txt_glassID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txt_catagoryID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                            .addComponent(jScrollPane3)
                                            .addComponent(jScrollPane2)))
                                    .addComponent(jScrollPane5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(txt_extraID, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_insert, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(189, 189, 189))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(272, 272, 272)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(btn_first, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_previous, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_last, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(204, 204, 204))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(67, 67, 67))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_catagoryID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_glassID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txt_methodID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_extraID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_insert, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_first, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_previous, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_last, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
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
    }// </editor-fold>//GEN-END:initComponents

    private void btn_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertActionPerformed
        
        if(checkInputs() != false)
        {
             try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO APP.DRINKS(Drink_ID, Drink_Name, Drinkdescription, DrinkCatagory_ID, Glass_ID, Method_ID, Extra_ID)"
                        + "values(?,?,?,?,?,?,?) ");
                ps.setString(1, txt_ID.getText());
                ps.setString(2, txt_name.getText());
                ps.setString(3, txt_description.getText());
                ps.setObject(4, txt_catagoryID.getSelectedItem());
                ps.setObject(5, txt_glassID.getSelectedItem());
                ps.setObject(6, txt_methodID.getSelectedItem());
                ps.setString(7, txt_extraID.getText());
                                
                ps.executeUpdate();
                
                Show_Cocktails_In_JTable();
                
                //JOptionPane.showMessageDialog(null, "One or More Fields Are Empty");
                 JOptionPane.showMessageDialog(null, "Data Inserted");
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }else{
                JOptionPane.showMessageDialog(null, "One or More Fields Are Empty");
            
        }
       
        //Only for testing
        System.out.println("ID => "+ txt_ID.getText());
        System.out.println("Name => "+ txt_name.getText());
        System.out.println("Descripton => "+ txt_description.getText());
        System.out.println("Method => "+ txt_catagoryID.getSelectedItem());
        System.out.println("Ingredient => "+ txt_glassID.getSelectedItem());
        System.out.println("Catagory => "+ txt_methodID.getSelectedItem());
        System.out.println("Glass => "+ txt_extraID.getText());
        
    }//GEN-LAST:event_btn_insertActionPerformed

    
    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        
        if (!txt_ID.getText().equals("") )
        {
            try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("DELETE FROM APP.DRINKS WHERE Drink_ID = ?");
                String id = txt_ID.getText();
                ps.setString(1, id);
                JOptionPane.showMessageDialog(null, "Drink Deleted");
                ps.executeUpdate();
                Show_Cocktails_In_JTable();
            } catch (SQLException ex) {
                Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Drink NOT Deleted");
            }
           
        }else{
            JOptionPane.showMessageDialog(null, "Drink Deleted : No ID To Delete");
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        
        if ( checkInputs() && txt_ID != null){
            try {
                String UpdateQuery = null;
                PreparedStatement ps = null;
                Connection con = getConnection();
                
                UpdateQuery = "UPDATE APP.DRINKS SET Drink_name = ?, "
                        + "Drinkdescription = ?, DrinkCatagory_ID = ?, Glass_ID = ?, Method_ID = ?,"
                        + "Extra_ID = ? WHERE Drink_ID = ?";
                
                ps = con.prepareStatement(UpdateQuery);
             
                ps.setString(1, txt_name.getText());
                ps.setString(2, txt_description.getText());
                ps.setObject(3, txt_catagoryID.getSelectedItem());
                ps.setObject(4, txt_glassID.getSelectedItem());
                ps.setObject(5, txt_methodID.getSelectedItem());
                ps.setString(6, txt_extraID.getText());
                ps.setString(7, txt_ID.getText());
                
                ps.executeUpdate();
                Show_Cocktails_In_JTable();
                JOptionPane.showMessageDialog(null, "Drink Updated");
                                                
            } catch (SQLException ex) {
               Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
            }
         } else {
            
            JOptionPane.showMessageDialog(null, "One or more firleds are EMPTY or WRONG");
        }       
          
    }//GEN-LAST:event_btn_updateActionPerformed

    private void JTable_CocktailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTable_CocktailsMouseClicked
        
        int index = JTable_Cocktails.getSelectedRow();
        ShowItem(index);
    }//GEN-LAST:event_JTable_CocktailsMouseClicked

    private void txt_catagoryIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_catagoryIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_catagoryIDActionPerformed

    private void btn_firstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_firstActionPerformed
        pos = 0;
        ShowItem(pos);
    }//GEN-LAST:event_btn_firstActionPerformed

    private void btn_lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lastActionPerformed
        pos = getDrinksList().size() - 1;
        ShowItem(pos);
    }//GEN-LAST:event_btn_lastActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        pos++;
        if (pos >= getDrinksList().size())
        {
            pos = getDrinksList().size()-1;
        }
        
        ShowItem(pos);
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btn_previousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_previousActionPerformed
        pos--;
        if (pos < 0)
        {
            pos = 0;
        }
        ShowItem(pos);
    }//GEN-LAST:event_btn_previousActionPerformed

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchActionPerformed

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased

        PreparedStatement ps = null;
        Connection con = getConnection();
        ResultSet rs;
        try{

            String sql1 = "SELECT * FROM APP.DRINKS WHERE Drink_Name =?"; //Drink_ID =?
            ps=con.prepareStatement(sql1);
            ps.setString(1, txt_search.getText());
            rs=ps.executeQuery();
            if(rs.next()){
                String add1 = rs.getString("DrinkDescription");
                txt_description.setText(add1);
                String add2 = rs.getString("Drink_Name");
                txt_name.setText(add2);
                String add3 = rs.getString("Drink_ID");
                txt_ID.setText(add3);
                String add4 = rs.getString("Extra_ID");
                txt_extraID.setText(add3);
                Object add5 = rs.getObject("DrinkCatagory_ID");
                txt_catagoryID.setSelectedItem(add5);
                Object add6 = rs.getObject("Glass_ID");
                txt_glassID.setSelectedItem(add6);
                Object add7 = rs.getObject("Method_ID");
                txt_methodID.setSelectedItem(add7);
                


            }

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_txt_searchKeyReleased

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
            java.util.logging.Logger.getLogger(Main_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTable_Cocktails;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_first;
    private javax.swing.JButton btn_insert;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_previous;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable_ingredient;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField txt_ID;
    private javax.swing.JComboBox<String> txt_catagoryID;
    private javax.swing.JTextArea txt_description;
    private javax.swing.JTextField txt_extraID;
    private javax.swing.JComboBox<String> txt_glassID;
    private javax.swing.JComboBox<String> txt_methodID;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
