package Lab2;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Prime")
public class Prime extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private List<PrimeList> primeListCollection = new ArrayList<PrimeList>();
	private int maxPrimeLists = 10;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int numPrimes = ServletUtilities.getIntParameter(request, "numPrimes", 10);
		int numDigits = ServletUtilities.getIntParameter(request, "numDigits", 10);
		PrimeList primeList = findPrimeList(primeListCollection, numPrimes, numDigits);

		if (primeList == null) {
			primeList = new PrimeList(numPrimes, numDigits, true);
			synchronized (primeListCollection) {
				if (primeListCollection.size() >= maxPrimeLists)
					primeListCollection.remove(0);
				primeListCollection.add(primeList);
			}
		}

		List<BigInteger> currentPrimes = primeList.getPrimes();
		int numCurrentPrimes = currentPrimes.size();
		int numPrimesRemaining = (numPrimes - numCurrentPrimes);
		boolean isLastResult = (numPrimesRemaining == 0);
		
		response.setIntHeader("Refresh", 3);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html> ");
		out.println("<html lang=\"en\"> ");
		out.println("	<head> ");
		out.println("		<title>Prime</title> ");
		out.println("		<meta charset=\"UTF-8\"> ");
		out.println("		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> ");
		out.println("		<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" ");
		out.println("		crossorigin=\"anonymous\"> ");
		out.println("	</head> ");
		out.println("	<body> ");
		out.println("		<div class=\"container\"> ");
		out.println("			<h3> Prime Numbers </h3>");
		out.println("			<h4>Find the first " + numPrimes + " Prime Number with " + numDigits + "-Digits</h4>");
		out.println("			<br>");
		if (isLastResult) {
			out.println("		<B>Done searching. Total Primes found: " + numCurrentPrimes + "</B> ");
			out.println("		<br>");
		} else {
			out.println("		<B>Still looking for " + numPrimesRemaining + " more<BLINK>...</BLINK></B>");
			out.println("		<br>");
		}
		out.println("			<table class=\"table table-bordered table-striped table-hover\">");
		out.println("				<thead>");
		out.println("					<tr>");
		out.println("						<th>Primes Count:</th>");
		out.println("						<th>Primes found:</th>");
		out.println("					</tr>");
		// out.println("					<tr>");
		// out.println("					</tr>");
		for (int i = 0; i < numCurrentPrimes; i++) {
			int c = i + 1;
			out.println("  				<tr> <td>" + c + "</td>" + "<td>" + currentPrimes.get(i) + "</td> </tr>");
		}
		out.println("				</thead>");
		out.println("			</table>");
		// out.println("			<p>");
		// out.println("			</p>");
		out.println("		</div> ");
		out.println("	</body> ");
		out.println("</html> ");

	}

	private PrimeList findPrimeList(List<PrimeList> primeListCollection, int numPrimes, int numDigits) {

		synchronized (primeListCollection) {
			for (int i = 0; i < primeListCollection.size(); i++) {
				PrimeList primes = (PrimeList) primeListCollection.get(i);
				if ((numPrimes == primes.getNumOfPrimes()) && (numDigits == primes.getNumOfDigits()))
					return (primes);
			}
			return (null);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
