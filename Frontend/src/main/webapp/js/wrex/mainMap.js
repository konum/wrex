	$(document).keyup(function(event) {
		if (event.keyCode == 27) {
			event.preventDefault();
			if ($("#mainMap").css("position") === "fixed")
				toggleFullScreen();
		}
	});

	function toggleFullScreen() {
		$("#mainMap").toggleClass("map_fullscreen map_embbeded");
		toogleMapStyle();
		$("#typeList").toggleClass("filtermap_panel_fullscreen");
		$("#geoSearch").toggleClass(
				"geolocation_panel_fullscreen geolocation_panel_embbedded");
		if ($("#mainMap").css("position") === "fixed") {
			$("#toggleFullscreen").prop('value', "#{i18n.close} (Esc)");
		} else {
			$("#toggleFullscreen").prop('value', "#{i18n.mainMap_fullScreen}");
		}
		google.maps.event.trigger(PF('map').map, "resize");
	}

	$("#address").keyup(function(event) {
		if (event.keyCode == 13) {
			$("#searchGeo").click();
		}
	});
	

	function clusterMarkers() {
		var mcOptions = {
			gridSize : 30,
			maxZoom : 13
		};
		var mc = new MarkerClusterer(PF('map').map, PF('map').map.markers,
				mcOptions);
		var tmp = PF('map').map.fitBounds;
		PF('map').map.fitBounds = google.maps.Map.prototype.fitBounds;
	}

	$(window)
	.load(
			function() {
				clusterMarkers();

				if (navigator.geolocation) {
					checkGeolocationByHTML5();
				} else {
					checkGeolocationByLoaderAPI(); // HTML5 not supported! Fall back to Loader API.
				}

				function checkGeolocationByHTML5() {
					navigator.geolocation
							.getCurrentPosition(
									function(position) {
										setMapCenter(
												position.coords.latitude,
												position.coords.longitude);
										document
												.getElementById('lat').value = position.coords.latitude;
										document
												.getElementById('lng').value = position.coords.longitude;
										setLatLng();
									}, function() {
										checkGeolocationByLoaderAPI(); // Error! Fall back to Loader API.
									});
				}

				function checkGeolocationByLoaderAPI() {
					if (google.loader.ClientLocation) {
						setMapCenter(
								google.loader.ClientLocation.latitude,
								google.loader.ClientLocation.longitude);
						document.getElementById('lat').value = position.coords.latitude;
						document.getElementById('lng').value = position.coords.longitude;
					} else {
						//If not user position, defualt to Santiago Chile
						PF('map').getMap().setCenter(
								new google.maps.LatLng(-33.4641,
										-71.0817));
					}
				}

				function setMapCenter(latitude, longitude) {
					PF('map').getMap()
							.panTo(
									new google.maps.LatLng(latitude,
											longitude));
				}
			});