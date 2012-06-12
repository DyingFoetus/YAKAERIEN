
package yakaerien.javabeans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import yakaerien.dao.DAOFactory;

public class Main 
{

    public static void main(String[] args) 
    {
//        Integer idCat01 = DAOFactory.getInstance().getCategoryDAO().save(new Category("Gros Lard"));
//        Integer idCat02 = DAOFactory.getInstance().getCategoryDAO().save(new Category("Nabot"));
//        
//        Integer idComp01 = DAOFactory.getInstance().getCompanyDAO().save(new Company("air vet"));
//        
//        DAOFactory.getInstance().getPlaneDAO().save(new Plane("CACA01", "present", "stand by",
//                                                    DAOFactory.getInstance().getCompanyDAO().get(idComp01),
//                                                    DAOFactory.getInstance().getCategoryDAO().get(idCat01)));        
//        DAOFactory.getInstance().getPlaneDAO().save(new Plane("CACA02", "present", "stand by",
//                                                    DAOFactory.getInstance().getCompanyDAO().get(idComp01),
//                                                    DAOFactory.getInstance().getCategoryDAO().get(idCat02)));
//        DAOFactory.getInstance().getPlaneDAO().save(new Plane("CACA03", "present", "stand by",
//                                                    DAOFactory.getInstance().getCompanyDAO().get(idComp01),
//                                                    DAOFactory.getInstance().getCategoryDAO().get(idCat02)));
//        DAOFactory.getInstance().getPlaneDAO().save(new Plane("CACA04", "present", "stand by",
//                                                    DAOFactory.getInstance().getCompanyDAO().get(idComp01),
//                                                    DAOFactory.getInstance().getCategoryDAO().get(idCat01)));
//        DAOFactory.getInstance().getPlaneDAO().save(new Plane("CACA05", "present", "stand by",
//                                                    DAOFactory.getInstance().getCompanyDAO().get(idComp01),
//                                                    DAOFactory.getInstance().getCategoryDAO().get(idCat01)));
        Date today = new Date();
        SimpleDateFormat fd = new SimpleDateFormat("dd/MM/yyyy");
        try 
        {
            today = fd.parse("14/06/2000");
        }
        catch (ParseException ex) 
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
//        DAOFactory.getInstance().getTakeoffDAO().save(new Takeoff(new Controller("bibi", "bubu", "15sv", null, 5373),
//                                                      DAOFactory.getInstance().getPlaneDAO().get(1),
//                                                      DAOFactory.getInstance().getTakeoffPlatformDAO().get(1), today, 122));
        
        List<Plane> list = DAOFactory.getInstance().getPlaneDAO().search(null, today, null);
        for (Plane p : list) 
        {
            System.out.println(p.getPlane_immatriculation());
        }
    }
}
