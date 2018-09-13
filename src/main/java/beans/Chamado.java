package beans;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import negocio.GoogleDisCtrl;

import java.util.ArrayList;
import java.util.List;

public class Chamado{
	private int id = count++;
	private static int count = 0;
	private String data;
	private String numChamado;
	private String tipoDespesa;
	private String deslInicial;
	private String deslFinal;
	private double km;
	private double valorUnitario;
	private double valorTotal;
	public String url;

	@OneToMany(fetch = FetchType.EAGER,mappedBy = "id",cascade = CascadeType.ALL)
	private List<Chamado> chamados = new ArrayList<>();
	
	
	public List<Chamado> getChamados() {
		return chamados;
	}

	public Chamado() {
		this.id = count++;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}
	public String getUrl() {
		return url;
	}

	public void setUrl(String objeto) {
		this.url = objeto;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getNumChamado() {
		return numChamado;
	}

	public void setNumChamado(String numChamado) {
		this.numChamado = numChamado;
	}

	public String getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(String tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}

	public String getDeslInicial() {
		return deslInicial;
	}

	public void setDeslInicial(String deslInicial) {
		this.deslInicial = deslInicial;
	}

	public String getDeslFinal() {
		return deslFinal;
	}

	public void setDeslFinal(String deslFinal) {
		this.deslFinal = deslFinal;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double object) {
		this.km = object;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public Double setValorUnitario(double valorUnitario) {
		return this.valorUnitario = valorUnitario;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}


}
