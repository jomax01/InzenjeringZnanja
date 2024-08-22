package EvaluateServlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fuzzysystem.FuzzySystemDAO;

@WebServlet("/EvaluateServlet")
public class EvaluateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EvaluateServlet() {
        super();
    }

    // Обрада POST захтева (података послатих из форме)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Преузимање вредности из форме
            int cpuCores = Integer.parseInt(request.getParameter("cpuCores"));
            int memorySize = Integer.parseInt(request.getParameter("memorySize"));
            int diskSpeed = Integer.parseInt(request.getParameter("diskSpeed"));
            int powerSupply = Integer.parseInt(request.getParameter("powerSupply"));
            String gpuModel = request.getParameter("gpuModel");

            // Путања до .fcl датотеке
            String fileName = getServletContext().getRealPath("/WEB-INF/resources/computerEvaluation.fcl");

            // Креирање објекта FuzzySystemDAO и извршавање фази система
            FuzzySystemDAO fuzzySystem = new FuzzySystemDAO();
            
            // Резултати за све намене
            Map<String, Double> results = new HashMap<>();
            results.put("homeUseSuitability", fuzzySystem.evaluateComputer(fileName, cpuCores, memorySize, diskSpeed, powerSupply, "home", gpuModel));
            results.put("businessUseSuitability", fuzzySystem.evaluateComputer(fileName, cpuCores, memorySize, diskSpeed, powerSupply, "business", gpuModel));
            results.put("gamingSuitability", fuzzySystem.evaluateComputer(fileName, cpuCores, memorySize, diskSpeed, powerSupply, "gaming", gpuModel));
            results.put("miningSuitability", fuzzySystem.evaluateComputer(fileName, cpuCores, memorySize, diskSpeed, powerSupply, "mining", gpuModel));
            results.put("hostingSuitability", fuzzySystem.evaluateComputer(fileName, cpuCores, memorySize, diskSpeed, powerSupply, "hosting", gpuModel));

            // Постављање резултата у атрибуте захтева
            request.setAttribute("results", results);

            // Прослеђивање резултата на index.jsp страницу
            request.getRequestDispatcher("/evaluatePage.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            // Руковање грешкама ако корисник унесе невалидне бројеве
            response.getWriter().println("<h1>Error: Please enter valid numbers for CPU cores, memory size, disk speed, and power supply!</h1>");
        }
    }

    // Ово ти није потребно за POST захтеве, али можеш оставити као референцу
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
}
