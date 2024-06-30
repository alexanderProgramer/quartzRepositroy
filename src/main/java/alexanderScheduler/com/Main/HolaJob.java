package alexanderScheduler.com.Main;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

public class HolaJob implements Job {
    static int count =0;
    public void execute(JobExecutionContext jobExecutionContext)
            throws JobExecutionException {

        int numeroIntentos = 8;
        System.out.println("call to repeticions"+ count++);

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        int day = date.getDayOfMonth();
        int month = date.getMonthValue();
        int year= date.getYear();
        int minute = time.getMinute();
        int hour = time.getHour();
        int second= time.getSecond();
        System.out.println("Metodo a ejecutar hour:minute:seccond is: "+ hour +":"+ minute +":"+second );
        return;
        // Creacion de una instacia de Scheduler
      /*  try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            System.out.println("Iniciando Scheduler...");
            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();
            int day = date.getDayOfMonth();
            int month = date.getMonthValue();
            int year= date.getYear();
            int minute = time.getMinute();
            int hour = time.getHour();
            int second= time.getSecond();
            String typeTime= "HOURS";



                count++;
                // Creacion una instacia de JobDetail
                JobDetail jobDetail = JobBuilder.newJob(CallJobIntentos.class)
                        .withIdentity("CallJobIntentos",  "MyGroup"+ count)
                        .build();

                Trigger trigger2 = TriggerBuilder.newTrigger()
                        .withIdentity("myTrigger", "MyGroup"+ count)
                        .withSchedule(simpleSchedule()
                                .withIntervalInSeconds(2)
                                .withRepeatCount(20))
                        .startAt(DateBuilder.dateOf(hour, minute, second+2, day, month, year))
                        //.startNow()
                        .build();

                scheduler.scheduleJob(jobDetail, trigger2);
                scheduler.start();

                    //.startAt(DateBuilder.dateOf(21, 1, 0, 29, 6, 2024))

        } catch (SchedulerException e) {
            System.out.println("Ocurrió una excepción : " +e.getMessage());
            throw new RuntimeException(e);
        }


*/

    }

}
