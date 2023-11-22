function actorSelected(select) {
    let index = select.selectedIndex;
    let actorId = select.options[index].value;
    let actorName = select.options[index].text;
    let urlImage = select.options[index].dataset.url;

    select.options[index].disabled = true;
    select.selectedIndex = 0;

    addActor(actorId, actorName, urlImage);

    let ids = $("#ids").val();
    if (ids == "") {
        $("#ids").val(actorId);
    } else {
        $("#ids").val(ids + "," + actorId);
    }
}

function addActor(id, name, urlImage){
    let htmlString = `
        <div class="card col-md-3 m-2" style="width: 10rem">
            <img class="card-img-top" src="{URL-IMAGE}" alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title">{NAME}</h5>
                <button class="btn btn-danger" data-id="{ID}" onclick="deleteActor(this); return false;">Delete</button>
            </div>
        </div>
    `;
    htmlString = htmlString.replace("{ID}", id);
    htmlString = htmlString.replace("{URL-IMAGE}", urlImage);
    htmlString = htmlString.replace("{NAME}", name);

    $("#actors-container").append(htmlString);
}

function deleteActor(btn){
    let id = btn.dataset.id;
    let node = btn.parentNode.parentNode;
    let arrayIds = $("#ids").val().split(",").filter(idActor => idActor != id);
    $("#ids").val(arrayIds.join(","));
    $("#actors option[value='" + id + "']").prop("disabled", false);
    node.remove();
}