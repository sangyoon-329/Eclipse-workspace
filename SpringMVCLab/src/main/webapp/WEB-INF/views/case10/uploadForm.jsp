<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<pre>
	파일 업로드 처리
	1. Front-end (form UI)
		1) request body를 형성하기 위해 method(POST) 설정
		2) request body를 형성하기 위해 content-type 설정 : enctype
		3) multipart content 형태로 전송됨 MIME : multipart/form-data
		4) Part 하나는 별도의 헤더를 가지고 있음.
			Content-Disposition : part name, file name
			Content-Type : file mime type
				(content-type 헤더가 없는 경우, 문자 Part로 인식되고, 파라미터 맵으로 형성됨)
	2. Back-end (multipart request process) : multipart-config 설정 필요
		1) 서블릿 스펙 : 각 서블릿에 multipart/form-data 설정
			Part를 통해 하나의 파트를 캡슐화함.
			getPart(partName), Collection%lt;Part%gt; getParts()
			문자기반 파트 : getParameter...그대로 사용.
			파일기반 파트 : 서버사이드의 특정 위치에 저장(Part.write).
		2) Spring webmvc : DispatcherServlet에 multipart-config 설정
			*** multipartResolver 를 빈으로 등록해야 함.
			원본 request를 wrapper request(MultipartHttpServletRequest)로 변경함.
			원본 Part를 wrapper part(MultipartFile)로 변경함 
			MultipartFile 을 통해 하나의 파트를 캡슐화함.
			핸들러 메소드 인자 MultipartFile, @RequestPart, MultipartFile[], commandObject
			문자기반 파트 : @RequestParam
			파일기반 파트 : 서버사이드의 특정 위치에 저장(MultipartFile.transferTo).
</pre>
<form method="post" enctype="multipart/form-data">
<pre>
	<input type="text" name="uploader" placeholder="업로더"/>
	<span>${errors.uploader }</span>
	<input type="file" name="uploadFile" placeholder="업로드파일"/>
	<span>${errors.uploadFile }</span>
	<button type="submit">업로드</button>
</pre>
</form>
<c:if test="${not empty saveName }">
업로드 된 파일명 : ${saveName}
</c:if>
</body>
</html>