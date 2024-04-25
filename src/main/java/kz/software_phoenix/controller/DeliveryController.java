package kz.software_phoenix.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Delivery", description = "The Delivery API. Contains all the operations that can be performed on a delivery.")
@RequestMapping("/api/v1/delivery")
public class DeliveryController {
    private final DeliveryService deliveryService;

    @Operation(summary = "Get list of delivery", description = "Get list of delivery. The operation returns a detailed list of deliveries")
    @GetMapping
    public ResponseEntity<List<DeliveryViewDto>> get(){
        return new ResponseEntity<>(deliveryService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Add delivery", description = "Add delivery. The operation add delivery")
    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody DeliveryCreateDto createDto){
        deliveryService.save(createDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
