package SimilarityServlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import similarity.CSVLoader;
import similarity.CaseRetrieval;
import similarity.Computer;

@WebServlet("/SimilarityServlet")
public class SimilarityServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SimilarityServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Preuzimanje podataka iz forme
        String cpu = request.getParameter("cpu");
        int ram = Integer.parseInt(request.getParameter("ram"));
        int storage = Integer.parseInt(request.getParameter("storage"));
        String gpu = request.getParameter("gpu");
        String chipset = request.getParameter("chipset");

        // Putanja do CSV datoteke
        String csvFilePath = getServletContext().getRealPath("/WEB-INF/resources/Database.csv");

        // Kreiraj CSVLoader instancu i učitaj bazu računara
        CSVLoader csvLoader = new CSVLoader();
        List<Computer> computerDatabase;

        try {
            // Učitaj bazu računara iz CSV fajla
            computerDatabase = csvLoader.loadComputersFromCSV(csvFilePath);

            // Kreiraj target računar za koji tražimo slične
            Computer targetComputer = new Computer(cpu, ram, storage, gpu, chipset);

            // Kreiraj CaseRetrieval instancu
            CaseRetrieval caseRetrieval = new CaseRetrieval();

            // Pronađi najsličnije računare (npr. 3 rezultata)
            List<Computer> similarComputers = caseRetrieval.retrieveMostSimilar(targetComputer, computerDatabase, 3);

            // Postavi rezultate kao atribut zahteva
            request.setAttribute("similarComputers", similarComputers);

            // Prosledi rezultate na JSP stranicu
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
            response.getWriter().println("Error reading the database file.");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
