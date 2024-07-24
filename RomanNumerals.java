import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class RomanNumerals {
    public static void main(String args[])throws FileNotFoundException{
        int length=6;
        String[] array=new String[length];
        int[] numArray=new int[length];
        Scanner s=new Scanner(new BufferedReader(new FileReader("test.txt")));
        for(int i=0;i<length;i++){
            array[i]=s.nextLine();
        }
        Map<Character,Integer> roman=map();
        int totalSum=0;
        int j=0;
        for (String a : array) {
            int sum=0;
            for(int i=0;i<a.length()-1;i++){
                if(roman.get(a.charAt(i))<roman.get(a.charAt(i+1))){
                    sum-=roman.get(a.charAt(i));
                }
                else{sum+=roman.get(a.charAt(i));}
            }
            sum+=roman.get(a.charAt(a.length()-1));
            totalSum+=sum;
            numArray[j]=sum;
            j++;
        }
        System.out.println("Array: "+Arrays.toString(numArray));
        System.out.println("Total sum: "+totalSum);
    }
    public static Map<Character,Integer> map(){
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        return map;
    }
}
