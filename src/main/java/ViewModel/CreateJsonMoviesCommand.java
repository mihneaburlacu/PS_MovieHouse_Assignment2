package ViewModel;

import Model.DBContextMovie;
import Model.Movie;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.util.List;

public class CreateJsonMoviesCommand implements  ICommand{
    private VMViewAndFilter vmViewAndFilter;

    public CreateJsonMoviesCommand(){}

    public CreateJsonMoviesCommand(VMViewAndFilter vmViewAndFilter) {
        this.vmViewAndFilter = vmViewAndFilter;
    }

    @Override
    public void execute() {
        DBContextMovie dbContextMovie = new DBContextMovie();
        List<Movie> movies = dbContextMovie.findAllMovies(dbContextMovie.createFindAllQuery());

        try{
            FileWriter fileWriter = new FileWriter("Movies.json");
            Gson gson = new Gson();

            for(Movie movie : movies) {
                gson.toJson(movie, fileWriter);
                fileWriter.append("\n");
            }

            fileWriter.close();
        }catch(Exception exp) {
            System.out.println("Error while creating .json file");
        }
    }
}
