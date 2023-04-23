package ViewModel;

import Model.User;
import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VMEmployee {
    private Property<String> createIDTextField;
    private Property<String> createNameTextField;
    private Property<String>createTypeTextField;
    private Property<String> createCategoryTextField;
    private Property<String> createYearTextField;
    public CreateMovieCommand createMovieCommand;

    private Property<String> nameReadTextField;
    private Property<String> idReadTextField;
    private Property<DefaultTableModel> readTable;
    public ReadMovieCommand readMovieCommand;

    private Property<String> nameDeleteTextField;
    private Property<String> idDeleteTextField;
    public DeleteMovieCommand deleteMovieCommand;

    private Property<String> updateIDTextField;
    private Property<String> updateNameTextField;
    private Property<String> updateTypeTextField;
    private Property<String> updateCategoryTextField;
    private Property<String> updateYearTextField;
    public UpdateMovieCommand updateMovieCommand;

    public VMEmployee() {
        createIDTextField = PropertyFactory.createProperty("createIDTextField", this, String.class);
        createNameTextField = PropertyFactory.createProperty("createNameTextField", this, String.class);
        createTypeTextField = PropertyFactory.createProperty("createTypeTextField", this, String.class);
        createCategoryTextField = PropertyFactory.createProperty("createCategoryTextField", this, String.class);
        createYearTextField = PropertyFactory.createProperty("createYearTextField", this, String.class);
        this.createMovieCommand = new CreateMovieCommand(this);

        idReadTextField = PropertyFactory.createProperty("idReadTextField", this, String.class);
        nameReadTextField = PropertyFactory.createProperty("nameReadTextField", this, String.class);
        readTable = PropertyFactory.createProperty("readTable", this, new DefaultTableModel());
        this.readMovieCommand = new ReadMovieCommand(this);

        nameDeleteTextField = PropertyFactory.createProperty("nameDeleteTextField", this, String.class);
        idDeleteTextField = PropertyFactory.createProperty("idDeleteTextField", this, String.class);
        this.deleteMovieCommand = new DeleteMovieCommand(this);

        updateIDTextField = PropertyFactory.createProperty("updateIDTextField", this, String.class);
        updateNameTextField = PropertyFactory.createProperty("updateNameTextField", this, String.class);;
        updateTypeTextField = PropertyFactory.createProperty("updateTypeTextField", this, String.class);;
        updateCategoryTextField = PropertyFactory.createProperty("updateCategoryTextField", this, String.class);;
        updateYearTextField = PropertyFactory.createProperty("updateYearTextField", this, String.class);;
        updateMovieCommand = new UpdateMovieCommand(this);
    }

    public String getCreateID() {
        return createIDTextField.get();
    }

    public String getCreateName() {
        return createNameTextField.get();
    }

    public String getCreateType() {
        return createTypeTextField.get();
    }

    public String getCreateCategory() {
        return createCategoryTextField.get();
    }

    public String getCreateYear() {return createYearTextField.get();}

    public String getReadID() {return idReadTextField.get();}

    public String getReadName() {return nameReadTextField.get();}

    public DefaultTableModel getReadTable(){
        return readTable.get();
    }

    public void setReadTable(DefaultTableModel defaultTableModel) {
        readTable.set(defaultTableModel);
    }

    public String getDeleteID() {return idDeleteTextField.get();}

    public String getDeleteName() {return nameDeleteTextField.get();}

    public String getUpdateID() {return updateIDTextField.get();}

    public String getUpdateName() {return updateNameTextField.get();}

    public String getUpdateType() {return updateTypeTextField.get();}

    public String getUpdateCategory() {return updateCategoryTextField.get();}

    public String getUpdateYear() {return updateYearTextField.get();}
}
