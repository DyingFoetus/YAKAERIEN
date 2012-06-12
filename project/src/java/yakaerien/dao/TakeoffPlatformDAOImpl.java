
package yakaerien.dao;

import java.util.List;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import yakaerien.javabeans.HibUtil;
import yakaerien.javabeans.TakeoffPlatform;

public class TakeoffPlatformDAOImpl implements TakeoffPlatformDAO
{
    private static final TakeoffPlatformDAOImpl instance  = new TakeoffPlatformDAOImpl();
    
    private TakeoffPlatformDAOImpl()
    {
    }
    
    public static TakeoffPlatformDAO getInstance()
    {
        return instance;
    }
    
    @Override
    public List<TakeoffPlatform> list() 
    {
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        
        Criteria crit = session.createCriteria(TakeoffPlatform.class);
        List<TakeoffPlatform> list = crit.list();
        
        t.commit();
        return list;
    }

    @Override
    public TakeoffPlatform get(Integer id) 
    {
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        
        Criteria crit = session.createCriteria(TakeoffPlatform.class);
        crit.add(Restrictions.eq("id", id));
        TakeoffPlatform c = (TakeoffPlatform) crit.uniqueResult();
        
        t.commit();
        return c; 
    }

    @Override
    public Integer save(TakeoffPlatform tp) 
    {
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        
        Criteria crit = session.createCriteria(TakeoffPlatform.class);
        crit.add(Restrictions.eq("tplat_number", tp.getTplat_number()));
        Integer id = -1;
        if (crit.list().isEmpty())
            id = (Integer) session.save(tp);
        else
            id = ((TakeoffPlatform) crit.uniqueResult()).getId();
        
        t.commit();
        return id;
    }

    @Override
    public Boolean update(TakeoffPlatform tp) 
    {
        try
        {
            Session session = HibUtil.getSessionFactory().getCurrentSession();
            Transaction t = session.beginTransaction();
            
            session.update(tp);
            
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
            
            String req = "delete from TakeoffPlatform where id=:id";
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
