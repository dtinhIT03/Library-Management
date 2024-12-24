package com.dangtinh.library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblreturn_slip")
public class ReturnSlip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "return_slip_id", nullable = false)
    private int returnSlipId;

    @Column(name = "return_slip_date")
    @Temporal(TemporalType.DATE)
    private Date returnSlipDate;

    @Column(name = "return_slip_refund", precision = 10, scale = 2)
    private BigDecimal returnSlipRefund;

    @Column(name = "return_slip_late_fee", precision = 10, scale = 2)
    private BigDecimal returnSlipLateFee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
}