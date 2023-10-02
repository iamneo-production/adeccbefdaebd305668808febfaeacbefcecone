package com.example.model; // Replace com.yourpackage with your actual package name

import java.util.Objects;

public class Medicine {
    private int medicineId;
    private String medicineName;
    private float price;
    private int quantity;
    private String description;

    // Constructors, Getters, and Setters (as shown in the previous response)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return medicineId == medicine.medicineId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicineId);
    }
}
