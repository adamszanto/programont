<%@ tag body-content="scriptless" %>
<%@ attribute name="label" required="true" type="java.lang.String" description="Label for the row" %>
<%@ attribute name="value" required="true" description="Value for the row" %>

<tr>
    <custom:tableRow>
        <h1>This is a table row</h1>
        <jsp:attribute name="label">
            <c:out value="${label}" />
        </jsp:attribute>
        <jsp:attribute name="value">
            <c:out value="${value}" />
        </jsp:attribute>
    </custom:tableRow>
</tr>
