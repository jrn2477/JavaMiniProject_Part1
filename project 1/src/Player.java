import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Class player has all of the data that is needed for each player during the game.
 * Project 1
 * @author Jeremy Bolella and Jason Nordheim
 *
 **/
public class Player implements ActionListener {
    private String name = "";
    private String[] chosenHotSpots = new String[5];
    private ArrayList<String> clickedSpots = new ArrayList<>();
    private ArrayList<String> hotSpotsCaught = new ArrayList<>();

    public Player(String t_name, String[] t_buttonsChosen) {
        t_name = name;
        t_buttonsChosen = chosenHotSpots;
    }

    public Player(String t_name) {
        t_name = name;
    }
    /**
     * @return returns the ChosenHotSpots String array
     */
    public String[] getChosenHotspots() {
        return chosenHotSpots;
    }

    /**
     * @return returns the size of the hotSpotsCaught Array
     */
    public int getHotSpotSize() {
        return hotSpotsCaught.size();
    }

    /**
     * When a button is clicked it will be evaluated and if it is an empty spot it will be added via this method
     * @param clickedButton - The name of the clicked button that is to be stored.
     */
    public void addSpot(String clickedButton) {
        clickedSpots.add(clickedButton);
    }

    /**
     * adds in a clickedHotSpot button when it is evaluated from the GameLogic class
     * @param clickedHotSpot - the Clicked HotSpot Button
     */
    public void addHotSpot(String clickedHotSpot) {
        hotSpotsCaught.add(clickedHotSpot);
    }

    /**
     * @return returns player name
     */
    public String getName() {
        return name;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

