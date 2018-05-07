package uz.upay.unistream.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientContext {
    private String clientId;

    private List<Document> documents;

    private String loyaltyCardNumber;

    private String smsConfirmationId;

}
