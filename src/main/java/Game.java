import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    private Dealer dealer;

    public Game(Dealer dealer) {
        this.dealer = dealer;
        this.players = new ArrayList<Player>();
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }


    public void deal(ArrayList<Player> players) {
        this.dealer.dealCards(players);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public String decideResult(Player player) {
        if (!player.isBust()){
            if (dealer.getHandValue() > player.getHandValue()){
                return "dealer";
            } else if (dealer.getHandValue() == player.getHandValue()){
                return "draw";
            } else {
                return "player";
            }
        }


        if (dealer.getHandValue() > player.getHandValue()){
            return "dealer";
        } else if (dealer.getHandValue() == player.getHandValue()){
            return "draw";
        } else {
            return "player";
        }
    }
}
