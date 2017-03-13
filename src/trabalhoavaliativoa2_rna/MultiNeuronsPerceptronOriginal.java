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
public class MultiNeuronsPerceptronOriginal {
    
    private String rotulo;
    private int[][] entrada;//2x4
    private double[] pesos;//1x2
    private double bias; // 
    private double a; // taxa de atualização
    private int[] desejavel;//1x4
    private int[] saida;//1x4
    private boolean erro;

    public MultiNeuronsPerceptronOriginal() {
        this.saida=new int[4];
        
    }

    public MultiNeuronsPerceptronOriginal(String rotulo, int[][] entrada, double[] pesos, double bias, double a, int[] desejavel) {
        this.rotulo = rotulo;
        this.entrada = entrada;
        this.pesos = pesos;
        this.bias = bias;
        this.a = a;
        this.desejavel = desejavel;        
        this.saida=new int[4];
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

    public double getBias() {
        return bias;
    }

    public void setBias(double bias) {
        this.bias = bias;
    }

    /*
    public int getMax_it() {
        return max_it;
    }

    public void setMax_it(int max_it) {
        this.max_it = max_it;
    }
     */
    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public int[] getDesejavel() {
        return desejavel;
    }

    public void setDesejavel(int[] desejavel) {
        this.desejavel = desejavel;
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

    @Override
    public String toString() {
        return "MultiNeuronsPerceptron{" + "entrada=" + entrada + ", pesos=" + pesos + ", bias=" + bias + /*", QTDE maxima de iterações=" + max_it + */ ", taxa de atualização=" + a + ", saida desejavel=" + desejavel + ", saida=" + saida + '}';
    }

    public void trinar() {
        double[] u = new double[this.saida.length];
        int[] e =new int[this.saida.length];
        for (int i = 0; i < this.entrada.length; i++) {
            u[i] = (entrada[0][i] * this.pesos[0] + entrada[1][i] * this.pesos[1] + this.bias);
            System.out.println("Neuronio "+rotulo+": entrada %d:["+entrada[0][i]
                    +" "+ entrada[1][i]+"], w1="+entrada[0][i]+"."+ pesos[0]
                    +" + w2="+entrada[1][i]+"."+ pesos[1]+" + "+bias+" = "+u[i]+" y="+saida[i]+" ==> "+ ((desejavel[i]==saida[i])? "correto.":"incorreto."));
            this.saida[i] = f(u[i]);
            e[i] = this.desejavel[i] - this.saida[i];
            if (e[i] != 0) {
                this.erro=true;
                System.out.printf("Correção dos pesos %.2f para %s: ", this.a, e[i]>0? "cima":"baixo");
                for(int j=0;j<pesos.length;j++){
                    System.out.printf("w%d=%.2f para ", j++, pesos[j]);
                    pesos[j]+=this.a*e[i]*this.entrada[j][i];
                    System.out.printf("w%.2f, ", pesos[j++]);
                }
                System.out.printf("bias=%.2f para ", this.bias);
                this.bias+=this.a*e[i];
                System.out.printf("%.2f.\n", this.bias);
            }else{
                this.erro=false;
            }
        }
        
    }

    private int f(double u) {
        if (u >= 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
