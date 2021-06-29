package br.com.crud.aplication;

import br.com.crud.dao.crudDAO;
import br.com.crud.model.Crud;

public class Main {

	public static void main(String[] args) {
	
			crudDAO crudDao = new crudDAO();
		
			Crud crud = new Crud();
			
			crud.setNome("MAYCON MOTTA DA SILVA");
			crud.setIdade(24);
			crud.setCpf("36565987945");
			crud.setHobby("Gosta de Estudar");
			crud.setSexo("N");
			crud.setDatanascimento("07/02/1225");
			
			crudDao.save(crud);
			
			System.out.println("USUÁRIO INSERIDO:");
			System.out.println(crud.getNome() + " - " + crud.getIdade() + " - " + crud.getCpf() + " - " + crud.getDatanascimento());			System.out.println("_________________________");

			
	// UPDATE  
			Crud c1 = new Crud();
			c1.setNome("MAYCON MOTTA DA SILVA");
			c1.setCpf("09850035961");
			c1.setSexo("M");
			c1.setDatanascimento("10/11/1999");
			c1.setIdade(79);
			c1.setHobby("Comer e correr");
			System.out.println("_________________________");
			System.out.println("Atualização do Funcionário:");
			System.out.println(c1.getNome() + " - " + c1.getIdade() + " - " + c1.getCpf() + " - " + c1.getDatanascimento());
			
			
	// DELETE POR ID LISTADO NO BANCO...
			
			// INFORMAR O ID A SER DELETADO:
			int ID = 60;
			
			crudDao.deleteByid(ID);
			System.out.println("_________________________");
			
			crudDao.update(c1);
			System.out.println("USUÁRIO DELETADOS (ID): " + ID);
			System.out.println();
			
			
	// Visualização de total de colaboradores Cadastrado no Sistema
			System.out.println("_________________________");
			System.out.println("LISTAGEM DOS DESENVOLVEDORES JÁ CADASTRADOS NO SISTEM: ");
			for(Crud c : crudDao.getCrud()) {
				
				System.out.println(" ID: " + c.getId() + " - " + c.getNome() + " - IDADE: " + c.getIdade() + " - CPF: " + c.getCpf() + " -  DATA DE NASCIMENTO: " + c.getDatanascimento());		
			}
	}


}

