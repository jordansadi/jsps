<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="us.matt.model.Item" %>
<%@ page import="java.net.URLEncoder" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Milli's Store</title>
    <link rel="stylesheet" href="./css/theStyle.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Milli's Store, Milwaukee's Only Milli-Owned Store.">
</head>
<body onload="saveTable()">
<div id="wrapper">
    <header>
        <h1>Milli's Store</h1>
    </header>
    <nav>
        <ul>
            <a href="index.jsp">Home</a>
            <a href="cat.go">Catalog</a>
            <a href="cart.go">Shopping Cart</a>
        </ul>
    </nav>
    <main>
        <h3>Milli's Cart</h3>
        <table>
            <%
                List recs = (List) request.getAttribute("catalog");
                Iterator it = recs.iterator();
                double total = 0;
                while (it.hasNext()) {
                    Item item = (Item) it.next();

                    out.print("<form action='delete.go'><tr class='purch'><td> " + item.getName() + " </td><td>" +
                            String.format("$%3.2f", item.getPrice()) + "</td><td><button type='submit' name='deleteItem' value='" +
                            item.getProductNumber() +"'>Delete</button></td></tr></form");
                    total += item.getPrice();

                }
                out.print("<tr class='total' ><td>Subtotal:</td><td>" +
                        String.format("$%3.2f", total) + "</td><td></td></tr>");
                out.print("<tr class='total' ><td>Tax:</td><td>" +
                        String.format("$%3.2f", (total * .085)) + "</td><td></td></tr>");
                out.print("<tr class='total' ><td>Grand Total:</td><td>" +
                        String.format("$%3.2f", (total + (total * .085))) + "</td><td></td></tr>");
            %>
        </table>
        <button type="button"><a href="bill.go">Complete Order</a></button>
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