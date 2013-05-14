<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ include file="/includes/admin/taglib.jsp"%>
<%@ include file="/includes/admin/cache.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><decorator:title default="Befun Administration List view" /></title>
<%@ include file="/includes/admin/style.jsp"%>
<%@ include file="/includes/admin/data/list/style.jsp"%>
<%@ include file="/includes/admin/js.jsp"%>
<%@ include file="/includes/admin/data/list/js.jsp"%>
<decorator:head />
<script>

(function( $ ) {
	$.widget( "ui.combobox", {
		_create: function() {
			var input,
				that = this,
				select = this.element.hide(),
				selected = select.children( ":selected" ),
				//value = selected.val() ? selected.text() : "",
				value = selected.text(),
				wrapper = this.wrapper = $( "<span>" )
					.addClass( "ui-combobox" )
					.insertAfter( select );

			function removeIfInvalid(element) {
				var value = $( element ).val(),
					matcher = new RegExp( "^" + $.ui.autocomplete.escapeRegex( value ) + "$", "i" ),
					valid = false;
				select.children( "option" ).each(function() {
					if ( $( this ).text().match( matcher ) ) {
						this.selected = valid = true;
						return false;
					}
				});
				if ( !valid ) {
					// remove invalid value, as it didn't match anything
					$( element )
						.val( "" )
						.attr( "title", value + " didn't match any item" )
						.tooltip( "open" );
					select.val( "" );
					setTimeout(function() {
						input.tooltip( "close" ).attr( "title", "" );
					}, 2500 );
					input.data( "autocomplete" ).term = "";
					return false;
				}
			}

			input = $( "<input>" )
				.appendTo( wrapper )
				.val( value )
				.attr( "title", "" )
				.addClass( "ui-state-default ui-combobox-input" )
				.autocomplete({
					delay: 0,
					minLength: 0,
					source: function( request, response ) {
						var matcher = new RegExp( $.ui.autocomplete.escapeRegex(request.term), "i" );
						response( select.children( "option" ).map(function() {
							var text = $( this ).text();
							//if ( this.value && ( !request.term || matcher.test(text) ) )
							if ( !request.term || matcher.test(text) )
								return {
									label: text.replace(
										new RegExp(
											"(?![^&;]+;)(?!<[^<>]*)(" +
											$.ui.autocomplete.escapeRegex(request.term) +
											")(?![^<>]*>)(?![^&;]+;)", "gi"
										), "<strong>$1</strong>" ),
									value: text,
									option: this
								};
						}) );
					},
					select: function( event, ui ) {
						ui.item.option.selected = true;
						that._trigger( "selected", event, {
							item: ui.item.option
						});
						select.trigger("change");
					},
					change: function( event, ui ) {
						if ( !ui.item )
							return removeIfInvalid( this );
					}
				})
				.addClass( "ui-widget ui-widget-content ui-corner-left" );

			input.data( "autocomplete" )._renderItem = function( ul, item ) {
				return $( "<li>" )
					.data( "item.autocomplete", item )
					.append( "<a>" + item.label + "</a>" )
					.appendTo( ul );
			};

			$( "<a>" )
				.attr( "tabIndex", -1 )
				.attr( "title", "Show All Items" )
				.tooltip()
				.appendTo( wrapper )
				.button({
					icons: {
						primary: "ui-icon-triangle-1-s"
					},
					text: false
				})
				.removeClass( "ui-corner-all" )
				.addClass( "ui-corner-right ui-combobox-toggle" )
				.click(function() {
					// close if already visible
					if ( input.autocomplete( "widget" ).is( ":visible" ) ) {
						input.autocomplete( "close" );
						removeIfInvalid( input );
						return;
					}

					// work around a bug (likely same cause as #5265)
					$( this ).blur();

					// pass empty string as value to search for, displaying all results
					input.autocomplete( "search", "" );
					input.focus();
				});

				input
					.tooltip({
						position: {
							of: this.button
						},
						tooltipClass: "ui-state-highlight"
					});
		},

		destroy: function() {
			this.wrapper.remove();
			this.element.show();
			$.Widget.prototype.destroy.call( this );
		}
	});
})( jQuery );

function getSuburbByArea(area, suburb){
	if(area.val() == "") {
	    suburb.empty();
	    suburb.append("<option value=''>Select Suburb</option>");
		return;
	};
    $.ajax({   
        type: "POST",   
        url: "<c:url value='/admin/data/json/demandAllSuburb.action'/>",   
        data: "qc.areaId=" + area.val() + "&qc.enabled=null",   
        dataType:"json",
        async: false,     //如果设置为false，则表示异步提交，否则表示同步提交
         timeout: 10000,
         error: function(){
             alert('Error loading content!');
             return  null;
         },
        success: function(data){   
            var items = data.views;
            suburb.empty();
            suburb.append("<option value='' selected='selected'>Select Suburb</option>");
            $.each(items, function(i, n){
            	suburb.append("<option value='" + n.id + "'>" + n.name + "</option>");
            });
            suburb.get(0).selectedIndex=0;
            suburb.change();
        }
    });
}

function getProjectBySuburb(suburb, project){
	if(suburb.val() == "") {
        project.empty();
        project.append("<option value=''>Select Project</option>");
		return;
	};
    $.ajax({   
        type: "POST",   
        url: "<c:url value='/admin/data/json/demandAllProject.action'/>",   
        data: "qc.suburbId=" + suburb.val(),   
        dataType:"json",
        async: false,     //如果设置为false，则表示异步提交，否则表示同步提交
         timeout: 10000,
         error: function(){
             alert('Error loading content!');
             return  null;
         },
        success: function(data){   
            var items = data.views;
            project.empty();
            project.append("<option value=''>Select Project</option>");
            $.each(items, function(i, n){
            	project.append("<option value='" + n.id + "'>" + n.name + "</option>");
            });
            project.get(0).selectedIndex=0;
            project.change();
        }
    });
}

function getStageByProject(project, stage){
	if(project.val() == "") {
		stage.empty();
		stage.append("<option value=''>Select Stage</option>");
		return;
	};
    $.ajax({   
        type: "POST",   
        url: "<c:url value='/admin/data/json/demandAllStage.action'/>",   
        data: "qc.projectId=" + project.val(),   
        dataType:"json",
        async: false,     //如果设置为false，则表示异步提交，否则表示同步提交
         timeout: 10000,
         error: function(){
             alert('Error loading content!');
             return  null;
         },
        success: function(data){   
            var items = data.views;
            stage.empty();
            stage.append("<option value=''>Select Stage</option>");
            $.each(items, function(i, n){
            	stage.append("<option value='" + n.id + "'>" + n.name + "</option>");
            });
            stage.get(0).selectedIndex=0;
            stage.change();
        }
    });
}

function getBuildingByStage(stage, building){
	if(stage.val() == "") {
		building.empty();
		building.append("<option value=''>Select Building</option>");
		return;
	};
    $.ajax({   
        type: "POST",   
        url: "<c:url value='/admin/data/json/demandAllBuilding.action'/>",   
        data: "qc.stageId=" + stage.val(),   
        dataType:"json",
        async: false,     //如果设置为false，则表示异步提交，否则表示同步提交
         timeout: 10000,
         error: function(){
             alert('Error loading content!');
             return  null;
         },
        success: function(data){   
            var items = data.views;
            building.empty();
            building.append("<option value=''>Select Building</option>");
            $.each(items, function(i, n){
            	building.append("<option value='" + n.id + "'>" + n.buildingNumber + "</option>");
            });
            building.get(0).selectedIndex=0;
            building.change();
        }
    });
}

function getFloorplanByBuilding(building, floorplan){
	if(building.val() == "") {
		floorplan.empty();
		floorplan.append("<option value=''>Select Floorplan</option>");
		return;
	};
    $.ajax({   
        type: "POST",   
        url: "<c:url value='/admin/data/json/demandAllFloorplan.action'/>",   
        data: "qc.buildingId=" + building.val(),   
        dataType:"json",
        async: false,     //如果设置为false，则表示异步提交，否则表示同步提交
         timeout: 10000,
         error: function(){
             alert('Error loading content!');
             return  null;
         },
        success: function(data){   
            var items = data.views;
            floorplan.empty();
            floorplan.append("<option value=''>Select Floorplan</option>");
            $.each(items, function(i, n){
            	floorplan.append("<option value='" + n.id + "'>" + n.bedRoomCount +"-"+n.bathroomCount +"-"+n.totalSize + "</option>");
            });
            floorplan.get(0).selectedIndex=0;
            floorplan.change();
        }
    });
}
</script>
<style>
.ui-combobox {
	position: relative;
	display: inline-block;
}

.ui-combobox-toggle {
	position: absolute;
	top: 0;
	bottom: 0;
	margin-left: -1px;
	padding: 0;
	/* adjust styles for IE 6/7 */
	*height: 1.7em;
	*top: 0.1em;
}

.ui-combobox-input {
	margin: 0;
	padding: 0.3em;
}
</style>
</head>
<body>
	<%@ include file="/includes/admin/header.jsp"%>
	<%@ include file="/includes/admin/data/list/header.jsp"%>
	<decorator:body />
	<%@ include file="/includes/admin/footer.jsp"%>
</body>
</html>