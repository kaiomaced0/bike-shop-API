package br.glacks.service;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import br.glacks.model.bike.Bike;

public interface BikeService {
    
    public List<Bike> getAll();

    public Bike getId(@PathParam("id") long id);

    public Response insert(Bike bike);

    public Bike update(@PathParam("id") long id, Bike bike);
    
    public Response delete(@PathParam("id") Long id);
}
