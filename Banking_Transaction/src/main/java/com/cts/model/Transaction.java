package com.cts.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor 
@Entity
@Table(name = "transaction_details")
@ApiModel(description = "Details About the Transactions")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"transactAt"}, 
        allowGetters = true)
public class Transaction {
	public Transaction(long l, double d) {
		// TODO Auto-generated constructor stub
	}

	@ApiModelProperty(notes = "The Transaction's ID which is Unique")
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@ApiModelProperty(notes = "The Transaction's Amount")
    private Double amount;

	@ApiModelProperty(notes = "The Transaction's TimeStamp")
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date transactAt;
	@Column(nullable = false)
	private String pan;
	private String fundname;

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Double getAmount() {
//		return amount;
//	}
//
//	public void setAmount(Double amount) {
//		this.amount = amount;
//	}
//
//	public Date getTransactAt() {
//		return transactAt;
//	}
//
//	public void setTransactAt(Date transactAt) {
//		this.transactAt = transactAt;
//	}
//
//	@Override
//	public String toString() {
//		return "Transaction [id=" + id + ", amount=" + amount + ", transactAt=" + transactAt + "]";
//	}
//
//	public Transaction(Long id, Double amount, Date transactAt) {
//		super();
//		this.id = id;
//		this.amount = amount;
//		this.transactAt = transactAt;
//	}
//
//	public Transaction() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

	
    

}
