package alexanderScheduler.com.Main;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDate;
import java.time.LocalTime;

public class CallJobIntentos implements Job {


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        int day = date.getDayOfMonth();
        int month = date.getMonthValue();
        int year= date.getYear();
        int minute = time.getMinute();
        int hour = time.getHour();
        int second= time.getSecond();
        System.out.println("metodo de intentos- metodo a ejecutar hour:minute:seccond is: "+ hour +":"+ minute +":"+second );
    }
}
