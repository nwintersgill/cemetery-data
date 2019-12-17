const colorCode = [green = '#49FF00', red = '#FF0000', yellow = '#FFD500'];

/* setting the map at LatLng{40.9578336, -76.88758} with zoom 15*/
    function mapGen(centerPoint, zoom){
      var map = L.map('map').setView(centerPoint, zoom);
      L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
      attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors',
      maxZoom: 25
      }).addTo(map); // Set up the basic map layer, in this case the map layer is OpenStreetMap
      return map;
    }

    function addCemetery(map, title, icon, location){
      var marker;
      try{
        marker = L.marker(location, {icon: icon, title: title}).addTo(map);
        marker.bindPopup('This is ' + title); // Add a marker to the map
        return marker;
      }
      catch (error){
        console.log(error + title);
      }
    }

  
    function addGrid(x_count, y_count, plot_coordinate){

      var poly = turf.polygon([plot_coordinate]);
      var bbox = turf.bbox(poly);


      var mapWidth = bbox[2] - bbox[0],
          mapHeight = bbox[3] - bbox[1];

      var countX = x_count; //cells by x
      var countY = y_count; //cells by y
      var cellWidth = mapWidth / countX;
      var cellHeight = mapHeight / countY;

      var coordinates = [],
      curX = bbox[0], curY = bbox[3], //cursor
      //top-left/top-right/bottom-right/bottom-left
      tLx, tLy,   tRx, tRy,
      bRx, bRy,   bLx, bLy;

      var grid, counter, gridFeat, temp;
      counter = 0;
      var gridCollection = [];

      for(var iY = 0; iY < countY; iY++){
    // count by cell in row
          for(var iX = 0; iX < countX; iX++){
              tLx = bLx = curX;
              tLy = tRy = curY;
              tRx = bRx = curX + cellWidth;
              bRy = bLy = curY - cellHeight;

              var cell = [
              // top-left/top-right/bottom-right/bottom-left/top-left
              [tLx, tLy], [tRx, tRy], [bRx, bRy], [bLx, bLy], [tLx, tLy]
              ];
              var color;
              fillColor = yellow;
              temp = turf.polygon([cell]);
              temp = turf.intersect(poly, temp);
              
              if (temp != null){
                //console.log(temp.geometry.coordinates);
              

                gridFeat = {
                    "type": "FeatureCollection",
                    "features": [
                        {
                        "type": "Feature",
                        "properties": {
                            "popupContent": "TODO: add code and connect plot class " + counter.toString(),
                            "style": {
                                weight: 2,
                                color: "#FFFFFF",
                                opacity: 1,
                                fillColor: fillColor,
                                fillOpacity: 1
                            }
                        },
                        "geometry": {
                            "type": "Polygon",
                            "coordinates": [temp.geometry.coordinates[0]
                            ]
                        }
                    }
                    ]
                };
              }
              grid = L.geoJSON(gridFeat, {style: function (feature) {return feature.properties.style;}, onEachFeature: function (feature, layer) {layer.bindPopup(feature.properties.popupContent)}});
              gridCollection.push(grid);
              // refresh cusror for cell
              curX = curX + cellWidth;
              counter += 1;
          }
    // refresh cursor for row
          curX = bbox[0];
          curY = curY - cellHeight;
      }
      return gridCollection;
    }