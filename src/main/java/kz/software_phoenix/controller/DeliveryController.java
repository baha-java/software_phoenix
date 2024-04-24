package kz.software_phoenix.controller;

import kz.software_phoenix.model.dto.DeliveryCreateDto;
import kz.software_phoenix.model.dto.DeliveryViewDto;
import kz.software_phoenix.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/delivery")
public class DeliveryController {
    private final DeliveryService deliveryService;

    @GetMapping
    public ResponseEntity<List<DeliveryViewDto>> get(){
        return new ResponseEntity<>(deliveryService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody DeliveryCreateDto createDto){
        deliveryService.save(createDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
