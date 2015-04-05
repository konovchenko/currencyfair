package com.currencyfair.model;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Anton Konovchenko
 * @version 1.0.0
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "message", schema = "", catalog = "currencyfair")
public class MessageEntity {
    @XmlTransient
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private Long id;

    @XmlElement
    @Basic
    @Column(name = "userId", nullable = true, insertable = true, updatable = true)
    private Long userId;

    @XmlElement
    @Basic
    @Column(name = "currencyFrom", nullable = true, insertable = true, updatable = true, length = 5)
    private String currencyFrom;

    @XmlElement
    @Basic
    @Column(name = "currencyTo", nullable = true, insertable = true, updatable = true, length = 5)
    private String currencyTo;

    @XmlElement
    @Basic
    @Column(name = "amountSell")
    private BigDecimal amountSell;

    @XmlElement
    @Basic
    @Column(name = "amountBuy")
    private BigDecimal amountBuy;

    @XmlElement
    @Basic
    @Column(name = "rate")
    private BigDecimal rate;

    @XmlElement
    @XmlJavaTypeAdapter(value = DateAdapter.class)
    @Basic
    @Column(name = "timePlaced", nullable = false, insertable = true, updatable = true)
    private Date timePlaced;

    @XmlElement
    @Basic
    @Column(name = "originatingCountry", nullable = true, insertable = true, updatable = true, length = 5)
    private String originatingCountry;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
    }

    public BigDecimal getAmountSell() {
        return amountSell;
    }

    public void setAmountSell(BigDecimal amountSell) {
        this.amountSell = amountSell;
    }

    public BigDecimal getAmountBuy() {
        return amountBuy;
    }

    public void setAmountBuy(BigDecimal amountBuy) {
        this.amountBuy = amountBuy;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Date getTimePlaced() {
        return timePlaced;
    }

    public void setTimePlaced(Date timePlaced) {
        this.timePlaced = timePlaced;
    }

    public String getOriginatingCountry() {
        return originatingCountry;
    }

    public void setOriginatingCountry(String originatingCountry) {
        this.originatingCountry = originatingCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageEntity that = (MessageEntity) o;

        if (amountBuy != null ? !amountBuy.equals(that.amountBuy) : that.amountBuy != null) return false;
        if (amountSell != null ? !amountSell.equals(that.amountSell) : that.amountSell != null) return false;
        if (currencyFrom != null ? !currencyFrom.equals(that.currencyFrom) : that.currencyFrom != null) return false;
        if (currencyTo != null ? !currencyTo.equals(that.currencyTo) : that.currencyTo != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (originatingCountry != null ? !originatingCountry.equals(that.originatingCountry) : that.originatingCountry != null)
            return false;
        if (rate != null ? !rate.equals(that.rate) : that.rate != null) return false;
        if (timePlaced != null ? !timePlaced.equals(that.timePlaced) : that.timePlaced != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (currencyFrom != null ? currencyFrom.hashCode() : 0);
        result = 31 * result + (currencyTo != null ? currencyTo.hashCode() : 0);
        result = 31 * result + (amountSell != null ? amountSell.hashCode() : 0);
        result = 31 * result + (amountBuy != null ? amountBuy.hashCode() : 0);
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        result = 31 * result + (timePlaced != null ? timePlaced.hashCode() : 0);
        result = 31 * result + (originatingCountry != null ? originatingCountry.hashCode() : 0);
        return result;
    }
}
