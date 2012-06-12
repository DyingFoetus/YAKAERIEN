
package yakaerien.dao;

import java.util.List;
import yakaerien.javabeans.Controller;

public interface ControllerDAO 
{
    public List<Controller> list();
    public Controller get(Integer id);
    public Integer save(Controller c);
    public Boolean update(Controller c);
    public Boolean delete(Integer id);    
}
