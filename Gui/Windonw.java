/**
* @author: Randolfo A Goncaves
* @date  : 25/03/24   
* @file  : Windown.java
* 
*  Aplicação grafica simples.
*/
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class Windown extends JFrame{
// Field
// =====
    JTextField fld = new JTextField(20);
    JPanel panel   = new JPanel();

// Build
// =====
    Windown(){ super("Ex simples de janela."); init(); }    
    
    void init(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);;
        this.setSize(500, 150);
        this.add(panel);
        panel.add(fld);
        panel.add(init(new JButton("clear")));
    }

//! Button
    JButton init(JButton btn){
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) { fld.setText(""); 
        }});
        return btn;
    }

//! Initialize
    void start(){ this.setVisible(true); }

    public static void main(String[] args) { new Windown().start();}
}
