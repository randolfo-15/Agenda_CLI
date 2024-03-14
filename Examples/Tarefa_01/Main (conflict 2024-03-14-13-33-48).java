import java.util.Scanner;

public class Main{
    // Obj para ler entrada:
    private static Scanner read = new Scanner(System.in);
    private static int cont=-1;

    // Class de somatorio:
    static class Ex_01{ float add(float n){++cont; return ((n=read.nextFloat())>=0)?n+add(n):0; }};
    
    // Class de media:
    static class Ex_02{ float average(){ cont=-1; return (new Ex_01().add(0))/cont;}};
    
    // Class de  acreimo salarial:
    static class Ex_03{ float salary(float money,float acr){ return money+(money*(acr/100)); }};    

    // Program: 
    static class Program{
        private 
        String space(){ return "\n____________________________\n";}

        private 
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
                    System.out.println("Soma = "+(new Ex_01().add(0))+space());
                }break;
                case 2:{
                    System.out.println("Dígite -1 para sair:"); 
                    System.out.println("Média = "+(new Ex_02().average())+space());
                }break;
                case 3:{
                    System.out.println("Quanto você recebe e o acrescimo: ");
                    System.out.println("Total = R$ "+
                            (new Ex_03().salary(
                                read.nextFloat(), /* Salário     */
                                read.nextInt()    /* Porcentagem */
                            )+space()));
                }break;
            }show();
        }
        
     }

    public static void main(String[] args) { new Program().show(); }
}
