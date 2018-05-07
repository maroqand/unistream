package uz.upay.unistream.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
    private String id;
    private String createTime;
    private String title;
    private String legend;
    private String status;
    private ClientContext clientContext;
    private String operationType;
}
