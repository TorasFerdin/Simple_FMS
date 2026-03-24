async function print(){
    const response = await fetch("http://localhost:8082/api/foods");
    // console.log(response);

    const body = await response.json();
    //console.log(body);

    document.getElementById("table-body-custom").innerHTML = "";

    for(let [index, item] of body.entries()){
        // console.log(index, item);

        // Backtick -> Alt + 9 + 6
        document.getElementById("table-body-custom").innerHTML += `
        <tr>
            <td>${item.name}</td>
            <td>${item.categ}</td>
            <td>${item.pric}</td>
            <td>${item.availa}</td>
            <td>
                <button type="button" class="btn btn-danger" onclick="deleteFood('${item.uuid}')">
                    X
                </button>
                <button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#updateModal" onclick="update('${item.uuid}')">
                    E
                </button>
            </td>
        </tr>
        `;
    }
}

async function save(){
    const name = document.getElementById("input-name").value;
    const categ = document.getElementById("input-category").value;
    const calor = document.getElementById("input-calories").value;
    const pric = document.getElementById("input-price").value;
    const availa = document.getElementById("input-availability").value;
    const expi = document.getElementById("input-expiration").value;

    const food = {
        name,
        categ,
        calor,
        pric,
        availa,
        expi,
    }

    //console.log(food);

    const response = await fetch("http://localhost:8082/api/foods", {
        method : "POST",
        body : JSON.stringify(food),
        headers : {
            "Content-Type" : "application/json"
        }
    });

    //console.log(response);

    if(response.ok){
        alert("New food added");
        print();
    }    
    else
        alert("Insert error");
}


async function update(uuidVal){
    const response = await fetch("http://localhost:8082/api/foods/" + uuidVal);  // GET call
    const body = await response.json();

    document.getElementById("update-name").value = body.name;
    document.getElementById("update-category").value = body.categ;
    document.getElementById("update-calories").value = body.calor;
    document.getElementById("update-price").value = body.pric;
    document.getElementById("update-availability").value = body.availa;
    document.getElementById("update-expiration").value = body.expi;

    document.getElementById("btn-save-upd").dataset.identifier = uuidVal;   // Dataset
}

async function saveUpdate(){
    const uuid = document.getElementById("btn-save-upd").dataset.identifier;
    // console.log(uuid);

    const name = document.getElementById("update-name").value;
    const categ = document.getElementById("update-category").value;
    const calor = document.getElementById("update-calories").value;
    const pric = document.getElementById("update-price").value;
    const availa = document.getElementById("update-availability").value;
    const expi = document.getElementById("update-expiration").value;

    const food = {
        name,
        categ,
        calor,
        pric,
        availa,
        expi,
    }

    const response = await fetch("http://localhost:8082/api/foods/" + uuid, {
        method: "PUT",
        body: JSON.stringify(food),
        headers: {
            "Content-Type": "application/json"
        }
    });

    if(response.ok){
        alert("Food udated successfully");
        print();

        const modalElement = document.getElementById("updateModal");
        const modal = bootstrap.Modal.getInstance(modalElement);
        modal.hide();
    }
    else
        alert("Update error");
}


async function deleteFood(uuidVal){
    //console.log(uuidVal);

    const response = await fetch("http://localhost:8082/api/foods/" + uuidVal, {
        method: "DELETE"
    });

    if(response.ok){
        alert("Deleted successfully");
        print();
    }
    else
        alert("Deletition error")
}

print();