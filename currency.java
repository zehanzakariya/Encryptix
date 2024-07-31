import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Available currencies (Mock data)
        Map<String, Double> exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);  // Base currency is USD
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.75);
        exchangeRates.put("INR", 74.0);
        exchangeRates.put("JPY", 110.0);

        // Currency symbols
        Map<String, String> currencySymbols = new HashMap<>();
        currencySymbols.put("USD", "$");
        currencySymbols.put("EUR", "€");
        currencySymbols.put("GBP", "£");
        currencySymbols.put("INR", "₹");
        currencySymbols.put("JPY", "¥");

        // Input base currency
        System.out.println("Available currencies: USD, EUR, GBP, INR, JPY");
        System.out.print("Enter base currency: ");
        String baseCurrency = sc.next().toUpperCase();

        // Input target currency
        System.out.print("Enter target currency: ");
        String targetCurrency = sc.next().toUpperCase();

        // Validate input currencies
        if (!exchangeRates.containsKey(baseCurrency) || !exchangeRates.containsKey(targetCurrency)) {
            System.out.println("Invalid currency code.");
            return;
        }

        // Input amount to be converted
        System.out.print("Enter amount in " + baseCurrency + ": ");
        double amount = sc.nextDouble();

        // Fetch exchange rate (Mock data for demonstration)
        double exchangeRate = getExchangeRate(baseCurrency, targetCurrency, exchangeRates);

        // Convert amount
        double convertedAmount = amount * exchangeRate;

        // Display result
        System.out.println("Converted Amount: " + convertedAmount + " " + currencySymbols.get(targetCurrency));

        sc.close();
    }

    // Mock function to fetch exchange rates
    private static double getExchangeRate(String baseCurrency, String targetCurrency, Map<String, Double> exchangeRates) {
        double baseRate = exchangeRates.get(baseCurrency);
        double targetRate = exchangeRates.get(targetCurrency);
        return targetRate / baseRate;
    }
}