/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reinaldo.bll;

import br.com.reinaldo.dal.PilotoDal;
import java.util.List;
import br.com.reinaldo.model.Piloto;
import javax.servlet.http.HttpServlet;
import br.com.reinaldo.dal.PilotoDal;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author naldo
 */
public class PilotoController extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/piloto.jsp";
    private static String LIST_PILOTO = "/listPiloto.jsp";
    private PilotoDal dao;
    
    public PilotoController(){
        super();
        dao = new PilotoDal();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int pilotoId = Integer.parseInt(request.getParameter("pilotoid"));
            dao.deletePiloto(pilotoId);
            forward = LIST_PILOTO;
            request.setAttribute("pilotos", dao.getAllPilotos());
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int pilotoId = Integer.parseInt(request.getParameter("pilotoid"));
            Piloto piloto = dao.getPilotosById(pilotoId);
            request.setAttribute("piloto", piloto);
        } else if (action.equalsIgnoreCase("listPiloto")){
            forward = LIST_PILOTO;
            request.setAttribute("pilotos", dao.getAllPilotos());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Piloto piloto = new Piloto();
        piloto.setMatricula(Integer.parseInt(request.getParameter("matricula")));
        piloto.setNome(request.getParameter("nome"));
        piloto.setPais(request.getParameter("pais"));
        try {
            Date dataNasc = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("datanasc"));
            piloto.setDataNasc(dataNasc);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        piloto.setEquipe(request.getParameter("equipe"));
        piloto.setFabricMotor(request.getParameter("fabricmotor"));
        piloto.setPontosTemp(Integer.parseInt(request.getParameter("pontostemp")));
        String pilotoId = request.getParameter("pilotoid");
        
        if(pilotoId == null || pilotoId.isEmpty())
        {
            dao.addPiloto(piloto);
        }
        else
        {
            piloto.setPilotoId(Integer.parseInt(pilotoId));
            dao.updatePiloto(piloto);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_PILOTO);
        request.setAttribute("pilotos", dao.getAllPilotos());
        view.forward(request, response);
    }
}
