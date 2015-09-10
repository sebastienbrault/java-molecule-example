package yose;

import static com.vtence.molecule.http.MimeTypes.JSON;

import com.google.gson.Gson;
import com.vtence.molecule.Request;
import com.vtence.molecule.Response;

import yose.Ping.Pong;

public class Home {

    public Home() {

    }
    

    public void homePage(Request request, Response response) throws Exception {
        response.contentType("text/html");
        response.body(buildHomePage());
    }
    
    public String buildHomePage() {
    	String htmlBody = "<html><head></head><body>";
    	htmlBody += "Hello Yose";
    	htmlBody += "Equipe en avant à gauche / à droite";
    	htmlBody += "<br/><a id=\"contact-me-link\" href=\"contactme\">Contactez en avant.</a>";
    	htmlBody += "<br/>Best team members:";
    	htmlBody += "<br/>Maïté Cartiny";
    	htmlBody += "<br/>Stéphane Bouget";
    	htmlBody += "<br/>Yannick Cornaille";
    	htmlBody += "<br/>Sébastien Brault";
    	htmlBody += "<br/><a id=\"repository-link\" href=\"https://github.com/sebastienbrault/java-molecule-example\">Source repository.</a>";
    	htmlBody += "<br/><a id=\"ping-challenge-link\" href=\"http://equipeenavantgauche.herokuapp.com/ping\">Source repository.</a>";
    	htmlBody += "<br/><img src=\"https://lh3.googleusercontent.com/-M7IAAlC3Bm8/VfBFCP4segI/AAAAAAAACrY/Ez6BI7-JXaQ/w852-h600/2015%2B-%2B1\"/>";
    	htmlBody += "</body>";
    	return htmlBody;
    }

}
