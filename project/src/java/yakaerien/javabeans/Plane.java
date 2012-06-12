
package yakaerien.javabeans;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="plane")
public class Plane implements Serializable
{
    private int id;
    private String plane_immatriculation;
    private String plane_status;
    private String plane_current_op;
    private Company company;
    private Category category;
    
    public Plane()
    {
    }
    
    public Plane(String immatriculation, String status, String current_op,
                 Company company, Category category)
    {
        this.plane_immatriculation = immatriculation;
        this.plane_status = status;
        this.plane_current_op = current_op;
        this.company = company;
        this.category = category;
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

    @ManyToOne
    @Cascade(CascadeType.ALL)
    public Company getCompany() 
    {
        return company;
    }

    public void setCompany(Company company) 
    {
        this.company = company;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() 
    {
        return id;
    }

    public void setId(int id_plane) 
    {
        this.id = id_plane;
    }

    public String getPlane_current_op() 
    {
        return plane_current_op;
    }

    public void setPlane_current_op(String plane_current_op) 
    {
        this.plane_current_op = plane_current_op;
    }

    public String getPlane_immatriculation() 
    {
        return plane_immatriculation;
    }

    public void setPlane_immatriculation(String plane_immatriculation) 
    {
        this.plane_immatriculation = plane_immatriculation;
    }

    public String getPlane_status() 
    {
        return plane_status;
    }

    public void setPlane_status(String plane_status) 
    {
        this.plane_status = plane_status;
    }
    
}
