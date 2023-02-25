package mshantadze.solvd_laba_university.parsers.xml.jaxb.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date> {
	@Override
	public Date unmarshal(String date) throws Exception {
		return new SimpleDateFormat("mm-dd-yy").parse(date);
	}

	@Override
	public String marshal(Date date) throws Exception {
		// TODO Auto-generated method stub
		return new SimpleDateFormat("mm-dd-yy").format(date);
	}
}
