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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "PRODUCTO")
@Data
@AllArgsConstructor
public class ProductoEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Double precio;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.EAGER)
	private List<DetalleVentaEntity> detallesVenta;
	
	public ProductoEntity() {
		this.detallesVenta = new ArrayList<>();
	}

}
