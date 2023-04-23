package ViewModel;

import Model.DBContextUser;
import Model.Enums.Role;
import Model.User;
import View.AdministratorView;
import View.EmployeeView;
import View.ManagerView;

import javax.swing.*;

public class LoginCommand implements ICommand{
    private VMLogin vmLogin;

    public LoginCommand(){super();}

    public LoginCommand(VMLogin vmLogin) {
        this.vmLogin = vmLogin;
    }

    public VMLogin getVmLogin() {
        return vmLogin;
    }

    public void setVmLogin(VMLogin vmLogin) {
        this.vmLogin = vmLogin;
    }

    @Override
    public void execute() {
        DBContextUser dbContextUser = new DBContextUser();

        String username = vmLogin.getUserTextField();
        String password = vmLogin.getPasswordTextField();

        String query = dbContextUser.createFindQueryByUsernameAndPassword(username, password);
        User user = dbContextUser.findUser(query);

        if(user != null) {
            Role role = user.getRole();

            if(role == Role.ADMINISTRATOR) {
                AdministratorView administratorView = new AdministratorView(user);
                administratorView.setVisible(true);
            }
            else if(role == Role.EMPLOYEE) {
                EmployeeView employeeView = new EmployeeView(user);
                employeeView.setVisible(true);
            }
            else {
                ManagerView managerView = new ManagerView(user);
                managerView.setVisible(true);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Username or password incorrect, please try again!");
        }
    }
}
