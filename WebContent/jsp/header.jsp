<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script language="JavaScript">
	function validate_search() {
		var search_key = $('#txt_search_key').val();
		if (search_key == '') {
			alert('请输入要搜索的关键词');
			return false;
		}
		window.location.href = '/search/' + encodeURI(search_key);
		return false;
	}
</script>
<!-- public topnav -->
<div class="top">
	<div class="wrap">
		<div class="nav_top">
			<p>
				<em>liuweify</em><a target="_blank" id="header_notice_num"
					class="notice_num" href="http://my.csdn.net/my/notifications"></a>我的：<a
					target="_blank" href="http://my.csdn.net/my/letter">收件箱<span
					id="header_letter_num"></span></a><a target="_top" class="red"
					href="http://download.csdn.net/my">资源</a><a target="_top"
					class="red" href="http://write.blog.csdn.net/">博客</a><a
					target="_top" href="http://my.csdn.net">空间</a><a target="_blank"
					href="https://passport.csdn.net/account/profile">设置</a>|<a
					target="_blank" href="https://passport.csdn.net/help/faq">帮助</a>|<a
					target="_top" href="https://passport.csdn.net/account/logout">退出</a>
			</p>
			<ul>
				<li><a target="_blank" href="http://www.csdn.net/">首页</a></li>
				<li><a target="_blank" href="http://news.csdn.net/">业界</a></li>
				<li><a target="_blank" href="http://mobile.csdn.net/">移动</a></li>
				<li><a target="_blank" href="http://cloud.csdn.net/">云计算</a></li>
				<li><a target="_blank" href="http://sd.csdn.net/">研发</a></li>
				<li><a target="_blank" href="http://bbs.csdn.net/">论坛</a></li>
				<li><a target="_blank" href="http://blog.csdn.net/">博客</a></li>
				<li><a target="_blank" href="http://download.csdn.net/">下载</a></li>
				<li class="more"><h2 onclick="showNavMore(this)"
						id="topnav_btnmore">
						<a href="javascript:void(0);">更多</a>
					</h2>
					<div id="topnav_hidlist">
						<iframe width="92" scrolling="no" height="178" frameborder="no"
							src="about:blank" name="nav_frm"></iframe>
					</div></li>
			</ul>
		</div>

	</div>
</div>
<!-- //public topnav -->
<!-- head area -->
<div class="head">
	<div class="wrap">
		<div class="logo">
			<a href="/">CSDN空间</a>
		</div>
		<div class="nav">
			<ul>
				<!-- <li ><a href="/"><span>个人中心</span></a></li>
				<li ><a href="/" id="a_my_homepage"><span>个人主页</span></a></li>
			</ul>-->
			</ul>
		</div>
		<div class="search">
			<form onsubmit="return validate_search();" action="/search"
				method="get" name="searchform" id="searchform">
				<input type="text" class="sear_input" value="" id="txt_search_key"
					name="txt_search_key"><input type="submit" class="sear_btn"
					value="">

			</form>
		</div>
	</div>
</div>
<!-- //head area -->