package fr.rt.MyPrintAuth.controllers;

import fr.rt.MyPrintAuth.entities.Status;
import fr.rt.MyPrintAuth.services.StatusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusController {

    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @PostMapping("")
    public ResponseEntity<Status> addStatus(@RequestBody Status status){


        return ResponseEntity.ok(statusService.addStatus(status));
    }
}
