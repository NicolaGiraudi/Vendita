import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
    private String name;
    private boolean isHuman;
    private int cash;
    private List<Property> properties;  //proprietà totali
    private Map<Property, Integer> bids;    //bid = offerta

    public Player(String name, boolean isHuman, int cash) {   //costruttore
        this.name = name;
        this.isHuman = isHuman;
        this.cash = 0;
        this.properties = new ArrayList<>();
        this.bids = new HashMap<>();
    }
    public Player(Player p) {   //Costr. per copy
        Player player = new Player(p);
    }

    //GETTER AND SETTER
    public String getName() {
        return name;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void addProperty(Property property) {
        properties.add(property);
    }

    public void removeProperty(Property property) {
        properties.remove(property);
    }

    public void addBid(Property property, int bid) {
        bids.put(property, bid);
    }

    public int getBid(Property property) {
        return bids.get(property);
    }

    public void buyProperty(Property property, int highestBid) {        //da implementare
    }

    public void sellProperty(Property property, int highestBid) {       //da implementare
    }
}

