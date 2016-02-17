package org.wrex.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * This servlet generates a sitemap xml. You can use it to dynamiclly generate the sitemap of your app. Commented code shows how to get
 * a backend service and itearate over a list of objets generating the xml. This sitemap complies with google tools.
 * @author ggefaell
 *
 */
@WebServlet("/sitemap.xml")
public class SitemapServlet extends HttpServlet {

	WebApplicationContext _context;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
	    super.init(config);
	     ServletContext servletContext = this.getServletContext();
	    this._context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
	}
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/xml");
        // You might want to add finer grained browser cache related headers.

        PrintWriter output = response.getWriter();
        
//        LocationService serv = (LocationService) _context.getBean("locationService");
        String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\" xmlns:xhtml=\"http://www.w3.org/1999/xhtml\">";
        output.append(header);
        String pages = "<url><loc>http://www.wiklimb.com/</loc><xhtml:link rel=\"alternate\" hreflang=\"es\" href=\"http://www.wiklimb.com/?lang=es\"/><xhtml:link rel=\"alternate\" hreflang=\"en\" href=\"http://www.wiklimb.com/?lang=en\"/></url>"
        		+ "<url><loc>http://www.wiklimb.com/createLocation</loc><xhtml:link rel=\"alternate\" hreflang=\"es\" href=\"http://www.wiklimb.com/createLocation?lang=es\"/><xhtml:link rel=\"alternate\" hreflang=\"en\" href=\"http://www.wiklimb.com/createLocation?lang=en\"/></url>"
        		+ "<url><loc>http://www.wiklimb.com/help</loc><xhtml:link rel=\"alternate\" hreflang=\"es\" href=\"http://www.wiklimb.com/help?lang=es\"/><xhtml:link rel=\"alternate\" hreflang=\"en\" href=\"http://www.wiklimb.com/help?lang=en\"/></url>"
        		+ "<url><loc>http://www.wiklimb.com/guide</loc><xhtml:link rel=\"alternate\" hreflang=\"es\" href=\"http://www.wiklimb.com/guide?lang=es\"/><xhtml:link rel=\"alternate\" hreflang=\"en\" href=\"http://www.wiklimb.com/guide?lang=en\"/></url>"
        		+ "<url><loc>http://www.wiklimb.com/search</loc><xhtml:link rel=\"alternate\" hreflang=\"es\" href=\"http://www.wiklimb.com/search?lang=es\"/><xhtml:link rel=\"alternate\" hreflang=\"en\" href=\"http://www.wiklimb.com/search?lang=en\"/></url>"
        		+ "<url><loc>http://www.wiklimb.com/about</loc><xhtml:link rel=\"alternate\" hreflang=\"es\" href=\"http://www.wiklimb.com/about?lang=es\"/><xhtml:link rel=\"alternate\" hreflang=\"en\" href=\"http://www.wiklimb.com/about?lang=en\"/></url>";
        output.append(pages);
//        for (Location loc : serv.getList()) {
//        	String url = "http://www.wiklimb.com/"+loc.getIdlocation()+"/"+loc.getName();
//			String cad = "<url><loc>"+url+"</loc><xhtml:link rel=\"alternate\" hreflang=\"es\" href=\""+url+"?lang=es\"/><xhtml:link rel=\"alternate\" hreflang=\"en\" href=\""+url+"?lang=en\"/></url>";
//			output.append(cad);
//		}
        output.append("</urlset>");
        output.close();    
    }

}    