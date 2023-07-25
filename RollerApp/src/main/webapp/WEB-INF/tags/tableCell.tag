<%@ attribute name="label" required="true" type="java.lang.String" description="Label for the cell" %>
<%@ attribute name="value" required="true" description="Value for the cell" %>

<td>
    <custom:tableCell>
        <h1>This is a table cell</h1>
        <jsp:attribute name="label" />
        <br />
        <jsp:attribute name="value" />
    </custom:tableCell>
</td>
