package ac.za.cput.factory;

import ac.za.cput.domain.Payment;
import ac.za.cput.domain.Payment.PaymentMethod;
import ac.za.cput.domain.Payment.PaymentStatus;
import java.time.LocalDateTime;

/**
 * Factory for creating Payment objects
 * @author Student
 */
public class PaymentFactory {
    public static Payment createPayment(String id, PaymentMethod method, double amount) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Payment ID is required");
        }
        if (method == null) {
            throw new IllegalArgumentException("Payment method is required");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }

        return new Payment.Builder()
                .setId(id)
                .setMethod(method)
                .setAmount(amount)
                .setStatus(PaymentStatus.PENDING) // Default status
                .setTransactionDate(LocalDateTime.now()) // Current timestamp
                .build();
    }

    public static Payment createPaymentWithStatus(String id, PaymentMethod method,
            double amount, PaymentStatus status, LocalDateTime transactionDate) {
        if (status == null) {
            throw new IllegalArgumentException("Payment status is required");
        }
        if (transactionDate == null) {
            throw new IllegalArgumentException("Transaction date is required");
        }

        return new Payment.Builder()
                .setId(id)
                .setMethod(method)
                .setAmount(amount)
                .setStatus(status)
                .setTransactionDate(transactionDate)
                .build();
    }
}
