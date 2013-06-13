<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<div id="panel">
	<span class="close"></span>
	<div class="top">
		<div class="title">
			<span id="project-name"></span>
		</div>      			
		<div class="tabs">     			
			<a href="#tab-overview" class="active first">项目图集</a>
			<a href="#tab-details">项目信息</a>
			<a href="#tab-features">项目特色</a>
			<a href="#tab-floorplans">户型检索</a>
			<a href="#tab-sales">区域分析</a>
			<a href="#tab-sales">精彩周边</a>
			<a href="#tab-sales">联系我们</a>
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
    			<a href="#subtab-description" class="active">基本信息</a>
    			<a href="#subtab-finish">内饰品牌</a>
    			<a href="#subtab-amenity">项目设施</a>
			</div>
			<div id="subtab-description" class="shown detailbox">
				<span class="arrow"></span>
				<div class="detail">
					<table>
						<tr>
							<td width="120"><strong>Address</strong></td>
							<td>661-665 Gardeners Rd Mascot NSW 2020</td>
						</tr>
						<tr>
							<td><strong>Council</strong></td>
							<td>Mascot</td>
						</tr>
						<tr>
							<td><strong>Distance to City</strong></td>
							<td>10km</td>
						</tr>
						<tr>
							<td><strong>Developer</strong></td>
							<td>Meriton</td>
						</tr>
						<tr>
							<td><strong>Builder</strong></td>
							<td>Meriton</td>
						</tr>
						<tr>
							<td><strong>Launch Date</strong></td>
							<td>25/05/2013</td>
						</tr>
						<tr>
							<td><strong>Total Stages</strong></td>
							<td>3</td>
						</tr>
						<tr>
							<td><strong>Total Buildings</strong></td>
							<td>3</td>
						</tr>
					</table>
				</div>
			</div>
			<div id="subtab-finish" class="hidden detailbox">
				<span class="arrow"></span>
				<div class="detail">
					<table>
						<tr>
							<td width="120"><strong>Wall</strong></td>
							<td>Painted Plasterboard</td>
						</tr>
						<tr>
							<td><strong>Floor</strong></td>
							<td>Carpet / Timber floor</td>
						</tr>
						<tr>
							<td><strong>Kitchen</strong></td>
							<td>Splashback (stone/nature stone)<br/>
								Cooktop (brand)<br/>
								Oven (brand)<br/>
								Rangehood (brand, ducted/recirculating)<br/>
								Dishwasher (brand)<br/>
								Microwave (brand)<br/>
								Sink (brand or material)
							</td>
						</tr>
						<tr>
							<td><strong>Bathroom</strong></td>
							<td>Shower (brand or material)<br/>
								Tub (brand)<br/>
								Tile (ceramic tiles)<br/>
								Bathroom ware (brand)
							</td>
						</tr>
						<tr>
							<td><strong>Aircon</strong></td>
							<td>Centralized</td>
						</tr>
						<tr>
							<td><strong>NBN</strong></td>
							<td>What's this?</td>
						</tr>
						<tr>
							<td><strong>Satellite TV</strong></td>
							<td>Foxtel</td>
						</tr>
					</table>
				</div>
			</div>
			<div id="subtab-amenity" class="hidden detailbox">
				<span class="arrow"></span>
				<div class="detail">
					<ul class="amenity">
						<li><i class="tick"></i> Reception</li>
						<li><i class="tick"></i> Swimming Pool</li>
						<li><i class="tick"></i> Sauna Room</li>
						<li><i class="tick"></i> Tennis Court</li>
						<li><i class="tick"></i> Function Room</li>
						<li><i class="tick"></i> Theatre Cinema</li>
						<li><i class="tick"></i> Library</li>
						<li><i class="tick"></i> BBQ Fireplace</li>
						<li><i class="tick"></i> Landscaping</li>
						<li><i class="tick"></i> Sky Garden</li>
						<li><i class="tick"></i> Visitor parking</li>
						<li><i class="tick"></i> Car wash bay</li>
						<li><i class="tick"></i> Gym</li>
						<li><i class="tick"></i> Kids Play Ground</li>
						<li><i class="tick"></i> Play Room</li>
						<li><i class="tick"></i> Recreation Place</li>
						<li><i class="tick"></i> Music Room</li>
					</ul>
				</div>
			</div>
		</div>
		<div id="tab-features" class="hidden tab-block">
			<ul class="brochure">
				<li><a href="/img/render/medium/vantage.jpg" rel="brochure"><img src="/img/render/medium/vantage.jpg" alt=""/></a></li>
				<li><a href="/img/render/medium/vantage-rhodes-cbdviews-641x432.jpg" rel="brochure"><img src="/img/render/medium/vantage-rhodes-cbdviews-641x432.jpg" alt=""/></a></li>
				<li class="last"><a href="/img/render/medium/vantage-rhodes-aerial-641x4321.jpg" rel="brochure"><img src="/img/render/medium/vantage-rhodes-aerial-641x4321.jpg" alt=""/></a></li>
				<li><a href="/img/render/medium/vantage-rhodes-open-plan-641x432.jpg" rel="brochure"><img src="/img/render/medium/vantage-rhodes-open-plan-641x432.jpg" alt=""/></a></li>
				<li><a href="/img/render/medium/vantage-rhodes-balcony-641x432.jpg" rel="brochure"><img src="/img/render/medium/vantage-rhodes-balcony-641x432.jpg" alt=""/></a></li>
				<li class="last"><a href="/img/render/medium/vantage-513_kitchen-web.jpg" rel="brochure"><img src="/img/render/medium/vantage-513_kitchen-web.jpg" alt=""/></a></li>
			</ul>
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