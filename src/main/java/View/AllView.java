package View;

import Model.User;
import ViewModel.VMAdministrator;
import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.Binder;
import net.sds.mvvm.bindings.BindingType;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class AllView extends JFrame{

    private JPanel contentPane;
    @Bind(value = "model", target = "table.value", type = BindingType.TARGET_TO_SOURCE)
    private JTable table;
    @Bind(value = "text", target = "filterTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField filterTextField;
    private JButton filterButton;
    private VMAdministrator vmAdministrator;

    public AllView() {
        setTitle("View all users");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 795, 570);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("View all or filter:");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblNewLabel.setBounds(300, 10, 190, 32);
        contentPane.add(lblNewLabel);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {"ID", "Name", "Username", "Password", "Role"},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                },
                new String[] {
                        "ID", "Name", "Username", "Password", "Role", ""
                }
        ));
        table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        table.setBounds(10, 66, 761, 347);
        contentPane.add(table);

        JLabel lblFilterAllUsers = new JLabel("Filter all users by role:");
        lblFilterAllUsers.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblFilterAllUsers.setBounds(10, 459, 180, 22);
        contentPane.add(lblFilterAllUsers);

        filterTextField = new JTextField();
        filterTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        filterTextField.setColumns(10);
        filterTextField.setBounds(190, 461, 143, 21);
        contentPane.add(filterTextField);

        filterButton = new JButton("Filter");
        filterButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        filterButton.setBounds(527, 456, 115, 29);
        contentPane.add(filterButton);

        vmAdministrator = new VMAdministrator();
        try {
            Binder.bind(this, vmAdministrator);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        catch (Error err) {
            err.printStackTrace();
        }

        vmAdministrator.viewAllUsersCommand.execute();
        designTables();

        addFilterListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmAdministrator.filterAllUsersCommand.execute();
                designTables();
            }
        });

    }

    public void designTables(){
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        for(int i = 0; i < table.getColumnModel().getColumnCount(); i++){
            table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
    }

    public void addFilterListener(ActionListener actionListener) {
        filterButton.addActionListener(actionListener);
    }

}

