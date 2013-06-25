package Server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class FavBean implements Serializable {

    private String command;
    private String uuid;
    private Set<Favorite> symbols;

    public FavBean() {}
    
    public FavBean(String command, String uuid, Set<Favorite> symbols) {
	this.uuid = uuid;
	this.symbols = symbols;
	this.command = command;
    }
    
    public FavBean(HashMap map) {
	this.uuid = (String) map.get("uuid");
	this.symbols = (Set<Favorite>) map.get("symbols");
	this.command = (String) map.get("command");
    }

    @Override
    public String toString() {
	return "FavBean [command="+command+", uuid="+uuid+", symbols="+symbols+"]";
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Set<Favorite> getSymbols() {
        return symbols;
    }

    public void setSymbols(Set<Favorite> symbols) {
        this.symbols = symbols;
    }

}
