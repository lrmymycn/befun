$(function(){
	Main.initMenu();
	Main.initFilter();
	Search.init();
});

Main = {
	root: '/befun-web/',
	imageRoot: '/',
	isLoading:false,
	isHome:false, //home is search.jsp
	currentProjectId:null,
	currentFloorplanId:null,
	currentApartmentId:null,
	currentRadiusWidget:null,
	currentClientId:null,
	init:function(){
		this.isHome = true;
		this.windowResize();
		$(window).resize(this.windowResize);
		//this.initFilter();
		//this.initClient();
		MapMenu.init();
		PanelPopup.init();
		FloorplanPopup.init();
		ComparePanel.init();
		//Search.init();
		FloorPlanFilter.init();
		Map.init();
		//this.showLightbox();
	},
	windowResize:function(){
		var mapHeight = $(window).height() - $('header').height() + 9;
		$('#map').height(mapHeight);
		$('#sidebar').height(mapHeight);
		$('#sidebar #projectlist').height(mapHeight - 36);
		var panelX = ($(window).width() - $('#panel').width()) / 2;
		var panelY = ($(window).height() - $('#panel').height()) / 2;
		if(panelY < 0){
			panelY = 0;
		}
		$('#panel').css({'left': panelX, 'top': panelY});
		var lightboxX = ($(window).width() - $('#lightbox').width()) / 2;
		var lightboxY = ($(window).height() - $('#lightbox').height()) / 2;
		if(lightboxY < 0){
			lightboxY = 0;
		}
		$('#lightbox').css({'left': lightboxX, 'top': lightboxY});
	},
	initFilter: function(){		
		$('#btn-filter').click(function(){
			PanelPopup.hide();
			$('#filter').toggle();
			
			if(!$('#client-panel').is(':visible')){	
				$('#filter-overlay').toggle();
			}
			
		});
		
		/*
		$('#filter #more-features').click(function(){
			$('#features-filter').toggle();
			if($(this).next('i').hasClass('arrow-down')){
				$(this).next('i').removeClass().addClass('arrow-up');
			}else if($(this).next('i').hasClass('arrow-up')){
				$(this).next('i').removeClass().addClass('arrow-down');
			}
		});
		*/
		$("#filter select.selectbox").selectbox();
		
		$('#reminder-nodes .filterNode').live('click', function(){
			$('#btn-filter').click();
		});
		
		$('#filter-overlay').click(function(){
			PanelPopup.hide();
			Main.hideFilter();
		});
	},
	initMenu: function(){
		Main.currentClientId = $('#clientname').data('id');	

		$('#change-client').click(function(){
			$('#client-panel').toggle();
		
			if(!$('#filter').is(':visible')){	
				$('#filter-overlay').toggle();
			}
		});
	
		$('#client-panel select[name="client"]').change(function(){
			var $this = $(this);
			var id = $this.val();
			if(id == ''){
				return;
			}
			$.ajax({
				url: Main.root + '/profile/json/selectClient.action?clientId=' + id,
				dataType: "json",
				type: "GET",
				success: function(data){
					if(data.errorMessages.length > 0){
						alert('An error happened');
					}else{
						var name = $this.find('option:selected').text();
						$('#clientname').text('and ' + name);
						$('#view-client').attr('href','client.jsp?id=' + id).show();
						Main.currentClientId = id;
						Main.hideFilter();
					}
				}
			});
		});
	
		if($('#change-client').length > 0){
			$.ajax({
				url: Main.root + 'profile/json/viewMineClients.action?qc.enabled=true',
				dataType: "json",
				type: "GET",
				success: function(data){
					var clients = data.clients;
					for(var i = 0; i < clients.length; i++){
						var client = clients[i];
						var option = $('<option value="' + client.id + '">' + client.givenName +  ' ' + client.surname + '</option>');
						$('#client-panel select').append(option);
						if(Main.currentClientId == client.id){
							$('#clientname').text('and ' + client.givenName + ' ' + client.surname);
							$('#view-client').attr('href','client.jsp?id=' + Main.currentClientId).show();
						}
					}
			
					$("#client-panel select.selectbox").selectbox();
				}
			});
		}

		$('#login-link').click(function(){
			$('#login-panel').toggle();
		
			if(!$('#filter').is(':visible')){	
				$('#filter-overlay').toggle();
			}
		});

	},
	hideFilter:function(){
		$('#filter').hide();
		$('#client-panel').hide();
		$('#login-panel').hide();
		$('#filter-overlay').hide();
	},
	loadProjectList:function(){
		$('#projectlist').empty();
		for(var i = 0; i < Search.projects.length; i++){
			var project = Search.projects[i];
			var cls = 'item';
			if(i == Search.projects.length - 1){
				cls = 'item last';
			}
			var html = '<div class="' + cls +'" data-id="' + project.id + '" data-lat="' + project.latitude + '" data-lng="' + project.longitude + '">'
					    + '<div class="clearfix">'
							+ '<img src="' + project.picture.mediumUrl + '" alt="' + project.name + '" width="140" height="94"/>'
							+ '<div class="info">'
								+ '<label>类型:</label><span>公寓</span><br/>'
								+ '<label>价格:</label><span>60万 - 80万</span><br/>'
								+ '<label>区域:</label>' + project.suburbName + '<br/>'
					 		+ '</div>'
					 	+ '</div>'
					    + '<div class="intro">简介: 高尚社区，宽带入户。英国管家，倍有面子。开个日本车你都不好意思和邻居打招呼。</div>'
					 + '</div>';
			var $div = $(html);
			
			$div.click(function(){
				var lat = $(this).data('lat');
				var lng = $(this).data('lng');
				var projectId = $(this).data('id');
				var center = new google.maps.LatLng(lat, lng);
				Map.center = center;
				Map.map.setCenter(Map.center);
				
				if(Main.currentProjectId != projectId){
					Main.currentProjectId = projectId;

					if(Main.currentRadiusWidget != null){
						Main.currentRadiusWidget.destroy();
						Main.currentRadiusWidget = new RadiusWidget();
					}
					MapMenu.resetMenu();
				}

				if(Map.map.getZoom() != 15){
					Map.map.setZoom(15);
				}
				
				PanelPopup.hide();
			});
			
			$div.appendTo($('#projectlist'));
		}
	},
	updateReminder: function(){
		$('#reminder-nodes').empty();
		
		var minPriceText = $('#filter select[name="minprice"] option:selected').text();
		var maxPriceText = $('#filter select[name="maxprice"] option:selected').text();
		var priceText = minPriceText + ' to ' + maxPriceText;
		if(minPriceText == maxPriceText){
			priceText = minPriceText;
		}
		if(priceText == ''){
			priceText = 'Any Price';
		}
		
		$('#reminder-nodes').append('<div class="filterNode"><span>' + priceText + '</span></div>');
		
		var bedroomText = "Any Beds";
		var num = '';
		$('#filter input[name="bedrooms"]:checked').each(function(){
			num = num + $(this).val() + ',';
		});
		if(num != ''){
			num = num.substr(0, num.length - 1);
			bedroomText = num + ' Beds';
		}
		$('#reminder-nodes').append('<div class="filterNode"><span>' + bedroomText + '</span></div>');
		
		var bathroomText = "Any Baths";
		num = '';
		$('#filter input[name="bathrooms"]:checked').each(function(){
			num = num + $(this).val() + ',';
		});
		if(num != ''){
			num = num.substr(0, num.length - 1);
			bathroomText = num + ' Baths';
		}
		$('#reminder-nodes').append('<div class="filterNode"><span>' + bathroomText + '</span></div>');
		
		var carspaceText = "Any Carspace";
		num = '';
		$('#filter input[name="carspace"]:checked').each(function(){
			num = num + $(this).val() + ',';
		});
		if(num != ''){
			num = num.substr(0, num.length - 1);
			carspaceText = num + ' Carspace';
		}
		$('#reminder-nodes').append('<div class="filterNode"><span>' + carspaceText + '</span></div>');

		var conditions = Search.conditions;
		
		if(conditions.distanceToCity != ""){
			var distanceText = $('#filter select[name="distancetocity"] option:selected').text();
			if(distanceText != 'CBD'){
				distanceText += " to City";
			}
			$('#reminder-nodes').append('<div class="filterNode"><span>' + distanceText + '</span></div>');
		}
		
		if(conditions.trainStation && conditions.trainStation != 'null'){
			$('#reminder-nodes').append('<div class="filterNode"><span>Train Station</span></div>');
		}
		
		if(conditions.shoppingCenter && conditions.shoppingCenter != 'null'){
			$('#reminder-nodes').append('<div class="filterNode"><span>Shopping Centres</span></div>');
		}
	
		if(conditions.chineseCommunity && conditions.chineseCommunity != 'null'){
			$('#reminder-nodes').append('<div class="filterNode"><span>Chinese Community</span></div>');
		}
		
		if(conditions.universities && conditions.universities != 'null'){
			$('#reminder-nodes').append('<div class="filterNode"><span>University Zone</span></div>');
		}
		
		if(conditions.schools && conditions.schools != 'null'){
			$('#reminder-nodes').append('<div class="filterNode"><span>School Zone</span></div>');
		}
		
		var statusText = $('#filter select[name="status"] option:selected').text();
		if(conditions.status != ''){
			$('#reminder-nodes').append('<div class="filterNode"><span>' + statusText + '</span></div>');
		}
		
	},
	loadingShow:function(){
		$('#loading').show();
	},
	loadingHide:function(){
		$('#loading').hide();
	}
}

Map = {
	map: null,
	zoomEvent:null,
	justZoomed:null,
	currentZoom:null,
	isZoomOut:false,
	mapObjects:null,
	markers:{},
	busLayer:null,
	updateTimer:null,
	center:null,
	infoWindow:null,
	defaultLat:-33.828929,
	defaultLng:151.087074,
	defaultZoom:11,
	placeService:null,
	init: function(){
		this.mapObjects = new Array();
		this.infoWindow = new google.maps.InfoWindow();
		
		var mapOptions = {
    		zoom: Map.defaultZoom,
    		minZoom: 11,
    		maxZoom: 20,
    		center: new google.maps.LatLng(Map.defaultLat, Map.defaultLng),
    		mapTypeId: google.maps.MapTypeId.ROADMAP,
    		mapTypeControl: false,
    		streetViewControl: false,
    		panControl: false,
    		zoomControlOptions: {
    			position: google.maps.ControlPosition.LEFT_CENTER
    		}
  		}
  		this.map = new google.maps.Map(document.getElementById("map"), mapOptions);
  		this.bindEvents();
  		this.currentZoom = this.map.getZoom();
  		Search.loadConditions();
  		Search.execute();
  		
  		this.placeService = new google.maps.places.PlacesService(Map.map);
	},
	bindEvents: function(){
		this.zoomEvent = google.maps.event.addListener(this.map, 'zoom_changed', function() {
			Debug.trace('zoom changed');
			Map.justZoomed = true;
			if(Map.map.getZoom() > Map.currentZoom){
				Map.isZoomOut = false;
			}else{
				Map.isZoomOut = true;
			}
			Map.currentZoom = this.getZoom();
			
			if(Map.currentZoom < 15){
				Map.cleanMap();
				PanelPopup.hide();
				MapMenu.disable();
			}else if(!Map.isZoomOut && Map.currentZoom == 15){
				Map.cleanMap();
				MapMenu.enable();
			}
		});
		
		google.maps.event.addListener(this.map, "dragstart", function () {
			
		});
		
		google.maps.event.addListener(this.map, "dragend", function () {

		});
		
		google.maps.event.addListener(this.map, 'idle', function() {
			if(Map.justZoomed){
				if(Map.updateTimer != null){
					clearTimeout(Map.updateTimer);
				}
				Map.updateTimer = setTimeout("Search.execute()", 100);
			}		
		});
	},
	unbindEvents: function(){
		google.maps.event.removeListener(this.zoomEvent);
	},
	cleanMap: function(){
		this.cleanMapObjects();
		this.cleanSchools();
		this.cleanStores();
		this.cleanChildcares();
		this.cleanBusRoutes();
		this.cleanRestaurants();
		this.cleanHospitals();
		this.cleanMedicalCentres();
	},
	cleanMapObjects: function(){
		Debug.trace('clean map: ' + this.mapObjects.length);
		
		for(var i = 0; i < this.mapObjects.length; i++){
			this.mapObjects[i].setMap(null);
		}
		this.mapObjects = new Array();
	},
	cleanSchools: function(){
		if(this.markers.schools){
			var schools = this.markers.schools;
			for(var i = 0; i < schools.length; i++){
				schools[i].setMap(null);
			}
			
			this.markers.schools = null;
		}
	},
	cleanStores: function(){
		if(this.markers.stores){
			var stores = this.markers.stores;
			for(var i = 0; i < stores.length; i++){
				stores[i].setMap(null);
			}
			
			this.markers.stores = null;
		}
	},
	cleanChildcares: function(){
		if(this.markers.childcares){
			var childcares = this.markers.childcares;
			for(var i = 0; i < childcares.length; i++){
				childcares[i].setMap(null);
			}
			
			this.markers.childcares = null;
		}
	},
	cleanRestaurants: function(){
		if(this.markers.restaurants){
			var restaurants = this.markers.restaurants;
			for(var i = 0; i < restaurants.length; i++){
				restaurants[i].setMap(null);
			}
			
			this.markers.restaurants = null;
		}
	},
	cleanHospitals: function(){
		if(this.markers.hospitals){
			var hospitals = this.markers.hospitals;
			for(var i = 0; i < hospitals.length; i++){
				hospitals[i].setMap(null);
			}
			
			this.markers.hospitals = null;
		}
	},
	cleanMedicalCentres: function(){
		if(this.markers.medicalcentres){
			var medicalcentres = this.markers.medicalcentres;
			for(var i = 0; i < medicalcentres.length; i++){
				medicalcentres[i].setMap(null);
			}
			
			this.markers.medicalcentres = null;
		}
	},
	cleanBusRoutes: function(){
		if(this.busLayer != null){
			this.busLayer.setMap(null);
			this.busLayer = null;
		}
	},
	loadClusters: function(){
		Debug.trace('load clusters');
		if(Search.cache == null){
			return;
		}
		var arr = new Array();
		for(var i = 0; i < Search.clusters.length; i++){
			var cluster = new ClusterOverlay(Search.clusters[i], this.map);
			arr.push(cluster);
		}
		this.mapObjects = arr;
	},
	loadSuburbs: function(){
		Debug.trace('load suburbs');
		if(Search.cache == null){
			return;
		}
		var arr = new Array();
		for(var i = 0; i < Search.suburbs.length; i++){
			var suburb = new ClusterOverlay(Search.suburbs[i], this.map);
			arr.push(suburb);
		}
		this.mapObjects = arr;
	},
	loadProjects: function(projects){
		Debug.trace('load projects');
		var arr = new Array();
		for(var i = 0; i < Search.projects.length; i++){
			var project = new ProjectOverlay(Search.projects[i], this.map);
			arr.push(project);
		}
		this.mapObjects = arr;
	},
	loadSchools: function(){
		this.markers.schools = [];
		this.loadAmenities('school', 'public school', this.markers.schools);
	},
	loadStores: function(){
		this.markers.stores = [];
		this.loadAmenities('store', 'coles', this.markers.stores);
		this.loadAmenities('store', 'woolworths', this.markers.stores);
	},
	loadChildcares:function(){
		this.markers.childcares = [];
		this.loadAmenities('childcare', 'childcare', this.markers.childcares);
	},
	loadRestaurants:function(){
		this.markers.restaurants = [];
		this.loadAmenities('restaurant', 'chinese restaurant', this.markers.restaurants);
	},
	loadHospitals:function(){
		this.markers.hospitals = [];
		this.loadAmenities('hospital', 'hospital', this.markers.hospitals);
	},
	loadMedicalCentres:function(){
		this.markers.medicalcentres = [];
		this.loadAmenities('medical', 'medical centre', this.markers.medicalcentres);
	},
	loadAmenities: function(amenity, keyword, arr){
		var request = {
		    location: Map.center,
		    radius: '1000', //1km
		   	query: keyword
		};
		
		var icon = Main.imageRoot + 'img/maps/' + amenity + '.png';
		
		Main.loadingShow();
		this.placeService.textSearch(request, function(results, status){
			Main.loadingHide();
  			if (status == google.maps.places.PlacesServiceStatus.OK) {
				for (var i = 0; i < results.length; i++) {
					var marker = Map.createMarker(results[i], icon);
					arr.push(marker);
				}
	        }
		});
	},
	createMarker: function(place, icon){
	    var marker = new google.maps.Marker({
			position: place.geometry.location,
			map: Map.map,
			animation: google.maps.Animation.DROP,
			icon: icon
		});
		
		google.maps.event.addListener(marker, 'click', function() {
        	Map.infoWindow.setContent('<b>' + place.name + '</b><br/>' + place.formatted_address);
        	Map.infoWindow.open(Map.map, this);
        });
        
        return marker
	},
	loadBusRoutes: function(){
		var kmlLayerOptions = {
			preserveViewport: true
		};
		this.busLayer = new google.maps.KmlLayer('https://maps.google.com.au/maps/ms?authuser=0&vps=2&ie=UTF8&msa=0&output=kml&msid=201892530171956132134.0004d2311a34b609cf116', kmlLayerOptions);
  		this.busLayer.setMap(this.map);
	}
}

Search = {
	cache:null,
	clusters:null,
	suburbs:null,
	projects:null,
	conditions: {
		suburbId:null,
		minPrice:null,
		maxPrice:null,
		propertyType:null,
		bedrooms:null,
		bathrooms:null,
		carspace:null,
		distanceToCity:null,
		trainStation:null,
		schools:null,
		universities:null,
		chineseCommunity:null,
		shoppingCenter:null,
		status:null,
	},
	init: function(){
		$('#search-suburb').val('');
		$('#filter select').val('');
		$('#filter input[name="propertytype"]:eq(0)').attr('checked', true);
		$('#filter input:checkbox').attr('checked', false);		
		
		$('#search-suburb').autocomplete({
			source: function (request, response) {
				$.ajax({
                  url: Main.root + 'estate/json/demandSuburbByKey.action',
                  data: {'qc.key': request.term},
                  dataType: "json",
                  type: "POST",
                  success: function(data){
                      response(data.keyRs);
                  }
                });
		    },
		    minLength: 1,
		    delay:500,
			select: function( event, ui ) {
				Debug.trace(ui.item.id);
				Search.conditions.suburbId = ui.item.id;
			},
			change: function (ev, ui) {
                if (!ui.item){
                    $(this).val("");
                }
            }
		});
		
		$('#btn-search, #btn-search2').click(function(){
			if(Main.isHome){
				Search.cache = null;
				Map.cleanMap();
				Search.execute();
			}else{
				Search.saveConditions();
				window.location.href = Main.root + "search.jsp";
			}
		});
		
		$('#btn-search4').click(function(){
			Search.saveLandingConditions();
			window.location.href = Main.root + "search.jsp";
		});
	},
	saveConditions:function(){
		this.setConditions();
		var jsonString = JSON.stringify(Search.conditions);
		$.cookie("conditions", jsonString,{ expires: 1, path: '/' });
	},
	setConditions:function(){
		var conditions = Search.conditions;			
		conditions.minPrice = $('#filter select[name="minprice"]').val();
		if(conditions.minPrice == null){
			conditions.minPrice = 0;
		}
		conditions.maxPrice = $('#filter select[name="maxprice"]').val();
		if(conditions.maxPrice == null){
			conditions.maxPrice = 0;
		}
		conditions.propertyType = $('#filter input[name="propertytype"]:checked').val();
		
		conditions.bedrooms = Tools.getCheckboxListValue('bedrooms');
		conditions.bathrooms = Tools.getCheckboxListValue('bathrooms');
		conditions.carspace = Tools.getCheckboxListValue('carspace');	
		
		conditions.distanceToCity = $('#filter select[name="distancetocity"]').val();
		conditions.trainStation = $('#filter input[name="train"]').is(":checked") ? true : 'null';
		conditions.schools = $('#filter input[name="schools"]').is(":checked") ? true : 'null';
		conditions.universities = $('#filter input[name="universities"]').is(":checked") ? true : 'null';
		conditions.chineseCommunity = $('#filter input[name="chinese"]').is(":checked") ? true : 'null';
		conditions.shoppingCenter = $('#filter input[name="shpppingcenter"]').is(":checked") ? true : 'null';
		conditions.status = $('#filter select[name="status"]').val();
		
		Search.conditions = conditions;
	},
	saveLandingConditions:function(){
		this.setLandingConditions();
		var jsonString = JSON.stringify(Search.conditions);
		$.cookie("conditions", jsonString,{ expires: 1, path: '/' });
	},
	setLandingConditions:function(){
		var conditions = Search.conditions;
		
		if(conditions.suburbId == null){
			conditions.minPrice = $('#home-filter select[name="minprice"]').val();
			if(conditions.minPrice == null){
				conditions.minPrice = 0;
			}
			conditions.maxPrice = $('#home-filter select[name="maxprice"]').val();
			if(conditions.maxPrice == null){
				conditions.maxPrice = 0;
			}
			conditions.bedrooms = $('#home-filter select[name="bedrooms"]').val();
			conditions.bathrooms = $('#home-filter select[name="bathrooms"]').val();
			conditions.carspace = $('#home-filter select[name="carspace"]').val();
		}else{
			conditions.minPrice = 0;
			conditions.maxPrice = 0;
			conditions.bedrooms = '';
			conditions.bathrooms = '';
			conditions.carspace = '';
		}
		Search.conditions = conditions;
	},
	loadConditions: function(){
		var cookie = $.cookie("conditions");
		if(cookie != null && cookie != ''){
			Search.conditions = JSON.parse(cookie);
			var conditions = Search.conditions;
			Search.clearConditions();
			
			var minPriceText = $('#filter select[name="minprice"] option[value="'+ conditions.minPrice + '"]').html();
			$('#filter select[name="minprice"]').val(conditions.minPrice).selectbox('change', conditions.minPrice, minPriceText);
			
			var maxPriceText = $('#filter select[name="maxprice"] option[value="'+ conditions.maxPrice + '"]').html();
			$('#filter select[name="maxprice"]').val(conditions.maxPrice).selectbox('change', conditions.maxPrice, maxPriceText);
			
			var bedrooms = conditions.bedrooms.split(',');
			for(var i = 0; i < bedrooms.length; i++){
				$('#filter input[name="bedrooms"][value="' + bedrooms[i] + '"]').attr('checked', true).parent('span').addClass('checked');
			}
			var bathrooms = conditions.bathrooms.split(',');
			for(var i = 0; i < bathrooms.length; i++){
				$('#filter input[name="bathrooms"][value="' + bathrooms[i] + '"]').attr('checked', true).parent('span').addClass('checked');
			}
			var carspaces = conditions.carspace.split(',');
			for(var i = 0; i < carspaces.length; i++){
				$('#filter input[name="carspace"][value="' + carspaces[i] + '"]').attr('checked', true).parent('span').addClass('checked');
			}
			
			var distanceToCityText = $('#filter select[name="distancetocity"] option[value="'+ conditions.distanceToCity + '"]').html();
			$('#filter select[name="distancetocity"]').val(conditions.distanceToCity).selectbox('change', conditions.distanceToCity, distanceToCityText);
			
			if(conditions.trainStation == 1){
				$('#filter input[name="train"]').attr('checked', true).parent('span').addClass('checked');
			}

			if(conditions.schools == 1){
				$('#filter input[name="schools"]').attr('checked', true).parent('span').addClass('checked');
			}
			
			if(conditions.universities == 1){
				$('#filter input[name="universities"]').attr('checked', true).parent('span').addClass('checked');
			}
			
			if(conditions.chineseCommunity == 1){
				$('#filter input[name="chinese"]').attr('checked', true).parent('span').addClass('checked');
			}
		 
		 	if(conditions.shoppingCenter == 1){
		 		$('#filter input[name="shpppingcenter"]').attr('checked', true).parent('span').addClass('checked');
		 	}			
			
			var statusText = $('#filter select[name="status"] option[value="'+ conditions.status + '"]').html();
			$('#filter select[name="status"]').val(conditions.status).selectbox('change', conditions.status, statusText);
			
			Main.updateReminder();
		}
	},
	clearConditions:function(){
		$.cookie("conditions", '',{ expires: -1, path: '/' });
	},
	execute: function(){
		Debug.trace('search execute');
		Map.justZoomed = false;

		if(this.cache == null){
			
			this.clusters = new Array();
			this.suburbs = new Array();
			this.projects = new Array();
			this.setConditions();
			var conditions = Search.conditions;
			
			var status = 'null';
			if(conditions.status == '0'){
				status = false;
			}else if(conditions.status == '1'){
				status = true;
			}
			
			var data = {
				'qc.suburbId': conditions.suburbId, 
				'qc.distanceToCity': conditions.distanceToCity,
				'qc.apQC.fpQC.bedRoomCountStr': conditions.bedrooms,
				'qc.apQC.fpQC.bathRoomCountStr': conditions.bathrooms,
				'qc.apQC.carParkingCountStr': conditions.carspace,
				house_type: conditions.propertyType,
				'qc.apQC.minPrice': conditions.minPrice,
				'qc.apQC.maxPrice': conditions.maxPrice,
				'qc.apQC.fpQC.bQC.readyHouse': status,
				'qc.suburbQC.chineseCommunity': conditions.chineseCommunity,
				'qc.suburbQC.train' : conditions.trainStation,
				'qc.suburbQC.schools' : conditions.schools,
				'qc.suburbQC.universities' : conditions.universities,
				'qc.suburbQC.shoppingCenter' : conditions.shoppingCenter
			};
						
			Main.updateReminder();
			Main.hideFilter();
			$.ajax({
				type: 'POST',
				url: Main.root + "estate/json/demandProjectAggregated.action",
				data: data,
				dataType: "json",
				success: function(json){
					Search.cache = json;
					//display areas and suburbs
					var aggrs = json.aggRs;
					
					for(var i = 0; i < aggrs.length; i++){
						var cluster = aggrs[i];
						if(cluster.projectCounts > 0){
							Search.clusters.push(cluster);
							for(var j = 0; j < cluster.suburbs.length; j++){
								var suburb = cluster.suburbs[j];
								if(suburb.projectCounts > 0){
									Search.suburbs.push(suburb);
								}
							}
						}
					}
					
					var projects = json.pgb.models;
					for(var k = 0; k < projects.length; k++){
						var project = projects[k];
						Search.projects.push(project);
					}
					
					var lat = Map.defaultLat;
					var lng = Map.defaultLng;
					var zoomLevel = Map.defaultZoom;
					
					if(Search.clusters.length == 1){
						if(Search.suburbs.length == 1){
							var suburb = Search.suburbs[0];
							lat = suburb.latitude;
							lng = suburb.longitude;
							zoomLevel = suburb.zoomLevel;
						}else{
							var cluster = Search.clusters[0];
							lat = cluster.latitude;
							lng = cluster.longitude;
							zoomLevel = cluster.zoomLevel;
						}
					}

					var center = new google.maps.LatLng(lat, lng);
					Map.center = center;
					Map.map.setCenter(Map.center);
					
					if(Map.currentZoom == zoomLevel){
						Search.loadSearchResult();
					}else{
						Map.map.setZoom(zoomLevel);
					}
					
				}
			});
		}else{
			this.loadSearchResult();
		}
		
	},
	loadSearchResult:function(){
		Debug.trace('load search result');
		Main.loadProjectList();
		
		var zoom = Map.map.getZoom();
		if(zoom < 12){
			Map.loadClusters();
		}else if(zoom <= 14){
			Map.loadSuburbs();
		}else{
			if(Map.mapObjects == null || Map.mapObjects.length == 0){
				Map.loadProjects();
			}
		}
	}
}

Debug = {
	enable:false,
	trace: function(s){
		if(this.enable){
			if ('console' in self && 'log' in console){
				console.log(s);
			}
		}
	}
}

MapMenu = {
	init: function(){
		$('#map-menu').mouseenter(function(){
			if($(this).hasClass('disabled')){
				return;
			}
			$(this).addClass('expended');
		}).mouseleave(function(){
			if($(this).hasClass('disabled')){
				return;
			}
			$(this).removeClass('expended');
		});
		
		$('#map-menu li a').click(function(){
			var $this = $(this);
			if($this.hasClass('active')){
				$this.removeClass('active');
			}else{
				$this.addClass('active');
			}
		});
		
		this.disable();
		
		$('#map-menu a.distance').click(function(){
			if(Map.center != null){
				if(Main.currentRadiusWidget == null){
					Main.currentRadiusWidget = new RadiusWidget();
				}else{
					Main.currentRadiusWidget.destroy();
					Main.currentRadiusWidget = null;
				}
			}			
		});
		
		$('#map-menu a.stores').click(function(){
			if(Map.markers.stores == null){
				Map.loadStores();
			}else{
				Map.cleanStores();
			}
		});
		
		$('#map-menu a.schools').click(function(){
			if(Map.markers.schools == null){
				Map.loadSchools();
			}else{
				Map.cleanSchools();
			}
		});
		
		$('#map-menu a.childcares').click(function(){
			if(Map.markers.childcares == null){
				Map.loadChildcares();
			}else{
				Map.cleanChildcares();
			}
		});
		
		$('#map-menu a.restaurants').click(function(){
			if(Map.markers.restaurants == null){
				Map.loadRestaurants();
			}else{
				Map.cleanRestaurants();
			}
		});
		
		$('#map-menu a.hospitals').click(function(){
			if(Map.markers.hospitals == null){
				Map.loadHospitals();
			}else{
				Map.cleanHospitals();
			}
		});
		
		$('#map-menu a.medicalcentres').click(function(){
			if(Map.markers.medicalcentres == null){
				Map.loadMedicalCentres();
			}else{
				Map.cleanMedicalCentres();
			}
		});
	},
	disable:function(){
		$('#map-menu').addClass('disabled');
		$('#map-menu li a').removeClass('active');
		
		if(Main.currentRadiusWidget != null){
			Main.currentRadiusWidget.destroy();
			Main.currentRadiusWidget = null;
		}
	},
	enable:function(){
		$('#map-menu').removeClass('disabled');
	},
	resetMenu:function(){
		if(Map.markers.schools){
			Map.cleanSchools();
			$('#map-menu a.schools').removeClass('active');
		}
		if(Map.markers.stores){
			Map.cleanStores();
			$('#map-menu a.stores').removeClass('active');
		}
		if(Map.markers.childcares){
			Map.cleanChildcares();
			$('#map-menu a.childcares').removeClass('active');
		}
		if(Map.markers.restaurants){
			Map.cleanRestaurants();
			$('#map-menu a.restaurants').removeClass('active');
		}
		if(Map.markers.hospitals){
			Map.cleanHospitals();
			$('#map-menu a.hospitals').removeClass('active');
		}
		if(Map.markers.medicalcentres){
			Map.cleanMedicalCentres();
			$('#map-menu a.medicalcentres').removeClass('active');
		}
	}
}

PanelPopup = {
	isShown: false,
	init: function(){
		$('#panel .close').click(function(){
			Map.center = Map.map.getCenter();
			PanelPopup.hide();
		});
		
		$('#panel-overlay').click(function(){
			Map.center = Map.map.getCenter();
			PanelPopup.hide();
		});
		
		$('#panel .tabs a').click(function(e){
			e.preventDefault();
			var target = $(this).attr('href');
			if($(target).hasClass('hidden')){
				$(target).siblings('.shown').removeClass('shown').addClass('hidden');
				$(target).removeClass('hidden').addClass('shown');
				
				$(this).siblings('.active').removeClass('active');
				$(this).addClass('active');
			}
		});
		
		/*
		$('#overview-list .items a').live('click', function(e){
			e.preventDefault();
			if($(this).hasClass('active')){
				return false;
			}
			
			var url = $(this).attr('href');
			$('#overview-main').fadeTo("medium", 0.5);
			var img = new Image();
 
			img.onload = function() {		 
				$('#overview-main').fadeTo("fast", 1);
				$('#overview-main').find("img").attr("src", url);		 
			};
			img.src = url;
			
			$('#overview-list .items a').removeClass('active');
			$(this).addClass('active');
			
			return false;
		});
		$("#overview-list .scrollable").scrollable();
		*/
		$('#floorplan-list .item').live('click', function(){
			FloorplanPopup.load($(this).data('id'));
		});
		
		$('#floorplan-list2 .item').live('click', function(){
			FloorplanPopup.load($(this).data('id'));
			$('#floorplan-list2 .item').removeClass('active');
			$(this).addClass('active');
		})

		$("#floorplan-list .scrollable").scrollable({vertical: true});
		$('#floorplan-list2 .scrollable').scrollable();
		
		$("#panel select.selectbox").selectbox();
		
		$('#tab-contactus form').validate();
	},
	show:function(){
		$('#panel .top .tabs a:first-child').click();
		$('#panel #tab-details .tabs a:first-child').click();
		$('#panel #tab-sales .tabs a:first-child').click();
		
		$('#panel').show();
		PanelPopup.isShown = true;
		$('#panel-overlay').show();
	},
	hide:function(){
		if(this.isShown){
			$('#panel').hide();		
			this.isShown = false;		
			//Main.currentProjectId = null;
			$('#panel-overlay').hide();
		}
	},
	load:function(projectId){
		/*
		if(Main.currentProjectId == projectId){
			return;
		}
		Main.currentProjectId = projectId;
		*/
		//Upate panel filter
		var conditions = Search.conditions;
		
		var minPriceText = $('#floorplan-filter select[name="minprice"] option[value="'+ conditions.minPrice + '"]').html();
		$('#floorplan-filter select[name="minprice"]').val(conditions.minPrice).selectbox('change', conditions.minPrice, minPriceText);
		var maxPriceText = $('#floorplan-filter select[name="maxprice"] option[value="'+ conditions.maxPrice + '"]').html();
		$('#floorplan-filter select[name="maxprice"]').val(conditions.maxPrice).selectbox('change', conditions.maxPrice, maxPriceText);
		
		var bedrooms = conditions.bedrooms.split(',');
		//reset
		$('#floorplan-filter input[name="floorplan-bedrooms"]').attr('checked', false).parent('span').removeClass('checked');
		for(var i = 0; i < bedrooms.length; i++){
			$('#floorplan-filter input[name="floorplan-bedrooms"][value="' + bedrooms[i] + '"]').attr('checked', true).parent('span').addClass('checked');
		}
		var bathrooms = conditions.bathrooms.split(',');
		//reset
		$('#floorplan-filter input[name="floorplan-bathrooms"]').attr('checked', false).parent('span').removeClass('checked');
		for(var i = 0; i < bathrooms.length; i++){
			$('#floorplan-filter input[name="floorplan-bathrooms"][value="' + bathrooms[i] + '"]').attr('checked', true).parent('span').addClass('checked');
		}
		var carspaces = conditions.carspace.split(',');
		//reset
		$('#floorplan-filter input[name="floorplan-carspace"]').attr('checked', false).parent('span').removeClass('checked');
		for(var i = 0; i < carspaces.length; i++){
			$('#floorplan-filter input[name="floorplan-carspace"][value="' + carspaces[i] + '"]').attr('checked', true).parent('span').addClass('checked');
		}
		Main.loadingShow();
		$.ajax({
				type: 'POST',
				url: Main.root + "estate/json/demandProjectDetail.action",
				data: {
						id: Main.currentProjectId,
						'qc.apQC.fpQC.bedRoomCountStr': conditions.bedrooms,
						'qc.apQC.fpQC.bathRoomCountStr': conditions.bathrooms,
						'qc.apQC.carParkingCountStr': conditions.carspace,
						'qc.apQC.minPrice': conditions.minPrice,
						'qc.apQC.maxPrice': conditions.maxPrice
					},
				dataType: "json",
				success: function(json){
					var project = json.view;
					if(project != null && project != undefined){
						$('#project-name').text(project.name);
						$('#tab-contactus .project').text(project.name);
						$('#hfproject').val(project.name);
						//$('#subtab-description .detail').html(project.description);
						//$('#subtab-finish .detail').html(project.finish);
						//$('#subtab-amenity .detail').html(project.amenity);
						//$('#subtab-data').html(project.data);
						//$('#subtab-condition').html(project.condition);
						//$('#subtab-offers').html(project.offers);
						
						var photos = project.medias;
						$('#tab-overview .brochure').empty();
						for(var i = 0; i < photos.length; i++){
							var cls = '';
							if((i + 1) % 3 == 0){
								cls = 'last';
							}
							var $li = '<li class="' + cls + '"><a href="' + photos[i].mediumUrl + '" rel="brochure"><img src="' + photos[i].mediumUrl + '" alt=""/></a></li>';
							$('#tab-overview .brochure').append($li);
						}
						$('#tab-overview .brochure a').fancybox({
							padding : 0
						});
						/*
						$('#overview-main').empty();
						if(photos.length > 0){
							$('#overview-main').append('<img src="' + photos[0].mediumUrl + '" width="510" height="343" alt=""/>');
						}
						$('#overview-list .items').empty();
						for(var i = 0; i < photos.length; i++){
							var cls = '';
							if(i == 0){
								cls = 'active';
							}
							var $item = $('<a href="' + photos[i].mediumUrl + '" class="' + cls + '"><img src="' + photos[i].smallUrl + '" width="84" height="56" /></a>');
							var index = Math.floor(i / 5);
								
							var $div = $('#overview-list').find('div[data-id='+ index + ']');
							if($div == null || $div.length == 0){
								$div = $('<div data-id="' + index + '"></div>');
								$('#overview-list .items').append($div);
							}
							$div.append($item);
						}
						*/
						FloorPlanFilter.currentFloorPlans = project.floorplans;
						FloorPlanFilter.updateList();
						
						Main.loadingHide();
						
						if(!PanelPopup.isShown){
							PanelPopup.show();	
						}
					}else{
						alert('Project not found');
					}
				}
		});
	}
}

FloorplanPopup = {
	isShown:false,
	init:function(){
		$('#befun').click(function(){
			ComparePanel.addFloorplan();
		});
		
		$('#interest').click(function(){
			InterestList.add();
		});
		
		$('#lightbox .sort a').click(function(){
			if($(this).hasClass('active')){
				return;
			}
			
			$('#lightbox .sort a').removeClass('active');
			$(this).addClass('active');
			
			var activeItem = $('#floorplan-list2 a.active').data('id');
			
			var type = $(this).data('type');
			FloorPlanFilter.updateList(type);
			
			$('#floorplan-list2 a[data-id="' + activeItem + '"]').addClass('active');
			
			var api = $('#floorplan-list2 .scrollable').data("scrollable");
			var index = $('#floorplan-list2 a.active').parent('div').data('id');
			
			api.seekTo(index, 1000);
		});
		
		$('#lightbox .close').click(function(){
			FloorplanPopup.hide();
		});
		$('#lightbox-overlay').click(function(){
			FloorplanPopup.hide();
		});
		
		$('#lightbox #units .scrollable a').live('click', function(e){
			e.preventDefault();
			
			if($(this).hasClass('active')){
				return false;
			}
			
			var target = $(this).attr('href');
			if($(target).hasClass('hidden')){
				$(target).siblings('.shown').removeClass('shown').addClass('hidden');
				$(target).removeClass('hidden').addClass('shown');
			}
			Main.currentApartmentId = $(this).data('id');
			
			$('#lightbox #units .scrollable a').removeClass('active');
			$(this).addClass('active');
		});
	},
	show:function(){
		$('#lightbox').show();
		$('#lightbox-overlay').show();
		
		var api = $('#floorplan-list2 .scrollable').data("scrollable");
		var index = $('#floorplan-list2 a.active').parent('div').data('id');
		api.seekTo(index, 1000);
		
		FloorplanPopup.isShown = true;
	},
	hide:function(){
		$('#lightbox').hide();
		$('#lightbox-overlay').hide();
		FloorplanPopup.isShown = false;
	},
	load: function(id){
		if(FloorplanPopup.isShown && Main.currentFloorplanId == id){
			return;
		}
		
		Main.currentFloorplanId = id;
		$('#floorplan-list2 .item').removeClass('active');
		$('#floorplan-list2 .item[data-id="' + id + '"]').addClass('active');
		Main.loadingShow();
		$.ajax({
				type: 'POST',
				url: Main.root + "estate/json/demandFloorplanById.action",
				data: {
						id: Main.currentFloorplanId,
						house_type: Search.propertyType,
						price_range: Search.priceRange
					},
				dataType: "json",
				success: function(json){
					var floorplan = json.view;
					if(floorplan != null && floorplan != undefined){
						var picture = null;
						if(floorplan.salePicture != null){
							picture = floorplan.salePicture;
						}
						if(floorplan.publicPicture != null){
							picture = floorplan.publicPicture;
						}
						if(picture == null){
							return;
						}
						
						var img = '<img src="' + picture.mediumUrl + '" alt=""/>';
						$('#lightbox .floorplan .image').html(img);
						$('#lightbox .floorplan .zoom').attr('href', picture.largeUrl);
						$('#units .items').empty();
						$('#apartments').empty();
						
						if(floorplan.apartments.length > 0){
							var apartments = floorplan.apartments;
							for(var i = 0; i < apartments.length; i++){
								var apartment = apartments[i];
								var active = ''
								if(i == 0){
									active = 'active';
									Main.currentApartmentId = apartment.id;
								}
								
								var $item = $('<a href="#' + apartment.id + '" data-id="' + apartment.id + '" class="item ' + active + '">' + apartment.unitNumber + '</a>');
								var index = Math.floor(i / 7);
								
								var $div = $('#units').find('div[data-id='+ index + ']');
								if($div == null || $div.length == 0){
									$div = $('<div data-id="' + index + '"></div>');
									$('#units .items').append($div);
								}
								$div.append($item);
								
								var div = '<div id="{id}" class="{cls}">' +
											'<table>' +
												'<tr>' +
													'<td width="25"></td>' +
													'<td width="100">栋</td>' +
													'<td>{building}</td>' +
												'</tr>' +
												'<tr>' +
													'<td></td>' + 
													'<td>楼层</td>' +
													'<td>{level}</td>' + 
												'</tr>' +
												'<tr>' +
													'<td></td>' +
													'<td>卧室</td>' +
													'<td>{bedrooms}</td>' +
												'</tr>' +
												'<tr>' +
													'<td></td>' +
													'<td>卫生间</td>' +
													'<td>{bathrooms}</td>' +
												'</tr>' +
												'<tr>' +
													'<td></td>' + 
													'<td>书房</td>' +
													'<td>{study}</td>' + 
												'</tr>' +
												'<tr>' +
													'<td></td>' +
													'<td>车位</td>' +
													'<td>{carspace}</td>' +
												'</tr>' +
												'<tr>' +
													'<td></td>' + 
													'<td>朝向</td>' +
													'<td>{aspect}</td>' +
												'</tr>' +
												'<tr>' +
													'<td></td>' + 
													'<td>内部面积</td>' +
													'<td>{internalsize}</td>' + 
												'</tr>' +
												'<tr>' +
													'<td></td>' + 
													'<td>外部面积</td>' +
													'<td>{externalsize}</td>' +
												'</tr>' +
												'<tr>' +
													'<td></td>' +
													'<td>总面积</td>' +
													'<td>{totalsize}</td>' +
												'</tr>' +
												'<tr>' +
													'<td></td>' +
													'<td>价格</td>' +
													'<td>{price}</td>' +
												'</tr>' +
												'<tr>' +
													'<td></td>' +
													'<td>平方单价</td>' +
													'<td>{pricepersquare}</td>' +
												'</tr>' +
											'</table>';
								var cls = 'hidden';
								if(i == 0){
									cls = 'shown';
								}
								div = div.replace('{id}', apartment.id).replace('{cls}', cls)
									.replace('{level}', apartment.floorLevel)
									.replace('{building}', apartment.buildingNum)
									.replace('{aspect}', Tools.getAspect(floorplan.orientationEast,floorplan.orientationNorth, floorplan.orientationSouth, floorplan.orientationWest))
									.replace('{bedrooms}', floorplan.bedRoomCount)
									.replace('{bathrooms}', floorplan.bathroomCount)
									.replace('{study}', Tools.getTrueOrFalseIcon(floorplan.studyroomCount))
									.replace('{internalsize}', floorplan.internalSize + ' m<sup>2</sup>')
									.replace('{externalsize}', floorplan.externalSize + ' m<sup>2</sup>')
									.replace('{totalsize}', floorplan.totalSize + ' m<sup>2</sup>')
									.replace('{carspace}', apartment.carParkingCount)
									.replace('{pricepersquare}', '$' + Tools.numberWithCommas(apartment.avgPricePerSQM) + '/m<sup>2</sup>')
									.replace('{price}', '$' + Tools.numberWithCommas(apartment.price));
								$('#apartments').append($(div));
							}
						}else{
							var div = '<div>' +
											'<table>' +
												'<tr>' +
													'<td width="25"></td>' +
													'<td width="70">卧室</td>' +
													'<td>{bedrooms}</td>' +
													'<td width="70">卫生间</td>' +
													'<td>{bathrooms}</td>' +
												'</tr>' +
												'<tr>' +
													'<td></td>' + 
													'<td>书房</td>' +
													'<td>{study}</td>' + 
													'<td>朝向</td>' +
													'<td>{aspect}</td>' +
												'</tr>' +
												'<tr>' +
													'<td></td>' + 
													'<td>内部面积</td>' +
													'<td>{internalsize}</td>' + 
													'<td>外部面积</td>' +
													'<td>{externalsize}</td>' +
												'</tr>' +
												'<tr>' +
													'<td></td>' +
													'<td>总面积</td>' +
													'<td>{totalsize}</td>' +
													'<td></td>' +
													'<td></td>' +
												'</tr>' +
												'<tr>' +
													'<td></td>' +
													'<td>价格范围</td>' +
													'<td colspan="3">{price}</td>' +
												'</tr>' +
											'</table>';
							
							var price = '';
							if(floorplan.minPrice == null && floorplan.minPrice == undefined){
								price = '敬请期待';
							}else{
								price = '$' + Tools.numberWithCommas(floorplan.minPrice) + ' - ' + '$' + Tools.numberWithCommas(floorplan.maxPrice);
							}
							
							div = div.replace('{aspect}', Tools.getAspect(floorplan.orientationEast,floorplan.orientationNorth, floorplan.orientationSouth, floorplan.orientationWest))
									.replace('{bedrooms}', floorplan.bedRoomCount)
									.replace('{bathrooms}', floorplan.bathroomCount)
									.replace('{study}', Tools.getTrueOrFalseIcon(floorplan.studyroomCount))
									.replace('{internalsize}', floorplan.internalSize + ' m<sup>2</sup>')
									.replace('{externalsize}', floorplan.externalSize + ' m<sup>2</sup>')
									.replace('{totalsize}', floorplan.totalSize + ' m<sup>2</sup>')
									.replace('{price}', price);
								$('#apartments').append($(div));
						}
						
						//$("#units .scrollable").scrollable({ vertical: true});
						Main.loadingHide();
						if(!FloorplanPopup.isShown){
							FloorplanPopup.show();		
						}
						
					}else{
						alert('Floorplan not found');	
					}
				}
		});
	}
}

FloorPlanFilter = {
	currentFloorPlans:[],
	conditions: {
		minPrice:null,
		maxPrice:null,
		bedrooms:null,
		bathrooms:null,
		carspace:null,
		aspect:null,
		study:null,
		splitLevel:null,
		storageRoom:null,
		courtyard:null,
		enclosedBalcony:null,
		penthouse:null,
		east:null,
		south:null,
		west:null,
		north:null
	},
	init: function(){
		$('#btn-search3').click(function(){
			FloorPlanFilter.curentFloorPlans = [];
			
			var conditions = FloorPlanFilter.conditions;
			
			conditions.minPrice = $('#floorplan-filter select[name="minprice"]').val();
			conditions.maxPrice = $('#floorplan-filter select[name="maxprice"]').val();
			conditions.bedrooms = Tools.getCheckboxListValue('floorplan-bedrooms');
			conditions.bathrooms = Tools.getCheckboxListValue('floorplan-bathrooms');
			conditions.carspace = Tools.getCheckboxListValue('floorplan-carspace');
			conditions.aspect = $('#floorplan-filter select[name="aspect"]').val();
			conditions.study = $('#floorplan-filter input[name="study"]').is(":checked") ? '0+' : null;
			conditions.splitLevel = $('#floorplan-filter input[name="splitlevel"]').is(":checked") ? true : 'null';
			conditions.storageRoom = $('#floorplan-filter input[name="storage"]').is(":checked") ? '0+' : null;
			conditions.courtyard = $('#floorplan-filter input[name="courtyard"]').is(":checked") ? '0+' : null;
			conditions.enclosedBalcony = $('#floorplan-filter input[name="splitlevel"]').is(":checked") ? '0+' : null;
			conditions.penthouse = $('#floorplan-filter input[name="penthouse"]').is(":checked") ? true : 'null';
			
			var aspect = $('#floorplan-filter select[name="aspect"]').val();
			conditions.east = aspect == 'E' ? true : 'null';
			conditions.south = aspect == 'S' ? true : 'null';
			conditions.west = aspect == 'W' ? true : 'null';
			conditions.north = aspect == 'N' ? true : 'null';
			
			var data = {
				id: Main.currentProjectId,
				'qc.apQC.fpQC.bedRoomCountStr': conditions.bedrooms,
				'qc.apQC.fpQC.bathRoomCountStr': conditions.bathrooms,
				'qc.apQC.carParkingCountStr': conditions.carspace,
				'qc.apQC.minPrice': conditions.minPrice,
				'qc.apQC.maxPrice': conditions.maxPrice,
				'qc.apQC.fpQC.split': conditions.splitLevel,
				'qc.apQC.fpQC.studyroomCountStr': conditions.study,
				'qc.apQC.fpQC.enclosedBaclonyCountStr': conditions.enclosedBalcony,
				'qc.apQC.fpQC.courtyardCountStr': conditions.courtyard,
				'qc.apQC.storageRoomCountStr': conditions.storageRoom,
				'qc.apQC.pentHouse': conditions.penthouse,
				'qc.apQC.fpQC.orientationEast': conditions.east,
				'qc.apQC.fpQC.orientationSouth': conditions.south,
    			'qc.apQC.fpQC.orientationWest': conditions.west,
    			'qc.apQC.fpQC.orientationNorth': conditions.north
			};
			
			$.ajax({
				type: 'POST',
				url: Main.root + "estate/json/demandProjectDetail.action",
				data: data,
				dataType: "json",
				success: function(json){
					var project = json.view;
					if(project != null && project != undefined){
						FloorPlanFilter.currentFloorPlans = project.floorplans;
						FloorPlanFilter.updateList();
					}else{
						alert('Project not found');
					}
				}
			});
		});
	},
	updateList: function(type){
		if(type == undefined){
			type = 'price';
		}
		$('#floorplan-list .items').empty().css('top', 0);
		$('#floorplan-list2 .items').empty().css('left', 0);
		var floorplans = this.currentFloorPlans;
		switch(type){
			case 'price':
				floorplans = Tools.sortByMinPrice(floorplans);
				break;
			case 'sqm':
				floorplans = Tools.sortByPricePerSQM(floorplans);
				break;
			case 'area':
				floorplans = Tools.sortByArea(floorplans);
				break;
		}
		
		for(var i = 0; i < floorplans.length; i++){
			var picture = null;
			if(floorplans[i].salePicture != null){
				picture = floorplans[i].salePicture;
			}
			if(floorplans[i].publicPicture != null){
				picture = floorplans[i].publicPicture;
			}
			
			if(picture == null){
				continue;
			}
			
			var $item = $('<a href="javascript:;" class="item" data-id="' + floorplans[i].id + '"><img src="' + picture.smallUrl + '" alt="" /></a>');				
			var $item2 = $item.clone();
			
			var index = Math.floor(i / 4);	
			var $div = $('#floorplan-list').find('div[data-id='+ index + ']');
			if($div == null || $div.length == 0){
				$div = $('<div data-id="' + index + '"></div>');
				$('#floorplan-list .items').append($div);
			}
			$div.append($item);
			
			var index2 = Math.floor(i / 6);
			var $div2 = $('#floorplan-list2').find('div[data-id='+ index2 + ']');
			if($div2 == null || $div2.length == 0){
				$div2 = $('<div data-id="' + index2 + '"></div>');
				$('#floorplan-list2 .items').append($div2);
			}
			$div2.append($item2);
		}
	}
}

FloorPlan = {
	data:null,
	init: function(){
		var cookie = $.cookie("floorplans");
		this.data = cookie ? JSON.parse(cookie) : [];
	},
	get: function(id){
		this.init();
		for(var i = 0; i < this.data.length; i++){
			if(this.data[i].id == id){
				return this.data[i];
			}
		}
		return null;
	},
	add: function(object){
		this.init();
		this.data.push(object);
		var jsonString = JSON.stringify(this.data);
		$.cookie("floorplans", jsonString,{ expires: 365, path: '/' });
	},
	remove:function(id){
		this.init();
		for(var i = 0; i < this.data.length; i++){
			if(this.data[i].id == id){
                this.data.splice(i, 1);
                var jsonString = JSON.stringify(this.data);
                $.cookie("floorplans", jsonString, { expires: 365, path: '/' });
                return;
			}
		}
	},
	items:function(){
		this.init();
		return this.data;
	},
	length: function(){
		this.init();
		return this.data.length;
	}
}

ComparePanel = {
	init:function(){
		$('#compare-overlay').click(function(){
			ComparePanel.hide();
		});
		
		$('#compare-panel .tab').click(function(){
			var $this = $(this);
			if($this.hasClass('up')){
				ComparePanel.show();
			}else{
				ComparePanel.hide();
			}
		});
		
		$('#compare-panel span.delete').click(function(){
			var $slot = $(this).next('.slot');
			ComparePanel.removeFloorplan($slot);
		});
			
		$('#compare-panel .clear').click(function(){
			$('#compare-panel .list .slot').each(function(){
				ComparePanel.removeFloorplan($(this));
			});
		});	
		
		$('#compare-panel .btn-compare').click(function(){
			if($(this).hasClass('disabled')){
				return false;
			}
		});
		
		var floorplans = FloorPlan.items();
		for(var i = 0; i < floorplans.length; i++){
			var $slot = $($('#compare-panel .slot')[i]);
			var id = floorplans[i].id;
			var image = floorplans[i].image;
			var $img = $('<img>').attr('src', image);
			
			ComparePanel.fillSlot($img, id, $slot);
		}
		ComparePanel.updateCompareButton();

	},
	show:function(callback){
		$('#compare-panel').animate({
			bottom:0
		},500, function(){
			$('#compare-overlay').show();
			$('#compare-panel .tab').removeClass('up').addClass('down');
			if(callback != undefined){
				callback();
			}
		});
	},
	hide:function(){
		$('#compare-panel').animate({
			bottom:-180
		},500, function(){
			$('#compare-overlay').hide();
			$('#compare-panel .tab').removeClass('down').addClass('up');
		});
	},
	addFloorplan:function(){
		if(FloorPlan.get(Main.currentApartmentId) != null){
			alert("You already added this floorplan, please select another one.");
			return;	
		}
		
		if(FloorPlan.length() >= 4){
			alert("Your compare list is full, please remove one first.");
			return;
		}
		
		var image = $('#lightbox .floorplan .image img').attr('src');
		FloorPlan.add({'id': Main.currentApartmentId, 'image': image});
		
		ComparePanel.show(function(){
			$('#compare-panel .slot').each(function(){
				if(!$(this).hasClass('filled')){
					var $slot= $(this);
					var offset = $('#lightbox .floorplan .image img').offset();
					var currentX = offset.left;
					var currentY = offset.top;
					
					var newOffset = $(this).offset();
					var gotoX = newOffset.left + 1;
					var gotoY = newOffset.top + 1;
					var newWidth = 120;
					var newHeight = 90;
					
					var $img = $('#lightbox .floorplan .image img').clone();
					$img.css({
						'position':'absolute',
						'z-index':1000,
						'left':currentX,
						'top':currentY,
						'width':576,
						'opacity':0.4
					}).appendTo('body').animate({
						opacity: 1,
						left: gotoX,
						top: gotoY,
						width: newWidth,
						height: newHeight
						},1000,function(){
							$img.remove();
							var $img2 = $('#lightbox .floorplan .image img').clone();
							ComparePanel.fillSlot($img2, Main.currentFloorplanId, $slot);
						});
					ComparePanel.updateCompareButton();
					return false;
				}
			});
		});		
	},
	removeFloorplan:function($slot){
		$slot.removeClass('filled').find('span').show().end().find('img').remove().end().prev('.delete').hide();
		var id = $slot.data('id');
		FloorPlan.remove(id);
		
		ComparePanel.updateCompareButton();
	},
	updateCompareButton:function(){
		if(FloorPlan.length() > 1){
			$('#compare-panel .btn-compare').removeClass('disabled');
		}else{
			$('#compare-panel .btn-compare').addClass('disabled');
		}
	},
	fillSlot:function($img, id, $slot){
		$img.attr('width', 120).attr('height', 90).prependTo($slot);
		$slot.addClass('filled').data('id', id).find('span').hide().end().prev('.delete').show();
	}
}

Compare = {
	viewModel:null,
	initProjectList:function(){
		var arr = Array();
		for(var i = 0; i < 4; i++){
			arr.push({
				name: '',
				image: '',
				suburb: '',
				distance: '',
				price: '',
				pricesqm: '',
				bedroom: '',
				bathroom: '',
				carspace: '',
				level: '',
				internalArea: '',
				externalArea: '',
				totalArea: '',
				studyRoom: '',
				openBalcony: '',
				enclosedBalcony: '',
				countryard: '',
				existing: '',
				amenity: {
					reception: false,
					swimmingPool: false,
					saunaRoom: false,
					tennisCourt: false,
					functionRoom: false,
					theatreCinema: false,
					library: false,
					bbq: false,
					landscaping: false,
					skyGarden: false,
					visitorParking: false,
					carWashBay: false,
					gym: false,
					kidsPlayGround: false,
					playRoom: false,
					recreationPlace: false,
					musicRoom: false
				}
			});
		}
		return arr;
	},
	init: function(){		
		$('div.project-column div, div.label-column div').mouseover(function(){		
			var row = $(this).data('row');
			if(row != null){
				$(this).addClass('highlight');
				$('.compare-table div[data-row="' + row + '"]').addClass('highlight');
			}			
		}).mouseleave(function(){			
			var row = $(this).data('row');
			if(row != null){
				$(this).removeClass('highlight');
				$('.compare-table div[data-row="' + row + '"]').removeClass('highlight');
			}
		});
		
		Compare.viewModel = {
			projects: ko.observableArray(Compare.initProjectList())
		};
		ko.applyBindings(Compare.viewModel);
		
		$.ajax({
          url: Main.root + 'estate/json/compare.action',
          dataType: "json",
          type: "GET",
          success: function(data){
              if(data.rs != null && data.rs != undefined){
              	var apartments = data.rs;
              	for(var i = 0; i < apartments.length; i++){
              		var apartment = apartments[i];
              		var pricePerSquare = (apartment.price / apartment.floorplan.totalSize).toFixed(0);
              		Compare.viewModel.projects.replace(Compare.viewModel.projects()[i], {
              			name: apartment.floorplan.building.stage.project.name,
              			image: '<a href="' + apartment.floorplan.salePicture.largeUrl + '" target="_blank"><img src="' + apartment.floorplan.salePicture.mediumUrl + '" width="190" height="143" alt=""/></a>',
              			suburb: apartment.floorplan.building.stage.project.suburb.name,
						distance: apartment.floorplan.building.stage.project.distanceToCity + 'km',
						price: '$' + apartment.price,
						pricesqm: '$' + pricePerSquare + '/m<sup>2</sup>',
						bedroom: apartment.floorplan.bedRoomCount,
						bathroom: apartment.floorplan.bathroomCount,
						carspace: apartment.carParkingCount,
						level: apartment.floorLevel,
						internalArea: apartment.floorplan.internalSize + 'm<sup>2</sup>',
						externalArea: apartment.floorplan.externalSize + 'm<sup>2</sup>',
						totalArea: apartment.floorplan.totalSize + 'm<sup>2</sup>',
						studyRoom: apartment.floorplan.studyroomCount > 0 ? '<i class="tick"></i>' : '<i class="cross"></i>',
						openBalcony: apartment.floorplan.openBaclonyCount > 0 ? '<i class="tick"></i>' : '<i class="cross"></i>',
						enclosedBalcony: apartment.floorplan.enclosedBaclonyCount > 0 ? '<i class="tick"></i>' : '<i class="cross"></i>',
						countryard: apartment.floorplan.courtyardCount > 0 ? '<i class="tick"></i>' : '<i class="cross"></i>',
						existing: apartment.floorplan.building.readyHouse ? '<i class="tick"></i>' : '<i class="cross"></i>',
              			amenity: {
              				reception: apartment.floorplan.building.stage.project.recreationPlace,
							swimmingPool: apartment.floorplan.building.stage.project.swimmingPool,
							saunaRoom: apartment.floorplan.building.stage.project.sauna,
							tennisCourt: apartment.floorplan.building.stage.project.tennisCourt,
							functionRoom: apartment.floorplan.building.stage.project.funcRoom,
							theatreCinema: apartment.floorplan.building.stage.project.theatreCinema,
							library: apartment.floorplan.building.stage.project.library,
							bbq: apartment.floorplan.building.stage.project.bbq,
							landscaping: apartment.floorplan.building.stage.project.landScaping,
							skyGarden: apartment.floorplan.building.stage.project.skyGarden,
							visitorParking: apartment.floorplan.building.stage.project.visitorParking,
							carWashBay: apartment.floorplan.building.stage.project.carWashBay,
							gym: apartment.floorplan.building.stage.project.gym,
							kidsPlayGround: apartment.floorplan.building.stage.project.kidsPlayGround,
							playRoom: apartment.floorplan.building.stage.project.playRoom,
							recreationPlace: apartment.floorplan.building.stage.project.recreationPlace,
							musicRoom: apartment.floorplan.building.stage.project.musicRoom
              			}
              		});
              	}
              }
          }
        });
	}
},

InterestList = {
	add: function(){
		if(Main.currentClientId == null || Main.currentClientId == 'null'){
			alert('Please select a client first!');
			return;	
		}
		
		if(Main.currentApartmentId == null || Main.currentApartmentId == 0){
			alert('Please select an apartment first!');
			return;
		}
		
		$.ajax({
			url: Main.root + 'profile/json/addAppartmentToList.action?propertyId=' + Main.currentApartmentId,
			dataType: "json",
			type: "GET",
			success: function(data){
				alert('This apartment has been added to your interest list.');
			}
        });
	}
};

ClientForm = {
	viewModel : null,
	init: function(){
		$('#client-tabs').tabs();
		
		ClientForm.viewModel = {
			title : ko.observable(),
			givenName : ko.observable(),
			surname : ko.observable(),
			preferredName : ko.observable(),
			gender: ko.observable(),
			status: ko.observable(),
			mobileNumber : ko.observable(),
			email: ko.observable(),
			homeAddress: ko.observable(),
			homePostcode: ko.observable(),
			requirements: ko.observableArray(),
			interestList: ko.observableArray(),
			currentRequirement:	ko.observable({
				minPrice: ko.observable('0'),
				maxPrice: ko.observable('0'),
				bedrooms: ko.observableArray(),
				bathrooms: ko.observableArray(),
				carspaces: ko.observableArray(),
				distancetocity: ko.observable(),
				status: ko.observable(),
				trainStation: ko.observable(),
				shoppingCenter: ko.observable(),
				chineseCommunity: ko.observable(),
				university: ko.observable(),
				school: ko.observable(),
				description: ko.observable('')
			})	
		};
		
		ClientForm.viewModel.removeRequirement = function(){
			if(confirm("Are you sure?")){
				var requirement = this;
				var id = requirement.id;
				Main.loadingShow();
				$.ajax({
					url: Main.root + 'profile/json/removeClientRequirement.action?id=' + id,
					dataType: "json",
					type: "GET",
					success: function(data){
						Main.loadingHide();
						if(data.errorMessages.length > 0){
							alert(data.errorMessages[0]);
						}else{
							ClientForm.viewModel.requirements.remove(requirement);
						}
					}
				});
			}
		};
		
		ClientForm.viewModel.matchRequirement = function(){
			var req = this;
			var conditions = Search.conditions;			
			conditions.minPrice = req.minPrice;
			if(conditions.minPrice == null){
				conditions.minPrice = 0;
			}
			conditions.maxPrice = req.maxPrice;
			if(conditions.maxPrice == null){
				conditions.maxPrice = 0;
			}
		
			conditions.bedrooms =  req.bedRoomCountStr;
			conditions.bathrooms = req.bathRoomCountStr;
			conditions.carspace = req.carParkingCountStr;	
		
			conditions.distanceToCity = req.distanceToCity;
			conditions.trainStation = req.train ? true : 'null';
			conditions.schools = req.schools ? true : 'null';
			conditions.universities = req.universities ? true : 'null';
			conditions.chineseCommunity = req.chineseCommunity ? true : 'null';
			conditions.shoppingCenter = req.shoppingCenter ? true : 'null';
			var status = '';
			if(req.readyHouse === true){
				status = '1';
			}else if(req.readyHouse === false){
				status = '0';
			}
			conditions.status = status;
			
			var jsonString = JSON.stringify(Search.conditions);
			$.cookie("conditions", jsonString,{ expires: 1, path: '/' });
			
			window.location.href = "/";	
		};
		
		ClientForm.viewModel.getPriceRange = function(minPrice, maxPrice){
			return Tools.convertPrice(minPrice) + ' to ' + Tools.convertPrice(maxPrice);
		};
		
		ko.applyBindings(ClientForm.viewModel);
		
		$('.client select').selectbox();
		$('.client input:checked').parent('span').addClass('checked');
		
		var clientId = Tools.getParameterByName('id');
		if(clientId != ""){
			Main.loadingShow();
			$.ajax({
				type: 'GET',
				url: Main.root + "profile/json/viewClientDetail.action?clientId=" + clientId,
				dataType: "json",
				success: function(json){
					Main.loadingHide();
					var client = json.client;
					if(client != null){
						ClientForm.viewModel.title(client.title);
						$('#client-form select[name="title"]').selectbox('change', client.title, client.title);
						ClientForm.viewModel.givenName(client.givenName);
						ClientForm.viewModel.surname(client.surname);
						ClientForm.viewModel.preferredName(client.preferredName);
						ClientForm.viewModel.gender(client.gender);
						ClientForm.viewModel.status(client.status);
						$('#client-form select[name="status"]').selectbox('change', client.status, client.status);
						ClientForm.viewModel.mobileNumber(client.mobileNumber);
						ClientForm.viewModel.email(client.email);
						ClientForm.viewModel.homeAddress(client.homeAddress);
						ClientForm.viewModel.homePostcode(client.homePostcode);
					}
				}
			});
			
			$.ajax({
				type: 'GET',
				url: Main.root + "profile/json/demandClientRequirement.action?qc.clientId=" + clientId,
				dataType: "json",
				success: function(json){
					if(json.errorMessages.length > 0){
						alert(json.errorMessages[0]);
					}else{
						ClientForm.viewModel.requirements(json.requirements);
					}
				}
			});
			
			$.ajax({
				type: 'GET',
				url: Main.root + "profile/json/viewInterestList.action?clientId=" + clientId,
				dataType: "json",
				success: function(json){
					if(json.errorMessages.length > 0){
						alert(json.errorMessages[0]);
					}else{
						ClientForm.viewModel.interestList(json.interestList.apartments);
					}
				}
			});
		}
		
		$('#client-form').validate({
			submitHandler: function(form){
				var data = {
					'client.title' : ClientForm.viewModel.title,
					'client.givenName' : ClientForm.viewModel.givenName,
					'client.surname' : ClientForm.viewModel.surname,
					'client.preferredName' : ClientForm.viewModel.preferredName,
					'client.gender' : ClientForm.viewModel.gender,
					'client.status' : ClientForm.viewModel.status,
					'client.mobileNumber' : ClientForm.viewModel.mobileNumber,
					'client.email' : ClientForm.viewModel.email,
					'client.homeAddress' : ClientForm.viewModel.homeAddress,
					'client.homePostcode' : ClientForm.viewModel.homePostcode
				};
				if(clientId != ''){
					data["client.id"] = clientId;
				}
				Main.loadingShow();
				$.ajax({
					type: 'POST',
					url: Main.root + "profile/json/saveOrUpdateClient.action",
					data: data,
					dataType: "json",
					success: function(json){
						Main.loadingHide();
						Tools.showSuccessMessage('Client has been updated!');
					}
				});
			}
		});
		
		$('#requirement-form').validate({
			submitHandler: function(form){
				if(clientId == ''){
					alert('Please select a client first!');
					return;
				}
				
				var status = 'null';
				if(ClientForm.viewModel.currentRequirement().status() == '1'){
					status = true;
				}else if(ClientForm.viewModel.currentRequirement().status() == '0'){
					status = false;
				}
				
				var data = {
					'model.client.id': clientId,
					'model.minPrice' : ClientForm.viewModel.currentRequirement().minPrice(),
					'model.maxPrice' : ClientForm.viewModel.currentRequirement().maxPrice(),
					'model.bedRoomCountStr' : ClientForm.viewModel.currentRequirement().bedrooms().join(','),
					'model.bathRoomCountStr' : ClientForm.viewModel.currentRequirement().bathrooms().join(','),
					'model.carParkingCountStr' : ClientForm.viewModel.currentRequirement().carspaces().join(','),
					'model.distanceToCity' : ClientForm.viewModel.currentRequirement().distancetocity(),
					'model.readyHouse':  status,
					'model.train': ClientForm.viewModel.currentRequirement().trainStation(),
					'model.shoppingCenter': ClientForm.viewModel.currentRequirement().shoppingCenter(),
					'model.chineseCommunity' : ClientForm.viewModel.currentRequirement().chineseCommunity(),
					'model.universities' : ClientForm.viewModel.currentRequirement().university(),
					'model.schools' : ClientForm.viewModel.currentRequirement().school(),
					'model.description' : ClientForm.viewModel.currentRequirement().description()
				};
				
				var req = {
					minPrice : ClientForm.viewModel.currentRequirement().minPrice(),
					maxPrice : ClientForm.viewModel.currentRequirement().maxPrice(),
					bedRoomCountStr : ClientForm.viewModel.currentRequirement().bedrooms().join(','),
					bathRoomCountStr : ClientForm.viewModel.currentRequirement().bathrooms().join(','),
					carParkingCountStr : ClientForm.viewModel.currentRequirement().carspaces().join(','),
					distanceToCity : ClientForm.viewModel.currentRequirement().distancetocity(),
					readyHouse:  status,
					train: ClientForm.viewModel.currentRequirement().trainStation(),
					shoppingCenter: ClientForm.viewModel.currentRequirement().shoppingCenter(),
					chineseCommunity : ClientForm.viewModel.currentRequirement().chineseCommunity(),
					universities : ClientForm.viewModel.currentRequirement().university(),
					schools : ClientForm.viewModel.currentRequirement().school(),
					description : ClientForm.viewModel.currentRequirement().description()
				};
				
				Main.loadingShow();
				$.ajax({
					type: 'POST',
					url: Main.root + "profile/json/createOrUpdateClientRequirement.action",
					data: data,
					dataType: "json",
					success: function(json){
						Main.loadingHide();
						Tools.showSuccessMessage('Requirement has been updated.');
						ClientForm.viewModel.requirements.push(req);
						ClientForm.viewModel.currentRequirement({});
					}
				});
				
			}
		});
	}	
};

ClientList = {
	viewModel: null,
	init: function(){
		ClientList.viewModel = {
			clients : ko.observableArray()
		}
		ClientList.viewModel.removeClient = function(){
			if(confirm("Are you sure?")){
				var client = this;
				var id = client.id;
				Main.loadingShow();
				$.ajax({
					url: Main.root + 'profile/json/disableClient.action?clientId=' + id,
					dataType: "json",
					type: "GET",
					success: function(data){
						Main.loadingHide();
						if(data.errorMessages.length > 0){
							alert(data.errorMessages[0]);
						}else{
							ClientList.viewModel.clients.remove(client);
						}
					}
				});
			}
		}
		
		$.ajax({
			url: Main.root + 'profile/json/viewMineClients.action?qc.enabled=true',
			dataType: "json",
			type: "GET",
			success: function(data){
				ClientList.viewModel.clients(data.clients);
				ko.applyBindings(ClientList.viewModel);
			}
		});
	}
};

ProjectPage = {
	map: null,
	init: function(){
		$('div.scrollable').scrollable();
		
		$('#gallery-list .items a').click(function(e){
			e.preventDefault();
			if($(this).hasClass('active')){
				return false;
			}
			
			var url = $(this).attr('href');
			$('#gallery-main').fadeTo("medium", 0.5);
			var img = new Image();
 
			img.onload = function() {		 
				$('#gallery-main').fadeTo("fast", 1);
				$('#gallery-main').find("img").attr("src", url);		 
			};
			img.src = url;
			
			$('#gallery-list .items a').removeClass('active');
			$(this).addClass('active');
			
			return false;
		});
		
		var latLng = new google.maps.LatLng(-34.007509, 151.101848);
		var mapOptions = {
    		zoom: 15,
    		minZoom: 11,
    		maxZoom: 20,
    		center: latLng,
    		mapTypeId: google.maps.MapTypeId.ROADMAP,
    		mapTypeControl: false,
    		streetViewControl: false,
    		panControl: false,
    		zoomControlOptions: {
    			position: google.maps.ControlPosition.LEFT_CENTER
    		}
  		}
  		this.map = new google.maps.Map(document.getElementById("googlemap"), mapOptions);
  		
  		var marker = new google.maps.Marker({
			position: latLng,
			map: ProjectPage.map
		});
		
		$("select.selectbox").selectbox();
	}
}

Tools = {
	getCheckboxListValue: function(name){
		var value = '';
		$('input[name="' + name +'"]:checked').each(function(){
			value = value + $(this).val() + ',';
		});
		if(value.length > 0){
			value = value.substr(0,value.length -1);
		}
		return value;
		
	},
	getTrueOrFalseIcon: function(num){
		if(num == 1){
			return '有';
		}else{
			return '无';
		}
	},
	getAspect: function(orientationEast, orientationNorth, orientationSouth, orientationWest){
		var orientation = '';
		if(orientationEast){
			orientation += '东';
		}
		if(orientationSouth){
			orientation += '南';
		}
		if(orientationWest){
			orientation += '西';
		}
		if(orientationNorth){
			orientation += '北';
		}
		
		return orientation;
	},
	numberWithCommas: function (x) {
		if(x != null && x != undefined){
    		return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    	}else{
    		return x;
    	}
	},
	sortByMinPrice: function(arr){
		function compare(a, b){
			if(a.minPrice < b.minPrice){
				return -1;
			}
			else if(a.minPrice > b.minPrice){
				return 1;
			}
			return 0;
		}
		
		return arr.sort(compare);
	},
	sortByPricePerSQM: function(arr){
		function compare(a, b){
			if(a.avgPricePerSQM < b.avgPricePerSQM){
				return -1;
			}
			else if(a.avgPricePerSQM > b.avgPricePerSQM){
				return 1;
			}
			return 0;
		}
		
		return arr.sort(compare);
	},
	sortByArea: function(arr){
		function compare(a, b){
			if(a.totalSize < b.totalSize){
				return -1;
			}
			else if(a.totalSize > b.totalSize){
				return 1;
			}
			return 0;
		}
		
		return arr.sort(compare);
	},
	showSuccessMessage: function(msg){
		$("html, body").animate({ scrollTop: 0 });
		var $msg = $('<div class="ui-state-highlight ui-corner-all message"><span class="ui-icon ui-icon-info"></span> ' + msg + '</div>');
		$('#content').prepend($msg);
		setTimeout(function() {
			$msg.remove();
		}, 5000);
	},
	getParameterByName: function(name) {
		name = name.replace(/[\[]/, "\\\[").replace(/[\]]/, "\\\]");
		var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
			results = regex.exec(location.search);
		return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
	},
	convertPrice: function(num){
		switch(num){
			case 1:
				return '$450,000';
			case 2:
				return '$550,000';
			case 3:
				return '$650,000';
			case 4:
				return '$750,000';
			case 5:
				return '$850,000';
			case 6:
				return '$850,000+';
			default:
				return 'Any Price';
		}
	}
}

String.prototype.capitalize = function () {
    return this.replace(/^./, function (char) {
        return char.toUpperCase();
    });
};

/* ClusterOverlay Class */
function ClusterOverlay(cluster, map){
	this._count = cluster.projectCounts;
	this._map = map;
	this._div = null;
	this._markerCenter = new google.maps.LatLng(cluster.latitude, cluster.longitude);
	this._imageCenter = null;
	this._zoomLevel = cluster.zoomLevel;
	this._shape = cluster.polylines;
	this._overlay = null;
	this._statusDiv = null;
	this._name = cluster.name;
	
	this.zoom = function(){		
        this._map.setCenter(this._markerCenter);
        this._map.setZoom(this._zoomLevel);
	}
	
	this.showStatus = function(){
		this._div.appendChild(this._statusDiv);
		$(this._statusDiv).css("left", $(this._div).width() + 5)
			.css("top", ($(this._div).height() - $(this._statusDiv).outerHeight()) / 2);
	}
	
	this.hideStatus = function(){
		if(this._statusDiv != null && this._statusDiv.parentNode != null){
			this._statusDiv.parentNode.removeChild(this._statusDiv);
		}
	}
	
	this.setMap(this._map);
}
ClusterOverlay.prototype = new google.maps.OverlayView();
ClusterOverlay.prototype.onAdd = function(){
	this._div = document.createElement("DIV");
	this._div.className = "cluster";
	this._div.innerHTML = "<div class='top'><div class='name'>"+ this._name + "</div></div><div class='bottom'>" + this._count +"</div>";
	
	this._statusDiv = document.createElement("DIV");
	this._statusDiv.className = "clusterStatus";
	this._statusDiv.innerHTML = "<span>"+ this._name +"</span>";
	
	var thisCluster = this;
	$(this._div).click(function(){
		thisCluster.zoom();
	});
	
	if(this._shape != null){
		//this._overlay = new ClusterPolygon(this, this._shape, this._map);
	}else{
		$(this._div).mouseover(function(){
			//thisCluster.showStatus();
		});
		
		$(this._div).mouseout(function(){
			//thisCluster.hideStatus();
		});
	}
	
	var panes = this.getPanes();
	panes.overlayMouseTarget.appendChild(this._div);
}
ClusterOverlay.prototype.draw = function(){	
	var path =  Main.imageRoot + "img/maps/";
	var image = null;
	var width = null;
	var height = null;	
	image = path + "cluster.png";
	width = height = 90;

	this._div.style.backgroundImage = "url('" + image + "')";
	//this._div.style.width = width + "px";
	//this._div.style.height = height + "px";
	
	this._imageCenter = this.getProjection().fromLatLngToDivPixel(this._markerCenter);
	this._div.style.left = (this._imageCenter.x - (width / 2)) + "px";
	this._div.style.top = (this._imageCenter.y - (height / 2)) + "px";
}
ClusterOverlay.prototype.onRemove = function(){
	if(this._div.parentNode != null){
		this._div.parentNode.removeChild(this._div);
		this._div = null;
		
		if(this._overlay != null){
			this._overlay.setMap(null);
			this._overlay = null;
		}
	}
}

/* ClusterPolygon Class */
function ClusterPolygon(clusterOverlay, shape, map){
	this._clusterOverlay = clusterOverlay;
	this._map = map;
	this._options = {
		fillColor: '#666666',
		fillOpacity: 0.0,
		strokeColor: '#2789b1',
		strokeOpacity: 0.0,
		strokeWeight: 3,
		zIndex: 1
	};
	this._optionsHover = {
		strokeOpacity: 0.8,
		fillOpacity: 0.08
	}
	
	var rings = new Array();
	for(var i = 0; i < shape.length; i++){
		rings.push(new google.maps.LatLng(shape[i].latitude, shape[i].longitude));
	}
	
	this.setOptions(this._options);
	this.setPaths(rings);
	this.setMap(this._map);
	
	google.maps.event.addListener(this, 'mouseover', function(){
		this.setOptions(this._optionsHover);
		//this._clusterOverlay.showStatus();
	});
	
	google.maps.event.addListener(this, 'mouseout', function(){
		this.setOptions(this._options);
		//this._clusterOverlay.hideStatus();
	})
	
	google.maps.event.addListener(this, 'click', function(){
		this._clusterOverlay.zoom();
	})
}
ClusterPolygon.prototype = new google.maps.Polygon();

/* ProjectOverlay Class */
function ProjectOverlay(project, map){
	this._map = map;
	this._div = null;
	this._logo = project.picture.mediumUrl;
	this._markerCenter = new google.maps.LatLng(project.latitude, project.longitude);
	this._imageCenter = null;
	this._projectId = project.id;
	
	this.setMap(this._map);
}
ProjectOverlay.prototype = new google.maps.OverlayView();
ProjectOverlay.prototype.onAdd = function(){
	this._div = document.createElement("DIV");
	this._div.className = "project";
	this._div.innerHTML = "<img src='" + this._logo + "' width='140' height='94'/>";
	
	var center = this._markerCenter;
	var projectId = this._projectId;
	$(this._div).click(function(){
		Map.center = center;
		Map.map.setCenter(Map.center);
		
		if(Main.currentProjectId == projectId){
			PanelPopup.load(projectId);
		}else{
			Main.currentProjectId = projectId
			if(Main.currentRadiusWidget != null){
				Main.currentRadiusWidget.destroy();
				Main.currentRadiusWidget = new RadiusWidget();
			}
			MapMenu.resetMenu();
		}		
	});
	
	$(this._div).mouseover(function(){
		$(this).css('z-index', '1000');
	});
	
	$(this._div).mouseout(function(){
		$(this).css('z-index', '300');
	});
	
	var panes = this.getPanes();
	panes.overlayMouseTarget.appendChild(this._div);
}
ProjectOverlay.prototype.draw = function(){		
	this._imageCenter = this.getProjection().fromLatLngToDivPixel(this._markerCenter);
	
	var img = new Image();
	var div = this._div;
	var left = this._imageCenter.x;
	var top = this._imageCenter.y;
	
	img.onload = function() {
		div.style.left = (left - (140 / 2) - 3) + "px";
		div.style.top = (top - (94 / 2) - 13) + "px";
	}
	img.src = this._logo;
}
ProjectOverlay.prototype.onRemove = function(){
	if(this._div.parentNode != null){
		this._div.parentNode.removeChild(this._div);
		this._div = null;
	}
}

/* Radius Widget */
function RadiusWidget() {
	this.setOptions({
		strokeWeight: 2,
		fillColor: '#fa702d',
		strokeColor:'#fa702d',
		editable:true,
		radius:1000,
		center: Map.center
	});

	this.setMap(Map.map);
	this._distanceOverlay = new DistanceOverlay();
	
	google.maps.event.addListener(this, 'radius_changed', function(){
		var radius = this.getRadius();
		this._distanceOverlay.update(radius);
	});
}
RadiusWidget.prototype = new google.maps.Circle();
RadiusWidget.prototype.destroy = function () {
	this.setMap(null);
	this._distanceOverlay.setMap(null);
};

/* ProjectOverlay Class */
function DistanceOverlay(){
	this._div = null;	
	this.setMap(Map.map);
}
DistanceOverlay.prototype = new google.maps.OverlayView();
DistanceOverlay.prototype.onAdd = function(){
	this._div = document.createElement("DIV");
	this._div.className = "radiusDistance";
	this._div.innerHTML = "<span>1.0km</span>";
		
	var center = this.getProjection().fromLatLngToDivPixel(Map.center); 
	this._div.style.left = (center.x + 120) + "px";
	this._div.style.top = (center.y - 10) + "px";
	
	var panes = this.getPanes();
	panes.overlayMouseTarget.appendChild(this._div);
}
DistanceOverlay.prototype.onRemove = function(){
	if(this._div.parentNode != null){
		this._div.parentNode.removeChild(this._div);
		this._div = null;
	}
}
DistanceOverlay.prototype.update = function(radius){
	var distance = (radius / 1000).toFixed(1);
	this._div.innerHTML = "<span>" + distance + "km</span>";
}
DistanceOverlay.prototype.draw = function(){
	
}
