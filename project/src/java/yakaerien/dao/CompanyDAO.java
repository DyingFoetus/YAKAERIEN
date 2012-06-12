
package yakaerien.dao;

import java.util.List;
import yakaerien.javabeans.Company;

public interface CompanyDAO 
{
    public List<Company> list();
    public Company get(Integer id);
    public Integer save(Company company);
    public Boolean update(Company company);
    public Boolean delete(Integer id);
}
