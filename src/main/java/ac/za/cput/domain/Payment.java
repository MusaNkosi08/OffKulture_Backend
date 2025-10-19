/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ac.za.cput.domain;

import java.time.LocalDateTime;

/**
 * Payment domain class implementing Builder pattern
 * @author Student
 */
public class Payment {
    public enum PaymentMethod {
        CARD,
        PAYPAL,
        EFT
    }

    public enum PaymentStatus {
        PENDING,
        COMPLETED,
        FAILED,
        REFUNDED
    }

    private final String id;
    private final PaymentMethod method;
    private final double amount;
    private final PaymentStatus status;
    private final LocalDateTime transactionDate;

    private Payment(Builder builder) {
        this.id = builder.id;
        this.method = builder.method;
        this.amount = builder.amount;
        this.status = builder.status;
        this.transactionDate = builder.transactionDate;
    }

    public String getId() {
        return id;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id='" + id + '\'' +
                ", method=" + method +
                ", amount=" + amount +
                ", status=" + status +
                ", transactionDate=" + transactionDate +
                '}';
    }

    public static class Builder {
        private String id;
        private PaymentMethod method;
        private double amount;
        private PaymentStatus status = PaymentStatus.PENDING; // Default status
        private LocalDateTime transactionDate;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setMethod(PaymentMethod method) {
            this.method = method;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setStatus(PaymentStatus status) {
            this.status = status;
            return this;
        }

        public Builder setTransactionDate(LocalDateTime transactionDate) {
            this.transactionDate = transactionDate;
            return this;
        }

        public Builder copy(Payment payment) {
            this.id = payment.id;
            this.method = payment.method;
            this.amount = payment.amount;
            this.status = payment.status;
            this.transactionDate = payment.transactionDate;
            return this;
        }

        public Payment build() {
            if (transactionDate == null) {
                transactionDate = LocalDateTime.now(); // Set current time if not specified
            }
            return new Payment(this);
        }
    }
}
