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

    function addCemetery(map, title, icon, location, mini_map){
      var marker;
      try{
        marker = L.marker(location, {icon: icon, title: title}).addTo(map);
        marker.bindPopup('<iframe id="iframe" src=' + mini_map + '></iframe>'); // Add a marker to the map
        return marker;
      }
      catch (error){
        console.log(error + title);
      }
    }