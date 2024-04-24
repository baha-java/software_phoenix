package kz.software_phoenix.service;

import kz.software_phoenix.model.dto.DeliveryCreateDto;
import kz.software_phoenix.model.dto.DeliveryViewDto;
import kz.software_phoenix.model.entity.Delivery;
import kz.software_phoenix.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;

    public List<DeliveryViewDto> findAll() {
        List<DeliveryViewDto> deliveryViews = new ArrayList<>();
        for (Delivery delivery : deliveryRepository.findAll()) {
            DeliveryViewDto deliveryViewDto = new DeliveryViewDto();
            deliveryViewDto.setProductName(delivery.getProduct());
            deliveryViewDto.setAddress(delivery.getAddress());
            deliveryViewDto.setPhoneNumber(delivery.getPhoneNumber());
            deliveryViews.add(deliveryViewDto);
        }
        return deliveryViews;
    }


    @Transactional
    public void save(DeliveryCreateDto deliveryCreateDto) {
        Delivery delivery = Delivery.builder()
                .product(deliveryCreateDto.getProduct())
                .address(deliveryCreateDto.getAddress())
                .quantity(deliveryCreateDto.getQuantity())
                .phoneNumber(deliveryCreateDto.getPhoneNumber())
                .build();
        deliveryRepository.save(delivery);
    }
}
