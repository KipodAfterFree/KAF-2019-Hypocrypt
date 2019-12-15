package hypocrypt;

public class SECrypto {
    private static long singleCrypt(long sum, long message, long key, long loop) {
        long a = key + loop + sum;
        long b = ((loop + 1));
        if (loop % 2 == 0) {
            return (message + a) * b;
        } else {
            return (message + a) * b;
        }
    }

    private static long singleDecrypt(long sum, long message, long key, long loop) {
        long a = key + loop + sum;
        long b = ((loop + 1));
        if (loop % 2 == 0) {
            return (message / b) - a;
        } else {
            return (message / b) - a;
        }
    }

    public static String decrypt(String message, String key) {
        // Convert String To An Array Of Ints.
        long[] messageCharacters = new long[message.length()];
        for (int character = 0; character < message.length(); character++) {
            messageCharacters[character] = (long) message.charAt(character);
        }

        // Convert Key To An Array Of Ints.
        long[] keyCharacters = new long[key.length()];
        long sumOfKey = 0;
        for (int character = 0; character < key.length(); character++) {
            keyCharacters[character] = (long) key.charAt(character);
            sumOfKey += keyCharacters[character];
        }
        // Create A New Array For The Decrypted Message
        long[] decryptedCharacters = new long[message.length()];
        // Decrypt Each Character
        for (int a = 0; a < decryptedCharacters.length; a++) {
            decryptedCharacters[a] = singleDecrypt(sumOfKey, messageCharacters[a], keyCharacters[a % key.length()], a);
        }

        // Convert Crypto To Message
        message = "";
        for (int b = 0; b < decryptedCharacters.length; b++) {
            message += (char) (decryptedCharacters[b] % (Math.pow(2, 16) - 1));
        }

        return message;
    }

    public static String encrypt(String message, String key) {
        // Convert String To An Array Of Ints.
        long[] messageCharacters = new long[message.length()];
        for (int character = 0; character < message.length(); character++) {
            messageCharacters[character] = (long) message.charAt(character);
        }

        // Convert Key To An Array Of Ints.
        long[] keyCharacters = new long[key.length()];
        long sumOfKey = 0;
        for (int character = 0; character < key.length(); character++) {
            keyCharacters[character] = (long) key.charAt(character);
            sumOfKey += keyCharacters[character];
        }

        // Create A New Array For The Encrypted Message
        long[] encryptedCharacters = new long[message.length()];
        // Encrypt Each Character
        for (int a = 0; a < encryptedCharacters.length; a++) {
            encryptedCharacters[a] = singleCrypt(sumOfKey, messageCharacters[a], keyCharacters[a % key.length()], a);
        }

        // Convert Crypto To Message
        message = "";
        for (int b = 0; b < encryptedCharacters.length; b++) {
            message += (char) (encryptedCharacters[b] % (Math.pow(2, 16) - 1));
        }
        return message;
    }
}