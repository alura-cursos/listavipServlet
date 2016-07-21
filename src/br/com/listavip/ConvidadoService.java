package br.com.listavip;

import java.util.List;

public class ConvidadoService {
	
	public List<Convidado> obterTodos(){
		return new ConvidadoRepository().obterTodos();
	}
	
	public void salvar(Convidado convidado){
		new ConvidadoRepository().salvar(convidado);
		
	}

}
