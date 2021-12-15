package utils;

import com.foxbox.hoodie.test.e2e.mail.api.EmailService;
import com.foxbox.hoodie.test.e2e.mail.model.Message;
import com.foxbox.hoodie.test.e2e.utils.StringUtils;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicReference;

import static com.codeborne.selenide.Selenide.Wait;

public class HoodieEmailService extends EmailService {

    public HoodieEmailService(String email) {
        super(email);
    }

    public String extractLinkFromMessageContaining(String text, Duration timeout) {
        AtomicReference<String> extractedText = new AtomicReference<>("");
        Wait().withTimeout(timeout).until(d -> {
            for (Message message : super.getAllMessages()) {
                extractedText.set(StringUtils.extractUrlFromText(message.getHtmlBody())
                        .stream()
                        .filter(url -> url.contains(text))
                        .findFirst()
                        .get());
            }
            return ! extractedText.get().isEmpty();
        });
        return extractedText.get();
    }
}
