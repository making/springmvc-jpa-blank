<c:import url="/WEB-INF/views/common/layout.jsp" charEncoding="UTF-8">
    <c:param name="title" value="PERSON LIST" />
    <c:param name="body">
        <p>
        <a href='<c:url value="/person/form/" />' class="btn">CREATE</a>
        </p>
        <table class="zebra-striped">
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
                    <td><a
                        href='<c:url value="/person/edit/${person.id}" />'
                        class="btn primary">編集</a> <a
                        href='<c:url value="/person/delete/${person.id}" />'
                        class="btn">削除</a></td>
                </tr>
            </c:forEach>
        </table>

        <p>${f:h(page.number + 1)}/${f:h(page.totalPages)}</p>
        <div class="pagination">
            <ul>
                <li><c:if test="${!page.isFirstPage()}">
                        <a href='<c:url value="?page=0" />'>&laquo;
                            first</a>
                    </c:if></li>
                <li><c:if test="${page.hasPreviousPage()}">
                        <a
                            href='<c:url value="?page=${f:h(page.number - 1)}" />'>&lt;
                            prev</a>
                    </c:if></li>
                <li><c:if test="${page.hasNextPage()}">
                        <a
                            href='<c:url value="?page=${f:h(page.number + 1)}" />'>next
                            &gt;</a>
                    </c:if></li>
                <li><c:if test="${!page.isLastPage()}">
                        <a
                            href='<c:url value="?page=${f:h(page.totalPages - 1)}" />'>last
                            &raquo;</a>
                    </c:if></li>
            </ul>
        </div>
    </c:param>
</c:import>

