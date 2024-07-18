import java.util.Random;
import java.util.Scanner;

/**
 * @author 6510405377 Jitlada Yotinta
 */
public class HasQuarterState implements State {
    private final GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert another quarter");
    }

    @Override
    public void ejectsQuarter() {
        System.out.println("Quarter returned and unselect flavor");
        gumballMachine.setChosenFlavor(null);
        gumballMachine.setStatus(gumballMachine.getNoQuarterStatus());
    }

    @Override
    public void turnsCrank() {
        System.out.println("You turned...");
        Random random = new Random();
        boolean isWinner = random.nextInt(1, 11) > 9;

        if (gumballMachine.getChosenFlavor() == null || gumballMachine.getChosenFlavor().isEmpty()) {
            System.out.println("You have to choose the flavor first");
        } else if (isWinner) {
            gumballMachine.setStatus(gumballMachine.getWinnerStatus());
        } else {
            gumballMachine.setStatus(gumballMachine.getGumballSoldStatus());
        }
    }

    @Override
    public void dispenseGumball() {
        System.out.println("No gumball dispensed");
    }

    @Override
    public void choose() {
        Scanner scanner = new Scanner(System.in);
        String choose = scanner.next().toLowerCase();

        if (choose.isEmpty()) {
            System.out.println("Flavor can't be empty");
        } else if (!gumballMachine.isThereFlavor(choose)) {
            System.out.println("There isn't this flavor");
        } else if (!gumballMachine.isAvailable(choose)) {
            System.out.println("This flavor is sold out");
        } else {
            gumballMachine.setChosenFlavor(choose.toLowerCase());
        }
    }
}
