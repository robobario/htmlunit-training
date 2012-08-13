import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.google.common.collect.Iterables;
import org.junit.Before;
import org.junit.Test;
import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PageGrabTestCase {
    private Server server;
    private Connector connector;

    @Before
    public void setup() throws Exception {
        server = new Server(0);
        server.addHandler(new HelloWorldHandler());
        server.start();
        connector = server.getConnectors()[0];
    }

    @Test
    public void testHelloWorld() throws IOException {
        final WebClient webClient = new WebClient();
        HtmlPage page = webClient.getPage("http://127.0.0.1:" + connector.getLocalPort() + "/");
        //check that the h1 contains 'Hello World'
    }

    @Test
    public void testGetJavascriptVariable() throws IOException {
        final WebClient webClient = new WebClient();
        HtmlPage page = webClient.getPage("http://127.0.0.1:" + connector.getLocalPort() + "/");
        //assert that window.bignumber = 5
    }

    @Test
    public void testGetValueFromDivWithClass() throws IOException {
        final WebClient webClient = new WebClient();
        HtmlPage page = webClient.getPage("http://127.0.0.1:" + connector.getLocalPort() + "/");
        //get the h2 element who's parent div has class "pickme"
        List<?> byXPath = page.getByXPath("//div[@class='pickme']/h2");
        HtmlElement element = (HtmlElement) Iterables.getOnlyElement(byXPath);
        assertEquals("Hello Apocalypse 3", element.getTextContent());
    }

    /**
     * Modifying the example above you can use xpath to move up or down the xml tree
     */
    @Test
    public void testTheNameOfTheDivOneLevelHigherDivWithClass() throws IOException {
        final WebClient webClient = new WebClient();
        HtmlPage page = webClient.getPage("http://127.0.0.1:" + connector.getLocalPort() + "/");
        //get the name of the div element who's child div has class "pickme"
        List<?> byXPath = page.getByXPath("");
        HtmlElement element = (HtmlElement) Iterables.getOnlyElement(byXPath);
        assertEquals("hi", element.getAttribute("name"));
    }


    @Test
    public void testClickingLinkIncrementsBignumber() throws IOException {
        final WebClient webClient = new WebClient();
        HtmlPage page = webClient.getPage("http://127.0.0.1:" + connector.getLocalPort() + "/");
        //click link
        //assert that window.bignumber = 5
    }


}
