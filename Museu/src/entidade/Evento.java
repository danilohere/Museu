package entidade;

import java.util.Date;

public class Evento {
	private long id;
	private String nome;
	private Date datainicio;
	private Date dataenc;
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
	public Date getDatainicio() {
		return datainicio;
	}
	public void setDatainicio(Date datainicio) {
		this.datainicio = datainicio;
	}
	public Date getDataenc() {
		return dataenc;
	}
	public void setDataenc(Date dataenc) {
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
