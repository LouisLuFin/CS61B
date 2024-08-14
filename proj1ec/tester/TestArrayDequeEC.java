package tester;
import static org.junit.Assert.*;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import student.StudentArrayDeque;


public class TestArrayDequeEC {
    @Test
    public void testStudentDeque1(){
        StudentArrayDeque<Integer> testDeque=new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> testSol=new ArrayDequeSolution<>();
        int randNum=StdRandom.uniform(3,6);
        testDeque.addFirst(randNum);
        testSol.addFirst(randNum);
        String outputString="addFirst"+ randNum+"\n";
        int switchBoard;
        int testSize=1;


        for (int i=0;i<10000;i+=1){
            switchBoard=StdRandom.uniform(4);
            if (switchBoard==0) {
                randNum=StdRandom.uniform(1000);
                testDeque.addFirst(randNum);
                testSol.addFirst(randNum);
                testSize+=1;
                outputString=outputString.concat("addFirst("+randNum+")\n");
            } else if (switchBoard==1) {
                randNum=StdRandom.uniform(1000);
                testDeque.addLast(randNum);
                testSol.addLast(randNum);
                testSize+=1;
                outputString=outputString.concat("addLast("+randNum+")\n");
            } else if (switchBoard==2 && testSize>0) {
                Integer De=testDeque.removeFirst();
                Integer Sol=testSol.removeFirst();
                testSize-=1;
                outputString=outputString.concat("removeFirst()\n");
                assertEquals(outputString,De,Sol);
            } else if (switchBoard==3 && testSize>0) {
                Integer De=testDeque.removeLast();
                Integer Sol=testSol.removeLast();
                testSize-=1;
                outputString=outputString.concat("removeLast()\n");
                assertEquals(outputString,De,Sol);
            }
        }
        testDeque.printDeque();
    }

    @Test
    public void testStudentDeque2(){
        StudentArrayDeque<Integer> testDeque=new StudentArrayDeque<>();
        testDeque.addFirst(StdRandom.uniform(3,1000));
        testDeque.addLast(StdRandom.uniform(3,1000));
        testDeque.printDeque();
    }


}
