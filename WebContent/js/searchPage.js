$(document).ready(function() {
	$("#id").change(function() {
		var p_url =  contextPath+'/main/showCemeteryZones';
		var p_data = {areaId:$(this).val()};
		doAjaxSubmit(p_url, p_data, p_callback);
	});

});

//选择一个墓大区后，墓小区联动
p_callback = function(obj){
	$("#zoneId").empty();
	$("#zoneId").append('<option value="-99">"请选择"</option>' );
    $.each(obj.data,function(i,value) {  
    	$("#zoneId").append("<option value="+value.zoneId+">"+value.zoneName+"</option>");
    });  
};