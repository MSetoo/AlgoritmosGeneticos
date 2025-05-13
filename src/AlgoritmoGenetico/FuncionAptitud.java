package AlgoritmoGenetico;
import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

public class FuncionAptitud extends FitnessFunction {

    @Override
    protected double evaluate(IChromosome ic) {
        return evaluar(ic);
    }

    private double evaluar(IChromosome ic) {
        // Extraer los bits de X
        //int signoX = (int) ic.getGene(0).getAllele();
        int x1 = (int) ic.getGene(0).getAllele();
        int x2 = (int) ic.getGene(1).getAllele();
        int x3 = (int) ic.getGene(2).getAllele();
        int x4 = (int) ic.getGene(3).getAllele();

        // Extraer los bits de Y
        //int signoY = (int) ic.getGene(5).getAllele();
        int y1 = (int) ic.getGene(4).getAllele();
        int y2 = (int) ic.getGene(5).getAllele();
        int y3 = (int) ic.getGene(6).getAllele();
        int y4 = (int) ic.getGene(7).getAllele();

        int x_valor = Integer.parseInt("" + x1 + x2 + x3 + x4, 2);
        int y_valor = Integer.parseInt("" + y1 + y2 + y3 + y4, 2);

        // if (signoX == 0) x_valor = -x_valor;
        // if (signoY == 0) y_valor = -y_valor;

        
        if(x_valor == y_valor){
            return  0;
           }
           
           double fx = x_valor * x_valor -8 * x_valor + 7;
           double fy = y_valor * y_valor -8 * y_valor + 7;
           
        double error = Math.abs(fx) + Math.abs(fy);
        // if (fx== fy){
        //     error = 10;
        // }
        double score = 1000 - error * 100;
        return Math.max(score, 0);
        
        
    }
}
