<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
    	<title>澳洲比房网 | 期房 楼花 现房</title>
        <jsp:include page="includes/head.jsp" />
    </head>
	<body>
		<div class="standard">
	        <header>
	        	<div class="inner">
	        		<jsp:include page="includes/search.jsp" />
	        	</div>
	        </header>
	        <div id="content" class="client">		         	        	
				<h2>Client</h2>	
				<div id="client-tabs">
					<ul>
						<li><a href="#tab-info">Information</a></li>
						<li><a href="#tab-requirements">Requirements</a></li>
						<li><a href="#tab-interest">Interest List</a></li>
					</ul>
					<div id="tab-info">
						<form id="client-form" action="" method="post">
							<div class="row clearfix">
								<span class="title">Title</span>
								<div class="input">
									<select name="title" data-bind="value: title">
										<option value="MS">MS</option>
										<option value="MR">MR</option>
										<option value="MRS">MRS</option>
										<option value="DR">DR</option>
									</select>
								</div>
							</div>
							<div class="row clearfix">
								<span class="title">Language</span>
								<div class="input">
									<select name="language">
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
								<span class="title">Given Name</span>
								<div class="input">
									<input type="text" name="givenname" class="required" data-bind="value: givenName"/>
								</div>
							</div>
							<div class="row clearfix">
								<span class="title">Surname</span>
								<div class="input">
									<input type="text" name="surname" data-bind="value: surname"/>
								</div>
							</div>
							<div class="row clearfix">
								<span class="title">Preferred Name</span>
								<div class="input">
									<input type="text" name="preferredname" data-bind="value: preferredName"/>
								</div>
							</div>
							<div class="row clearfix">
								<span class="title">Gender</span>
								<div class="input">
									<input type="radio" name="gender" value="MALE" data-bind="checked: gender"/> Male <input type="radio" name="gender" value="FEMALE" data-bind="checked: gender"/> Female
								</div>
							</div>
							<div class="row clearfix">
								<span class="title">Status</span>
								<div class="input long">
									<select name="status" data-bind="value: status">
										<option value="">Select</option>
										<option value="PR">PR</option>
										<option value="CITIZEN">Citizen</option>
										<option value="OVERSEAS_INVESTOR">Oversea's Investor</option>
										<option value="STUDENT">Student</option>
									</select>
								</div>
							</div>
							<div class="row clearfix">
								<span class="title">Mobile</span>
								<div class="input">
									<input type="text" name="mobilenumber" data-bind="value: mobileNumber"/>
								</div>
							</div>
							<div class="row clearfix">
								<span class="title">Email</span>
								<div class="input">
									<input type="text" name="email" data-bind="value: email"/>
								</div>
							</div>
							<div class="row clearfix">
								<span class="title">Home Address</span>
								<div class="input">
									<input type="text" name="address" data-bind="value: homeAddress"/>
								</div>
							</div>
							<div class="row clearfix">
								<span class="title">Postcode</span>
								<div class="input">
									<input type="text" name="postcode" data-bind="value: homePostcode"/>
								</div>
							</div>
							<div class="button">
								<input type="submit" value="Save" class="btn red"/>
							</div>
						</form>
					</div>
					<div id="tab-requirements">
						<table class="list">
							<thead>
								<tr>
									<th width="150">Price Range</th>
									<th width="150">Particulars</th>
									<th width="150">Features</th>
									<th>Notes</th>
									<th width="100">Action</th>
								</tr>
							</thead>
							<tbody data-bind="foreach: requirements">
								<tr>
									<td><span data-bind="text: $root.getPriceRange($data.minPrice, $data.maxPrice)"></span></td>
									<td>Bedroom: <span data-bind="text: bedRoomCountStr"></span><br/>
									Bathroom: <span data-bind="text: bathRoomCountStr"></span><br/>
									CarSpace: <span data-bind="text: carParkingCountStr"></span><br/>
									Distance to City: <span data-bind="text: distanceToCity"></span> km
									</td>
									<td><span data-bind="visible: train">Train Stations<br/></span>
									<span data-bind="visible: shoppingCenter">Shopping Centres<br/></span>
									<span data-bind="visible: chineseCommunity">Chinese Community<br/></span>
									<span data-bind="visible: universities">University Zone<br/></span>
									<span data-bind="visible: schools">School Zone<span></td>
									<td data-bind="text: description"></td>
									<td class="action">
										<a href="javascript:;" data-bind="click: $parent.matchRequirement">Match</a>
										<a href="javascript:;" data-bind="click: $parent.removeRequirement">Delete</a>
									</td>
								</tr>
							</tbody>
						</table>
						<h3>New Requirement</h3>
						<form id="requirement-form" action="" method="post">
							<div class="row clearfix">
								<span class="title">Price Range</span>
								<div class="input">
									<select name="minPrice" data-bind="value: currentRequirement().minPrice">
										<option value="0" selected="true">Any Price</option>
										<option value="1">$450,000</option>
										<option value="2">$550,000</option>
										<option value="3">$650,000</option>
										<option value="4">$750,000</option>
										<option value="5">$850,000</option>
									</select>
									<span class="to">to</span>
									<select name="maxPrice" data-bind="value: currentRequirement().maxPrice">
										<option value="0">Any Price</option>
										<option value="1">$450,000</option>
										<option value="2">$550,000</option>
										<option value="3">$650,000</option>
										<option value="4">$750,000</option>
										<option value="5">$850,000</option>
										<option value="6">$850,000+</option>
									</select>
								</div>
							</div>
							<div class="row clearfix">
								<span class="title">Bedrooms:</span>
								<div class="intput">
									<input type="checkbox" value="1" name="bedrooms" id="bedroom-11" data-bind="checked: currentRequirement().bedrooms"/> 
									<label for="bedroom-11">1</label>
									<input type="checkbox" value="2" name="bedrooms" id="bedroom-12" data-bind="checked: currentRequirement().bedrooms">
									<label for="bedroom-12">2</label>
									<input type="checkbox" value="3" name="bedrooms" id="bedroom-13" data-bind="checked: currentRequirement().bedrooms"/>
									<label for="bedroom-13">3</label>
									<input type="checkbox" value="3+" name="bedrooms" id="bedroom-13plus" data-bind="checked: currentRequirement().bedrooms"/>
									<label form="bedroom-13plus">3+</label>
								</div>
							</div>
							<div class="row clearfix">
								<span class="title">Bathrooms:</span>
								<div class="intput">
									<input type="checkbox" value="1" name="bathrooms" id="bathroom-11" data-bind="checked: currentRequirement().bathrooms"/> 
									<label for="bathroom-11">1</label>
									<input type="checkbox" value="2" name="bathrooms" id="bathroom-12" data-bind="checked: currentRequirement().bathrooms">
									<label for="bathroom-12">2</label>
									<input type="checkbox" value="2+" name="bathrooms" id="bathroom-12plus" data-bind="checked: currentRequirement().bathrooms"/>
									<label for="bathroom-12plus">2+</label>
								</div>
							</div>
							<div class="row clearfix">
								<span class="title">Carspace:</span>
								<div class="intput">
									<input type="checkbox" value="1" name="carspace" id="carspace-11" data-bind="checked: currentRequirement().carspaces"/> 
									<label for="carspace-11">1</label>
									<input type="checkbox" value="2" name="carspace" id="carspace-12" data-bind="checked: currentRequirement().carspaces">
									<label for="carspace-12">2</label>
									<input type="checkbox" value="2+" name="carspace" id="carspace-12plus" data-bind="checked: currentRequirement().carspaces"/>
									<label for="carspace-12plus">2+</label>
								</div>
							</div>
							<div class="row clearfix">
								<span class="title">Distance to City:</span>
								<div class="input">
									<select name="distancetocity" data-bind="value: currentRequirement().distancetocity">
										<option value="">Select</option>
										<option value="0">CBD</option>
										<option value="5">5km</option>
										<option value="10">10km</option>
										<option value="15">15km</option>
										<option value="20">20km</option>
										<option value="20+">20km+</option>
									</select>
								</div>
							</div>  
							<div class="row clearfix">
								<span class="title">Status:</span>
								<div class="input">
									<select name="status" data-bind="value: currentRequirement().status">
										<option value="">Select</option>
										<option value="0">Offplan</option>
										<option value="1">Existing</option>
									</select>
								</div>
							</div>
							<div class="row clearfix">
								<span class="title">Features:</span>
								<ul class="checkbox-list clearfix">
									<li>
										<input type="checkbox" value="1" name="train" id="train1" data-bind="checked: currentRequirement().trainStation"/>
										<label for="train1">Train Stations</label>
									</li>
									<li>
										<input type="checkbox" value="1" name="shpppingcenter" id="shoppingcenter1" data-bind="checked: currentRequirement().shoppingCenter"/>
										<label for="shoppingcenter1">Shopping Centres</label>
									</li>
									<li>			        			
										<input type="checkbox" value="1" name="chinese" id="chinese1" data-bind="checked: currentRequirement().chineseCommunity"/>
										<label for="chinese1">Chinese Community</label>
									</li>
									<li>
										<input type="checkbox" value="1" name="universities" id="university1" data-bind="checked: currentRequirement().university"/>
										<label for="university1">University Zone</label>
									</li>
									<li>
										<input type="checkbox" value="1" name="schools" id="school1" data-bind="checked: currentRequirement().school"/>
										<label for="school1">School Zone</label>
									</li>		        			
								</ul>
							</div>
							<div class="row clearfix">
								<span class="title">Notes:</span>
								<div class="input">
									<textarea data-bind="value: currentRequirement().description"></textarea>
								</div>
							</div>
							<div class="button">
								<input type="submit" value="Add" class="btn red"/>
							</div>
						</form>
					</div>
					<div id="tab-interest">
						<table class="list">
							<thead>
								<tr>
									<th>Project</th>
									<th>Apartment</th>
									<th>Level</th>
									<th>Bed</th>
									<th>Bath</th>
									<th>Car</th>
									<th>Study</th>
									<th>Storage</th>
									<th>Price</th>
									<th>Price/sqm</th>
									<th width="50">Action</th>
								</tr>
							</thead>
							<tbody data-bind="foreach: interestList">
								<!-- ko if: $data.apartment != null -->
								<tr>
									<td data-bind="text: $data.apartment.projectName"></td>
									<td data-bind="text: $data.apartment.unitNumber"></td>
									<td data-bind="text: $data.apartment.floorLevel"></td>
									<td></td>
									<td></td>
									<td data-bind="text: $data.apartment.carParkingCount"></td>
									<td></td>
									<td data-bind="text: $data.apartment.storageRoomCount"></td>
									<td>$ <span data-bind="text: $data.apartment.price"></span></td>
									<td>$ <span data-bind="text: $data.apartment.avgPricePerSQM"></span>m<sup>2</sup></td>
									<td class="action"><a href="javascript:;">Delete</a></td>
								</tr>
								<!-- /ko -->
							</tbody>
						</table>
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
				ClientForm.init();
			})
        </script>
	</body>
</html>
