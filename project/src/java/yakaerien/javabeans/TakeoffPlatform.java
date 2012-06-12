
package yakaerien.javabeans;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="takeoffplatform")
public class TakeoffPlatform implements Serializable
{
    private int id;
    private int tplat_number;
    private Set<Takeoff> takeoffs;
    
    public TakeoffPlatform()
    {
    }
    
    public TakeoffPlatform(int number)
    {
        this.tplat_number = number;
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
    @Cascade(CascadeType.ALL)
    public Set<Takeoff> getTakeoffs() 
    {
        return takeoffs;
    }

    public void setTakeoffs(Set<Takeoff> takeoffs) 
    {
        this.takeoffs = takeoffs;
    }

    public int getTplat_number() 
    {
        return tplat_number;
    }

    public void setTplat_number(int tplat_number) 
    {
        this.tplat_number = tplat_number;
    }
    
}
