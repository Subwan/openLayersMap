function getAllFigures(callback) {
  let xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      callback( JSON.parse(xhr.responseText));
    }
  };
  xhr.open('GET', '/map/figure', true);
  xhr.send();
};

function deleteFigure(id) {
  let xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      xhr.responseText;
    }
  };
  xhr.open('GET', '/map/delete?id=' + id, true);
  xhr.send();
}

function manageFigure(body, callback) {
  let xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            callback(xhr.responseText);
       }
    };
  xhr.open('POST', '/map/figure', true);
  xhr.send(body);
};
