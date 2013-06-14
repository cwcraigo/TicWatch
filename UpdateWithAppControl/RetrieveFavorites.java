import java.util.HashMap;


public class RetrieveFavorites implements Handler{
	public void handleIt(HashMap data){
		Hibernate hib = new Hibernate();
		hib.addNewUsers("C3P0");
		hib.addNewUsers("HONSOLO");
		hib.addNewUsers("CHEWBAKA");
		hib.showAllUsers();
		hib.modifyUser("C3P0","R2D2");
		//hib.deleteAllUser();
	}
}
