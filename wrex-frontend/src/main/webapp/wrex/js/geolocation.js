	function codeAddress() {
		var address = document.getElementById('address').value;
		geocoder = new google.maps.Geocoder();
		geocoder.geocode({
			'address' : address
		}, function(results, status) {
			if (status == google.maps.GeocoderStatus.OK) {
				PF('map').map.setCenter(results[0].geometry.location);
			} else {
				//Do nothing on invalid address
				//alert('Geocode was not successful for the following reason: '	+ status);
			}
		});
	}
