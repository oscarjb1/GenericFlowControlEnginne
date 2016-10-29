package com.pr.gfce.exchange.fixer;

/**
 * @author Oscar Blancarte
 */
import java.util.Map;

public class FixerResponse {

    private String base;
    private String date;
    private Map<String,String> rates;

    /**
     *
     * @return The base
     */
    public String getBase() {
        return base;
    }

    /**
     *
     * @param base The base
     */
    public void setBase(String base) {
        this.base = base;
    }

    /**
     *
     * @return The date
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    public Map<String, String> getRates() {
        return rates;
    }

    public void setRates(Map<String, String> rates) {
        this.rates = rates;
    }

}
