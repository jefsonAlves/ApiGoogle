package beans;

import negocio.GoogleDisCtrl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jboss.jandex.Main;

public class GoogleDis {
	private int idGoogle;
	protected String origem;
	protected String destino;
	public String rest;
	public String link;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "idGoogle", cascade = CascadeType.ALL)
	private List<GoogleDis> googleDis = new ArrayList<>();

	public String gerarCalc(String origem, String destino) {
		URL url;
		try {
			url = new URL("http://maps.google.es/maps/api/directions/xml?origin=" + origem + "&destination=" + destino
					+ "&sensor=false");
			
			Document document = getDocumento(url);
			return analisaXml(document);
		} catch (MalformedURLException | DocumentException e) {
			e.printStackTrace();

		}
		
		return "";

	}

	@SuppressWarnings("rawtypes")
	public static String analisaXml(Document document) {
		
		List list = document.selectNodes("//DirectionsResponse/route/leg/distance/text");

		
		Element element = (Element) list.get(list.size() - 1);

		return element.getText();
	}

	public static Document getDocumento(URL url) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(url);
		return document;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String objeto) {
		this.link = objeto;
	}
	public List<GoogleDis> getGoogleDis() {
		return googleDis;
	}

	public void setGoogleDis(List<GoogleDis> googleDis) {
		this.googleDis = googleDis;
	}

	public int getIdGoogle() {
		return idGoogle;
	}

	public void setIdGoogle(int idGoogle) {
		this.idGoogle = idGoogle;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getRest() {
		return rest;
	}

	public void setRest(String rest) {
		this.rest = rest;
	}
	
	public String link(String link) {
		link = this.link;

		return link;

	}


}
