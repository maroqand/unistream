
package uz.upay.unistream.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

    private String AddressString;

    private String Apartment;

    private String Building;

    private String City;

    private String CountryCode;

    private String House;

    private String Postcode;

    private String State;

    private String Street;
}
