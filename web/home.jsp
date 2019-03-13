<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="us.jordan.model.Item" %>

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
        var input, filter, table, tr, td, i, txtValue;
        input = document.getElementById("myInput");
        filter = input.value.toUpperCase();
        table = document.getElementById("myTable");
        tr = table.getElementsByTagName("tr");

        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[0];
            if (td) {
                txtValue = td.textContent || td.innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
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
            <br>
            <h2>Home</h2>

            <input type="text" id="myInput" onkeyup="getSearchTerm()" placeholder="Search for item">
            <input class="btn btn-lg" type="button" value="Refresh" id="refresh" onclick="window.location.reload()">

            <form action="cartplace.go">
                <table id="myTable">
                    <tr>
                        <th>Name</th>
                        <th>Item #</th>
                        <th>Price</th>
                        <th>Add</th>
                    </tr>
                    <tbody>
                        <%
                            List recs = (List) request.getAttribute("catalog");
                            Iterator it = recs.iterator();
                            while (it.hasNext()) {
                                Item item = (Item) it.next();

                                out.print("<tr>" +
                                        "<td>" + item.getName() + "</td>" +
                                        "<td>" + item.getProductNumber() + "</td>" +
                                        "<td>$" + item.getPrice() + "</td>" +
                                        "<td>Add to Cart<input type='checkbox' name='cartItem' value=" +
                                        item.getProductNumber()+ "></td></tr>");
                            }
                        %>
                    </tbody>
                </table>
                <button type="submit">Purchase</button>
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