<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <jsp:include page="includes/head.jsp" />
    </head>
	<body>
		<div class="standard">
	        <header>
	        	<div class="inner">
	        		<jsp:include page="includes/search.jsp" />
	        	</div>
	        </header>
	        <div id="content">	         	        	
				<h2>Client</h2>
				<form id="client-form" action="" method="post">
					<div class="row clearfix">
						<span class="title">Title</span>
						<div class="input">
							<select name="title">
								<option>Ms.</option>
								<option>Mr.</option>
								<option>Mrs.</option>
								<option>Dr.</option>
							</select>
						</div>
					</div>
					<div class="row clearfix">
						<span class="title">Language</span>
						<div class="input">
							<select name="title">
								<option>English</option>
								<option>Mandarin</option>
								<option>Cantonese</option>
								<option>Japanese</option>
								<option>Korean</option>
								<option>Others</option>
							</select>
						</div>
					</div>
					<div class="row clearfix">
						<span class="title">First Name</span>
						<div class="input">
							<input type="text" name="firstname" class="required"/>
						</div>
					</div>
					<div class="row clearfix">
						<span class="title">Last Name</span>
						<div class="input">
							<input type="text" name="lastname"/>
						</div>
					</div>
					<div class="row clearfix">
						<span class="title">Preferred Name</span>
						<div class="input">
							<input type="text" name="preferredname"/>
						</div>
					</div>
					<div class="row clearfix">
						<span class="title">Phone</span>
						<div class="input">
							<input type="text" name="phone"/>
						</div>
					</div>
					<div class="row clearfix">
						<span class="title">Email</span>
						<div class="input">
							<input type="text" name="email"/>
						</div>
					</div>
					<div class="row clearfix">
						<span class="title">Home Address</span>
						<div class="input">
							<input type="text" name="address"/>
						</div>
					</div>
					<div class="row clearfix">
						<span class="title">Postcode</span>
						<div class="input">
							<input type="text" name="postcode"/>
						</div>
					</div>
					<div class="row clearfix">
						<span class="title">Citizenship</span>
						<div class="input">
							<input type="radio" name="citizenship" value="foreigner">Foreigner
							<input type="radio" name="citizenship" value="pr">Australian Citizen/PR
						</div>
					</div>
					<div class="row clearfix">
						<span class="title">Preferred Area</span>
						<div class="input">
							<input type="checkbox" name="area" value="1">Eastern Sydney
							<input type="checkbox" name="area" value="2">Southern Sydney
							<input type="checkbox" name="area" value="3">Inner West
							<input type="checkbox" name="area" value="4">Western Sydney
							<input type="checkbox" name="area" value="5">Northern Sydney
							<input type="checkbox" name="area" value="6">City CBD
						</div>
					</div>
					<div class="row clearfix">
						<span class="title">Purchaser Type</span>
						<div class="input">
							<input type="checkbox" name="type" value="1">First Home Buyer
							<input type="checkbox" name="type" value="2">Owner Occupier
							<input type="checkbox" name="type" value="3">Investor
						</div>
					</div>
					<div class="row clearfix">
						<span class="title">Eligible for Gov Grant?</span>
						<div class="input">
							<input type="checkbox" name="govgrant" value="1">Yes
						</div>
					</div>
					<div class="row clearfix">
						<span class="title">Time Frame</span>
						<div class="input">
							<input type="checkbox" name="timeframe" value="1">Immediate
							<input type="checkbox" name="timeframe" value="1">&lt; 1 month
							<input type="checkbox" name="timeframe" value="1">1 - 3 months
							<input type="checkbox" name="timeframe" value="1">3 - 6 months
							<input type="checkbox" name="timeframe" value="1">&gt; 6 months
						</div>
					</div>
					<div class="row clearfix">
						<span class="title">Price Range</span>
						<div class="input">
							<input type="checkbox" name="pricerange" value="1">Below 600k
							<input type="checkbox" name="pricerange" value="1">600k - 800k
							<input type="checkbox" name="pricerange" value="1">800k - 1m
							<input type="checkbox" name="pricerange" value="1">1m and above
						</div>
					</div>
					<div class="row clearfix">
						<span class="title">Public Transport</span>
						<div class="input">
							<input type="checkbox" name="transport" value="1">Train
							<input type="checkbox" name="transport" value="1">Bus
							<input type="checkbox" name="transport" value="1">Ferry
							<input type="checkbox" name="transport" value="1">Non-essential
						</div>
					</div>
					<div class="row clearfix">
						<span class="title">Bedroom</span>
						<div class="input">
							<input type="checkbox" name="bedroom" value="1">1
							<input type="checkbox" name="bedroom" value="1">2
							<input type="checkbox" name="bedroom" value="1">3
							<input type="checkbox" name="bedroom" value="1">3+
						</div>
					</div>
					<div class="row clearfix">
						<span class="title">Bathroom</span>
						<div class="input">
							<input type="checkbox" name="bathroom" value="1">1
							<input type="checkbox" name="bathroom" value="1">2
							<input type="checkbox" name="bathroom" value="1">2+
						</div>
					</div>
					<div class="row clearfix">
						<span class="title">Car Space</span>
						<div class="input">
							<input type="checkbox" name="carspace" value="1">1
							<input type="checkbox" name="carspace" value="1">2
							<input type="checkbox" name="carspace" value="1">2+
						</div>
					</div>
					<div class="row clearfix">
						<span class="title">View</span>
						<div class="input">
							<input type="checkbox" name="view" value="1">Ocean
							<input type="checkbox" name="view" value="1">Water
							<input type="checkbox" name="view" value="1">Park
							<input type="checkbox" name="view" value="1">City
							<input type="checkbox" name="view" value="1">Non-essential
						</div>
					</div>
					<div class="row clearfix">
						<span class="title">Facility</span>
						<div class="input">
							<input type="checkbox" name="facility" value="1">Swimming Pool
							<input type="checkbox" name="facility" value="1">Gym
							<input type="checkbox" name="facility" value="1">Tennis Court
							<input type="checkbox" name="facility" value="1">Non-essential
						</div>
					</div>
					<div class="button">
						<input type="submit" value="Save" class="btn red"/>
					</div>
				</form>
         	</div>
		</div>
		<footer>
			&copy; 2012 Befun Property 
		</footer>
		<div id="filter-overlay"></div>
		<div id="overlay"></div>
		<jsp:include page="includes/script.jsp" />
        <script>
        	$(function(){
				ClientForm.init();
			})
        </script>
	</body>
</html>
