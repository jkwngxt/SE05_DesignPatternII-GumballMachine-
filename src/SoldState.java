/**
 * @author 6510405377 Jitlada Yotinta
 */
public class SoldState implements State {
    private final GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait, we’re already giving you a gumball");
    }

    @Override
    public void ejectsQuarter() {
        System.out.println("Sorry, you already turned the crank");
    }

    @Override
    public void turnsCrank() {
        System.out.println("Turning twice doesn't get you another gumball!");
    }

    @Override
    public void dispenseGumball() {
        gumballMachine.dispense();
        System.out.println("Reset choosing flavor");
        gumballMachine.setChosenFlavor(null);

        if (gumballMachine.getNumGumballs() == 0) {
            System.out.println("Oops, out of gumballs!");
            gumballMachine.setStatus(gumballMachine.getOutOfGumballsStatus());
        } else {
            gumballMachine.setStatus(gumballMachine.getNoQuarterStatus());
        }

    }

    @Override
    public void choose() {
        System.out.println("You can't choose flavor after you already turned the crank");
    }
}
