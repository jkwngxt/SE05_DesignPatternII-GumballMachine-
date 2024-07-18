/**
 * @author 6510405377 Jitlada Yotinta
 */
public abstract class Gumball {
    private final int count;

    public Gumball(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public abstract String getFlavor();
}
