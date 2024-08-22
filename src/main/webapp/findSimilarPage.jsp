<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Similar Computers</title>
    <style>
        /* Celi sadržaj je centriran i stilizovan */
        body {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f4f4f9;
            font-family: Arial, sans-serif;
        }

        h1 {
            text-align: center;
            color: #333;
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

        button {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 18px;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }

        /* Stil za rezultate */
        #results {
            margin-top: 20px;
        }

    </style>
</head>
<body>
    <div class="form-container">
        <h1>Search for Similar Computers</h1>
        <form id="findSimilarForm">
            <label for="cpuCores">CPU Cores:</label>
            <select id="cpuCores" name="cpuCores">
                <option value="AMDcpu">AMD CPU</option>
                <option value="ARMcpu">ARM CPU</option>
                <option value="Intelcpu">Intel CPU</option>
            </select>

            <label for="memorySize">Memory Size:</label>
            <select id="memorySize" name="memorySize">
                <option value="DDR">DDR</option>
                <option value="DDR2">DDR2</option>
                <option value="DDR3">DDR3</option>
                <option value="DDR4">DDR4</option>
                <option value="DDR5">DDR5</option>
            </select>

            <label for="diskSpeed">Storage Type:</label>
            <select id="diskSpeed" name="diskSpeed">
                <option value="HardDrive">Hard Drive</option>
                <option value="NVMe">NVMe</option>
                <option value="RAM">RAM</option>
            </select>

            <label for="powerSupply">Power Supply:</label>
            <select id="powerSupply" name="powerSupply">
                <option value="500W">500W</option>
                <option value="600W">600W</option>
                <option value="750W">750W</option>
                <option value="850W">850W</option>
                <option value="1000W">1000W</option>
            </select>

            <label for="gpuModel">GPU Model:</label>
            <select id="gpuModel" name="gpuModel">
                <option value="DedicatedGraphics">Dedicated Graphics</option>
                <option value="IntegratedGraphics">Integrated Graphics</option>
            </select>

            <button type="submit">Search</button>
        </form>

        <div id="results"></div>
    </div>

    <script>
    document.getElementById('findSimilarForm').addEventListener('submit', function(event) {
        event.preventDefault();

        const cpuCores = document.getElementById('cpuCores').value;
        const memorySize = document.getElementById('memorySize').value;
        const diskSpeed = document.getElementById('diskSpeed').value;
        const powerSupply = document.getElementById('powerSupply').value;
        const gpuModel = document.getElementById('gpuModel').value;

        const formData = new URLSearchParams();
        formData.append('cpuCores', cpuCores);
        formData.append('memorySize', memorySize);
        formData.append('diskSpeed', diskSpeed);
        formData.append('powerSupply', powerSupply);
        formData.append('gpuModel', gpuModel);

        // Pošaljite POST zahtev na pravi URL
        fetch('/KnowledgeEngineering/SimilarityServlet', {
            method: 'POST',
            body: formData
        })
        .then(response => response.text())
        .then(data => {
            const resultsDiv = document.getElementById('results');
            resultsDiv.innerHTML = data;
        })
        .catch(error => {
            console.error('Error:', error);
            alert('An error occurred while searching for similar computers.');
        });
    });
    </script>
</body>
</html>
