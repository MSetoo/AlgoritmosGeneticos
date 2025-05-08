import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;
public class Agenetico  {
    //cromosomas es un arreglo de genes
    public void configurar(int genes) {

        Configuration config = new  DefaultConfiguration();  
        FuncionAptitud fa = new FuncionAptitud();  
        try {
            config.setFitnessFunction(fa);
            Gene[]sampleGene= new Gene[genes]; //se crea un arreglo de genes de 10 elementos
            for (int i = 0; i < genes; i++) {
                sampleGene[i] = new IntegerGene(config, 0, 1); //se   crea un gen de tipo entero entre 0 y 100
            }
            Chromosome ic = new Chromosome(config, sampleGene); //se crea un cromosoma con 10 genes
            config.setSampleChromosome(ic); //muedtrsa de gen
        }catch (InvalidConfigurationException e) {
            e.printStackTrace();
        } 
       
    
    }
    public void conf_poblacion(Configuration config, int poblacionInicial){

        try {
            config.setPopulationSize(poblacionInicial);
            Genotype poblacion = Genotype.randomInitialGenotype(config);
        } catch (InvalidConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            
    }
}