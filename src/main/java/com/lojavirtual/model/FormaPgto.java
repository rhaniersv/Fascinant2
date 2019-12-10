package com.lojavirtual.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FormaPgto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String descricao;

	private int numMaxParc;

	private int numPadraoParc;

	private int intervaloDias;

	private float percentualAcres;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getNumMaxParc() {
		return numMaxParc;
	}

	public void setNumMaxParc(int numMaxParc) {
		this.numMaxParc = numMaxParc;
	}

	public int getNumPadraoParc() {
		return numPadraoParc;
	}

	public void setNumPadraoParc(int numPadraoParc) {
		this.numPadraoParc = numPadraoParc;
	}

	public int getIntervaloDias() {
		return intervaloDias;
	}

	public void setIntervaloDias(int intervaloDias) {
		this.intervaloDias = intervaloDias;
	}

	public float getPercentualAcres() {
		return percentualAcres;
	}

	public void setPercentualAcres(float percentualAcres) {
		this.percentualAcres = percentualAcres;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + id;
		result = prime * result + intervaloDias;
		result = prime * result + numMaxParc;
		result = prime * result + numPadraoParc;
		result = prime * result + Float.floatToIntBits(percentualAcres);
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
		FormaPgto other = (FormaPgto) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id != other.id)
			return false;
		if (intervaloDias != other.intervaloDias)
			return false;
		if (numMaxParc != other.numMaxParc)
			return false;
		if (numPadraoParc != other.numPadraoParc)
			return false;
		if (Float.floatToIntBits(percentualAcres) != Float.floatToIntBits(other.percentualAcres))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FormaPgto [id=" + id + ", descricao=" + descricao + ", numMaxParc=" + numMaxParc + ", numPadraoParc="
				+ numPadraoParc + ", intervaloDias=" + intervaloDias + ", percentualAcres=" + percentualAcres + "]";
	}

}
