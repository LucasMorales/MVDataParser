import java.util.ArrayList;
import java.util.List;

public class State {
    private String name;
    private List<County> counties;

    public State(String name) {
        this.name = name;
        this.counties = new ArrayList<>();
    }


}
