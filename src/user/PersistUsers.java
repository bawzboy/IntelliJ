package user;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class PersistUsers {
    private List<UserModel> users = new ArrayList<>();
    private static final String FILE_PATH = "users.json";
    private Gson gson = new Gson();

    public PersistUsers() {
        loadUsers();
    }

    public void saveUsers() {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(users, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadUsers() {
        java.io.File file = new java.io.File(FILE_PATH);
        this.users = new ArrayList<>();

        if (!file.exists() || file.length() == 0) {
            saveUsers();
            return;
        }
        try (Reader reader = new FileReader(file)) {
            List<UserModel> loadedUsers = gson.fromJson(reader, new TypeToken<List<UserModel>>() {}.getType());
            if (loadedUsers != null) {
                this.users = loadedUsers;
            }
        } catch (IOException | com.google.gson.JsonSyntaxException e) {
            System.err.println("Error loading users.json: " + e.getMessage());
            saveUsers();
        }
    }

    public List<UserModel> getUsers() {
        return users;
    }
}
