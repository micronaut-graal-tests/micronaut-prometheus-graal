package example.micronaut;

import io.micronaut.configuration.metrics.micrometer.annotation.MircometerTimed;
import io.micrometer.core.annotation.Timed;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;

import javax.inject.Singleton;

@Singleton
@Controller("/")
public class AlarmController {

    @MircometerTimed
    @Timed(value = "method.alarms.save-single", percentiles = {0.5, 0.95}, histogram = true, description = "Save alarm timer (Single)")
    @Get("/alarm-single")
    public Single<Alarm> saveAlarmReactive() {
        return Single.just(new Alarm(1, "Alarm 1", "High"));
    }

    @MircometerTimed
    @Timed(value = "method.alarms.save", percentiles = {0.5, 0.95}, histogram = true, description = "Save alarm timer")
    @Get("/alarm")
    public Alarm saveAlarm() {
        return new Alarm(2, "Alarm 2", "Medium");
    }
}
