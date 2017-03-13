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
public class Treino {

    private PerceptronPorReforco a;
    private PerceptronPorReforco b;
    private PerceptronPorReforco c;

    public Treino() {
    }

    public Treino(PerceptronPorReforco a, PerceptronPorReforco b, PerceptronPorReforco c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public PerceptronPorReforco getA() {
        return a;
    }

    public void setA(PerceptronPorReforco a) {
        this.a = a;
    }

    public PerceptronPorReforco getB() {
        return b;
    }

    public void setB(PerceptronPorReforco b) {
        this.b = b;
    }

    public PerceptronPorReforco getC() {
        return c;
    }

    public void setC(PerceptronPorReforco c) {
        this.c = c;
    }

    public void treinar(int max) {
        int epoca = 1;
        int linha = 0;//controla os perceptrons
        int coluna = 0;//contro a qual pesos serão trocados
        boolean[] error = new boolean[4];
        int erro;
        do {
            for (int i = 0; i < 4; i++) {
                a.trinar(i);
                b.trinar(i);
                c.setEntrada(a.getSaida(i), 0, i);//x0
                c.setEntrada(b.getSaida(i), 1, i);//x1
                c.setEntrada(1, 2, i);//x2
                // tenho que informar a saida desejavel;
                c.trinar(i);
                c.estaerrado(i);
                if (c.getErro()) {
                    error[i] = true;
                    int e;
                    e = c.getDesejavel()[i] - c.getSaida(i);
                    if (linha == 0) {
                        c.atualizar_peso(coluna, i, e);
                        coluna++;
                    } else {
                        if (linha == 1) {
                            a.atualizar_peso(coluna, i, e);
                            coluna++;
                        } else {
                            if (linha == 2) {
                                b.atualizar_peso(coluna, i, e);
                                coluna++;
                            }
                        }
                    }
                    linha++;
                    if (coluna > 2) {
                        coluna = 0;
                    }
                    if (linha > 2) {
                        linha = 0;
                    }
                }

            }
            epoca++;
            erro = 0;
            for (boolean err : error) {
                if (err) {
                    erro++;
                }
            }
        } while (erro > 0 && epoca < max);
        System.out.println("Quantidade de epocas percorridas: "+epoca);
        System.out.println("C: " + Arrays.toString(c.getPesos()) + "\nA: " + Arrays.toString(a.getPesos()) + "\nB: " + Arrays.toString(c.getPesos()));
    }

}
