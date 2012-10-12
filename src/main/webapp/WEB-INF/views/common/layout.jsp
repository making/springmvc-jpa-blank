<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
    href='${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css'>
<script type="text/javascript"
    src='${pageContext.request.contextPath}/js/jquery-1.7.1.min.js'></script>
<title>${param.title}</title>
<style type="text/css">
html,body {
    background-color: #eee;
}


.container>footer p {
    text-align: center; /* center align it with the container */
}

.container {
    width: 820px;
}

/* The white background content wrapper */
.content {
    background-color: #fff;
    padding: 20px;
    margin: 0 -20px;
    -webkit-border-radius: 0 0 6px 6px;
    -moz-border-radius: 0 0 6px 6px;
    border-radius: 0 0 6px 6px;
    -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .15);
    -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .15);
    box-shadow: 0 1px 2px rgba(0, 0, 0, .15);
}
/* Page header tweaks */
.page-header {
    background-color: #f5f5f5;
    padding: 20px 20px 10px;
    margin: -20px -20px 20px;
}

.row {
    padding: 20px;
}
</style>
</head>

<body>
    <div class="container">
        <div class="content">
            <div class="page-header">
                <h1>
                    <a href='${pageContext.request.contextPath}'>Spring MVC JPA
                        Blank App</a>
                </h1>
            </div>
            <div class="row">${param.body}</div>
        </div>
        <footer>
            <p>&copy; @making 2011</p>
        </footer>
    </div>
</body>
</html>