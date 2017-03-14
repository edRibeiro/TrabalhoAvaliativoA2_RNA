/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoavaliativoa2_rna;

import java.util.Arrays;

/**
 *
 * @author AMD-FX
 */
public class MultiNeuronsPerceptronPorReforco {

    private int[][] xa;//2x4
    private int[][] xb;//2x4
    private double[] wa;//1x2   
    private double[] wb;//1x2   
    private double[] wc;//1x2   
    private double a; // taxa de atualização
    private int[] ya;//1x4
    private int[] yb;//1x4
    private int[] yc;//1x4
//    private boolean erro;
    private int[] dc;

    public MultiNeuronsPerceptronPorReforco(int[][] xa, int[][] xb, double[] wa, double[] wb, double[] wc, double a, int[] dc) {
        this.xa = xa;
        this.xb = xb;
        this.wa = wa;
        this.wb = wb;
        this.wc = wc;
        this.a = a;
        this.ya = new int[4];
        this.yb = new int[4];
        this.yc = new int[4];
        this.dc = dc;
    }

    public void treinar(int max) {
        boolean continua = true;
        int epoca = 0, peso = 0, col = 0;
        boolean[] erro = new boolean[4];
        while (continua && epoca < max) {            
            for (int i = 0; i < 4; i++) {
                continua = false;
                double ua = 0.0, ub = 0.0, uc = 0.0;
                for (int j = 0; j < xa.length; j++) {
                    ua += xa[j][i] * wa[j];
                }
                ya[i] = f(ua);
                for (int j = 0; j < xb.length; j++) {
                    ua += xb[j][i] * wb[j];
                }
                yb[i] = f(ub);

                uc = ya[i] * wc[0] + yb[i] * wc[1] + wc[2];
                yc[i] = f(uc);
                int e;
                System.out.println("yc:"+Arrays.toString(yc));
                System.out.println("dc:"+Arrays.toString(dc));
                e = dc[i] - yc[i];
                if (e != 0) {
                    continua=true;
                    switch (peso) {
                        case 0:
                            System.out.println("de wc:"+Arrays.toString(wc));
                            wc[col] += a * e;
                            System.out.println("Para dc:"+Arrays.toString(wc));
                            col++;
                            break;
                        case 1:                            
                            System.out.println("de wa:"+Arrays.toString(wa));
                            wc[col] += a * e;
                            System.out.println("Para wa:"+Arrays.toString(wa));
                            col++;
                            break;
                        case 2:                            
                            System.out.println("de wb:"+Arrays.toString(wb));
                            wc[col] += a * e;
                            System.out.println("Para wb:"+Arrays.toString(wb));
                            col++;
                            break;
                        default:
                            break;
                    }
                    if (col >= 4) {
                        col = 0;
                        peso++;
                        if (peso >= 3) {
                            peso = 0;
                        }
                    }

                }
            }
            epoca++;
        }
        System.out.println("Quantidade de epocas percorridas: "+epoca);
        System.out.println("C: " + Arrays.toString(wc) + "\nA: " + Arrays.toString(wa) + "\nB: " + Arrays.toString(wb));
    
    }

    private int f(double u) {
        if (u >= 0) {
            return 1;
        } else {
            return 0;
        }
    }

}
