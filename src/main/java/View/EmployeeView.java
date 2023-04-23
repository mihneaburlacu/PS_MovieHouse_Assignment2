package View;

import Model.Enums.Type;
import Model.Movie;
import Model.User;
import ViewModel.VMAdministrator;
import ViewModel.VMEmployee;
import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.Binder;
import net.sds.mvvm.bindings.BindingType;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class EmployeeView extends JFrame {

    private JPanel contentPane;
    private JLabel welcomeLabel;
    @Bind(value = "text", target = "createIDTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField createIDTextField;
    @Bind(value = "text", target = "createNameTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField createNameTextField;
    @Bind(value = "text", target = "createTypeTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField createTypeTextField;
    @Bind(value = "text", target = "createCategoryTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField createCategoryTextField;
    @Bind(value = "text", target = "createYearTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField createYearTextField;
    private JLabel insertUsernameLabel;
    private JButton createButton;
    @Bind(value = "text", target = "nameReadTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField nameReadTextField;
    @Bind(value = "text", target = "idReadTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField idReadTextField;
    private JButton readButton;
    @Bind(value = "model", target = "readTable.value", type = BindingType.TARGET_TO_SOURCE)
    private JTable readTable;
    @Bind(value = "text", target = "updateIDTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField updateIDTextField;
    @Bind(value = "text", target = "nameDeleteTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField nameDeleteTextField;
    @Bind(value = "text", target = "idDeleteTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField idDeleteTextField;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton viewButton;
    private User employee;
    private String employeeID;
    private VMEmployee vmEmployee;
    @Bind(value = "text", target = "updateNameTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField updateNameTextField;
    @Bind(value = "text", target = "updateTypeTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField updateTypeTextField;
    @Bind(value = "text", target = "updateCategoryTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField updateCategoryTextField;
    @Bind(value = "text", target = "updateYearTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField updateYearTextField;

    public EmployeeView(User employee) {
        setTitle("MovieHouse - Employee");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 785, 575);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        welcomeLabel = new JLabel("Welcome, ");
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        welcomeLabel.setBounds(250, 10, 108, 29);
        contentPane.add(welcomeLabel);

        insertUsernameLabel = new JLabel("");
        insertUsernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        insertUsernameLabel.setBounds(356, 10, 130, 37);
        insertUsernameLabel.setForeground(Color.GREEN);
        contentPane.add(insertUsernameLabel);

        JLabel createLabel = new JLabel("Create movie:");
        createLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        createLabel.setBounds(10, 36, 108, 22);
        contentPane.add(createLabel);

        createIDTextField = new JTextField();
        createIDTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        createIDTextField.setColumns(10);
        createIDTextField.setBounds(10, 92, 74, 19);
        contentPane.add(createIDTextField);

        createNameTextField = new JTextField();
        createNameTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        createNameTextField.setColumns(10);
        createNameTextField.setBounds(94, 92, 78, 19);
        contentPane.add(createNameTextField);

        createTypeTextField = new JTextField();
        createTypeTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        createTypeTextField.setColumns(10);
        createTypeTextField.setBounds(178, 92, 88, 19);
        contentPane.add(createTypeTextField);

        createCategoryTextField = new JTextField();
        createCategoryTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        createCategoryTextField.setColumns(10);
        createCategoryTextField.setBounds(273, 92, 74, 19);
        contentPane.add(createCategoryTextField);

        createYearTextField = new JTextField();
        createYearTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        createYearTextField.setColumns(10);
        createYearTextField.setBounds(359, 92, 84, 19);
        contentPane.add(createYearTextField);

        createButton = new JButton("Create");
        createButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        createButton.setBounds(485, 82, 115, 29);
        contentPane.add(createButton);

        JLabel idInsertLabel = new JLabel("ID");
        idInsertLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        idInsertLabel.setBounds(36, 69, 45, 13);
        contentPane.add(idInsertLabel);

        JLabel nameInsertLabel = new JLabel("Name");
        nameInsertLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        nameInsertLabel.setBounds(124, 69, 45, 13);
        contentPane.add(nameInsertLabel);

        JLabel typeInsertLabel = new JLabel("Type");
        typeInsertLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        typeInsertLabel.setBounds(188, 69, 74, 13);
        contentPane.add(typeInsertLabel);

        JLabel categoryInsertLabel = new JLabel("Category");
        categoryInsertLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        categoryInsertLabel.setBounds(282, 69, 76, 13);
        contentPane.add(categoryInsertLabel);

        JLabel lblYear = new JLabel("Year");
        lblYear.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblYear.setBounds(368, 69, 45, 13);
        contentPane.add(lblYear);

        JLabel readLabel = new JLabel("Read movie:");
        readLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readLabel.setBounds(10, 116, 108, 22);
        contentPane.add(readLabel);

        JLabel readNameLabel = new JLabel("Enter the name: ");
        readNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readNameLabel.setBounds(36, 148, 152, 22);
        contentPane.add(readNameLabel);

        nameReadTextField = new JTextField();
        nameReadTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        nameReadTextField.setBounds(215, 150, 143, 19);
        contentPane.add(nameReadTextField);
        nameReadTextField.setColumns(10);

        JLabel readIDLabel = new JLabel("Enter ID: ");
        readIDLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readIDLabel.setBounds(36, 180, 152, 22);
        contentPane.add(readIDLabel);

        idReadTextField = new JTextField();
        idReadTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        idReadTextField.setColumns(10);
        idReadTextField.setBounds(215, 182, 143, 19);
        contentPane.add(idReadTextField);

        readButton = new JButton("Read");
        readButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readButton.setBounds(485, 155, 115, 29);
        contentPane.add(readButton);

        JLabel updateLabel = new JLabel("Update movie:");
        updateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        updateLabel.setBounds(10, 238, 108, 22);
        contentPane.add(updateLabel);

        readTable = new JTable();
        readTable.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null, null},
                },
                new String[] {
                        "New column", "New column", "New column", "New column", "New column", "New column"
                }
        ));
        readTable.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        readTable.setBounds(20, 212, 433, 16);
        contentPane.add(readTable);

        updateNameTextField = new JTextField();
        updateNameTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        updateNameTextField.setColumns(10);
        updateNameTextField.setBounds(39, 322, 78, 19);
        contentPane.add(updateNameTextField);

        updateTypeTextField = new JTextField();
        updateTypeTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        updateTypeTextField.setColumns(10);
        updateTypeTextField.setBounds(123, 322, 88, 19);
        contentPane.add(updateTypeTextField);

        updateCategoryTextField = new JTextField();
        updateCategoryTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        updateCategoryTextField.setColumns(10);
        updateCategoryTextField.setBounds(223, 322, 88, 19);
        contentPane.add(updateCategoryTextField);

        updateYearTextField = new JTextField();
        updateYearTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        updateYearTextField.setColumns(10);
        updateYearTextField.setBounds(329, 322, 84, 19);
        contentPane.add(updateYearTextField);

        JLabel lblNewLabel = new JLabel("Or save lists with info about movies");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNewLabel.setBounds(10, 516, 323, 22);
        contentPane.add(lblNewLabel);

        JLabel readIDLabel_1 = new JLabel("Enter ID: ");
        readIDLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readIDLabel_1.setBounds(36, 270, 152, 22);
        contentPane.add(readIDLabel_1);

        updateIDTextField = new JTextField();
        updateIDTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        updateIDTextField.setColumns(10);
        updateIDTextField.setBounds(215, 272, 143, 19);
        contentPane.add(updateIDTextField);

        JLabel nameInsertLabel_1 = new JLabel("Name");
        nameInsertLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        nameInsertLabel_1.setBounds(46, 302, 45, 13);
        contentPane.add(nameInsertLabel_1);

        JLabel typeInsertLabel_1 = new JLabel("Type");
        typeInsertLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        typeInsertLabel_1.setBounds(136, 302, 74, 13);
        contentPane.add(typeInsertLabel_1);

        JLabel categoryInsertLabel_1 = new JLabel("Category");
        categoryInsertLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        categoryInsertLabel_1.setBounds(235, 301, 76, 13);
        contentPane.add(categoryInsertLabel_1);

        JLabel lblYear_1 = new JLabel("Year");
        lblYear_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblYear_1.setBounds(356, 301, 45, 13);
        contentPane.add(lblYear_1);

        updateButton = new JButton("Update");
        updateButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        updateButton.setBounds(485, 272, 115, 29);
        contentPane.add(updateButton);

        JLabel deleteLabel = new JLabel("Delete movie:");
        deleteLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        deleteLabel.setBounds(10, 351, 108, 22);
        contentPane.add(deleteLabel);

        JLabel readNameLabel_1 = new JLabel("Enter the name: ");
        readNameLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readNameLabel_1.setBounds(36, 383, 152, 22);
        contentPane.add(readNameLabel_1);

        JLabel readIDLabel_2 = new JLabel("Enter ID: ");
        readIDLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readIDLabel_2.setBounds(36, 415, 152, 22);
        contentPane.add(readIDLabel_2);

        nameDeleteTextField = new JTextField();
        nameDeleteTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        nameDeleteTextField.setColumns(10);
        nameDeleteTextField.setBounds(215, 385, 143, 19);
        contentPane.add(nameDeleteTextField);

        idDeleteTextField = new JTextField();
        idDeleteTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        idDeleteTextField.setColumns(10);
        idDeleteTextField.setBounds(215, 417, 143, 19);
        contentPane.add(idDeleteTextField);

        deleteButton = new JButton("Delete");
        deleteButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        deleteButton.setBounds(485, 365, 115, 29);
        contentPane.add(deleteButton);

        JLabel viewLabel = new JLabel("View all movies sorted by type and by year");
        viewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        viewLabel.setBounds(10, 471, 332, 22);
        contentPane.add(viewLabel);

        viewButton = new JButton("View, filter or save lists");
        viewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        viewButton.setBounds(443, 468, 220, 29);
        contentPane.add(viewButton);

        JLabel lblOrFilter = new JLabel("Filter all movies by type, category or year");
        lblOrFilter.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblOrFilter.setBounds(10, 492, 332, 22);
        contentPane.add(lblOrFilter);

        this.employee = employee;
        this.employeeID = this.employee.getID() + "";

        setUsernameToInsertLabel(employee.getUsername());

        vmEmployee = new VMEmployee();
        try {
            Binder.bind(this, vmEmployee);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        catch (Error err) {
            err.printStackTrace();
        }

        addCreateButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    vmEmployee.createMovieCommand.execute();
                }catch(Exception error) {
                    System.out.println("Error while creating movie");
                    JOptionPane.showMessageDialog(null, "Error while creating movie");
                }
            }
        });

        addReadButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    vmEmployee.readMovieCommand.execute();
                }catch(Exception error) {
                    System.out.println("Error while reading movie");
                    JOptionPane.showMessageDialog(null, "Error while reading movie");
                }
            }
        });

        addDeleteButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    vmEmployee.deleteMovieCommand.execute();
                } catch(Exception exp) {
                    System.out.println("Exception while deleting movie ");
                    showMessage("Exception while deleting movie ");
                }
            }
        });

        addUpdateButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    vmEmployee.updateMovieCommand.execute();
                }catch (Error error) {
                    System.out.println("Error while updating the movie");
                    showMessage("Error while updating the movie");
                }
            }
        });

        addViewButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewAndFilterView viewAndFilterView = new ViewAndFilterView();
                viewAndFilterView.setVisible(true);
            }
        });
    }

    public void addCreateButton(ActionListener actionListener) {
        createButton.addActionListener(actionListener);
    }

    public void addReadButton(ActionListener actionListener) {
        readButton.addActionListener(actionListener);
    }

    public void addUpdateButton(ActionListener actionListener) {
        updateButton.addActionListener(actionListener);
    }

    public void addDeleteButton(ActionListener actionListener) {
        deleteButton.addActionListener(actionListener);
    }

    public void setUsernameToInsertLabel(String username) {
        insertUsernameLabel.setText(username);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public void addViewButton(ActionListener actionListener) {
        viewButton.addActionListener(actionListener);
    }

}