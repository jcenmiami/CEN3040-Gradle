import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.whois.WhoisClient;

public class Whois {

	public static void main(String[] args) {

		WhoisClient whois;
		whois = new WhoisClient();
		// We want to timeout if a response takes longer than 60 seconds
		whois.setDefaultTimeout(60000);

		StringBuilder result = new StringBuilder("");
		String domainName = "usfsm.edu";
		try {
			// default is internic.net
			whois.connect(WhoisClient.DEFAULT_HOST);
			String whoisData1 = whois.query("=" + domainName);
			result.append(whoisData1);
			whois.disconnect();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(result.toString());

	}
}
