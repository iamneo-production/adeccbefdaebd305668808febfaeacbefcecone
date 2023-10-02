package com.example.springapp.controller;

import com.example.springapp.model.Medicine;
import com.example.springapp.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicines")
public class MedicineController {

    @Autowired
    private PharmacyService pharmacyService;

    @PostMapping
    public ResponseEntity<Boolean> addMedicine(@RequestBody Medicine medicine) {
        boolean result = pharmacyService.addMedicine(medicine);
        if (result) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.badRequest().body(false);
        }
    }

    @PutMapping("/{medicineId}")
    public ResponseEntity<Medicine> updateMedicine(
            @PathVariable int medicineId,
            @RequestBody Medicine updatedMedicine) {
        Medicine updated = pharmacyService.updateMedicine(medicineId, updatedMedicine);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
