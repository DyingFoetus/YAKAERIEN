
package yakaerien.javabeans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name="landing")
public class Landing implements Serializable
{
    private int id;
    private Controller controller;
    private Plane plane;
    private LandingPlatform landingplatform;
    private Date landing_date;
    private int landing_passengers;
    
    public Landing()
    {
    }

    public Landing(Controller controller, Plane plane, LandingPlatform landingplatform,
                   Date landing_date, int landing_passengers) 
    {
        this.controller = controller;
        this.plane = plane;
        this.landingplatform = landingplatform;
        this.landing_date = landing_date;
        this.landing_passengers = landing_passengers;
    }

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
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

    @Temporal(TemporalType.DATE)
    public Date getLanding_date() 
    {
        return landing_date;
    }

    public void setLanding_date(Date landing_date) 
    {
        this.landing_date = landing_date;
    }

    public int getLanding_passengers() 
    {
        return landing_passengers;
    }

    public void setLanding_passengers(int landing_passengers) 
    {
        this.landing_passengers = landing_passengers;
    }

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    public LandingPlatform getLandingplatform() 
    {
        return landingplatform;
    }

    public void setLandingplatform(LandingPlatform landingplatform) 
    {
        this.landingplatform = landingplatform;
    }

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    public Plane getPlane() 
    {
        return plane;
    }

    public void setPlane(Plane plane) 
    {
        this.plane = plane;
    }
    
}
