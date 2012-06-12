
package yakaerien.dao;

import java.util.List;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import yakaerien.javabeans.HibUtil;
import yakaerien.javabeans.ParkPlanning;

public class ParkPlanningDAOImpl implements ParkPlanningDAO
{
    private static final ParkPlanningDAOImpl instance = new ParkPlanningDAOImpl();
    
    private ParkPlanningDAOImpl()
    {
    }
    
    public static ParkPlanningDAO getInstance()
    {
        return instance;
    }
            
    @Override
    public List<ParkPlanning> list() 
    {
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        
        Criteria crit = session.createCriteria(ParkPlanning.class);
        List<ParkPlanning> list = crit.list();
        
        t.commit();
        return list;
    }

    @Override
    public ParkPlanning get(Integer id) 
    {
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        
        Criteria crit = session.createCriteria(ParkPlanning.class);
        crit.add(Restrictions.eq("id", id));
        ParkPlanning c = (ParkPlanning) crit.uniqueResult();
        
        t.commit();
        return c;        
    }

    @Override
    public Integer save(ParkPlanning pp) 
    {
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        
        Integer id = (Integer) session.save(pp);
        
        t.commit();
        return id;        
    }

    @Override
    public Boolean update(ParkPlanning pp) 
    {
        try
        {
            Session session = HibUtil.getSessionFactory().getCurrentSession();
            Transaction t = session.beginTransaction();
            
            session.update(pp);
            
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
            
            String req = "delete from ParkPlanning where id=:id";
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
