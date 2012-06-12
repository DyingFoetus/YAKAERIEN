
package yakaerien.dao;

import java.util.List;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import yakaerien.javabeans.Company;
import yakaerien.javabeans.HibUtil;

public class CompanyDAOImpl implements CompanyDAO
{
    private static final CompanyDAOImpl instance = new CompanyDAOImpl();
    
    private CompanyDAOImpl()
    {
    }
    
    public static CompanyDAO getInstance()
    {
        return instance;
    }
    
    @Override
    public List<Company> list() 
    {
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        
        Criteria crit = session.createCriteria(Company.class);
        List<Company> list = crit.list();
        
        t.commit();
        return list;
    }

    @Override
    public Company get(Integer id) 
    {
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        
        Criteria crit = session.createCriteria(Company.class);
        crit.add(Restrictions.eq("id", id));
        Company c = (Company) crit.uniqueResult();
        
        t.commit();
        return c;
    }

    @Override
    public Integer save(Company company) 
    {
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        
        Criteria crit = session.createCriteria(Company.class);
        crit.add(Restrictions.eq("company_name", company.getCompany_name()));
        Integer id = -1;
        if (crit.list().isEmpty())
            id = (Integer) session.save(company);
        else
            id = ((Company) crit.uniqueResult()).getId();
        
        t.commit();
        return id;
    }

    @Override
    public Boolean update(Company company) 
    {
        try
        {
            Session session = HibUtil.getSessionFactory().getCurrentSession();
            Transaction t = session.beginTransaction();
            
            session.update(company);
            
            t.commit();
            return true;
        }
        catch (HibernateException e)
        {
            return false;
        }        
    }

    @Override
    public Boolean delete(Integer id) 
    {
        try
        {
            Session session = HibUtil.getSessionFactory().getCurrentSession();
            Transaction t = session.beginTransaction();
            
            String req = "delete from Company where id=:id";
            Query q = session.createQuery(req);
            q.setInteger("id", id.intValue());
            int rowcount = q.executeUpdate();
            
            t.commit();
            if (rowcount != 0)
                return true;
            return false;
        }
        catch (HibernateException e)
        {
            return false;
        }
    }
    
}
