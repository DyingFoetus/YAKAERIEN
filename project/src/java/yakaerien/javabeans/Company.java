
package yakaerien.javabeans;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="company")
public class Company implements Serializable
{
    private int id;
    private String company_name;
    private Set<Plane> planes;
    
    public Company()
    {
    }

    public Company(String company_name)
    {
        this.company_name = company_name;
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
    
    public String getCompany_name() 
    {
        return company_name;
    }

    public void setCompany_name(String company_name) 
    {
        this.company_name = company_name;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() 
    {
        return id;
    }

    public void setId(int id_company) 
    {
        this.id = id_company;
    }
    
}
