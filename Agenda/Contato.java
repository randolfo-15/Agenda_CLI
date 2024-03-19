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
    void set_telp(String telp){ if(telp.length()<=16)       this.telp=telp; }
}





