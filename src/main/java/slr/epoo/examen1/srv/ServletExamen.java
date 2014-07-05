/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package slr.epoo.examen1.srv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import slr.epoo.examen1.mdl.Evaluacion;

/**
 *
 * @author Aaron
 */
@WebServlet(name = "Servo", urlPatterns = {"/resultados"})
public class ServletExamen extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Evaluacion ee = new Evaluacion("Ana", 7);
        try(PrintWriter out = response.getWriter()){
            response.setContentType("application/json");
            ObjectMapper mp = new ObjectMapper();
            JsonGenerator jg = mp.getJsonFactory().createJsonGenerator(out);
            jg.writeObject(java.util.Collections.singletonMap("object", ee));
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet examenes";
    }// </editor-fold>

}
