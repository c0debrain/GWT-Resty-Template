package rq.restygwt.template.client;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import rq.restygwt.template.shared.Person;

@Path("api/v1/persons")
public interface PersonService extends RestService
{
    @GET
    void getPersons(MethodCallback<List<Person>> callback);
    
    @GET
    @Path("{id}")
    void getPerson(@PathParam("id") String id, MethodCallback<Person> callback);
}
