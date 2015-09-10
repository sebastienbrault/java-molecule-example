package yose.worlds;

import com.vtence.molecule.testing.http.HttpRequest;
import com.vtence.molecule.testing.http.HttpResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import yose.YoseDriver;

import java.io.IOException;

import static com.vtence.molecule.testing.http.HttpResponseAssert.assertThat;

public class StartWorld {

    YoseDriver yose = new YoseDriver(9999);

    HttpRequest request = new HttpRequest(9999);
    HttpResponse response;

    @Before
    public void startGame() throws Exception {
        yose.start();
    }

    @After
    public void stopGame() throws Exception {
        yose.stop();
    }

    @Test
    public void firstWebPageChallenge() throws IOException {
        yose.home().displaysGreeting("Hello Yose");
    }

    @Test
    public void testForContacts() throws IOException {
        yose.home().checkCreatorNames("Maïté Cartiny");
        yose.home().checkCreatorNames("Stéphane Bouget");
    }

    @Test
    public void testForSourceURL() throws IOException {
        yose.home().checkSrcURL("repository-link");
        yose.home().checkSrcURL("https://github.com/sebastienbrault/java-molecule-example");
    }
    
    @Test
    public void testForPingURL() throws IOException {
        yose.home().checkPingURL("ping-challenge-link");
        yose.home().checkPingURL("http://equipeenavantgauche.herokuapp.com/ping");
    }
    
    @Test
    public void testHomePageContentType() throws IOException {
        response = request.get("/");

        assertThat(response).isOK()
                            .hasContentType("text/html");
    }
    
    @Test
    public void firstWebServiceChallenge() throws IOException {
        response = request.get("/ping");

        assertThat(response).isOK()
                            .hasContentType("application/json")
                            .hasBodyText("{\"alive\":true}");
    }
}
