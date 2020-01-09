/*Question 
Email Checker:
takes in a list of email addresses and returns an integer indicating the number of unique email addresses.
Where "unique" email addresses means they will be delivered to the same account using Gmail account matching.
Specifically: Gmail will ignore the placement of "." in the username. And it will ignore any portion of the username after a "+".
Examples:
test.email@gmail.com, test.email+spam@gmail.com and testemail@gmail.com will all go to the same address, and thus the result should be 1.
 */


//Solution
package com.fetchrewards.main;

import java.util.HashSet;
import java.util.Set;

public class Execute {

	public static void main(String[] args) {
		String[] input = { "test.email+spam@gmail.com", "test.email@gmail.com", "testemail@gmail.com",
				"test.email++spam@gmail.com", "test2.email+@yahoo.com" };

		Execute execute = new Execute();

		System.out.println("Number of unique emails = " + execute.uniqueEmails(input));
	}

	public int uniqueEmails(String[] emails) {
		Set<String> uniqueEntries = new HashSet<>();
		StringBuilder validEmail;

		for (String email : emails) {
			validEmail = new StringBuilder();
			for (int i = 0; i < email.length(); i++) {
				char c = email.charAt(i);
				if (c == '.')
					continue;
				else if (c == '+' || c == '@') {
					while (email.charAt(i) != '@') {
						i++;
					}
					validEmail.append(email.substring(i));
					break;
				} else {
					validEmail.append(c);
				}
			}
			uniqueEntries.add(validEmail.toString());
		}
		return uniqueEntries.size();
	}

}
