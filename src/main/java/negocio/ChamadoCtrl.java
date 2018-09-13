package negocio;

import beans.Chamado;
import beans.GoogleDis;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class ChamadoCtrl implements Serializable {

	private static final long serialVersionUID = 6030249996872717733L;

	private Chamado ch;
	private List<Chamado> listaChamados = new ArrayList<Chamado>();
	private double valorTotal;
	private GoogleDisCtrl resultado = new GoogleDisCtrl();
	private String link;
	public double number = 0;

	public void dataForm() {
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date();
		String str = fmt.format(data);
		ch.setData(str);
		
	}

	@SuppressWarnings("static-access")
	public void addChamados(String km, GoogleDis l) {
		ch.setKm(Double.parseDouble(km.replaceAll("km", "").trim().replace(',', '.')));
		listaChamados.add(ch);
		dataForm();
		ch.setValorUnitario(ch.getKm() * 0.65);
		link = ("http://www.google.com/maps/dir/?api=1&origin=" + l.getOrigem() + "&destination=" + l.getDestino());
		ch.setUrl(link.replaceAll(",", "%2C").replaceAll(" ", "+"));
		valorDosChamados();
		total();
		this.ch = new Chamado();
		
	}
	
	public double total() {

		// number = Double.parseDouble(resultado.rest);
		// System.out.println(number);
		return number;
	}

	public void removerChamado(ActionEvent evento) {
		ch = (Chamado) evento.getComponent().getAttributes().get("chamadoSelecionado");
		listaChamados.remove(ch);
		valorDosChamados();

	}

	public void inserirChamado() {

	}

	public List<Chamado> getListaChamados() {
		return listaChamados;
	}

	public void setListaChamados(List<Chamado> listaChamados) {
		this.listaChamados = listaChamados;
	}

	public Chamado getCh() {
		if (ch == null) {
			ch = new Chamado();
		}
		return ch;
	}

	public void setCh(Chamado ch) {
		this.ch = ch;
	}

	public void valorDosChamados() {

		double valorTotal = 0;
		DecimalFormat formato = new DecimalFormat("#,##.00");
		valorTotal = Format(formato);
		for (int i = 0; i < listaChamados.size(); i++) {
			valorTotal += listaChamados.get(i).getValorUnitario();
		}
		// this.ch.setValorTotal(valorTotal);
		this.valorTotal = valorTotal;
	}

	private double Format(DecimalFormat formato) {
		// TODO Auto-generated method stub
		return 0;
	}

	public GoogleDisCtrl getResultado() {
		return resultado;
	}

	public void setResultado(GoogleDisCtrl resultado) {
		this.resultado = resultado;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
}