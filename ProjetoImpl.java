package mAPa;

import mAPa.DadoConsultadoException;
import mAPa.Projeto;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProjetoImpl implements ProjetoDAO{
	//Collection que irá armazenar todos os projetos
    private static Set<Projeto> projetos = new HashSet<>();
 
 
    @Override
    public void adicionar(Projeto projeto) {
    	projetos.add(projeto);
 
    }
 
    @Override
    public List<Projeto> listar() {
    	List<Projeto> projetoList = new ArrayList<>();
    	projetoList.addAll(projetos);
    	return projetoList;
    }
 
    @Override
    public Projeto consultarPorNome(String nome) throws DadoConsultadoException {
        for(Projeto projeto: projetos) {
        	if(projeto.getNome().equalsIgnoreCase(nome)) {
        		System.out.println("Alterado com sucesso!");
        		return projeto;
        		
        	}
        }
        throw new DadoConsultadoException("Projeto nao encontrado com o nome: "+nome);
    }
 
    @Override
    public Projeto alterar(String nome, Projeto projeto) throws DadoConsultadoException {
    	Projeto projetoEncontrado = consultarPorNome(nome);
    	projetoEncontrado.setNome(projeto.getNome());
    	projetoEncontrado.setObjetivo(projeto.getObjetivo());
    	projetoEncontrado.setNecessidades(projeto.getNecessidades());
    	projetoEncontrado.setDataInicio(projeto.getDataInicio());
    	projetoEncontrado.setDataFinal(projeto.getDataFinal());
    	projetoEncontrado.setStatus(projeto.getStatus());
        return projetoEncontrado;
    }
 
    @Override
    public void excluir(Projeto projeto) throws DadoConsultadoException, UnsupportedOperationException {
    	if(projetos.contains(projeto)) {
    		projetos.remove(projeto);
    		System.out.println("Excluido com Sucesso!");
    		return;
    	}
    	throw new DadoConsultadoException("Nao encontrado projeto pra exclusao");
 
    }
 
    @Override
    public void excluir(String nome) throws DadoConsultadoException, UnsupportedOperationException {
    	Projeto projeto = consultarPorNome(nome);
    	this.excluir(projeto);
 
    }

}
