
	function popupGallery(){
		$('.popup-gallery')
		.magnificPopup(
				{
					delegate : 'a',
					type : 'image',
					tLoading : 'Loading image #%curr%...',
					mainClass : 'mfp-img-mobile',
					gallery : {
						enabled : true,
						navigateByImgClick : true,
						preload : [ 0, 1 ],
						tCounter: '<span class="mfp-counter">%curr% / %total%</span>', // markup of counter
						 tPrev: '#{i18n.gallery_left}', // title for left button
						  tNext: '#{i18n.gallery_right}' // title for right button
					// Will preload 0 - before current, and 1 after the current image
					},
					image : {
						tError : '<a href="%url%">The image #%curr%</a> could not be loaded.',
						
					}
				});
	}
	
function goTopSlow() {
		$('html, body').animate({
			scrollTop : $('header').offset().top
		}, 'slow');
	}
	
	function goTopFast() {
			$('html, body').animate({
				scrollTop : $('header').offset().top
			}, 'fast');
	}
	
	function goBottom() {
		$('html, body').animate({
			scrollTop : $('footer').offset().top
		}, 'fast');
	}
	
	function goTo(selector, offset) {
		$('html, body').animate({
			scrollTop : $(selector).offset().top - offset
		}, 'slow');
	}
	
	function debounce(func, wait, immediate) {
		var timeout;
		return function() {
			var context = this, args = arguments;
			var later = function() {
				timeout = null;
				if (!immediate) func.apply(context, args);
			};
			var callNow = immediate && !timeout;
			clearTimeout(timeout);
			timeout = setTimeout(later, wait);
			if (callNow) func.apply(context, args);
		};
	};
	
	
	$(document).ready(function(){
	    var pageTitle   = document.title; //HTML page title
	    var pageUrl     = location.href; //Location of this page
	   
	    $('.share-btn-wrp li').click(function(event){
	        var shareName = $(this).attr('class').split(' ')[0]; //get the first class name of clicked element
	        var url = $(this).attr('url');
	        if (url===undefined){
	        	url = encodeURIComponent(pageUrl);
	        }
	        switch(shareName) //switch to different links based on different social name
	        {
	            case 'facebook':
	                OpenShareUrl('https://www.facebook.com/sharer/sharer.php?u=' + url);
	                break;
	            case 'gplus':
	                OpenShareUrl('https://plus.google.com/share?url=' + url);
	                break;
	            case 'twitter':
	                OpenShareUrl('http://twitter.com/home?status=' + url);
	                break;
	        }
	       
	    });
	       
	    function OpenShareUrl(openLink){
	        //Parameters for the Popup window
	        winWidth    = 650;
	        winHeight   = 450;
	        winLeft     = ($(window).width()  - winWidth)  / 2;
	        winTop      = ($(window).height() - winHeight) / 2;
	        winOptions   = 'width='  + winWidth  + ',height=' + winHeight + ',top='    + winTop    + ',left='   + winLeft;
	        window.open(openLink,'Share This Link',winOptions); //open Popup window to share website.
	        return false;
	    }
	});
	
	PrimeFaces.locales['es'] = {
		    closeText: 'Cerrar',
		    prevText: 'Anterior',
		    nextText: 'Siguiente',
		    monthNames: ['Enero','Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
		    monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun','Jul','Ago','Sep','Oct','Nov','Dic'],
		    dayNames: ['Domingo','Lunes','Martes','Miércoles','Jueves','Viernes','Sábado'],
		    dayNamesShort: ['Dom','Lun', 'Mar', 'Mie', 'Jue', 'Vie', 'Sab'],
		    dayNamesMin: ['D','L','M','X','J','V','S'],
		    weekHeader: 'Semana',
		    firstDay: 1,
		    isRTL: false,
		    showMonthAfterYear: false,
		    yearSuffix: '',
		    timeOnlyTitle: 'Sólo hora',
		    timeText: 'Tiempo',
		    hourText: 'Hora',
		    minuteText: 'Minuto',
		    secondText: 'Segundo',
		    currentText: 'Fecha actual',
		    ampm: false,
		    month: 'Mes',
		    week: 'Semana',
		    day: 'Día',
		    allDayText : 'Todo el día'
		};