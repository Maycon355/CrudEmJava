package br.com.crud.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.com.crud.factory.ConnectionFactory;
import br.com.crud.model.Crud;

public class crudDAO {
	//APENAS TESTE CRUD
	// METODO INSERT
	public void save(Crud crud) {
		String sql = "INSERT INTO crud(nome,idade,sexo,hobby,cpf,Datanascimento) VALUES (?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
				try {
			///Criar conexão a partir da classe Factory 
			conn = ConnectionFactory.createConnectionToMySql();
			
			//PreparedStatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//Add = os dados esperado pela query	
			pstm.setString(1, crud.getNome());
			pstm.setInt(2, crud.getIdade());
			pstm.setString(3, crud.getSexo());
			pstm.setString(4, crud.getHobby());
			pstm.setString(5, crud.getCpf());
			pstm.setString(6, crud.getDatanascimento());
			
			//Executar
			pstm.execute();
			
			System.out.println("Inserção de Desenvolvedor feita com SUCESSO, \nSeja BEM VINDO:");
	
	}
		catch (Exception e) {
		e.printStackTrace();
	}finally {
		// Fechar as conexões
		try {
			if (pstm!=null) {
				pstm.close();
			}
			if (conn!=null){
				conn.close();
				}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	}

	public void update (Crud crud){
		
		String sql = "UPDATE crud SET nome = ?, idade = ?, sexo = ?, hobby = ?, cpf = ?, datanascimento = ? ";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		
		try {
			///Criar conexão a partir da classe Factory
			conn = ConnectionFactory.createConnectionToMySql();
			
			//PreparedStatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//Add = os dados esperado pela query	
			pstm.setString(1, crud.getNome());
			pstm.setInt(2, crud.getIdade());
			pstm.setString(3, crud.getSexo());
			pstm.setString(4, crud.getHobby());
			pstm.setString(5, crud.getCpf());
			pstm.setString(6, crud.getDatanascimento());
			
			//Executar
			pstm.execute();
	
	}
		catch (Exception e) {
		e.printStackTrace();
	}finally {
		// Fechar as conexões
		try {
			if (pstm!=null) {
				pstm.close();
			}
			if (conn!=null){
				conn.close();
				}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	}

	public void deleteByid (int id) {
		String sql= "DELETE FROM crud WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		
		try {
			conn = ConnectionFactory.createConnectionToMySql();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, id);

			pstm.execute();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if (pstm != null) {
				pstm.close();
				
			}if (pstm != null) {
				pstm.close();
				
			}
			if(conn!=null) {
				conn.close();
			}
		}catch(Exception e) {
				e.printStackTrace();
				
		}
			}
	}
	
	public List<Crud> getCrud(){
		
		String sql= "SELECT * FROM crud";
	
	List<Crud> crud = new ArrayList<Crud>();
	
		Connection conn = null;
		PreparedStatement pstm = null;
		//Classe que vai recuperar do BD
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySql();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				
			
			Crud crud1 = new Crud();
				//Recuperar o ID:
			crud1.setId(rset.getInt("ID"));
				//Recuperar o CPF:
			crud1.setCpf(rset.getString("CPF"));
				//Recuperar o NOME:
			crud1.setNome(rset.getString("NOME"));
				//Recuperar o IDADE:
			crud1.setIdade(rset.getInt("IDADE"));
				//Recuperar o SEXO:
			crud1.setSexo(rset.getString("SEXO"));
				//Recuperar o ID:
			crud1.setHobby(rset.getString("Hobby"));
				//Recuperar o DATA
			crud1.setDatanascimento(rset.getString("Datanascimento"));
			
			
			crud.add(crud1);	
			}
			
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		try {
		if (rset != null) {
			rset.close();
			
		}if (pstm != null) {
			pstm.close();
			
		}
		if(conn!=null) {
			conn.close();
		}
	}catch(Exception e) {
			e.printStackTrace();
			
	}
		}
	
		
	return crud;
	
}
}


