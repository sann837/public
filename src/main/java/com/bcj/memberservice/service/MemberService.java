package com.bcj.memberservice.service;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import com.bcj.memberservice.model.Member;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MemberService {

	public Member saveCustomer(Member member) {

		try {

			Client client = Client.create();

			WebResource webResource = client.resource("http://localhost:8280/services/EkthaSolServices/post");

			ObjectMapper mapper = new ObjectMapper();
			ClientResponse response = webResource.type(MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class,
					mapper.writeValueAsString(member));

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			System.out.println("Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);

			return member;

		} catch (IOException e) {

			e.printStackTrace();
			return member;
		}

	}
}
