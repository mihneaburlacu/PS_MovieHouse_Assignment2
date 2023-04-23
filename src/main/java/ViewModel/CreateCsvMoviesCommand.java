package ViewModel;

import Model.DBContextMovie;
import Model.Movie;

import java.io.FileWriter;
import java.util.List;

public class CreateCsvMoviesCommand implements ICommand{
    private VMViewAndFilter vmViewAndFilter;

    public CreateCsvMoviesCommand(){}

    public CreateCsvMoviesCommand(VMViewAndFilter vmViewAndFilter) {
        this.vmViewAndFilter = vmViewAndFilter;
    }

    @Override
    public void execute() {
        DBContextMovie dbContextMovie = new DBContextMovie();
        List<Movie> list = dbContextMovie.findAllMovies(dbContextMovie.createFindAllQuery());

        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("Movies.csv");

            fileWriter.append("id,name,type,category,year,id_creator\n");

            for(Movie movie : list) {
                fileWriter.append(movie.getID() + ",");
                fileWriter.append(movie.getName() + ",");
                fileWriter.append(movie.getType() + ",");
                fileWriter.append(movie.getCategory() + ",");
                fileWriter.append(movie.getYear() + ",");
                fileWriter.append(movie.getIdCreator() + "\n");
            }

            fileWriter.close();
        }catch (Exception exp) {
            System.out.println("Error while creating .csv file for movies");
        }
    }
}
