package entity;

public class Evento {
	private long id;
	private String nome;
	private String descricao;
	private String datainicio;
	private String dataenc;
	private float valortot;
	private float valormeia;
	private int qnting;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDatainicio() {
		return datainicio;
	}
	public void setDatainicio(String datainicio) {
		this.datainicio = datainicio;
	}
	public String getDataenc() {
		return dataenc;
	}
	public void setDataenc(String dataenc) {
		this.dataenc = dataenc;
	}
	public float getValortot() {
		return valortot;
	}
	public void setValortot(float valortot) {
		this.valortot = valortot;
	}
	public float getValormeia() {
		return valormeia;
	}
	public void setValormeia(float valormeia) {
		this.valormeia = valormeia;
	}
	public int getQnting() {
		return qnting;
	}
	public void setQnting(int qnting) {
		this.qnting = qnting;
	}
}
