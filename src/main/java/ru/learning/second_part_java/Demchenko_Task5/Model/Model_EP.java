package ru.learning.second_part_java.Demchenko_Task5.Model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


@Getter
@Setter
public class Model_EP {

        private Integer instanceId;
        private String productType;
        private String productCode;
        private String registerType;
        private String mdmCode;
        private String contractNumber;
        private Date contractDate;
        private Integer priority;
        private double interestRatePenalty;
        private double minimalBalance;
        private double thresholdAmount;
        private String accountingDetails;
        private String rateType;
        private double taxPercentageRate;
        private double technicalOverdraftLimitAmount;
        private Integer contractId;
        private String branchCode;
        private String isoCurrencyCode;
        private String urgencyCode;
        private Integer referenceCode;
        private HashMap<String, List<AdditionalPropertiesVip>> additionalPropertiesVIP;
        private List<InstanceAgreements> instanceAgreements;





}
