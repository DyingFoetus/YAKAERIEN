
package yakaerien.dao;

import java.util.List;
import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import yakaerien.javabeans.HibUtil;
import yakaerien.javabeans.Landing;
import yakaerien.javabeans.Plane;

public class LandingDAOImpl implements LandingDAO
{
    private static final LandingDAOImpl instance = new LandingDAOImpl();
    
    private LandingDAOImpl()
    {
    }
    
    public static LandingDAO getInstance()
    {
        return instance;
    }
    
    @Override
    public List<Landing> list() 
    {
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        
        Criteria crit = session.createCriteria(Landing.class);
        List<Landing> list = crit.list();
        
        t.commit();
        return list;        
    }

    @Override
    public Landing get(Integer id) 
    {
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        
        Criteria crit = session.createCriteria(Landing.class);
        crit.add(Restrictions.eq("id", id));
        Landing c = (Landing) crit.uniqueResult();
        
        t.commit();
        return c;        
    }

    @Override
    public Integer save(Landing l) 
    {
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();

        Integer id = (Integer) session.save(l);
        
        t.commit();
        return id;        
    }

    @Override
    public Boolean update(Landing l) 
    {
        try
        {
            Session session = HibUtil.getSessionFactory().getCurrentSession();
            Transaction t = session.beginTransaction();
            
            session.update(l);
            
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
            
            String req = "delete from Landing where id=:id";
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
    public List<Landing> planeHistory(String imm) 
    {
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        
        Criteria crit = session.createCriteria(Landing.class);
        
        Criteria planeCrit = session.createCriteria(Plane.class);
        planeCrit.add(Restrictions.eq("plane_immatriculation", imm));
        Plane p = (Plane) planeCrit.uniqueResult();
        
        crit.add(Restrictions.eq("plane", p));
        crit.addOrder(Order.desc("landing_date"));
        List<Landing> res = crit.list();
        
        t.commit();
        return res;
    }
    
}
