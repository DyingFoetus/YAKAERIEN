
package yakaerien.javabeans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="takeoff")
public class Takeoff implements Serializable
{
    private int id;
    private Controller controller;
    private Plane plane;
    private TakeoffPlatform takeoffplatform;
    private Date takeoff_date;
    private int takeoff_passengers;

    public Takeoff() 
    {
    }

    public Takeoff(Controller controller, Plane plane, TakeoffPlatform takeoffplatform,
                   Date takeoff_date, int takeoff_passengers) 
    {
        this.controller = controller;
        this.plane = plane;
        this.takeoffplatform = takeoffplatform;
        this.takeoff_date = takeoff_date;
        this.takeoff_passengers = takeoff_passengers;
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
    public Plane getPlane() 
    {
        return plane;
    }

    public void setPlane(Plane plane) 
    {
        this.plane = plane;
    }

    @Temporal(TemporalType.DATE)
    public Date getTakeoff_date() 
    {
        return takeoff_date;
    }

    public void setTakeoff_date(Date takeoff_date) 
    {
        this.takeoff_date = takeoff_date;
    }

    public int getTakeoff_passengers() 
    {
        return takeoff_passengers;
    }

    public void setTakeoff_passengers(int takeoff_passengers) 
    {
        this.takeoff_passengers = takeoff_passengers;
    }

    @ManyToOne
    @Cascade(CascadeType.ALL)
    public TakeoffPlatform getTakeoffplatform() 
    {
        return takeoffplatform;
    }

    public void setTakeoffplatform(TakeoffPlatform takeoffplatform) 
    {
        this.takeoffplatform = takeoffplatform;
    }
    
}
