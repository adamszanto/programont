<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Fishing Journal</title>
</head>
<body>
    <h2>Hello World!</h2>
    <%!
    String makeItLower(String data) {
        return data.toLowerCase();
    }
    %>

    Lower case "Hello World": <%= makeItLower("Hello World")%>
</body>
</html>