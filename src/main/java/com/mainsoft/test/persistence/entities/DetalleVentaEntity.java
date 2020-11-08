package com.mainsoft.test.persistence.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "DETALLE_VENTA")
@Data
@AllArgsConstructor
public class DetalleVentaEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JoinColumn(name = "id_venta")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<VentaEntity> ventas;
	private Long idProducto;
	@ManyToOne
	@JoinColumn
	private ProductoEntity producto;
	
	public DetalleVentaEntity() {
		this.ventas = new ArrayList<>();
	}

}
