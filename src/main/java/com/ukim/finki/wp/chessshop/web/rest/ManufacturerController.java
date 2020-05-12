package com.ukim.finki.wp.chessshop.web.rest;

import com.ukim.finki.wp.chessshop.model.Manufacturer;
import com.ukim.finki.wp.chessshop.service.ManufacturerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/manufacturers")
@CrossOrigin(origins="http://localhost:3000")
public class ManufacturerController {
    private final ManufacturerService manufacturerService;

    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public List<Manufacturer> findAll(){
        return this.manufacturerService.findAll();
    }

    @GetMapping("/{id}")
    public Manufacturer findById(@PathVariable  Long id){
        return this.manufacturerService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Manufacturer save(@RequestBody @Valid Manufacturer manufacturer){
        return this.manufacturerService.save(manufacturer);
    }

    /*@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Manufacturer save(@RequestParam String name, @RequestParam String address){
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName(name);
        manufacturer.setAddress(address);
        return this.manufacturerService.save(manufacturer);
    }*/

    @PutMapping("/{id}") // ili @PutMapping? -> patch vo av
    public Manufacturer update(@PathVariable Long id, @RequestBody @Valid Manufacturer manufacturer){
        return this.manufacturerService.update(id,manufacturer);
    }

    @DeleteMapping("/{id}")
    public Integer deleteById(@PathVariable Long id){
        return this.manufacturerService.deleteById(id);
    }
}
