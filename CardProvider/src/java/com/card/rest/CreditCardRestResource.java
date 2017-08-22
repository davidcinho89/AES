/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.card.rest;

import co.com.card.creditcardvalidation.CreditCard;
import com.card.entity.Cards;
import com.card.service.CreditCardResponse;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author DELL
 */
@Path("CreditCardRest")
public class CreditCardRestResource {

    @Context
    private UriInfo context;

    @PersistenceContext(unitName = "CardProviderPU")
    private EntityManager em;
    /**
     * Creates a new instance of CreditCardRestResource
     */
    public CreditCardRestResource() {
    }


    /**
     * PUT method for updating or creating an instance of CreditCardRestResource
     * @param content representation for the resource
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_XML})
    public Response verifyCC(CreditCard content) {
        CreditCardResponse result = new CreditCardResponse();
        try {
            Cards cr = (Cards) em.createNamedQuery("Cards.findByTipoAndNumber")
                .setParameter("number", content.getCcNum())
                .setParameter("tipo", content.getCcType()).getSingleResult();
        
            System.out.println("Resultado: "+cr.getIdcard()); 
            result.setValid(true);
            return Response.status(200).entity(result).build();
        } catch (NoResultException e) {            
            System.out.println("Sin resultados");
            result.setValid(false);
            return Response.status(200).entity(result).build();
        }               
        
    }
}
