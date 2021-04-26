package com.test.code.common;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class ConstantCommon {
    
    public static String formatCurrencyIndonesia(int nominal) {
		DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
		DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
		formatRp.setCurrencySymbol("Rp. ");
		formatRp.setMonetaryDecimalSeparator(',');
		formatRp.setGroupingSeparator('.');
		kursIndonesia.setDecimalFormatSymbols(formatRp);
		return kursIndonesia.format(nominal);
	}
}