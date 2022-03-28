package st.evora.engenharia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "localizacao")
public class Localizacao {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idlocalizacao;
	
	
	private String latitude;
	private String longitude;
	private String descricao;
	
	
	public Localizacao() {
		super();
	}
	
	public Localizacao(Long idlocalizacao, String latitude, String longitude, String descricao) {
		super();
		this.idlocalizacao = idlocalizacao;
		this.latitude = latitude;
		this.longitude = longitude;
		this.descricao = descricao;
	}
	public Long getIdlocalizacao() {
		return idlocalizacao;
	}
	public void setIdlocalizacao(Long idlocalizacao) {
		this.idlocalizacao = idlocalizacao;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
