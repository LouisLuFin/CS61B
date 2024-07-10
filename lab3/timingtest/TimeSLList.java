package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        SLList<Integer> S=new SLList<>();
        int[] NList={1000,2000,4000,8000,16000,32000,64000,128000};
        int currentMilestoneIndex=0;
        int M=10000;
        AList<Integer> N=new AList<>();
        AList<Integer> ops=new AList<>();
        AList<Double> times=new AList<>();

        for (int i=0;i<NList[NList.length-1];i+=1){
            int currentMilestone=NList[currentMilestoneIndex];
            S.addLast(i);
            if (i==currentMilestone-1){
                N.addLast(i+1);
                timeGetLastHelper(S,M,times,ops);
                currentMilestoneIndex+=1;
            }
        }
        printTimingTable(N,times,ops);
    }

    public static void timeGetLastHelper(SLList<Integer> S, int M, AList<Double> time, AList<Integer> ops){
        Stopwatch sw=new Stopwatch();
        for (int i=0;i<M;i+=1){
            int a=S.getLast();
        }
        ops.addLast(M);
        time.addLast(sw.elapsedTime());
    }
}
