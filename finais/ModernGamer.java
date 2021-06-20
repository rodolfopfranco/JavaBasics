package one.digitalinnovation.classes.finais;

public class ModernGamer extends Gamer{
    @Override
    public String bits() { return "128";}

    /*You can't override a final method:
    @Override
    public String artstyle() {
    	return super.artstyle();
    }*/

    public String play(final String game){
	    //game = "Cyberpunk 2077";
	    return "Jogando "+game;
    }
}
