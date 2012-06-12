
package yakaerien.dao;

import java.util.List;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import yakaerien.javabeans.Controller;
import yakaerien.javabeans.HibUtil;

public class ControllerDAOImpl implements ControllerDAO
{
    private static final ControllerDAOImpl instance = new ControllerDAOImpl();
    
    private ControllerDAOImpl()
    {
    }
    
    public static ControllerDAO getInstance()
    {
        return instance;
    }
    
    @Override
    public List<Controller> list() 
    {
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        
        Criteria crit = session.createCriteria(Controller.class);
        List<Controller> list = crit.list();
        
        t.commit();
        return list;        
    }

    @Override
    public Controller get(Integer id) 
    {
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        
        Criteria crit = session.createCriteria(Controller.class);
        crit.add(Restrictions.eq("id", id));
        Controller c = (Controller) crit.uniqueResult();
        
        t.commit();
        return c;        
    }

    @Override
    public Integer save(Controller c) 
    {
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        
        Criteria crit = session.createCriteria(Controller.class);
        crit.add(Restrictions.eq("cont_numsecu", c.getCont_numsecu()));
        Integer id = -1;
        if (crit.list().isEmpty())
            id = (Integer) session.save(c);
        else
            id = ((Controller) crit.uniqueResult()).getId();
        
        t.commit();
        return id;        
    }

    @Override
    public Boolean update(Controller c) 
    {
        try
        {
            Session session = HibUtil.getSessionFactory().getCurrentSession();
            Transaction t = session.beginTransaction();
            
            session.update(c);
            
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
            
            String req = "delete from Controller where id=:id";
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
