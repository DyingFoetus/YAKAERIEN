
package yakaerien.dao;

import java.util.List;
import yakaerien.javabeans.Parking;

public interface ParkingDAO 
{
    public List<Parking> list();
    public Parking get(Integer id);
    public Integer save(Parking p);
    public Boolean update(Parking p);
    public Boolean delete(Integer id);    
}
