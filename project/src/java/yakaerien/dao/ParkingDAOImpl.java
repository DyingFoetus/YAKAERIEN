
package yakaerien.dao;

import java.util.List;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import yakaerien.javabeans.HibUtil;
import yakaerien.javabeans.Parking;

public class ParkingDAOImpl implements ParkingDAO
{
    private static final ParkingDAOImpl instance = new ParkingDAOImpl();
    
    private ParkingDAOImpl()
    {
    }
    
    public static ParkingDAO getInstance()
    {
        return instance;
    }
    
    @Override
    public List<Parking> list() 
    {
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        
        Criteria crit = session.createCriteria(Parking.class);
        List<Parking> list = crit.list();
        
        t.commit();
        return list;        
    }

    @Override
    public Parking get(Integer id) 
    {
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        
        Criteria crit = session.createCriteria(Parking.class);
        crit.add(Restrictions.eq("id", id));
        Parking c = (Parking) crit.uniqueResult();
        
        t.commit();
        return c;         
    }

    @Override
    public Integer save(Parking p) 
    {
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        
        Criteria crit = session.createCriteria(Parking.class);
        crit.add(Restrictions.eq("parking_name", p.getParking_name()));
        Integer id = -1;
        if (crit.list().isEmpty())
            id = (Integer) session.save(p);
        else
            id = ((Parking) crit.uniqueResult()).getId();
        
        t.commit();
        return id;        
    }

    @Override
    public Boolean update(Parking p) 
    {
        try
        {
            Session session = HibUtil.getSessionFactory().getCurrentSession();
            Transaction t = session.beginTransaction();
            
            session.update(p);
            
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
            
            String req = "delete from Parking where id=:id";
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
