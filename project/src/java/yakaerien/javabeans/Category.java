
package yakaerien.javabeans;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="category")
public class Category implements Serializable
{
    private int id;
    private String cat_name;
    private Set<Plane> planes;
    private Set<Parking> parkings;
    
    public Category()
    {
    }
    
    public Category(String cat_name)
    {
        this.cat_name = cat_name;
    }

    @OneToMany
    @Cascade(CascadeType.ALL)
    public Set<Plane> getPlanes() 
    {
        return planes;
    }

    public void setPlanes(Set<Plane> planes) 
    {
        this.planes = planes;
    }

    public String getCat_name() 
    {
        return cat_name;
    }

    public void setCat_name(String cat_name) 
    {
        this.cat_name = cat_name;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() 
    {
        return id;
    }

    public void setId(int id_category) 
    {
        this.id = id_category;
    }

    @OneToMany
    @Cascade(CascadeType.ALL)
    public Set<Parking> getParkings() 
    {
        return parkings;
    }

    public void setParkings(Set<Parking> parkings) 
    {
        this.parkings = parkings;
    }
    
}
