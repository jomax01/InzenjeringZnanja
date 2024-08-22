package similarity;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

import java.io.File;
import java.io.FileNotFoundException;


public class SimilarComputerFinder {

    public static void main(String[] args) {
        try {
            // Ručno navedi putanju do ontologije
            String filePath = "/WEB-INF/resources/ontologyIZ.rdf"; // Unesite apsolutnu putanju do ontologije
            
            // Kreiramo instancu ComputerOntologyDAO sa apsolutnom putanjom
            ComputerOntologyDAO ontologyDAO = new ComputerOntologyDAO(new File(filePath));
            CaseRetrieval caseRetrieval = new CaseRetrieval(ontologyDAO);

            // Primer kako pronaći najsličniji računar zadatom računaru
            OWLNamedIndividual targetComputer = ontologyDAO.getIndividual("SomeComputerInstance");

            if (targetComputer != null) {
                OWLNamedIndividual mostSimilar = caseRetrieval.findMostSimilar(targetComputer);

                if (mostSimilar != null) {
                    System.out.println("Most similar computer: " + mostSimilar);
                } else {
                    System.out.println("No similar computers found.");
                }
            } else {
                System.out.println("Target computer instance not found.");
            }
        } catch (OWLOntologyCreationException e) {
            System.err.println("Error creating ontology: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("Ontology file not found: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
