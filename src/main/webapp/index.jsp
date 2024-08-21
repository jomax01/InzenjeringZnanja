<%@ page import="java.util.Map" %>
<%@ page import="similarity.Computer" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>Computer Specification Input</title>
</head>
<body>
    <h1>Enter Computer Specifications for Evaluation</h1>
    <form action="EvaluateServlet" method="post">
        <!-- Унос за процесор (број језгара) -->
        <label for="cpuCores">CPU Cores:</label>
        <select id="cpuCores" name="cpuCores">
            <option value="2" <%= "2".equals(request.getParameter("cpuCores")) ? "selected" : "" %>>2</option>
            <option value="4" <%= "4".equals(request.getParameter("cpuCores")) ? "selected" : "" %>>4</option>
            <option value="6" <%= "6".equals(request.getParameter("cpuCores")) ? "selected" : "" %>>6</option>
            <option value="8" <%= "8".equals(request.getParameter("cpuCores")) ? "selected" : "" %>>8</option>
            <option value="10" <%= "10".equals(request.getParameter("cpuCores")) ? "selected" : "" %>>10</option>
            <option value="12" <%= "12".equals(request.getParameter("cpuCores")) ? "selected" : "" %>>12</option>
            <option value="14" <%= "14".equals(request.getParameter("cpuCores")) ? "selected" : "" %>>14</option>
            <option value="16" <%= "16".equals(request.getParameter("cpuCores")) ? "selected" : "" %>>16</option>
            <option value="18" <%= "18".equals(request.getParameter("cpuCores")) ? "selected" : "" %>>18</option>
            <option value="20" <%= "20".equals(request.getParameter("cpuCores")) ? "selected" : "" %>>20</option>
        </select><br>

        <!-- Унос за радну меморију -->
        <label for="memorySize">Memory Size (GB):</label>
        <select id="memorySize" name="memorySize">
            <option value="4" <%= "4".equals(request.getParameter("memorySize")) ? "selected" : "" %>>4 GB</option>
            <option value="8" <%= "8".equals(request.getParameter("memorySize")) ? "selected" : "" %>>8 GB</option>
            <option value="12" <%= "12".equals(request.getParameter("memorySize")) ? "selected" : "" %>>12 GB</option>
            <option value="16" <%= "16".equals(request.getParameter("memorySize")) ? "selected" : "" %>>16 GB</option>
            <option value="20" <%= "20".equals(request.getParameter("memorySize")) ? "selected" : "" %>>20 GB</option>
            <option value="24" <%= "24".equals(request.getParameter("memorySize")) ? "selected" : "" %>>24 GB</option>
            <option value="28" <%= "28".equals(request.getParameter("memorySize")) ? "selected" : "" %>>28 GB</option>
            <option value="32" <%= "32".equals(request.getParameter("memorySize")) ? "selected" : "" %>>32 GB</option>
            <option value="36" <%= "36".equals(request.getParameter("memorySize")) ? "selected" : "" %>>36 GB</option>
            <option value="40" <%= "40".equals(request.getParameter("memorySize")) ? "selected" : "" %>>40 GB</option>
        </select><br>

        <!-- Унос за брзину чврстог диска -->
        <label for="diskSpeed">Disk Speed (MB/s):</label>
        <select id="diskSpeed" name="diskSpeed">
            <option value="100" <%= "100".equals(request.getParameter("diskSpeed")) ? "selected" : "" %>>100 MB/s</option>
            <option value="200" <%= "200".equals(request.getParameter("diskSpeed")) ? "selected" : "" %>>200 MB/s</option>
            <option value="300" <%= "300".equals(request.getParameter("diskSpeed")) ? "selected" : "" %>>300 MB/s</option>
            <option value="400" <%= "400".equals(request.getParameter("diskSpeed")) ? "selected" : "" %>>400 MB/s</option>
            <option value="500" <%= "500".equals(request.getParameter("diskSpeed")) ? "selected" : "" %>>500 MB/s</option>
            <option value="600" <%= "600".equals(request.getParameter("diskSpeed")) ? "selected" : "" %>>600 MB/s</option>
            <option value="700" <%= "700".equals(request.getParameter("diskSpeed")) ? "selected" : "" %>>700 MB/s</option>
            <option value="800" <%= "800".equals(request.getParameter("diskSpeed")) ? "selected" : "" %>>800 MB/s</option>
            <option value="900" <%= "900".equals(request.getParameter("diskSpeed")) ? "selected" : "" %>>900 MB/s</option>
            <option value="1000" <%= "1000".equals(request.getParameter("diskSpeed")) ? "selected" : "" %>>1000 MB/s</option>
        </select><br>

        <!-- Унос за снагу напајања -->
        <label for="powerSupply">Power Supply (W):</label>
        <select id="powerSupply" name="powerSupply">
            <option value="300" <%= "300".equals(request.getParameter("powerSupply")) ? "selected" : "" %>>300 W</option>
            <option value="400" <%= "400".equals(request.getParameter("powerSupply")) ? "selected" : "" %>>400 W</option>
            <option value="500" <%= "500".equals(request.getParameter("powerSupply")) ? "selected" : "" %>>500 W</option>
            <option value="600" <%= "600".equals(request.getParameter("powerSupply")) ? "selected" : "" %>>600 W</option>
            <option value="700" <%= "700".equals(request.getParameter("powerSupply")) ? "selected" : "" %>>700 W</option>
            <option value="800" <%= "800".equals(request.getParameter("powerSupply")) ? "selected" : "" %>>800 W</option>
            <option value="900" <%= "900".equals(request.getParameter("powerSupply")) ? "selected" : "" %>>900 W</option>
            <option value="1000" <%= "1000".equals(request.getParameter("powerSupply")) ? "selected" : "" %>>1000 W</option>
            <option value="1200" <%= "1200".equals(request.getParameter("powerSupply")) ? "selected" : "" %>>1200 W</option>
        </select><br>

        <!-- Унос за графичку картицу -->
        <label for="gpuModel">GPU Model:</label>
        <select id="gpuModel" name="gpuModel">
            <option value="intel uhd 620" <%= "intel uhd 620".equals(request.getParameter("gpuModel")) ? "selected" : "" %>>Intel UHD 620</option>
            <option value="nvidia rtx 3060" <%= "nvidia rtx 3060".equals(request.getParameter("gpuModel")) ? "selected" : "" %>>Nvidia RTX 3060</option>
            <option value="amd radeon rx 580" <%= "amd radeon rx 580".equals(request.getParameter("gpuModel")) ? "selected" : "" %>>AMD Radeon RX 580</option>
            <option value="nvidia rtx 3080" <%= "nvidia rtx 3080".equals(request.getParameter("gpuModel")) ? "selected" : "" %>>Nvidia RTX 3080</option>
            <option value="nvidia rtx 3090" <%= "nvidia rtx 3090".equals(request.getParameter("gpuModel")) ? "selected" : "" %>>Nvidia RTX 3090</option>
            <option value="amd radeon rx 5700" <%= "amd radeon rx 5700".equals(request.getParameter("gpuModel")) ? "selected" : "" %>>AMD Radeon RX 5700</option>
            <option value="intel iris xe" <%= "intel iris xe".equals(request.getParameter("gpuModel")) ? "selected" : "" %>>Intel Iris Xe</option>
            <option value="nvidia quadro p4000" <%= "nvidia quadro p4000".equals(request.getParameter("gpuModel")) ? "selected" : "" %>>Nvidia Quadro P4000</option>
            <option value="amd radeon pro wx 3200" <%= "amd radeon pro wx 3200".equals(request.getParameter("gpuModel")) ? "selected" : "" %>>AMD Radeon Pro WX 3200</option>
        </select><br>

        <!-- Дугме за слање -->
        <input type="submit" value="Evaluate">
    </form>

    <!-- Приказ резултата ако је доступан -->
    <%
        if (request.getAttribute("results") != null) {
            Map<String, Double> results = (Map<String, Double>) request.getAttribute("results");
    %>
        <h2>Evaluation Results:</h2>
        <ul>
            <li>Suitability for Home Use: <%= results.get("homeUseSuitability") %></li>
            <li>Suitability for Business Use: <%= results.get("businessUseSuitability") %></li>
            <li>Suitability for Gaming: <%= results.get("gamingSuitability") %></li>
            <li>Suitability for Mining: <%= results.get("miningSuitability") %></li>
            <li>Suitability for Hosting: <%= results.get("hostingSuitability") %></li>
        </ul>
    <%
        }
    %>

    <h1>Find Similar Computers</h1>
    <form action="SimilarityServlet" method="post">
        <!-- Унос за процесор -->
        <label for="cpu">Processor:</label>
        <select id="cpu" name="cpu">
            <option value="Intel Core i3 10110U" <%= "Intel Core i3 10110U".equals(request.getParameter("cpu")) ? "selected" : "" %>>Intel Core i3 10110U</option>
            <option value="Intel Core i5 10500" <%= "Intel Core i5 10500".equals(request.getParameter("cpu")) ? "selected" : "" %>>Intel Core i5 10500</option>
            <option value="AMD Ryzen 5 3600" <%= "AMD Ryzen 5 3600".equals(request.getParameter("cpu")) ? "selected" : "" %>>AMD Ryzen 5 3600</option>
            <option value="Intel Core i7 10700K" <%= "Intel Core i7 10700K".equals(request.getParameter("cpu")) ? "selected" : "" %>>Intel Core i7 10700K</option>
            <option value="AMD Ryzen 9 5900X" <%= "AMD Ryzen 9 5900X".equals(request.getParameter("cpu")) ? "selected" : "" %>>AMD Ryzen 9 5900X</option>
            <option value="Intel Core i9 11900K" <%= "Intel Core i9 11900K".equals(request.getParameter("cpu")) ? "selected" : "" %>>Intel Core i9 11900K</option>
            <option value="Intel Core i5 10400F" <%= "Intel Core i5 10400F".equals(request.getParameter("cpu")) ? "selected" : "" %>>Intel Core i5 10400F</option>
            <option value="Intel Core i7 11700F" <%= "Intel Core i7 11700F".equals(request.getParameter("cpu")) ? "selected" : "" %>>Intel Core i7 11700F</option>
            <option value="AMD Ryzen 7 5800X" <%= "AMD Ryzen 7 5800X".equals(request.getParameter("cpu")) ? "selected" : "" %>>AMD Ryzen 7 5800X</option>
            <option value="Intel Core i3 10105" <%= "Intel Core i3 10105".equals(request.getParameter("cpu")) ? "selected" : "" %>>Intel Core i3 10105</option>
        </select><br>

        <!-- Унос за радну меморију -->
        <label for="ram">Memory Size (GB):</label>
        <select id="ram" name="ram">
            <option value="8" <%= "8".equals(request.getParameter("ram")) ? "selected" : "" %>>8 GB</option>
            <option value="16" <%= "16".equals(request.getParameter("ram")) ? "selected" : "" %>>16 GB</option>
            <option value="32" <%= "32".equals(request.getParameter("ram")) ? "selected" : "" %>>32 GB</option>
            <option value="64" <%= "64".equals(request.getParameter("ram")) ? "selected" : "" %>>64 GB</option>
            <option value="128" <%= "128".equals(request.getParameter("ram")) ? "selected" : "" %>>128 GB</option>
            <option value="4" <%= "4".equals(request.getParameter("ram")) ? "selected" : "" %>>4 GB</option>
            <option value="12" <%= "12".equals(request.getParameter("ram")) ? "selected" : "" %>>12 GB</option>
            <option value="24" <%= "24".equals(request.getParameter("ram")) ? "selected" : "" %>>24 GB</option>
            <option value="40" <%= "40".equals(request.getParameter("ram")) ? "selected" : "" %>>40 GB</option>
            <option value="20" <%= "20".equals(request.getParameter("ram")) ? "selected" : "" %>>20 GB</option>
        </select><br>

        <!-- Унос за масовну меморију -->
        <label for="storage">Storage Size (GB):</label>
        <select id="storage" name="storage">
            <option value="256" <%= "256".equals(request.getParameter("storage")) ? "selected" : "" %>>256 GB</option>
            <option value="512" <%= "512".equals(request.getParameter("storage")) ? "selected" : "" %>>512 GB</option>
            <option value="1024" <%= "1024".equals(request.getParameter("storage")) ? "selected" : "" %>>1 TB</option>
            <option value="2048" <%= "2048".equals(request.getParameter("storage")) ? "selected" : "" %>>2 TB</option>
            <option value="128" <%= "128".equals(request.getParameter("storage")) ? "selected" : "" %>>128 GB</option>
            <option value="640" <%= "640".equals(request.getParameter("storage")) ? "selected" : "" %>>640 GB</option>
            <option value="160" <%= "160".equals(request.getParameter("storage")) ? "selected" : "" %>>160 GB</option>
            <option value="320" <%= "320".equals(request.getParameter("storage")) ? "selected" : "" %>>320 GB</option>
            <option value="480" <%= "480".equals(request.getParameter("storage")) ? "selected" : "" %>>480 GB</option>
            <option value="750" <%= "750".equals(request.getParameter("storage")) ? "selected" : "" %>>750 GB</option>
        </select><br>

        <!-- Унос за графичку картицу -->
        <label for="gpu">GPU Model:</label>
        <select id="gpu" name="gpu">
            <option value="Intel UHD 620" <%= "Intel UHD 620".equals(request.getParameter("gpu")) ? "selected" : "" %>>Intel UHD 620</option>
            <option value="Nvidia RTX 3060" <%= "Nvidia RTX 3060".equals(request.getParameter("gpu")) ? "selected" : "" %>>Nvidia RTX 3060</option>
            <option value="AMD Radeon RX 580" <%= "AMD Radeon RX 580".equals(request.getParameter("gpu")) ? "selected" : "" %>>AMD Radeon RX 580</option>
            <option value="Intel Iris Xe" <%= "Intel Iris Xe".equals(request.getParameter("gpu")) ? "selected" : "" %>>Intel Iris Xe</option>
            <option value="Nvidia Quadro RTX 4000" <%= "Nvidia Quadro RTX 4000".equals(request.getParameter("gpu")) ? "selected" : "" %>>Nvidia Quadro RTX 4000</option>
            <option value="Nvidia GTX 1660 Ti" <%= "Nvidia GTX 1660 Ti".equals(request.getParameter("gpu")) ? "selected" : "" %>>Nvidia GTX 1660 Ti</option>
            <option value="AMD Radeon RX 570" <%= "AMD Radeon RX 570".equals(request.getParameter("gpu")) ? "selected" : "" %>>AMD Radeon RX 570</option>
            <option value="AMD Radeon RX 5600 XT" <%= "AMD Radeon RX 5600 XT".equals(request.getParameter("gpu")) ? "selected" : "" %>>AMD Radeon RX 5600 XT</option>
            <option value="Intel UHD Graphics 630" <%= "Intel UHD Graphics 630".equals(request.getParameter("gpu")) ? "selected" : "" %>>Intel UHD Graphics 630</option>
            <option value="Nvidia RTX 3070" <%= "Nvidia RTX 3070".equals(request.getParameter("gpu")) ? "selected" : "" %>>Nvidia RTX 3070</option>
        </select><br>

        <!-- Унос за чипсет -->
        <label for="chipset">Chipset:</label>
        <select id="chipset" name="chipset">
            <option value="Intel H410" <%= "Intel H410".equals(request.getParameter("chipset")) ? "selected" : "" %>>Intel H410</option>
            <option value="Intel Z490" <%= "Intel Z490".equals(request.getParameter("chipset")) ? "selected" : "" %>>Intel Z490</option>
            <option value="AMD B450" <%= "AMD B450".equals(request.getParameter("chipset")) ? "selected" : "" %>>AMD B450</option>
            <option value="Intel Comet Lake-U" <%= "Intel Comet Lake-U".equals(request.getParameter("chipset")) ? "selected" : "" %>>Intel Comet Lake-U</option>
            <option value="AMD X570" <%= "AMD X570".equals(request.getParameter("chipset")) ? "selected" : "" %>>AMD X570</option>
            <option value="Intel Z590" <%= "Intel Z590".equals(request.getParameter("chipset")) ? "selected" : "" %>>Intel Z590</option>
            <option value="AMD A320" <%= "AMD A320".equals(request.getParameter("chipset")) ? "selected" : "" %>>AMD A320</option>
            <option value="Intel H310" <%= "Intel H310".equals(request.getParameter("chipset")) ? "selected" : "" %>>Intel H310</option>
            <option value="Intel H470" <%= "Intel H470".equals(request.getParameter("chipset")) ? "selected" : "" %>>Intel H470</option>
            <option value="AMD TRX40" <%= "AMD TRX40".equals(request.getParameter("chipset")) ? "selected" : "" %>>AMD TRX40</option>
        </select><br>

        <!-- Дугме за слање -->
        <input type="submit" value="Find Similar Computers">
    </form>

    <!-- Приказ резултата ако је доступан -->
    <%
        if (request.getAttribute("similarComputers") != null) {
            List<Computer> similarComputers = (List<Computer>) request.getAttribute("similarComputers");
    %>
        <h2>Similar Computers:</h2>
        <ul>
            <% for (Computer computer : similarComputers) { %>
                <li><%= computer %></li>
            <% } %>
        </ul>
    <%
        }
    %>
</body>
</html>
