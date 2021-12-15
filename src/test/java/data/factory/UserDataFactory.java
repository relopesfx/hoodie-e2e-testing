package data.factory;

import com.foxbox.hoodie.test.e2e.utils.DataFactory;
import data.model.User;
import lombok.extern.log4j.Log4j2;

import static data.enums.RoleType.ADMIN;
import static data.enums.RoleType.USER;

@Log4j2
public class UserDataFactory extends DataFactory<User> {

    private static final String EMAIL_DOMAIN = "1secmail.com";
    private static final String USER_PASSWORD = "Letmein1";

    @Override
    public User create() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        User user = User.builder()
                .email(generateEmail(USER.get().toLowerCase()))
                .password(USER_PASSWORD)
                .firstName(firstName)
                .lastName(lastName)
                .fullName(firstName + " " + lastName)
                .phoneNumber(faker.numerify("(###) ###-####"))
                .role(USER.get())
                .build();
        log.info(user);
        return user;
    }

    public User createAdmin() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        User user = User.builder()
                .email(generateEmail(ADMIN.get().toLowerCase()))
                .password(USER_PASSWORD)
                .firstName(firstName)
                .lastName(lastName)
                .fullName(firstName + " " + lastName)
                .phoneNumber(faker.numerify("(###) ###-####"))
                .role(ADMIN.get())
                .build();
        log.info(user);
        return user;
    }

    private String generateEmail(String role) {
        return String.format("%s%s@%s", role, faker.numerify("#####"), EMAIL_DOMAIN);
    }
}
