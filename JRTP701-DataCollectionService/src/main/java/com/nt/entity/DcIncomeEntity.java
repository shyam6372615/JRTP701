package com.nt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="JRTP_DC_INCOME")
@Data
public class DcIncomeEntity {
   @Id
   @GeneratedValue(strategy =GenerationType.AUTO)
   private Integer incomeId;
   private Integer caseNumber;
   private Double empIncome;
   private Double propertyIncome;
}
