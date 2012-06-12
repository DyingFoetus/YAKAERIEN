
package yakaerien.action;

import com.opensymphony.xwork2.ActionSupport;

public class ExempleAction extends ActionSupport
{
    private String myMessage;
    
    @Override
    public String execute() throws Exception
    {
        myMessage = "Voici ma 1ere vue struts.";
        return SUCCESS;
    }
    
    public String getMyMessage()
    {
        return myMessage;
    }
}
