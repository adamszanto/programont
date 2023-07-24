<%@ tag body-content="empty" %>
<%@ attribute name="label" required="true" type="java.lang.String" description="Label for the cell" %>
<%@ attribute name="value" required="true" description="Value for the cell" %>

<td>
    <label><jsp:invoke fragment="label" /></label>
    <br />
    <jsp:invoke fragment="value" />
</td>
