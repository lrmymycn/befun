<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="floorplan-filter">
	<div class="title">检索当前项目户型</div>
	<table>
		<tr class="odd">
			<td class="label">价格:</td>
			<td>
				<div class="pricerange">
					<select name="minprice" class="selectbox">
						<option value="0" selected="true">不限</option>
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
						<option value="0" selected="true">不限</option>
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
			<td class="label">卧室:</td>
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
			<td class="label">浴室:</td>
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
			<td class="label">车位:</td>
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
				<label>复式</label>
			</li>
			<li>
				<span class="checkbox">
					<input type="checkbox" value="Y" name="storage"/>
				</span>
				<label>储藏室</label>
			</li>
			<li>
				<span class="checkbox">
					<input type="checkbox" value="Y" name="courtyard"/>
				</span>
				<label>后院</label>
			</li>
			<li>
				<span class="checkbox">
					<input type="checkbox" value="Y" name="study"/>
				</span>
				<label>书房</label>
			</li>   					
			<li>
				<span class="checkbox">
					<input type="checkbox" value="Y" name="penthouse"/>
				</span>
				<label>阁楼</label>
			</li>
			<li>
				<span class="checkbox">
					<input type="checkbox" value="Y" name="wintergarden"/>
				</span>
				<label>封闭式阳台</label>
			</li>
		</ul>
		<div class="clearfix">
			<span class="label">朝向:</span>
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