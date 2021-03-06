
package co.com.card;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import co.com.card.creditcardvalidation.CreditCard;
import co.com.card.creditcardvalidation.ObjectFactory;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ValidateCreditCard", targetNamespace = "http://card.com.co/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ValidateCreditCard {


    /**
     * 
     * @param creditCard
     * @return
     *     returns boolean
     * @throws CreditCardValidationFaultMessage
     */
    @WebMethod(operationName = "VerifyCC")
    @WebResult(name = "valid", targetNamespace = "http://card.com.co/CreditCardValidation", partName = "valid")
    public boolean verifyCC(
        @WebParam(name = "CreditCard", targetNamespace = "http://card.com.co/CreditCardValidation", partName = "CreditCard")
        CreditCard creditCard)
        throws CreditCardValidationFaultMessage
    ;

}
