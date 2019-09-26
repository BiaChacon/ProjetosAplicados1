package com.pa1.backend.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Reserva implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idReserva;
	private Date dataReserva;
	private Integer horarios[] = new Integer[16];
	private String responsavel;
	
    @JsonManagedReference
	@ManyToOne
	@JoinColumn(name="espaco_id")
	private Espaco espaco;
	
	public Reserva() {}

	public Reserva(Integer idReserva, Date dataReserva, Integer[] horarios, String responsavel, Espaco espaco) {
		super();
		this.idReserva = idReserva;
		this.dataReserva = dataReserva;
		this.horarios = horarios;
		this.responsavel = responsavel;
		this.espaco = espaco;
	}

	public Integer getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}

	public Date getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
	}

	public Integer[] getHorarios() {
		return horarios;
	}

	public void setHorarios(Integer[] horarios) {
		this.horarios = horarios;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public Espaco getEspaco() {
		return espaco;
	}

	public void setEspaco(Espaco espaco) {
		this.espaco = espaco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idReserva == null) ? 0 : idReserva.hashCode());
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
		Reserva other = (Reserva) obj;
		if (idReserva == null) {
			if (other.idReserva != null)
				return false;
		} else if (!idReserva.equals(other.idReserva))
			return false;
		return true;
	}
	
	
	
}