function getId(type) {
  let xhr = new XMLHttpRequest();
  xhr.open('GET', '/map?type=' + type, false);
  xhr.send();
  if (xhr.status != 200) {
    alert( xhr.status + ': ' + xhr.statusText );
  } else {
    return xhr.responseText;
  }
};

function sendMarker(body) {
  let xhr = new XMLHttpRequest();
  xhr.open('POST', '/map', true);
  xhr.send(body);
  if (xhr.status != 200) {
    alert( xhr.status + ': ' + xhr.statusText );
  } else {
    return xhr.responseText;
  }
};
