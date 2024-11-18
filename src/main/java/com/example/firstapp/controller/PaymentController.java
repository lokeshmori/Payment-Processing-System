package com.example.firstapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstapp.pojo.Payment;
import com.example.firstapp.pojo.PaymentRequest;

@RestController
@RequestMapping("/v1/payments")
public class PaymentController {
	private final Map<Long, Payment> paymentMap = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong();

    // 1. POST /v1/payments
    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody PaymentRequest request) {
        long id = idCounter.incrementAndGet();
        Payment payment = new Payment(id, request.getAmount(), request.getCurrency());
        paymentMap.put(id, payment);
        return ResponseEntity.status(HttpStatus.CREATED).body(payment);
    }
    
    // 2. GET /v1/payments/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long id) {
        Payment payment = paymentMap.get(id);
        if (payment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(payment);
    }
    
 // 3. PUT /v1/payments/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody PaymentRequest request) {
        Payment payment = paymentMap.get(id);
        if (payment == null) {
            return ResponseEntity.notFound().build();
        }
        payment.setAmount(request.getAmount());
        payment.setCurrency(request.getCurrency());
        return ResponseEntity.ok(payment);
    }

    // 4. PATCH /v1/payments/{id}
    @PatchMapping("/{id}")
    public ResponseEntity<Payment> partialUpdatePayment(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        Payment payment = paymentMap.get(id);
        if (payment == null) {
            return ResponseEntity.notFound().build();
        }
        if (updates.containsKey("amount")) {
            payment.setAmount((Double) updates.get("amount"));
        }
        if (updates.containsKey("currency")) {
            payment.setCurrency((String) updates.get("currency"));
        }
        return ResponseEntity.ok(payment);
    }
    
    // 5. DELETE /v1/payments/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        Payment removedPayment = paymentMap.remove(id);
        if (removedPayment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    // 6. GET /v1/payments
    @GetMapping
    public ResponseEntity<List<Payment>> listPayments() {
        return ResponseEntity.ok(new ArrayList<>(paymentMap.values()));
    }

    // 7. POST /v1/payments/{id}/repeat
    @PostMapping("/{id}/repeat")
    public ResponseEntity<Payment> repeatPayment(@PathVariable Long id) {
        Payment existingPayment = paymentMap.get(id);
        if (existingPayment == null) {
            return ResponseEntity.notFound().build();
        }
        long newId = idCounter.incrementAndGet();
        Payment newPayment = new Payment(newId, existingPayment.getAmount(), existingPayment.getCurrency());
        paymentMap.put(newId, newPayment);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPayment);
    }
}
