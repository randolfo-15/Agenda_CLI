import java.util.Scanner;

public class Main{
    // Obj para ler entrada:
    private static Scanner read = new Scanner(System.in);

    // Class de somatorio:
    static class Ex_01{ float add(float n){ return ((n=read.nextFloat())>=0)?n+add(n):0; }};
    
    // Class de media:
    static class Ex_02{ float average(int cnt,int smt){ return (new Ex_01().add(0)/smt); }};
    
    // Class de  acreimo salarial:
    static class Ex_03{ static float salary(float money){ return money+(money/4); }};    

    // Program: 
    static class Program{
        int Layout(){
            System.out.println(
                " Tarefa 01\n"+
                "===========\n"+
                "  1 -> [__Somatário__]\n"+
                "  2 -> [____Media____]\n"+
                "  3 -> [__Redimento__]\n"+
                "  0 -> [____Sair_____]"
            );
            return read.nextInt();
        }
        void show(){
            switch (Layout()){
                case 0: return;
                case 1: {
                    System.out.println("Dígite -1 para sair:"); 
                    System.out.println("Soma = "+(new Ex_01().add(0)));
                }break;
                case 2:{
                    System.out.println("Dígite -1 para sair:"); 
                    System.out.println("Soma = "+(new Ex_01().add(0)));
                }break;
                case 3:{

                }break;
            }show();
        }
        
     }

    public static void main(String[] args) {
        new Program().show();

        /*if(args[1]=="somar"){  
            System.out.println("Dígite -1 para encerrar somas:"); 
            System.out.println("Somatório = "+(new Ex_01().add(0))); 
       }*/
       //System.out.println("Dígite suas 3 notas semestrais"); 
       //System.out.println("Média = "+(new Ex_02().average(3, 3))); 
       //System.out.println("Um salario 1200 + 25% = "+(new Ex_03().salary(1200))); 
    }
}
