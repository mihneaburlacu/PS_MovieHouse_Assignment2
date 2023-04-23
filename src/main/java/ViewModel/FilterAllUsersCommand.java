package ViewModel;

import Model.DBContextUser;
import Model.User;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class FilterAllUsersCommand implements ICommand{
    private VMAdministrator vmAdministrator;

    public FilterAllUsersCommand(){super();}

    public FilterAllUsersCommand(VMAdministrator vmAdministrator) {
        this.vmAdministrator = vmAdministrator;
    }

    @Override
    public void execute() {
        DBContextUser dbContextUser = new DBContextUser();

        String role = vmAdministrator.getRoleFilter();

        String[] columns = new String[]{"ID", "Name", "Username", "Password", "ROLE"};
        int rowIndex = 1;
        List<User> users = dbContextUser.findUsersByRole(role);
        int noRows = users.size();
        String [][] data = new String[noRows + 1][5];

        data[0][0] = "ID";
        data[0][1] = "NAME";
        data[0][2] = "USERNAME";
        data[0][3] = "PASSWORD";
        data[0][4] = "ROLE";

        for (User utilizator: users)
        {
            data[rowIndex][0] = utilizator.getID() + "";
            data[rowIndex][1] = utilizator.getName();
            data[rowIndex][2] = utilizator.getUsername();
            data[rowIndex][3] = utilizator.getPassword();
            data[rowIndex][4] = utilizator.getRole().toString();

            rowIndex++;
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, columns);
        vmAdministrator.setTable(defaultTableModel);
    }
}
