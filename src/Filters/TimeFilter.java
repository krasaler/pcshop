package Filters;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
public class TimeFilter implements Filter {

    public TimeFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		long start = System.currentTimeMillis();
		response.setContentType("text/html;charset=utf-8");
		((HttpServletResponse)response).setHeader("cache-control", "no-cache");
		
		PrintWriter out = response.getWriter();
		CharResponseWrapper wrapper = new CharResponseWrapper((HttpServletResponse)response);
		
		chain.doFilter(request, wrapper);
		long load = System.currentTimeMillis() - start;
		String timeload = String.format("%1$tM:%1$tS:%1$tL", load);
		CharArrayWriter caw = new CharArrayWriter();
		caw.write(wrapper.toString().substring(0, wrapper.toString().indexOf("</body>")-1));
		caw.write("<div class=footer><center> Время загрузки: "+ timeload + "<center></div>");
		caw.write("\n</body></html>");
		out.write(caw.toString());
		out.close();
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
	}

	public class CharResponseWrapper extends HttpServletResponseWrapper {
		   private CharArrayWriter output;
		   public String toString() {
		      return output.toString();
		   }
		   public CharResponseWrapper(HttpServletResponse response){
		      super(response);
		      output = new CharArrayWriter();
		   }
		   public PrintWriter getWriter(){
		      return new PrintWriter(output);
		   }
		}
}
