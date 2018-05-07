package uz.upay.unistream.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * A client's data
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Client {

    /**
     * Unique identificator of the client
     */
    private String Id;

    private String FirstName;

    private String LastName;

    private String MiddleName;

    private String Gender;

    private String BirthDate;

    private String BirthPlace;

    private String CountryOfResidence;

    private Address Address;

    private String PhoneNumber;

    private Object KazId;

    private Object LoyaltyCardNumber;

    private String TaxpayerIndividualIdentificationNumber;
}
