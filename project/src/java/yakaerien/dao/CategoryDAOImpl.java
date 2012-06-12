
package yakaerien.dao;

import java.util.List;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import yakaerien.javabeans.Category;
import yakaerien.javabeans.HibUtil;

public class CategoryDAOImpl implements CategoryDAO
{
    private static final CategoryDAOImpl instance = new CategoryDAOImpl();
    
    private CategoryDAOImpl()
    {
    }
    
    public static CategoryDAO getInstance()
    {
        return instance;
    }
    
    @Override
    public List<Category> list() 
    {
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        
        Criteria crit = session.createCriteria(Category.class);
        List<Category> list = crit.list();
        
        t.commit();
        return list;
    }

    @Override
    public Category get(Integer id) 
    {
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        
        Criteria crit = session.createCriteria(Category.class);
        crit.add(Restrictions.eq("id", id));
        Category c = (Category) crit.uniqueResult();
        
        t.commit();
        return c;
    }

    @Override
    public Integer save(Category category) 
    {
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        
        Criteria crit = session.createCriteria(Category.class);
        crit.add(Restrictions.eq("cat_name", category.getCat_name()));
        Integer id = -1;
        if (crit.list().isEmpty())
            id = (Integer) session.save(category);
        else
            id = ((Category) crit.uniqueResult()).getId();
        
        t.commit();
        return id;
    }

    @Override
    public Boolean update(Category category) 
    {
        try
        {
            Session session = HibUtil.getSessionFactory().getCurrentSession();
            Transaction t = session.beginTransaction();
            
            session.update(category);
            
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
            
            String req = "delete from Category where id=:id";
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
