/*!**************************************************************
 *  Agenda
 * ========
 * @author : Randolfo A Gonçalves
 * @file   : Contato.java
 * @brief  : Class dedicada a Gerenciar dados  da Agenda
 * @since  : 18-03-24
 ****************************************************************/

import java.util.ArrayList;
import java.util.Scanner;



public  class  Agenda{

// Fields
// ======
    //! Leitura de dados
    private static Scanner read = new Scanner(System.in);
    
    //! Conteiner para contatos
    private static ArrayList<Contato> list = new ArrayList<Contato>();       
   
// Manager
// =======
    //! Adicionar novo contato unico
    static void add(Contato cnt){
        if(!search(cnt.get_name()))list.add(cnt);
        else if(quest("Existing contact, try again [y/n]? ").equals("y")) new_contato();
    }
    
    //! Remover contato com seu index
    static void del(int idx){ list.remove(idx); }
    
    //! Busca contatos existentes
    static boolean search(String name){ 
        for(var cnt:list) if(cnt.get_name().equals(name)) return true;
        return false;
    }

    //! Lista um conteudo 
    static String list_data(int opt){
        return ((opt>0)?list_cnt(Clr.be+"Idx    Contato\n\t===    ======="+Clr.df+"\n",0):list_task((-1)*opt));
    }

    //! Listar contatos da agenda
    static String list_cnt(String inf,int i){
        for(var cnt:list) inf+="\t"+Clr.gn+" "+(i++)+Clr.df+"     [ "+cnt.get_name()+" / "+cnt.get_telp()+" ]\n";
        return inf;
    }

    //! Listar tarefas de um contato
    static String list_task(int idx){ return list.get(idx).list_tasks("",0); }

    //! Update contact 
    static void update(int idx){
        switch(quest("\n\t1 -> update name   \n\t2 -> update telp\n\t3 -> telp and name \n\tKEY: ")){
            case "1":  list.get(idx).set_name(quest("Nome: "));  break;
            case "2":  list.get(idx).set_telp(quest("Telp: "));  break;
            case "3": {list.get(idx).set_name(quest("Nome: "));
                       list.get(idx).set_telp(quest("Telp: "));} break;
        }
    }

    //! new task 
    static void new_task(int idx){ list.get(idx).new_task(quest("New task: ")); }

    //! remove task 
    static void del_task(int idx){list.get(idx).del_task(quest(0)); }

// Programa
// ========
    //! Clear terminal
    static void clear(){ System.out.print("\033\143"); }

    //! Realiza uma questão
    static String quest(String text){ 
        System.out.print("\t"+text); 
        return read.nextLine();
    }
    
    static int quest(){ 
        System.out.print("\tContact Idx: ");    
        int exit=read.nextInt(); 
        read.nextLine(); 
        return exit;
    }
    
    static int quest(int e){ 
        System.out.print("\tTask Idx: ");  
        return read.nextInt(); 
    }

    //! Exibir a interface de opções
    static int label(int opt){
        System.out.println("\n"
           +Clr.yw+"\t****************************************************"+Clr.df+"\n"
           +Clr.yw+"\t*********************"+Clr.be+" Agenda "+Clr.yw+"***********************"+Clr.df+"\n"
           +Clr.yw+"\t____________________________________________________"+Clr.yw+"\n"
           +"\t"+list_data(opt)
           +Clr.yw+"\t____________________________________________________"+Clr.yw+"\n"
           +Clr.gn+"\t  1"+Clr.rd+" -> Register          "+Clr.gn+"2"+Clr.rd+" -> Remove contact        \n"
           +Clr.gn+"\t  3"+Clr.rd+" -> Update contact    "+Clr.gn+"4"+Clr.rd+" -> List tasks            \n"
           +Clr.gn+"\t  5"+Clr.rd+" -> New Task          "+Clr.gn+"6"+Clr.rd+" -> Remove Task         \n\n"
           +Clr.gn+"\t                 0 -> Exit                          \n"+Clr.df
           +Clr.yw+"\t****************************************************"+Clr.df
        );
        System.out.print("\tKEY: ");
        return read.nextInt(); 
    }

    //! Cadastra novo contato
    static void new_contato(){ add(new Contato(quest("Nome: "),quest("Telp: "))); }

    //! Remove um contato
    static void  del_contato(){del(quest()); }

    //! Inicia programa
    static boolean start(int opt){
        clear();
        switch(label(opt)){
            case 1:{
                read.nextLine();
                new_contato();       
            }break;
            case 2:del_contato();       break;
            case 3:update(quest());     break;
            case 4:start((-1)*quest()); break;
            case 5:new_task(quest());   break;
            case 6:del_task(quest());   break;
            case 0:System.exit(0);
        
        }
        return start(1); 
    }
    
    //! Init padrão
    static boolean start(){
        try{ start(1); return true; } 
        catch(Exception e){return (quest(e.getMessage()+" ....Continui[y/n]? ").equals("y"))?start():false;} 
    }

    // Main
    public static void main(String[] args) {
        start();   
    }
}




