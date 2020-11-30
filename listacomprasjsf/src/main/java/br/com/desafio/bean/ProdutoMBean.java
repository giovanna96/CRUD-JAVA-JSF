package br.com.desafio.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.desafio.dao.DaoGeneric;
import br.com.desafio.entidade.Produto;


@ManagedBean
@ViewScoped
public class ProdutoMBean {
	
	private Produto produto = new Produto();
	
	private DaoGeneric<Produto> daoGeneric = new DaoGeneric<Produto>();
	
	public String salvar() {
		daoGeneric.salvar(produto);
		return "";
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
