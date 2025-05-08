import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;
public class Agenetico  {
    //cromosomas es un arreglo de genes
    public void configurar(int genes, int poblacionInicial,int iteracionesGeneracion,
    int evolucion) {

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
    private void conf_poblacion(Configuration config, int poblacionInicial,int iteracionGenerecion , int evolucion){

        try {
            config.setPopulationSize(poblacionInicial);
            Genotype poblacion = Genotype.randomInitialGenotype(config);
        } catch (InvalidConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            
    }
    public void evolucionar(Genotype poblacion, int iteracionGenerecion , int evolucion ){ 
        ver_poblacion(poblacion.getChromosomes());
        for (int i = 0; i < iteracionGenerecion ; i++ ){
            poblacion.evolve(evolucion);
           ver_individuo(poblacion.getFittestChromosome()); //obtener al mejhor individuo
        }
       System.out.println("Optimo: ");
       ver_individuo(poblacion.getFittestChromosome());
    }

    private void ver_poblacion  (IChromosome[] ic){
     System.out.println("----------------Poblacion----------");
     for (IChromosome iChromosome : ic){
        ver_individuo(iChromosome);
     }
     System.out.println("----------------------------");
    }
    private void ver_individuo (IChromosome ic){

        System.out.println("**********individuo*********");
        int signoX = (int)ic.getGene(0).getAllele();
        int x1 = (int)ic.getGene(1).getAllele();
        int x2 = (int)ic.getGene(2).getAllele();
        int x3 = (int)ic.getGene(3).getAllele();
        int x4 = (int)ic.getGene(4).getAllele();

        int signoY = (int)ic.getGene(5).getAllele();
        int y1 = (int)ic.getGene(6).getAllele();
        int y2 = (int)ic.getGene(7).getAllele();
        int y3 = (int)ic.getGene(8).getAllele();
        int y4 = (int)ic.getGene(9).getAllele();
        
        int x_valor = Integer.parseInt ("x1"+"x2"+"x3"+"x4");
        int y_valor = Integer.parseInt ("y1"+"y2"+"y3"+"y4");


        if (signoX == 0 ){
            x_valor = -x_valor;
        }
        if (signoY == 0 ){
            y_valor = -y_valor;
        }
        System.out.println("");
    }
}