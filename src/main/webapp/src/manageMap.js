function getAllPoint() {
  let xhr = new XMLHttpRequest();
  xhr.open('GET', '/map/point', false);
  xhr.send();
  if (xhr.status != 200) {
    alert( xhr.status + ': ' + xhr.statusText );
  } else {
    let json = xhr.responseText;
    return JSON.parse(json);
  }
};

function deleteFigure(id) {
  let xhr = new XMLHttpRequest();
  xhr.open('GET', '/map/delete?id=' + id, false);
  xhr.send();
  if (xhr.status != 200) {
    alert( xhr.status + ': ' + xhr.statusText );
  } else {
    xhr.responseText;
  }
}

function manageFigure(body) {
  let xhr = new XMLHttpRequest();
  xhr.open('POST', '/map/figure', false);
  xhr.send(body);
  if (xhr.status != 200) {
    alert( xhr.status + ': ' + xhr.statusText );
  } else {
    return xhr.responseText;
  }
};
