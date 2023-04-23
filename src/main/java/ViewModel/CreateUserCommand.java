package ViewModel;

import Model.DBContextUser;
import Model.Enums.Role;
import Model.User;

public class CreateUserCommand implements ICommand{
    private VMAdministrator vmAdministrator;

    public CreateUserCommand() {super();}

    public CreateUserCommand(VMAdministrator vmAdministrator) {
        this.vmAdministrator = vmAdministrator;
    }

    @Override
    public void execute() {
        DBContextUser dbContextUser = new DBContextUser();

        int id = Integer.parseInt(vmAdministrator.getCreateID());
        String name = vmAdministrator.getCreateName();
        String username = vmAdministrator.getCreateUsername();
        String password = vmAdministrator.getCreatePassword();
        String role = vmAdministrator.getCreateRole();

        User user = new User();

        if(role.equals("ADMINISTRATOR")) {
            user = new User(id, name, username, password, Role.ADMINISTRATOR);
        }
        else if(role.equals("MANAGER")) {
            user = new User(id, name, username, password, Role.MANAGER);
        }
        else {
            user = new User(id, name, username, password, Role.EMPLOYEE);
        }

        dbContextUser.insert(user);
    }
}
