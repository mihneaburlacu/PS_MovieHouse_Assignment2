package ViewModel;

import Model.DBContextUser;
import Model.User;

import javax.swing.table.DefaultTableModel;

public class ReadUserCommand implements ICommand{
    private VMAdministrator vmAdministrator;

    public ReadUserCommand(){super();}

    public ReadUserCommand(VMAdministrator vmAdministrator) {
        this.vmAdministrator = vmAdministrator;
    }

    public DefaultTableModel returnTable(User user) {
        String[] columns = new String[]{"ID", "nume", "username", "parola", "ROL"};
        String[][] data = new String[1][5];

        data[0][0] = user.getID() + "";
        data[0][1] = user.getName();
        data[0][2] = user.getUsername();
        data[0][3] = user.getPassword();
        data[0][4] = user.getRole().toString();

        DefaultTableModel defaultTableModel = new DefaultTableModel(data, columns);

        return defaultTableModel;
    }

    @Override
    public void execute() {
        DBContextUser dbContext = new DBContextUser();

        String username = vmAdministrator.getReadUsername();

        if(!username.equals("")) {
            String query = dbContext.createFindQueryByUsername(username);
            User user = dbContext.findUser(query);

            DefaultTableModel defaultTableModel = returnTable(user);
            vmAdministrator.setReadTable(defaultTableModel);

        }
        else {
            String id = vmAdministrator.getReadID();

            if(!id.equals("")) {
                String query = dbContext.createFindQueryByID(Integer.parseInt(id));
                User user = dbContext.findUser(query);

                DefaultTableModel defaultTableModel = returnTable(user);
                vmAdministrator.setReadTable(defaultTableModel);
            }
        }
    }
}
