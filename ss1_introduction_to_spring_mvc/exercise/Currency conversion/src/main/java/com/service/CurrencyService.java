package com.service;

public class CurrencyService implements ICurrencyService {
    @Override
    public double usdToVnd(double usd) {
        return usd * 23000;
    }
}
