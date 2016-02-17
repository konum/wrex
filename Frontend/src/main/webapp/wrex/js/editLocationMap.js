var currentMarker = null;

	function handlePointClick(event) {
		document.getElementById('formLocation:lat').value = event.latLng.lat();
		document.getElementById('formLocation:lng').value = event.latLng.lng();
		if (currentMarker != null) {
			currentMarker.setMap(null);
		}
		currentMarker = new google.maps.Marker({
			position : new google.maps.LatLng(event.latLng.lat(), event.latLng
					.lng())
		});
		codeLatLng(new google.maps.LatLng(event.latLng.lat(), event.latLng
				.lng()));
		PF('map').addOverlay(currentMarker);
	}

	 
	function codeLatLng(latlng) {
		geocoder = new google.maps.Geocoder();
		geocoder
				.geocode(
						{
							'latLng' : latlng
						},
						function(results, status) {
							if (status == google.maps.GeocoderStatus.OK) {
								if (results[1]) {
									for(var j = 0; j < 0; j++){
										if (results[j].types[0] == 'locality') {
											indice = j;
											break;
										}
									}
									for (var i = 0; i < results[j].address_components.length; i++) {
										if (results[j].address_components[i].types[0] == 'country') {
											country = results[j].address_components[i];
											document.getElementById('formLocation:country').value  = country.short_name;
											console.log(country.short_name);
											break;
										}
									}
								} else {
									alert('No results found');
									return ""
								}
							} else {
								alert('Geocoder failed due to: ' + status);
								return ""
							}
						});
	}