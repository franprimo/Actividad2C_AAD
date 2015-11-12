package parser_html;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Parser {
	
	public static void main(String arg[]){
		String html = "http://www.pccomponentes.com/";
		Document htmlFile = null;
		try {
			//Realiza la conexion a la web que le pases como paramatre
			htmlFile = Jsoup.connect(html).get();
			Elements productos = htmlFile.getElementsByClass("nombre");
			//Saco el tamaño del elemento productos para saber cuantos hay y poder recorrerlo 
			int numProd = productos.size();
			//Como ya se cuantos productos tengo, lo recorro obteniendo lo que quiero
			for(int i = 0; i < numProd; i++){
				String titulo = htmlFile.getElementsByClass("nombre").get(i).text();
				String precio = htmlFile.getElementsByClass("preciosProductos").get(i).text();
				System.out.println("Contenido: "+titulo+". Precio: "+precio);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
