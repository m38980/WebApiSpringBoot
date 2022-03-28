package st.evora.engenharia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "distrito")
public class Distrito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iddistrito;
	
	private String abreviatura;
	private String descricao;
	
	
	public Distrito() {
		super();
	}
	
	
	public Distrito(Long iddistrito, String abreviatura, String descricao) {
		super();
		this.iddistrito = iddistrito;
		this.abreviatura = abreviatura;
		this.descricao = descricao;
	}
	public Long getIddistrito() {
		return iddistrito;
	}
	public void setIddistrito(Long iddistrito) {
		this.iddistrito = iddistrito;
	}
	public String getAbreviatura() {
		return abreviatura;
	}
	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
