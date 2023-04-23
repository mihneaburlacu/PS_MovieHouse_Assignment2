package ViewModel;

import Model.DBContextUser;

public class UpdateUserCommand implements ICommand{
    private VMAdministrator vmAdministrator;

    public UpdateUserCommand(){super();}

    public UpdateUserCommand(VMAdministrator vmAdministrator) {
        this.vmAdministrator = vmAdministrator;
    }

    @Override
    public void execute() {
        DBContextUser dbContextUser = new DBContextUser();

        String name = vmAdministrator.getUpdateName();
        String username = vmAdministrator.getUpdateUsername();
        String password = vmAdministrator.getUpdatePassword();
        String role = vmAdministrator.getUpdateRole();

        int id = Integer.parseInt(vmAdministrator.getUpdateID());

        dbContextUser.updateUser(id, name, username, password, role);
    }
}
