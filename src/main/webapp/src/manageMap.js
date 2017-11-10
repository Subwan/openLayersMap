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

function manageMarker(body) {
  let xhr = new XMLHttpRequest();
  xhr.open('POST', '/map', false);
  xhr.send(body);
  if (xhr.status != 200) {
    alert( xhr.status + ': ' + xhr.statusText );
  } else {
    return xhr.responseText;
  }
};
