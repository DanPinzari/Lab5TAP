import java.util.*;

class StivaGoalaException extends Exception {
    public StivaGoalaException(String message) {
        super(message);
    }
}

public class Main {
    public static void inverseazaStive(Stack<String> stiva1, Stack<String> stiva2) throws StivaGoalaException {
        if (stiva1.isEmpty() || stiva2.isEmpty()) {
            throw new StivaGoalaException("Una dintre stive este goală.");
        }

        Stack<String> temp1 = new Stack<>();
        Stack<String> temp2 = new Stack<>();

        while (!stiva1.isEmpty()) {
            temp1.push(stiva1.pop());
        }

        while (!stiva2.isEmpty()) {
            temp2.push(stiva2.pop());
        }

        while (!temp1.isEmpty()) {
            stiva2.push(temp1.pop());
        }

        while (!temp2.isEmpty()) {
            stiva1.push(temp2.pop());
        }
    }

    public static void main(String[] args) {
        Stack<String> stiva1 = new Stack<>();
        Stack<String> stiva2 = new Stack<>();

//        // Populăm stivele cu câteva valori
        stiva1.push("1");
        stiva1.push("2");
        stiva2.push("4");
        stiva2.push("5");

        try {
            // Încercăm să inversăm conținutul stivelor
            inverseazaStive(stiva1, stiva2);

            // Încercăm să adăugăm manual un caracter care nu este un număr întreg în stiva1
            String element = "6";
            if (element.matches("-?\\d+")) {
                stiva1.push(element);
            } else {
                throw new NumberFormatException("Caracterul introdus nu este un număr întreg.");
            }

            // Aruncăm o excepție neverificată (ArithmeticException) prin împărțirea unui număr la zero
            int rezultat = 10 / 0;

            // Afisăm stivele invertite
            System.out.println("Stiva1: ");
            while (!stiva1.isEmpty()) {
                System.out.print(stiva1.pop() + " ");
            }

            System.out.println("\nStiva2: ");
            while (!stiva2.isEmpty()) {
                System.out.print(stiva2.pop() + " ");
            }

        } catch (StivaGoalaException e) {
            System.out.println("Nu s-a putut inversa stivele: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Nu s-a putut adauga elementul în stivă. Caracterul introdus nu este un număr întreg.");
        } catch (ArithmeticException e) {
            System.out.println("A apărut o excepție neverificată: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("A apărut o excepție neașteptată: " + e.getMessage());
        } finally {
            // Afișăm stările finale ale stivelor
            System.out.println("\nStarea finală a stivei 1: " + stiva1);
            System.out.println("Starea finală a stivei 2: " + stiva2);
        }
    }
}
