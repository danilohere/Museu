package control;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.DAOMainImpl;

public class MainControl {
	private DAOMainImpl dao = new DAOMainImpl();
	public void gerarRelatorio(){
		try {
			String relatorio = dao.gerarRelatorio();
			FileWriter arq;
			try {
				arq = new FileWriter("d:\\relatorio.txt");
				PrintWriter gravarArq = new PrintWriter(arq);
				 
			    gravarArq.println("Relatório");
			    gravarArq.println("-----------------");
			    gravarArq.printf(relatorio);
			    gravarArq.printf("-------------");
			 
			    arq.close();
			 
			    System.out.printf("Relatório gerado em C:");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
