package ru.learning.second_part_java.Demchenko_Task5.Model;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InstanceAgreements {

    private String GeneralAgreementId;
    private String supplementaryAgreementId;
    private String arrangementType;
    private Integer shedulerJobId;
    private String number;
    private Date openingDate;
    private Date closingDate;
    private Date cancelDate;
    private Integer validityDuration;
    private String cancellationReason;
    private String status;
    private Date interestCalculationDate;
    private double interestRate;
    private double coefficient;
    private String coefficientAction;
    private double minimumInterestRate;
    private String minimumInterestRateCoefficient;
    private String minimumInterestRateCoefficientAction;
    private double maximalInterestRate;
    private double maximalInterestRateCoefficient;
    private String maximalInterestRateCoefficientAction;

}
