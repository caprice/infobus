function doAjaxSubmit(p_url, p_data, p_callback) {
	$.ajax({
		type : "POST",
		url : p_url,
		data : p_data,
		dataType : "json",
		beforeSend : function(XMLHttpRequest) {
			// ShowLoading();
		},
		success : function(data) {
			p_callback(data);
		},
		complete : function(XMLHttpRequest, textStatus) {
			// HideLoading();
		},
		error : function() {
			// 请求出错处理
		}
	});
}




