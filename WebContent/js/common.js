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


$.fn.serializeObject = function(){  
    var o = {};  
    var a = this.serializeArray();  
    $.each(a, function(){  
        if (o[this.name]) {  
            if (!o[this.name].push) {  
                o[this.name] = [o[this.name]];  
            }  
            o[this.name].push(this.value || '');  
        }  
        else {  
            o[this.name] = this.value || '';  
        }  
    });  
    return o;  
};  




