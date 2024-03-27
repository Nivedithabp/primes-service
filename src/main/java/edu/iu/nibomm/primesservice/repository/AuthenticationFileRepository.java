package edu.iu.nibomm.primesservice.repository;

import edu.iu.nibomm.primesservice.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

@Repository
public class AuthenticationFileRepository implements IAuthenticationRepository{

    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationFileRepository.class);

    private static final String DATABASE_NAME = "data/customers.txt";
    private static final String NEW_LINE = System.lineSeparator();

    public AuthenticationFileRepository() {
        try {
            Path directoryPath = Paths.get(DATABASE_NAME).getParent();
            if (directoryPath != null) {
                Files.createDirectories(directoryPath);
            }

            Path filePath = Paths.get(DATABASE_NAME);
            if (Files.notExists(filePath)) {
                Files.createFile(filePath);
            }
        } catch (IOException e) {
            LOG.error("Failed to create directory or file", e);
            throw new RuntimeException("Failed to initialize repository", e);
        }
    }


    @Override
    public Customer findbyUsername(String username) throws IOException {
        Path path = Paths.get(DATABASE_NAME);
        List<String> data = Files.readAllLines(path);
        for (String line :data){
            if(!line.trim().isEmpty()){
                String[] properties = line.split(",");
                if(properties[0].trim().equalsIgnoreCase(username.trim())){
                    return new Customer(properties[0].trim(),properties[1].trim());
                }
            }
        }
        return null;
    }
    @Override
    public boolean save(Customer customer) throws IOException {
        Customer x = findbyUsername(customer.getUsername());
        if(x == null){
            Path path = Paths.get(DATABASE_NAME);
            String data = String.format("%1$s,%2$s",
                    customer.getUsername().trim(),
                    customer.getPassword().trim());
            data += NEW_LINE;
            Files.write(path,
                    data.getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
            return true;
        }


        return false;
    }

}
