//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Player pikachu = new Player(1, "Pikachu", 10);
        Player celebi = new Player(2, "Celebi", 20);
        Player hitmochan = new Player(3, "Hitmochan", 30);
        Player mankey = new Player(4, "Mankey", 40);
        Player starmie = new Player(5, "Starmie", 50);
        Player togepi = new Player(6, "Togepi", 60);


        SimpleHashtable players = new SimpleHashtable();
        System.out.println("\nBefore");
        players.put(pikachu.getUserName(), pikachu);
        players.put(celebi.getUserName(), celebi);
        players.put(hitmochan.getUserName(), hitmochan);
        players.put(mankey.getUserName(), mankey);
        players.put(starmie.getUserName(), starmie);
        players.put(togepi.getUserName(), togepi);


        players.printHashtable();

        System.out.println("Getting Pikachu");
        System.out.println(players.get(pikachu.getUserName()));

        System.out.println("Removing Pikachu");
        players.remove(pikachu.getUserName());

        System.out.println("Test if Pikachu is still in Hashtable");
        System.out.println(players.get(pikachu.getUserName()));

        System.out.println("Show Updated Hashtable");
        players.printHashtable();

    }
}