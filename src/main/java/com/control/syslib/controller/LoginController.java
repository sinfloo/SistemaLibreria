package com.control.syslib.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.control.syslib.service.UsuarioService;
import com.google.gson.Gson;

@Controller
public class LoginController {
	
	@Autowired 
	private UsuarioService us;
	
	Map<String, Object> map = new HashMap<>();
	Gson g = new Gson();
	
		@GetMapping("/")
		public String index(Model model) {
		        return "login";
		}	
		
		
		 @RequestMapping(value="/logout")
	       public String logout(HttpServletRequest request){
	           HttpSession httpSession = request.getSession();
	           httpSession.invalidate();
	           return "redirect:/";
	       }
		
		 
		 @RequestMapping("/principio")
			public String principal(Model model, HttpServletRequest request) {
			 HttpSession session = request.getSession(false);

		        boolean loggedIn = session != null && session.getAttribute("usuario") != null ;
		        System.out.println(" , " +  loggedIn );
		        System.out.println();

		        String back="";
		        if (loggedIn) {
		        	System.out.println("hay sesion activa");
		        back="main";
		        } else {
		            System.out.println("no hay sesion activa");
		            back="login";
		        }


				return back;
			}
			

			@RequestMapping(value = "/login", method = RequestMethod.POST)
			public void login(HttpServletRequest request, HttpServletResponse response, Model model) throws ServletException, IOException {
				PrintWriter out = response.getWriter();
				String user = request.getParameter("user");
				String clave = request.getParameter("pass");
				HttpSession session = request.getSession(true);
				int x = 0;
				int op = Integer.parseInt(request.getParameter("op"));
				try {

					if (op == 1) {
						if (us.Validar_Mapeo_dat(user, clave) != null) {
							map = us.Validar_Mapeo_dat(user, clave);
							session.setAttribute("idusuario", map.get("idusuario"));
							session.setAttribute("usuario", map.get("usuario"));
							session.setAttribute("password_u", map.get("password_u"));
							session.setAttribute("estado", map.get("estado"));
							session.setAttribute("nombres", map.get("nombres"));
							session.setAttribute("apellidos", map.get("apellidos"));
							session.setAttribute("dni", map.get("dni"));

							Map<String, Object> datos = new HashMap<>();

							x = 1;
							datos.put("op", x);
							datos.put("nom_usuariooo", map.get("usuario"));
							out.println(g.toJson(datos));
					} else {
						out.println(0);
					}

				} else {
					session.setAttribute("idusuario", null);
					session.setAttribute("nombres", null);
					session.setAttribute("password_u", null);
					session.setAttribute("usuario", null);
					session.invalidate();

				}
					
				} catch (Exception e) {
					System.out.println("Salto un error no esperado" + e);
				}
			}

		
}
