package Server;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "app_user")
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	private String uuid;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "user_favorite",
				joinColumns = { @JoinColumn(name="user_id") },
				inverseJoinColumns =  @JoinColumn(name="favorite_id"))

	private Set<Favorite> favorites;

	public User(){}

	public String toString() {
		return "User [id=" + id + ", uuid=" + uuid + ", favorites=" + favorites
				+ "]";
	}

	public long getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public void setFavorites(Set<Favorite> favorites) {
		this.favorites = favorites;
	}

	public Set<Favorite> getFavorites() {
		return favorites;
	}


}
