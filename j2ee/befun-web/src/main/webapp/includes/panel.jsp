 <div id="panel">
	<span class="close"></span>
	<div class="top">
		<div class="title">
			<span id="project-name"></span>
		</div>      			
		<div class="tabs">     			
			<a href="#tab-overview" class="active first">Overview</a>
			<a href="#tab-details">Details</a>
			<a href="#tab-floorplans">Floorplans</a>
			<a href="#tab-sales">Sales Portal</a>
		</div>
	</div>     		
	<div class="content">
		<div id="tab-overview" class="shown">
			<div id="overview-main">
				
			</div>
			<div id="overview-list">
				<a href="javascript:;" class="prev"></a>
				<div class="scrollable">
				  <div class="items">

				  </div>
				</div>
				<a href="javascript:;" class="next"></a>
			</div>
		</div>	
		<div id="tab-details" class="hidden tab-block">
			<div class="tabs">
    			<a href="#subtab-description" class="active">Description</a>
    			<a href="#subtab-features">Features</a>
    			<a href="#subtab-finish">Finish Scheme</a>
    			<a href="#subtab-amenity">Amenities</a>
			</div>
			<div id="subtab-description" class="shown detailbox">
				<span class="arrow"></span>
				<div class="detail">
					
				</div>
			</div>
			<div id="subtab-features" class="hidden detailbox">
				<span class="arrow"></span>
				<div class="detail">
					
				</div>
			</div>
			<div id="subtab-finish" class="hidden detailbox">
				<span class="arrow"></span>
				<div class="detail">
					
				</div>
			</div>
			<div id="subtab-amenity" class="hidden detailbox">
				<span class="arrow"></span>
				<div class="detail">
					
				</div>
			</div>
		</div>
		<div id="tab-floorplans" class="hidden">
			<div id="floorplan-filter">
				<div class="title">Search current project</div>
				<table>
					<tr class="odd">
						<td class="label">Price range:</td>
						<td>
							<div class="pricerange">
		        				<select name="minprice" class="selectbox">
				        			<option value="0" selected="true">Any Price</option>
				        			<option value="1">$450,000</option>
				        			<option value="2">$550,000</option>
				        			<option value="3">$650,000</option>
				        			<option value="4">$750,000</option>
				        			<option value="5">$850,000</option>
				        		</select>
			        		</div>
			        		<div class="pricerangeto">
			        			to
			        		</div>
			        		<div class="pricerange">
				        		<select name="maxprice" class="selectbox">
				        			<option value="0" selected="true">Any Price</option>
				        			<option value="1">$450,000</option>
				        			<option value="2">$550,000</option>
				        			<option value="3">$650,000</option>
				        			<option value="4">$750,000</option>
				        			<option value="5">$850,000</option>
				        			<option value="6">$850,000+</option>
				        		</select>
			        		</div>
        				</td>
					</tr>
					<tr>
						<td class="label">Bedrooms:</td>
						<td>
							<span class="checkbox">
		        				<input type="checkbox" value="1" name="floorplan-bedrooms" id="floorplan-bedroom-1"/> 
		        			</span>
		        			<label for="floorplan-bedroom-1">1</label>
		        			<span class="checkbox">
			        			<input type="checkbox" value="2" name="floorplan-bedrooms" id="floorplan-bedroom-2">
			        		</span>
			        		<label for="floorplan-bedroom-2">2</label>
			        		<span class="checkbox">
			        			<input type="checkbox" value="3" name="floorplan-bedrooms" id="floorplan-bedroom-3"/>
							</span>	
							<label for="floorplan-bedroom-3">3</label>
							<span class="checkbox">        		
			        			<input type="checkbox" value="3+" name="floorplan-bedrooms" id="floorplan-bedroom-3plus"/>
			        		</span>
			        		<label form="floorplan-bedroom-3plus">3+</label>
        				</td>
					</tr>
					<tr class="odd">
						<td class="label">Bathrooms:</td>
						<td>
							<span class="checkbox">
		        				<input type="checkbox" value="1" name="floorplan-bathrooms" id="floorplan-bathroom-1"/> 
		        			</span>
		        			<label for="floorplan-bathroom-1">1</label>
		        			<span class="checkbox">
			        			<input type="checkbox" value="2" name="floorplan-bathrooms" id="floorplan-bathroom-2">
			        		</span>
			        		<label for="floorplan-bathroom-2">2</label>
			        		<span class="checkbox">
			        			<input type="checkbox" value="3" name="floorplan-bathrooms" id="floorplan-bathroom-2plus"/>
							</span>	
							<label for="floorplan-bathroom-2plus">2+</label>
						</td>
					</tr>
					<tr>
						<td class="label">Carspace:</td>
						<td>
							<span class="checkbox">
		        				<input type="checkbox" value="1" name="floorplan-carspace" id="floorplan-carspace-1"/> 
		        			</span>
		        			<label for="floorplan-carspace-1">1</label>
		        			<span class="checkbox">
			        			<input type="checkbox" value="2" name="floorplan-carspace" id="floorplan-carspace-2">
			        		</span>
			        		<label for="floorplan-carspace-2">2</label>
			        		<span class="checkbox">
			        			<input type="checkbox" value="3" name="floorplan-carspace" id="floorplan-carspace-2plus"/>
							</span>	
							<label for="floorplan-carspace-2plus">2+</label>
						</td>
					</tr>
				</table>
				<div class="feature">
					<ul class="list clearfix">
    					<li>
    						<span class="checkbox">
								<input type="checkbox" value="Y" name="splitlevel"/>
							</span>
							<label>Split level</label>
    					</li>
    					<li style="width:115px;">
							<span class="checkbox">
								<input type="checkbox" value="Y" name="storage"/>
							</span>
							<label>Storage room</label>
    					</li>
    					<li>
    						<span class="checkbox">
								<input type="checkbox" value="Y" name="courtyard"/>
							</span>
							<label>Courtyard</label>
    					</li>
    					<li>
							<span class="checkbox">
    							<input type="checkbox" value="Y" name="study"/>
    						</span>
    						<label>Study</label>
    					</li>   					
    					<li style="width:115px;">
							<span class="checkbox">
								<input type="checkbox" value="Y" name="penthouse"/>
							</span>
							<label>Penthouse</label>
    					</li>
    					<li style="width:140px;">
							<span class="checkbox">
								<input type="checkbox" value="Y" name="wintergarden"/>
							</span>
							<label>Enclosed Balcony</label>
    					</li>
					</ul>
					<div class="clearfix">
						<span class="label">Aspect:</span>
						<div class="aspect">
							<select name="aspect" class="selectbox">
			        			<option value="">Select</option>
			        			<option value="N">North</option>
			        			<option value="E">East</option>
			        			<option value="W">West</option>
			        			<option value="S">South</option>
			        		</select>
						</div>
					</div>
					
				</div>
				<div class="buttons">
					<a href="javascript:;" id="btn-search3"></a>
				</div>
        		
			</div>
			<div id="floorplans">
				<!--<div class="title">Search Results:</div>-->
				<div id="floorplan-list">
					<a href="javascript:;" class="prev nav"></a>
					<div class="scrollable">
						<div class="items">
							
						</div>
					</div>
					<a href="javascript:;" class="next nav"></a>
				</div>
			</div>
		</div>
		<div id="tab-sales" class="hidden tab-block">
			<div class="tabs">
    			<a href="#subtab-data" class="active">Data</a>
    			<a href="#subtab-condition">Condition of Purchase</a>
    			<a href="#subtab-offers">Special Offers</a>
			</div>
			<div id="subtab-data" class="shown detailbox">
				<span class="arrow"></span>
				<div class="detail">
					
				</div>
			</div>
			<div id="subtab-condition" class="hidden detailbox">
				<span class="arrow"></span>
				<div class="detail">
					
				</div>
			</div>
			<div id="subtab-offers" class="hidden detailbox">
				<span class="arrow"></span>
				<div class="detail">
					
				</div>
			</div>
		</div>
	</div>
</div>