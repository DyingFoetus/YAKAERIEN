
package yakaerien.dao;

import java.util.List;
import yakaerien.javabeans.Landing;

public interface LandingDAO 
{
    public List<Landing> list();
    public Landing get(Integer id);
    public Integer save(Landing l);
    public Boolean update(Landing l);
    public Boolean delete(Integer id);
    public List<Landing> planeHistory(String imm);
}
