package com.mundipaggsandbox.model;

import java.io.Serializable;

/**
 * Created by guilherme on 27/10/16.
 */
public class Merchant implements Serializable{

    private Long id;
    private String merchantKey;
    private String publicMerchantKey;
    private String name;
    private String documentNumber;
    private String corporateName;
    private boolean isRetryEnabled;
    private boolean isAntiFraudEnabled;
    private boolean isDeleted;
    private boolean isEnabled;
    private String merchantStatus;


    public String getMerchantKey() {
        return merchantKey;
    }

    public void setMerchantKey(String merchantKey) {
        this.merchantKey = merchantKey;
    }

    public String getPublicMerchantKey() {
        return publicMerchantKey;
    }

    public void setPublicMerchantKey(String publicMerchantKey) {
        this.publicMerchantKey = publicMerchantKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String merchantName) {
        this.name = merchantName;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public boolean isRetryEnabled() {
        return isRetryEnabled;
    }

    public void setRetryEnabled(boolean isRetryEnabled) {
        this.isRetryEnabled = isRetryEnabled;
    }

    public boolean isAntiFraudEnabled() {
        return isAntiFraudEnabled;
    }

    public void setAntiFraudEnabled(boolean isAntiFraudEnabled) {
        this.isAntiFraudEnabled = isAntiFraudEnabled;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getMerchantStatus() {
        return merchantStatus;
    }

    public void setMerchantStatus(String merchantStatus) {
        this.merchantStatus = merchantStatus;
    }


    @Override
    public String toString() {
        return corporateName+" "+merchantStatus;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
