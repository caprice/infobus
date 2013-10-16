function showNavMore(e) {
	var frm = window.frames['nav_frm'];
	var ss = '<!doctype html>';
	ss += '<html dir="ltr" lang="zh-CN">';
	ss += '<head>';
	ss += '<title>csdn</title>';
	ss += '<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />';
	ss += '<link type="text/css" rel="Stylesheet" href="http://csdnimg.cn/pubnav/css/navtop_2012.css" />';
	ss += '<base target="_blank" />';
	ss += '</head>';
	ss += '<body class="navbody">';
	ss += '<div class="nav_top_2011">';
	ss += '<ul style="width:76px;" onclick="top.hide_nav_more()">';
	var arr1 = [ 'CTO俱乐部', '高校俱乐部', '培训充电', '程序员', 'ITeye', 'TUP' ];
	var arr2 = [ 'club.csdn.net/cto', 'student.csdn.net', 'edu.csdn.net',
			'mobile.csdn.net', 'sd.csdn.net', 'cloud.csdn.net',
			'www.programmer.com.cn', 'www.iteye.com', 'tup.csdn.net' ];
	for ( var i = 0; i < arr1.length; i++)
		ss += '<li><a href="http://' + arr2[i] + '/">' + arr1[i] + '</a></li>';
	ss += '</ul>';
	ss += '</div>';
	ss += '</body>';
	ss += '</html>';
	if (!frm.document.title) {
		frm.document.write(ss);
	}
	var hidList = document.getElementById("topnav_hidlist");
	var isshow = hidList.style.display == "block";
	hidList.style.display = isshow ? "none" : "block";
	e.className = isshow ? "" : "open";
	e.firstChild.blur();
	if (document.body.onclick == null) {
		document.body.onclick = function(event) {
			event = event || window.event;
			var target = event.target || event.srcElement;
			if (target.parentNode && target.parentNode.id == 'topnav_btnmore') {
				return;
			}
			if (target.id != 'topnav_btnmore') {
				hide_nav_more();
			}
		};
	}
}
function hide_nav_more() {
	document.getElementById("topnav_hidlist").style.display = "none";
	document.getElementById("topnav_btnmore").className = "";
}
