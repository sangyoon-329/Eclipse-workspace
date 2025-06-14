<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script src="<c:url value='/resources/js/app/buyer/buyerForm.js'/>"></script>
</head>
<body>
	<div class="card">
		<div class="card-header">
			<h5>Form controls</h5>
		</div>
		<div class="card-body">
			<div class="row">
				<form:form modelAttribute="buyer">
					<div class="form-group">
						<label class="form-label" for="buyerName">거래처이름(*)</label>
						<form:input path="buyerName" cssClass="form-control" placeholder="거래처 이름"/>
						<form:errors path="buyerName" cssClass="text-danger"/>
					</div>
					<div class="form-group">
						<label class="form-label" for="lprodGu">분류코드(*)</label>
						<select name="lprodGu" id="lprodGu" class="form-select">
							<option value="">분류 선택</option>
						</select>
					</div>
					<div class="form-group">
						<label class="form-label" for="buyerBank">주거래은행</label>
						<form:input path="buyerBank" cssClass="form-control" placeholder="주거래은행"/>
						<form:errors path="buyerBank" cssClass="text-danger"/>
					</div>
					<div class="form-group">
						<label class="form-label" for="buyerBankno">계좌번호</label>
						<form:input path="buyerBankno" cssClass="form-control" placeholder="계좌번호"/>
						<form:errors path="buyerBankno" cssClass="text-danger"/>
					</div>
					<div class="form-group">
						<label class="form-label" for="buyerBankname">예금주</label>
						<form:input path="buyerBankname" cssClass="form-control" placeholder="예금주"/>
						<form:errors path="buyerBankname" cssClass="text-danger"/>
					</div>
					<div class="form-group">
						<label class="form-label" for="buyerZip">우편번호</label>
						<form:input path="buyerZip" cssClass="form-control" placeholder="우편번호"/>
					</div>
					<div class="form-group">
						<label class="form-label" for="buyerAdd1">기본주소</label>
						<form:input path="buyerAdd1" cssClass="form-control" placeholder="기본주소"/>
					</div>
					<div class="form-group">
						<label class="form-label" for="buyerAdd2">상세주소</label>
						<form:input path="buyerAdd2" cssClass="form-control" placeholder="상세주소"/>
					</div>
					<div class="form-group">
						<label class="form-label" for="buyerComtel">회사전화번호</label>
						<form:input path="buyerComtel" cssClass="form-control" placeholder="회사전화번호"/>
						<form:errors path="buyerComtel" cssClass="text-danger"/>
					</div>
					<div class="form-group">
						<label class="form-label" for="buyerFax">팩스번호</label>
						<form:input path="buyerFax" cssClass="form-control" placeholder="팩스번호"/>
					</div>
					<div class="form-group">
						<label class="form-label" for="buyerMail">메일주소</label>
						<form:input path="buyerMail" cssClass="form-control" placeholder="메일주소" type="mail"/>
						<form:errors path="buyerMail" cssClass="text-danger"/>
					</div>
					<div class="form-group">
						<label class="form-label" for="buyerCharger">담당자</label>
						<form:input path="buyerCharger" cssClass="form-control" placeholder="담당자"/>
						<form:errors path="buyerCharger" cssClass="text-danger"/>
					</div>
					<div class="form-group">
						<label class="form-label" for="buyerTelext">내선번호</label>
						<form:input path="buyerTelext" cssClass="form-control" placeholder="내선번호"/>
					</div>
					<div>
						<button type="submit" class="btn btn-primary mb-4">Submit</button>
						<button type="reset" class="btn btn-danger mb-4">Reset</button>
					</div>
			
			<div class="form-group">
						<label class="form-label" for="exampleFormControlSelect1">Example
							select</label> <select class="form-select" id="exampleFormControlSelect1">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
						</select>
					</div>
					<div class="form-group">
						<label class="form-label" for="exampleFormControlTextarea1">Example
							textarea</label>
						<textarea class="form-control" id="exampleFormControlTextarea1"
							rows="3"></textarea>
					</div>
				</form:form>
				</div>
			</div>
		</div>
</body>
</html>