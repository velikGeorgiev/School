
package haorcado;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class Haorcado {
    
    private Locale locale = new Locale("es", "ES");
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Juego juego = null;
        
        try {
            juego = new Juego();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        
        //String[] categorias = juego.cogerCategorias();
        
        Menu menu = new Menu("Juego") {{
            agregarSubMenu( new Menu("Iniciar partida") {{
                agregarSubMenu(new Menu("Un jugador"));
                agregarSubMenu(new Menu("Multijugador"));
            }});
            agregarSubMenu( new Menu("Mas Opciones") {{
                agregarSubMenu(new Menu("Configuraciones") {{
                    agregarSubMenu(new Menu("Jugadores"));  
                    agregarSubMenu(new Menu("Palabras y Categorias") {{
                        agregarSubMenu(new Menu("Palabras") {{
                            agregarSubMenu(new Menu("Nueva"));  
                      }});
                        agregarSubMenu(new Menu("Categorias") {{
                            agregarSubMenu(new Menu("Nueva"));  
                        }});
                    }});  
                }});
            }});
            agregarSubMenu( new Menu("Finalizar partida"));
        }};
        
        Menu[] subMenus = menu.cogerSubMenus();
        
        imprimirMenus(menu, 0);
    }

    private static void imprimirMenus(Menu menus, int level) {
        System.out.println(Consola.repetirCaracter(' ', level) + menus.cogerNombre());
        if(menus.haySubMenus()) {
            Menu[] subMenus = menus.cogerSubMenus();
            
            for(Menu subMenuActual: subMenus) {
                imprimirMenus(subMenuActual, level+2);
            }
        }
    }
}
