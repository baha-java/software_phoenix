package kz.software_phoenix.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryCreateDto {

    @NotBlank
    private String product;
    @NotBlank
    private Integer quantity;
    @NotBlank
    private String address;
    @NotBlank
    @Size(min = 12, max = 12)
    private String phoneNumber;
}
