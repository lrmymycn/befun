<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
    	<title>比房网 | 对比户型</title>
        <jsp:include page="includes/head.jsp" />
    </head>
	<body>
		<div class="standard">
	        <header>
	        	<div class="inner">
	        		<jsp:include page="includes/search.jsp" />
	        	</div>
	        </header>
	        <div id="content" class="compare">	         	        	
				<h2>对比户型</h2>
				<div class="compare-table">
         		<div class="label-column">
         			<div class="name">Project name</div>
         			<div class="layout">Layout</div>
         			<div data-row="0">Suburb</div>
         			<div data-row="1">Distance to city</div>
         			<div data-row="2">Price</div>
         			<div data-row="3">Price/sqm</div>
         			<div data-row="4">Bedroom</div>
         			<div data-row="5">Bathroom</div>
         			<div data-row="6">Car space</div>
         			<div data-row="7">Level</div>
         			<div data-row="8">Internal area</div>
         			<div data-row="9">External area</div>
         			<div data-row="10">Total area</div>
         			<div data-row="11">Study room</div>
         			<div data-row="12">Open balcony</div>
         			<div data-row="13">Enclosed balcony</div>
         			<div data-row="14">Countryard</div>
         			<div data-row="15">Existing</div>
         			<div class="amenity">Amenity</div>
         		</div>
         		<div data-bind="foreach: projects">
	         		<div class="project-column first-column">
	         			<div class="name" data-bind="text: name"></div>
	         			<div class="layout" data-bind="html: image"></div>
	         			<div data-row="0" data-bind="text: suburb"></div>
	         			<div data-row="1" data-bind="text: distance"></div>
	         			<div data-row="2" data-bind="html: price"></div>
	         			<div data-row="3" data-bind="html: pricesqm"></div>
	         			<div data-row="4" data-bind="text: bedroom"></div>
	         			<div data-row="5" data-bind="text: bathroom"></div>
	         			<div data-row="6" data-bind="text: carspace"></div>
	         			<div data-row="7" data-bind="text: level"></div>
	         			<div data-row="8" data-bind="html: internalArea"></div>
	         			<div data-row="9" data-bind="html: externalArea"></div>
	         			<div data-row="10" data-bind="html: totalArea"></div>
	         			<div data-row="11" data-bind="html: studyRoom"></div>
	         			<div data-row="12" data-bind="html: openBalcony"></div>
	         			<div data-row="13" data-bind="html: enclosedBalcony"></div>
	         			<div data-row="14" data-bind="html: countryard"></div>
	         			<div data-row="15" data-bind="html: existing"></div>
	         			<div class="amenity clearfix">
	         				<ul data-bind="style: {display: name == '' ? 'none' : 'block'}">
	         					<li><i data-bind="css: { tick: amenity.reception, question: !amenity.reception}"></i> Reception</li>
	         					<li><i data-bind="css: { tick: amenity.swimmingPool, question: !amenity.swimmingPool}"></i> Swimming Pool</li>
	         					<li><i data-bind="css: { tick: amenity.saunaRoom, question: !amenity.saunaRoom}"></i> Sauna Room</li>
	         					<li><i data-bind="css: { tick: amenity.tennisCourt, question: !amenity.tennisCourt}"></i> Tennis Court</li>
	         					<li><i data-bind="css: { tick: amenity.functionRoom, question: !amenity.functionRoom}"></i> Function Room</li>
	         					<li><i data-bind="css: { tick: amenity.theatreCinema, question: !amenity.theatreCinema}"></i> Theatre Cinema</li>
	         					<li><i data-bind="css: { tick: amenity.library, question: !amenity.library}"></i> Library</li>
	         					<li><i data-bind="css: { tick: amenity.bbq, question: !amenity.bbq}"></i> BBQ Fireplace</li>
	         					<li><i data-bind="css: { tick: amenity.landscaping, question: !amenity.landscaping}"></i> Landscaping</li>
	         					<li><i data-bind="css: { tick: amenity.skyGarden, question: !amenity.skyGarden}"></i> Sky Garden</li>
	         					<li><i data-bind="css: { tick: amenity.visitorParking, question: !amenity.visitorParking}"></i> Visitor parking</li>
	         					<li><i data-bind="css: { tick: amenity.carWashBay, question: !amenity.carWashBay}"></i> Car wash bay</li>
	         					<li><i data-bind="css: { tick: amenity.gym, question: !amenity.gym}"></i> Gym</li>
	         					<li><i data-bind="css: { tick: amenity.kidsPlayGround, question: !amenity.kidsPlayGround}"></i> Kids Play Ground</li>
	         					<li><i data-bind="css: { tick: amenity.playRoom, question: !amenity.playRoom}"></i> Play Room</li>
	         					<li><i data-bind="css: { tick: amenity.recreationPlace, question: !amenity.recreationPlace}"></i> Recreation Place</li>
	         					<li><i data-bind="css: { tick: amenity.musicRoom, question: !amenity.musicRoom}"></i> Music Room</li>
	         				</ul>
	         			</div>
	         		</div>
         		</div>
         	</div>
         	<footer>
				&copy; 2012 Befun Property 
			</footer>
		</div>
		<jsp:include page="includes/script.jsp" />
        <script>
        	$(function(){
				Debug.enable = true;
				Compare.init();
			})
        </script>
	</body>
</html>
