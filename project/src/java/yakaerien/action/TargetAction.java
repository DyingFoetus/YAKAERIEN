/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakaerien.action;

/**
 *
 * @author rack
 */
import com.opensymphony.xwork2.ActionSupport;

public class TargetAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private String login;
    private String password;
    private boolean logged;

    @Override
    public String execute() throws Exception {
        if (login.equals("Admin") && password.equals("pwd")) {
            setLogged(true);
        } else {
            setLogged(false);
        }
        return SUCCESS;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogged(boolean isLogged) {
        this.logged = isLogged;
    }

    public boolean isLogged() {
        return logged;
    }
}
