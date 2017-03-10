/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoavaliativoa2_rna;

/**
 *
 * @author Ederson
 */
public class Perceptron {

    private int[][] xa;//entradas
    private int[][] xb;//entradas
    private double[] wa;//peso
    private double[] wb;//peso
    private double[] wc;//peso
    private int[] da;//desejavel
    private int[] db;//desejavel
    private int[] dc;//desejavel
    private double a;
    private int max_int;

    /*public Perceptron(int[][] x, double[] w, int[] d, double a, double e, int max_int) {
        this.x = x;//entradas
        this.w = w;//peso
        this.d = d;//desejavel
        this.a = a;//taxa da aprendixagem
        this.e = e;//margem de erro
        
        this.max_int = max_int;
    }*/
    public Perceptron(int[][] xa, int[][] xb, double[] wa, double[] wb, double[] wc, int[] da, int[] db, int[] dc, double a, int max_int) {
        this.xa = xa;
        this.xb = xb;
        this.wa = wa;
        this.wb = wb;
        this.wc = wc;
        this.da = da;
        this.db = db;
        this.dc = dc;
        this.a = a;
      
        this.max_int = max_int;
    }

    public void treinar() {

        int[] ya = new int[4];//saida
        int[] yb = new int[4];//saida
        double ua = 0;
        double ub = 0;
        double uc = 0;
        int epocas = 0, yc = 0, ordem = 0;
        boolean continua = true;
        while ((epocas < this.max_int) && (continua)) {
            continua = false;
            System.out.println("Época = "+epocas+"\n");
            for (int i = 0; i < this.xa[0].length; i++) {
                //x1*w1+x2*w2+w0 
                ua = this.xa[0][i] * this.wa[0] + this.xa[1][i] * this.wa[1] + this.wa[2];

                //Calculando a saída
                if (ua >= 0) {
                    ya[i] = 1;
                } else {
                    ya[i] = 0;
                }

                //Mostrando a aprendizagem
                System.out.println("A: entrada"+i+"(" + this.xa[0][i]
                        + "  ," + this.xa[1][i]
                        + ") u="+ua
                        + " y=" + ya[i]
                        + "  wa_1=" + this.wa[0]
                        + "  wa_2=" + this.wa[1]
                        + "  wa_0=" + this.wa[2]);

                //Comparando a saída obtida com a desejável
                if ((ya[i] == 1) && (this.da[i] == 0)) {
                    ajustar_pesos(false, this.wa, ordem); //Deve diminuir os pesos
                    System.out.printf("Correção dos pesos de 0.1 para baixo  A{ %f, %f, %f}\n", wa[0],wa[1],wa[2]);
                    ordem++;
                    continua = true;
                } else if ((ya[i] == 0) && (this.da[i] == 1)) {
                    ajustar_pesos(true, this.wa, ordem); //Deve aumentar os pesos
                    System.out.printf("Correção dos pesos de 0.1 para cima  A{ %f, %f, %f}\n", wa[0],wa[1],wa[2]);
                    ordem++;
                    continua = true;
                }
                if (ordem >= this.wa.length) {
                    ordem = 0;
                }

                ub = this.xb[0][i] * this.wb[0] + this.xb[1][i] * this.wb[1] + this.wb[2];
                //Calculando a saída
                if (ub >= 0) {
                    yb[i] = 1;
                } else {
                    yb[i] = 0;
                }
                //Mostrando a aprendizagem
                System.out.println("B: entrada"+i+"(" + this.xb[0][i]
                        + "  ," + this.xb[1][i]
                        + ") u= "+ub
                        + " y=" + yb[i]
                        + "  w_1=" + this.wb[0]
                        + "  w_2=" + this.wb[1]
                        + "  w_0=" + this.wb[2]);

                //Comparando a saída obtida com a desejável
                if ((yb[i] == 1) && (this.db[i] == 0)) {
                    ajustar_pesos(false, this.wb, ordem); //Deve diminuir os pesos
                    System.out.printf("Correção dos pesos de 0.1 para baixo  B{ %f, %f, %f}\n", wb[0],wb[1],wb[2]);
                    ordem++;
                    continua = true;
                } else if ((yb[i] == 0) && (this.db[i] == 1)) {
                    ajustar_pesos(true, this.wb, ordem); //Deve aumentar os pesos
                    System.out.printf("Correção dos pesos de 0.1 para cima  B{ %f, %f, %f}\n", wb[0],wb[1],wb[2]);
                    ordem++;
                    continua = true;
                }
                if (ordem >= this.wb.length) {
                    ordem = 0;
                }

                uc = ya[i] * this.wc[0] + yb[i] * this.wc[1] + this.wc[2];

                //Calculando a saída
                if (uc >= 0) {
                    yc = 1;
                } else {
                    yc = 0;
                }

                //Mostrando a aprendizagem
                System.out.println("C: entrada"+i+"(" + ya[i]
                        + "  ," + yb[i]
                        + ") u="+uc
                        + "  y=" + yc
                        + "  w_1=" + this.wc[0]
                        + "  w_2=" + this.wc[1]
                        + "  w_0=" + this.wc[2]);

                //Comparando a saída obtida com a desejável
                if ((yc == 1) && (this.dc[i] == 0)) {
                    ajustar_pesos(false, this.wc, ordem); //Deve diminuir os pesos
                    System.out.printf("Correção dos pesos de 0.1 para baixo  C{ %f, %f, %f}\n", wc[0],wc[1],wc[2]);
                    ordem++;
                    continua = true;
                } else if ((yc == 0) && (this.dc[i] == 1)) {
                    ajustar_pesos(true, this.wc, ordem); //Deve aumentar os pesos
                    System.out.printf("Correção dos pesos de 0.1 para cima  C{ %f, %f, %f}\n", wc[0],wc[1],wc[2]);
                    ordem++;
                    continua = true;
                }
                if (ordem >= this.wc.length) {
                    ordem = 0;
                }
            }
            System.out.println("_____________________________");
            epocas++;
        }
        if(epocas<max_int){
            System.out.printf("W de A{ %f, %f, %f}\n", wa[0],wa[1],wa[2]);
            System.out.printf("W de B{ %f, %f, %f}\n", wb[0],wb[1],wb[2]);
            System.out.printf("W de C{ %f, %f, %f}\n", wc[0],wc[1],wc[2]);
        }
    }

    private void ajustar_pesos(boolean aumentar, double [] pesos, int ordem) {
        if (aumentar) {
            pesos[ordem] += this.a;
        } else {
            pesos[ordem] -= this.a;
        }
    }
}
