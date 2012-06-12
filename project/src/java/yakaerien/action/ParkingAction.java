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
import java.util.ArrayList;
import java.util.List;
import yakaerien.dao.DAOFactory;
import yakaerien.javabeans.Parking;

public class ParkingAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private int category_id;
    private boolean parking_empty;
    private List<Parking> p_list;


    @Override
    public String execute() throws Exception {
        this.p_list = DAOFactory.getInstance().getParkingDAO().list();
        return SUCCESS;
    }
    
     public List<Parking> getP_list() {
          return p_list;
     }

     public void setP_list(List<Parking> p_list) {
          this.p_list = p_list;
     }


     public int getCategory_id() {
          return category_id;
     }

     public void setCategory_id(int category_id) {
          this.category_id = category_id;
     }

     public boolean isParking_empty() {
          return parking_empty;
     }

     public void setParking_empty(boolean parking_empty) {
          this.parking_empty = parking_empty;
     }
}
