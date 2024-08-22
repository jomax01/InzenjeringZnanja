package similarity;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Set;
import java.util.stream.Collectors;

public class ComputerOntologyDAO {
    private OWLOntology ontology;
    private OWLDataFactory dataFactory;
    private OWLOntologyManager manager;

    // Konstruktor koji prihvata File
    public ComputerOntologyDAO(File file) throws OWLOntologyCreationException, FileNotFoundException {
        manager = OWLManager.createOWLOntologyManager();
        
        System.out.println("Looking for ontology at: " + file.getAbsolutePath());
        
        if (!file.exists()) {
            throw new FileNotFoundException("Ontology file not found at: " + file.getAbsolutePath());
        }

        // Učitaj ontologiju
        try {
            ontology = manager.loadOntologyFromOntologyDocument(file);
            dataFactory = manager.getOWLDataFactory();
        } catch (OWLOntologyCreationException e) {
            System.err.println("Failed to load ontology: " + e.getMessage());
            throw e;
        }
    }

    public void addComputerInstance(String instanceName, String cpuType, String memoryType, String gpuType, String chipsetType, String storageType) {
        OWLNamedIndividual computerInstance = dataFactory.getOWLNamedIndividual(IRI.create("http://www.semanticweb.org/nina/ontologies/2024/6/untitled-ontology-8#" + instanceName));

        OWLNamedIndividual cpuInstance = dataFactory.getOWLNamedIndividual(IRI.create("http://www.semanticweb.org/nina/ontologies/2024/6/untitled-ontology-8#" + cpuType));
        OWLNamedIndividual memoryInstance = dataFactory.getOWLNamedIndividual(IRI.create("http://www.semanticweb.org/nina/ontologies/2024/6/untitled-ontology-8#" + memoryType));
        OWLNamedIndividual gpuInstance = dataFactory.getOWLNamedIndividual(IRI.create("http://www.semanticweb.org/nina/ontologies/2024/6/untitled-ontology-8#" + gpuType));
        OWLNamedIndividual chipsetInstance = dataFactory.getOWLNamedIndividual(IRI.create("http://www.semanticweb.org/nina/ontologies/2024/6/untitled-ontology-8#" + chipsetType));
        OWLNamedIndividual storageInstance = dataFactory.getOWLNamedIndividual(IRI.create("http://www.semanticweb.org/nina/ontologies/2024/6/untitled-ontology-8#" + storageType));

        // Dodavanje instance računara u ontologiju
        OWLAxiom axiom = dataFactory.getOWLClassAssertionAxiom(dataFactory.getOWLClass(IRI.create("http://www.semanticweb.org/nina/ontologies/2024/6/untitled-ontology-8#PC")), computerInstance);
        manager.addAxiom(ontology, axiom);

        // Povezivanje svojstava kao što su "hasCPU", "hasMemory", itd.
        linkIndividualToProperty(computerInstance, cpuInstance, "hasCPU");
        linkIndividualToProperty(computerInstance, memoryInstance, "hasMemory");
        linkIndividualToProperty(computerInstance, gpuInstance, "hasGPU");
        linkIndividualToProperty(computerInstance, chipsetInstance, "hasChipset");
        linkIndividualToProperty(computerInstance, storageInstance, "hasStorage");

        saveOntology();
    }

    private void linkIndividualToProperty(OWLNamedIndividual subject, OWLNamedIndividual object, String propertyName) {
        OWLObjectProperty property = dataFactory.getOWLObjectProperty(IRI.create("http://www.semanticweb.org/nina/ontologies/2024/6/untitled-ontology-8#" + propertyName));
        OWLObjectPropertyAssertionAxiom axiom = dataFactory.getOWLObjectPropertyAssertionAxiom(property, subject, object);
        manager.addAxiom(ontology, axiom);
    }

    public void saveOntology() {
        try {
            manager.saveOntology(ontology);
        } catch (OWLOntologyStorageException e) {
            System.err.println("Error saving ontology: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Set<OWLNamedIndividual> getAllComputers() {
        OWLClass computerClass = dataFactory.getOWLClass(IRI.create("http://www.semanticweb.org/nina/ontologies/2024/6/untitled-ontology-8#PC"));
        return ontology.getIndividualsInSignature()
                .stream()
                .filter(ind -> ontology.getClassAssertionAxioms(computerClass)
                        .stream()
                        .anyMatch(axiom -> axiom.getIndividual().equals(ind)))
                .collect(Collectors.toSet());
    }

    public OWLDataFactory getOWLDataFactory() {
        return dataFactory;
    }

    public OWLNamedIndividual getRelatedIndividual(OWLNamedIndividual subject, OWLObjectProperty property) {
        return ontology.getObjectPropertyAssertionAxioms(subject)
                .stream()
                .filter(axiom -> axiom.getProperty().equals(property))
                .map(OWLObjectPropertyAssertionAxiom::getObject)
                .filter(OWLNamedIndividual.class::isInstance)
                .map(OWLNamedIndividual.class::cast)
                .findFirst()
                .orElse(null);
    }

    public OWLNamedIndividual getIndividual(String individualName) {
        return ontology.getIndividualsInSignature()
                .stream()
                .filter(ind -> ind.getIRI().toString().endsWith(individualName))
                .findFirst()
                .orElse(null);
    }

    public OWLNamedIndividual createComputerInstance(String cpuCores, String memorySize, String diskSpeed,
            String powerSupply, String gpuModel) {

        // Proverite da li su parametri null
        if (cpuCores == null || memorySize == null || diskSpeed == null || powerSupply == null || gpuModel == null) {
            throw new IllegalArgumentException("None of the computer specifications can be null.");
        }

        // Kreiramo jedinstveno ime za instancu računara
        String instanceName = "Computer_" + cpuCores + "_" + memorySize + "_" + diskSpeed + "_" + powerSupply + "_" + gpuModel;

        // Kreiramo instancu za klasu računara (PC)
        OWLClass computerClass = dataFactory.getOWLClass(IRI.create("http://www.semanticweb.org/nina/ontologies/2024/6/untitled-ontology-8#PC"));
        OWLNamedIndividual computerInstance = dataFactory.getOWLNamedIndividual(IRI.create("http://www.semanticweb.org/nina/ontologies/2024/6/untitled-ontology-8#" + instanceName));

        // Dodajemo instancu u ontologiju
        OWLAxiom classAssertion = dataFactory.getOWLClassAssertionAxiom(computerClass, computerInstance);
        manager.addAxiom(ontology, classAssertion);

        // Dodajemo osobine računara kao atribute
        addDataProperty(computerInstance, "hasCPUCores", cpuCores);
        addDataProperty(computerInstance, "hasMemorySize", memorySize);
        addDataProperty(computerInstance, "hasDiskSpeed", diskSpeed);
        addDataProperty(computerInstance, "hasPowerSupply", powerSupply);
        addDataProperty(computerInstance, "hasGPUModel", gpuModel);

        // Spremamo izmene
        saveOntology();

        return computerInstance;
    }

    private void addDataProperty(OWLNamedIndividual individual, String propertyName, String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null for data property.");
        }
        OWLDataProperty property = dataFactory.getOWLDataProperty(IRI.create("http://www.semanticweb.org/nina/ontologies/2024/6/untitled-ontology-8#" + propertyName));
        OWLDataPropertyAssertionAxiom axiom = dataFactory.getOWLDataPropertyAssertionAxiom(property, individual, value);
        manager.addAxiom(ontology, axiom);
    }
}
