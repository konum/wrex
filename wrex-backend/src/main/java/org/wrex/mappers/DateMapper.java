package org.wrex.mappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DateMapper {

    public String asString(Date date) {
        return date != null ? new SimpleDateFormat( "yyyy-MM-dd" )
            .format( date ) : null;
    }

    public Date asDate(String date) {
        try {
        	Date ret = date != null ? new SimpleDateFormat( "yyyy-MM-dd" ).parse( date ) : null;
        	if (ret != null)
        		ret.setHours(14);
            return ret;
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
    }
    
    @Test
    public void test() {
    	String date = "2018-10-01";
    	System.out.print(asDate(date));
    }
}