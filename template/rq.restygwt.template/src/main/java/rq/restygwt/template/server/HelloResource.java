package rq.restygwt.template.server;

import java.util.Collection;
import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rq.restygwt.template.shared.Person;

import com.google.inject.Singleton;

@Singleton
@Path("v1/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HelloResource
{
    public HelloResource()
    {
        objects = new HashMap<String, Person>();
        Person o1 = new Person("1", "John", "Doe");
        Person o2 = new Person("2", "Kim", "Kardashian");
        Person o3 = new Person("3", "Bob", "Marley");
        objects.put(o1.getId(), o1);
        objects.put(o2.getId(), o2);
        objects.put(o3.getId(), o3);
    }

    // example : http://127.0.0.1:8888/api/v1/persons
    @GET
    public Collection<Person> getObjects()
    {
        return objects.values();
    }

    // example : http://127.0.0.1:8888/api/v1/persons/1
    @GET
    @Path("{id}")
    public Person getObject(@PathParam("id") String id)
    {
        return objects.get(id);
    }

    private HashMap<String, Person> objects;
}
