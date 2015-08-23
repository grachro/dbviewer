<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<STYLE type="text/css">
body {
  font-size: 100%;
}

table {
    border-top:1px solid #000000;
    border-left:1px solid #000000;
    border-collapse:collapse;
    border-spacing:0;
    empty-cells:show;
}
th {
    background-color: #87CEEB;
    border-right:1px solid #000000;
    border-bottom:1px solid #000000;
    text-align:center;
    padding:2px;
    font-size: small;
    font-weight:normal;
}
td {
    border-right:1px solid #000000;
    border-bottom:1px solid #000000;
    padding:2px;
    font-size: small;
}
.command-name {
	font-weight: bold;
}

</STYLE>
</head>
<body>



<s:if test="%{commandList.isEmpty()}">
<s:iterator value="scriptList" var="script" status="sts">
<s:form action="select" method="get">
	<h2>${script.scriptCaption}</h2>
	<s:if test="#script.description != null"><pre>${script.description}</pre></s:if>
	<input type="hidden" name="scriptId" value="${script.scriptId}" />
	<ul>
	<s:iterator value="#script.useParams" var="useParam">
	   	<li>${useParam.caption}<input type="text" name="param-${useParam.name}" value="" /><s:if test="#useParam.description != null">　${useParam.description}</s:if></li>
	</s:iterator>
	</ul>
	<s:submit action="query" />
</s:form>
<hr />
</s:iterator>
<s:if test="%{scriptList.isEmpty()}">
	スクリプト定義なし
</s:if>

</s:if>
<s:else>
	<s:iterator value="commandList" var="command" status="comsts">
		<span class="command-name"><s:property value="%{name}" /></span><br />
		<span><pre><s:property value="%{sql}" /></pre></span><br />
		<span style="font-size:65%;"><s:property value="%{dbCaption}" /></span><br />
		
		<s:if test="%{#command.editOnly}">
		</s:if>
		<s:elseif test="%{#command.getResult().isEmpty()}">
			該当データなし<br><br>
		</s:elseif>
		<s:else>
			<table>
				<tr>
					<s:iterator value="#command.getHeaders()" var="headerName">
						<th><s:property value="%{headerName}" /></th>
					</s:iterator>
				</tr>
				<s:iterator value="#command.getResult()" var="record">
					<tr>
						<s:iterator value="#command.getHeaders()" var="headerName">
							<td>
								<s:property value="%{#record.get(#headerName)}" />
							</td>
						</s:iterator>
					</tr>
				</s:iterator>
			</table>
			<br />
		</s:else>
	</s:iterator>
</s:else>
</body>
</html>