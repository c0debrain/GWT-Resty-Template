package rq.restygwt.template.client;

import java.util.List;

import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import rq.restygwt.template.shared.Person;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;

public class Template implements EntryPoint
{

    public void onModuleLoad()
    {
        Defaults.setServiceRoot(GWT.getHostPageBaseURL()); // (avoid Template in the url)

        final HTML html = new HTML();
        RootPanel.get().add(html);

        // Uses resty generator (set up in gwt.xml)
        PersonService s = GWT.create(PersonService.class);

        
        s.getPersons(new MethodCallback<List<Person>>()
        {
            public void onSuccess(Method method, List<Person> response)
            {
                for (Person person : response)
                {
                    html.getElement().setInnerHTML(html.getElement().getInnerHTML() + "Hello " + person.getFirstName() + " " + person.getLastName() + "</br>");
                }
            }

            public void onFailure(Method method, Throwable exception)
            {
                html.setText("Rest call failed");
            }
        });

        s.getPerson("1", new MethodCallback<Person>()
        {
            public void onSuccess(Method method, Person response)
            {
                html.getElement().setInnerHTML(html.getElement().getInnerHTML() + "The first one is " + response.getFirstName() + " " + response.getLastName() + "</br>");

            }

            public void onFailure(Method method, Throwable exception)
            {
                html.setText("Rest call failed");
            }
        });
    }
}
