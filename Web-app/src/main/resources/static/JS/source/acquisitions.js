const ctx = document.getElementById("nbTechniques")

const htmlData =document.getElementById("jsonData").textContent;

const data = JSON.parse(htmlData)

const charData = {
    labels : data.map(row => row.technique_name),
    datasets : [{
        label : "nbTech",
        data: data.map(row => row.technique_count),
        backgroundColor:["blue","cyan","navy","royalblue","indigo","lightblue"],
        color : "white"
    }]
}

const myChart = new Chart(ctx,{
    type: "pie",
    data:charData,
    options: {
                responsive: false,
                style: false,
                plugins: {
                    legend: {
                        position: 'right',
                    }
                }
            }


})
