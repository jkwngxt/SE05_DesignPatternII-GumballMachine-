/**
 * @author 6510405377 Jitlada Yotinta
 */
public class SoldOutState implements State {

    public SoldOutState() {
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert a quarter, the machine is sold out");
    }

    @Override
    public void ejectsQuarter() {
        System.out.println("You haven't inserted a quarter");
    }

    @Override
    public void turnsCrank() {
        System.out.println("You turned, but there are no gumballs");
    }

    @Override
    public void dispenseGumball() {
        System.out.println("There is empty");
    }

    @Override
    public void choose() {
        System.out.println("The machine is sold out");
    }
}
