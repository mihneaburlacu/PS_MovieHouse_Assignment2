package ViewModel;

import Model.DBContextMovie;
import Model.DBContextUser;
import Model.Movie;
import Model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class FilterAllMoviesCommand implements  ICommand{
    private VMViewAndFilter vmViewAndFilter;

    public FilterAllMoviesCommand() {}

    public FilterAllMoviesCommand(VMViewAndFilter vmViewAndFilter) {
        this.vmViewAndFilter = vmViewAndFilter;
    }

    @Override
    public void execute() {
        DBContextMovie dbContextMovie = new DBContextMovie();

        DefaultComboBoxModel<String> comboBox = vmViewAndFilter.getFilterComboBox();
        String comboBoxCurr = comboBox.getSelectedItem().toString();
        String textField = vmViewAndFilter.getFilterTextField();

        String[] columns = new String[]{"ID", "Name", "Type", "Category", "Year", "ID_Creator"};
        int rowIndex = 1;

        List<Movie> movies;

        if(comboBoxCurr.equalsIgnoreCase("TYPE")) {
            movies = dbContextMovie.findAllMovies(dbContextMovie.createFindByTypeQuery(textField));
        }
        else if(comboBoxCurr.equalsIgnoreCase("CATEGORY")) {
            movies = dbContextMovie.findAllMovies(dbContextMovie.createFindByCategoryQuery(textField));
        }
        else {
            movies = dbContextMovie.findAllMovies(dbContextMovie.createFindByYearQuery(Integer.parseInt(textField)));
        }

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
