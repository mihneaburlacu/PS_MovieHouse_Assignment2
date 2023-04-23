package ViewModel;

import Model.DBContextMovie;
import Model.Enums.Type;
import Model.Movie;

public class CreateMovieCommand implements ICommand{
    private VMEmployee vmEmployee;

    public CreateMovieCommand() {super();}

    public CreateMovieCommand(VMEmployee vmEmployee) {
        this.vmEmployee = vmEmployee;
    }

    @Override
    public void execute() {
        DBContextMovie dbContextMovie = new DBContextMovie();

        int id = Integer.parseInt(vmEmployee.getCreateID());
        String name = vmEmployee.getCreateName();
        String type = vmEmployee.getCreateType();
        String category = vmEmployee.getCreateCategory();
        int year = Integer.parseInt(vmEmployee.getCreateYear());
        int id_creator = 10;

        Movie movie = new Movie();

        if(type.equalsIgnoreCase("ARTISTIC")) {
            movie = new Movie(id, name, Type.ARTISTIC, category, year, id_creator);
        }
        else {
            movie = new Movie(id, name, Type.SERIES, category, year, id_creator);
        }

        dbContextMovie.insert(movie);
    }
}
