function getFiles(data) {
    for (var i in data){
    var elem = $("<a>");
    elem.attr("href", "files/" + data[i].newFilename);
    elem.text(data[i].comment);
    $("#list").append(elem);
    $("#list").append("<br>")
    }
}

$.get("/files", getFiles);