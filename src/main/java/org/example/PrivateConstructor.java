package org.example;

public class PrivateConstructor {
    private String id = "123";
    private String name = "A";

    private PrivateConstructor() {
    }

    @Override
    public String toString() {
        return "PrivateConstructor{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public static class Builder {
        private PrivateConstructor instance;

        public Builder() {
            instance = new PrivateConstructor();
        }

        public Builder setId(String id) {
            instance.id = id;
            return this;
        }

        public Builder setName(String name) {
            instance.name = name;
            return this;
        }

        public PrivateConstructor build() {
            return instance;
        }
    }

    public static void main(String[] args) {
        PrivateConstructor privateConstructor = new PrivateConstructor.Builder()
                .setId("456")
                .setName("B")
                .build();
        System.out.println(privateConstructor);
    }
}
