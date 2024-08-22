<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Computer Specification Input</title>
    <style>
        /* Osnovni stil za centriranje i postavljanje širine */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        /* Kontejner za formu */
        .form-container {
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 600px;
            width: 100%;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
            color: #555;
        }

        select {
            width: 100%;
            padding: 8px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }

        input[type="submit"] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 18px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        /* Stil za rezultate evaluacije */
        h2 {
            color: #333;
            text-align: center;
        }

        ul {
            list-style-type: none;
            padding: 0;
        }

        ul li {
            background-color: #e7f3fe;
            margin: 5px 0;
            padding: 10px;
            border-radius: 5px;
            color: #333;
        }

        /* Link back to index */
        a {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: #007BFF;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="form-container">
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
            </select>

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
            </select>

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
            </select>

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
            </select>

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
            </select>

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
        <a href="index.jsp">Back to Index</a>
    </div>
</body>
</html>
