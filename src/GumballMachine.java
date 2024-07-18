import java.util.HashMap;

/**
 * @author 6510405377 Jitlada Yotinta
 */
public class GumballMachine {
    private final HasQuarterState hasQuarterStatus;
    private final NoQuarterState noQuarterStatus;
    private final SoldOutState outOfGumballsStatus;
    private final SoldState gumballSoldStatus;
    private final WinnerState winnerStatus;
    private final HashMap<String, Gumball> gumballs;

    private State status;
    private String chosenFlavor;

    public GumballMachine(HashMap<String, Gumball> gumballs) {
        this.gumballs = gumballs;
        this.gumballSoldStatus = new SoldState(this);
        hasQuarterStatus = new HasQuarterState(this);
        noQuarterStatus = new NoQuarterState(this);
        outOfGumballsStatus = new SoldOutState();
        winnerStatus = new WinnerState(this);
        status = this.gumballs.isEmpty() ? outOfGumballsStatus : noQuarterStatus;
    }

    public void insertQuarter() {
        status.insertQuarter();
    }

    public void ejectsQuarter() {
        status.ejectsQuarter();
    }

    public void turnsCrank() {
        status.turnsCrank();
        status.dispenseGumball();
    }

    public void chooseFlavor() {
        status.choose();
    }

    public int getNumGumballs() {
        int tt = 0;
        for (Gumball gumball : gumballs.values()) {
            tt += gumball.getCount();
        }
        return tt;
    }

    public void dispense() {
        if (gumballs.get(chosenFlavor).getCount() > 0) {
            if (chosenFlavor.equalsIgnoreCase("Orange")) {
                System.out.println("A orange gumball comes rolling out the slot");
            } else if (chosenFlavor.equalsIgnoreCase("Mango")) {
                System.out.println("A mango gumball comes rolling out the slot");
            }
        }
    }

    public boolean isThereFlavor(String string) {
        return gumballs.containsKey(string);
    }

    public boolean isAvailable(String string) {
        return gumballs.get(string).getCount() > 0;
    }

    @Override
    public String toString() {
        String result = "Mighty Gumball, Inc.\n" +
                "Java-enabled Standing Gumball Model #2004\n" +
                "Inventory: " + getNumGumballs() + " gumball" + (getNumGumballs() <= 1 ? "\n" : "s\n");
        for (Gumball gumball : gumballs.values()) {
            result += "           " + gumball.getFlavor() + ": " + gumball.getCount() + "\n";
        }

        if (status == noQuarterStatus) {
            return result + "Machine is waiting for quarter\n";
        }

        if (status == hasQuarterStatus) {
            return result + "Machine is waiting for turning\n";
        }

        return result + "Machine is sold out\n";
    }

    public void setStatus(State status) {
        this.status = status;
    }

    public HasQuarterState getHasQuarterStatus() {
        return hasQuarterStatus;
    }

    public NoQuarterState getNoQuarterStatus() {
        return noQuarterStatus;
    }

    public SoldOutState getOutOfGumballsStatus() {
        return outOfGumballsStatus;
    }

    public SoldState getGumballSoldStatus() {
        return gumballSoldStatus;
    }

    public WinnerState getWinnerStatus() {
        return winnerStatus;
    }

    public String getChosenFlavor() {
        return chosenFlavor;
    }

    public void setChosenFlavor(String chosenFlavor) {
        this.chosenFlavor = chosenFlavor;
    }
}
