package com.lojavirtual.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItensPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	private Pedido pedido;

	@ManyToOne
	private Produto produto;

	private float qtde;

	private float valorUnit;

	private float subTotal;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public float getQtde() {
		return qtde;
	}

	public void setQtde(float qtde) {
		this.qtde = qtde;
	}

	public float getValorUnit() {
		return valorUnit;
	}

	public void setValorUnit(float valorUnit) {
		this.valorUnit = valorUnit;
	}

	public float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + Float.floatToIntBits(qtde);
		result = prime * result + Float.floatToIntBits(subTotal);
		result = prime * result + Float.floatToIntBits(valorUnit);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItensPedido other = (ItensPedido) obj;
		if (id != other.id)
			return false;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (Float.floatToIntBits(qtde) != Float.floatToIntBits(other.qtde))
			return false;
		if (Float.floatToIntBits(subTotal) != Float.floatToIntBits(other.subTotal))
			return false;
		if (Float.floatToIntBits(valorUnit) != Float.floatToIntBits(other.valorUnit))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItensPedido [id=" + id + ", pedido=" + pedido + ", produto=" + produto + ", qtde=" + qtde
				+ ", valorUnit=" + valorUnit + ", subTotal=" + subTotal + "]";
	}

}
