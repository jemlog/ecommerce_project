package project.finaltoyproject.policy;

public class CreditCardPaymentPolicy implements PaymentPolicy{


    @Override
    public int payment(String creditCard) {
        return 0;
    }
}
