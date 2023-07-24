<%@ tag body-content="scriptless" %>
<%@ attribute name="label" required="true" type="java.lang.String" description="Label for the row" %>
<%@ attribute name="value" required="true" description="Value for the row" %>

<tr>
    <custom:tableCell>
        <jsp:attribute name="label">
            <c:out value="${label}" />
        </jsp:attribute>
        <jsp:attribute name="value">
            <c:out value="${value}" />
        </jsp:attribute>
    </custom:tableCell>
</tr>
