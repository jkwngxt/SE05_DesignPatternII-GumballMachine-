/**
 * @author 6510405377 Jitlada Yotinta
 */
public class NoQuarterState implements State {
    private final GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You insert a quarter");
        gumballMachine.setStatus(gumballMachine.getHasQuarterStatus());
    }

    @Override
    public void ejectsQuarter() {
        System.out.println("You haven't inserted a quarter");
    }

    @Override
    public void turnsCrank() {
        System.out.println("You turned but there's no quarter");
    }

    @Override
    public void dispenseGumball() {
        System.out.println("You need to pay first");
    }

    @Override
    public void choose() {
        System.out.println("You need to insert a quarter first");
    }
}
