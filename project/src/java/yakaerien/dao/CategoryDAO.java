
package yakaerien.dao;

import java.util.List;
import yakaerien.javabeans.Category;

public interface CategoryDAO 
{
    public List<Category> list();
    public Category get(Integer id);
    public Integer save(Category category);
    public Boolean update(Category category);
    public Boolean delete(Integer id);
}
