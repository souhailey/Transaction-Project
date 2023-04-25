package main;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		TransactionDao TransactionVar=new TransactionDaoImpl();
		Transaction TransactionInit = new Transaction();
		TransactionInit.setRef(request.getParameter("Ref"));
		TransactionInit.setCompteDeb(request.getParameter("CompteDeb"));
		TransactionInit.setCompteCred(request.getParameter("CompteCred"));
		TransactionInit.setMontant(Double.parseDouble(request.getParameter("Montant")));
		TransactionInit.setDevise(request.getParameter("Devise"));
		if(request.getParameter("CompteDeb").substring(0, 3).equals(request.getParameter("CompteCred").substring(0, 3)))
		{	
			TransactionInit.setType("VIRINT");
		}
		else {
			TransactionInit.setType("VIRCHAC");
		}
		TransactionVar.begin();
		int r=TransactionVar.save(TransactionInit);
		TransactionVar.commit();
		
		if(r==0) {
			out.println("<html>"
					+ "<body><h2>Error"
					+ "</h2></body></html>"
					+ ""
					+ "");
			
		}else {
			out.println("<html>"
					+ "<body><h2> bien ajoute"
					+ "</h2></body></html>"
					+ ""
					+ "");
		
		
	}
		out.println("<a href=\"display.jsp\">Display Transactions</a>");
}
}	
