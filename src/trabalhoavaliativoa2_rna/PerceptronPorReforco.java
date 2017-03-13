/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoavaliativoa2_rna;

/**
 *
 * @author AMD-FX
 */
public class PerceptronPorReforco {

    private String rotulo;
    private int[][] entrada;//2x4
    private double[] pesos;//1x2   
    private double a; // taxa de atualização
    private int[] saida;//1x4
    private boolean erro;
    private int[] desejavel;

    public PerceptronPorReforco() {
        this.entrada = new int[3][4];
        this.pesos = new double[3];
        this.a = a;
        this.saida = new int[4];

    }

    public PerceptronPorReforco(String rotulo, int[][] entrada, double[] pesos, double a) {
        this.rotulo = rotulo;
        this.entrada = entrada;
        this.pesos = pesos;
        this.a = a;
        this.saida = new int[4];
    }

    public String getRotulo() {
        return rotulo;
    }

    public void setRotulo(String rotulo) {
        this.rotulo = rotulo;
    }

    public int[][] getEntrada() {
        return entrada;
    }

    public void setEntrada(int[][] entrada) {
        this.entrada = entrada;
    }

    public double[] getPesos() {
        return pesos;
    }

    public void setPesos(double[] pesos) {
        this.pesos = pesos;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public boolean getErro() {
        return this.erro;
    }

    public void setErro(boolean erro) {
        this.erro = erro;
    }

    public int[] getSaida() {
        return saida;
    }

    public void setSaida(int[] saida) {
        this.saida = saida;
    }

    public int getEntrada(int i, int j) {
        return entrada[i][j];
    }

    public void setEntrada(int entrada, int i, int j) {
        this.entrada[i][j] = entrada;
    }

    public double getPesos(int i) {
        return pesos[i];
    }

    public void setPesos(double pesos, int i) {
        this.pesos[i] = pesos;
    }

    public int getSaida(int i) {
        return saida[i];
    }

    public void setSaida(int saida, int i) {
        this.saida[i] = saida;
    }

    public int[] getDesejavel() {
        return desejavel;
    }

    public void setDesejavel(int[] desejavel) {
        this.desejavel = desejavel;
    }

    @Override
    public String toString() {
        return "MultiNeuronsPerceptron{" + "entrada=" + entrada + ", pesos=" + pesos + ", taxa de atualização=" + a + ", saida=" + saida + '}';
    }

    public void trinar(int i) {
        double u = 0.0;
        for (double w : pesos) {
            u += entrada[0][i] * w;
        }
        //u = entrada[0][i] * pesos[0] + entrada[1][i] * pesos[1] + pesos[2];
        this.saida[i] = f(u);
    }

    public void atualizar_peso(int i, int j, int e) {
        if (i < pesos.length) {
            pesos[i] += a * (e) * entrada[i][j];
        }
    }

    public void estaerrado(int i) {
        erro = desejavel[i] != saida[i];
    }

    private int f(double u) {
        if (u >= 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
