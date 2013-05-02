Main = {
	root: '/befun-web/',
	imageRoot: '/',
	isLoading:false,
	isHome:false,
	currentProjectId:null,
	currentFloorplanId:null,
	currentRadiusWidget:null,
	init:function(){
		this.isHome = true;
		this.windowResize();
		$(window).resize(this.windowResize);
		this.initFilter();
		//this.initLogin();
		MapMenu.init();
		PanelPopup.init();
		FloorplanPopup.init();
		ComparePanel.init();
		Search.init();
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
			
			if(!$('#signin-panel').is(':visible')){	
				$('#filter-overlay').toggle();
			}
			
		});
		
		$('#filter #more-features').click(function(){
			$('#features-filter').toggle();
			if($(this).next('i').hasClass('arrow-down')){
				$(this).next('i').removeClass().addClass('arrow-up');
			}else if($(this).next('i').hasClass('arrow-up')){
				$(this).next('i').removeClass().addClass('arrow-down');
			}
		});
		
		$("select.selectbox").selectbox();
		
		$('#reminder-nodes .filterNode').live('click', function(){
			$('#btn-filter').click();
		});
		
		$('#filter-overlay').click(function(){
			PanelPopup.hide();
			Main.hideFilter();
		});
	},
	initLogin: function(){
		$('#signin').click(function(){
			$('#signin-panel').toggle();
			
			if(!$('#filter').is(':visible')){	
				$('#filter-overlay').toggle();
			}
		});
		
		$('#login-form').submit(function(){
			var valid = true;
			if($('#login-form input[name="email"]').val().lengt == 0){
				valid = false;
			}
			if($('#login-form input[name="password"]').val().length == 0){
				valid = false
			}
			return valid;
		});
	},
	hideFilter:function(){
		$('#filter').hide();
		$('#signin-panel').hide();
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
			var $div = $('<div class="' + cls +'" data-id="' + project.id + '" data-lat="' + project.latitude + '" data-lng="' + project.longitude + '"><img src="' + project.logo.smallUrl + '" alt="' + project.name + '" height="70" width="170" /></div>');
			
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
		
		if(conditions.trainStation){
			$('#reminder-nodes').append('<div class="filterNode"><span>Train Station</span></div>');
		}
	
		if(conditions.chineseCommunity){
			$('#reminder-nodes').append('<div class="filterNode"><span>Chinese Community</span></div>');
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
				window.location.href = "/";	
			}
		});
	},
	saveConditions:function(){
		this.setConditions();
		var jsonString = JSON.stringify(Search.conditions);
		$.cookie("conditions", jsonString,{ expires: 365, path: '/' });
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
		conditions.trainStation = $('#filter input[name="train"]').is(":checked") ? true : null;
		conditions.schools = $('#filter input[name="schools"]').is(":checked") ? true : null;
		conditions.universities = $('#filter input[name="universities"]').is(":checked") ? true : null;
		conditions.chineseCommunity = $('#filter input[name="chinese"]').is(":checked") ? true : null;
		conditions.shoppingCenter = $('#filter input[name="shpppingcenter"]').is(":checked") ? true : null;
		conditions.status = $('#filter select[name="status"]').val();
		
		Search.conditions = conditions;
	},
	loadConditions: function(){
		var cookie = $.cookie("conditions");
		if(cookie != null && cookie != ''){
			Search.conditions = JSON.parse(cookie);
			var conditions = Search.conditions;
		
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
			
			this.clearConditions();
		}
	},
	clearConditions:function(){
		$.removeCookie("conditions");
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
			
			var data = {
				'qc.suburbId': conditions.suburbId, 
				'qc.distanceToCity': conditions.distanceToCity,
				bedroom_count: conditions.bedrooms,
				bathroom_count: conditions.bathrooms,
				car_parking_count: conditions.carspace,
				house_type: conditions.propertyType,
				//'qc.apQC.minPrice': conditions.minPrice,
				//'qc.apQC.maxPrice': conditions.maxPrice,
				ready_house: conditions.status
			};
			
			if(conditions.chineseCommunity){
				data['qc.suburbQC.chineseCommunity'] = true;
			}
			
			if(conditions.trainStation){		
				data['qc.suburbQC.train'] = true;
			}
			
			if(conditions.schools){
				data['qc.suburbQC.schools'] = true;
			}
			
			if(conditions.universities){
				data['qc.suburbQC.universities'] = true;
			}
			
			if(conditions.shoppingCenter){
				data['qc.suburbQC.shoppingCenter'] = true;
			}
						
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
		
		$('#floorplan-list .item').live('click', function(){
			FloorplanPopup.load($(this).data('id'));
		});
		
		$('#floorplan-list2 .item').live('click', function(){
			FloorplanPopup.load($(this).data('id'));
			$('#floorplan-list2 .item').removeClass('active');
			$(this).addClass('active');
		})
		
		$("#overview-list .scrollable").scrollable();
		$("#floorplan-list .scrollable").scrollable({vertical: true});
		$('#floorplan-list2 .scrollable').scrollable();
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
						bedroom_count: conditions.bedrooms,
						bathroom_count: conditions.bathrooms,
						car_parking_count: conditions.carspace,
						min_price: conditions.minPrice,
						max_price: conditions.maxPrice
					},
				dataType: "json",
				success: function(json){
					var project = json.view;
					if(project != null && project != undefined){
						$('#project-name').text(project.name);
						$('#subtab-description .detail').html(project.description);
						$('#subtab-features .detail').html(project.features);
						$('#subtab-finish .detail').html(project.finish);
						$('#subtab-amenity .detail').html(project.amenity);
						$('#subtab-data').html(project.data);
						$('#subtab-condition').html(project.condition);
						$('#subtab-offers').html(project.offers);
						
						var photos = project.medias;
						$('#overview-main').empty();
						$('#overview-main').append('<img src="' + photos[0].mediumUrl + '" width="510" height="343" alt=""/>');
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
		
		$('#lightbox .sort a').click(function(){
			if($(this).hasClass('active')){
				return;
			}
			
			$('#lightbox .sort a').removeClass('active');
			$(this).addClass('active');
		});
		
		$('#lightbox .close').click(function(){
			FloorplanPopup.hide();
		});
		$('#lightbox-overlay').click(function(){
			FloorplanPopup.hide();
		});
		
		$('#lightbox #units a').live('click', function(e){
			e.preventDefault();
			
			if($(this).hasClass('active')){
				return false;
			}
			
			var target = $(this).attr('href');
			if($(target).hasClass('hidden')){
				$(target).siblings('.shown').removeClass('shown').addClass('hidden');
				$(target).removeClass('hidden').addClass('shown');
			}
			
			$('#lightbox #units a').removeClass('active');
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
						var img = '<img src="' + floorplan.salePicture.mediumUrl + '" alt=""/>';
						$('#lightbox .floorplan .image').html(img);
						$('#units .items').empty();
						$('#apartments').empty();
						
						if(floorplan.apartments.length > 0){
							var apartments = floorplan.apartments;
							for(var i = 0; i < apartments.length; i++){
								var apartment = apartments[i];
								var active = ''
								if(i == 0){
									active = 'active';
								}
								
								var $item = $('<a href="#' + apartment.id + '" class="item ' + active + '">' + apartment.unitNumber + '</a>');
								var index = Math.floor(i / 7);
								
								var $div = $('#units').find('div:data[id='+ index + ']');
								if($div == null || $div.length == 0){
									$div = $('<div data-id="' + index + '"></div>');
									$('#units .items').append($div);
								}
								$div.append($item);
								
								var div = '<div id="{id}" class="{cls}">' +
											'<div class="name">{unit}</div>' +
											'<table>' +
												'<tr>' +
													'<td width="25"></td>' +
													'<td width="25"><i class="building"></i></td>' +
													'<td width="80">{building}</td>' + 
													'<td width="25"><i class="lot"></i></td>' +
													'<td>{lot}</td>' +
												'</tr>' +
												'<tr class="even">' +
													'<td></td>' +
													'<td>SPT</td>' +
													'<td>{split}</td>' +
													'<td>STG</td>' +
													'<td>{stage}</td>' +
												'</tr>' +
												'<tr>' +
													'<td></td>' + 
													'<td><i class="level"></i></td>' +
													'<td>{level}</td>' + 
													'<td><i class="color"></i></td>' +
													'<td>{color}</td>' +
												'</tr>' +
												'<tr class="even">' +
													'<td></td>' +
													'<td><i class="bedroom"></i></td>' +
													'<td>{bedrooms}</td>' +
													'<td><i class="bathroom"></i></td>' +
													'<td>{bathrooms}</td>' +
												'</tr>' +
												'<tr>' +
													'<td></td>' + 
													'<td><i class="study"></i></td>' +
													'<td>{study}</td>' + 
													'<td>ASP</td>' +
													'<td>{aspect}</td>' +
												'</tr>' +
												'<tr class="even">' +
													'<td></td>' +
													'<td><i class="openbalcony"></i></td>' +
													'<td>{openbaclony}</td>' +
													'<td><i class="enclosedbalcony"></i></td>' +
													'<td>{enclosedbaclony}</td>' +
												'</tr>' +
												'<tr>' +
													'<td></td>' + 
													'<td><i class="internalarea"></i></td>' +
													'<td>{internalsize}</td>' + 
													'<td><i class="externalarea"></i></td>' +
													'<td>{externalsize}</td>' +
												'</tr>' +
												'<tr class="even">' +
													'<td></td>' +
													'<td><i class="totalarea"></i></td>' +
													'<td>{totalsize}</td>' +
													'<td><i class="money"></i></td>' +
													'<td>{price}</td>' +
												'</tr>' +
												/*
												'<tr class="last">' +
													'<td></td>' + 
													'<td><i class="speech"></i></td>' +
													'<td colspan="3" class="comment">' +
														'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.' +
													'</td>' +
												'</tr>' +
												*/
											'</table>';
								var cls = 'hidden';
								if(i == 0){
									cls = 'shown';
								}
								div = div.replace('{id}', apartment.id).replace('{cls}', cls)
									.replace('{unit}', apartment.unitNumber)
									.replace('{split}', Tools.getTrueOrFalseIcon(floorplan.isSplit))
									.replace('{level}', apartment.floorLevel)
									.replace('{lot}', apartment.lotNumber)
									.replace('{stage}', apartment.stageName)
									.replace('{building}', apartment.buildingNumber)
									.replace('{color}', apartment.colorScheme)
									.replace('{aspect}', Tools.getAspect(floorplan.orientation))
									.replace('{bedrooms}', floorplan.bedRoomCount)
									.replace('{bathrooms}', floorplan.bathroomCount)
									.replace('{study}', floorplan.studyroomCount)
									.replace('{openbaclony}', floorplan.openBaclonyCount)
									.replace('{enclosedbaclony}', floorplan.enclosedBaclonyCount)
									.replace('{internalsize}', floorplan.internalSize + ' m<sup>2</sup>')
									.replace('{externalsize}', floorplan.externalSize + ' m<sup>2</sup>')
									.replace('{totalsize}', floorplan.totalSize + ' m<sup>2</sup>')
									.replace('{price}', Tools.numberWithCommas(apartment.price));
								$('#apartments').append($(div));
							}
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
		penthouse:null
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
			conditions.study = $('#floorplan-filter input[name="study"]').is(":checked") ? true : null;
			conditions.splitLevel = $('#floorplan-filter input[name="splitlevel"]').is(":checked") ? true : null;
			conditions.storageRoom = $('#floorplan-filter input[name="storage"]').is(":checked") ? true : null;
			conditions.courtyard = $('#floorplan-filter input[name="courtyard"]').is(":checked") ? true : null;
			conditions.enclosedBalcony = $('#floorplan-filter input[name="splitlevel"]').is(":checked") ? true : null;
			conditions.penthouse = $('#floorplan-filter input[name="penthouse"]').is(":checked") ? true : null;
			
			var data = {
				id: Main.currentProjectId
			};
			
			if(conditions.splitLevel){
				data['qc.split'] = true; 
			}
			
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
	updateList: function(){
		$('#floorplan-list .items').empty().css('top', 0);
		$('#floorplan-list2 .items').empty().css('left', 0);
		var floorplans = this.currentFloorPlans;
		for(var i = 0; i < floorplans.length; i++){
			var $item = $('<a href="javascript:;" class="item" data-id="' + floorplans[i].id + '"><img src="' + floorplans[i].salePicture.smallUrl + '" alt="" /></a>');				
			var $items = $item.clone();
			
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
			$div2.append($items);
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
		if(FloorPlan.get(Main.currentFloorplanId) != null){
			alert("You already added this floorplan, please select another one.");
			return;	
		}
		
		if(FloorPlan.length() >= 4){
			alert("Your compare list is full, please remove one first.");
			return;
		}
		
		var image = $('#lightbox .floorplan .image img').attr('src');
		FloorPlan.add({'id': Main.currentFloorplanId, 'image': image});
		
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
				totalArea: ''
			});
		}
		return arr;
	},
	init: function(){
		Main.initFilter();
		//Main.initLogin();
		Search.init();
		
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
          url: Main.root + 'index.php/Compare/data',
          dataType: "json",
          type: "GET",
          success: function(data){
              if(data.contents != null && data.contents != undefined){
              	var projects = data.contents;
              	for(var i = 0; i < projects.length; i++){
              		var project = projects[i];
              		Compare.viewModel.projects.replace(Compare.viewModel.projects()[i], {
              			name: 'TODO',
              			image: '<img src="' + project.medium_sale_floorplan + '" width="190" height="143" alt=""/>',
              			suburb: 'TODO',
						distance: 'TODO',
						price: '',
						pricesqm: '',
						bedroom: project.bedroom_count,
						bathroom: project.bathroom_count,
						carspace: '0',
						level: '10',
						internalArea: project.internal_size,
						externalArea: project.external_size,
						totalArea: project.total_size
              		});
              	}
              }
          }
        });
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
			return '<i class="tick"></i>';
		}else{
			return '<i class="cross"></i>';
		}
	},
	getAspect: function(oritation){
		switch(oritation){
			case 1:
				return "E";
			case 2:
				return "S";
			case 3:
				return "SE";
			case 4:
				return "W";
			case 5:
				return 'EW';
			case 6:
				return "WE";
			case 7:
				return 'ESW';
			case 8:
				return "N";
			case 9:
				return "NE";
			case 10:
				return 'SN';
			case 11:
				return 'ESN';
			case 12:
				return "NW";
			case 13:
				return 'EWN';
			case 14:
				return 'SWN';
			case 15:
				return 'ESWN';
		}
	},
	numberWithCommas: function (x) {
    	return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	}
}


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
	this._div.innerHTML = this._count;
	
	this._statusDiv = document.createElement("DIV");
	this._statusDiv.className = "clusterStatus";
	this._statusDiv.innerHTML = "<span>"+ this._name +"</span>";
	
	var thisCluster = this;
	$(this._div).click(function(){
		thisCluster.zoom();
	});
	
	if(this._shape != null){
		this._overlay = new ClusterPolygon(this, this._shape, this._map);
	}else{
		$(this._div).mouseover(function(){
			thisCluster.showStatus();
		});
		
		$(this._div).mouseout(function(){
			thisCluster.hideStatus();
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
	if(this._count > 25){
		image = path + "cluster-x3.png";
		width = height = 68;
	}else if(this._count > 15){
		image = path + "cluster-x2.png";
		width = height = 56;
	}else{
		image = path + "cluster-x1.png";
		width = height = 28;
	}

	this._div.style.backgroundImage = "url('" + image + "')";
	this._div.style.width = width + "px";
	this._div.style.height = height + "px";
	this._div.style.lineHeight = height + "px";
	
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
		this._clusterOverlay.showStatus();
	});
	
	google.maps.event.addListener(this, 'mouseout', function(){
		this.setOptions(this._options);
		this._clusterOverlay.hideStatus();
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
	this._logo = project.logo.smallUrl;
	this._markerCenter = new google.maps.LatLng(project.latitude, project.longitude);
	this._imageCenter = null;
	this._projectId = project.id;
	
	this.setMap(this._map);
}
ProjectOverlay.prototype = new google.maps.OverlayView();
ProjectOverlay.prototype.onAdd = function(){
	this._div = document.createElement("DIV");
	this._div.className = "project";
	this._div.innerHTML = "<img src='" + this._logo + "' width='100' height='42'/>";
	
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
		div.style.left = (left - (100 / 2) - 3) + "px";
		div.style.top = (top - (42 / 2) - 13) + "px";
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