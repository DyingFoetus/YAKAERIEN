
package yakaerien.dao;

import java.util.Date;
import java.util.List;
import yakaerien.javabeans.Plane;

public interface PlaneDAO 
{
    public List<Plane> list();
    public Plane get(Integer id);
    public Plane get(String imm);
    public Integer save(Plane plane);
    public Boolean update(Plane plane);
    public Boolean delete(Integer id);
    public List<Plane> search(String imm, Date date, String type);
}
