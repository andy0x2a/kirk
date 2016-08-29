
 jQuery(document).ready(function($) {
 var url = 'http://default-environment.quy9nfcir5.us-west-2.elasticbeanstalk.com/gps/';
 if (window.location.pathname == "/tracking/") {
$("#map").width($(document).width()*.5);
$("#map").height($(document).height()*.3);
$.get(url,function(data) {
var mapPoints = [];
for(var i =0; i < data.length; i++) {
 mapPoints.push({'lat':data[i].latitude, 'lng':data[i].longitude});
}
initMap(mapPoints);
 
//https://maps.googleapis.com/maps/api/js?key=AIzaSyDA-vvUy_Ms8YOG9xdNzNICWK2uhaCrvHQ&callback=initMap
//https://maps.googleapis.com/maps/api/js?key=AIzaSyDA-vvUy_Ms8YOG9xdNzNICWK2uhaCrvHQ


});

}
  });


  function initMap(mapPoints) {
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 5,
          center: {lat: mapPoints[mapPoints.length-1].lat, lng: mapPoints[mapPoints.length-1].lng},
          mapTypeId: 'terrain'
        });

       
        var flightPath = new google.maps.Polyline({
          path: mapPoints,
          geodesic: true,
          strokeColor: '#FF0000',
          strokeOpacity: 1.0,
          strokeWeight: 4
        });
		 flightPath.setMap(map);

}
  