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
	
	private List<Produto> produtos;
	
	
	private DaoGeneric<Produto> daoGeneric = new DaoGeneric<Produto>();
	
	
	public ProdutoMBean() {
		produto = new Produto();
		produtos = new ArrayList<Produto>();
		listProdutos();
	}

	public String salvar() {
		daoGeneric.salvar(produto);
		produto =  new Produto();
		listProdutos();
		return null;
	}
	
	public String editar() {
		daoGeneric.editar(produto);
		produto =  new Produto();
		listProdutos();
		return null;
	}
	
	public String deletar(Produto produto) {
		daoGeneric.deleteById(produto);
		produto =  new Produto();
		listProdutos();
		return null;
	}
	
	public String verProduto(Long id) {
		produto = daoGeneric.findById(Produto.class,id);
		return null;
	}
	
	public void listProdutos() {
		produtos = daoGeneric.findAll(Produto.class);
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public DaoGeneric<Produto> getDaoGeneric() {
		return daoGeneric;
	}

	public void setDaoGeneric(DaoGeneric<Produto> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}
}
