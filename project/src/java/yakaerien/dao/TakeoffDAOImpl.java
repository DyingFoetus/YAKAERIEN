
package yakaerien.dao;

import java.util.List;
import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import yakaerien.javabeans.HibUtil;
import yakaerien.javabeans.Plane;
import yakaerien.javabeans.Takeoff;

public class TakeoffDAOImpl implements TakeoffDAO
{
    private static final TakeoffDAOImpl instance = new TakeoffDAOImpl();
    
    private TakeoffDAOImpl()
    {
    }
    
    public static TakeoffDAO getInstance()
    {
        return instance;
    }
    
    @Override
    public List<Takeoff> list() 
    {
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        
        Criteria crit = session.createCriteria(Takeoff.class);
        List<Takeoff> list = crit.list();
        
        t.commit();
        return list;
    }

    @Override
    public Takeoff get(Integer id) 
    {
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        
        Criteria crit = session.createCriteria(Takeoff.class);
        crit.add(Restrictions.eq("id", id));
        Takeoff c = (Takeoff) crit.uniqueResult();
        
        t.commit();
        return c;        
    }

    @Override
    public Integer save(Takeoff t) 
    {
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        Transaction tr = session.beginTransaction();
        
        Integer id = (Integer) session.save(t);
        
        tr.commit();
        return id;
    }

    @Override
    public Boolean update(Takeoff t) 
    {
        try
        {
            Session session = HibUtil.getSessionFactory().getCurrentSession();
            Transaction tr = session.beginTransaction();
            
            session.update(t);
            
            tr.commit();
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
            
            String req = "delete from Takeoff where id=:id";
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

    @Override
    public List<Takeoff> planeHistory(String imm) 
    {
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        
        Criteria crit = session.createCriteria(Takeoff.class);
        
        Criteria planeCrit = session.createCriteria(Plane.class);
        planeCrit.add(Restrictions.eq("plane_immatriculation", imm));
        Plane p = (Plane) planeCrit.uniqueResult();
        
        crit.add(Restrictions.eq("plane", p));
        crit.addOrder(Order.desc("takeoff_date"));
        List<Takeoff> res = crit.list();
        
        t.commit();
        return res;
    }
    
}
