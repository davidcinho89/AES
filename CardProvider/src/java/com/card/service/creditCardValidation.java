/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.card.service;

import co.com.card.CreditCardValidationFaultMessage;
import com.card.entity.Cards;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author DELL
 */
@WebService(serviceName = "ValidateCreditCardService", portName = "ValidateCreditCardPort", endpointInterface = "co.com.card.ValidateCreditCard", targetNamespace = "http://card.com.co/", wsdlLocation = "WEB-INF/wsdl/creditCardValidation/CreditCardValidationWrapper.wsdl")
public class creditCardValidation {
    
    @PersistenceContext(unitName = "CardProviderPU")
    private EntityManager em;

    public boolean verifyCC(co.com.card.creditcardvalidation.CreditCard creditCard) throws CreditCardValidationFaultMessage {        
        try {
            Cards cr = (Cards) em.createNamedQuery("Cards.findByTipoAndNumber")
                .setParameter("number", creditCard.getCcNum())
                .setParameter("tipo", creditCard.getCcType()).getSingleResult();
        
            System.out.println("Resultado: "+cr.getIdcard());             
            return true;
        } catch (NoResultException e) {            
            System.out.println("Sin resultados");            
            return false;
        }  
    }
    
}
