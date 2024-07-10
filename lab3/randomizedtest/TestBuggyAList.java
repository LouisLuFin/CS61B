package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> AListNoResize=new AListNoResizing<>();
        BuggyAList<Integer> BuggyAL=new BuggyAList<>();
        int[] arr=new int[]{4,5,6};
        for (int i=0;i<arr.length;i+=1){
            AListNoResize.addLast(arr[i]);
            BuggyAL.addLast(arr[i]);
        }
        for (int i=0;i<arr.length;i+=1){
            System.out.println(compareAList_BuggyAList(AListNoResize,BuggyAL));
            AListNoResize.removeLast();
            BuggyAL.removeLast();
        }
    }


    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B=new BuggyAList<>();
        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                System.out.println("L addLast(" + randVal + ")");
                System.out.println("B addLast(" + randVal + ")");
                System.out.println("===========================");
            } else if (operationNumber == 1) {
                // size
                int sizeL = L.size();
                int sizeB=B.size();
                System.out.println("L size: " + sizeL);
                System.out.println("B size: " + sizeB);
                System.out.println("===========================");
            } else if (operationNumber == 2) {
                if (L.size() != 0) {
                    int a = L.getLast();
                    System.out.println("L Call getLast: " + a);
                }
                if (B.size() != 0) {
                    int b = B.getLast();
                    System.out.println("B Call getLast: " + b);
                    System.out.println("===========================");
                }
            } else if (operationNumber == 3) {
                if (L.size() != 0) {
                    int c = L.removeLast();
                    System.out.println("L Call removeLast: " + c);
                }
                if (B.size() != 0) {
                    int d=B.removeLast();
                    System.out.println("B Call removeLast: " + d);
                    System.out.println("===========================");
                }
            }
        }
    }
    public boolean compareAList_BuggyAList(AListNoResizing<Integer> AList,BuggyAList<Integer> BAList){
        if (AList.size()!=BAList.size()){
            return false;
            }
        int listSize=AList.size();
        for (int i=0;i<listSize;i+=1){
            if (AList.get(i)!=BAList.get(i)){
                return false;
            }
        }
        return true;
        }


    // YOUR TESTS HERE
}
