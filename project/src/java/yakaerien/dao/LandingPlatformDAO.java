
package yakaerien.dao;

import java.util.List;
import yakaerien.javabeans.LandingPlatform;

public interface LandingPlatformDAO 
{
    public List<LandingPlatform> list();
    public LandingPlatform get(Integer id);
    public Integer save(LandingPlatform lp);
    public Boolean update(LandingPlatform lp);
    public Boolean delete(Integer id);    
}
