package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Program: Assignment 2, employeesGui. GUI will handle adding employees and products
 *          as well as searching for existing employees and/or products. Part one does not
 *          include functionality.
 * Author:  Mark Chipp 200180985 <mark.chipp@mygeorgian.ca, mark.chipp@live.ca>
 * Edited:  27-Nov-2016
 */
public class EmployeesGui extends JFrame
{
    private JPanel  greetingPanel, hrPanel = new JPanel(), invenPanel = new JPanel(), searchPanel = new JPanel(), 
                    hrTopPanel, hrBottomPanel, buttonPanel, invenTopPanel;
    private JLabel  lblGreeting, lblFirstName, lblLastName, lblGender, lblAge, lblDepartment, lblPrice, lblEmpSearch, lblProdSearch,
                    lblPosition, lblSupervisor, lblManager, lblProduct, lblMfg, lblStockCode, lblStockCount;
    private JTextField  txtFirstName, txtLastName, txtGender, txtAge, txtDepartment,
                        txtPosition, txtSupervisor, txtManager, txtGreeting, txtPrice, txtEmpSearch, txtProdSearch,
                        txtProduct, txtMfg, txtStockCode, txtStockCount;
    private JButton btnExitButton, btnSearchButton;
    
    public EmployeesGui()
    {
        // super calls
        super("Employee Register");
        setLayout(new BorderLayout());
        
        // creating a tabbed interface
        JTabbedPane tabPane = new JTabbedPane();
        
        // call functions to build panels
        buildGreetingPanel("Welcome to the Employee Register");
        buildHrPanel();
        buildBottomPanel();
        buildInventoryPanel();
        buildSearchPanel();
        
        hrPanel.setLayout(new BorderLayout());
        hrPanel.add(hrTopPanel,BorderLayout.NORTH);
        hrPanel.add(hrBottomPanel,BorderLayout.SOUTH);
        
        invenPanel.setLayout(new BorderLayout());
        invenPanel.add(invenTopPanel,BorderLayout.NORTH);
        
        tabPane.addTab("HR", null, hrPanel, "HR Tab");
        tabPane.addTab("Inventory", null, invenPanel, "Inventory Tab");
        tabPane.addTab("Search", null, searchPanel, "Search Tab");
        
        add(greetingPanel, BorderLayout.NORTH);
        add(tabPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    public void buildGreetingPanel(String message)
    {
        greetingPanel = new JPanel();
        lblGreeting = new JLabel(message);
        greetingPanel.add(lblGreeting);
        greetingPanel.setBorder(BorderFactory.createRaisedBevelBorder());
    }
    
    public void buildHrPanel()
    {
        // creating main panel
        hrTopPanel = new JPanel();
        hrTopPanel.setLayout(new GridLayout(2,2));
        
        // creating top panel labels
        hrTopPanel.setBorder(BorderFactory.createTitledBorder("Employee Information"));
        lblFirstName = new JLabel("First Name:");
        lblLastName = new JLabel("Last Name:");
        lblGender = new JLabel("Gender:");
        lblAge = new JLabel("Age:");
        
        // creating top panel text boxes
        txtFirstName = new JTextField(15);
        txtLastName = new JTextField(15);
        txtGender = new JTextField(15);
        txtAge = new JTextField(2);
        
        // add labels and text to the top panel
        hrTopPanel.add(lblFirstName);
        hrTopPanel.add(txtFirstName);
        hrTopPanel.add(lblLastName);
        hrTopPanel.add(txtLastName);
        hrTopPanel.add(lblGender);
        hrTopPanel.add(txtGender);
        hrTopPanel.add(lblAge);
        hrTopPanel.add(txtAge);        
      
        // creating bottom panel
        hrBottomPanel = new JPanel();
        hrBottomPanel.setLayout(new GridLayout(2,2));
        
        // create bottom panel labels
        hrBottomPanel.setBorder(BorderFactory.createTitledBorder("Position Information"));
        lblDepartment = new JLabel("Department:");
        lblPosition = new JLabel("Position:");
        lblSupervisor = new JLabel("Supervisor:");
        lblManager = new JLabel("Manager:");
        
        // create bottom panel text boxes
        txtDepartment = new JTextField(15);
        txtPosition = new JTextField(15);
        txtSupervisor = new JTextField(15);
        txtManager = new JTextField(15);
        
        // add labels and text to the bottom panel
        hrBottomPanel.add(lblDepartment);
        hrBottomPanel.add(txtDepartment);
        hrBottomPanel.add(lblPosition);
        hrBottomPanel.add(txtPosition);
        hrBottomPanel.add(lblSupervisor);
        hrBottomPanel.add(txtSupervisor);
        hrBottomPanel.add(lblManager);
        hrBottomPanel.add(txtManager);        
    }
    
    public void buildBottomPanel()
    {
        buttonPanel = new JPanel();
        btnExitButton = new JButton("Exit");
        btnExitButton.addActionListener(new ExitButtonListener());
        buttonPanel.add(btnExitButton);
    }
    
    public void buildInventoryPanel()
    {
        // creating inventory top panel
        invenTopPanel = new JPanel();
        invenTopPanel.setLayout(new GridLayout(3,2));
        
        // creating inventory panel labels
        invenTopPanel.setBorder(BorderFactory.createTitledBorder("Product Information"));
        lblProduct = new JLabel("Product Name:");
        lblMfg = new JLabel("Manufacturer:");
        lblStockCode = new JLabel("Item Code:");
        lblStockCount = new JLabel("Stock:");
        lblPrice = new JLabel("Price:");
        
        // creating inventory panel text        
        txtProduct = new JTextField(15);
        txtMfg = new JTextField(15);
        txtStockCode = new JTextField(12);
        txtStockCount = new JTextField(4);
        txtPrice = new JTextField(8);
        
        // add text fields and labels to inventory panel
        invenTopPanel.add(lblProduct);
        invenTopPanel.add(txtProduct);
        invenTopPanel.add(lblMfg);
        invenTopPanel.add(txtMfg);
        invenTopPanel.add(lblStockCode);
        invenTopPanel.add(txtStockCode);
        invenTopPanel.add(lblStockCount);
        invenTopPanel.add(txtStockCount);
        invenTopPanel.add(lblPrice);
        invenTopPanel.add(txtPrice);
    }
    
    private void buildSearchPanel()
    {
        
        // creating inventory top panel
        searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(3,2));
        
        // creating search panel labels 
        lblEmpSearch = new JLabel("Empolyee name or number:");
        lblProdSearch = new JLabel("Product name or number");
        
        // creating search panel text
        txtEmpSearch = new JTextField(25);
        txtProdSearch = new JTextField(25);
        
        // setup search button
        btnSearchButton = new JButton("Search");
        btnSearchButton.addActionListener(new SearchButtonListener());
        
        // add text fields, buttons, and labels to search panel
        searchPanel.add(lblEmpSearch);
        searchPanel.add(txtEmpSearch);
        searchPanel.add(lblProdSearch);
        searchPanel.add(txtProdSearch);        
        searchPanel.add(btnSearchButton);
        
        
    }
    
    private class ExitButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            // check if user wants to exit. If yes, exit application
            if (JOptionPane.showConfirmDialog(null, "Are you sure you wish to exit?", "Exit?", JOptionPane.YES_NO_OPTION)==0)
            {
                System.exit(0);
            }
        }
    }
    
    private class SearchButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            // add functionality for search button here
        }
    }
    
    public static void main(String[] args)
    {
        EmployeesGui gui = new EmployeesGui();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.pack();
        gui.setVisible(true);
    }
}