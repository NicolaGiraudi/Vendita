import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SalePhase {
    private List<Player> players;   //tutti i giocatori
    private List<Property> propertiesForSale;   //proprietà in vendita

    public SalePhase(List<Player> players) {
        this.players = players;
        this.propertiesForSale = new ArrayList<>();
    }

    public void addPropertyForSale(Property property) {     //metti una proprietà in vendita
        propertiesForSale.add(property);
    }

    public void placeOffer() {       //metodo che consente di lanciare un'offerta

        //looppa a tutti i giocatori
        for (Player player : players) {
            for (Property property : propertiesForSale) {
                int bid = player.isHuman() ? askForOffer(player, property) : makeOffer(player, property);
                player.addBid(property, bid);
            }
        }
    }

    private int askForOffer(Player player, Property property) {
        System.out.println(player.getName() + ", lancia un offerta, è il tuo turno. Vuoi acquistare la " + property.getName() + "?");
        Scanner scanner = new Scanner(System.in);       // utilizzo la classe Scanner perchè bufferedreader fa merda
        int offer = scanner.nextInt();                  //prendo il numero di monete offerte da riga di comando
        int cash = 14000 - offer*1000;
        player.setCash(cash);
        System.out.println(player.getName() + " hai offerto $" + offer*1000 + " per la proprietà: " + property.getName());
        return offer;
    }


    private int makeOffer(Player player, Property property) {
        // qua va implementato il metodo per i BOT
        // creare un algoritmo che esegua azioni randomiche o implementare una strategia.
        return 0;
    }

    public void sellProperties() {      //algoritmo per la vendita delle proprietà
                                        //determina l'offerta più alta e assegna ad ogni giocatore la proprietà

        for (Property property : propertiesForSale) {
            int highestOffer = 0;
            Player highestOfferer = null;
            for (Player player : players) {
                int bid = player.getBid(property);
                if (bid > highestOffer) {
                    highestOffer = bid;
                    highestOfferer = player;
                }
            }
            if (highestOffer > 0 && highestOfferer != null) {
                highestOfferer.addProperty(property);
                highestOfferer.setCash(highestOfferer.getCash() - highestOffer);
            }
        }
    }
}

