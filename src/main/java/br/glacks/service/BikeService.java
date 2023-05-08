package br.glacks.service;
import java.util.List;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import br.glacks.model.bike.Bike;

public interface BikeService {
    
    public List<Bike> getAll();

    public Bike getId(@PathParam("id") long id);

    public List<Bike> getNome(@PathParam("nome") String nome);

    public Response insert(Bike bike);

    public Bike update(@PathParam("id") long id, Bike bike);
    
    public Response delete(@PathParam("id") Long id);
}
