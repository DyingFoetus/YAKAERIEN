
package yakaerien.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.List;
import yakaerien.dao.DAOFactory;
import yakaerien.javabeans.Plane;

public class SearchPlaneResultAction extends ActionSupport
{
    private String immat;
    private Date date;
    private String type_avion;
    private List<Plane> plist;

    @Override
    public String execute() throws Exception 
    {
        if (immat.equals(""))
            immat = null;
        if (type_avion.equals(""))
            type_avion = null;
        this.plist = DAOFactory.getInstance().getPlaneDAO().search(this.immat, this.date, this.type_avion);
        
        return SUCCESS;
    }

    public Date getDate() 
    {
        return date;
    }

    public void setDate(Date date) 
    {
        this.date = date;
    }

    public String getImmat() 
    {
        return immat;
    }

    public void setImmat(String immat) 
    {
        this.immat = immat;
    }

    public List<Plane> getPlist() 
    {
        return plist;
    }

    public void setPlist(List<Plane> plist) 
    {
        this.plist = plist;
    }

    public String getType_avion() 
    {
        return type_avion;
    }

    public void setType_avion(String type_avion) 
    {
        this.type_avion = type_avion;
    }
    
    
}
