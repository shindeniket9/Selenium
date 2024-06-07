package thetestingacdamy;

public class trial{
    public static void main(String[] args) {

        //factorial - n=5 i.e 5*4*3*2*1
        int n = 6;
        int temp = n;
        int fact = 1;

        int i =1;
        while(i<=n){
            fact = fact*temp;
            temp-=1;
            i++;
        }
        System.out.println(fact);
    }
}
