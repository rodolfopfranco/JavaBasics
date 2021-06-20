package one.digitalinnovation.classes.finais;

public class Programa {
    public static void main(String[] args){
        final RetroGamer retroGamer = new RetroGamer();
        final Gamer gamer = new Gamer();
        final ModernGamer modernGamer = new ModernGamer();
        final var game = "CS";

        /*Final won't let game be changed, like this:
        var game = "CS";
        game = "pubg";
         */
        System.out.println(modernGamer.play(game));
    }
}
