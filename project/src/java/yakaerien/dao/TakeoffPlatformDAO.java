
package yakaerien.dao;

import java.util.List;
import yakaerien.javabeans.TakeoffPlatform;

public interface TakeoffPlatformDAO 
{
    public List<TakeoffPlatform> list();
    public TakeoffPlatform get(Integer id);
    public Integer save(TakeoffPlatform tp);
    public Boolean update(TakeoffPlatform tp);
    public Boolean delete(Integer id);      
}
