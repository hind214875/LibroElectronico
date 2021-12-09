/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.Hind;

import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author hinda
 */
public class LibroElectronico {
    //Atributos

    private String identificador;//private encapsulacion para que no podemos acceder a los atributos desde otra clase solo utilizando metodos
    private String tituloLibro;
    private int NumeroTotalLibro;//no puedo almacenar mas que 9999
    private int TamañoLibro;//no puede almacenar mas 10MB
    private int NumeroPaginaActual;

    //constrectores
    public LibroElectronico() {//constrector por defecto       
        this.identificador = RandomStringUtils.randomNumeric(3);//entre 000 y 999
        int identificador = Integer.parseInt(this.identificador);

        if ((identificador < 000 || identificador > 999)) {

            identificador = 000;
        }
        this.identificador = "" + identificador;
        this.tituloLibro = "Don Quijote de la Mancha";
        this.TamañoLibro = 5;
        this.NumeroPaginaActual = 1435;
        this.NumeroPaginaActual=1;
    }

    //constrector parametrizado
    public LibroElectronico(String identificador, String tituloLibro, int NumeroTotalLibro, int TamañoLibro, int NumeroPaginaActual) {
        this.identificador = identificador;//entre 000 y 999
        int ident = Integer.parseInt(this.identificador);

        if ((ident < 000 || ident > 999)) {
            ident = 000;
        }
        this.identificador = "" + identificador;
        this.tituloLibro = tituloLibro;

        this.NumeroTotalLibro = NumeroTotalLibro;
        if (this.NumeroTotalLibro > 9999) {
            this.NumeroTotalLibro = 9999;
        }
        this.TamañoLibro = TamañoLibro;
        if (this.TamañoLibro > 10) {
            this.TamañoLibro = 0;
        }
        this.NumeroPaginaActual = NumeroPaginaActual;
        if (this.NumeroPaginaActual < 0 || this.NumeroPaginaActual > 9999) {
            this.NumeroPaginaActual = 0;
        }
         
    }

    //getters y setters 
    public String getTituloLibro() {//metodos getters y setters son public para que podemos utilizarlo en otras classes por acceder a los atributos atraver de ellos
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public int getNumeroTotalLibro() {
        return NumeroTotalLibro;
    }

    public int getTamañoLibro() {
        return TamañoLibro;
    }

    public void setTamañoLibro(int TamañoLibro) {
        this.TamañoLibro = TamañoLibro;
        if (this.TamañoLibro > 10) {
            this.TamañoLibro = 0;
        }
    }

    public int getNumeroPaginaActual() {
        if (this.NumeroPaginaActual < 0 || this.NumeroPaginaActual > 9999) {//porque condition?
            this.NumeroPaginaActual = 0;
        }
        return NumeroPaginaActual;
    }

    public void setNumeroTotalLibro(int NumeroTotalLibro) {
        this.NumeroTotalLibro = NumeroTotalLibro;
        if (this.NumeroTotalLibro > 9999) {
            this.NumeroTotalLibro = 9999;
        }
    }

    //toString
    @Override
    public String toString() {
        return "LibroElectronico{" + "identificador=" + identificador + ", tituloLibro=" + tituloLibro + ", NumeroTotalLibro=" + NumeroTotalLibro + ", Tama\u00f1oLibro=" + TamañoLibro + ", NumeroPaginaActual=" + NumeroPaginaActual + '}';
    }

    public void PasarPagina(int numeroPagina) {
        this.NumeroPaginaActual = this.NumeroPaginaActual;
        this.NumeroTotalLibro = this.NumeroPaginaActual;
        if (this.NumeroPaginaActual < 0 || this.NumeroPaginaActual > 9999) {
            throw new IllegalArgumentException("NumeroPaginaActual no puede ser fuera del rango del NumeroTotalLibro ");
        } else {
            if ((this.NumeroPaginaActual += numeroPagina) > this.NumeroTotalLibro) {
                NumeroPaginaActual = 1;//no podemos pasar a un pagina mas que el tamaño del libro volvemos a la pagina 1
            }else if((this.NumeroPaginaActual += numeroPagina) < this.NumeroTotalLibro) {
                this.NumeroPaginaActual += numeroPagina;
            }
        }

    }

    public void retrocederPagina(int numeroPaginaRetroc) {//
        this.NumeroPaginaActual = Math.abs(this.NumeroPaginaActual);
        if (this.NumeroPaginaActual < 0 || this.NumeroPaginaActual > 9999) {
             throw new IllegalArgumentException("NumeroPaginaActual no puede ser fuera del rango del NumeroTotalLibro ");
        } else {
            if(this.NumeroPaginaActual>=numeroPaginaRetroc){
              this.NumeroPaginaActual-= numeroPaginaRetroc;  
            }else{
                this.NumeroPaginaActual=0;
            }
            
        }
    }

    public void saltar(int numero) {
        this.NumeroPaginaActual = this.NumeroPaginaActual;
        if (this.NumeroPaginaActual < 0 || this.NumeroPaginaActual > 9999) {
            this.NumeroPaginaActual = 0;//eso no es necessario
        } else {
            if (numero > 0) {
                if ((this.NumeroPaginaActual += numero) > 9999) {//9999 es total de paginas cambialo
                    this.NumeroPaginaActual = 0;
                } else {
                    this.NumeroPaginaActual += numero;
                }

            } else if (numero < 0) {
                if ((this.NumeroPaginaActual -= numero) < 0) {
                    this.NumeroPaginaActual = 0;
                } else {
                    this.NumeroPaginaActual -= numero;
                }
            }
        }

    }
}
