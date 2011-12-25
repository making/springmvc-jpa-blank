<c:import url="/WEB-INF/views/common/layout.jsp" charEncoding="UTF-8">
    <c:param name="title" value="PERSON FORM" />
    <c:param name="body">
        <spring:hasBindErrors name="person">
            <script type="text/javascript">
                $(document).ready(function() {
                    $("div.clearfix>div.input>.error").parent().parent().addClass("error");
                });
            </script>
        </spring:hasBindErrors>
        <form:form method="post" action="." modelAttribute="person">
            <div class="clearfix">
                <label for="name">name</label>
                <div class="input">
                    <form:input path="name" cssClass="span5"
                        cssErrorClass="error" />
                    <form:errors path="name"
                        cssClass="error help-inline inline"
                        element="span" />
                </div>
            </div>
            <div class="clearfix">
                <label for="age">age</label>
               <div class="input">
                    <form:input path="age" cssClass="span3"
                        cssErrorClass="error" />
                    <form:errors path="age"
                        cssClass="error help-inline inline"
                        element="span" />
                </div>
            </div>
            <form:hidden path="id" />
            <div class="actions">
                <input type="submit" class="btn primary" value="Submit">&nbsp;
                <button type="reset" class="btn">Cancel</button>
            </div>
        </form:form>
        <hr>
        <a href='<c:url value="/person/list" />' class="btn">list</a>
    </c:param>
</c:import>

