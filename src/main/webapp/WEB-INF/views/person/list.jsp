<c:import url="/WEB-INF/views/common/layout.jsp" charEncoding="UTF-8">
	<c:param name="title" value="PERSON LIST" />
	<c:param name="body">
		<p>
			<a href='${pageContext.request.contextPath}/person/form/'
				class="btn btn-info">CREATE</a>
		</p>
		<table class="table table-striped table-bordered table-condensed">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>AGE</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${page.content}" var="person">
				<tr>
					<td>${f:h(person.id)}</td>
					<td>${f:h(person.name)}</td>
					<td>${f:h(person.age)}</td>
					<td>
					    <a href='${pageContext.request.contextPath}/person/edit/${person.id}'
						class="btn btn-primary">Edit</a> 
						<a href='${pageContext.request.contextPath}/person/delete/${person.id}'
						class="btn">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>


	</c:param>
</c:import>

