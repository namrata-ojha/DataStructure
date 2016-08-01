package Siblings;

/**
 * Created by namrataojha on 6/3/16.
 * Asked in Samsung
 */
public class Sol {
    public int solution(int N) {
        // write your code in Java SE 8
        if(N > 10000000 || N < 0)
            return -1;
        else if(N==0) return 0;
        else{
            int[] family= new int[10];
            //Marking the value in array
            while(N!=0){
                if(N==0) break;
                int value=N%10;
                family[value]++;
                N/=10;
            }
            String largestN="";
            for(int i=9;i>=0;i--){
                for(int j=0;j<family[i];j++){
                    largestN+=i;
                }
            }
            return Integer.parseInt(largestN);
        }

    }
    public static void main(String[] args) {
     Sol s = new Sol();
        System.out.println(s.solution( 526));
    }
}
