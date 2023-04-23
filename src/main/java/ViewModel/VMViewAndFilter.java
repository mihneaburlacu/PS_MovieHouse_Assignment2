package ViewModel;

import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VMViewAndFilter {
    private Property<DefaultTableModel> table;
    public ViewAllMoviesCommand viewAllMoviesCommand;
    public CreateTxtMoviesCommand createTxtMoviesCommand;
    public CreateCsvMoviesCommand createCsvMoviesCommand;
    public CreateJsonMoviesCommand createJsonMoviesCommand;
    public FilterAllMoviesCommand filterAllMoviesCommand;
    public CreateXmlMoviesCommand createXmlMoviesCommand;
    private Property<String> filterTextField;
    private Property<DefaultComboBoxModel<String>> filterComboBox;

    public VMViewAndFilter() {
        table = PropertyFactory.createProperty("table", this, new DefaultTableModel());
        this.filterComboBox = PropertyFactory.createProperty("filterComboBox", this, new DefaultComboBoxModel<String>());
        filterTextField = PropertyFactory.createProperty("filterTextField", this, String.class);
        viewAllMoviesCommand = new ViewAllMoviesCommand(this);
        createTxtMoviesCommand = new CreateTxtMoviesCommand(this);
        createCsvMoviesCommand = new CreateCsvMoviesCommand(this);
        createJsonMoviesCommand = new CreateJsonMoviesCommand(this);
        filterAllMoviesCommand = new FilterAllMoviesCommand(this);
        createXmlMoviesCommand = new CreateXmlMoviesCommand(this);
    }

    public DefaultTableModel getTable(){
        return table.get();
    }

    public void setTable(DefaultTableModel defaultTableModel) {
        table.set(defaultTableModel);
    }

    public DefaultComboBoxModel<String> getFilterComboBox() {return filterComboBox.get();}

    public String getFilterTextField() {return filterTextField.get();}
}
