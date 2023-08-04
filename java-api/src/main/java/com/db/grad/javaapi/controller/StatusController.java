package com.db.grad.javaapi.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class StatusController {

      @GetMapping("/status")
      public String getWelcome() {
              return "API is up and running!";
      }
}
