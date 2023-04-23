package ViewModel;

import Model.DBContextMovie;
import Model.DBContextUser;
import Model.Movie;
import Model.User;

import javax.swing.table.DefaultTableModel;

public class ReadMovieCommand implements ICommand{
    private VMEmployee vmEmployee;

    public ReadMovieCommand() {super();}

    public ReadMovieCommand(VMEmployee vmEmployee) {
        this.vmEmployee = vmEmployee;
    }

    public DefaultTableModel returnTable(Movie movie) {
        String[] columns = new String[]{"ID", "name", "type", "category", "year"};
        String[][] data = new String[1][5];

        data[0][0] = movie.getID() + "";
        data[0][1] = movie.getName();
        data[0][2] = movie.getType().toString();
        data[0][3] = movie.getCategory();
        data[0][4] = movie.getYear() + "";

        DefaultTableModel defaultTableModel = new DefaultTableModel(data, columns);

        return defaultTableModel;
    }

    @Override
    public void execute() {
        DBContextMovie dbContext = new DBContextMovie();

        String name = vmEmployee.getReadName();

        if(!name.equals("")) {
            String query = dbContext.createFindQueryByName(name);
            Movie movie = dbContext.findMovie(query);

            DefaultTableModel defaultTableModel = returnTable(movie);
            vmEmployee.setReadTable(defaultTableModel);

        }
        else {
            String id = vmEmployee.getReadID();

            if(!id.equals("")) {
                String query = dbContext.createFindQueryByID(Integer.parseInt(id));
                Movie movie = dbContext.findMovie(query);

                DefaultTableModel defaultTableModel = returnTable(movie);
                vmEmployee.setReadTable(defaultTableModel);
            }
        }
    }
}
