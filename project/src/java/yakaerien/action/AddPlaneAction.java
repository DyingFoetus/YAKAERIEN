/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakaerien.action;

import com.opensymphony.xwork2.ActionSupport;
import yakaerien.dao.DAOFactory;
import yakaerien.javabeans.Category;
import yakaerien.javabeans.Company;
import yakaerien.javabeans.Plane;

/**
 *
 * @author rack
 */
public class AddPlaneAction extends ActionSupport {
    
    
    private static final long serialVersionUID = 4L;
    public String immatriculation;
    public Integer nbmax;
    public String date;
    public String compagnie;
    public String plane_type;
    public String plane_state;

    public String getCompagnie() {
        return compagnie;
    }

    public String getDate() {
        return date;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public Integer getNbmax() {
        return nbmax;
    }

    public String getPlane_state() {
        return plane_state;
    }

    public String getPlane_type() {
        return plane_type;
    }

    public void setCompagnie(String compagnie) {
        this.compagnie = compagnie;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public void setNbmax(Integer nbmax) {
        this.nbmax = nbmax;
    }

    public void setPlane_state(String plane_state) {
        this.plane_state = plane_state;
    }

    public void setPlane_type(String plane_type) {
        this.plane_type = plane_type;
    }
    
    @Override
    public String execute() throws Exception {
        
        Company c = new Company(compagnie);
        Category ca = new Category(plane_type);
        
        Integer idComp = DAOFactory.getInstance().getCompanyDAO().save(c);
        Integer idCat = DAOFactory.getInstance().getCategoryDAO().save(ca);
        
        
        DAOFactory.getInstance().getPlaneDAO().save(new Plane(immatriculation, plane_state, "",
                                                    DAOFactory.getInstance().getCompanyDAO().get(idComp),
                                                    DAOFactory.getInstance().getCategoryDAO().get(idCat)));
        return SUCCESS;
    }
}
