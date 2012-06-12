
package yakaerien.javabeans;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name="controller")
public class Controller implements Serializable
{
    private int id;
    private String cont_firstname;
    private String cont_lastname;
    private String cont_address;
    private Date cont_birthdate;
    private int cont_numsecu;
    private Set<Landing> landings;
    private Set<Takeoff> takeoffs;
    private Set<ParkPlanning> parkplannings;
    
    public Controller()
    {
    }

    public Controller(String cont_firstname, String cont_lastname, String cont_address,
                      Date cont_birthdate, int cont_numsecu) 
    {
        this.cont_firstname = cont_firstname;
        this.cont_lastname = cont_lastname;
        this.cont_address = cont_address;
        this.cont_birthdate = cont_birthdate;
        this.cont_numsecu = cont_numsecu;
    }

    public String getCont_address() 
    {
        return cont_address;
    }

    public void setCont_address(String cont_address) 
    {
        this.cont_address = cont_address;
    }

    @Temporal(TemporalType.DATE)
    public Date getCont_birthdate() 
    {
        return cont_birthdate;
    }

    public void setCont_birthdate(Date cont_birthdate) 
    {
        this.cont_birthdate = cont_birthdate;
    }

    public String getCont_firstname() 
    {
        return cont_firstname;
    }

    public void setCont_firstname(String cont_firstname) 
    {
        this.cont_firstname = cont_firstname;
    }

    public String getCont_lastname() 
    {
        return cont_lastname;
    }

    public void setCont_lastname(String cont_lastname) 
    {
        this.cont_lastname = cont_lastname;
    }

    public int getCont_numsecu() 
    {
        return cont_numsecu;
    }

    public void setCont_numsecu(int cont_numsecu) 
    {
        this.cont_numsecu = cont_numsecu;
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

    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    public Set<Landing> getLandings() 
    {
        return landings;
    }

    public void setLandings(Set<Landing> landings) 
    {
        this.landings = landings;
    }

    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    public Set<ParkPlanning> getParkplannings() 
    {
        return parkplannings;
    }

    public void setParkplannings(Set<ParkPlanning> parkplannings) 
    {
        this.parkplannings = parkplannings;
    }

    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    public Set<Takeoff> getTakeoffs() 
    {
        return takeoffs;
    }

    public void setTakeoffs(Set<Takeoff> takeoffs) 
    {
        this.takeoffs = takeoffs;
    }
    
}
