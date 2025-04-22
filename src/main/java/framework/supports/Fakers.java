package framework.supports;

import com.github.javafaker.Faker;

import java.util.Locale;

public class Fakers {

    private Faker faker = new Faker(new Locale("pt-BR"));
    private String nome, sobrenome, email, postalCode, subject, messagem;

    public String getNome() {
        return nome = faker.name().firstName();
    }

    public String getSobrenome() {
        return sobrenome = faker.name().lastName();
    }

    public String getEmail() { return  email = faker.internet().emailAddress(); }

    public String getPostalCode() {
        return postalCode = faker.address().zipCode();
    }

    public String getSubject() { return subject = faker.book().title(); }

    public String getMessage() { return messagem = faker.lorem().paragraph(); }

}