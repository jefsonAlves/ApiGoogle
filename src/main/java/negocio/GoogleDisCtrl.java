package negocio;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import beans.GoogleDis;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class GoogleDisCtrl extends GoogleDis {

	protected List<GoogleDisCtrl> listaDistancia = new ArrayList<GoogleDisCtrl>();
	private GoogleDis distancia = new GoogleDis();

	public GoogleDis getDistancia() {
		return distancia;
	}

	public void setDistancia(GoogleDis distancia) {
		this.distancia = distancia;
	}

	public List<GoogleDisCtrl> getListaDistancia() {
		return listaDistancia;
	}

	public void setListaDistancia(List<GoogleDisCtrl> listaDistancia) {
		this.listaDistancia = listaDistancia;
	}
	
	public String resultado() {

		this.setRest(gerarCalc(distancia.getOrigem(), distancia.getDestino()));
		// double d = Double.parseDouble(resultado);
		return this.getRest();

	}
	@SuppressWarnings("static-access")
	public void calcularDis() {
		
		 //this.setOrigem("rua w cinco, GOiania");
		distancia.setOrigem(origem);
		//this.setDestino("avenida independencia, goiania");
		distancia.setDestino(destino);
//		String link = ("http://www.google.com/maps/dir/?api=1&origin=" + distancia.getOrigem() + "&destination=" + distancia.getDestino());
//		distancia.setLink(link.replaceAll(",", "%2C").replaceAll(" ", "+"));
		resultado();
	}

}
