package kz.software_phoenix.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryViewDto {
    private String productName;
    private String address;
    private String phoneNumber;
}