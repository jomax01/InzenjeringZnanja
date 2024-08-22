package similarity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;

public class CaseRetrieval {

    private ComputerOntologyDAO ontologyDAO;

    // Težinski faktori kao konstante
    private static final double CPU_WEIGHT = 0.3;
    private static final double MEMORY_WEIGHT = 0.2;
    private static final double GPU_WEIGHT = 0.2;
    private static final double CHIPSET_WEIGHT = 0.15;
    private static final double STORAGE_WEIGHT = 0.15;
    private static final double SIMILARITY_THRESHOLD = 0.8;

    public CaseRetrieval(ComputerOntologyDAO ontologyDAO) {
        this.ontologyDAO = ontologyDAO;
    }

    public double compareComputers(OWLNamedIndividual computer1, OWLNamedIndividual computer2) {
        double similarity = 0.0;

        similarity += compareComponent(computer1, computer2, "hasCPU", CPU_WEIGHT);
        similarity += compareComponent(computer1, computer2, "hasMemory", MEMORY_WEIGHT);
        similarity += compareComponent(computer1, computer2, "hasGPU", GPU_WEIGHT);
        similarity += compareComponent(computer1, computer2, "hasChipset", CHIPSET_WEIGHT);
        similarity += compareComponent(computer1, computer2, "hasStorage", STORAGE_WEIGHT);

        return similarity;
    }

    private double compareComponent(OWLNamedIndividual computer1, OWLNamedIndividual computer2, String propertyName, double weight) {
        OWLObjectProperty property = ontologyDAO.getOWLDataFactory().getOWLObjectProperty(IRI.create("http://www.semanticweb.org/nina/ontologies/2024/6/untitled-ontology-8#" + propertyName));
        OWLNamedIndividual component1 = ontologyDAO.getRelatedIndividual(computer1, property);
        OWLNamedIndividual component2 = ontologyDAO.getRelatedIndividual(computer2, property);
        
        if (component1 != null && component2 != null && component1.equals(component2)) {
            return weight;
        } else if (component1 == null && component2 == null) {
            return weight * 0.5;
        }
        return 0.0;
    }

    public OWLNamedIndividual findMostSimilar(OWLNamedIndividual targetComputer) {
        Set<OWLNamedIndividual> allComputers = ontologyDAO.getAllComputers();
        OWLNamedIndividual mostSimilar = null;
        double maxSimilarity = 0;

        for (OWLNamedIndividual computer : allComputers) {
            if (!computer.equals(targetComputer)) {
                double similarity = compareComputers(targetComputer, computer);
                if (similarity > maxSimilarity) {
                    maxSimilarity = similarity;
                    mostSimilar = computer;
                }
            }
        }

        return mostSimilar;
    }

    public List<OWLNamedIndividual> findSimilarComputers(OWLNamedIndividual targetComputer) {
        List<OWLNamedIndividual> similarComputers = new ArrayList<>();
        Set<OWLNamedIndividual> allComputers = ontologyDAO.getAllComputers();

        for (OWLNamedIndividual computer : allComputers) {
            if (!computer.equals(targetComputer)) {
                double similarity = compareComputers(targetComputer, computer);
                if (similarity >= SIMILARITY_THRESHOLD) {
                    similarComputers.add(computer);
                }
            }
        }

        return similarComputers;
    }
}
