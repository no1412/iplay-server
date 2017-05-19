<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <title>内容详情</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="description" content="">
	<meta name="keywords" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- Set render engine for 360 browser -->
	<meta name="renderer" content="webkit">
	
	<!-- No Baidu Siteapp-->
	<meta http-equiv="Cache-Control" content="no-siteapp"/>
	
	<!-- Add to homescreen for Chrome on Android -->
	<meta name="mobile-web-app-capable" content="yes">
	
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/amazeui.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/app.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/my_style.css">
    </head>
    
    <body>
        <%-- <section class="aui-content-padded">
            <div class="aui-card-list">
                <div class="aui-card-list-header">
                    ${contentDescribeVo.title }
                </div>
                <div class="aui-card-list-content-padded">
                    ${contentDescribeVo.contentDetail }
                </div>
                <div class="aui-card-list-footer">
                    
                </div>
            </div>
        </section> --%>
		<article class="am-article">
			<div class="am-article-hd">
			    <h1 class="am-article-title content-title">${contentDescribeVo.title }</h1>
			    <span>
			         <img class="user-head-img am-circle" src="${contentDescribeVo.headPicUrl }"/>
			         <i class="user-nick-name">${contentDescribeVo.nickName }</i>
			    </span>
			</div>
			<hr class="am-article-divider">
			<article data-am-widget="paragraph" class="am-paragraph am-paragraph-default" data-am-paragraph="{ tableScrollable: true, pureview: true }">
                ${contentDescribeVo.contentDetail }
            </article>
		</article>
    </body>
</html>
