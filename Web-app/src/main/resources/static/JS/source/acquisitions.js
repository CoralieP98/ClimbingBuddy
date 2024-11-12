const ctx = document.getElementById("nbTechniques")

const htmlData =document.getElementById("jsonData").textContent;

const data = JSON.parse(htmlData)

const charData = {
    labels : data.map(row => row.technique_name),
    datasets : [{
        label : "nbTech",
        data: data.map(row => row.technique_count),
        // backgroundColor:["blue","cyan","navy","royalblue","indigo","lightblue"]
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
//
// (async function () {
//     window.addEventListener('load', function () {
//
//         const ctx = document.getElementById('nbTechniques');
//         console.log("PWEEEET")
//
//         let data = JSON.parse(document.querySelector('#jsonData').outerText);
//         new Chart(ctx, {
//             type: 'pie',
//             data: {
//                 labels: data.map(row => row.technique_name),
//                 datasets: [{
//                     label: 'Part of product in vending',
//                     data: data.map(row => row.technique_count),
//                 }]
//             },
//             // options: {
//             //     responsive: false,
//             //     style: false,
//             //     plugins: {
//             //         legend: {
//             //             position: 'right',
//             //         }
//             //     }
//             // }
//         });
//     });
// })();