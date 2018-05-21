function statusChangeCallback(response) {
		console.log('statusChangeCallback');
		console.log(response);
		if (response.status === 'connected') {
			testAPI();
		} 
	}

	function checkLoginState() {
		PF('loginDialog').hide();
		PF('statusDialog').show();
		FB.getLoginStatus(function(response) {
			statusChangeCallback(response);
		});
	}

	window.fbAsyncInit = function() {
		FB.init({
			appId : '983867481665033',
			xfbml : true,
			version : 'v2.4'
		});
	};

	(function(d, s, id) {
		var js, fjs = d.getElementsByTagName(s)[0];
		if (d.getElementById(id)) {
			return;
		}
		js = d.createElement(s);
		js.id = id;
		js.src = "//connect.facebook.net/en_US/sdk.js";
		fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));

	FB.getLoginStatus(function(response) {
		statusChangeCallback(response);
	});

	(function(d, s, id) {
		var js, fjs = d.getElementsByTagName(s)[0];
		if (d.getElementById(id))
			return;
		js = d.createElement(s);
		js.id = id;
		js.src = "//connect.facebook.net/en_US/sdk.js";
		fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));

	var id = 0;
	var gresponse;
	var name;
	var url;
	var mail;
	function testAPI() {
		console.log('Welcome!  Fetching your information.... ');
		FB
				.api(
						'/me',
						function(response) {
							console.log('Successful login for: '
									+ response.name);
							name = response.name;
							id = response.id;
							mail = response.mail;
						});
		foobar();

	}

	function foobar() {
		setTimeout(function() {
			console.log('Logging in.... ');
			FB.api('/' + id + '/picture?type=large', function(response) {
				if (response && !response.error) {
					url = response.data.url;
					login([{name:'name', value:name}, {name:'url', value:url},{name:'id', value:id},,{name:'mail', value:mail}]);
				}
			});
		}, 400);
	}
