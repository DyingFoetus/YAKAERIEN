
package yakaerien.dao;

import java.util.List;
import yakaerien.javabeans.ParkPlanning;

public interface ParkPlanningDAO 
{
    public List<ParkPlanning> list();
    public ParkPlanning get(Integer id);
    public Integer save(ParkPlanning pp);
    public Boolean update(ParkPlanning pp);
    public Boolean delete(Integer id);    
}
