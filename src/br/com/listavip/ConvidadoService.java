package br.com.listavip;

import java.util.List;

public class ConvidadoService {
	
	public List<Convidado> obterListaDeConvidados(){
		return new ConvidadoRepository().obterobterListaDeConvidados();
	}
	
	public void salvarConvidado(Convidado convidado){
		new ConvidadoRepository().salvarConvidado(convidado);
		
	}

}
