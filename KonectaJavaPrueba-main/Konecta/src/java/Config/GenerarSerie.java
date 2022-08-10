/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

/**
 *
 * @author Miguel
 */
public class GenerarSerie {
    int dato;
    String numero;
    
    public String NumSerie(int dato){
        this.dato=dato+1;
        if ((this.dato>=10000000)&&(this.dato<=100000000)) {
            numero=""+dato;
        }
        if ((this.dato>=1000000)&&(this.dato<=10000000)) {
            numero="0"+dato;
        }
        if ((this.dato>=100000)&&(this.dato<=1000000)) {
            numero="00"+dato;
        }
        if ((this.dato>=10000)&&(this.dato<=100000)) {
            numero="000"+dato;
        }
        if ((this.dato>=1000)&&(this.dato<=10000)) {
            numero="0000"+dato;
        }
        if ((this.dato>=100)&&(this.dato<=1000)) {
            numero="00000"+dato;
        }
        if ((this.dato>=10)&&(this.dato<=100)) {
            numero="000000"+dato;
        }
        if (this.dato<10) {
            numero="0000000"+dato;
        }
        return this.numero;
        
    }
}
