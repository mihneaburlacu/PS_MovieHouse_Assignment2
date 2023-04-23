package ViewModel;

import Model.DBContextMovie;
import Model.Movie;

import java.io.FileWriter;
import java.util.List;

public class CreateTxtMoviesCommand implements ICommand{
    private VMViewAndFilter vmViewAndFilter;

    public CreateTxtMoviesCommand(){}

    public CreateTxtMoviesCommand(VMViewAndFilter vmViewAndFilter) {
        this.vmViewAndFilter = vmViewAndFilter;
    }

    @Override
    public void execute() {
        DBContextMovie dbContextMovie = new DBContextMovie();
        List<Movie> list = dbContextMovie.findAllMovies(dbContextMovie.createFindAllQuery());

        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("Movies.txt");

            for(Movie movie : list) {
                fileWriter.write(movie.toString() + "\n");
            }

            fileWriter.close();
        }catch (Exception exp) {
            System.out.println("Error while creating .txt file for movies");
        }
    }
}
