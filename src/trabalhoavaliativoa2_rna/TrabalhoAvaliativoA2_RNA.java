/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoavaliativoa2_rna;

import java.util.Arrays;

/**
 *
 * @author lab1
 */
public class TrabalhoAvaliativoA2_RNA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] xa = {{1, 1, 0, 0}, {0, 1, 0, 1}};
        double[] wa = {0.5, 0.3, -0.1};
        int[] da = {0, 1, 0, 1};

        int[][] xb = {{0, 0, 1, 1}, {1, 0, 1, 0}};
        double[] wb = {0.5, 0.3, -0.6};
        int[] db = {0, 0, 1, 0};

//        int [][]xc = {ya,yb};
        double[] wc = {0.5, 0.3, -0.6};
        int[] dc = {0, 1, 1, 1};

        Perceptron p = new Perceptron(xa, xb, wa, wb, wc, da, db, dc, 0.5, 500);
        p.treinar();
//        double[] wpa = {0.5, 0.3};
//        double[] wpb = {0.5, 0.3};
        double a = 0.5;
//        MultiNeuronsPerceptronOriginal pa = new MultiNeuronsPerceptronOriginal("A", xa, wpa, -0.6, a, da);
//        MultiNeuronsPerceptronOriginal pb = new MultiNeuronsPerceptronOriginal("B", xb, wpb, -0.6, a, db);
//        MultiNeuronsPerceptronOriginal pc = new MultiNeuronsPerceptronOriginal();
//        pc.setA(a);
//        pc.setRotulo("C");
//        pc.setPesos(new double[]{-0.5, 0.3});
//        pc.setBias(0.4);
//        pc.setDesejavel(dc);
//
//        int epoca = 1, max_epocas = 500;
//        boolean erro = true;
//        do {
//            System.out.println("Epoca: " + epoca + "\n\n");
//            pa.trinar();
//            System.out.println(Arrays.toString(pa.getSaida()));
//            pb.trinar();
//            System.out.println(Arrays.toString(pb.getSaida()));
//            pc.setEntrada(new int[][]{pa.getSaida(), pb.getSaida()});
//            pc.trinar();
//            System.out.println(Arrays.toString(pc.getSaida()));
//            System.out.println("---------------------------------------------------------------------------");
//            epoca++;
//            if (!pc.getErro()) {
//                erro=false;
//                System.out.println(Arrays.toString(pa.getPesos()) + ", Bias=" + pa.getBias());
//                System.out.println(Arrays.toString(pb.getPesos()) + ", Bias=" + pb.getBias());
//                System.out.println(Arrays.toString(pc.getPesos()) + ", Bias=" + pc.getBias());
//            }
//        } while (erro && epoca <= max_epocas);
//        
//        System.out.println("--------------------------------------------------------------------------------------------");
//        
//        Treino t =new Treino();
//        PerceptronPorReforco pf_a;
//        PerceptronPorReforco pf_b;
//        PerceptronPorReforco pf_c;
        int [][] pfa = {{1, 1, 0, 0}, {0, 1, 0, 1}, {1,1,1,1}};
//        double[] pfwa = {0.5, 0.3, -0.1};
//        pf_a=new PerceptronPorReforco("A", pfa, pfwa, a);
//        t.setA(pf_a);
        int[][] pfb = {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 1, 1}};        
//        double[] pfwb = {0.5, 0.3, -0.6};
//        pf_b=new PerceptronPorReforco("B", pfb, pfwb, a);
//        t.setB(pf_b);
//        pf_c=new PerceptronPorReforco();
//        pf_c.setPesos(wc);
//        pf_c.setDesejavel(dc);
//        t.setC(pf_c);
//        t.treinar(1000);
        MultiNeuronsPerceptronPorReforco mp = new MultiNeuronsPerceptronPorReforco(pfa, pfb, wa, wb, wc, a, dc);
        mp.treinar(100);

    }

}
