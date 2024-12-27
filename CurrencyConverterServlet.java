import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import org.json.JSONObject;

public class CurrencyConverterServlet extends HttpServlet {

    // Simulating currency conversion rates (in reality, this would be fetched from an API)
    private static final double USD_TO_EUR = 0.93;
    private static final double USD_TO_INR = 83.22;
    private static final double USD_TO_GBP = 0.76;
    private static final double EUR_TO_USD = 1.08;
    private static final double EUR_TO_INR = 89.57;
    private static final double EUR_TO_GBP = 0.82;
    private static final double INR_TO_USD = 0.012;
    private static final double INR_TO_EUR = 0.011;
    private static final double INR_TO_GBP = 0.0091;
    private static final double GBP_TO_USD = 1.32;
    private static final double GBP_TO_EUR = 1.22;
    private static final double GBP_TO_INR = 109.67;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String amountStr = request.getParameter("amount");
        String fromCurrency = request.getParameter("from");
        String toCurrency = request.getParameter("to");

        double amount = Double.parseDouble(amountStr);
        double convertedAmount = 0.0;
        boolean success = true;

        if (fromCurrency.equals("USD") && toCurrency.equals("EUR")) {
            convertedAmount = amount * USD_TO_EUR;
        } else if (fromCurrency.equals("USD") && toCurrency.equals("INR")) {
            convertedAmount = amount * USD_TO_INR;
        } else if (fromCurrency.equals("USD") && toCurrency.equals("GBP")) {
            convertedAmount = amount * USD_TO_GBP;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("USD")) {
            convertedAmount = amount * EUR_TO_USD;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("INR")) {
            convertedAmount = amount * EUR_TO_INR;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("GBP")) {
            convertedAmount = amount * EUR_TO_GBP;
        } else if (fromCurrency.equals("INR") && toCurrency.equals("USD")) {
            convertedAmount = amount * INR_TO_USD;
        } else if (fromCurrency.equals("INR") && toCurrency.equals("EUR")) {
            convertedAmount = amount * INR_TO_EUR;
        } else if (fromCurrency.equals("INR") && toCurrency.equals("GBP")) {
            convertedAmount = amount * INR_TO_GBP;
        } else if (fromCurrency.equals("GBP") && toCurrency.equals("USD")) {
            convertedAmount = amount * GBP_TO_USD;
        } else if (fromCurrency.equals("GBP") && toCurrency.equals("EUR")) {
            convertedAmount = amount * GBP_TO_EUR;
        } else if (fromCurrency.equals("GBP") && toCurrency.equals("INR")) {
            convertedAmount = amount * GBP_TO_INR;
        } else {
            success = false;
        }

        JSONObject jsonResponse = new JSONObject();
        if (success) {
            jsonResponse.put("success", true);
            jsonResponse.put("convertedAmount", convertedAmount);
        } else {
            jsonResponse.put("success", false);
        }

        response.setContentType("application/json");
        response.getWriter().write(jsonResponse.toString());
    }
}
