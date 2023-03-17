package com.rrlira96.codechallengelottery.controller;

import com.rrlira96.codechallengelottery.entities.DrawsReport;
import com.rrlira96.codechallengelottery.service.DrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(value = "/draws-report")
public class DrawController {

    @Autowired
    private DrawService drawService;

    @PostMapping
    public ResponseEntity<DrawsReport> generateDrawsReport(@RequestBody Set<Integer> userGuess) {
        drawService.validateUserGuess(userGuess);
        return ResponseEntity.ok().body(drawService.generateReport(userGuess));
    }
}
