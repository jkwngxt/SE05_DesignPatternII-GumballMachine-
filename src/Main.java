import java.util.HashMap;
import java.util.Scanner;

/**
 * @author 6510405377 Jitlada Yotinta
 */
public class Main {
    public static void main(String[] args) {
        HashMap<String, Gumball> gumballs = new HashMap<>();
        gumballs.put("mango", new MangoGumball(5));
        gumballs.put("orange", new OrangeGumball(5));


        GumballMachine gumballMachine = new GumballMachine(gumballs);

        char selected;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu: C)heck inventory  I)nsert quarter  R)eturn quarter  T)erns crank  S)elect flavor  E)xit");
            selected = scanner.next().charAt(0);

            if (selected == 'E' || selected == 'e') {
                System.out.println("Exit...");
                break;

            } else if (selected == 'I' || selected == 'i') {
                gumballMachine.insertQuarter();

            } else if (selected == 'R' || selected == 'r') {
                gumballMachine.ejectsQuarter();

            } else if (selected == 'C' || selected == 'c') {
                System.out.println(gumballMachine);

            } else if (selected == 'T' || selected == 't') {
                gumballMachine.turnsCrank();

            } else if (selected == 'S' || selected == 's') {
                gumballMachine.chooseFlavor();
            } else {
                System.out.println("Wrong option! Try again");
            }
        }
    }
}
