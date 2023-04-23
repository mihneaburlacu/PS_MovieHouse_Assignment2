package View;

import Model.Movie;
import ViewModel.VMEmployee;
import ViewModel.VMLogin;
import ViewModel.VMViewAndFilter;
import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.Binder;
import net.sds.mvvm.bindings.BindingType;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ViewAndFilterView extends JFrame{

    private JPanel contentPane;
    @Bind(value = "model", target = "table.value", type = BindingType.TARGET_TO_SOURCE)
    private JTable table;
    private JButton viewButton;
    private String[] stringChoices = new String[]{"TYPE", "CATEGORY", "YEAR"};
    @Bind(value = "model", target = "filterComboBox.value", type = BindingType.BI_DIRECTIONAL)
    private JComboBox filterComboBox;
    @Bind(value = "text", target = "filterTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField filterTextField;
    private JTextField textField;
    private JButton filterButton;
    private JButton txtButton;
    private JButton xmlButton;
    private JButton csvButton;
    private JButton jsonButton;
    private VMViewAndFilter vmViewAndFilter;

    public ViewAndFilterView() {
        setTitle("View, filter and save info");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 890, 586);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("View, filter and save info:");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblNewLabel.setBounds(300, 10, 400, 32);
        contentPane.add(lblNewLabel);

        JLabel viewLabel = new JLabel("View all movies sorted by type and by year:");
        viewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        viewLabel.setBounds(10, 50, 332, 22);
        contentPane.add(viewLabel);

        viewButton = new JButton("View");
        viewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        viewButton.setBounds(527, 50, 115, 29);
        contentPane.add(viewButton);

        JLabel lblFilterAllMovies = new JLabel("Filter all movies by:");
        lblFilterAllMovies.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblFilterAllMovies.setBounds(10, 124, 164, 22);
        contentPane.add(lblFilterAllMovies);

        filterComboBox = new JComboBox<String>(stringChoices);
        filterComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        filterComboBox.setBounds(160, 126, 143, 21);
        contentPane.add(filterComboBox);

        filterButton = new JButton("Filter");
        filterButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        filterButton.setBounds(527, 121, 115, 29);
        contentPane.add(filterButton);

        filterTextField = new JTextField();
        filterTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        filterTextField.setBounds(328, 127, 161, 19);
        contentPane.add(filterTextField);
        filterTextField.setColumns(10);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {"ID", "NAME", "TYPE", "CATEGORY", "YEAR", "ID_CREATOR"},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                },
                new String[] {
                        "ID", "NAME", "TYPE", "CATEGORY", "YEAR", "ID_CREATOR"
                }
        ));
        table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        table.setBounds(10, 192, 761, 347);
        contentPane.add(table);

        txtButton = new JButton("TXT");
        txtButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        txtButton.setBounds(114, 82, 96, 21);
        contentPane.add(txtButton);

        xmlButton = new JButton("XML");
        xmlButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        xmlButton.setBounds(220, 82, 96, 21);
        contentPane.add(xmlButton);

        csvButton = new JButton("CSV");
        csvButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        csvButton.setBounds(326, 82, 96, 21);
        contentPane.add(csvButton);

        jsonButton = new JButton("JSON");
        jsonButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        jsonButton.setBounds(432, 82, 96, 21);
        contentPane.add(jsonButton);

        JLabel lblNewLabel_1 = new JLabel("Save info:");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(10, 82, 102, 22);
        contentPane.add(lblNewLabel_1);

        vmViewAndFilter = new VMViewAndFilter();
        try{
            Binder.bind(this, vmViewAndFilter);
        } catch(Exception ex) {
            System.out.println("\nError with binding at LogIn\n");
            ex.printStackTrace();
        }

        addViewButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetTable();
                vmViewAndFilter.viewAllMoviesCommand.execute();
                designTables();
            }
        });

        addFilterButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetTable();
                vmViewAndFilter.filterAllMoviesCommand.execute();
                designTables();
            }
        });

        addTxtButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmViewAndFilter.createTxtMoviesCommand.execute();
            }
        });

        addCSVButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmViewAndFilter.createCsvMoviesCommand.execute();
            }
        });

        addJSONButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmViewAndFilter.createJsonMoviesCommand.execute();
            }
        });

        addXmlButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmViewAndFilter.createXmlMoviesCommand.execute();
            }
        });
    }

    public void resetTable() {
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {"ID", "NAME", "TYPE", "CATEGORY", "YEAR", "ID_CREATOR"},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                },
                new String[] {
                        "ID", "NAME", "TYPE", "CATEGORY", "YEAR", "ID_CREATOR"
                }
        ));
    }


    public void addViewButton(ActionListener actionListener) {
        viewButton.addActionListener(actionListener);
    }

    public void addFilterButton(ActionListener actionListener) {
        filterButton.addActionListener(actionListener);
    }

    public void addTxtButton(ActionListener actionListener) {
        txtButton.addActionListener(actionListener);
    }

    public void addXmlButton(ActionListener actionListener) {
        xmlButton.addActionListener(actionListener);
    }

    public void addCSVButton(ActionListener actionListener) {
        csvButton.addActionListener(actionListener);
    }

    public void addJSONButton(ActionListener actionListener) {
        jsonButton.addActionListener(actionListener);
    }

    public void designTables(){
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        for(int i = 0; i < table.getColumnModel().getColumnCount(); i++){
            table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
    }

}
