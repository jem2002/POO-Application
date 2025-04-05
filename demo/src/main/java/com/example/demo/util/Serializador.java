package com.example.demo.util;

import javax.crypto.*;
import java.io.*;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Serializador {
    private static final String ALGORITHM = "AES";
    private final Key secretKey;
    private final String filePath;
    private final String keyPath;

    public Serializador(String filePath, String keyPath) {
        this.filePath = filePath;
        this.keyPath = keyPath;
        this.secretKey = cargarClave();
    }

    private Key cargarClave() {
        try {
            File keyFile = new File(keyPath);
            if (keyFile.exists()) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(keyPath))) {
                    return (Key) ois.readObject();
                }
            } else {
                return generarYGuardarClave();
            }
        } catch (IOException | ClassNotFoundException | NoSuchAlgorithmException e) {
            throw new RuntimeException("Error inicializando clave", e);
        }
    }

    private Key generarYGuardarClave() throws NoSuchAlgorithmException, IOException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        keyGenerator.init(256);
        Key key = keyGenerator.generateKey();
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(keyPath))) {
            oos.writeObject(key);
        }
        return key;
    }

    public void guardarDatos(List<?> datos) {
        try (FileOutputStream fos = new FileOutputStream(filePath);
            CipherOutputStream cos = new CipherOutputStream(fos, getCipher(Cipher.ENCRYPT_MODE));
            ObjectOutputStream oos = new ObjectOutputStream(cos)) {
            
            oos.writeObject(datos);
        } catch (Exception e) {
            throw new RuntimeException("Error guardando datos", e);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> cargarDatos() {
        try (FileInputStream fis = new FileInputStream(filePath);
            CipherInputStream cis = new CipherInputStream(fis, getCipher(Cipher.DECRYPT_MODE));
            ObjectInputStream ois = new ObjectInputStream(cis)) {
            
            return (List<T>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (Exception e) {
            throw new RuntimeException("Error cargando datos", e);
        }
    }

    private Cipher getCipher(int cipherMode) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(cipherMode, secretKey);
        return cipher;
    }
}