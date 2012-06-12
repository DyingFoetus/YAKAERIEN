
package yakaerien.javabeans;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name="landingplatform")
public class LandingPlatform implements Serializable
{
    private int id;
    private int lplat_number;
    private Set<Landing> landings;
    
    public LandingPlatform()
    {
    }
    
    public LandingPlatform(int number)
    {
        this.lplat_number = number;
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

    public int getLplat_number() 
    {
        return lplat_number;
    }

    public void setLplat_number(int lplat_number) 
    {
        this.lplat_number = lplat_number;
    }
    
}
