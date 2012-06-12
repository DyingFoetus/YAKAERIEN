
package yakaerien.dao;

public class DAOFactory 
{
    private static final DAOFactory instance = new DAOFactory();
    
    private DAOFactory()
    {
    }
    
    public static DAOFactory getInstance()
    {
        return instance;
    }
    
    public CategoryDAO getCategoryDAO()
    {
        return CategoryDAOImpl.getInstance();
    }
    
    public CompanyDAO getCompanyDAO()
    {
        return CompanyDAOImpl.getInstance();
    }
    
    public ControllerDAO getControllerDAO()
    {
        return ControllerDAOImpl.getInstance();
    }
    
    public LandingDAO getLandingDAO()
    {
        return LandingDAOImpl.getInstance();
    }
    
    public LandingPlatformDAO getLandingPlatformDAO()
    {
        return LandingPlatformDAOImpl.getInstance();
    }
    
    public ParkPlanningDAO getParkPlanningDAO()
    {
        return ParkPlanningDAOImpl.getInstance();
    }
    
    public ParkingDAO getParkingDAO()
    {
        return ParkingDAOImpl.getInstance();
    }
    
    public PlaneDAO getPlaneDAO()
    {
        return PlaneDAOImpl.getInstance();
    }
    
    public TakeoffDAO getTakeoffDAO()
    {
        return TakeoffDAOImpl.getInstance();
    }
    
    public TakeoffPlatformDAO getTakeoffPlatformDAO()
    {
        return TakeoffPlatformDAOImpl.getInstance();
    }
    
}
