package uz.upay.unistream.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientResponse {
    private List<Item> items;
    private int page;
    private int pageSize;
    private int totalCount;
}
