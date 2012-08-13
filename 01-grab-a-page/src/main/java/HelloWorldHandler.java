import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import org.mortbay.jetty.Request;
import org.mortbay.jetty.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelloWorldHandler extends AbstractHandler{
    @Override
    public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch) throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        String content = CharStreams.toString(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("helloworld.html"), Charsets.UTF_8));
        response.getWriter().print(content);
        ((Request)request).setHandled(true);
    }
}
