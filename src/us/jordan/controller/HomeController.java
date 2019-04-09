package us.jordan.controller;

import us.jordan.model.CreateDB;
import us.jordan.model.Item;
import us.jordan.model.ItemCatalog;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class HomeController extends HttpServlet {
   private String RESULT_PAGE = "home.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");

        CreateDB db = new CreateDB();
        ItemCatalog cat = new ItemCatalog();
        List<Item> result = cat.getAllItems();

        request.setAttribute("catalog", result);
        
        RequestDispatcher view = request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Main Controller";
    }
}
