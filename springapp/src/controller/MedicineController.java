package com.example.springapp.controller;

import com.example.springapp.model.Medicine;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/medicines")
public class MedicineController {

    private final List<Medicine> medicineList = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Boolean> addMedicine(@RequestBody Medicine medicine) {
        boolean result = medicineList.add(medicine);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{medicineId}")
    public ResponseEntity<Medicine> updateMedicine(
            @PathVariable int medicineId,
            @RequestBody Medicine updatedMedicine) {
        for (int i = 0; i < medicineList.size(); i++) {
            Medicine existingMedicine = medicineList.get(i);
            if (existingMedicine.getMedicineId() == medicineId) {
                // Update the fields of existing medicine
                existingMedicine.setMedicineName(updatedMedicine.getMedicineName());
                existingMedicine.setPrice(updatedMedicine.getPrice());
                existingMedicine.setQuantity(updatedMedicine.getQuantity());
                existingMedicine.setDescription(updatedMedicine.getDescription());
                return ResponseEntity.ok(existingMedicine);
            }
        }
        return ResponseEntity.notFound().build();
    }
}
