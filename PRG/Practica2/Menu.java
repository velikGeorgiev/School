package haorcado;

import java.util.Arrays;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class Menu {
    
    private String nombre = "";
    private Menu[] subMenus = new Menu[5];
    private int contadorSubMenus = 0;
    
    public Menu(String nombre) {
        this.nombre = nombre;
    }
    
    public boolean haySubMenus() {
        return (this.contadorSubMenus > 0);
    }
    
    public void agregarSubMenu(Menu menu) {
        this.asegurarCapacidad();
        
        this.subMenus[this.contadorSubMenus++] = menu;
    }
    
    private void asegurarCapacidad() {
        if(this.contadorSubMenus >= this.subMenus.length - 2) {
            int nuevaCapacidad = this.subMenus.length + (this.subMenus.length >> 2);
            
            this.subMenus = Arrays.copyOf(this.subMenus, nuevaCapacidad);
        }
    }
    
    public String cogerNombre() {
        return this.nombre;
    }
    
    public Menu[] cogerSubMenus() {
        Menu[] subMenuItems = new Menu[this.contadorSubMenus];
        
        System.arraycopy(this.subMenus, 0, subMenuItems, 0, this.contadorSubMenus);
        
        return subMenuItems;
    }
}
