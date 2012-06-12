
package yakaerien.dao;

import java.util.List;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import yakaerien.javabeans.HibUtil;
import yakaerien.javabeans.LandingPlatform;

public class LandingPlatformDAOImpl implements LandingPlatformDAO
{
    private static final LandingPlatformDAOImpl instance = new LandingPlatformDAOImpl();
    
    private LandingPlatformDAOImpl()
    {
    }
    
    public static LandingPlatformDAO getInstance()
    {
        return instance;
    }
    
    @Override
    public List<LandingPlatform> list() 
    {
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        
        Criteria crit = session.createCriteria(LandingPlatform.class);
        List<LandingPlatform> list = crit.list();
        
        t.commit();
        return list;        
    }

    @Override
    public LandingPlatform get(Integer id) 
    {
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        
        Criteria crit = session.createCriteria(LandingPlatform.class);
        crit.add(Restrictions.eq("id", id));
        LandingPlatform c = (LandingPlatform) crit.uniqueResult();
        
        t.commit();
        return c;          
    }

    @Override
    public Integer save(LandingPlatform lp) 
    {
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        
        Criteria crit = session.createCriteria(LandingPlatform.class);
        crit.add(Restrictions.eq("lplat_number",
                                 lp.getLplat_number()));
        Integer id = -1;
        if (crit.list().isEmpty())
            id = (Integer) session.save(lp);
        else
            id = ((LandingPlatform) crit.uniqueResult()).getId();
        
        t.commit();
        return id;        
    }

    @Override
    public Boolean update(LandingPlatform lp) 
    {
        try
        {
            Session session = HibUtil.getSessionFactory().getCurrentSession();
            Transaction t = session.beginTransaction();
            
            session.update(lp);
            
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
            
            String req = "delete from LandingPlatform where id=:id";
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
