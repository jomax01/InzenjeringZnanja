package ontology;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLClass;

import java.io.File;
import java.util.Set;
import java.util.stream.Collectors;

public class OWXIntegration {

    public static void main(String[] args) {
        try {
            // Учитавање OWL/OWX онтологије
            File file = new File("resources/ontologyIZ.owl"); // Промените на вашу .owl/.owx датотеку
            OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
            OWLOntology ontology = manager.loadOntologyFromOntologyDocument(file);
            
            // Приказ успешног учитавања онтологије
            System.out.println("Онтологија је успешно учитана: " + ontology.getOntologyID());

            // Преглед свих класа у онтологији
            Set<OWLClass> classes = ontology.classesInSignature().collect(Collectors.toSet());
            System.out.println("Класе у онтологији:");
            for (OWLClass owlClass : classes) {
                System.out.println("Класа: " + owlClass.getIRI().getShortForm());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
