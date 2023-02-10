import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // Creo giocatore reale e bot
        Player player1 = new Player("player1", true, 14000);
        Player bot1 = new Player("bot1", false, 14000);
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(bot1);

        // Creo 2 proprietà per testare
        Property property1 = new Property("Proprietà1", 100);
        Property property2 = new Property("Proprietà2", 200);
        List<Property> properties = new ArrayList<>();
        properties.add(property1);
        properties.add(property2);

        // Test fase compra vendita
        SalePhase salePhase = new SalePhase(players);
        salePhase.addPropertyForSale(property1);
        salePhase.addPropertyForSale(property2);

        // Offerta e vendita
        salePhase.placeOffer();
        salePhase.sellProperties();

        // Risultato finale
        for (Player player : players) {
            System.out.println("Nome giocatore: " + player.getName());
            System.out.println("Soldi: " + player.getCash());
            System.out.println("Proprietà: " + player.getProperties());
            System.out.println();
        }
    }
}
