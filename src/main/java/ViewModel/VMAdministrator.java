package ViewModel;

import Model.Enums.Role;
import Model.User;
import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.BindingType;
import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VMAdministrator {
    private Property<String> createIDTextField;
    private Property<String> createNameTextField;
    private Property<String> createUsernameTextField;
    private Property<String> createPasswordTextField;
    private Property<String> createRoleTextField;
    public ICommand createUserCommand;

    private Property<String> usernameDeleteTextField;
    private Property<String> idDeleteTextField;
    public ICommand deleteUserCommand;

    private Property<String> updateNameTextField;
    private Property<String> updateUsernameTextField;
    private Property<String> updatePasswordTextField;
    private Property<String> updateRoleTextField;
    private Property<String> updateIDTextField;
    public ICommand updateUserCommand;

    private Property<String> usernameReadTextField;
    private Property<String> idReadTextField;
    private Property<DefaultTableModel> readTable;
    public ICommand readUserCommand;

    private Property<DefaultTableModel> table;
    public ICommand viewAllUsersCommand;

    private Property<String> filterTextField;
    public ICommand filterAllUsersCommand;

    public VMAdministrator() {
        createIDTextField = PropertyFactory.createProperty("createIDTextField", this, String.class);
        createNameTextField = PropertyFactory.createProperty("createNameTextField", this, String.class);
        createUsernameTextField = PropertyFactory.createProperty("createUsernameTextField", this, String.class);
        createPasswordTextField = PropertyFactory.createProperty("createPasswordTextField", this, String.class);
        createRoleTextField = PropertyFactory.createProperty("createRoleTextField", this, String.class);
        this.createUserCommand = new CreateUserCommand(this);

        usernameDeleteTextField = PropertyFactory.createProperty("usernameDeleteTextField", this, String.class);
        idDeleteTextField = PropertyFactory.createProperty("idDeleteTextField", this, String.class);
        this.deleteUserCommand = new DeleteUserCommand(this);

        updateIDTextField = PropertyFactory.createProperty("updateIDTextField", this, String.class);
        updateNameTextField = PropertyFactory.createProperty("updateNameTextField", this, String.class);
        updateUsernameTextField = PropertyFactory.createProperty("updateUsernameTextField", this, String.class);
        updatePasswordTextField = PropertyFactory.createProperty("updatePasswordTextField", this, String.class);
        updateRoleTextField = PropertyFactory.createProperty("updateRoleTextField", this, String.class);
        this.updateUserCommand = new UpdateUserCommand(this);

        usernameReadTextField = PropertyFactory.createProperty("usernameReadTextField", this, String.class);
        idReadTextField = PropertyFactory.createProperty("idReadTextField", this, String.class);
        readTable = PropertyFactory.createProperty("readTable", this, new DefaultTableModel());
        this.readUserCommand = new ReadUserCommand(this);

        table = PropertyFactory.createProperty("table", this, new DefaultTableModel());
        this.viewAllUsersCommand = new ViewAllUsersCommand(this);

        filterTextField = PropertyFactory.createProperty("filterTextField", this, String.class);
        this.filterAllUsersCommand = new FilterAllUsersCommand(this);
    }

    public String getCreateID() {
        return createIDTextField.get();
    }

    public String getCreateName() {
        return createNameTextField.get();
    }

    public String getCreateUsername() {
        return createUsernameTextField.get();
    }

    public String getCreatePassword() {
        return createPasswordTextField.get();
    }

    public String getCreateRole() {
        return createRoleTextField.get();
    }

    public String getDeleteID() {return idDeleteTextField.get();}

    public String getDeleteUsername() {return usernameDeleteTextField.get();}

    public String getUpdateID() {
        return updateIDTextField.get();
    }

    public String getUpdateName() {
        return updateNameTextField.get();
    }

    public String getUpdateUsername() {
        return updateUsernameTextField.get();
    }

    public String getUpdatePassword() {
        return updatePasswordTextField.get();
    }

    public String getUpdateRole() {
        return updateRoleTextField.get();
    }

    public DefaultTableModel getReadTable(){
        return readTable.get();
    }

    public void setReadTable(DefaultTableModel defaultTableModel) {
        readTable.set(defaultTableModel);
    }

    public String getReadUsername() {
        return usernameReadTextField.get();
    }

    public String getReadID() {
        return idReadTextField.get();
    }

    public DefaultTableModel getTable(){
        return table.get();
    }

    public void setTable(DefaultTableModel defaultTableModel) {
        table.set(defaultTableModel);
    }

    public String getRoleFilter() {
        return filterTextField.get();
    }
}
