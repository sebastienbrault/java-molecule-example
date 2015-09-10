package yose;

import com.google.gson.Gson;
import com.vtence.molecule.WebServer;
import com.vtence.molecule.routing.DynamicRoutes;

import java.io.IOException;
import java.net.URI;

public class Yose {

    private final WebServer server;

    public Yose(int port) {
    	if (System.getProperty("os.name").toLowerCase().contains("win"))
    	{
            this.server = WebServer.create("localhost",port);
    	}
    	else
    	{
        	this.server = WebServer.create(port);
    	}
    }

    public void start() throws IOException {
        final Gson gson = new Gson();

        server.start(new DynamicRoutes() {{
           // get("/").to((request, response) -> response.body(buildHomePage()));
            get("/").to((request, response) -> response.body(buildHomePage()));

            get("/ping").to(new Ping(gson)::pong);
            get("/primeFactors").to(new PowerOfTwo()::initPage);
        }});
    }

    public String buildHomePage() {
    	String htmlBody = "<!doctype html>"; 
    	htmlBody += "<html><head></head><body>";
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
    
    public URI uri() {
        return server.uri();
    }

    public void stop() throws IOException {
        server.stop();
    }

    private static final int PORT = 0;

    private static int port(String[] args) {
        return args.length > 0 ? Integer.parseInt(args[PORT]) : 8080;
    }

    public static void main(String[] args) throws IOException {
        Yose yose = new Yose(port(args));
        yose.start();
        System.out.print("To play the game visit " + yose.uri());
    }
}