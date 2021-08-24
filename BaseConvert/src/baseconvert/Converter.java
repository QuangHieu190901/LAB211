package baseconvert;

import java.math.BigInteger;

public class Converter {
    
    public BigInteger convertBinToDec(String bin){
        BigInteger result = new BigInteger("0");
        BigInteger base = new BigInteger("1");
        //iterate over the binary number
        for (int i = bin.length() - 1; i >= 0; i--) {
            result = result.add(base.multiply(new BigInteger(String.valueOf(bin.charAt(i)), 2)));
            base = base.multiply(new BigInteger("2"));           
        }
        return result;
//        return new BigInteger(bin, 2);
    }
    
    public String convertDecToBin(BigInteger dec){
        StringBuilder sb = new StringBuilder();
        //divide dec by 2 until dec = 0
        while (dec.compareTo(new BigInteger("0")) == 1) {            
            sb.append(dec.remainder(new BigInteger("2")).toString(2));
            dec = dec.divide(new BigInteger("2"));
        }
//        return dec.toString(2);
        return sb.reverse().toString();
    }
    
    
    public BigInteger convertHexToDec(String hex){
        BigInteger result = new BigInteger("0");
        BigInteger base = new BigInteger("1");
        //iterate over the hexa number
        for (int i = hex.length() - 1; i >= 0; i--) {
            result = result.add(base.multiply(new BigInteger(String.valueOf(hex.charAt(i)), 16)));
            base = base.multiply(new BigInteger("16"));           
        }
        return result;        
//        return new BigInteger(hex, 16);
    }
    
    public String convertDecToHex(BigInteger dec){
        StringBuilder sb = new StringBuilder();
        //divide dec by 16 until dec = 0
        while (dec.compareTo(new BigInteger("0")) == 1) {
            sb.append(dec.remainder(new BigInteger("16")).toString(16).toUpperCase());
            dec = dec.divide(new BigInteger("16"));
        }
//        return dec.toString(16).toUpperCase();
        return sb.reverse().toString();
    }

}
