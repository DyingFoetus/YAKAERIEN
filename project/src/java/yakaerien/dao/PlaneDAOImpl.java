
package yakaerien.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import yakaerien.javabeans.*;

public class PlaneDAOImpl implements PlaneDAO
{
    private static final PlaneDAOImpl instance =  new PlaneDAOImpl();
    
    private PlaneDAOImpl()
    {
    }
    
    public static PlaneDAO getInstance()
    {
        return instance;
    }
    
    @Override
    public List<Plane> list() 
    {
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        
        Criteria crit = session.createCriteria(Plane.class);
        List<Plane> list = crit.list();
        
        t.commit();
        return list;
    }

    @Override
    public Plane get(Integer id) 
    {
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        
        Criteria crit = session.createCriteria(Plane.class);
        crit.add(Restrictions.eq("id", id));
        Plane c = (Plane) crit.uniqueResult();
        
        t.commit();
        return c;        
    }

    @Override
    public Integer save(Plane plane) 
    {
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        
        Criteria crit = session.createCriteria(Plane.class);
        crit.add(Restrictions.eq("plane_immatriculation",
                                 plane.getPlane_immatriculation()));
        Integer id = -1;
        if (crit.list().isEmpty())
            id = (Integer) session.save(plane);
        else
            id = ((Plane) crit.uniqueResult()).getId();
        
        t.commit();
        return id;
    }

    @Override
    public Boolean update(Plane plane) 
    {
        try
        {
            Session session = HibUtil.getSessionFactory().getCurrentSession();
            Transaction t = session.beginTransaction();
            
            session.update(plane);
            
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
            
            String req = "delete from Plane where id=:id";
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
    public List<Plane> search(String imm, Date date, String type) 
    {
        Session sesion = HibUtil.getSessionFactory().getCurrentSession();
        Transaction t = sesion.beginTransaction();
        
        Criteria crit = sesion.createCriteria(Plane.class);
        
        if (imm != null)
            crit.add(Restrictions.like("plane_immatriculation", "%" + imm + "%"));
        if (date != null)
        {
            List<Integer> ids = new ArrayList<Integer>();
            
            Criteria lcrit = sesion.createCriteria(Landing.class);
            lcrit.add(Restrictions.eq("landing_date", date));
            List<Landing> ll = lcrit.list();
            for (Landing l : ll)
            {
                ids.add(l.getId());
            }
            
            Criteria tcrit = sesion.createCriteria(Takeoff.class);
            lcrit.add(Restrictions.eq("takeoff_date", date));
            List<Takeoff> tl = tcrit.list();
            for (Takeoff to : tl)
            {
                ids.add(to.getId());
            }
            
            crit.add(Restrictions.in("id", ids));
        }
        if (type != null)
        {
            Criteria catCrit = sesion.createCriteria(Category.class);
            catCrit.add(Restrictions.eq("cat_name", type));
            Category cat = (Category)catCrit.uniqueResult();
            
            crit.add(Restrictions.eq("category", cat));
        }
        
        List<Plane> res = crit.list();
        
        t.commit();
        return res;
    }

    @Override
    public Plane get(String imm) 
    {
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        
        Criteria crit = session.createCriteria(Plane.class);
        crit.add(Restrictions.eq("plane_immatriculation", imm));
        Plane p = (Plane) crit.uniqueResult();
        
        t.commit();
        return p;
    }
    
}
