
package yakaerien.javabeans;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="parking")
public class Parking implements Serializable
{
    private int id;
    private Category category;
    private Set<ParkPlanning> parkplannings;
    private boolean parking_empty;
    private int parking_number;
    private String parking_name;

    public Parking() 
    {
    }

    public Parking(Category category, int parking_number, String parking_name) 
    {
        this.category = category;
        this.parking_number = parking_number;
        this.parking_name = parking_name;
    }

    @ManyToOne
    @Cascade(CascadeType.ALL)
    public Category getCategory() 
    {
        return category;
    }

    public void setCategory(Category category) 
    {
        this.category = category;
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

    public boolean isParking_empty() 
    {
        return parking_empty;
    }

    public void setParking_empty(boolean parking_empty) 
    {
        this.parking_empty = parking_empty;
    }

    public String getParking_name() 
    {
        return parking_name;
    }

    public void setParking_name(String parking_name) 
    {
        this.parking_name = parking_name;
    }

    public int getParking_number() 
    {
        return parking_number;
    }

    public void setParking_number(int parking_number) 
    {
        this.parking_number = parking_number;
    }

    @OneToMany
    @Cascade(CascadeType.ALL)
    public Set<ParkPlanning> getParkplannings() 
    {
        return parkplannings;
    }

    public void setParkplannings(Set<ParkPlanning> parkplannings) 
    {
        this.parkplannings = parkplannings;
    }
    
}
