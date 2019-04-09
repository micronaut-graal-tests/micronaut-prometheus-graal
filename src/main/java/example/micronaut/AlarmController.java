package example.micronaut;

import io.micrometer.core.annotation.Timed;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;

import javax.inject.Singleton;

@Singleton
@Controller("/")
public class AlarmController {

    @Timed(value = "method.alarms.save", percentiles = {0.5, 0.95}, histogram = true, description = "Save alarm timer")
    @Get("/alarm")
    public Single<Alarm> saveAlarm() {
        return Single.just(new Alarm(1, "Alarm 1", "High"));
    }
}
