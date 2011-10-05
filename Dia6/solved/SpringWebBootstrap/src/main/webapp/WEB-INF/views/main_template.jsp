<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<html>
    <head>
        <title>Test</title>
        <link href="<s:url value="/public" />/css/spitter.css" 
              rel="stylesheet" 
              type="text/css" />
    </head>

    <body>
        <div id="container">
            <a href="<s:url value="/home" />">HOME</a>
            <div id="content">
                <t:insertAttribute name="content" /> <!--<co id="co_tile_content" />-->
            </div>
        </div>
    </body>
</html>