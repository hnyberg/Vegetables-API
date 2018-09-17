package com.hannesnyberg.vegetableAPI.Controller;

import com.hannesnyberg.vegetableAPI.Model.Vegetable;
import com.hannesnyberg.vegetableAPI.Model.VegetableDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class VegetableController {

    @Autowired
    private VegetableDAO vegetableDAO;

    @GetMapping("/vegetables")
    public List<Vegetable> getAllVegetables() {

        return vegetableDAO.findAll();
    }

    @GetMapping("/vegetables/{id}")
    public Vegetable getVegetable(@PathVariable long id){

        return vegetableDAO.findById(id).orElse(null);
    }

    @PostMapping("/vegetables")
    public Vegetable addNewVegetable(@RequestBody Vegetable inputVegetable) {
        Vegetable newVegetable = vegetableDAO.save(inputVegetable);

        return newVegetable;

    }

    @PutMapping("/vegetables/{id}")
    public ResponseEntity<Object> updateVegetable(@RequestBody Vegetable newVegetable, @PathVariable long id) {

        Optional<Vegetable> oldVegetable = vegetableDAO.findById(id);

        if (!oldVegetable.isPresent()){
            return ResponseEntity.notFound().build();
        }

        oldVegetable.get().setName(newVegetable.getName());
        oldVegetable.get().setPrice(newVegetable.getPrice());

        vegetableDAO.save(oldVegetable.get());

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/vegetables/{id}")
    public void deleteVegetable(@PathVariable long id){

        Optional<Vegetable> vegetable = vegetableDAO.findById(id);

        if (vegetable.isPresent()){
            vegetableDAO.deleteById(id);
        }
        else {

            throw new RuntimeException("Vegetable not found by id " + id){
                public String getMessage(){
                    return "Vegetable not found => none deleted";
                }
            };
        }

    }

}
