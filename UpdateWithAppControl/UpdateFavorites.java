import java.util.HashMap;


public class UpdateFavorites implements Handler{
	public void handleIt(HashMap data){
		Hibernate hib = new Hibernate();
		hib.addSharedFavorite("R2D2");
	}
}
