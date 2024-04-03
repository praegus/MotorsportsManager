package io.sdet.motorsportsmanager.controller;

import io.sdet.api.ApiApi;
import io.sdet.model.ChassisResponse;
import io.sdet.motorsportsmanager.models.Chassis;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@Log4j2
public class ChassisEndpoint implements ApiApi {

    @Override
    public ResponseEntity<List<ChassisResponse>> getChassis() {
        return ResponseEntity.ok().body(
                Arrays.stream(Chassis.values()).map(c -> {
            var response = new ChassisResponse();
            response.setColor(c.getColor());
            response.setName(c.getName());
            return response;
        }).toList()
        );
    }
}
