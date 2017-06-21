package control;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.DAOMainImpl;

public class MainControl {
	private DAOMainImpl dao = new DAOMainImpl();
	private String path = System.getProperty("user.dir");
	public void gerarRelatorio(){
		try {
			String relatorio = dao.gerarRelatorio();
			FileWriter arq;
			try {
				arq = new FileWriter(path+"/relatorio/relatorio.txt");
				PrintWriter gravarArq = new PrintWriter(arq);
				 
			    gravarArq.println("Relatório");
			    gravarArq.println("-----------------");
			    gravarArq.println(relatorio);
			    gravarArq.println("-------------");
			 
			    arq.close();
			 
			    System.out.printf("Relatório gerado na pasta Relatórios");
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
