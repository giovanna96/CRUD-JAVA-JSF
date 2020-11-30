package br.com.desafio.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.desafio.dao.DaoGeneric;
import br.com.desafio.entidade.Produto;


@ManagedBean
@SessionScoped
public class ProdutoMBean {
	
	private Produto produto;
	
	
	private DaoGeneric<Produto> daoGeneric = new DaoGeneric<Produto>();
	
	
	public ProdutoMBean() {
		produto = new Produto();
	}

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
