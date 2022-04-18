import JBench.PView;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args){
        PView measure = new PView(3,false, PView.Time.MILlI);
        LinkedList<PView.Compare> functions = new LinkedList<>();
        functions.add(Test::func1);
        functions.add(Test::func2);
        functions.add(Test::func3);
        functions.add(Test::func4);
        measure.benchmark(functions);
    }
}
