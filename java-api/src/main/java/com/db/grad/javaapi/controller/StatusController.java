package com.db.grad.javaapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

      @GetMapping("/status")
      public String getWelcome() {
              return "API is up and running!";
      }
}
