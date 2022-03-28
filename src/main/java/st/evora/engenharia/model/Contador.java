package st.evora.engenharia.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contador")
public class Contador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcontador;
	
	//Mapeamento de Relação entre ás Tabelas Cliente - Contador (1-N)
	@ManyToOne(fetch = FetchType.EAGER,  cascade=CascadeType.ALL)
	@JoinColumn(name="idcliente")
	private Cliente cliente;
	
	//Mapeamento de Relação entre ás Tabelas Localizacao - Contador (1-N)
	@ManyToOne(fetch = FetchType.EAGER,  cascade=CascadeType.ALL)
	@JoinColumn(name="idlocalizacao")
	private Localizacao localizacao;
	
	
	//Mapeamento de Relação entre ás Tabelas Distrito - Contador (1-N)
	@ManyToOne(fetch = FetchType.EAGER,  cascade=CascadeType.ALL)
	@JoinColumn(name="iddistrito")
	private Distrito distrito;
	
	
	//Mapeamento de Relação entre ás Tabelas Cidade - Contador (1-N)
	@ManyToOne(fetch = FetchType.EAGER,  cascade=CascadeType.ALL)
	@JoinColumn(name="idcidade")
	private Cidade cidade;
	
	
	
	private String conta_numero;
	private String numero_contador;
	private double latitude ;
	private double longitude;
	private Integer leitura_anterior;
	private Integer nova_leitura;
	private String ramal;
	private String descricao;
	
	
	public Contador() {
	}

	public Contador(Long idcontador, String conta_numero, String numero_contador, double latitude, double longitude,
			Integer leitura_anterior, Integer nova_leitura, String ramal, String descricao) {
		super();
		this.idcontador = idcontador;
		this.conta_numero = conta_numero;
		this.numero_contador = numero_contador;
		this.latitude = latitude;
		this.longitude = longitude;
		this.leitura_anterior = leitura_anterior;
		this.nova_leitura = nova_leitura;
		this.ramal = ramal;
		this.descricao = descricao;
	}
	public Long getIdcontador() {
		return idcontador;
	}
	public void setIdcontador(Long idcontador) {
		this.idcontador = idcontador;
	}
	public String getConta_numero() {
		return conta_numero;
	}
	public void setConta_numero(String conta_numero) {
		this.conta_numero = conta_numero;
	}
	public String getNumero_contador() {
		return numero_contador;
	}
	public void setNumero_contador(String numero_contador) {
		this.numero_contador = numero_contador;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public Integer getLeitura_anterior() {
		return leitura_anterior;
	}
	public void setLeitura_anterior(Integer leitura_anterior) {
		this.leitura_anterior = leitura_anterior;
	}
	public Integer getNova_leitura() {
		return nova_leitura;
	}
	public void setNova_leitura(Integer nova_leitura) {
		this.nova_leitura = nova_leitura;
	}
	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Contador(Cliente cliente) {
		this.cliente = cliente;
	}

	public Contador(Localizacao localizacao, Distrito distrito, Cidade cidade) {
		super();
		this.localizacao = localizacao;
		this.distrito = distrito;
		this.cidade = cidade;
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}
	
	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}
    
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
}
