/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoavaliativoa2_rna;

/**
 *
 * @author Tarcisio
 */
public class Perceptron {
    private int[][] xa;//entradas
    private int[][] xb;//entradas
    private double[] wa;//peso
    private double[] wb;//peso
    private double[] wc;//peso
    private int[]da;//desejavel
    private int[]db;//desejavel
    private int[]dc;//desejavel
    private double a, e;
    private int max_int;

    public Perceptron(int[][] x, double[] w, int[] d, double a, double e, int max_int) {
        this.x = x;//entradas
        this.w = w;//peso
        this.d = d;//desejavel
        this.a = a;//taxa da aprendixagem
        this.e = e;//margem de erro
        
        this.max_int = max_int;
    }
    
    public void treinar(){
        
        int[]ya=new int[4];//saida
        int[]yb=new int[4];//saida
        double ua=0;
        double ub=0;
        double uc=0;
        int epocas=0,y=0,ordem=0;
        boolean continua=true;
        while ((epocas<this.max_int)&&(continua)){
            continua=false;
            for (int i=0;i<this.x[0].length;i++){
                //x1*w1+x2*w2+w0 
                ua=this.x[0][i]*this.w[0] + this.x[1][i]*this.w[1] + this.w[2];
                
                //Calculando a saída
                if (ua>=0){
                    ya[i]=1;
                }else{
                    ya[i]=0;
                }
                //Calculando a saída
                if (ub>=0){
                    yb[i]=1;
                }else{
                    yb[i]=0;
                }
                
                uc=ya[i]*this.w[0] + yb[i]*this.w[1] + this.w[2];

                //Calculando a saída
                if (uc>=0){
                    y=1;
                }else{
                    y=0;
                }
                
                //Mostrando a aprendizagem
                System.out.println("(" + this.x[0][i] + 
                        "  ," + this.x[1][i] + 
                        ")  ="+y  +
                        "  w1="+ this.w[0] +
                         "  w2=" + this.w[1] +
                          "  w0=" + this.w[2]);
                
                //Comparando a saída obtida com a desejável
                if((y==1)&&(this.d[i]==0)){
                    ajustar_pesos(false,ordem); //Deve diminuir os pesos
                    ordem++;
                    continua=true;
                }else if ((y==0)&&(this.d[i]==1)){
                    ajustar_pesos(true,ordem); //Deve aumentar os pesos
                    ordem++;
                    continua=true;
                }
                if (ordem>=this.w.length){
                    ordem=0;
                }
            }
            System.out.println("_____________________________");
           epocas++;
        }
    }
    
    private void ajustar_pesos(boolean aumentar, int ordem){
        if (aumentar){
            this.w[ordem]+=this.a;
        }else{
            this.w[ordem]-=this.a;
        }
    }
}
