package com.javaweb.springmvc.Util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class DateUtil {

	
	public String getDate(Date date) {
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String strDate = formatter.format(date);
		 return strDate;
	}
	
//	public String getTime(Date date) {
//		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		 String strDate = formatter.format(date); 
//		 return strDate;
//	}
	public String getTimeLine(String dateStart) {
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
		 Date date=new Timestamp(System.currentTimeMillis());
		 String dateStop=formatter.format(date);
		 Date d1=null;
		 Date d2=null;
		

	            try {
					d1 = formatter.parse(dateStart);
					 d2 = formatter.parse(dateStop);
				} catch (java.text.ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	           

	       
		 long diff = d2.getTime() - d1.getTime();
		 long diffSeconds = diff / 1000;
	     long diffMinutes = diff / (60 * 1000);
	     long diffHours = diff / (60 * 60 * 1000);
	     long diffDays = diff / (24 * 60 * 60 * 1000);
	     long diffMonths = diff / (30 * 24 * 60 * 60 * 1000);
	     long diffYears = diff / (12 * 30 * 24 * 60 * 60 * 1000);
	     if(diffSeconds<=60) {
	    	 String kq=String.valueOf(diffSeconds);
	    	 String kqs=kq + " Giây trước";
	    	 return kqs;
	     }else if(diffMinutes<=60) {
	    	 String kq=String.valueOf(diffMinutes);
	    	 String kqs=kq + " Phút trước";
	    	 return kqs;
	     }else if(diffHours<=24) {
	    	 String kq=String.valueOf(diffHours);
	    	 String kqs=kq + " Giờ trước";
	    	 return kqs;
	     }else if(diffDays<=24){
	    	 String kq=String.valueOf(diffDays);
	    	 String kqs=kq+" Ngày trước";
	    	 return kqs;
		}
	     else if(diffMonths<=30){
	    	 String kq=String.valueOf(diffMonths);
	    	 String kqs=kq+" Tháng trước";
	    	 return kqs;
		}
	     else if(diffYears<=12){
	    	 String kq=String.valueOf(diffYears);
	    	 String kqs=kq+" Năm trước";
	    	 return kqs;
		}else {
			return "quá";
		}
		 
	}
}
