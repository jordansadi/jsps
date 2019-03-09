<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="us.matt.model.Item" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Milli's Store</title>
    <link rel="stylesheet" href="./css/theStyle.css">
    <script src="jquery-3.3.1.slim.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Milli's Store, Milwaukee's Only Milli-Owned Store.">
</head>
<script>
    var userInput = "test";
    var fullTable = [];

    function saveTable() {
        $("#products tr").each(function() {
            var arrayOfThisRow = [];
            var tableData = $(this).find('td');
            if (tableData.length > 0) {
                tableData.each(function() { arrayOfThisRow.push($(this).text()); });
                fullTable.push(arrayOfThisRow);
            }
        });
    }

    function getSearchTerm() {
        userInput = $("#userSearch").val();

        var myTableArray = fullTable;

        if (userInput !== "") {
            for (var i = myTableArray.length - 1; i >= 0; i--) {
                if (myTableArray[i][1].indexOf(userInput) === -1)
                    myTableArray.splice(i, 1);
            }
        }

        $("#products tr").remove();

        for (var j = 0; j < myTableArray.length; j++) {
            var v = myTableArray[j];
            var $line = $("<tr></tr>");
            var itemNum = v[0];
            $line.append($("<td></td>").html(v[0]));
            $line.append($("<td></td>").html(v[1]));
            $line.append($("<td></td>").html(v[2]));
            $line.append($("<td></td>").html(v[3]));
            $line.append($("<td></td>").html('Add to Cart<input type="checkbox" name="cartItem" value="' + itemNum + '"/>'));
            $("#products tbody").append($line);
        }
    }
</script>
<body onload="saveTable()">
<div id="wrapper">
    <header>
        <h1>Milli's Store</h1>
    </header>

    <nav>
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="cat.go">Catalog</a></li>
            <li><a href="cart.go">Shopping Cart</a></li>
        </ul>
    </nav>
    <main>
        <h2>Catalog</h2>

        Search items: <input type="text" id="userSearch">
        <input type="button" id="search" value="Search" onclick="getSearchTerm()">
        <input type="button" value="Refresh" onclick="window.location.reload()">

        <form action="cartplace.go">
            <table id="products">
                <tbody>
                    <%
                        List recs = (List) request.getAttribute("catalog");
                        Iterator it = recs.iterator();
                        while (it.hasNext()) {
                            Item item = (Item) it.next();
                            out.print("<tr><td>" + item.getProductNumber() + "</td><td>" + item.getName() +"</td><td>$" + item.getPrice() +
                                    "</td><td>" + item.getDescription() + "</td><td>Add to Cart<input type='checkbox' name='cartItem' value=" +
                                    item.getProductNumber()+ "></td></tr>");
                        }
                    %>
                </tbody>
            </table>
            <input type="submit" value="Purchase">
        </form>
    </main>
    <footer>
        <a id="mobile" href="tel:262-521-5040">262-521-5040</a>
        <span id="desktop">262-521-5040</span>&nbsp; | &nbsp;
        <a href="mailto:jsadi@my.wctc.edu">jsadi@my.wctc.edu</a><br>
        Copyright &copy; 2019 Milli's Store
    </footer>
</div>
</body>
</html>
