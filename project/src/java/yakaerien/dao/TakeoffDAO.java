
package yakaerien.dao;

import java.util.List;
import yakaerien.javabeans.Takeoff;

public interface TakeoffDAO 
{
    public List<Takeoff> list();
    public Takeoff get(Integer id);
    public Integer save(Takeoff t);
    public Boolean update(Takeoff t);
    public Boolean delete(Integer id);   
    public List<Takeoff> planeHistory(String imm);   
}
