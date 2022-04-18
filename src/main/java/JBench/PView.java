package JBench;

import java.util.List;

public class PView {
    private int trial;
    private boolean average;
    public PView(int trial, boolean average){
        this.trial = trial;
        this.average = average;
    }
    public void benchmark(List<Compare> functions){
        long[][] times = new long[functions.size()][trial];
        for(int i=0;i<functions.size();i++){
            for(int j=0;j<trial;j++) {
                long startTime = System.nanoTime();
                functions.get(i).perform();
                long endTime = System.nanoTime();
                times[i][j] = (endTime-startTime);
            }
        }
        //Could condense this by directly averaging it from the loop above but
        // want to keep the information for each trials available
        if(average){
            long[][] tempList = new long[functions.size()][1];
            long temp = 0;
            for(int i=0;i<functions.size();i++){
                for(int j=0;j<trial;j++) {
                    temp+=times[i][j];
                }
                tempList[i][0] = temp/trial;
            }
            times = tempList;
        }
        GUI.createGUI(times);
    }
    public interface Compare {
        void perform();
    }
}
