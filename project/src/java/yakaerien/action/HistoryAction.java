
package yakaerien.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import yakaerien.dao.DAOFactory;
import yakaerien.javabeans.Landing;
import yakaerien.javabeans.Plane;
import yakaerien.javabeans.Takeoff;

public class HistoryAction extends ActionSupport
{
    private String imm;
    private Plane plane;
    private List<Landing> llist;
    private List<Takeoff> tlist;

    @Override
    public String execute() throws Exception 
    {
        plane = DAOFactory.getInstance().getPlaneDAO().get(imm);
        llist = DAOFactory.getInstance().getLandingDAO().planeHistory(imm);
        tlist = DAOFactory.getInstance().getTakeoffDAO().planeHistory(imm);
        return SUCCESS;
    }

    public String getImm() 
    {
        return imm;
    }

    public void setImm(String imm) 
    {
        this.imm = imm;
    }

    public Plane getPlane() 
    {
        return plane;
    }

    public void setPlane(Plane plane) 
    {
        this.plane = plane;
    }

    public List<Landing> getLlist() 
    {
        return llist;
    }

    public void setLlist(List<Landing> llist) 
    {
        this.llist = llist;
    }

    public List<Takeoff> getTlist() 
    {
        return tlist;
    }

    public void setTlist(List<Takeoff> tlist) 
    {
        this.tlist = tlist;
    }
    
}
