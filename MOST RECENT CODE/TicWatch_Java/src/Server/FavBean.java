package Server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

@SuppressWarnings("serial")
public class FavBean implements Serializable {

    private String command;
    private String uuid;
    private ArrayList<String> symbols;

    public FavBean() {}
    
    public FavBean(String command, String uuid, ArrayList<String> symbols) {
	this.uuid = uuid;
	this.symbols = symbols;
	this.command = command;
    }
    
    @SuppressWarnings("unchecked")
    public FavBean(HashMap<String,Object> map) {
	this.uuid = (String) map.get("uuid");
	this.symbols = (ArrayList<String>) map.get("symbols");
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

    public ArrayList<String> getSymbols() {
        return symbols;
    }

    public void setSymbols(ArrayList<String> symbols) {
        this.symbols = symbols;
    }

}
