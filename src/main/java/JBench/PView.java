package JBench;

import java.util.List;

public class PView {
    private int trial;
    private boolean average;
    private Time multiplier;
    private int x=1050;
    private int y=750;

    public PView(int trial, boolean average, Time scale){
        this.trial = trial;
        this.average = average;
        this.multiplier = scale;
    }
    public PView(int trial, boolean average, Time scale, int x, int y){
        this.trial = trial;
        this.average = average;
        this.x = x;
        this.y = y;
    }
    public void benchmark(List<Compare> functions){
        long[][] times = new long[functions.size()][trial];
        long startTime, endTime;
        for(int i=0;i<functions.size();i++){
            for(int j=0;j<trial;j++) {
                System.out.println("Beginning function "+(i+1)+", trial: "+(j+1));
                startTime = System.nanoTime();
                functions.get(i).perform();
                endTime = System.nanoTime();
                switch(multiplier){
                    case NANO -> times[i][j] = (endTime-startTime);
                    case MILlI -> times[i][j] = (endTime-startTime)/(long)1e6;
                    case SEC -> times[i][j] = (endTime-startTime)/(long)1e9;
                    case MIN -> times[i][j] = (endTime-startTime)/(long)6e10;
                }
            }
        }
        // Could condense this by directly averaging it from the loop above but
        // want to keep the information for each trials available for now
        if(average){
            long[][] tempList = new long[functions.size()][1];
            long temp = 0;
            for(int i=0;i<functions.size();i++){
                for(int j=0;j<trial;j++) {
                    temp+=times[i][j];
                }
                tempList[i][0] = temp/trial;
                temp = 0;
            }
            times = tempList;
        }
        GUI.createGUI(times, x, y, average, multiplier);
    }
    public interface Compare {
        void perform();
    }
    public enum Time{
        NANO,
        MILlI,
        SEC,
        MIN
    }
}
