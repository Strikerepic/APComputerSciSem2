import java.util.*;

public class Solver {
    public static void main(String[] args){
        FinalCal cal = new FinalCal();
        Scanner sc = new Scanner(System.in);
        System.out.println("What math");
        String Problem = sc.nextLine();
        String[] temp = Problem.split("((?=[+-/*()^])|(?<=[+-/*()^]))");
        ArrayList<String> eqList = new ArrayList<String>();
        for(int i =0; i < temp.length; i++)
        {
            eqList.add(temp[i]);
        }
        System.out.println(cal.calc(eqList));

    }
    

}
