package ViewModel;

import Model.DBContextMovie;
import Model.DBContextUser;
import Model.Movie;

public class UpdateMovieCommand implements  ICommand{
    private VMEmployee vmEmployee;

    public UpdateMovieCommand() {}

    public UpdateMovieCommand(VMEmployee vmEmployee) {
        this.vmEmployee = vmEmployee;
    }

    @Override
    public void execute() {
        DBContextMovie dbContextMovie = new DBContextMovie();

        String name = vmEmployee.getUpdateName();
        String type = vmEmployee.getUpdateType();
        String category = vmEmployee.getUpdateCategory();
        String year = vmEmployee.getUpdateYear();

        int id = Integer.parseInt(vmEmployee.getUpdateID());

        dbContextMovie.updateMovie(id, name, type, category, Integer.parseInt(year));
    }
}
