package haorcado;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class Juego {
    /**
     * Archivo que contiene las palabras y las categorias
     */
    private File archivoDeEstadisticas = new File("/home/velko/NetBeansProjects/Haorcado/src/haorcado/palabras");
    
    /**
     * Categorias y la lista de palabras
     */
    private HashMap<String, ArrayList<String>> categoriasYPalabras =  new HashMap<>();
    
    /**
     * Categoria en la que se jugara.
     */
    private String categoriaPartida = "";
    
    /**
     * Palabra con la que se jugara.
     */
    private String palabraPartida = "";
    
    /**
     * Random
     */
    private Random rand = new Random();
    
    
    public Juego() throws Exception {
        /**
         * Cargamos las palabras y las categorias
         */
        this.cargarPalabrasYCategorias();
    }
    
    /**
     * Carga todas las categorias y sus palabras de un fichero.
     * 
     * @throws Exception 
     */
    private void cargarPalabrasYCategorias() throws Exception {
        /**
         * Las palabras que contiene la categoria actual
         */
        ArrayList<String> palabrasDeCategoria = new ArrayList<>();
        
        /**
         * El nombre de la categoria actual
         */
        String categoria = "";
        
        Scanner lector = null;
        
        try {
            lector = new Scanner(this.archivoDeEstadisticas, "utf-8");
            
            while(lector.hasNextLine()) {
                String lineaActual = lector.nextLine().trim().toLowerCase();
                
                /**
                 * Si la linea es vacia pasamos a la siguiente
                 */
                if(lineaActual.equals("")) {
                    continue;
                }
                
                /**
                 * Si no existe una categoria le damos una
                 * predeterminada
                 */
                if(categoria.equals("")) {
                    categoria = "Otros";
                }
                
                if(lineaActual.charAt(0) == '@') {
                    /**
                     * Si encontramos una categoria y en la lista de palabras
                     * tenemos algunos elementos los agregamos a su categoria
                     * correspondiente
                     */
                    if(palabrasDeCategoria.size() > 0) {
                        this.categoriasYPalabras.put(categoria, palabrasDeCategoria);
                    }
                    
                    // Indicamos la nueva categoria
                    categoria = lineaActual.substring(1, lineaActual.length());
                    
                    // Quitamos todas las palabras ya que la hemos "puesto" en su categoria 
                    // y necesitamos una lista vacia para las nuevas.
                    palabrasDeCategoria.clear();
                } else {
                    palabrasDeCategoria.add(lineaActual);
                }
            }
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            if(lector != null) {
                /**
                 * Si en la lista de palabras aun tenemos alguna
                 * la agregamos a la categoria
                 */
                if(palabrasDeCategoria.size() > 0) {
                    this.categoriasYPalabras.put(categoria, palabrasDeCategoria);
                }
                
                lector.close();
            }
        }
    }
    
    /**
     * Comprueba si una categoria existe.
     * 
     * @param categoria Nombre de la categoria
     * @return TRUE si la categoria existe FALSE en caso contrario
     */
    public boolean existeCategoria(String categoria) {
        return this.categoriasYPalabras.containsKey(categoria);
    }
    
    /**
     * El metodo devuelve todas la categoria disponibles.
     * 
     * @return Lista de las categorias definidas en el fichero
     */
    public String[] cogerCategorias() {
        return this.categoriasYPalabras.keySet().toArray(new String[this.categoriasYPalabras.size()]);
    }
    
    /**
     * Devuelve la lista de palabras que contiene una categoria.
     * 
     * @param categoria Nombre de la categoria
     * @return Lista de las palabras guardadas en la lista indicada
     */
    public String[] cogerPalabras(String categoria) {
        if(existeCategoria(categoria)) {
            return this.categoriasYPalabras.get(categoria).toArray(new String[this.categoriasYPalabras.get(categoria).size()]);
        } else {
            return null;
        }
    }
    
    /**
     * Selecciona una categoria, de la cual se escogera de forma aleatoria
     * la palabra con la que se jugara.
     * 
     * @param categoria Nombre de una categoria valida
     */
    public void seleccionarCategoria(String categoria) {
        if(existeCategoria(categoria)) {
            this.categoriaPartida = categoria;
        }
    }
    
    /**
     * Selecciona una palabra aleatoria, de la categoria 
     * elegida.
     */
    public void seleccionarPalabra() {
        if(this.categoriaPartida.equals("")) {
            return;
        }
        
        // Las palabras correspondientes de la categoria
        String[] palabras = this.cogerPalabras(this.categoriaPartida);
        
        this.palabraPartida = palabras[this.rand.nextInt(palabras.length)];
    }
}
