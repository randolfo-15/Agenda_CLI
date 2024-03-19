/*!
 *  Agenda
 * ========
 * @author : Randolfo A Gonçalves
 * @file   : Contato.java
 * @brief  : Class dedicada a Gerenciar dados  da Agenda
 * @since  : 18-03-24
 */

import java.util.ArrayList;
import java.util.Scanner;


public  class  Agenda{
    private static Scanner read = new Scanner(System.in);

    private static ArrayList<Contato> list = new ArrayList<Contato>();       
    
    static void add(Contato cnt){ if(!search(cnt.get_name(), 0)) list.add(cnt); }
    static boolean del(int idx){ 
        try{ list.remove(idx); return true;}
        catch( Exception e ){ e.printStackTrace(); return false; }
    }

    static boolean search(String name,int i){ 
        return ((i<list.size())?((is_name(name,list.get(i).get_name()))?true:search(name,i+1)):false); 
    }
    
    static boolean is_name(String name,String other){return ((name.equals(other))?true:false); }

    static String listar(){
        String data="";
        int i=0;
        for(var cnt : list ) data+= (i++)+" -> "+cnt.get_name()+" "+cnt.get_telp()+"\n";
        return data;
    }

    static int label(){
        System.out.println("\n"
           +"**************************************\n"
           +"*************** Agenda ***************\n"
           +"--------------------------------------\n"
           +listar()
           +"--------------------------------------\n"
           +" 1 -> Cadastrar                       \n"
           +" 2 -> Remover                         \n"
           +" 0 -> Sair                            \n"
           +"**************************************"
        );
        return read.nextInt(); 
    }

    static void new_contato(){
        Contato cnt = new Contato();  

        System.out.print("Qual o nome?"); 
        cnt.set_name(read.next());
        
        System.out.print("Qual é o telefone?");
        cnt.set_telp(read.next());
        
        add(cnt);
    }

    static void  del_contato(){
        System.out.println("Qual o numero do contato?"); 
        del(read.nextInt());
    }

    static void start(){
        switch(label()){
            case 1:new_contato(); break;
            case 2:del_contato(); break;
            case 0:return;
        }start(); 
    }


    public static void main(String[] args) {
        start();   
    }
}




