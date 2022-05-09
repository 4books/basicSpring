package hello.core.something;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Random;

public class TestSomething {

    @Test
    public void testBenfordsLaw() {
        LocalTime now = LocalTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hhmmss");
        int preTime = Integer.parseInt(now.format(dateTimeFormatter));
        System.out.println("preTime = " + preTime);

        int count = 0;
        for(;;){
            count++;

            now = LocalTime.now();
            int currTime = Integer.parseInt(now.format(dateTimeFormatter));
            if(currTime > preTime) {
                System.out.println("currTime = " + currTime);
                break;
            }
        }

        System.out.println("count = " + count);

    }
}
