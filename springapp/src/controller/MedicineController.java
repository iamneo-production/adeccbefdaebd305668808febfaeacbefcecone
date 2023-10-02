package com.example.controller; // Replace com.yourpackage with your actual package name

import com.example.model.Medicine;
import com.example.service.PharmacyService; // Import your service class

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicines")
public class MedicineController {
    @Autowired
    private PharmacyService pharmacyService; // Inject your service class here

    @PostMapping
    public ResponseEntity<Boolean> addMedicine(@RequestBody Medicine medicine) {
        boolean result = pharmacyService.addMedicine(medicine);
        return ResponseEntity.ok(result);
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

    // Add more endpoints as needed
}
