import java.util.Scanner;

public class Main{
    // Obj para ler entrada:
    private static Scanner read = new Scanner(System.in);

    // Class de somatorio:
    static class Ex_01{ float add(int cnt,int i){ return (i<cnt)?read.nextFloat()+add(cnt,i+1):0; }};
    
    // Class de media:
    static class Ex_02{ float average(int cnt,int smt){ return (new Ex_01().add(cnt, smt)/smt); }};
    
    // Class de  acreimo salarial:
    static class Ex_03{ float salary(float money){ return money+(money/4); }};    

    public static void main(String[] args) {
       System.out.println("Dígite 4 números:"); 
       System.out.println("Somatório = "+(new Ex_01().add(4,0))); 
       System.out.println("Dígite suas 3 notas semestrais"); 
       System.out.println("Média = "+(new Ex_02().average(3, 3))); 
       System.out.println("Um salario 1200 + 25% = "+(new Ex_03().salary(1200))); 
    }
}
