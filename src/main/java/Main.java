import JBench.PView;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args){
        PView measure = new PView(20,true);
        LinkedList<PView.Compare> functions = new LinkedList<>();
        functions.add(Test::returnNum);
        functions.add(Test::returnK);
        measure.benchmark(functions);
    }
}
