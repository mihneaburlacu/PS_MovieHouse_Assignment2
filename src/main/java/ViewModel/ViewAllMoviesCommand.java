package ViewModel;

import Model.DBContextMovie;
import Model.DBContextUser;
import Model.Movie;
import Model.User;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ViewAllMoviesCommand implements ICommand{
    private VMViewAndFilter vmViewAndFilter;

    public ViewAllMoviesCommand() {}

    public ViewAllMoviesCommand(VMViewAndFilter vmViewAndFilter) {
        this.vmViewAndFilter = vmViewAndFilter;
    }

    @Override
    public void execute() {
        DBContextMovie dbContextMovie = new DBContextMovie();

        String[] columns = new String[]{"ID", "Name", "Type", "Category", "Year", "ID_Creator"};
        int rowIndex = 1;
        List<Movie> movies = dbContextMovie.findAllMovies(dbContextMovie.createFindAllQuery());
        int noRows = movies.size();
        String [][] data = new String[noRows + 1][6];

        data[0][0] = "ID";
        data[0][1] = "NAME";
        data[0][2] = "TYPE";
        data[0][3] = "CATEGORY";
        data[0][4] = "YEAR";
        data[0][5] = "ID_CREATOR";

        for (Movie movie: movies)
        {
            data[rowIndex][0] = movie.getID() + "";
            data[rowIndex][1] = movie.getName();
            data[rowIndex][2] = movie.getType().toString();
            data[rowIndex][3] = movie.getCategory();
            data[rowIndex][4] = movie.getYear() + "";
            data[rowIndex][5] = movie.getIdCreator() + "";

            rowIndex++;
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, columns);
        vmViewAndFilter.setTable(defaultTableModel);
    }
}
