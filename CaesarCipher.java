import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Caesar Cipher Program!");

       
        System.out.println("\nChoose an option:");
        System.out.println("1. Encrypt a message");
        System.out.println("2. Decrypt a message");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        scanner.nextLine(); 

       
        System.out.print("\nEnter your message: ");
        String message = scanner.nextLine();
        System.out.print("Enter the shift key (1-25): ");
        int shift = scanner.nextInt();

        
        if (choice == 1) {
            String encryptedMessage = encrypt(message, shift);
            System.out.println("\nEncrypted Message: " + encryptedMessage);
        } else if (choice == 2) {
            String decryptedMessage = decrypt(message, shift);
            System.out.println("\nDecrypted Message: " + decryptedMessage);
        } else {
            System.out.println("Invalid choice. Please restart the program.");
        }

        scanner.close();
    }

    
    public static String encrypt(String message, int shift) {
        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);

            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                ch = (char) ((ch - base + shift) % 26 + base);
            }

            encrypted.append(ch);
        }

        return encrypted.toString();
    }

  
    public static String decrypt(String message, int shift) {
        return encrypt(message, 26 - shift); // Reverse the shift for decryption
    }
}
