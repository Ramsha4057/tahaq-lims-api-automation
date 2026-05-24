package models.response;

public class LoginResponse {

    private String message;
    private Data data;

    public String getMessage() {
        return message;
    }

    public Data getData() {
        return data;
    }

    public static class Data {

        private String token;
        private String userId;
        private String email;
        private String name;

        public String getToken() {
            return token;
        }

        public String getUserId() {
            return userId;
        }

        public String getEmail() {
            return email;
        }

        public String getName() {
            return name;
        }
    }
}