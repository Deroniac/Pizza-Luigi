package be.vdab.listeners;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class Mandjelistener
 *
 */
@WebListener
public class Mandjelistener implements HttpSessionAttributeListener, ServletContextListener {
	private static final String MANDJE = "mandje";
	private static final String AANTAL_MANDJES = "aantalMandjes";
    /**
     * Default constructor. 
     */
    public Mandjelistener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    	if (MANDJE.equals(event.getName())) {
    		((AtomicInteger) event.getSession().getServletContext().getAttribute(AANTAL_MANDJES))
    		.incrementAndGet();
    	}
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    	if (MANDJE.equals(event.getName())) {
    		((AtomicInteger) event.getSession().getServletContext().getAttribute(AANTAL_MANDJES))
    		.decrementAndGet();
    	}
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
         // TODO Auto-generated method stub
    	event.getServletContext().setAttribute(AANTAL_MANDJES, new AtomicInteger());
    }
	
}
