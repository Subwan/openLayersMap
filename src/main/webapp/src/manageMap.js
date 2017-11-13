function getAllMarkers() {
  let xhr = new XMLHttpRequest();
  xhr.open('GET', '/map', false);
  xhr.send();
  if (xhr.status != 200) {
    alert( xhr.status + ': ' + xhr.statusText );
  } else {
    let json = xhr.responseText;
    return JSON.parse(json);
  }
};

function manageLine(body) {
  let xhr = new XMLHttpRequest();
  xhr.open('POST', '/map/line', false);
  xhr.send(body);
  if (xhr.status != 200) {
    alert( xhr.status + ': ' + xhr.statusText );
  } else {
    return xhr.responseText;
  }
};

function managePolygon(body) {
  let xhr = new XMLHttpRequest();
  xhr.open('POST', '/map/polygon', false);
  xhr.send(body);
  if (xhr.status != 200) {
    alert( xhr.status + ': ' + xhr.statusText );
  } else {
    return xhr.responseText;
  }
};

function manageDot(body) {
  let xhr = new XMLHttpRequest();
  xhr.open('POST', '/map/dot', false);
  xhr.send(body);
  if (xhr.status != 200) {
    alert( xhr.status + ': ' + xhr.statusText );
  } else {
    return xhr.responseText;
  }
};
