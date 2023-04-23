package ViewModel;

import Model.DBContextMovie;
import Model.DBContextUser;

public class DeleteMovieCommand implements ICommand{
    private VMEmployee vmEmployee;

    public DeleteMovieCommand() {super();}

    public DeleteMovieCommand(VMEmployee vmEmployee) {
        this.vmEmployee = vmEmployee;
    }

    public void deleteMovieByID(int id, DBContextMovie dbContext) {
        String query = dbContext.createDeleteQueryByID(id);
        dbContext.deleteMovie(query);
    }

    public void deleteMovieByName(String name, DBContextMovie dbContext) {
        String query = dbContext.createDeleteQueryByName(name);
        dbContext.deleteMovie(query);
    }

    @Override
    public void execute() {
        DBContextMovie dbContextMovie = new DBContextMovie();
        String name = vmEmployee.getDeleteName();

        if(!name.equals("")) {
            deleteMovieByName(name, dbContextMovie);
        }
        else {
            String id = vmEmployee.getDeleteID();

            if (!id.equals("")) {
                deleteMovieByID(Integer.parseInt(id), dbContextMovie);
            }
        }
    }
}
