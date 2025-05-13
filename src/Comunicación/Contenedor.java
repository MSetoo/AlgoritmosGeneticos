package Comunicación;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;

public class Contenedor {
    public void contenedor () {
        Runtime runtime = Runtime.instance();
        ProfileImpl profile = new ProfileImpl();
        AgentContainer agentContainer = runtime.createMainContainer(profile);
        
       agregarAgentes (agentContainer);

    }   public void agregarAgentes (AgentContainer agentContainer) {
        try {
            agentContainer.createNewAgent("Agente1", "Comunicación.Agente1", null).start();
            agentContainer.createNewAgent("Agente2", "Comunicación.Agente2", null).start();
            agentContainer.createNewAgent("Agente3", "Comunicación.Agente3", null).start();
        } catch (StaleProxyException e) {
            e.printStackTrace();
      }
      }   
    }