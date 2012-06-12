
package yakaerien.javabeans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="parkplanning")
public class ParkPlanning implements Serializable
{
    private int id;
    private Plane plane;
    private Parking parking;
    private Controller controller;
    private Date pp_indate;
    private Date pp_outdate;
    private String pp_action;

    public ParkPlanning() 
    {
    }

    public ParkPlanning(Plane plane, Parking parking, Controller controller,
                        Date pp_indate) 
    {
        this.plane = plane;
        this.parking = parking;
        this.controller = controller;
        this.pp_indate = pp_indate;
    }

    @ManyToOne
    @Cascade(CascadeType.ALL)
    public Controller getController() 
    {
        return controller;
    }

    public void setController(Controller controller) 
    {
        this.controller = controller;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    @ManyToOne
    @Cascade(CascadeType.ALL)
    public Parking getParking() 
    {
        return parking;
    }

    public void setParking(Parking parking) 
    {
        this.parking = parking;
    }

    @ManyToOne
    @Cascade(CascadeType.ALL)
    public Plane getPlane() 
    {
        return plane;
    }

    public void setPlane(Plane plane) 
    {
        this.plane = plane;
    }

    public String getPp_action() 
    {
        return pp_action;
    }

    public void setPp_action(String pp_action) 
    {
        this.pp_action = pp_action;
    }

    @Temporal(TemporalType.DATE)
    public Date getPp_indate() 
    {
        return pp_indate;
    }

    public void setPp_indate(Date pp_indate) 
    {
        this.pp_indate = pp_indate;
    }

    @Temporal(TemporalType.DATE)
    public Date getPp_outdate() 
    {
        return pp_outdate;
    }

    public void setPp_outdate(Date pp_outdate) 
    {
        this.pp_outdate = pp_outdate;
    }
    
}
