package ViewModel;

import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;

public class VMLogin {
    private Property<String> usernameTextField;
    private Property<String> passwordTextField;
    public ICommand loginCommand;

    public VMLogin() {
        usernameTextField = PropertyFactory.createProperty("username", this, String.class);
        passwordTextField = PropertyFactory.createProperty("password", this, String.class);
        this.loginCommand = new LoginCommand(this);
    }

    public String getUserTextField() {
        return usernameTextField.get();
    }

    public void setUserTextField(String userTextField) {
        this.usernameTextField.set(userTextField);
    }

    public String getPasswordTextField() {
        return passwordTextField.get();
    }

    public void setPasswordTextField(String passwordTextField) {
        this.passwordTextField.set(passwordTextField);
    }

    public ICommand getLoginCommand() {
        return loginCommand;
    }

    public void setLoginCommand(ICommand loginCommand) {
        this.loginCommand = loginCommand;
    }
}
