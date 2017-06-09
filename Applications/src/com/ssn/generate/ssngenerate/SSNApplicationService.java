package com.ssn.generate.ssngenerate;

import java.util.Random;

public class SSNApplicationService {

	public void generateSSN(SSNApplicationForm a) {

		SSNApplicationDAO ssndao = new SSNApplicationDAO();
		if (a.getPassportnumber().equals("N1155878")) {

			Random r = new Random();
			long ssn = r.nextInt(900000000) + 100000000;
			String ssn1 = Long.toString(ssn);
			String group1 = ssn1.substring(0, 3);
			String group2 = ssn1.substring(3, 5);
			String group3 = ssn1.substring(5, 9);
			String ssnnumber = group1 + "-" + group2 + "-" + group3;
			ssndao.displaySSN(ssnnumber);
		} else {
			System.out.println("invalid passportnumber");
		}

	}

}
