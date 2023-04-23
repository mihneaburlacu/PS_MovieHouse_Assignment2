package ViewModel;

import Model.DBContextUser;

public class DeleteUserCommand implements ICommand{
    private VMAdministrator vmAdministrator;

    public DeleteUserCommand() {super();}

    public DeleteUserCommand(VMAdministrator vmAdministrator) {
        this.vmAdministrator = vmAdministrator;
    }

    public void deleteUserByID(int id, DBContextUser dbContext) {
        String query = dbContext.createDeleteQueryByID(id);
        dbContext.deleteUser(query);
    }

    public void deleteUserByUsername(String username, DBContextUser dbContext) {
        String query = dbContext.createDeleteQueryByUsername(username);
        dbContext.deleteUser(query);
    }

    @Override
    public void execute() {
        DBContextUser dbContextUser = new DBContextUser();
        String username = vmAdministrator.getDeleteUsername();

        if(!username.equals("")) {
            deleteUserByUsername(username, dbContextUser);
        }
        else {
            String id = vmAdministrator.getDeleteID();

            if (!id.equals("")) {
                deleteUserByID(Integer.parseInt(id), dbContextUser);
            }
        }
    }
}
