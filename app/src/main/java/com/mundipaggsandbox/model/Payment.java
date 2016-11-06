package com.mundipaggsandbox.model;

/**
 * Created by guilherme on 27/10/16.
 */
public class Payment {

    private String name;
    private String email;
    private String creditCardNumber;
    private String creditCardHolderName;
    private String amountInCents;
    private String creditCardBrand;
    private String expMonth;
    private String expYear;
    private String securityCode;
    private Integer installmentCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardHolderName() {
        return creditCardHolderName;
    }

    public void setCreditCardHolderName(String creditCardHolderName) {
        this.creditCardHolderName = creditCardHolderName;
    }

    public String getAmountInCents() {
        return amountInCents;
    }

    public void setAmountInCents(String amountInCents) {
        this.amountInCents = amountInCents;
    }

    public String getCreditCardBrand() {
        return creditCardBrand;
    }

    public void setCreditCardBrand(String creditCardBrand) {
        this.creditCardBrand = creditCardBrand;
    }

    public String getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(String expMonth) {
        this.expMonth = expMonth;
    }

    public String getExpYear() {
        return expYear;
    }

    public void setExpYear(String expYear) {
        this.expYear = expYear;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public Integer getInstallmentCount() {
        return installmentCount;
    }

    public void setInstallmentCount(Integer installmentCount) {
        this.installmentCount = installmentCount;
    }
}
