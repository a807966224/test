<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 
	https://github.com/pgkk/kkpager.git
	js分页展示控件 
-->
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.10.2.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/kkpager.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/pagers.js"/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/kkpager_blue.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/test.css"/>">

<link rel="stylesheet" href="<c:url value="/resources/css/quick_layout-min.css"/>">
<script type="text/javascript" src="<c:url value="/resources/js/jquery-html5Validate.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/utils.js"/>"></script>

<link href="<c:url value="/resources/css/uploader-image.css"/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<c:url value="/resources/js/Q.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/Q.Uploader.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/Q.Uploader.UI.Image.js"/>"></script>