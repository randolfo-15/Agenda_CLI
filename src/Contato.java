import java.util.ArrayList;

/*!
 *  Contato 
 * =========
 * @author : Randolfo A Gonçalves
 * @file   : Contato.java
 * @brief  : Class dedicada a struct de dados Agenda
 * @since  : 18-03-24
 */


public class Contato{

// Fields
// ======
   private String name="",
                  telp="";
   private ArrayList<String> tasks = new ArrayList<String>(); 

// Build
// =====
    Contato(){}
    Contato(String name,String telp){ 
        set_name(name);
        set_telp(telp);
    }

// Getting
// ======= 
    String get_name(){ return name; }
    String get_telp(){ return telp; }
    
// Setting
// =======
    void set_name(String name){ if(!name.equals(this.name)) this.name=name; }
    void set_telp(String telp){ if(telp.length()<=19)       this.telp=telp; }

// Tasks
// =====
    
    //! Insert task:
    void new_task(String task){ tasks.add(task);}
    
    //! Remove task:
    boolean del_task(int idx){ 
        try{ tasks.remove(idx); return true;}
        catch( Exception e ){ e.printStackTrace(); return false; }
    }

    //! List tasks:
    String list_tasks(String inf,int i){ 
       inf= "[ "+name+" ]\n";
       for(var task:tasks) inf+="\t"+Clr.gn+(i++)+Clr.df+" -> [ "+task+" ]\n"; return inf; 
    }
}





