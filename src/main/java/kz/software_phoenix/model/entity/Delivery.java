package kz.software_phoenix.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "delivers")
public class Delivery extends BaseEntity {

    @Column(name = "product")
    private String product;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    public Delivery() {
    }
}
