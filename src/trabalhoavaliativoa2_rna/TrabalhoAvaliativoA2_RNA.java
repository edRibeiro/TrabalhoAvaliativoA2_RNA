/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoavaliativoa2_rna;

import javax.swing.JOptionPane;

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
        int [][]xa = {{1,1,0,0},{0,1,0,1}};
        double []wa={0.0, 0.0, 0.0};
        int []da= {0,1,0,1};
        
        int [][]xb = {{0,0,1,1},{1,0,1,0}};
        double []wb={0.0, 0.0, 0.0};
        int []db= {0,0,1,0};
        
//        int [][]xc = {ya,yb};
        double []wc={0.0, 0.0, 0.0};
        int []dc= {0,1,1,1};
        
        Perceptron p = new Perceptron(xa, xb, wa, wb, wc, da, db, dc, 0.5, 10000);
        p.treinar();
        
        

    }

}
