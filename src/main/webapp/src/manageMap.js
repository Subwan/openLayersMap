var map = new ol.Map({
  target: 'map',
    controls: ol.control.defaults({
    attributionOptions: {
      collapsible: false
    }
  }),
    view: new ol.View({
      center: [0, 0],
      zoom: 0
    }),
    layers: [
      new ol.layer.Tile({
        source: new ol.source.TileWMS({
        projection: 'EPSG:4326', //HERE IS THE DATA SOURCE PROJECTION
        url: 'http://demo.boundlessgeo.com/geoserver/wms',
        params: {
          'LAYERS': 'ne:NE1_HR_LC_SR_W_DR'
        }
      })
      })
    ]

  });
