package us.jordan.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class DeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Enumeration paramNames = request.getParameterNames();
        String paramName;
        String deleteId = "";
        Cookie[] cookies = null;
        String ids = "";

        while (paramNames.hasMoreElements()) {
            paramName = (String) paramNames.nextElement();
            if (paramName.equals("deleteItem")) {
                String[] paramValues = request.getParameterValues(paramName);
                if (paramValues.length == 1) {
                    deleteId = paramValues[0];
                }
            }
        }

        cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("cartItem")) {
                String[] nums = cookie.getValue().split(",");
                for (int i = 0; i < nums.length; i++) {
                    if (!deleteId.equals(nums[i])) {
                        ids += nums[i] + ",";
                    }
                }
            }
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("cartItem")) {
                cookie.setMaxAge(0);
            }
        }

        Cookie items = new Cookie("cartItem", ids);
        items.setMaxAge(60 * 60 * 24);
        response.addCookie(items);

        String site = "cart.go";
        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", site);
    }
}