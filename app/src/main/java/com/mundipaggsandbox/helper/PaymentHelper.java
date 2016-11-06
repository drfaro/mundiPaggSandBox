package com.mundipaggsandbox.helper;

import android.app.Activity;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.mundi.R;
import com.mundipaggsandbox.model.Payment;

/**
 * Created by guilherme on 28/10/16.
 */
public class PaymentHelper {

    private EditText paymentUserName;
    private EditText paymentUserEmail;
    private EditText paymentCreditCard;
    private EditText paymentCreditHolder;
    private EditText paymentCents;
    private EditText paymentCardMonth;
    private EditText paymentCardYear;
    private EditText paymentCardSecurity;
    private EditText paymentCardInstallment;
    private Payment payment;
    private RadioGroup paymentCardBrand;
    private String validateMessage;

    public PaymentHelper(Activity activity) {

        paymentUserName = (EditText) activity.findViewById(R.id.payment_user_name);
        paymentUserEmail = (EditText) activity.findViewById(R.id.payment_user_email);
        paymentCreditCard = (EditText) activity.findViewById(R.id.payment_credit_card);
        paymentCreditHolder = (EditText) activity.findViewById(R.id.payment_credit_holder);
        paymentCents = (EditText) activity.findViewById(R.id.payment_cents);
        paymentCardMonth = (EditText) activity.findViewById(R.id.payment_card_month);
        paymentCardYear = (EditText) activity.findViewById(R.id.payment_card_year);
        paymentCardSecurity = (EditText) activity.findViewById(R.id.payment_card_security);
        paymentCardInstallment = (EditText) activity.findViewById(R.id.payment_card_installment);
        paymentCardBrand = (RadioGroup) activity.findViewById(R.id.payment_card_brand);

        payment = new Payment();

    }

    public Payment getPayment() {

        int checkedRadioButtonId = paymentCardBrand.getCheckedRadioButtonId();
        RadioButton paymentCardBrandChecked = (RadioButton) paymentCardBrand.findViewById(checkedRadioButtonId);

        payment.setCreditCardBrand(paymentCardBrandChecked.getText().toString());

        payment.setName(paymentUserName.getText().toString());
        payment.setEmail(paymentUserEmail.getText().toString());
        payment.setCreditCardNumber(paymentCreditCard.getText().toString());
        payment.setCreditCardHolderName(paymentCreditHolder.getText().toString());
        payment.setAmountInCents(paymentCents.getText().toString().replace(",", "").replace(".", ""));
        payment.setExpMonth(paymentCardMonth.getText().toString());
        payment.setExpYear(paymentCardYear.getText().toString());
        payment.setSecurityCode(paymentCardSecurity.getText().toString());
        payment.setInstallmentCount(Integer.parseInt(paymentCardInstallment.getText().toString()));

        return payment;
    }

    public boolean isValidate(){


        if (paymentUserName.getText().toString().isEmpty() ){
            validateMessage = "Preencha o nome.";
            return false;
        }
        else if (paymentUserEmail.getText().toString().isEmpty() ){
            validateMessage = "Preencha o email.";
            return false;
        }
        else if (!isEmailValid(paymentUserEmail.getText().toString())) {
            validateMessage = "Email invalido";
            return false;
        }

        else if (paymentCreditCard.getText().toString().isEmpty()  ){
            validateMessage = "Preencha o numero do cartao.";
            return false;
        }

        else if (paymentCreditCard.getText().toString().length() != 16 ){
            validateMessage = "Numero do cartao invalido.";
            return false;
        }

        else if (paymentCreditHolder.getText().toString().isEmpty() ){
            validateMessage = "Preencha o nome impresso no cartao";
            return false;
        }
        else if (paymentCents.getText().toString().isEmpty() ){
            validateMessage = "Preencha o valor da transação";
            return false;
        }
        else if (paymentCardMonth.getText().toString().isEmpty() ){
            validateMessage = "Preencha o mes da validade do catao";
            return false;
        }
        else if (Integer.valueOf(paymentCardMonth.getText().toString()) < 1 || Integer.valueOf(paymentCardMonth.getText().toString()) > 12 ){
            validateMessage = "Preencha o mes de validade corretamete";
            return false;
        }
        else if (paymentCardYear.getText().toString().isEmpty() ){
            validateMessage = "Preencha o ano da validade do catao";
            return false;
        }
        else if (Integer.valueOf(paymentCardYear.getText().toString()) < 16  || Integer.valueOf(paymentCardYear.getText().toString()) > 22  ){
            validateMessage = "Preencha o ano de validade corretamente";
            return false;
        }
        else if (paymentCardSecurity.getText().toString().isEmpty() ){
            validateMessage = "Preencha o codigo de seguranca do cartao";
            return false;
        }
        else if (paymentCardInstallment.getText().toString().isEmpty() ){
            validateMessage = "Preencha o numero de parcelas da compra";
            return false;
        }
        else if (Integer.valueOf(paymentCardInstallment.getText().toString()) > 12){
            validateMessage = "O numero maximo de parcelas é 12";
            return false;
        }
        else {
            return true;
        }

    }

    private boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public String getValidateMessage() {
        return validateMessage;
    }
}
